package lesson2_9;
import java.util.Scanner;
public class returnBack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("�п�J�@�Ӥ����: ");
		int letter5 = scanner.nextInt(); 
		if (letter5 >= 10000 && letter5 <= 99999)
		{
			System.out.println("Input number: " + letter5);
			//�ŧi����ܼ�a, b, c, d���^��Ƥ��զ��ƭ�
			int a = letter5 / 10000;			//�U���
			int b = letter5 % 10;      			//�Ӧ��
			int c = (letter5 % 100) / 10;   	//�Q���
			int d = (letter5 % 10000) / 1000;	//�d���
			if (a == b && c == d)
				System.out.println("Result: yes");
				else
					System.out.println("Result: no");
		}
		else
			System.out.println("�D�����!");
	}

}
