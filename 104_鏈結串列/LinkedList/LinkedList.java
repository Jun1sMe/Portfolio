
public class LinkedList
{
	Node first;

	public LinkedList()
	{
		first = null;
	}
	public LinkedList(int num, int eng, int math)
	{
		first = new Node(num, eng, math);
	}
	public boolean isEmpty()
	{
		// first = null, is empty
		if(first == null)
			return true;
		return false;
	}
	// find/search
	public Node getNode(int keyword)
	{
		Node temp = first;
		while(temp != null)
		{
			// student number
			if(keyword == temp.getData()[0])
				return temp;
			temp = temp.getLink();
		}
		return null;		
	}
	// confirm the data
	public String getNode(boolean opt)
	{
		Node temp = first;
		String str = "";
		while(temp != null)
		{
			// output the file
			if(opt == true)
			{
				System.out.printf("%2d\t%3d\t%3d\t%3d\n", temp.getData()[0], temp.getData()[1], temp.getData()[2], (temp.getData()[1] + temp.getData()[2]) / 2);				
			}
			// output the console
			else
			{
				str += temp.getData()[0] + "\t" + temp.getData()[1] + "\t" + temp.getData()[2] + "\t" + (temp.getData()[1] + temp.getData()[2]) / 2 + "\n";
			}
			temp = temp.getLink();
		}
		return str;
	}

	public void insertAtFront(int num, int eng, int math)
	{
		// 動態配置節點並設定資料
		Node newNode = new Node(num, eng, math);
		// 將該節點指向開始位置
		newNode.setLink(this.first);
		// 更新開頭節點位置
		this.first = newNode;
	}
	public void insertInOrdered(int num, int eng, int math)
	{
		Node temp = first;
		// 前一個節點
		Node prev = null;
		while(temp != null)
		{
			// average
			if(eng + math > (temp.getData()[1] + temp.getData()[2]))
				break;
			prev = temp;
			temp = temp.getLink();
		}
		// 創建一個資料節點
		Node newNode = new Node(num, eng, math);
		// 新增至開頭
		if(temp == this.first)	// 包含first = null
		{
			newNode.setLink(this.first); 
			this.first = newNode;
		}
		// 新增至結尾
		else if(temp == null)
		{
			prev.setLink(newNode);
		}
		// 新增至中間
		else
		{
			newNode.setLink(temp);
			prev.setLink(newNode);
		}
	}
	public boolean delete(int num)
	{
		Node temp = first;
		Node prev = null;
		while(temp != null)
		{
			if(num == temp.getData()[0])
				break;
			prev = temp;
			temp = temp.getLink();
		}
		// 串列為空或是查無資料
		if(temp == null)
			return false;
		// 更新鏈結串列之first參考
		else if(temp == this.first)
			this.first = this.first.getLink();
		else
			prev.setLink(temp.getLink());
		return true;
	}
}
