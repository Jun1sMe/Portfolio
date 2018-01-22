
public class NQueue
{
	private ListNode front, rear;  //Pop�qfront��, Push�qrear�[

	public NQueue()
	{
		front = rear = null;
	}
	public void push(String d)
	{
		ListNode temp = new ListNode(d);
		if(isEmpty())
			front = rear = temp;
		else
		{
			rear.setLink(temp);
			rear = temp;				
		}
	}
	public String eject()
	{
		if(isEmpty())
			return "";
		ListNode temp = front;
		front = temp.getLink();
		return temp.getData();
	}
	public boolean isEmpty()	//�ˬd��C�O�_���Ū�
	{
		if(front == null)
			return true;
		return false;
	}
	public String getWord(char lowChar)
	{
		ListNode temp, prev;
		int count;
		int random = -1;
		do
		{
			count = 0;
			temp = front;
			prev = null;
			while(temp != null)
			{
				if(temp.getData().toLowerCase().charAt(0) == lowChar)
				{
					count++;					
					if(random == count)
					{
						if(prev != null)
							prev.setLink(temp.getLink());
						else		// prev = null
							front = temp.getLink();
						return temp.getData();
					}
				}
				prev = temp;
				temp = temp.getLink();
			}
			random = (int)(Math.random() * count) + 1;	
		}while(count != 0);
		return "";
		
	}
	public void output()		//�L�X��C���Ҧ�������
	{
		ListNode temp;
		char upChar = 'A';	// upChar++
		int count;
		String str = "";
		while(upChar <= 'Z')
		{
			temp = front;
			count = 0;
			while(temp != null)
			{
				if(temp.getData().toUpperCase().charAt(0) == upChar)
				{
					if(count == 0)
					{
						str += "\n" + upChar + ":\n";
						count++;
					}
					str += temp.getData() + " ";
				}
				temp = temp.getLink();
			}
			upChar++;			
		}
		if(!str.equals(""))
			System.out.print(str + "\n");
	}
	public static int isValue(String str)	//�P�_�r�����^��
	{
		str = str.toLowerCase();
		if(str.charAt(0) - 'a' >= 0 && str.charAt(0) - 'z' <= 0)
			return str.charAt(0) - 'a';
		return -1;
	}

}
