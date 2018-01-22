
public class MyRunnable implements Runnable
{
	private String name;
	private CallBackInterface callBackInterface;
	
	public MyRunnable(String name, CallBackInterface callBackInterface)
	{
		this.name = name;
		this.callBackInterface = callBackInterface;
	}
	@Override public void run()
	{
		try
		{
			// horses' running time
			Thread.sleep(1000);
			synchronized(callBackInterface)
			{
				callBackInterface.sendMessage(name);
				System.out.println("Horse " + name + " arrives!");
			}
			
		}
		catch(InterruptedException e)
		{
			// sleep needs exception
			e.printStackTrace();
		}
	}

}
