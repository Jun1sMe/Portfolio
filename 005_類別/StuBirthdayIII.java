package lesson009_3_3;
import java.util.Scanner;
public class StuBirthdayIII {

	static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		// �ͤ�]�t�褸�~���
		// �ŧib�}�C�����OBirthday�A�ëإߪŶ�
		Birthday b[] = new Birthday[100];
		
		while(true)
		{
			System.out.print("�п�J�ǥͪ��ͤ�(quit: -1 -1 -1): ");
			int stuYear = input.nextInt();
			int stuMonth = input.nextInt();
			int stuDay = input.nextInt();	
			
			// �Nb�}�C�إ߰ѦҦ�}�A�ñN�ƭȦs��
			b[count] = new Birthday(stuYear, stuMonth, stuDay);
					
			// ��J-1 -1 -1 �h����
			if(stuYear == -1 && stuMonth == -1 && stuDay == -1)
				break;

			if(stuYear == -2 || stuMonth == -2 || stuDay == -2)
				System.out.println("��J���~�A�Э��s��J");
			else
				count++;
		}

		// �Ƨ�
		for(int pass = 1; pass < count ; pass++)
		{
			for(int i = 0; i < count - pass; i++)
			{
				int val = Birthday.compare(b[i], b[i + 1]);
				// ���p�h��
				if(val == -1)
				{
					Birthday temp = b[i + 1];
					b[i + 1] = b[i];
					b[i] = temp;
				}
			}
		}
		
		// ��X
		for(int i = 0; i < count; i++)
			b[i].print();
	}


}

class Birthday {
	private int year;
	private int month;
	private int day;
	private enum Status {
		LEAP, COMMON
	}
	private static Status sta = Status.COMMON;
	public Birthday(int y, int m, int d) {
		year = y;
		month = m;
		day = d;
		year = judgeYear(year);		
		// �|�~: (�����~���O400������)��(�����~���O4�����Ʀ����O100������)
		if(year % 400 == 0)
			sta = Status.LEAP;
		else if(year % 4 == 0 && year % 100 != 0)
			sta = Status.LEAP;				
		month = judgeMonth(month);
		day = judgeDay(day, month);		
	}
	
	// �ƨ禡: �P�_�~
	public static int judgeYear(int y) {
		if(y >= 0 && y < 106)
			return (y + 1911);
		else if(y >= 1911 & y < 2017)
			return y;
		else			
			return -2;
	}
	// �ƨ禡: �P�_��
	public static int judgeMonth(int m) {
		if(m >= 1 && m <= 12)
			return m;
		else			
			return -2;
	}
	// �ƨ禡: �P�_��
	public static int judgeDay(int d, int m) {
		if(d >= 1)
		{
			if(sta == Status.LEAP)
			{
				if(m == 2 && d <= 29)
					return d;
			}
			else
				if(m == 2 && d <= 28)
					return d;
			
			if(m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12)
				if(d <= 31)
					return d;
			if(m == 4 || m == 6 || m == 9 || m == 11)
				if(d <= 30)
					return d;
		}
		return -2;
	}
	
	// �ƨ禡: ���
	public static int compare(Birthday b1, Birthday b2) {
		if(b1.year >= b2.year)
		{			
			if(b1.month >= b2.month)
			{		
				if(b1.day > b2.day)
					return -1;
				
				return -1;
			}
			return -1;
		}
		return 0;	
	}

	// �ƨ禡: ���yyyy/mm/dd
	public void print() {
		System.out.printf("%4d/%02d/%02d\n", year, month, day);
	}
}
