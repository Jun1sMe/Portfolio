package lesson13_3;
import java.util.Scanner;
public class caseCovertor {
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int retry = 0;
		while(true)
		{
			System.out.print("�п�J�@�Ӧr��: ");
			int input1 = input.next().charAt(0);
			System.out.print("�п�J�@�Ӧr��: ");
			int input2 = input.next().charAt(0);
			
			// �j�p�g�t�Z��32
			// A-Z���Q�i��: 65~90
			if(input1 >= 65 && input1 <= 90)
			{
				System.out.print((char)input1 + "���j�g�A��p�g��" + (char)(input1 + 32));
				retry++;
			}
			// a-z���Q�i��: 97~122
			else if(input1 >= 97 && input1 <= 122)
			{
				System.out.print((char)input1 + "���p�g�A��j�g��" + (char)(input1 - 32));
				retry++;
			}
			System.out.println();
			
			if(input2 >= 65 && input2 <= 90)
			{
				System.out.print((char)input2 + "���j�g�A��p�g��" + (char)(input2 + 32));
				retry++;
			}
			else if(input2 >= 97 && input2 <= 122)
			{
				System.out.print((char)input2 + "���p�g�A��j�g��" + (char)(input2 - 32));
				retry++;
			}
			System.out.println();
			
			if(retry != 2)
				System.out.println("��J�����~! �Э��s��J\n");
			else
				break;

		}
		
		
		
	}

}
