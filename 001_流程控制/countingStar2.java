package lesson5_2;
import java.util.Scanner;
public class countingStar2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the size of the diamond: ");
		int getLength = scanner.nextInt();						// 用戶指定菱形之大小
		for(int i = 0; i < getLength; i++)						// i為列的控制、j為行的控制
		{
			for(int j = 0; j < getLength -1 - i; j++)			// 顯示' '，空格數為尺寸少1
				System.out.print(" ");							// 依列執行：4、3、2...
			if(i == 0)											// 首列，'*'為1
				System.out.print("*");			
			if(i > 0 && i <= getLength )						// 非首列，'*'為2
			{
				System.out.print("*");
				for(int j = 0; j < 2 * i - 1; j++)				// 顯示' '，空格數受i間接控制
					System.out.print(" ");						// 依列執行：0、1、3、5...
				
				System.out.print("*");
			}
			System.out.print("\n");								// 每列執行完畢，換行		
		}
		
		for(int i = 0; i < getLength - 1; i++)					// 下方之反三角，最長列由正三角執行
		{
			for(int j = 0; j < i + 1; j++)						// 顯示' '，空格數為每次遞增
				System.out.print(" ");							// 依列執行：1、2、3...
			if(i != getLength - 2)								// 非首列，'*'為2
			{
				System.out.print("*");
				for(int j = 0; j < 2 * getLength - 5 - 2 * i; j++)	// 顯示' '，空格數
					System.out.print(" ");							// 依列執行：5、3、1...

				System.out.print("*");
			}
			else													// 末列，'*'為1
				System.out.print("*");
			System.out.print("\n");
		}
	}

}
