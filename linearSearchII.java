package lesson008_3;
import java.util.Scanner;
public class linearSearchII {

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
				System.out.print("Option: 1) Add. 2) Search. -1) Quit: ");
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
				System.out.print("Key: ");
				int key = scanner.nextInt();
				if(LinearSearch(numArr, key, count) != -1)
					System.out.println("\'" + key + "\' is found!");
				else
					System.out.println("\'" + key + "\' is not found!");
				
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
	// 副函式: 遞迴 ->找數值
	// key存在於陣列a中索引0至n-1的範圍內，便回傳所在的index，否則回傳-1
	public static int LinearSearch (int a[], int key, int n) {
		// base case
		// 若比不到數值
		if(n <= 0)
			return -1;
		// recursive step
		if(key == a[n - 1])
			return (n - 1);
		else
			return LinearSearch(a, key, n - 1);
	}

}
