import java.util.Scanner;

public class TestUnit
{
	// 紀錄目前位置
	public static CUniversity cur;
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		// 宣告大學名稱
		CUniversity myUni = new CUniversity("OO大學");
		cur = myUni;
		// 狀態控制
		int flow = 0, optA = -1, optB = -1;

		while (true)
		{
			// 學校
			if (flow == 0)
			{
				if(optA == -1)
				{
					// 標頭(路徑)
					System.out.println(cur.getPath());
					optA++;
				}
				// 選單
				if(optA == 0)
					optA = cur.menu();
				// 1:新增
				if (optA == 1)
				{
					// 選單二
					System.out.print("1:學系, 2:行政單位, -1:取消: ");
					int optA3 = scanner.nextInt();
					// 學系
					if (optA3 == 1)
					{
						System.out.print("名稱：");
						String name = scanner.next();
						CUniversity temp = new CDepartment(name, myUni);
						myUni.add(temp);
						System.out.println("新增成功！\n");
						optA = 0;
					} 
					// 行政單位
					else if (optA3 == 2)
					{
						System.out.print("名稱：");
						String name = scanner.next();
						CUniversity temp = new CAdministration(name, myUni);
						myUni.add(temp);
						System.out.println("新增成功！\n");
						optA = 0;
					} 
					// 取消
					else if (optA3 == -1)
						optA = 0;
					// error
					else
						printError();
				}
				// 2:進入
				else if (optA == 2)
				{
					if (myUni.getDepartCount() == 0)
					{
						System.out.println("沒有任何資料！\n");
						optA = 0;
					} 
					else
					{
						// 顯示大學部門				
						int opt2 = myUni.showList();
						// 返回
						if (opt2 == -1)
							optA = 0;
						// error
						else if(opt2 <= 0 || opt2 > myUni.getDepartCount())
							printError();
						else
						{
							cur = myUni.getPos(opt2 - 1);
							System.out.println();
							flow = 1;
							optA = -1;
						}
					}
				}
				// 3:印出所有人員
				else if (optA == 3)
				{
					int count = 0;
					// Method1
//					((CUniversity) myUni.getDepartList()[i]).printAll();						
					// Method2
					for(int i = 0 ; i < myUni.getDepartCount(); i++)
						count += myUni.getPos(i).printAll();					
					
					if(count == 0)
						System.out.println("尚無資料");
					// new line
					System.out.println();					
					optA = 0;
				}
				// -1:結束
				else if (optA == -1)
				{
					System.out.println("感謝使用本系統。");
					break;
				}
				// error
				else
				{
					printError();
					optA = 0;
				}
				
			}
			// 部門
			if(flow == 1)
			{				
				if(optB == -1)
				{
					// 標頭、路徑
					System.out.println(cur.getPath());
					optB++;
				}
				if(optB == 0)
				{	
					int reply = cur.menu();
					// 選單： -1返回
					if(reply == -1)
					{
						System.out.println();
						cur = myUni;
						flow = 0;
						optA = -1;
						optB = -1;
					}
					// 4: print, 5: error
					else if(reply == 4 || reply == 5)
						continue;
					else
						System.out.println("新增成功！\n");
									
				}

			}

		}

	}
	// print error
	public static void printError()
	{
		System.out.println("Error! Try again.");
	}

}
