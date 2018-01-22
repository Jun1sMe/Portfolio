// �|���ͤ�
public class MemberBD {
	// ���K����: �~�B��B��
	private int year, month, day;
	// �غc�l: �I�s�覡�A�z�L����k�ק��Ƥ��e
	public MemberBD(int y, int m, int d) {
		this.setData(y, m, d);
	}
	// ��g ->�غc�l�禡
	public void setData(int y, int m, int d) {
		// �]�w��Ȭ�1
		year = month = day = 1;
		if(year >= 1)
			year = y;
		if(m >= 1 && m <= 12)
			month = m;
		if(MemberBD.isValid(y, m, d) == true)
			day = d;
	}
	// �ˬd����榡�B���e, false��ܤ���
	public static boolean isValid(int y, int m, int d) {
		// �H�}�C�����C�뤧�Ѽ�
		int days[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		// �~�B��D���`��
		if(y <= 0 || m <= 0 || m > 12)
			return false;
		
		// �G�뤧�~������
		if(m != 2)
		{
			// �Ӥ뤧�Ѽ�
			if(d <= 0 || d > days[m])
				return false;
			return true;
		}
		// �G�붷�p�J�|�~�Q��:
		// �褸�~���H4�i�㰣�B���H100���i�㰣�A��
		// �褸�~���H400�i�㰣
		if((y % 4 == 0 && y % 100 != 0) || y % 100 == 0)
		{
			if(d <= 0 || d > 29)
				return false;
			return true;
		}
		// ���~
		if(d <= 0 || d > days[m])
			return false;
		return true;
	}
	// Main function�i���Ϊ��ƭ�: �~�B��B��
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public int getDay() {
		return day;
	}
	// �^�ǼƦr��ܤ��������G: 
	// �p��0 ->a ���� | �j��0 ->a ���� | 0 ->�ۦP
	public static int compare(MemberBD a, MemberBD b) {
		// �~���
		if(a.year - b.year != 0)
			return a.year - b.year;
		// ����
		if(a.month - b.month != 0)
			return a.month - b.month;
		// �Y�~�B��ۦP�A�h���ѤU������
		return a.day - b.day;		
	}
	// �L�X����
	public void print() {
		// �I�s�Ӫ��󪺦~�B��B�馨���ܼ�
		System.out.printf("%04d/%02d/%02d", this.year, this.month, this.day);
	}

}
