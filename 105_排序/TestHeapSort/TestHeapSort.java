import java.util.Arrays;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestHeapSort
{
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("請輸入檔案名稱: ");
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
					// 日期｜股票代號｜股票名稱｜券商代號｜券商名稱｜成交價｜買進張數｜賣出張數
					int day = CStockData.isDay(tempArr[0]);
					int numSto = CStockData.isNumStock(tempArr[1]);
					double price = CStockData.isPrice(tempArr[5]);
					int ticketBuy = CStockData.isTicketBuy(tempArr[6]);
					int ticketSell = CStockData.isTicketSell(tempArr[7]);
					// 資料正確才可輸入
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
				System.out.print("1) Heap Sort: ");
				int opt = scanner.nextInt();
				if(opt == 1)			// heap sort
				{	
					heapSort(stockArr, count - 1, 5);	// 5: price
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
	// heap sort: 先Max heap, 再sort
	public static void heapSort(CStockData[] arr, int n, int index)
	{
		// i = 0為標題
		// 末項之父節點至根節點
		for(int i = n / 2 ; i >= 1 ; i--)
			adjust(arr, i, n, index);
		for(int i = n ; i > 1 ; i--)
		{
			swap(arr, 1, i);				// 首項移至末項
			adjust(arr, 1, i, index);	// 逐一比較，找出最大值	
		}
	}
	// 由上而下，逐一比較
	public static void adjust(CStockData[] arr, int root, int n, int index)
	{
		CStockData temp = arr[root];
		int child = 2 * root;
		while(child < n)		// 尚有子節點
		{
			// 右側有節點且右側節點較大
			if((child < n -1) && arr[child].getKey(index) < arr[child + 1].getKey(index))
				child++;
			// root較大則不換
			if(temp.getKey(index) > arr[child].getKey(index))
				break;
			else
			{
				arr[child / 2] = arr[child];
				child = 2 * child;
			}
		}
		arr[child / 2] = temp;		// 將root存入子節點的父節點，不一定為最後之節點
	}
}
