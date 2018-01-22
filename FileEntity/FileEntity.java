
abstract public class FileEntity
{
	// 代表所屬的目錄夾
	protected CDirectory parent;
	// 檔案或目錄名稱
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
