
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
		// �ʺA�t�m�`�I�ó]�w���
		Node newNode = new Node(num, eng, math);
		// �N�Ӹ`�I���V�}�l��m
		newNode.setLink(this.first);
		// ��s�}�Y�`�I��m
		this.first = newNode;
	}
	public void insertInOrdered(int num, int eng, int math)
	{
		Node temp = first;
		// �e�@�Ӹ`�I
		Node prev = null;
		while(temp != null)
		{
			// average
			if(eng + math > (temp.getData()[1] + temp.getData()[2]))
				break;
			prev = temp;
			temp = temp.getLink();
		}
		// �Ыؤ@�Ӹ�Ƹ`�I
		Node newNode = new Node(num, eng, math);
		// �s�W�ܶ}�Y
		if(temp == this.first)	// �]�tfirst = null
		{
			newNode.setLink(this.first); 
			this.first = newNode;
		}
		// �s�W�ܵ���
		else if(temp == null)
		{
			prev.setLink(newNode);
		}
		// �s�W�ܤ���
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
		// ��C���ũάO�d�L���
		if(temp == null)
			return false;
		// ��s�쵲��C��first�Ѧ�
		else if(temp == this.first)
			this.first = this.first.getLink();
		else
			prev.setLink(temp.getLink());
		return true;
	}
}
