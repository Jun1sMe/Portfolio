import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class TestDoublyLinkedList
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int flow = 0; // flow control
		OrderParser orderList = new OrderParser();
		Node curNode = new Node("");

		try
		{
			while (true)
			{
				if (flow == 0)
				{
					System.out.println("Command:");
					String commandLine = scanner.nextLine();
					CommandParser parserCom = new CommandParser(commandLine);

					String inFile = parserCom.getInFile();
					FileReader fileReader = new FileReader(inFile);
					BufferedReader bufReader = new BufferedReader(fileReader);
					String tempStr;
					while ((tempStr = bufReader.readLine()) != null)
					{
						orderList.setCommand(tempStr);
					}
					// close
					bufReader.close();
					fileReader.close();
					orderList.printAll();

					flow++;
					// result
					System.out.print("Result: ");
					curNode = orderList.getCurNode();
				}	// end flow0

				else if (flow == 1)
				{
					System.out.print(orderList.printResult() + 
							"\n1. Next Step, 2. Last Step, 3. Compile, -1. Quit: ");
					int opt = scanner.nextInt();
					
					
					// 1. Next Step,
					if (opt == 1)
					{
						if (curNode.getRightLink() == null)
							System.out.println("End of Code.");
						else
						{
							System.out.println(curNode.getRightLink().getData());
							curNode = orderList.getCurNode().getRightLink();
						}
					}
					// 2. Last Step,
					else if (opt == 2)
					{
						if (curNode.getLeftLink() == null)
							System.out.println("End of Code.");
						else
						{
							System.out.println("Before: " + curNode.getLeftLink().getData());
							curNode = orderList.getCurNode().getLeftLink();
						}
					}
					// 3. Compile,
					else if (opt == 3)
					{
						orderList.setData();
						flow--;
					}
					// -1. Quit
					else if (opt == -1)
					{
						System.out.println("Thank you for using!");
						break;
					} else
						System.out.println("Error! Try again.");

				}	// end flow1

			}	// end while

		} catch (Exception e)
		{
			System.out.println("File Not Found");
		}

	}

}
