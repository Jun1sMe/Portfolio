import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class TestDictionary
{

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner scan = new Scanner(System.in);
		HashTable testHT = new HashTable(10, 5);	//10 buckets¡A5 slots per bucket
		while(true)
		{
			System.out.print("1) Insert. 2) Search. -1) Quit: ");
			int opt = scan.nextInt();
			if(opt == 1)			// insert
			{
				System.out.print("File Name: ");
				String fn = scan.next();	
				try
				{
					FileReader fr = new FileReader(fn);
					BufferedReader br = new BufferedReader(fr);
					String temp;
					while((temp = br.readLine()) != null)
					{
						testHT.insert(temp);
					}
					System.out.println("The process is completed!\n");
					// close file
					fr.close();
					br.close();
				} 
				catch (IOException e)
				{
					System.out.println("File not found!");
				}
			}
			else if(opt == 2)	// search
			{
				System.out.print("Query: ");
				String input = scan.next();
				String temp = testHT.search(input); 
				if(temp != null)
				{
					String[] tempArr = temp.split(" ");
					System.out.println("¡¥" + input + "¡¦ is found at slot " + tempArr[1] 
							+ ", bucket " + tempArr[0] + "!, and it shows up " + tempArr[2] + " times.");
				}
				else
					System.out.println("¡¥" + input + "¡¦ is not found!");
				System.out.println();
			}
			else if(opt == -1)	// quit
			{
				System.out.println("Thank you for using!\nBye.");
				break;
			}
			else
				System.out.println("Error! Try again.");				
		}
	}
}
