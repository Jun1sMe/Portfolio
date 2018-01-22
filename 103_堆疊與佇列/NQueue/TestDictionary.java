import java.util.Scanner;

public class TestDictionary
{

	public final static int engNum = 26;
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		NQueue[] testQueue = new NQueue[engNum];
		for(int i = 0 ; i < engNum ; i++)
			testQueue[i] = new NQueue();			
		int flow = 0;	// ªì©l¬yµ{
		while(true)
		{
			if(flow == 0)
			{
				System.out.print("Input a string (-1 to end): ");
				String input = scanner.next();
				if(input.equals("-1"))
					flow++;
				else
				{
					int value = NQueue.isValue(input);
					if( value >= 0 && value < engNum)
					{
						testQueue[value].push(input);
					}
					else
						printError();
				}
			}
			else if(flow == 1)
			{
				System.out.print("\n1)Insert. 2)Get a word. 3)Output. 4)Quit: ");
				int opt = scanner.nextInt();
				if(opt == 1)
					flow--;
				else if(opt == 2)
				{
					System.out.print("Initial: ");
					String inputChar = scanner.next();
					if(inputChar.length() == 1)
					{
						int value = NQueue.isValue(inputChar);
						String tempStr = testQueue[value].getWord(inputChar.charAt(0));
						if(!tempStr.equals(""))
						{
							System.out.println("Word: " + tempStr);
							continue;
						}
					}
					printError();				
				}
				else if(opt == 3)
				{
					for(int i = 0 ; i < engNum ; i++)
						testQueue[i].output();
				}
				else if(opt == 4)
				{
					System.out.println("Thank you for using");
					break;					
				}
				else
					printError();
			}

		}
	}
	public static void printError()
	{
		System.out.println("Error! Try again.");
	}

}
