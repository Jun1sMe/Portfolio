import java.util.Scanner;
public class guessNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String player = "玩家";						// 宣告字串變數玩家、電腦
		String computer = "電腦";
		boolean again = true;						// 重新遊戲判斷
		int winP = 0, winC = 0;						// 勝利次數
		int who1st = randomAorB();					// 宣告who1st為判斷二選一
		int leftHandP, rightHandP, guessHandP = 0;
		System.out.print("隨機決定先後：");
		if(who1st == 0)
			System.out.print(player);
		else
			System.out.print(computer);			
		System.out.println("先。");
		System.out.println("======遊戲開始======");

		while(again)								// 遊戲循環
		{
			while(true)								// 出拳限制0或5
			{
				System.out.print("出拳（左手/右手）： ");
				leftHandP = scanner.nextInt();
				rightHandP = scanner.nextInt();
				if(leftHandP == 0 || leftHandP == 5)
					if(rightHandP == 0 || rightHandP == 5)
						break;
				System.out.println("小提示: 出拳僅能0或5");
			}		
			System.out.println(leftHandP + " " + rightHandP);
			
			if(who1st == 0)							// 玩家先攻，則猜拳語
			{
				while(true)
				{
					System.out.print("拳語：");
					guessHandP = scanner.nextInt();
					if(guessHandP == 0 || guessHandP == 5 || guessHandP == 10
							|| guessHandP == 15 || guessHandP == 20)
						if(guessHandP >= leftHandP + rightHandP)
							break;					
						else
							System.out.println("小提示: 拳語須大於或等於自己出拳總和");	
					else
						System.out.println("小提示: 拳語須為五的倍數，至多20");	
				}
				if(guessHandP == 0)
					System.out.println("沒有");
				else
					System.out.println(guessHandP);
			}
			
			int leftHandC = randomAorB();			// 判斷二選一: 左手
			int rightHandC = randomAorB();			// 判斷二選一: 右手
			int guessHandC = 0;						// 拳語須不小於和拳
			System.out.print("電腦: ");
			System.out.print(rightHandC + " ");
			System.out.print(leftHandC + " ");
			
			if(who1st == 5)							// 電腦先攻，則猜拳語
			{										// 拳語必為己拳+0~+10 
				guessHandC = randomAtoC() + leftHandC + rightHandC;			
				if(guessHandC == 0)
					System.out.print("沒有");
				else
					System.out.print(guessHandC);
			}			
			System.out.print("\n");
			
			// 總拳
			int sumHand = leftHandP + rightHandP + leftHandC + rightHandC;
			System.out.print("玩家: " + leftHandP + " " + rightHandP + " ");
			if(who1st == 0)							// 玩家先攻，顯示拳語
				System.out.print(guessHandP);
			System.out.println("\n總數: " + sumHand);	// 顯示總數

			if(who1st == 0 && guessHandP == sumHand)
			{										// 玩家先攻且猜對
				if(++winP < 2)						// 兩勝不顯示聽牌
					System.out.println(player + "聽牌");
			}
			else if(who1st == 5 && guessHandC == sumHand)
			{										// 電腦先攻且猜對
				if(++winC < 2)						// 兩勝不顯示聽牌
					System.out.println(computer + "聽牌");
			}
			else
			{
				System.out.println("下一回合");
				if(who1st == 0)						// 攻守互換
					who1st = 5;
				else
					who1st = 0;
			}				
			System.out.print("\n");					// 遊戲場次間距
			
			if(winP == 1 || winC == 1)				// 貼心提醒
			{
				System.out.print("注意! ");
				if(winP == 1)
					System.out.print(player);
				else
					System.out.print(computer);
				System.out.print("已聽牌\n");
			}	

			if(winP == 2 || winC == 2)				// 獲得兩勝即勝出
			{				
				if(winP == 2)
					System.out.println(player + "獲勝！");
				else
					System.out.println(computer + "獲勝！");
				
				while(true)							// 判斷繼續與否
				{
					System.out.print("請問是否繼續 (Y/N)？ ");
					char gameX = scanner.next().charAt(0);
					if(gameX == 'Y' || gameX == 'y')
					{
						winP = 0;						// 歸零
						winC = 0;
						System.out.print("\n");			// 遊戲場次間距
						break;
					}
					else if(gameX == 'N' || gameX == 'n')
					{
						again = false;					// 遊戲結束
						System.out.println("\n" + "遊戲結束。");
						break;
					}
					else
						System.out.println("\n" + "輸入錯誤! 重試: ");					
				}
				
			}

		}

	}
	
// 副函式區	
	public static int randomAorB()					// 判斷二選一: 回傳0或5
	{
		int A = (int)(Math.random() * 10);			// 強制轉換成整數變數，數值0~9
		if(A < 5)									// 0~4為判斷一、5~9為判斷二
			return 0;
		else
			return 5;
	}
	public static int randomAtoC()					// 判斷三選一: 回傳三個數值
	{
		int A = (int)(Math.random() * 4 + 1);		// 強制轉換成整數變數，數值1~4
		if(A == 1)									// 玩家出拳0, 0機會1/4
			return 0;
		else if(A >= 2 && A <= 3)					// 玩家出拳0, 5機會1/2
			return 5;
		else										// 玩家出拳5, 5機會1/4
			return 10;
	}
	
}
