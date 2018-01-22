
public class MyThread extends Thread
{

	public MyThread()
	{
		// TODO Auto-generated constructor stub
	}
	@Override public void run()
	{
		try
		{
			sleep(1000);		// pause 1s
			System.out.println("Hello World!");
		}
		catch(InterruptedException e)
		{
			// sleep needs exception
			e.printStackTrace();
		}
	}

}
