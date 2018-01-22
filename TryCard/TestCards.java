import java.util.Scanner;

public class TestCards
{
	public static void main(String[] args)
	{
		int flow = 1;
		int round = 1;
		// build a object and generate cards
		Cards playCard = new Cards();
		// build object array for storing cards
		Card player[] = new Card[5];
		Card bot[] = new Card[5];
		// single Score and total Score
		// X: player Y: bot
		int scorePlayerX = 0, totPlayerX = 0;
		int scorePlayerY = 0, totPlayerY = 0;
		// initialize
		String optGame = null;

		while (true)
		{
			Scanner scanner = new Scanner(System.in);		

			if (flow == 0)
			{
				System.out.print("再玩一次(y/n)? ");
				optGame = scanner.next();
				flow--;
			}
			// first step
			else if (flow == 1)
			{
				System.out.print("開始遊戲 (y/n)? ");
				optGame = scanner.next();
				flow--;
			}
			
			// Start game
			if (optGame.equals("y") || optGame.equals("Y"))
			{
				if (round == 1)
					System.out.println("開始洗牌…");

				for (int i = 0; i < 5; i++)
				{
					player[i] = playCard.deal();
					bot[i] = playCard.deal();
					
				}
				System.out.println("進行第" + round + "回合:\n電腦得5張手牌，玩家得5張手牌。");
				// show your card
				urCard(player);				
				
				while (true)
				{
					System.out.print("\n你的選擇? 1)調整手牌順序, 2)亮牌: ");
					int optShow = scanner.nextInt();
					if (optShow == 1)
					{
						System.out.print("輸入你要交換的兩張牌（牌的編號為0到4）: ");
						int optSwitchA = scanner.nextInt();
						int optSwitchB = scanner.nextInt();
						Card temp = player[optSwitchA];
						player[optSwitchA] = player[optSwitchB];
						player[optSwitchB] = temp;

						// show your card
						urCard(player);	

					} else if (optShow == 2)
					{
						System.out.println("電腦\t玩家");
						for (int i = 0; i < 5; i++)
						{
							// 1電腦，2玩家
							bot[i].print();
							System.out.print("-> ");
							player[i].print();
						
							// judge
							if (bot[i].suit == player[i].suit)
								System.out.println(" 平手");
							else if ((bot[i].suit - player[i].suit) == 1 || 
									(bot[i].suit - player[i].suit) == -2)
							{
								System.out.println(" 電腦勝，得" + (player[i].point + 1) + "點");
								scorePlayerY++;
							}
							else if ((bot[i].suit - player[i].suit) == -1 || 
									(bot[i].suit - player[i].suit) == 2)
							{
								System.out.println(" 玩家勝，得" + (bot[i].point + 1) + "點");
								scorePlayerX++;
							}
							
							// player win
							if(scorePlayerX == 1)
							{
								totPlayerX += (bot[i].point + 1);								
								scorePlayerX--;
							}
							// bot win
							else if(scorePlayerY == 1)
							{
								totPlayerY += (player[i].point + 1);
								scorePlayerY--;
							}
							
						}

						System.out.println("\n電腦得到" + totPlayerY + "點，你得到" + totPlayerX + "點\n");
						round++;
						flow--;
		
						// account and reset 
						if (round == 4)
						{
							if(totPlayerY > totPlayerX)
								System.out.println("你落敗了！\n");
							else if(totPlayerY < totPlayerX)
								System.out.println("你獲勝了！\n");
							else
								System.out.println("平手！\n");
							
							round = 1;
							totPlayerY = 0;
							totPlayerX = 0;
							flow = 0;
						}
						
						break;
					}
					// exception
					else
						System.out.println("Error! Try again.");
				}

				
			}
			// end game
			else if (optGame.equals("n") || optGame.equals("N"))
			{
				System.out.println("Thanks for using.");
				break;
			}
			// exception
			else
			{
				System.out.println("Error! Try again.");
				// back flow1
				if(flow == 0)
					flow++;
				else if(flow == -1)
					flow++;
			}
		}

	}

	// method
	public static void urCard(Card player[])
	{
		System.out.println("你的牌為");
		for (int i = 0; i < 5; i++)
		{
			if (i == 0)
				player[i].print();
			else
			{
				System.out.print(", ");
				player[i].print();
			}
		}
		System.out.println();
	}

}
