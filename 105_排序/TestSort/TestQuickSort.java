import java.util.Arrays;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestQuickSort
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("�п�J�ɮצW��: ");
		String loadInFile = scanner.next();
		String loadOutFile = "sample";		// initial 
		// try: load and buffer the file
		try(FileReader fileReader = new FileReader(loadInFile);
				BufferedReader bufReader = new BufferedReader(fileReader);
						FileWriter fileWriter = new FileWriter(loadOutFile);
						BufferedWriter bufWriter = new BufferedWriter(fileWriter);)
		{
			String temp;
			int count = 0;
			CStockData[] stockArr = new CStockData[100]; 
			while((temp = bufReader.readLine()) != null)
			{
				if(count >= stockArr.length)
					stockArr = Arrays.copyOf(stockArr, stockArr.length * 2);
				// space and ',' ->"\\s+|,"
				String[] tempArr = temp.split("\\s+|,");	
				// into array
				if(count == 0)	// first title
					stockArr[count++] = new CStockData(tempArr);
				else
				{
					// ����U�Ѳ��N���U�Ѳ��W�١U��ӥN���U��ӦW�١U������U�R�i�i�ơU��X�i��
					int day = CStockData.isDay(tempArr[0]);
					int numSto = CStockData.isNumStock(tempArr[1]);
					double price = CStockData.isPrice(tempArr[5]);
					int ticketBuy = CStockData.isTicketBuy(tempArr[6]);
					int ticketSell = CStockData.isTicketSell(tempArr[7]);
					// ��ƥ��T�~�i��J
					if(day != -1 && numSto != -1 && price != -1 && ticketBuy != -1 && ticketSell != -1)
					{
						stockArr[count++] = new CStockData(day, numSto, tempArr[2], tempArr[3], tempArr[4],
								price, ticketBuy, ticketSell);						
					}
					else
					{
						printError();
						continue;
					}
				}
			}
			// close file
			bufReader.close();
			fileReader.close();
			
			// picking algorithm			
			while(true)
			{
				System.out.print("1) Quick Sort, 2) Merged Sort(for), 3) Merged Sort(recursive): ");
				int opt = scanner.nextInt();
				if(opt == 1)			// quick sort
				{	
					quickSort(stockArr, 1, count - 1, 5);	// 5: price
					break;
				}
				else if(opt == 2)	// merged sort(for)
				{
					mergedSort(stockArr, count - 1, 5);		// n���p�J�������A��count - 1, 5: price
					break;	
				}
				else if(opt == 3)	// merged sort(recursive)
				{
					CStockData[] aft = new CStockData[stockArr.length];	// �Ȧs
					recursMergedSort(stockArr, aft, 1, count - 1, 5);	// 5: price
					break;	
				}
				else
					printError();				
			}			
			// output
			for (int i = 0; i < count; i++)
			{
				// output lines an new it
				bufWriter.write(stockArr[i].getFull());
				bufWriter.newLine();
			}
			// cache into file immediately and close file
			bufWriter.flush();
			bufWriter.close();
			fileWriter.close();
			System.out.println("Success!");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found!");
		}
		catch(IOException e){}

	}
	// print error
	public static void printError()
	{
		System.out.println("Error! Try again.");
	}
	// swap over
	public static void swap(CStockData[] arr, int i, int j)
	{
		CStockData temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	// quick sort: �Ѥp��j�A�ɧǱƦC
	public static void quickSort(CStockData[] arr, int left, int right, int index)
	{
		int i, j;		// sentinel
		double pivot;
		if(left < right)
		{
			i = left;
			j = right + 1;	// keep the right value(don't miss)
			pivot = arr[left].getKey(index);
			do
			{
				do
					i++;
				while(i < j && arr[i].getKey(index) < pivot);	// i�n���j��Ь�A�ó]�w��ɱ���(���p����)
				do
					j--;
				while(arr[j].getKey(index) > pivot);		// j�n���p��Ь�
				if(i < j)
					swap(arr, i, j);
			}while(i < j);
			swap(arr, left, j);
			quickSort(arr, left, j - 1, index);
			quickSort(arr, j + 1, right, index);
		}
	}
	// merge sort : �v�@�ۥ[�Ѥ@��h
	public static void recursMergedSort(CStockData[] arr, CStockData[] aft, int start, int end, int index)
	{
		if(start >= end)		// base case: at least 2 number
			return;
		int mid = (start + end) / 2;
		recursMergedSort(arr, aft, start, mid, index);
		recursMergedSort(arr, aft, mid + 1, end, index);
		merge(arr, aft, start, mid, end, index);
		for(int i = start ; i <= end ; i++)
			arr[i] = aft[i];
	}
	// merge sort : �v�@�ۥ[�Ѥ@��h
	public static void mergedSort(CStockData[] arr, int n, int index)
	{
		int s = 1;	// ��1�}�l
		CStockData[] temp = new CStockData[arr.length];
		while(s < n)		// �v���ۥ[
		{
			mergePass(arr, temp, n, s, index);
			s *= 2;
			mergePass(temp, arr, n, s, index);
			s *= 2;
		}
	}
	// merge pass : �v�@�ۥ[�Ѥ@��h
	public static void mergePass(CStockData[] initiList, CStockData[] mergedList, int n, int s, int index)
	{
		int i;	// ���L����
		for(i = 1; i < n - 2 * s + 1; i+= 2 * s)	// �U�ǦC�ۥ[�A�[�ܤG�������
			merge(initiList, mergedList, i, i + s - 1, i + 2 * s - 1, index);
		if(i + s < n)	// �l���[�J�Ƨ�
			merge(initiList, mergedList, i, i + s - 1, n, index);
		else		// �N�w�ƧǦC��J�̫�
			while(i < n)	
				mergedList[i] = initiList[i++];
	}
	// merge : �Ѥp��j�A�ɧǱƦC
	public static void merge(CStockData[] initiList, CStockData[] mergedList, int i, int m, int n, int index)
	{
		int j = m + 1;	// �ĤG�l�ǦC���_�l��m
		int k = i;	// mergedList���_�l��m
		while(i <= m && j <= n)	// �ƧǸ��p��
		{
			if(initiList[i].getKey(index) <= initiList[j].getKey(index))
				mergedList[k++] = initiList[i++];
			else
				mergedList[k++] = initiList[j++];
		}
		// ���ަ�m�b�Ĥ@�l�ǦC
		while(i <= m)
			mergedList[k++] = initiList[i++];
		// ���ަ�m�b�ĤG�l�ǦC
		while(j <= n)
			mergedList[k++] = initiList[j++];
	}	
}
