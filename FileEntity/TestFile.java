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
				System.out.println("指令輸入錯誤！");
			// 檢視所在目錄底下的所有檔名與目錄夾名稱
			else if (parser.getCommand() == Command.LS)
			{
				String total = fm.ls();
				// show total
				System.out.println(total);
			}
			// 進入某一個資料夾當中
			else if (parser.getCommand() == Command.CD)
			{
				String itemName = parser.getArgs()[0];
				fm.cd(itemName);
			}
			// 回上一層目錄
			else if (parser.getCommand() == Command.BACK)
			{
				fm.back();
			}
			// 建立一個空檔案
			else if (parser.getCommand() == Command.TOUCH)
			{
				String itemName = parser.getArgs()[0];
				fm.touch(itemName);
			}
			// 建立一個新的資料夾
			else if (parser.getCommand() == Command.MKDIR)
			{
				String itemName = parser.getArgs()[0];
				fm.mkdir(itemName);
			}
			// 根據關鍵字搜尋目錄夾與其子目錄夾中所有包含該關鍵字的檔案與資料夾
			// 大小寫不分
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
				System.out.println("指令" + parser.commandString());
				if (parser.getArgs() != null)
					for (int i = 0; i < parser.getArgs().length; i++)
						System.out.println(parser.getArgs()[i]);
			}
		}

	}

}
