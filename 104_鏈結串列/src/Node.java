/*
 * record node
 */
public class Node
{
	String data;
	Node leftLink;
	Node rightLink;
	
	public Node(String data)
	{
		this.data = data;
		this.leftLink = null;
		this.rightLink = null;
	}
	public void setLeftLink(Node leftLink)
	{
		this.leftLink = leftLink;
	}
	public void setRightLink(Node rightLink)
	{
		this.rightLink = rightLink;
	}
	public Node getLeftLink()
	{
		return this.leftLink;
	}
	public Node getRightLink()
	{
		return this.rightLink;
	}
	public String getData()
	{
		return this.data;
	}
	public int getValue()
	{
		String[] str = this.data.split("\\s");	
		if(str.length == 2)
			return Integer.parseInt(str[1].replaceAll(";", ""));
		return 0;
	}
	public void setValue(String str)
	{
		this.data += str; 
	}
	public String getParser()
	{
		String[] str = this.data.split("\\s");
		if(str.length >= 1 && str.length <= 2)
			return str[0].replaceAll(";", "");
		return "";
	}
	
	
}
