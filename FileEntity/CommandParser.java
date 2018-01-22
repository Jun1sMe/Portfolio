/* ノㄓ秆猂 */
public class CommandParser
{
	// variable
	private int command = Command.NONE;
	private String[] args = null; // 把计
	// storage command
	private String commandWord;

	// error code
	// 0 ->correct  -1 ->岿粇  -2 ->把计岿粇
	private int errorCode = 0;
	
	// constructor
	public CommandParser()
	{
		
	}

	// constructor
	public CommandParser(String commandLine)
	{
		this.setCommand(commandLine);
	}

	// method
	private void setCommand(String commandLine)
	{
		// avoid exception
		if (commandLine == null)
			return;

		// split into string
		// '\s' means between space, and '+' means space can over 'one'
		String[] tokens = commandLine.split("\\s+");

		// tokens exists
		if (tokens.length > 0)
		{
			// 秈ヘ魁Ж ->CD = 1
			if (tokens[0].equals("cd") == true)
			{
				this.command = Command.CD;
				// 把计岿粇: 块嘿
				if (tokens.length != 2)
					this.errorCode = -2;
			}
			// 癶糷 ->BACK = 2
			else if (tokens[0].equals("cd..") == true)
			{
				this.command = Command.BACK;
				// 把计岿粇度块
				if (tokens.length != 1)
					this.errorCode = -2;
			}
			// ミ穝郎 ->TOUCH = 3
			else if (tokens[0].equals("touch") == true)
			{
				this.command = Command.TOUCH;
				// 把计岿粇度块
				if (tokens.length != 2)
					this.errorCode = -2;
			}
			// ミ穝ヘ魁Ж ->MKDIR = 4
			else if (tokens[0].equals("mkdir") == true)
			{
				this.command = Command.MKDIR;
				// 把计岿粇: 块嘿
				if (tokens.length != 2)
					this.errorCode = -2;
			}
			// ヘ魁Жい┮Τ郎 ->LS = 5
			else if (tokens[0].equals("ls") == true)
			{
				this.command = Command.LS;
				// 把计岿粇: 度块
				if (tokens.length != 1)
					this.errorCode = -2;
			}
			// 穓碝 ->SEARCH = 6
			else if (tokens[0].equals("search") == true)
			{
				this.command = Command.SEARCH;
				// 把计岿粇: 度块
				if (tokens.length != 2)
					this.errorCode = -2;
			}
			// 岿粇
			else
			{
				this.errorCode = -1;
				return;
			}
			// set 
			commandWord = tokens[0];
			// ぇ把计args
			if (tokens.length - 1 > 0)
			{
				this.args = new String[tokens.length - 1];
				for (int i = 1; i < tokens.length; i++)
					this.args[i - 1] = tokens[i];
			}
		}
	}

	public int getCommand()
	{
		return command;
	}

	public boolean isValid()
	{
		if (errorCode == 0)
			return true;
		return false;
	}

	public String commandString()
	{
		return commandWord;
	}

	public String[] getArgs()
	{
		return args;
	}
}
