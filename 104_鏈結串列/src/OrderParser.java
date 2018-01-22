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
	
	// a: 傳入字串的頭尾空白去掉，並將英文轉大寫字母。
	public String[] toUpper(String str)
	{
		return str.toUpperCase().split("\\s+");
	}
	// b: 是否為正整數的字串。
	// 如果是則回傳true，否則回傳false。
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
	// c: 是否全為T語言所定義的字元，且是否以分號結尾。
	// 不符上述條件者請回傳0，否則回傳1。
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
	// d: 計算s中字組（token）的個數。
	public int tokenNum(String[] str)
	{
		return str.length;
	}
	// e: 是否滿足T語言的指令格式，如果有錯誤地方請回傳-1
	// LOAD便回傳0，ADD則回傳1，PRT回傳2。
	// 如指令後有其他數字，便存到params之中。
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
