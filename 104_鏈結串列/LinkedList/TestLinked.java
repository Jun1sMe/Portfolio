import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TestLinked
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		LinkedList myList = new LinkedList();
		int flow = 0;
 		while(true)
		{
 			if(flow == 0)
 			{
 				System.out.print("Insert new data (SN/ENGLISH/MATH): ");
 				int stuNum = scanner.nextInt();
 				int stuEng = scanner.nextInt();
 				int stuMath = scanner.nextInt();
 				if(stuNum == -1 && stuEng == -1 && stuMath == -1)
 				{
 					flow++;
 					continue;
 				}
 				// ­«½Æ
 				else if(myList.getNode(stuNum) != null)
 				{
 					System.out.println("Error! Student number exists.");
 					continue;
 				}
 				// ¶W¥X½d³ò
 				else if((stuNum <= 0 || stuNum >= 100) || (stuEng < 0 || stuEng > 100) || (stuMath < 0 || stuMath > 100))
 				{
 					printError();
 					continue;
 				}
				myList.insertInOrdered(stuNum, stuEng, stuMath);
 			}
 			else if(flow == 1)
 			{
 				System.out.print("\nOption: 1) Add. 2) Output. 3) Delete. -1) Quit & Save: ");
 				int opt = scanner.nextInt();
 				if(opt == 1)
 					flow--;
 				else if(opt == -1)
 				{
 					System.out.print("Storage File Name: ");
 					String fileName = scanner.next();
 					FileWriter fileWrite;
					try
					{
						fileWrite = new FileWriter(fileName);
						BufferedWriter bufWrite = new BufferedWriter(fileWrite);
						bufWrite.write("SN\tENG.\tMATH.\tAVG.\n-------------------------------");
						bufWrite.newLine();
						bufWrite.write(myList.getNode(false));
						System.out.println("Accomplishment.\nBye!");
						// flush in and close
						bufWrite.flush();
						bufWrite.close();
						fileWrite.close();
	 					break;
					} catch (IOException e)
					{
						
					}				
 				}
 				else if(opt == 2)
 				{
 					System.out.println("\nSN\tENG.\tMATH.\tAVG.\n-------------------------------");
 					myList.getNode(true);
 				}
 				else if(opt == 3)
 				{
 					System.out.print("Please enter student number: ");
 					int inputSn = scanner.nextInt();
 					if(myList.delete(inputSn))
 						System.out.println("Success!");
 					else
 						System.out.println("Student Number not exists!");
 				}
 				else
 					printError();
 					
 			}

			
			
		}
		
		

	}
	// print error
	public static void printError()
	{
		System.out.println("Error! Try again.");
	}

}
