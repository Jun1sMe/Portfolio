package lesson5_3;
import java.util.Scanner;
public class countingStar3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the size of the diamond: ");
		int getLength = scanner.nextInt();						// 用戶指定菱形之大小
		for(int i = 0; i < getLength; i++)						// i為列的控制、j為行的控制
		{
			if(i == 0)											// 首列，僅有'*'
				for(int j = 0; j < getLength * 2 - 1; j++)
					System.out.print("*");
			else
			{
				for(int j = 0; j < getLength - i; j++)			// 顯示'*'，星數為尺寸少1
					System.out.print("*");						// 依列執行：4、3、2...
				for(int j= 0 ; j < 2 * i -1; j++)				// 顯示' '，星數受i控制
					System.out.print(" ");
				for(int j = 0; j < getLength - i; j++)			// 顯示'*'，星數為尺寸少1
					System.out.print("*");						// 依列執行：4、3、2...			
			}
			System.out.print("\n");								// 每列執行完畢，換行		
		}
		
		for(int i = 0; i < getLength - 1; i++)					// 下方之反三角，最長列由正三角執行
		{														// 利用例題二之原'*'，並在前後增加'*'
			for(int j = 0; j < i + 1; j++)						// 顯示'*'，空格數為每次遞增
				System.out.print("*");							// 依列執行：1、2、3...
			if(i != getLength - 2)								// 非首列，'*'為2
			{
				System.out.print("*");
				for(int j = 0; j < 2 * getLength - 5 - 2 * i; j++)	// 顯示' '，空格數
				{													// 依列執行：5、3、1...
					System.out.print(" ");
				}
				System.out.print("*");
			}
			else												// 末列'*'為數列值多1
				System.out.print("*");
			for(int j = 0; j < i + 1; j++)						// 顯示'*'，空格數為每次遞增
				System.out.print("*");							// 依列執行：1、2、3...
			System.out.print("\n");
		}
	}

}
