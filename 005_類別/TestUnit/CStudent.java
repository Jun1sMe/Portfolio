/*
 * �ǥ͡G�]�A�m�W�B�Ǹ��]�r��^�B�J�Ǧ~���]�Ʀr�A�褸�^
 */
public class CStudent extends CDepartment
{
	protected String stuNum;
	protected int year;
	// �]�m�ǥ�
	public CStudent(String name, CUniversity parent, String num, int year)
	{
		super(name, parent);
		this.title = "�ǥ�";
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
