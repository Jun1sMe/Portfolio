package lesson2_8;
import java.util.Scanner;
public class ArmstrongT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("�п�J�@�ӤT���: ");
		int armstrongInt = scanner.nextInt(); 
		if (armstrongInt >= 100 && armstrongInt <= 999)
		{
			//�ŧi����ܼ�a, b, c�����i�����Ƥ��զ��ƭ�
			int a = armstrongInt / 100;       //�ʦ��
			int b = armstrongInt % 10;        //�Ӧ��
			int c = (armstrongInt / 10) % 10; //�Q���
			if (armstrongInt == a * a * a + b * b * b + c * c * c)
				System.out.println("Yes, �O���i������!");
				else
					System.out.println("No, ���O���i������!");
		}
			else
				System.out.println("�D�T���!");
		
	}

}
