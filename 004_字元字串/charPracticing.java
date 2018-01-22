package lesson13_1;
import java.util.Scanner;
public class charPracticing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int int1;
		char char1;
		
		// 一、輸入數值轉換成字元 ->30~122
		while(true)
		{
			System.out.print("Please enter an integer: ");
			int1 = scanner.nextInt();
			if(int1 < 30 || int1 >122)
				System.out.println("The value excceds! Try again.\n(Ragne: 30~122)");
			else
				break;
		}
		
		// 一、輸入字元轉換成數值 ->0-9, A-Z, a-z
		// 十進位: 48~57, 65~90, 97~122
		while(true)
		{
			System.out.print("Please enter an character: ");
			char1 = scanner.next().charAt(0);
			int char2int = (int)char1;
			if(char2int >= 48 && char2int <= 57)
				break;
			else if(char2int >= 65 && char2int <= 90)
				break;
			else if(char2int >= 97 && char2int <= 122)
				break;
			else
				System.out.println("The value excceds! Try again.\\n(Ragne: 0-9,A-Z,a-z)");
		}
		
		// 輸出
		System.out.println("AcsiiCode = " + int1 + "/ Asc2Char = " + (char)(int1));
		System.out.println("Char = " + char1 + "/ Char2AsciiCode = " + (int)char1);
		
	}

}
