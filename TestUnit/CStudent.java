/*
 * 學生：包括姓名、學號（字串）、入學年份（數字，西元）
 */
public class CStudent extends CDepartment
{
	protected String stuNum;
	protected int year;
	// 設置學生
	public CStudent(String name, CUniversity parent, String num, int year)
	{
		super(name, parent);
		this.title = "學生";
		this.year = year;
		this.stuNum = num;
	}
	
	public int getYear()
	{
		return this.year;
	}
	public String getStuNum()
	{
		return this.stuNum;
	}
	
}
