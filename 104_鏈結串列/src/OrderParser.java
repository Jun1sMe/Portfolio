import java.util.Arrays;
public class OrderParser extends CommandParser
{
	public final String dummySpace = "dummy";
	DoublyLinkedList myLinkedList;

	public OrderParser()
	{
		this.setData();
	}
	public OrderParser(String commandLine)
	{
		this.setData();	
		this.setCommand(commandLine);
	}
	public void setData()
	{	
		myLinkedList = new DoublyLinkedList(dummySpace);	
	}
	public void setCommand(String commandLine)
	{
		// avoid exception
		if (commandLine == null)
			return;		
		this.parser(commandLine);
		
	}
	
	// a: �ǤJ�r�ꪺ�Y���ťեh���A�ñN�^����j�g�r���C
	public String[] toUpper(String str)
	{
		return str.toUpperCase().split("\\s+");
	}
	// b: �O�_������ƪ��r��C
	// �p�G�O�h�^��true�A�_�h�^��false�C
	public boolean toInt(String str)
	{
		try
		{
			int i = Integer.parseInt(str);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	// c: �O�_����T�y���ҩw�q���r���A�B�O�_�H���������C
	// ���ŤW�z����̽Ц^��0�A�_�h�^��1�C
	public int toEnd(String str)
	{
		if(str.endsWith(";"))
		{
			String[] strArr = toUpper(str);
			int num = tokenNum(strArr);
			if( num >= 1 && num <= 2)
				return 1;
		}
		return 0;
	}
	// d: �p��s���r�ա]token�^���ӼơC
	public int tokenNum(String[] str)
	{
		return str.length;
	}
	// e: �O�_����T�y�������O�榡�A�p�G�����~�a��Ц^��-1
	// LOAD�K�^��0�AADD�h�^��1�APRT�^��2�C
	// �p���O�ᦳ��L�Ʀr�A�K�s��params�����C
	public int parser(String str)
	{
		if(toEnd(str) == 1)
		{
			// toUpper, split
			String[] tokens = toUpper(str);
			if(tokens[0].equals("LOAD"))
			{
				if(tokenNum(tokens) == 2)
				{
					String temp = tokens[1].substring(0, tokens[1].length() - 1);
					if(toInt(temp))
					{
						myLinkedList.insertInOrdered(str);
						return 0;
					}					
				}
			}
			else if(tokens[0].equals("ADD"))
			{
				if(tokenNum(tokens) == 2)
				{
					String temp = tokens[1].substring(0, tokens[1].length() - 1);
					if(toInt(temp))
					{
						myLinkedList.insertInOrdered(str);
						return 1;
					}				
				}
			}
			else if(tokens[0].substring(0, 3).equals(("PRT")))
			{
				myLinkedList.insertInOrdered(str);
				return 2;
			}
		}
		printSynError();
		return -1;			
	}

	public void printAll()
	{
		myLinkedList.getNode();
	}
	public int printResult()
	{
		return myLinkedList.getResult();
	}
	public Node getCurNode()
	{
		Node curNode = myLinkedList.last;
		return curNode;
	}

}
