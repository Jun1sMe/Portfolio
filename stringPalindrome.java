package lesson13_10;
import java.util.Scanner;
public class stringPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		while(true)
		{
			// ��J�r��s�J�r���}�C
			String str = input.next();
			char[] ch = str.toCharArray();
			
			// ��r���פ��|�W�L20
			if(ch.length > 20)
			{
				System.out.print("Your words is too long! Shorter!");
				continue;
			}
			
			// �p��۵�����
			int count = 0;
			
			// ���Ƶ��P�@�b�r��
			for(int i = 0 ; i < ch.length / 2 ; i++)
				if(ch[i] == ch[ch.length - 1 - i])
					count++;
			
			if(count == ch.length / 2)
				System.out.print("Yes");
			else
				System.out.print("No");
		}

	}

}
