package lesson5_1;
import java.util.Scanner;
public class countingStar1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the size of the diamond: ");
		int getLength = scanner.nextInt();						// 用戶指定菱形之大小
		for(int i = 0; i < getLength; i++)						// i為列的控制、j為行的控制
		{
			for(int j = 0; j < getLength -1 - i; j++)			// 顯示' '，空格數為尺寸少1												
				System.out.print(" ");							// 依列執行：4、3、2...
			for(int j = 0; j < 2 * i + 1; j++)					// 顯示'*'，星數受i間接控制
				System.out.print("*");							// 依列執行：1‵、3、5...
			
			System.out.print("\n");								// 每列執行完畢，換行			
		}
		for(int i = 0; i < getLength - 1; i++)					// 下方之反三角，最長列由正三角執行
		{
			for(int j = 0; j < i + 1; j++)						// 顯示' '，空格數為每次遞增
				System.out.print(" ");							// 依列執行：1、2、3...
			for(int j = 0; j < 2 * getLength - 3 - 2 * i; j++)	// 顯示'*'，星數最大列由正三角顯示，故顯示下一階層，兩倍尺寸少3
				System.out.print("*");							// 依列執行：7、5、3...

			System.out.print("\n");
		}
	}

}
