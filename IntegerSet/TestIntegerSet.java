package lesson009_5d;
import java.util.Scanner;
public class TestIntegerSet {

	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("Initial size for Set A: ");
		int a = scanner.nextInt();
		IntegerSet colA = new IntegerSet(a);
		System.out.print("Initial size for Set B: ");
		int b = scanner.nextInt();
		IntegerSet colB = new IntegerSet(b);
				
		while(true)
		{
			System.out.print("Menu: 1) Modify A. 2) Modify B. 3) Intersection. 4) Union. -1) Quit: ");
			int option = scanner.nextInt();
			// Quit
			if(option == -1)
			{
				System.out.println("Thanks for using.");
				break;
			}
			// Modify A.
			else if(option == 1)
				modifyValue(option, colA);
			// Modify B.
			else if(option == 2)
				modifyValue(option, colB);
			// Intersection.
			else if(option == 3)
			{
				IntegerSet result = colB.intersection(colA);
				result.output();
			}
			// Union.
			else if(option == 4)
			{
				IntegerSet result = colB.union(colA);
				result.output();
			}
			else
				System.out.println("Error! Try again.");
			
			
				
		}
		
		
		
	}
	
	// function: modifyValue
	public static void modifyValue(int opt, IntegerSet x) {		
		// last
		while(true)
		{
			System.out.print("Modify ");
			// Modify A.
			if(opt == 1)
				System.out.print("A");
			// Modify B.
			else
				System.out.print("B");
			System.out.print(": a) Insert. b) Output. c) Delete. d) Back: ");
			String select = scanner.next();
			// select
			// Insert.
			if(select.equals("a") == true || select.equals("A") == true)
			{
				System.out.print("Insert: ");
				int value = scanner.nextInt();		
				// 範圍0~100
				if(value < 0 || value > 100)
					System.out.println("\'" + value + "\' out of range!\n" );
				else
				{
					// 值存在
					if(x.search(value) != -1)
						System.out.println("\'" + value + "\' duplicated!\n" );
					// 值不存在，則新增
					else
					{
						x.insert(value);	
						System.out.println("\'" + value + "\' successfully inserted!\n" );
					}		
				}
			}
			// Output.
			else if(select.equals("b") == true || select.equals("B") == true)
				x.output();
			// Delete.
			else if(select.equals("c") == true || select.equals("C") == true)
			{
				System.out.print("Delete: ");
				int value = scanner.nextInt();			
				// 值不存在
				if(x.search(value) == -1)
					System.out.println("\'" + value + "\' not found!\n" );
				// 值存在，則刪除
				else
				{
					x.delete(value);	
					System.out.println("\'" + value + "\' successfully deleted!\n" );
				}		
			}
			// Back
			else if(select.equals("d") == true || select.equals("D") == true)
				break;
			else
				System.out.println("Error! Try again.");
		}
			
	
	}

}
