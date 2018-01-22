package lesson2_8;
import java.util.Scanner;
public class ArmstrongT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("叫块计: ");
		int armstrongInt = scanner.nextInt(); 
		if (armstrongInt >= 100 && armstrongInt <= 999)
		{
			//俱计跑计a, b, c﹊吹Ё计ぇ舱Θ计
			int a = armstrongInt / 100;       //κ计
			int b = armstrongInt % 10;        //计
			int c = (armstrongInt / 10) % 10; //计
			if (armstrongInt == a * a * a + b * b * b + c * c * c)
				System.out.println("Yes, 琌﹊吹Ё计!");
				else
					System.out.println("No, ぃ琌﹊吹Ё计!");
		}
			else
				System.out.println("獶计!");
		
	}

}
