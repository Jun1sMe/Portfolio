
public class CFile extends FileEntity
{
	public CFile(String name, CDirectory parent)
	{
		super(name);
		this.parent = parent;
	}
	@Override public String getName()
	{
		return name;
	}
}
