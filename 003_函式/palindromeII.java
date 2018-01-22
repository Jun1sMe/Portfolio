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
				// ����enter
				String enter = scanner.nextLine();
				// ������J�r��				
				String str = scanner.nextLine();
				// ���h�ť�
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

	// �ƨ禡: ���j ->���հj��
	// leftEnd�PrightEnd���}�C��index�A�N��}�C�d�򪺰_�����
	public static int TestPalindrome (char a[], int leftEnd, int rightEnd) {
		// base case
		// �_�ƶq'>'�B���ƶq'='
		if(leftEnd >= rightEnd)
			return 1;
		// recursive step
		if(a[leftEnd] == a[rightEnd])
			return TestPalindrome(a, (leftEnd + 1), (rightEnd - 1));
		else
			return 0;
	}

}
