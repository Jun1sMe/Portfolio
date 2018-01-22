import java.util.Arrays;
public class OrderParser extends CommandParser
{
	private int[] params;
	private int count;
	
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
		params = new int[10];	
	}
	public void setCommand(String commandLine)
	{
		// avoid exception
		if (commandLine == null)
			return;		
		if(count >= params.length)
			params = Arrays.copyOf(params, params.length * 2);
		this.parser(commandLine, params);
		
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
	public int parser(String s, int[] params)
	{
		if(toEnd(s) == 1)
		{
			// reduce ';'
			s = s.substring(0, s.length() - 1);
			// toUpper, split
			String[] tokens = toUpper(s);
			if(tokens[0].equals("LOAD"))
			{
				if(tokenNum(tokens) == 2)
				{
					String temp = tokens[1];
					if(toInt(temp))
					{
						params[count] = Integer.parseInt(temp);
						return 0;
					}					
				}
			}
			else if(tokens[0].equals("ADD"))
			{
				if(tokenNum(tokens) == 2)
				{
					String temp = tokens[1];
					if(toInt(temp))
					{
						params[count] += Integer.parseInt(temp);
						return 1;
					}				
				}
			}
			else if(tokens[0].equals("PRT"))
			{
				if(count + 1 >= params.length)
					params = Arrays.copyOf(params, params.length * 2);	
				params[count + 1] = params[count];
				count++;
				return 2;
			}
		}
		printSynError();
		return -1;			
	}
	
	public int getCount()
	{
		return this.count;
	}
	public int getParams(int index)
	{
		return this.params[index];
	}

}
