import java.util.Scanner;

public class TestRPG
{
	public static int num = 5;
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		// 金額，生命數
		int cash = 0, live = num, enLive = num;
		// 輸入英雄
		RPGGame RPG = new RPGGame();		
		for(int i = 0 ; i < num ; i++)
		{
			System.out.print("請輸入第" + (i + 1) + "位英雄姓名：");
			String inName = scanner.next();
			while(true)
			{
				System.out.print("請輸入第" + (i + 1) + "位英雄職業（1=盜賊、2=劍士、3=魔法師）：");
				int inJob = scanner.nextInt();		
				if(inJob >= 1 && inJob <= 3)
				{
					RPG.cha[i] = new SChampion(inName, inJob);
					break;
				}
				printError();				
			}			
		}
		
		// 顯示怪物
		RPG.showMon();
		
		String[] round = {"一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二", "十三", "十四", "十五"};
		int roundIndex = 0;
		while(true)
		{
			// 回合
			if(roundIndex < 15)
				System.out.println("\n第" + round[roundIndex++] + "回合\n玩家先攻");
			else
				System.out.println("\n第" + (roundIndex + 1) + "回合\n玩家先攻");
			// 玩家攻擊準備
			int target[] = new int[num];
			for(int i = 0 ; i < num; i++)
			{
				// dead
				if(RPG.cha[i].getHp() <= 0)
					continue;
				
				System.out.print(RPG.cha[i].getName() + " 攻擊對象：1)自動, 2)指定對象: ");
				int opt = scanner.nextInt();
				if(opt == 1)
				{
					while(true)
					{
						int result = (int)(Math.random() * enLive);
						if(RPG.mon[result].getHp() > 0)
						{
							target[i] = result;
							break;
						}
					}		
				}
				else if(opt == 2)
				{
					while(true)
					{
						RPG.hitMon();
						int opt2 = scanner.nextInt();
						if(opt2 >= 1 && opt2 <= 5)
						{
							// storage index
							target[i] = opt2 - 1;
							break;
						}
						else
							printError();
					}
				}
				System.out.println(RPG.cha[i].getName() + " 預備攻擊 " + RPG.mon[target[i]].getName());
			}
			System.out.println("\n玩家攻擊開始！");
			// 攻擊
			for(int i = 0 ; i < num ; i++)
			{
				// dead
				if(RPG.cha[i].getHp() <= 0)
					continue;
				
				String player = RPG.cha[i].getName();
				String playerJob = RPG.cha[i].getJob();
				int playerAtk = RPG.cha[i].getAttack();
				String bot = RPG.mon[target[i]].getName();
				int botHp = RPG.mon[target[i]].getHp();
				
				if(botHp <= 0)
					continue;
				
				int fee = (int)(Math.random() * 10);
				if(fee > 8)
					System.out.println(bot + " 對" + player + " 發動攻擊，" + player + "閃避。");
				else
				{
					int afterAtk = botHp - playerAtk;
					// still alive
					if(afterAtk > 0)
					{
						System.out.println(player + " 對 " + bot + "發動" + playerJob + "攻擊，造成" + bot + " " + playerAtk + "損傷。");					
						RPG.mon[target[i]].setHp(afterAtk);				
					}
					else
					{
						int botCoin = RPG.mon[target[i]].getCoin();
						System.out.println(player + " 對 " + bot + "發動" + playerJob + "攻擊，造成" + bot + " " + playerAtk + "損傷，擊潰" + bot + "，得" + botCoin + "元。");					
						RPG.mon[target[i]].setHp(0);
						// 金錢
						RPG.cha[i].setCoin(botCoin);
						cash += botCoin;
						enLive--;
						if(enLive == 0)
						{
							// 最後請輸出遊戲所得之錢幣
							System.out.println("怪物全數消滅！\n您贏得勝利，獲得 " + cash + " 元。");
							return;
						}
					}
				}
				
			}
			// 怪物攻擊
			System.out.println("\n怪物後攻");
			for(int i = 0 ; i < num ; i++)
			{
				// dead
				if(RPG.mon[i].getHp() <= 0)
					continue;
				
				int victim;				
				while(true)
				{
					victim = (int)(Math.random() * live);
					if(RPG.cha[victim].getHp() > 0)
						break;
				}
								
				String bot = RPG.mon[i].getName();
				int botAtk = RPG.mon[i].getAttack();
				String player = RPG.cha[victim].getName();
				int playerHp = RPG.cha[victim].getHp();
				
				int fee = (int)(Math.random() * 10);
				if(fee > 8)
					System.out.println(bot + " 對" + player + " 發動攻擊，" + player + "閃避。");
				else
				{
					int afterAtk = playerHp - botAtk;
					// still alive
					if(afterAtk > 0)
					{
						System.out.println(bot + " 對" + player + " 發動攻擊，造成" + player + " " + botAtk + "損傷。");
						RPG.cha[victim].setHp(afterAtk);	
					}
					else
					{
						System.out.println(bot + " 對" + player + " 發動攻擊，造成" + player + " " + botAtk + "損傷，擊潰" + player);
						RPG.cha[victim].setHp(0);
						live--;
						if(live == 0)
						{
							System.out.println("全軍遭到殲滅！\n遊戲結束");
							return;
						}
					}
				}
				

			}
			// 回合終了
			System.out.println("\n第一回合結束\n英雄隊得" + cash + "元，狀態：共" + live + "人存活");
			for(int i = 0 ; i < num ; i++)
			{
				// dead
				if(RPG.cha[i].getHp() <= 0)
					continue;
				String player = RPG.cha[i].getName();
				int playerM = RPG.cha[i].getCoin();
				int playerHp = RPG.cha[i].getHp();			
				System.out.println(player +" (M: " + playerM + "; HP: " + playerHp + ")");
			}
			
		}	

	}
	// print error
	public static void printError()
	{
		System.out.println("Error! Try again.");
	}
}
