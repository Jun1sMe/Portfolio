
public class DoublyLinkedList
{
	Node first, last;

	public DoublyLinkedList()
	{
		first = last = null; 
	}
	public DoublyLinkedList(String data)
	{
		last = first = new Node(data);
	}
	
	public void insertInOrdered(String data)
	{
		Node temp = first;
		// 前一個節點
		Node prev = null;
		while(temp != null)
		{
			if(temp.getRightLink() != null)
			{
				prev = temp;
				temp = temp.getRightLink();				
			}
			else
				break;
		}
		// 創建一個資料節點
		Node newNode = new Node(data);
		// 新增至開頭
		if(temp == this.first)	// 包含first = null
		{
			newNode.setRightLink(this.first); 
			this.first = newNode;
			temp.setLeftLink(this.first);
			this.last = temp;
		}
		// 新增至結尾
		else if(temp == null)
		{
			prev.setRightLink(newNode);
			newNode.setLeftLink(prev);
			this.last = newNode;
		}
		// 新增至中間
		else
		{
			newNode.setRightLink(temp);
			newNode.setLeftLink(prev);
			prev.setRightLink(newNode);
			temp.setLeftLink(newNode);
		}
	}
	// confirm the data
	public void getNode()
	{
		int k = 1;
		Node temp = first;
		while(temp != null && temp.getRightLink() != null)
		{
			System.out.printf("%5s\t", temp.getData());				
			temp = temp.getRightLink();
			System.out.println("執行" + k++ + "次");
		}
		System.out.println();		
	}
	public int getResult()
	{
		Node temp = first;
		int tempInt = 0;
		while(temp != null && temp.getRightLink() != null)
		{
			if(temp.getParser().equals("LOAD"))
				tempInt = temp.getValue();
			else if(temp.getParser().equals("ADD"))
				tempInt += temp.getValue();		
//			else
//				temp.setValue(" " + tempInt);
			temp = temp.getRightLink();
		}
		
		return tempInt;
	}

}
