package lesson13_3;
import java.util.Scanner;
public class caseCovertor {
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int retry = 0;
		while(true)
		{
			System.out.print("請輸入一個字元: ");
			int input1 = input.next().charAt(0);
			System.out.print("請輸入一個字元: ");
			int input2 = input.next().charAt(0);
			
			// 大小寫差距為32
			// A-Z之十進位: 65~90
			if(input1 >= 65 && input1 <= 90)
			{
				System.out.print((char)input1 + "為大寫，其小寫為" + (char)(input1 + 32));
				retry++;
			}
			// a-z之十進位: 97~122
			else if(input1 >= 97 && input1 <= 122)
			{
				System.out.print((char)input1 + "為小寫，其大寫為" + (char)(input1 - 32));
				retry++;
			}
			System.out.println();
			
			if(input2 >= 65 && input2 <= 90)
			{
				System.out.print((char)input2 + "為大寫，其小寫為" + (char)(input2 + 32));
				retry++;
			}
			else if(input2 >= 97 && input2 <= 122)
			{
				System.out.print((char)input2 + "為小寫，其大寫為" + (char)(input2 - 32));
				retry++;
			}
			System.out.println();
			
			if(retry != 2)
				System.out.println("輸入有錯誤! 請重新輸入\n");
			else
				break;

		}
		
		
		
	}

}
