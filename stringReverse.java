package lesson13_9;
import java.util.Scanner;
public class stringReverse {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		// �s���J�⦸
		char[][] ch2 = new char[2][100];
		int k = 0;
		do
		{
			
			// ��J�r��s�J�r���}�C
			Scanner input = new Scanner(System.in);
			String str = input.nextLine();
			char[] ch = str.toCharArray();
			int j = 0;

			// �N�˸m���Ƨǧ󬰥��m�A�é�J�G���}�C
			for(int i = ch.length - 1 ; i >= 0  ; i--)
				ch2[k][j++] = ch[i];

			// ����h�l�Ŷ��A���׬����ޭȥ[�@
			char temp[] = new char[j + 1];
			for(int i = 0 ; i < j + 1 ; i++)
				temp[i] = ch2[k][i];
			ch2[k] = temp;							

		}while(++k < 2);	// do while������ޭ�
		
		// ��X��r
		for(k = 0 ; k < 2 ; k++)
		{
			for(int i = 0 ; i < ch2[k].length - 1  ; i++)
				System.out.print(ch2[k][i]);
			System.out.println();
		}

	}
			
}