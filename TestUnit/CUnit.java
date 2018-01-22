/*
 * �j�ǲ�´�[�c
 */
import java.util.Scanner;
abstract class CUnit
{
	protected String name;	//���W��
	protected CUniversity parent;	//���ݳ��
	protected String title;	// ¾��
	protected Scanner scanner = new Scanner(System.in);

	public CUnit(String name)
	{
		this.name = name;
	}
	public void setParent (CUniversity parent) {
		this.parent = parent;
	}
	
	public abstract int menu();		//�L�X�ӳ��������
		
	public CUnit getParent()			// ���o�ثe��m
	{
		return parent;
	}
	public String getName()			// ���o�ӦW��
	{
		return name;
	}
	public String getTitle()
	{
		return title;
	}
	public String getPath()			// ��ܸ��|
	{
		String par = recurGetPath(parent);
		if(par == "")
			return getName() + "\n========";
		return par + getName() + ":\n========"; 
	}
	public String recurGetPath(CUnit parent)
	{
		if(parent == null)
			return "";
		return recurGetPath(parent.getParent()) + parent.getName() + ">";
	}
	
}
