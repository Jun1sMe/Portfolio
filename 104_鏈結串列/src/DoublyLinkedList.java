
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
		// �e�@�Ӹ`�I
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
		// �Ыؤ@�Ӹ�Ƹ`�I
		Node newNode = new Node(data);
		// �s�W�ܶ}�Y
		if(temp == this.first)	// �]�tfirst = null
		{
			newNode.setRightLink(this.first); 
			this.first = newNode;
			temp.setLeftLink(this.first);
			this.last = temp;
		}
		// �s�W�ܵ���
		else if(temp == null)
		{
			prev.setRightLink(newNode);
			newNode.setLeftLink(prev);
			this.last = newNode;
		}
		// �s�W�ܤ���
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
			System.out.println("����" + k++ + "��");
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
