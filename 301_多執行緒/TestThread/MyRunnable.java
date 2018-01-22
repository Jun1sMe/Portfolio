
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
			Thread.sleep(1000);	// sleep is static method
			synchronized(callBackInterface)
			{
				callBackInterface.sendMessage("Thread: " + name + " Finished");				
			}
		}
		catch(InterruptedException e)
		{
			// sleep needs exception
			e.printStackTrace();
		}
	}

}
