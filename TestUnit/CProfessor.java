/*
 * 老師：包括姓名、職等（level，數字，0為助理教授、1為副教授、2為教授）
 */
public class CProfessor extends CDepartment
{
	protected int level;
	// 設置老師
	public CProfessor(String name, CUniversity parent, int level)
	{
		super(name, parent);
		this.level = level;
		this.title = getLevel(level);
	}
	
	public String getLevel(int level)
	{
		// 0為助理教授、1為副教授、2為教授）
		String str[] = {"助理教授", "副教授", "教授"};
		return str[this.level];
	}

}
