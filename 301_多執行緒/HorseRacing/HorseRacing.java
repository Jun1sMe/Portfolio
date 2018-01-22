import java.util.Scanner;
import java.util.ArrayList;

public class HorseRacing
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		NameCollector nameCollector = new NameCollector();
		ArrayList<String> racer = new ArrayList<String>();
		ArrayList<Thread> myThread = new ArrayList<Thread>();
		
		while(true)
		{
			System.out.print("Input racer(-1 to stop): ");
			String tmp = scan.next();
			if(tmp.equals("-1"))
				break;
			racer.add(tmp);	
		}
		// no one play
		if(racer.size() == 0)
		{
			System.out.println("No contestant!");
			return;
		}
		System.out.println("\nGaming..");
		for(int i = 0; i < racer.size(); i++)
		{
			myThread.add(new Thread(new MyRunnable(racer.get(i), nameCollector)));
		}
		for(int i = 0; i < racer.size(); i++)
		{
			myThread.get(i).start();
		}
		try
		{
			for(int i = 0; i < racer.size(); i++)
			{
				myThread.get(i).join();
			}
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}		
		System.out.println("Order:");
		System.out.println(nameCollector);


	}

}
