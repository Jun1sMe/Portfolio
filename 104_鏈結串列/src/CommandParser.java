
public class CommandParser
{
	// file in and out
	private String inFile;
	
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
		if (tokens.length ==  2)
		{
			if (tokens[0].toUpperCase().equals("T"))
			{
				// program.t�N����O��
				if((tokens[1] = tokens[1].toLowerCase()).endsWith(".t"))
				{
					inFile = tokens[1];
					return;
				}
			}
		}
		printComError();			
	}

	public String getInFile()
	{
		return inFile;		
	}

	// �r�ꤣ�Ů榡(T program.t)
	public void printComError()
	{
		System.out.println("Command error!");
	}
	// T�y�����ԭz���~(�Ҧp�G���~�����O)
	public void printSynError()
	{
		System.out.println("Syntax error!");
	}

}
