package lesson2_7;
import java.util.Scanner;

public class countTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("�п�J���N���");
		int getSec = scanner.nextInt();         // �ŧigetSec����J���ƭ�
		int day = getSec / (24 * 60 * 60);
		System.out.println(day + " day");	
		int hour1 = getSec % (24 * 60 * 60);    // hour����ư��H�ѼƤ��l�ơA�A�N���l�ư��H�ɼ�
		int hour2 = hour1 / (60 * 60);
		System.out.println(hour2 + " hours");	
		int min1 = getSec % (60 * 60);          // min����ư��H�ɼƤ��l�ơA�A�N���l�ư��H���
		int min2 = min1 / 60;
		System.out.println(min2 + " minutes");
		int sec = getSec % 60;
		System.out.println(sec + " seconds");

	}

}
