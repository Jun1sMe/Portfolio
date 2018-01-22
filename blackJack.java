package lesson12_2;
import java.util.Scanner;
public class blackJack {

	public static enum Round{
		PLAYER, DEALOR
	}
	public static enum Status{
		WON, LOST, TIE, BLACKJACK, INITIAL
	}
	public static Scanner input = new Scanner(System.in);
	public static Round rou = Round.PLAYER;
	public static Status sta;
	// 撲克牌最多52張、籌碼、投注
	public static int countPoker = 0 , chip, bet;
	public static int playerPoint, dealorPoint, playerCard, dealorCard;
	public static int[][] playerPoker = new int[5][2], dealorPoker = new int[5][2];	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int flow = 1, option = 1;
		/* :::testing:::.新牌.洗牌		 */		
		int[][] officialPoker = boxPoker();	
		printArr(officialPoker);
		shufflePoker(officialPoker);
		printArr(officialPoker);
		
		while(true)
		{
			// 重新進入
			if(flow == 0)
			{
				if(chip > 0 && countPoker <= 42 )
				{
					System.out.print("是否再玩一次（1:是/2:否）？");
					option = input.nextInt();
					System.out.println("\n");
				}
				else if(chip <= 0)
					option = 2;
				else if(countPoker > 42)
				{
					System.out.println("該局已結束，和官整理牌桌中..");
					option = 2;
				}

			}
			// 首次進入
			if(flow == 1)
			{
				System.out.println("Blackjack開始");
				do
				{
					System.out.print("您的籌碼：");
					chip = input.nextInt();
					if(chip < 1)
						System.out.println("麻煩貴賓籌措現金後再入場!");
					else
						System.out.println();
				}while(chip < 1);
				
				flow--;	
			}

	
			// Play again
			if(option == 1)
			{
				// 顯示初始狀態
				betDisplay(officialPoker);
				// 顯示持有牌、點數
				showAll(playerPoker, playerCard);
				// 玩家回合、持有牌少於五張、點數小於21
				while(rou == Round.PLAYER && playerCard < 5 && playerPoint < 21)
				{
					System.out.print("\n\n1) Hit. 2) Stay? ");
					int hitOrNot = input.nextInt();
					if(hitOrNot == 1)
					{
						playerPoker[playerCard++] = drawOne(officialPoker);
						// 顯示持有牌、點數
						showAll(playerPoker, playerCard);
						// Busted
						if(playerPoint > 21)
							sta = Status.LOST;
					}
					else if(hitOrNot == 2)
						rou = Round.DEALOR;
					else
						System.out.print("Error! Try again.");
				}
				

				if(sta != Status.BLACKJACK && sta != Status.LOST )
				{	
					rou = Round.DEALOR;
					System.out.println("\n\n莊家回合\n莊家的牌組：");
					
					// 莊家牌總點數小於17，則繼續發牌
					while(pointJudge(dealorPoker, dealorCard) < 17)
						dealorPoker[dealorCard++] = drawOne(officialPoker);
					// 顯示持有牌、點數
					showAll(dealorPoker, dealorCard);
					
					// 莊家未Blackjack
					if(sta != Status.BLACKJACK)
					{
	
						if(sta != Status.LOST)
						{
							if(playerPoint > dealorPoint || dealorPoint > 21)
								sta = Status.WON;
							else if(playerPoint < dealorPoint && dealorPoint <= 21)
								sta = Status.LOST;
							else
							{
								System.out.print("平手！");
								sta = Status.TIE;
							}
						}
					}
					else
						sta = Status.LOST;
									
				}
				// 雙方都Blackjack
				if(sta == Status.BLACKJACK && playerPoint == 21 && dealorPoint == 21)
					sta = Status.TIE;		
				
				if(sta == Status.WON || playerPoint == 21)
					System.out.println("\n玩家獲勝！\n您獲得的" + bet + "枚籌碼，您的籌碼剩 "
							+ (chip += bet) + " 枚。\n");
				else if(sta == Status.LOST || dealorPoint == 21)
					System.out.println("\n莊家獲勝！\n您損失的" + bet + "枚籌碼，您的籌碼剩 "
							+ (chip -= bet) + " 枚。\n");
				else if(sta == Status.TIE)
					System.out.println("\n平手！\n您獲得的" + bet + "枚籌碼，您的籌碼剩 "
							+ (chip) + " 枚。\n");
				
				// 初始化
				sta = Status.INITIAL;
				rou = Round.PLAYER;
				playerCard = 0;
				playerPoint = 0;
				dealorCard = 0;
				dealorPoint = 0;
				for(int k = 0; k < 5; k++)
				{
					playerPoker[k][0] = 0;
					playerPoker[k][1] = 0;
					dealorPoker[k][0] = 0;
					dealorPoker[k][1] = 0;
				}
				
			}
			// Leave
			else if(option == 2)
			{
				System.out.println("感謝您的遊玩，再見！");
				break;
			}
			else
				System.out.println("輸入錯誤! 請重試");
		}
		
	}

	// 副函式: 盒內牌組
	public static int[][] boxPoker() {
		// 撲克牌為52張牌，0 ->4種花色、1 ->13張牌值
		int pokerFace[][] = new int[52][2];
		for(int i = 0; i < pokerFace.length; i++)
		{
			// Spade ->0~12、Heart ->13~25、Diamond ->26~38、Club ->39~51
			pokerFace[i][0] = i / 13;
			pokerFace[i][1] = (i % 13) + 1;
		}
		return pokerFace;
	}
	// 副函式: 公正洗牌
	public static void shufflePoker(int[][] x) {
		for(int i = 0; i < x.length; i++)
		{
			// 將隨機取出的索引值丟入temp
			int ran = (int)(Math.random() * x.length);
			int[] temp = x[ran];
			x[ran] = x[i];
			x[i] = temp;
		}
	}
	// 副函式: 抽一張牌
	public static int[] drawOne(int[][] x) {
		return x[countPoker++];			
	}
	// 副函式: 初始狀態顯示
	public static void betDisplay(int[][] x) {
		do
		{
		System.out.print("投注：");
		bet = input.nextInt();
		if(bet > chip)
			System.out.println("貴賓籌碼不足，請重新下注");
		else
			System.out.println("");
		}while(bet > chip);
		
		System.out.println("洗牌完畢，開始發牌…\n莊家得2張牌\n玩家得2張牌：");
		
		// 莊家先給自己一副暗牌、明牌 →玩家
		dealorPoker[0] = drawOne(x);
		dealorPoker[1] = drawOne(x);
		dealorCard = 2;
		playerPoker[0] = drawOne(x);
		playerPoker[1] = drawOne(x);
		playerCard = 2;
		
	}
	// 副函式: 持有牌顯示
	public static void cardDisplat(int[][] y, int card) {
		for(int k = card - 1; k >= 0; k--)
		{
			// 末次不加','
			if(k != card - 1)
				System.out.print(", ");
			// 花色
			if(y[k][0] == 0)
				System.out.print("Spade ");
			else if(y[k][0] == 1)
				System.out.print("Heart ");
			else if(y[k][0] == 2)
				System.out.print("Diamond ");
			else if(y[k][0] == 3)
				System.out.print("Club ");
			// 牌值
			if(y[k][1] == 1)
				System.out.print("Ace");
			else if(y[k][1] == 11)
				System.out.print("Jack");
			else if(y[k][1] == 12)
				System.out.print("Queen");
			else if(y[k][1] == 13)
				System.out.print("King");
			else
				System.out.print(y[k][1]);		
		}
	
	}	
	// 副函式: 點數判斷
	public static int pointJudge(int[][] y, int count) {
		int point = 0, ace = 0;
		if(y[0][1] == 1 || y[0][1] == 11 || y[1][1] == 1 || y[1][1] == 11)
		{
			point = 21;
			sta = Status.BLACKJACK;
			return point;
		}
		else
		{
			for(int i = 0; i < count; i++)
			{
				if(y[i][1] == 11 || y[i][1] == 12 || y[i][1] == 13)
					point += 10;
				else
					point += y[i][1];
				
				// 持有第三張起
				if(i >= 2 && y[i][1] == 1)
					ace++;
			}
			// 有ACE的情況
			while(ace > 0 && (point + 10) < 21)
			{
				point += 10;
				if(ace == 1)
					break;
			}			
			return point;
		}
			
	}	
	// 副函式: 顯示持有牌及點數
	public static void showAll(int[][] poker, int card) {
		// 顯示持有牌
		cardDisplat(poker, card);
		// 顯示點數
		System.out.print("\nPoints: " + pointJudge(poker, card));
		if(sta == Status.BLACKJACK && pointJudge(poker, card) == 21)
			System.out.println("(Blackjack) ");
		else if(pointJudge(poker, card) > 21)
			System.out.println("(Busted)");
			
		if(rou == Round.PLAYER)
			playerPoint = pointJudge(poker, card);
		else if(rou == Round.DEALOR)
			dealorPoint = pointJudge(poker, card);	
	}
	
	// 副函式: 輸出
	public static void printArr(int[][] x) {
		for(int i = 0; i < x.length; i++)
		{
			for(int j = 0; j < x[i].length; j++)
				System.out.print(x[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}
}
