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
