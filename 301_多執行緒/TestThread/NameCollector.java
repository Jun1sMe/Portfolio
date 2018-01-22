import java.util.ArrayList;

public class NameCollector implements CallBackInterface
{
	private ArrayList<String> nameList;
	public NameCollector()
	{
		nameList = new ArrayList<String>();
	}
	@Override public void sendMessage(String str)
	{
		nameList.add(str);
	}
	@Override public String toString()
	{
		String str = "";
		for(int i = 0; i < nameList.size(); i++)
		{
			str += nameList.get(i) + "\n";
		}
		return str;
	}
}
