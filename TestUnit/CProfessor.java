/*
 * �Ѯv�G�]�A�m�W�B¾���]level�A�Ʀr�A0���U�z�б¡B1���Ʊб¡B2���б¡^
 */
public class CProfessor extends CDepartment
{
	protected int level;
	// �]�m�Ѯv
	public CProfessor(String name, CUniversity parent, int level)
	{
		super(name, parent);
		this.level = level;
		this.title = getLevel(level);
	}
	
	public String getLevel(int level)
	{
		// 0���U�z�б¡B1���Ʊб¡B2���б¡^
		String str[] = {"�U�z�б�", "�Ʊб�", "�б�"};
		return str[this.level];
	}

}
