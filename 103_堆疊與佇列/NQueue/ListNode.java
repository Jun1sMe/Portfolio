
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
	//請提供必要的成員方法，用以取得private成員的資料內容。
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
