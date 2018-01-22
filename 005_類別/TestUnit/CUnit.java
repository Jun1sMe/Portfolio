/*
 * 大學組織架構
 */
import java.util.Scanner;
abstract class CUnit
{
	protected String name;	//單位名稱
	protected CUniversity parent;	//所屬單位
	protected String title;	// 職位
	protected Scanner scanner = new Scanner(System.in);

	public CUnit(String name)
	{
		this.name = name;
	}
	public void setParent (CUniversity parent) {
		this.parent = parent;
	}
	
	public abstract int menu();		//印出該單位相關資料
		
	public CUnit getParent()			// 取得目前位置
	{
		return parent;
	}
	public String getName()			// 取得該名稱
	{
		return name;
	}
	public String getTitle()
	{
		return title;
	}
	public String getPath()			// 顯示路徑
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
