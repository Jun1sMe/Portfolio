package lesson10_3;
import java.util.Scanner;
public class maxGCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter numerator: ");
		int num = scanner.nextInt();
		System.out.print("Enter denominator: ");
		int den = scanner.nextInt();
		// 呼叫副函式numGCD
		numGCD(num, den);
	}

	// 副函式求最大公因數
	public static void numGCD(int a, int b)
	{
		int GCD = 1;
		// 分母為正整數
		if(b > 0)
		{
			for(int i = 2 ; i < a && i < b ; i++)
			{
				if(a % i == 0 && b % i == 0)
					GCD = i;				
			}
			System.out.print("Answer: " + GCD);
		}
		else
			System.out.print("Error!");
	}
}
