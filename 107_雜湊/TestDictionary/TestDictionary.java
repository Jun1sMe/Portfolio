import java.util.Scanner;

public class TestDictionary
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		HashTable testHT = new HashTable(211);	// prime is division
		while(true)
		{
			System.out.print("1) Insert. 2) Search. -1) Quit: ");
			int opt = scanner.nextInt();
			if(opt == 1)		// insert
			{
				scanner.nextLine();	// skip the 'enter'
				System.out.print("Sentence: ");
				String input = scanner.nextLine();			
				testHT.insert(input);
			}
			else if(opt == 2)	// search
			{
				System.out.print("Query: ");
				String input = scanner.next();
				if(testHT.search(input) != null)		// found it
					System.out.println("．" + input + "・ is found!");
				else
					System.out.println("．" + input + "・ is not found!");
			}
			else if(opt == -1)	// quit
			{
				System.out.println("Thank you for using!\nBye.");
				break;
			}
			else
				printError();
			// separate apart
			System.out.println();
		}
	}
	public static void printError()
	{
		System.out.println("Error! Try again.");
	}
}
