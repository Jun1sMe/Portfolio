package lesson008_1;
import java.util.Scanner;
public class pascalTheory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("C(m��n)�A�п�Jm, n: ");
		int input1 = input.nextInt();
		int input2 = input.nextInt();
		System.out.print("Ans: " + pascal(input1, input2));
		
	}
	
	// �ƨ禡: ���j ->�ڴ��d�w�z
	public static int pascal(int n, int x) {
		// base case
		if(x <= 1)
			return 1;
		// recursive step
		return (pascal(n - 1, x - 1) *  n) / x;
	}

}
