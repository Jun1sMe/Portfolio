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
		// �I�s�ƨ禡numGCD
		numGCD(num, den);
	}

	// �ƨ禡�D�̤j���]��
	public static void numGCD(int a, int b)
	{
		int GCD = 1;
		// �����������
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
