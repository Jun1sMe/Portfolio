package lesson13_2;
import java.util.Scanner;
public class stringPracticing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		// ��J���r���૬��int
		int input[] = new int[10];
		
		// ��J�Q�Ӧr��
		for(int i = 0; i < 10; i++)
			input[i] = scanner.next().charAt(0);
		
		// ��X�çP�_
		for(int i = 0; i < 10; i++)
		{
			int count = 0;
			// 0-9���Q�i��: 48~57
			if(input[i] >= 48 && input[i] <= 57)
			{
				System.out.println((char)input[i] + "�O�Ʀr");
				count++;
			}
			// A-Z���Q�i��: 65~90
			else if(input[i] >= 65 && input[i] <= 90)
				System.out.println((char)input[i] + "�O�r��");
			// a-z���Q�i��: 97~122
			else if(input[i] >= 97 && input[i] <= 122)
				System.out.println((char)input[i] + "�O�r��");

			// �̫�@�����浲�����X
			if(i == 9)
			{
				for(int j = 0 ; j < 10 ; j++)
					System.out.print((char)input[j]);
				if(count == 10)
					System.out.println(" �O�Ʀr");
				else
					System.out.println(" ���O�Ʀr");
			}
		}
		
	}

}
