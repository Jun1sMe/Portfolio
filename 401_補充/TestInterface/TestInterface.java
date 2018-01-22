import java.util.ArrayList;
import java.util.Scanner;

public class TestInterface
{
	public static Scanner scan = new Scanner(System.in); // offer method
	public static void main(String[] args)
	{
		int input = 0, flowTrapezoid = 0; // initialize input and Trapezoid flow
		float up = 0, low = 0, h = 0; // initialize Trapezoid value
		ArrayList<Object> myArr = new ArrayList();	// initialize array be obj
		while(true)
		{
			if(input == 0) // 1st step
			{
				System.out.print("1)Circle 2)Trapezoid 3)Show Data -1)Quit: ");
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
			if(input == -1) // quit
			{
				System.out.println("Thank you! Bye.");
				break;
			}
			else if(input == 1) // circle
			{
				System.out.print("Radius: ");
				try
				{
					float r = scan.nextInt();
					if(r > 0)
					{
						myArr.add(new Circle(r));
						printSuccess();
						input = 0;
					}
					else
						printError();
				}
				catch(Exception e)
				{
					printTypeError();
				}
					
			}
			else if(input == 2) // trapezoid
			{
				try
				{
					// input flow
					if(flowTrapezoid == 0)
					{
						System.out.print("Upper: ");
						up = scan.nextInt();
						flowTrapezoid++;
					}
					else if(flowTrapezoid == 1)
					{
						if(up > 0)
						{
							System.out.print("Lower: ");
							low = scan.nextInt();
							flowTrapezoid++;
						}
						else
						{
							printError();
							flowTrapezoid--;
						}
					}
					else if(flowTrapezoid == 2)
					{
						if(low > 0)
						{
							System.out.print("Height: ");
							h = scan.nextInt();
							flowTrapezoid++;
						}
						else
						{
							printError();
							flowTrapezoid--;
						}
					}
					else // last step
					{
						if(h > 0)
						{
							myArr.add(new Trapezoid(up, low, h));
							printSuccess();
							input = flowTrapezoid = 0;
							up = low = h = 0;
						}
						else
						{
							printError();
							flowTrapezoid--;
						}
					}
				}
				catch(Exception e)
				{
					printTypeError();
				}
			}
			else if(input == 3) // show data
			{
				if(myArr.size() == 0)
					System.out.println("No data!");
				else
				{
					printBreakline();
					for(int i = 0 ; i < myArr.size(); i++)
					{
						System.out.print("Shape" + (i + 1) + ": ");
						if(myArr.get(i) instanceof Circle) // get obj type
						{
							Circle tmp  = (Circle) myArr.get(i);	
							System.out.print(tmp.getClass().getName() + "\n" + tmp.getAttributes());
							System.out.printf("Area: %.2f\nPerimeter: %.2f\n", tmp.getArea() , tmp.getPerimeter());
						}
						else
						{
							Trapezoid tmp = (Trapezoid) myArr.get(i);
							System.out.print(tmp.getClass().getName() + "\n" + tmp.getAttributes());
							System.out.printf("Area: %.2f\nPerimeter: %.2f\n", tmp.getArea() , tmp.getPerimeter());
						}
						if(i != myArr.size() - 1) // last one
							System.out.println();
					}
					printBreakline();					
				}
				input = 0;
			}
			else	 // including input 0
			{
				printError();
				input = 0;
			}
					
		}

	}
	public static void printError()
	{
		System.out.println("Error! Try again.");
	}
	public static void printTypeError()
	{
		System.out.println("Error! Use Integer.");
		scan.nextLine();		// clear scanner
	}
	public static void printBreakline()
	{
		System.out.println("=================");
	}
	public static void printSuccess()
	{
		System.out.println("Success!");
	}
}
