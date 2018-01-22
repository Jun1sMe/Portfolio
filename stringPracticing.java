package lesson13_2;
import java.util.Scanner;
public class stringPracticing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		// 輸入之字元轉型為int
		int input[] = new int[10];
		
		// 輸入十個字元
		for(int i = 0; i < 10; i++)
			input[i] = scanner.next().charAt(0);
		
		// 輸出並判斷
		for(int i = 0; i < 10; i++)
		{
			int count = 0;
			// 0-9之十進位: 48~57
			if(input[i] >= 48 && input[i] <= 57)
			{
				System.out.println((char)input[i] + "是數字");
				count++;
			}
			// A-Z之十進位: 65~90
			else if(input[i] >= 65 && input[i] <= 90)
				System.out.println((char)input[i] + "是字母");
			// a-z之十進位: 97~122
			else if(input[i] >= 97 && input[i] <= 122)
				System.out.println((char)input[i] + "是字母");

			// 最後一次執行結束後輸出
			if(i == 9)
			{
				for(int j = 0 ; j < 10 ; j++)
					System.out.print((char)input[j]);
				if(count == 10)
					System.out.println(" 是數字");
				else
					System.out.println(" 不是數字");
			}
		}
		
	}

}
