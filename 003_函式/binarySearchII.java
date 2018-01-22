package lesson008_5;
import java.util.Scanner;
public class binarySearchII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int[] numArr = new int[100];
		int option = 0, count = 0;;

		do
		{
			// first flow
			if(option == 0)
			{
				System.out.print("Option: 1) Add. 2) Binary Search. -1) Quit: ");
				option = scanner.nextInt();
				if(option != 1 && option != 2 && option != -1)
				{
					System.out.println("Error! Try again.");
					option = 0;					
				}				
			}
			// Add
			if(option == 1)
			{
				System.out.print("Insert grade (-1 to end): ");
				int grade= scanner.nextInt();
				// 數字介於0~100間 
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
			// Binary Search
			else if(option == 2)
			{
				bubbleSort(numArr, count);
				System.out.print("Key: ");
				int key = scanner.nextInt();
				if(binarySearch(numArr, key, 0, (count - 1)) == 1)
					System.out.println("\'" + key + "\' is found!");
				else
					System.out.println("\'" + key + "\' is not found!");
				
				option = 0;
			}
			// Quit
			else if(option == -1)
				System.out.println("Thanks for using.");
		}while(option != -1);


	}

	// 副函式: 遞迴 ->二元搜尋
	// key為欲搜尋的數字，start與end為陣列的index，代表搜尋的起迄範圍
	public static int binarySearch(int a[], int key, int start, int end) {
		int mid = (start + end) / 2;
		// base case
		if(start > end)
			return 0;
		// recursive step
		if(key > a[mid])
			return binarySearch(a, key, (mid + 1), end);
		else if(key < a[mid])
			return binarySearch(a, key, start, (mid - 1));
		else
			return 1;		
	}
	
	// 副函式: 氣泡排序法
	public static void bubbleSort(int a[], int count) {
		// 每數都比
		for(int i = 1; i < count; i++)
		{
			// 少比一次
			for(int j = 0; j < count - i; j++)
			{
				// 前者為小，後者為大
				if(a[j] > a[j + 1])
				{
					int temp = a[j + 1];
					a[j + 1] = a[j];
					a[j] = temp;					
				}
			}
		}
	}
	

}
