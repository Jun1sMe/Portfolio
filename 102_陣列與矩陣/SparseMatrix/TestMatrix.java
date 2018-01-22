import java.util.Arrays;
import java.util.Scanner;
//import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class TestMatrix
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		SparseMatrix[] mArray;
		System.out.print("請輸入檔案名稱: ");
		String inputName = scanner.next();

		// load and buffer the file in try
		try (FileReader fileReader = new FileReader(inputName);
				BufferedReader bufReader = new BufferedReader(fileReader);)
		{
			// space and '0' ->"\\s+|0"
			// first line: array line
			String arrNum, temp;
			arrNum = bufReader.readLine();
			int count = -1;
			// current matrix number
			int curArrNum = Integer.parseInt(arrNum);
			String[] arrSize = new String[2];
			String[] mediate;
			mArray = new SparseMatrix[curArrNum];		
			// load data
			while (++count < curArrNum)
			{
				// row, col
				arrSize = bufReader.readLine().split(" ");
				mArray[count] = new SparseMatrix(Integer.parseInt(arrSize[0]), Integer.parseInt(arrSize[1]));
				// row major
				for (int i = 0; i < mArray[count].getTerm(0).row; i++)
				{
					temp = bufReader.readLine();
					// print the first array
					if (count == 0)
						System.out.println(temp);
					mediate = temp.split(" ");
					for (int j = 0; j < mediate.length; j++)
					{
						// storage terms not '0'
						int value = Integer.parseInt(mediate[j]);
						if (value != 0)
							mArray[count].setTerm(i, j, value);
					}
				}
				// catch new line for the next catch
				if (count == 0)
				{
					bufReader.readLine();
					System.out.println();
				}
			} // end while: load data into array, count = 2
			bufReader.close();
			fileReader.close();

			// demand function
			while(true)
			{
				System.out.println("1) Clone, 2) Transpose, 3) Add, 4) Mult, 5) Save, 6) Exit");
				int opt = scanner.nextInt();
				if (count >= mArray.length)
					mArray = Arrays.copyOf(mArray, mArray.length * 2);
				// 1) Clone
				if (opt == 1)
				{
					System.out.print("Index: ");
					int optIndex = scanner.nextInt();					
					if (optIndex >= 0 && optIndex < count)
					{
						mArray[count] = new SparseMatrix(mArray[optIndex]);
						printResult(mArray[count], mArray[count].getTerm(0).row, mArray[count].getTerm(0).col, mArray[count].getTerm(0).value);
						printSuccess(count++);
					} 
					else
						printError();
				}
				// 2) Transpose
				else if (opt == 2)
				{
					System.out.print("Index: ");
					int optIndex = scanner.nextInt();
					if (optIndex >= 0 && optIndex < count)
					{
						// first: clone
						mArray[count] = new SparseMatrix(mArray[optIndex]);
						// second: transpose
						mArray[count].fastTranspose();					
						printResult(mArray[count], mArray[count].getTerm(0).row, mArray[count].getTerm(0).col, mArray[count].getTerm(0).value);
						printSuccess(count++);
					} 
					else
						printError();
				}
				// 3) Add
				else if (opt == 3)
				{
					System.out.print("Index: ");
					int optIndex1 = scanner.nextInt();				
					int optIndex2 = scanner.nextInt();					
					if (optIndex1 >= 0 && optIndex1 < count && optIndex2 >= 0 && optIndex2 < count)
					{
						// first: clone 2 item
						SparseMatrix tempMx1 = new SparseMatrix(mArray[optIndex1]);
						SparseMatrix tempMx2 = new SparseMatrix(mArray[optIndex2]);
						// second: add
						if((tempMx1 = SparseMatrix.add(tempMx1, tempMx2)) != null)
						{
							mArray[count] = tempMx1;						
							printResult(mArray[count], mArray[count].getTerm(0).row, mArray[count].getTerm(0).col, mArray[count].getTerm(0).value);
							printSuccess(count++);
							continue;
						}
					} 
					printError();
				}
				// 4) Mult
				else if (opt == 4)
				{
					System.out.print("Index: ");
					int optIndex1 = scanner.nextInt();				
					int optIndex2 = scanner.nextInt();
					if (optIndex1 >= 0 && optIndex1 < count && optIndex2 >= 0 && optIndex2 < count)
					{
						// first: clone 2 item
						SparseMatrix tempMx1 = new SparseMatrix(mArray[optIndex1]);
						SparseMatrix tempMx2 = new SparseMatrix(mArray[optIndex2]);
						// second: mult
						if((tempMx1 = SparseMatrix.mult(tempMx1, tempMx2)) != null)
						{
							mArray[count] = tempMx1;						
							printResult(mArray[count], mArray[count].getTerm(0).row, mArray[count].getTerm(0).col, mArray[count].getTerm(0).value);
							printSuccess(count++);
							continue;
						}
					} 
					printError();
				}
				// 5) Save
				else if (opt == 5)
				{
					System.out.print("請輸入檔名(輸入o寫回原檔案): ");
					String outputName = scanner.next();
					FileWriter fileWriter = new FileWriter(outputName);
					BufferedWriter bufWriter = new BufferedWriter(fileWriter);
					
					// first line(int to string)
					bufWriter.write(count + "");
					bufWriter.newLine();
					// size & array
					for(int h = 0 ; h < count ; h++)
					{
						// put into all
						String all = "";
						all += mArray[h].getTerm(0).row + " " + mArray[h].getTerm(0).col + "\n";
						for(int i = 1, k = 1 ; i <= mArray[h].getTerm(0).row ; i++)
						{
							for(int j = 1 ; j <= mArray[h].getTerm(0).col ; j++)
							{
								if(mArray[h].getTerm(k).row == i - 1)
								{
									if(mArray[h].getTerm(k).col == j - 1)
									{
										all += mArray[h].getTerm(k).value + " ";
										if(k < mArray[h].getTerm(0).value)
											k++;
										continue;
									}							
								}
								all += "0 ";	
							}
							all += "\n";
						}
						// write in and new line
						bufWriter.write(all);
						bufWriter.newLine();					
					}
					// immediate write over
					bufWriter.flush();
					bufWriter.close();
					fileWriter.close();
					System.out.println("已將所有矩陣成功寫入 " + outputName + " 中");				
				}
				// 6) Exit
				else if (opt == 6)
				{
					System.out.println("Thank you for using!");
					break;
				}
				// exception
				else
					printError();
			}
	

		} catch (FileNotFoundException e)
		{
			System.out.println(inputName + " not found!");
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
		}

	}

	// print error
	public static void printError()
	{
		System.out.println("Error! Try again.");
	}
	// print result
	public static void printResult(SparseMatrix arr, int row, int col, int count)
	{
		for(int i = 1, k = 1 ; i <= row ; i++)
		{
			for(int j = 1 ; j <= col ; j++)
			{
				if(arr.getTerm(k).row == i - 1)
				{
					if(arr.getTerm(k).col == j - 1)
					{
						System.out.print(arr.getTerm(k).value + "\t");
						if(k < count)
							k++;
						continue;
					}							
				}
				System.out.print("0\t");		
			}
			System.out.println();
		}
	}
	public static void printSuccess(int count)
	{
		System.out.println("矩陣已存入陣列尾端 位置為 " + count);
	}

}
