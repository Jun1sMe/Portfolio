
public class CommandParser
{
	// file in and out
	private String inFile, outFile;
	
	// constructor
	public CommandParser()
	{
		
	}
	public CommandParser(String commandLine)
	{
		this.setCommand(commandLine);
	}
	private void setCommand(String commandLine)
	{
		// avoid exception
		if (commandLine == null)
			return;

		// split into string
		String[] tokens = commandLine.split("\\s+");
		// T program.t p.out
		if (tokens.length ==  3)
		{
			if (tokens[0].toUpperCase().equals("T"))
			{
				// program.t代表指令檔
				if((tokens[1] = tokens[1].toLowerCase()).endsWith(".t"))
				{
					inFile = tokens[1];
					// p.out代表輸出檔則用來儲存輸出結果
					if((tokens[2] = tokens[2].toLowerCase()).endsWith(".out"))
					{
						outFile = tokens[2];
						return;
					}
				}
			}
		}
		printComError();			
	}

	public String getInFile()
	{
		return inFile;
	}
	public String getOutFile()
	{
		return outFile;
	}

	// 字串不符格式(T program.t p.out)
	public void printComError()
	{
		System.out.println("Command error!");
	}
	// T語言的敘述有誤(例如：錯誤的指令)
	public void printSynError()
	{
		System.out.println("Syntax error!");
	}

}
