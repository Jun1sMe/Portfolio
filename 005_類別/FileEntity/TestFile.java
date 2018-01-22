import java.util.Scanner;

public class TestFile
{
	// build CFileManager obj
	public static CFileManager fm = new CFileManager();
	// private static Object String;

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		while (true)
		{
			// String strDisplay = "\\root";
			System.out.print(fm.curDir.getPath() + ">");
			// fm.getCurrentDir();
			
			// get '\s+'
			String commandLine = scanner.nextLine();
			CommandParser parser = new CommandParser(commandLine);

			if (parser.isValid() == false)
				System.out.println("���O��J���~�I");
			// �˵��Ҧb�ؿ����U���Ҧ��ɦW�P�ؿ����W��
			else if (parser.getCommand() == Command.LS)
			{
				String total = fm.ls();
				// show total
				System.out.println(total);
			}
			// �i�J�Y�@�Ӹ�Ƨ���
			else if (parser.getCommand() == Command.CD)
			{
				String itemName = parser.getArgs()[0];
				fm.cd(itemName);
			}
			// �^�W�@�h�ؿ�
			else if (parser.getCommand() == Command.BACK)
			{
				fm.back();
			}
			// �إߤ@�Ӫ��ɮ�
			else if (parser.getCommand() == Command.TOUCH)
			{
				String itemName = parser.getArgs()[0];
				fm.touch(itemName);
			}
			// �إߤ@�ӷs����Ƨ�
			else if (parser.getCommand() == Command.MKDIR)
			{
				String itemName = parser.getArgs()[0];
				fm.mkdir(itemName);
			}
			// �ھ�����r�j�M�ؿ����P��l�ؿ������Ҧ��]�t������r���ɮ׻P��Ƨ�
			// �j�p�g����
			else if (parser.getCommand() == Command.SEARCH)
			{
				String itemName = parser.getArgs()[0];
				String[] s = fm.search(itemName);
				if (s != null)
				{
					for (int i = 0; i < s.length; i++)
						System.out.println(s[i]);
					System.out.println();
				}
			}
			//
			else
			{
				System.out.println("���O" + parser.commandString());
				if (parser.getArgs() != null)
					for (int i = 0; i < parser.getArgs().length; i++)
						System.out.println(parser.getArgs()[i]);
			}
		}

	}

}
