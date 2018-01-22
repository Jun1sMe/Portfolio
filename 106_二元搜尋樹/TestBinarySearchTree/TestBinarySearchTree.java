import java.util.Scanner;

public class TestBinarySearchTree
{

	public static void main(String[] args)
	{		
		Scanner scanner = new Scanner(System.in);
		BinaryTree testBinaryTree = new BinaryTree();
		while(true)
		{
			System.out.print("Command: ");
			String input = scanner.next();
			if(input.length() == 1)
			{
				input = input.toLowerCase();
				// 輸入'i’：新增節點,可輸入姓名, 電話, 依據姓名字母順序插入節點(輸入姓名如重覆，請印出錯誤訊息)
				if(input.equals("i"))
				{
					System.out.print("Name: ");
					String name = scanner.next();
					// name don't exist
					if(testBinaryTree.SearchNode(testBinaryTree.getRoot(), name) == null)
					{
						System.out.print("Phone: ");
						String phone = scanner.next();
						if(isPhone(phone))			// phone is valid
						{
							testBinaryTree.insertNode(name, phone);
							printDone();
							continue;
						}					
					}
					else
					{
						System.out.println("Name exists!");
						continue;
					}
				}
				// 輸入'd’：接著輸入姓名，可將一筆資料節點中之姓名相同者刪除(假設輸入之姓名不會重覆)
				else if(input.equals("d"))
				{
					System.out.print("Name: ");
					String name = scanner.next();
					TreeNode temp = testBinaryTree.SearchNode(testBinaryTree.getRoot(), name);
					if(temp != null)		// name don't exist
					{
						testBinaryTree.deleteNode(name);
						printDone();
					}
					else
						printNoData();
					continue;
				}
				// 輸入'f’：接著輸入一個姓名，可將一筆資料節點中之姓名相同者印出資料
				else if(input.equals("f"))
				{
					System.out.print("Name: ");
					String name = scanner.next();
					TreeNode temp = testBinaryTree.SearchNode(testBinaryTree.getRoot(), name);
					if(temp != null)		// name don't exist
						System.out.println(temp);
					else
						printNoData();
					continue;						
				}
				// 輸入'l’：依據姓名字母順序印出所有節點內容
				else if(input.equals("l"))
				{
					testBinaryTree.printInorder(testBinaryTree.getRoot());
					continue;
				}
				// 輸入'q’：讀取離開程式
				else if(input.equals("q"))
				{
					System.out.println("Thank you for using.\nBye!");
					break;
				}
			}
			printError();		
		}
	}
	public static void printNoData()
	{
		System.out.println("No data.");
	}
	public static void printDone()
	{
		System.out.println("Success!");
	}
	public static void printError()
	{
		System.out.println("Error! Try again.");
	}
	// confirm phone
	public static boolean isPhone(String phone)
	{
		if(phone.length() >= 1 && phone.length() <= 10)
		{
			char[] tempCh = phone.toCharArray();
			int count = 0;
			for(int i = 0 ; i < tempCh.length ; i++) 
			{
				if(tempCh[i] - '0' >= 0 && tempCh[i] - '9' <= 0)
					count++;
			}
			if(count == tempCh.length)
				return true;
		}
		return false;
	}
}
