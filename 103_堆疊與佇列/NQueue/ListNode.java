
public class ListNode
{
	
	private String data;
	private ListNode link;

	public ListNode()
	{
		this.link = null;
	}
	public ListNode(String s)
	{
		this.data = s;
		this.link = null;
	}
	//�д��ѥ��n��������k�A�ΥH���oprivate��������Ƥ��e�C
	public String getData()
	{
		return this.data;
	}
	public ListNode getLink()
	{
		return this.link;
	}
	public void setLink(ListNode link)
	{
		this.link = link;
	}
//	public void setData(String data)
//	{
//		this.data += " " + data;
//	}

}
