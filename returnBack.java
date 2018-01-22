package lesson2_9;
import java.util.Scanner;
public class returnBack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("叫块き计: ");
		int letter5 = scanner.nextInt(); 
		if (letter5 >= 10000 && letter5 <= 99999)
		{
			System.out.println("Input number: " + letter5);
			//俱计跑计a, b, c, dゅ计ぇ舱Θ计
			int a = letter5 / 10000;			//窾计
			int b = letter5 % 10;      			//计
			int c = (letter5 % 100) / 10;   	//计
			int d = (letter5 % 10000) / 1000;	//计
			if (a == b && c == d)
				System.out.println("Result: yes");
				else
					System.out.println("Result: no");
		}
		else
			System.out.println("獶き计!");
	}

}
