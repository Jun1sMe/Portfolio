import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;
//import java.io.FileNotFoundException;
//import java.io.IOException;

public class TestTCode
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);		
		while(true)
		{
			try
			{
				System.out.println("Command:");
				String commandLine = scanner.nextLine();
				CommandParser parserCom = new CommandParser(commandLine);

				String inFile = parserCom.getInFile();
				String outFile = parserCom.getOutFile();
				// exception
				if(inFile == null || outFile == null)
					continue;
				
				// read file and buffered in
				FileReader fileRead = new FileReader(inFile);
				BufferedReader bufRead = new BufferedReader(fileRead);

				String tempStr;
				OrderParser orderList = new OrderParser();

				while ((tempStr = bufRead.readLine()) != null)
				{
					orderList.setCommand(tempStr);
				}
				// close file
				fileRead.close();

				FileWriter fileWrite = new FileWriter(outFile);
				BufferedWriter bufOutWrite = new BufferedWriter(fileWrite);

				int exeCount = orderList.getCount();
				for(int i = 0 ; i < exeCount ; i++)
				{
					// string in
					bufOutWrite.write(orderList.getParams(i) + "");
					bufOutWrite.newLine();				
				}
				bufOutWrite.flush();
				// close file
				fileWrite.close();
				System.out.println("Done");
			}

			catch(Exception e)
			{
				System.out.println("File Not Found");
			}
			
		} // end while

	}

}
