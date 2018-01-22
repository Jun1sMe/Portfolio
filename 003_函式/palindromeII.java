package lesson008_4;
import java.util.Scanner;
public class palindromeII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int option = 0;

		do
		{
			// first flow
			if(option == 0)
			{
				System.out.print("Option: 1) Test Palindrome. -1) Quit: ");
				option = scanner.nextInt();
				if(option != 1 && option != -1)
				{
					System.out.println("Error! Try again.");
					option = 0;					
				}				
			}
			// Test Palindrome
			if(option == 1)
			{
				System.out.print("Input a string: ");
				// 捕捉enter
				String enter = scanner.nextLine();
				// 捕捉輸入字元				
				String str = scanner.nextLine();
				// 除去空白
				str = str.replaceAll(" ", "");
				char[] ch = str.toCharArray();
				
				if(TestPalindrome(ch, 0, ch.length - 1) == 1)
					System.out.println("The input string is a palindrome.");
				else
					System.out.println("The input string is not a palindrome.");

				option = 0;

			}
			// Quit
			else if(option == -1)
				System.out.println("Thanks for using.");
		}while(option != -1);


	}

	// 副函式: 遞迴 ->測試迴文
	// leftEnd與rightEnd為陣列的index，代表陣列範圍的起迄兩端
	public static int TestPalindrome (char a[], int leftEnd, int rightEnd) {
		// base case
		// 奇數量'>'、偶數量'='
		if(leftEnd >= rightEnd)
			return 1;
		// recursive step
		if(a[leftEnd] == a[rightEnd])
			return TestPalindrome(a, (leftEnd + 1), (rightEnd - 1));
		else
			return 0;
	}

}
