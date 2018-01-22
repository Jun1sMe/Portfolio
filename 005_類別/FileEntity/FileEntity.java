
abstract public class FileEntity
{
	// �N����ݪ��ؿ���
	protected CDirectory parent;
	// �ɮשΥؿ��W��
	protected String name;
	
	public FileEntity(String name)
	{
		this.name = name;
	}
	
	public CDirectory getParent()
	{
		return parent;
	}
	
	public void setParent(CDirectory parent)
	{
		this.parent = parent;
	}
	// abstract method
	abstract public String getName();
	
	public String getPath()
	{
		return recurGetPath(parent) + "\\" + getName();
	}
	
	private String recurGetPath(CDirectory parent)
	{
		if(parent == null)
			return "";
		return recurGetPath(parent.getParent()) + "\\" + parent.getName();
	}
}
