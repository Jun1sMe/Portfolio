
public class TestThread
{

	public static void main(String[] args)
	{
		NameCollector nameCollector = new NameCollector();
		MyRunnable myRunnable1 = new MyRunnable("A", nameCollector);
		MyRunnable myRunnable2 = new MyRunnable("B", nameCollector);
		MyRunnable myRunnable3 = new MyRunnable("C", nameCollector);		
		Thread myThread1 = new Thread(myRunnable1);
		Thread myThread2 = new Thread(myRunnable2);
		Thread myThread3 = new Thread(myRunnable3);
		myThread1.start();	// starting thread: runnable
		myThread2.start();	
		myThread3.start();
		// possible stop
		try
		{
			myThread1.join();
			myThread2.join();
			myThread3.join();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}		
		System.out.println("Main Thread Finished");
		System.out.println(nameCollector);
	}
}
