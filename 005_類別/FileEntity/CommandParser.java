/* �ΨӸѪR���O */
public class CommandParser
{
	// variable
	private int command = Command.NONE;
	private String[] args = null; // �Ѽ�
	// storage command
	private String commandWord;

	// error code
	// 0 ->correct �U -1 ->���O���~ �U -2 ->�Ѽƿ��~
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
			// �i�J�ؿ��� ->CD = 1
			if (tokens[0].equals("cd") == true)
			{
				this.command = Command.CD;
				// �Ѽƿ��~: �u���J�@�ӫ��O�A�@�ӦW��
				if (tokens.length != 2)
					this.errorCode = -2;
			}
			// �h�^�W�h ->BACK = 2
			else if (tokens[0].equals("cd..") == true)
			{
				this.command = Command.BACK;
				// �Ѽƿ��~�A�ȯ��J�@�ӫ��O
				if (tokens.length != 1)
					this.errorCode = -2;
			}
			// �إ߷s�� ->TOUCH = 3
			else if (tokens[0].equals("touch") == true)
			{
				this.command = Command.TOUCH;
				// �Ѽƿ��~�A�ȯ��J�@�ӫ��O
				if (tokens.length != 2)
					this.errorCode = -2;
			}
			// �إ߷s�ؿ��� ->MKDIR = 4
			else if (tokens[0].equals("mkdir") == true)
			{
				this.command = Command.MKDIR;
				// �Ѽƿ��~: �u���J�@�ӫ��O�A�@�ӦW��
				if (tokens.length != 2)
					this.errorCode = -2;
			}
			// �C�X�ؿ������Ҧ��ɮ� ->LS = 5
			else if (tokens[0].equals("ls") == true)
			{
				this.command = Command.LS;
				// �Ѽƿ��~: �ȯ��J�@�ӫ��O
				if (tokens.length != 1)
					this.errorCode = -2;
			}
			// �j�M ->SEARCH = 6
			else if (tokens[0].equals("search") == true)
			{
				this.command = Command.SEARCH;
				// �Ѽƿ��~: �ȯ��J�@�ӫ��O
				if (tokens.length != 2)
					this.errorCode = -2;
			}
			// ���O���~
			else
			{
				this.errorCode = -1;
				return;
			}
			// set 
			commandWord = tokens[0];
			// ���O���ѼƩ�Jargs
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
