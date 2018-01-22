package lesson008_2;
import java.util.Scanner;
public class showMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int[] numArr = new int[100];
		int count = 0, option = 0;
		do
		{
			// first flow
			if(option == 0)
			{
				System.out.print("Option: 1) Add. 2) Minimum. -1) Quit: ");
				option = scanner.nextInt();
			}
			// Add
			if(option == 1)
			{
				System.out.print("Insert grade (-1 to end): ");
				int grade= scanner.nextInt();
				// 輸入數字（介於0~100）: 
				if(grade >= 0 && grade <= 100)
				{
					numArr[count++] = grade;
				}
				else if(grade == -1)
				{
					System.out.println();
					option = 0;
				}					
				else
					System.out.println("Error! Try again.");
			}
			// Minimum
			else if(option == 2)
			{
				System.out.println("Minimum: " + RecursiveMinimum(numArr, count) + "\n");
				option = 0;
			}
			// Quit
			else if(option == -1)
				System.out.println("Thanks for using.");
			else
			{
				System.out.println("Error! Try again.");
				option = 0;
			}
		}while(option != -1);
			
		
		
	}
	// 副函式: 遞迴 ->找最小值
	public static int RecursiveMinimum (int a[], int n) {
		// base case
		if(n <= 1)
			return a[0];		
		// 最小值存入min		
		int min = RecursiveMinimum (a, n - 1);
		// recursive step
		if(a[n - 1] < min)
			return a[n - 1]; 
		else
			return min;

	}

}
