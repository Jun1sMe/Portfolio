import java.util.Scanner;

public class TestStorage
{
	public static Scanner scanner = new Scanner(System.in);
	// 總店+分店總數初始化10家
	public static Store stores[] = new Store[10];

	public static void main(String[] args)
	{
		// 每家店實際營業中
		for (int i = 0; i < stores.length; i++)
			stores[i] = new Store();

		// initialize the first flow
		int flow = 0;
		int storeNum = 0;

		while (true)
		{

			System.out.println("「倉儲管理系統v2.0」");
			// 首次執行: 選擇分店
			if (flow == 0)
			{
				while (true)
				{
					System.out.print("請輸入分店代號(0~9): ");
					storeNum = scanner.nextInt();
					if (storeNum >= 0 && storeNum <= 9)
					{
						// stores[storeNum] = new Store();
						flow++;
						break;
					}
					System.out.println("輸入錯誤！");
				}
			}

			System.out.println("=====請選擇下列操作=====");
			System.out.print("1) 顯示所有資料\n" + "2) 增加商品資料\n" + "3) 出貨登錄\n" + "4) 進貨登錄\n" + "5) 離開系統\n>>>");
			int opt = scanner.nextInt();
			System.out.println("===================");

			// 顯示所有資料
			if (opt == 1)
			{
				for (int i = 0; i < stores.length; i++)
				{
					System.out.println("代號" + i + "分店: ");
					stores[i].showList();
				}
				// stores[storeNum].showList();

				System.out.print("是否進入其他分店進行操作(y/n): ");
				String changeStore = scanner.next();
				if (changeStore.equalsIgnoreCase("y"))
					flow = 0;
				
				System.out.println();
			}

			// 增加商品資料
			else if (opt == 2)
			{
				System.out.println("請輸入下列資訊:");
				String no;
				while (true)
				{
					System.out.print("商品編號: ");
					no = scanner.next();
					// 編號已存在
					if (stores[storeNum].search(no) != -1)
						System.out.print("該編號已新增，請重新輸入");
					else
						break;
				}

				System.out.print("商品名稱: ");
				String name = scanner.next();
				System.out.print("單價: ");
				int pri = scanner.nextInt();
				System.out.print("單位: ");
				String uni = scanner.next();
				System.out.print("製造商: ");
				String mak = scanner.next();
				stores[storeNum].add(no, name, pri, uni, mak);
				System.out.println();
			}
			// 出/進貨登錄: 系統會先顯示目前已經建立的商品，再要求使用者輸入商品
			else if (opt == 3 || opt == 4)
			{
				loadStuff(opt, storeNum);
			}
			// 離開系統
			else if (opt == 5)
			{
				System.out.println("感謝您使用本系統，\n再見!");
				break;
			} 
			else
				System.out.println("輸入錯誤，請重試。\n");
		}

	}

	// function: loading stuff
	public static void loadStuff(int opt, int storeNum)
	{
		// 系統會先顯示目前已經建立的商品
		if (stores[storeNum].showProduct())
		{
			// 商品編號
			String no;
			while (true)
			{
				System.out.print("請輸入商品編號: ");
				no = scanner.next();
				// 編號不存在
				if (stores[storeNum].search(no) == -1)
				{
					System.out.print("該編號不存在，");
					continue;
				}
				break;
			}
			System.out.print("請輸入商品");
			if (opt == 3)
				System.out.print("出");
			else
				System.out.print("進");
			System.out.print("貨數量: ");

			int numStock = scanner.nextInt();
			if (numStock < 1)
			{
				numStock = 0;
				System.out.println("操作失敗！\n");
			} 
			else
			{
				if (stores[storeNum].numStock(opt, no, numStock) == true)
					System.out.println("操作成功！\n");
				else
					System.out.println("商品無庫存！\n");
			}

		}
	}

}
