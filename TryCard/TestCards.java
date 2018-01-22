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
				System.out.print("�A���@��(y/n)? ");
				optGame = scanner.next();
				flow--;
			}
			// first step
			else if (flow == 1)
			{
				System.out.print("�}�l�C�� (y/n)? ");
				optGame = scanner.next();
				flow--;
			}
			
			// Start game
			if (optGame.equals("y") || optGame.equals("Y"))
			{
				if (round == 1)
					System.out.println("�}�l�~�P�K");

				for (int i = 0; i < 5; i++)
				{
					player[i] = playCard.deal();
					bot[i] = playCard.deal();
					
				}
				System.out.println("�i���" + round + "�^�X:\n�q���o5�i��P�A���a�o5�i��P�C");
				// show your card
				urCard(player);				
				
				while (true)
				{
					System.out.print("\n�A�����? 1)�վ��P����, 2)�G�P: ");
					int optShow = scanner.nextInt();
					if (optShow == 1)
					{
						System.out.print("��J�A�n�洫����i�P�]�P���s����0��4�^: ");
						int optSwitchA = scanner.nextInt();
						int optSwitchB = scanner.nextInt();
						Card temp = player[optSwitchA];
						player[optSwitchA] = player[optSwitchB];
						player[optSwitchB] = temp;

						// show your card
						urCard(player);	

					} else if (optShow == 2)
					{
						System.out.println("�q��\t���a");
						for (int i = 0; i < 5; i++)
						{
							// 1�q���A2���a
							bot[i].print();
							System.out.print("-> ");
							player[i].print();
						
							// judge
							if (bot[i].suit == player[i].suit)
								System.out.println(" ����");
							else if ((bot[i].suit - player[i].suit) == 1 || 
									(bot[i].suit - player[i].suit) == -2)
							{
								System.out.println(" �q���ӡA�o" + (player[i].point + 1) + "�I");
								scorePlayerY++;
							}
							else if ((bot[i].suit - player[i].suit) == -1 || 
									(bot[i].suit - player[i].suit) == 2)
							{
								System.out.println(" ���a�ӡA�o" + (bot[i].point + 1) + "�I");
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

						System.out.println("\n�q���o��" + totPlayerY + "�I�A�A�o��" + totPlayerX + "�I\n");
						round++;
						flow--;
		
						// account and reset 
						if (round == 4)
						{
							if(totPlayerY > totPlayerX)
								System.out.println("�A���ѤF�I\n");
							else if(totPlayerY < totPlayerX)
								System.out.println("�A��ӤF�I\n");
							else
								System.out.println("����I\n");
							
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
		System.out.println("�A���P��");
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
