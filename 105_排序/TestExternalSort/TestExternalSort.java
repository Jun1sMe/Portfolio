import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TestExternalSort
{

	public static int streamSize = 1000;		// offer for 'TA' setting buffer size
	public static final int suitSize = 15; 	// the best size for insertion
	public static int fileCount = 0;			// output file number
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		StopWatch watch = new StopWatch();
		System.out.print("Input a file: ");;
		String loadInFile = scanner.next();
		// try: load and buffer the file
		try
		{
			FileReader fileReader = new FileReader(loadInFile);
			BufferedReader bufReader = new BufferedReader(fileReader);
			String loadOutFile = "temp", resultFile = "result", fileType = ".csv";	// initial 
			String titleLine = bufReader.readLine(),		// load title line
					temp = "";							// other line
			// start watch
			watch.start();
			do
			{
				int count = 0;
				CRoutine[] busRoutine = new CRoutine[streamSize];
				// divide stream file to several segment and base on '15'
				// while number is less than '15', insertion sort is the best way
				while((temp = bufReader.readLine()) != null && count < streamSize)
				{					
					// record data
					String[] tempDep = temp.split("\\s+|,");		
					int dep = Integer.parseInt(tempDep[7]);				// departure: index 7				
					int i = (count / suitSize) * suitSize;				// start '0'
					while(i < count && dep > busRoutine[i].getDep())		// not greater than exists
						i++;
					for(int j = count ; j > i ; j--)						// move toward
						busRoutine[j] = busRoutine[j - 1];

					busRoutine[i] = new CRoutine(temp, dep);
					count++;				
				}	// end while: sorted subsequence, length is not greater than '15'
				/* merge sort, n is length */
				mergedSort(busRoutine, count);				
				// output
				FileWriter fileWriter = new FileWriter(loadOutFile + fileCount++ + fileType);
				BufferedWriter bufWriter = new BufferedWriter(fileWriter);
				for (int i = 0; i < count; i++)
				{
					// output lines an new line
					bufWriter.write(busRoutine[i].toString());
					bufWriter.newLine();
				}
				// cache into file immediately and close file
				bufWriter.flush();
				bufWriter.close();
				fileWriter.close();
			}while(temp != null);	// end while: no data
			// close file
			bufReader.close();
			fileReader.close();
			
			/* start the next step */
			// initialize
			CRoutine[] busRoutine = new CRoutine[fileCount];
			FileReader[] frArr = new FileReader[fileCount];				
			BufferedReader[] brArr = new BufferedReader[fileCount];
			FileWriter fileWriter1 = new FileWriter(resultFile + fileType);
			BufferedWriter bufWriter1 = new BufferedWriter(fileWriter1);
			int count = 0;
			// output the title
			bufWriter1.write(titleLine);
			bufWriter1.newLine();
			// files' first loading
			for(int l = 0 ; l < fileCount; l++)
			{
				frArr[l] = new FileReader(loadOutFile + l + fileType);
				brArr[l] = new BufferedReader(frArr[l]);
				temp = brArr[l].readLine();
				String[] tempDep = temp.split("\\s+|,");		
				int dep = Integer.parseInt(tempDep[7]);				// departure: index 7
				busRoutine[l] = new CRoutine(temp, dep, l);
			}
			// min heap
			for(int i = ((fileCount - 1) - 1) / 2 ; i >= 0 ; i--)
				verseAdjust(busRoutine, i, fileCount);
			do
			{
				// output the first line a new line
				bufWriter1.write(busRoutine[0].toString());
				bufWriter1.newLine();
				// catch the file, where take it
				int tempNo = busRoutine[0].getFile();
				if((temp = brArr[tempNo].readLine()) != null)
				{
					String[] tempDep = temp.split("\\s+|,");		
					int dep = Integer.parseInt(tempDep[7]);			// departure: index 7
					busRoutine[0] = new CRoutine(temp, dep, tempNo);
					// min heap
					verseAdjust(busRoutine, 0, fileCount);
				}
				// the file is no data
				else
				{
					// file still exists
					if(fileCount - 1 >= 0) 
					{
						// swap this for last 
						swap(busRoutine, 0, fileCount - 1);
						fileCount--;
						// min heap
						verseAdjust(busRoutine, 0, fileCount);
					}
				}
				// cache into file
				if(++count >= streamSize)
					bufWriter1.flush();
			}while(fileCount > 0);
			bufWriter1.flush();	// cache into the rest
			// end watch and show pass
			watch.end();
			System.out.println("It costs: " + watch.passTime() + " ms");
			// close file
			for(int l = 0 ; l < fileCount ; l++)
			{
				frArr[l].close();
				brArr[l].close();
			}
			bufWriter1.close();
			fileWriter1.close();	
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found!");
		}
		catch(IOException e){}

	}

	/* merge sort*/
	// merge sort : from first to last by step
	public static void mergedSort(CRoutine[] arr, int n)
	{
		int s = suitSize;	// start 'suitSize'
		CRoutine[] temp = new CRoutine[arr.length];
		while(s < n)		// until length
		{
			mergePass(arr, temp, n, s);
			s *= 2;
			mergePass(temp, arr, n, s);
			s *= 2;
		}
	}
	// merge pass : two in one
	public static void mergePass(CRoutine[] initiList, CRoutine[] mergedList, int n, int s)
	{
		int i;
		for(i = 0; i < n - 2 * s + 1; i+= 2 * s)	// link with sequence, if it exists over two number
			merge(initiList, mergedList, i, i + s - 1, i + 2 * s - 1);
		if(i + s < n)	// insert the rest
			merge(initiList, mergedList, i, i + s - 1, n - 1);
		else		// add sorted
			while(i < n)	
				mergedList[i] = initiList[i++];
	}
	// merge : ascending
	public static void merge(CRoutine[] initiList, CRoutine[] mergedList, int i, int m, int n)
	{
		int j = m + 1;	// subsequence's start
		int k = i;	// mergedList's start
		while(i <= m && j <= n)	// sorted smaller
		{
			if(initiList[i].getDep() <= initiList[j].getDep())
				mergedList[k++] = initiList[i++];
			else
				mergedList[k++] = initiList[j++];
		}
		// index in sequence
		while(i <= m)
			mergedList[k++] = initiList[i++];
		// index in subsequence
		while(j <= n)
			mergedList[k++] = initiList[j++];
	}
	/* heap sort*/
	// swap data
	public static void swap(CRoutine[] arr, int i, int j)
	{
		CRoutine temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	// heap sort: after max heap , sort it
	public static void heapSort(CRoutine[] arr, int n)
	{
		// the last node of parent node move to the root
		for(int i = ((n - 1) - 1) / 2 ; i >= 0 ; i--)
			adjust(arr, i, n);
		for(int i = n - 1 ; i > 0 ; i--)
		{
			swap(arr, 0, i);		// swap the first to the last
			adjust(arr, 0, i);	// find max heap	
		}
	}
	// from root to the end
	public static void adjust(CRoutine[] arr, int root, int n)
	{
		CRoutine temp = arr[root];
		int child = 2 * root + 1;	// left child
		while(child < n)				// there's still node
		{
			// right side exists and bigger
			if((child < n -1) && arr[child].getDep() < arr[child + 1].getDep())
				child++;
			// root is bigger and keep
			if(temp.getDep() > arr[child].getDep())
				break;
			else
			{
				arr[(child - 1) / 2] = arr[child];
				child = 2 * child + 1;
			}
		}
		arr[(child - 1) / 2] = temp;		// root put into the child node of parent node, but it's not always the last
	}
	// from root to the end, the min
	public static void verseAdjust(CRoutine[] arr, int root, int n)
	{
		CRoutine temp = arr[root];
		int child = 2 * root + 1;	// left child
		while(child < n)				// there's still node
		{
			// right side exists and smaller
			if((child < n -1) && arr[child].getDep() > arr[child + 1].getDep())
				child++;
			// root is smaller and keep
			if(temp.getDep() < arr[child].getDep())
				break;
			else
			{
				arr[(child - 1) / 2] = arr[child];
				child = 2 * child + 1;
			}
		}
		arr[(child - 1) / 2] = temp;		// root put into the child node of parent node, but it's not always the last
	}

}
