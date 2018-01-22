package lesson3_2;
import java.util.Scanner;

public class TeamAB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 我是賴宥鈞，ProjectB的承包商
		// 發包商為林庭瑋
		Scanner scanner = new Scanner(System.in);
		int num, den, min, ans = 0;						// 宣告整數變數分子、分母、	暫存數、最大公因數
		int i = 1;										// 宣告計數，並初始為1
		
		System.out.println("請輸入兩個正整數，分別為分子、分母: ");
		num = scanner.nextInt();
		den = scanner.nextInt();
		System.out.println(
				"Enter numerator: " + num + "\n" + 
				"Enter denominator: " + den);
		while(num <= 0 || den <= 0)						// 輸入的數值其一為0，則重新輸入
		{
			System.out.println("Error!");
			System.out.println("請輸入兩個正整數，分別為分子、分母: ");
			num = scanner.nextInt();
			den = scanner.nextInt();			
		}
		min = num;										// 先把最小值定為 num
		if(num > den)									// 若否，則最小值為 den
			min = den;
		while(i <= min)									// 執行次數為最小值
		{
			if(den % i == 0)                            // i每次執行遞增，並藉由遞增的i除以den and num
			{											// 若滿足，則該i為最小公因數
				if(num % i == 0)
					ans = i;			
			}
			i++;
		}
		System.out.println("Answer: " + ans);
	}

}
