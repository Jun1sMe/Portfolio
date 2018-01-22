
public class Node
{
	private int key, times;
	private String value;
//	private Node link;
	public Node(int key, String val)
	{
		this.key = key;
		this.value = val;
		this.times = 1;
//		this.link = null;
	}
	public String getValue()
	{
		return this.value;
	}
	public int getTimes()
	{
		return this.times;
	}
	public void setTimes()
	{
		this.times++;
	}
	public void setTimes(int times)
	{
		this.times = times;
	}
//	public Node getLink()
//	{
//		return this.link;
//	}
//	public void setLink(Node link)
//	{
//		this.link = link;
//	}
}
