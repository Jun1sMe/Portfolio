
public class Node
{
	private int key;
	private String value;
	private Node link;
	public Node(int key, String val)
	{
		this.key = key;
		this.value = val;
		this.link = null;
	}
	public String getValue()
	{
		return this.value;
	}
	public Node getLink()
	{
		return this.link;
	}
	public void setLink(Node link)
	{
		this.link = link;
	}
}
