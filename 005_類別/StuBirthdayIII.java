package lesson009_3_3;
import java.util.Scanner;
public class StuBirthdayIII {

	static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		// 生日包含西元年月日
		// 宣告b陣列為類別Birthday，並建立空間
		Birthday b[] = new Birthday[100];
		
		while(true)
		{
			System.out.print("請輸入學生的生日(quit: -1 -1 -1): ");
			int stuYear = input.nextInt();
			int stuMonth = input.nextInt();
			int stuDay = input.nextInt();	
			
			// 將b陣列建立參考位址，並將數值存放
			b[count] = new Birthday(stuYear, stuMonth, stuDay);
					
			// 輸入-1 -1 -1 則停止
			if(stuYear == -1 && stuMonth == -1 && stuDay == -1)
				break;

			if(stuYear == -2 || stuMonth == -2 || stuDay == -2)
				System.out.println("輸入錯誤，請重新輸入");
			else
				count++;
		}

		// 排序
		for(int pass = 1; pass < count ; pass++)
		{
			for(int i = 0; i < count - pass; i++)
			{
				int val = Birthday.compare(b[i], b[i + 1]);
				// 較小則換
				if(val == -1)
				{
					Birthday temp = b[i + 1];
					b[i + 1] = b[i];
					b[i] = temp;
				}
			}
		}
		
		// 輸出
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
		// 閏年: (公元年分是400的倍數)或(公元年分是4的倍數但不是100的倍數)
		if(year % 400 == 0)
			sta = Status.LEAP;
		else if(year % 4 == 0 && year % 100 != 0)
			sta = Status.LEAP;				
		month = judgeMonth(month);
		day = judgeDay(day, month);		
	}
	
	// 副函式: 判斷年
	public static int judgeYear(int y) {
		if(y >= 0 && y < 106)
			return (y + 1911);
		else if(y >= 1911 & y < 2017)
			return y;
		else			
			return -2;
	}
	// 副函式: 判斷月
	public static int judgeMonth(int m) {
		if(m >= 1 && m <= 12)
			return m;
		else			
			return -2;
	}
	// 副函式: 判斷日
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
	
	// 副函式: 比較
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

	// 副函式: 顯示yyyy/mm/dd
	public void print() {
		System.out.printf("%4d/%02d/%02d\n", year, month, day);
	}
}
