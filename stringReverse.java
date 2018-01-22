package lesson13_9;
import java.util.Scanner;
public class stringReverse {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		// 連續輸入兩次
		char[][] ch2 = new char[2][100];
		int k = 0;
		do
		{
			
			// 輸入字串存入字元陣列
			Scanner input = new Scanner(System.in);
			String str = input.nextLine();
			char[] ch = str.toCharArray();
			int j = 0;

			// 將倒置的排序更為正置，並放入二維陣列
			for(int i = ch.length - 1 ; i >= 0  ; i--)
				ch2[k][j++] = ch[i];

			// 釋放多餘空間，長度為索引值加一
			char temp[] = new char[j + 1];
			for(int i = 0 ; i < j + 1 ; i++)
				temp[i] = ch2[k][i];
			ch2[k] = temp;							

		}while(++k < 2);	// do while控制索引值
		
		// 輸出文字
		for(k = 0 ; k < 2 ; k++)
		{
			for(int i = 0 ; i < ch2[k].length - 1  ; i++)
				System.out.print(ch2[k][i]);
			System.out.println();
		}

	}
			
}