/*
 * 行政人員：包括姓名、職稱（position）
 */
public class CFaculty extends CUniversity
{	
	// 設置行政
	public CFaculty(String name, CUniversity parent, String title)
	{
		super(name, parent);
		this.title = title;
	}	
		
}
