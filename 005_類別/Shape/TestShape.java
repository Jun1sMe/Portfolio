import java.util.Scanner;
public class TestShape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Shape objShape[] = new Shape[100];
		int opt = 0, opt2 = 0, count = 0;
		
		while(true)
		{
			Scanner scanner = new Scanner(System.in);
			// initial status
			if(opt == 0)
			{		
				System.out.print("Menu: 1)add, 2)output, -1)Quit: ");
				opt = scanner.nextInt();
			}
			// add
			if(opt == 1)
			{
				// initial status
				if(opt2 == 0)
				{
					System.out.print("Options: 1)rectangle, 2)circle, 3)trapezoid, -1)Back: ");
					opt2 = scanner.nextInt();
				}
				// rectangle
				if(opt2 == 1)
				{
					System.out.print("Please enter the width and heigth: ");
					int w = scanner.nextInt();
					int h = scanner.nextInt();
					if(w > 0 && h > 0)
					{
						objShape[count] = new Rectangle(w, h);
						System.out.println("Area: " + objShape[count].area() +
										"\nPerimeter: " + objShape[count].perimeter());					
						count++;
						opt2 = 0;
					}
					else
						System.out.println("Error! Try again.");
				}
				// circle
				else if(opt2 == 2)
				{
					System.out.print("Please enter the radius: ");
					int r = scanner.nextInt();
					if(r > 0)
					{
						objShape[count] = new Circle(r);
						System.out.println("Area: " + objShape[count].area() +
										"\nPerimeter: " + objShape[count].perimeter());					
						count++;
						opt2 = 0;
					}
					else
						System.out.println("Error! Try again.");
				}
				// trapezoid
				else if(opt2 == 3)
				{
					System.out.print("Please type the upper, lower, and heigth: ");
					int u = scanner.nextInt();
					int l = scanner.nextInt();
					int h = scanner.nextInt();
					if(u > 0 && l > 0 && h > 0)
					{
						objShape[count] = new Trapezoid(u, l, h);
						System.out.print("Area: " + objShape[count].area() +
										"\nPerimeter: ");
						System.out.printf("%.2f\n", objShape[count].perimeter());
						count++;
						opt2 = 0;
					}
					else
						System.out.println("Error! Try again.");
				}
				// Back
				else if(opt2 == -1)
					opt = 0;
				else
				{
					System.out.println("Error! Try again.");
					opt2 = 0;
				}

			}
			// output
			else if(opt == 2)
			{
				for(int i = 0; i < count; i++)
				{
					System.out.printf("%9s ", objShape[i].getClass().getName());
					System.out.printf(" Area: %4.2f", objShape[i].area());
					System.out.printf("\tPerimeter: %4.2f\n", objShape[i].perimeter());
				}
				System.out.println();
				opt = 0;
			}
			// Quit
			else if(opt == -1)
			{
				System.out.println("Thanks for using");
				break;
			}
			else
			{
				System.out.println("Error! Try again.");
				opt = 0;
			}
		}
	}

}
