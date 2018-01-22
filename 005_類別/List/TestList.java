import java.util.Scanner;
public class TestList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AdvancedSearchList myList = new AdvancedSearchList();
			
		while(true)
		{
			Scanner scanner = new Scanner(System.in);
			System.out.print("Options: 1) Append, 2)Search, 3)Max, 4)remove(index), 5)remove(value,number), -1)Quit: ");
			int opt = scanner.nextInt();
			// Append
			if(opt == 1)
			{
				System.out.print("Append value: ");
				int input = scanner.nextInt();
				if(myList.add(input))
					System.out.println("Adding success!");
				else
					System.out.println("Adding failure!");
				
				myList.print();
			}
			// Search
			else if(opt == 2)
			{
				System.out.print("Search value: ");
				int input = scanner.nextInt();
				if(myList.search(input) != -1)
					System.out.println(input + " exists!");
				else
					System.out.println(input + " don't exist!");	
				
				myList.print();
			}
			// Max
			else if(opt == 3)
			{
				int value = myList.findMax();
				if(value != -1)
					System.out.println("Max: " + value);
				else
					System.out.println("You don't enter any value!");	
				
				myList.print();
			}
			// remove(index)
			else if(opt == 4)
			{
				System.out.print("Remove index: ");
				int input = scanner.nextInt();
				if(myList.remove(input))
					System.out.println("index" + input + " deletes!");
				else
					System.out.println("index" + input + " don't exist!");
				
				myList.print();
			}
			// remove(value,number)
			else if(opt == 5)
			{
				System.out.print("Remove value and number: ");
				int inputVal = scanner.nextInt();
				int inputNum = scanner.nextInt();
				if(myList.remove(inputVal, inputNum))
					System.out.println(inputVal + " deletes.");
				else
					System.out.println(inputVal + " don't exist or " + 
								inputNum + "is not correct!");
				
				myList.print();
			}
			// Quit
			else if(opt == -1)
			{
				System.out.println("Thanks for using system.");
				break;
			}
			else
				System.out.println("Error! Try again.");
		}
	}

}
