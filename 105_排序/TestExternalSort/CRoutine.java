
public class CRoutine
{
	private String busData;
	private int dep, file;
	public CRoutine(String input, int departure)
	{
		this.busData = input;
		this.dep = departure;
	}
	public CRoutine(String input, int departure, int file)
	{
		this.busData = input;
		this.dep = departure;
		this.file = file;
	}
	public int getDep()
	{
		return this.dep;
	}
	public int getFile()
	{
		return this.file;
	}
	@Override public String toString()
	{
		return this.busData;
	}

}
