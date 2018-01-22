
public class StopWatch
{
	private long start, end;
	public StopWatch()
	{
		reset();
	}
	public void reset()
	{
		start = end = 0;
	}
	public void start()
	{
		start = System.currentTimeMillis();
	}
	public void end()
	{
		end = System.currentTimeMillis();
	}
	public long passTime()
	{
		return end - start;
	}
}
