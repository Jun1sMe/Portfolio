import java.util.Scanner;

public class TestTemplate
{
	public static Scanner scan = new Scanner(System.in); // offer method
	public static void main(String[] args)
	{
		// initialize
		SortList<String> myStr = new SortList<>();
		SortList<Integer> myInt = new SortList<>();
		int input = 0;
		while(true)
		{
			if(input == 0) // 1st step
			{
				System.out.print("1)String 2)Integer -1)Quit: ");
				try
				{
					input = scan.nextInt();		
				}
				catch(Exception e)
				{
					printTypeError();
					continue; // retry directly
				}
			}
			if(input == -1)
			{
				System.out.println("Thank you! Bye.");
				break;
			}
			else if(input == 1) // string
			{
				while(true)
				{
					System.out.print("Input(-1 to quit): ");
					String val = scan.next();
					if(val.equals("-1"))
						break;
					myStr.add(val);
				}
				myStr.bubbleSort(new Compare<String>()
				{
					@Override
					public int compare(String t1, String t2)
					{
						if(t1.compareTo(t2) > 0)
							return 1;
						if(t1.compareTo(t2) < 0)
							return -1;
						return 0;
					} 
				});
				
				printResult();
				System.out.println(myStr + "\n");
			}
			else if(input == 2) // int
			{
				while(true)
				{
					System.out.print("Input(-1 to quit): ");
					int val = scan.nextInt();
					if(val == -1)
						break;
					myInt.add(val);
				}
				myInt.bubbleSort(new Compare<Integer>()
				{
					@Override
					public int compare(Integer t1, Integer t2)
					{
						if(t1 > t2)
							return 1;
						if(t1 < t2)
							return -1;
						return 0;
					}
			
				});
				
				printResult();
				System.out.println(myInt + "\n");
				
			}
			else
			{
				printError();
			}
			// reset
			input = 0;				
		}
	}
	public static void printError()
	{
		System.out.println("Error! Try again.");
	}
	public static void printTypeError()
	{
		System.out.println("Type Error!");
		scan.nextLine();		// clear scanner
	}
	public static void printResult()
	{
		System.out.print("Order: ");
	}
}
