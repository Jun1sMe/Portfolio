// 會員生日
public class MemberBD {
	// 隱密成員: 年、月、日
	private int year, month, day;
	// 建構子: 呼叫方式，透過此方法修改資料內容
	public MemberBD(int y, int m, int d) {
		this.setData(y, m, d);
	}
	// 改寫 ->建構子函式
	public void setData(int y, int m, int d) {
		// 設定初值為1
		year = month = day = 1;
		if(year >= 1)
			year = y;
		if(m >= 1 && m <= 12)
			month = m;
		if(MemberBD.isValid(y, m, d) == true)
			day = d;
	}
	// 檢查日期格式、內容, false表示不符
	public static boolean isValid(int y, int m, int d) {
		// 以陣列紀錄每月之天數
		int days[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		// 年、月非正常值
		if(y <= 0 || m <= 0 || m > 12)
			return false;
		
		// 二月之外的情形
		if(m != 2)
		{
			// 該月之天數
			if(d <= 0 || d > days[m])
				return false;
			return true;
		}
		// 二月須計入閏年討論:
		// 西元年除以4可整除且除以100不可整除，或
		// 西元年除以400可整除
		if((y % 4 == 0 && y % 100 != 0) || y % 100 == 0)
		{
			if(d <= 0 || d > 29)
				return false;
			return true;
		}
		// 平年
		if(d <= 0 || d > days[m])
			return false;
		return true;
	}
	// Main function可取用的數值: 年、月、日
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public int getDay() {
		return day;
	}
	// 回傳數字表示日期比較結果: 
	// 小於0 ->a 較早 | 大於0 ->a 較晚 | 0 ->相同
	public static int compare(MemberBD a, MemberBD b) {
		// 年比較
		if(a.year - b.year != 0)
			return a.year - b.year;
		// 月比較
		if(a.month - b.month != 0)
			return a.month - b.month;
		// 若年、月相同，則必剩下日期比較
		return a.day - b.day;		
	}
	// 印出物件
	public void print() {
		// 呼叫該物件的年、月、日成員變數
		System.out.printf("%04d/%02d/%02d", this.year, this.month, this.day);
	}

}
