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
	// ���J�P�̦h52�i�B�w�X�B��`
	public static int countPoker = 0 , chip, bet;
	public static int playerPoint, dealorPoint, playerCard, dealorCard;
	public static int[][] playerPoker = new int[5][2], dealorPoker = new int[5][2];	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int flow = 1, option = 1;
		/* :::testing:::.�s�P.�~�P		 */		
		int[][] officialPoker = boxPoker();	
		printArr(officialPoker);
		shufflePoker(officialPoker);
		printArr(officialPoker);
		
		while(true)
		{
			// ���s�i�J
			if(flow == 0)
			{
				if(chip > 0 && countPoker <= 42 )
				{
					System.out.print("�O�_�A���@���]1:�O/2:�_�^�H");
					option = input.nextInt();
					System.out.println("\n");
				}
				else if(chip <= 0)
					option = 2;
				else if(countPoker > 42)
				{
					System.out.println("�ӧ��w�����A�M�x��z�P�त..");
					option = 2;
				}

			}
			// �����i�J
			if(flow == 1)
			{
				System.out.println("Blackjack�}�l");
				do
				{
					System.out.print("�z���w�X�G");
					chip = input.nextInt();
					if(chip < 1)
						System.out.println("�·жQ���w���{����A�J��!");
					else
						System.out.println();
				}while(chip < 1);
				
				flow--;	
			}

	
			// Play again
			if(option == 1)
			{
				// ��ܪ�l���A
				betDisplay(officialPoker);
				// ��ܫ����P�B�I��
				showAll(playerPoker, playerCard);
				// ���a�^�X�B�����P�֩󤭱i�B�I�Ƥp��21
				while(rou == Round.PLAYER && playerCard < 5 && playerPoint < 21)
				{
					System.out.print("\n\n1) Hit. 2) Stay? ");
					int hitOrNot = input.nextInt();
					if(hitOrNot == 1)
					{
						playerPoker[playerCard++] = drawOne(officialPoker);
						// ��ܫ����P�B�I��
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
					System.out.println("\n\n���a�^�X\n���a���P�աG");
					
					// ���a�P�`�I�Ƥp��17�A�h�~��o�P
					while(pointJudge(dealorPoker, dealorCard) < 17)
						dealorPoker[dealorCard++] = drawOne(officialPoker);
					// ��ܫ����P�B�I��
					showAll(dealorPoker, dealorCard);
					
					// ���a��Blackjack
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
								System.out.print("����I");
								sta = Status.TIE;
							}
						}
					}
					else
						sta = Status.LOST;
									
				}
				// ���賣Blackjack
				if(sta == Status.BLACKJACK && playerPoint == 21 && dealorPoint == 21)
					sta = Status.TIE;		
				
				if(sta == Status.WON || playerPoint == 21)
					System.out.println("\n���a��ӡI\n�z��o��" + bet + "�T�w�X�A�z���w�X�� "
							+ (chip += bet) + " �T�C\n");
				else if(sta == Status.LOST || dealorPoint == 21)
					System.out.println("\n���a��ӡI\n�z�l����" + bet + "�T�w�X�A�z���w�X�� "
							+ (chip -= bet) + " �T�C\n");
				else if(sta == Status.TIE)
					System.out.println("\n����I\n�z��o��" + bet + "�T�w�X�A�z���w�X�� "
							+ (chip) + " �T�C\n");
				
				// ��l��
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
				System.out.println("�P�±z���C���A�A���I");
				break;
			}
			else
				System.out.println("��J���~! �Э���");
		}
		
	}

	// �ƨ禡: �����P��
	public static int[][] boxPoker() {
		// ���J�P��52�i�P�A0 ->4�ت��B1 ->13�i�P��
		int pokerFace[][] = new int[52][2];
		for(int i = 0; i < pokerFace.length; i++)
		{
			// Spade ->0~12�BHeart ->13~25�BDiamond ->26~38�BClub ->39~51
			pokerFace[i][0] = i / 13;
			pokerFace[i][1] = (i % 13) + 1;
		}
		return pokerFace;
	}
	// �ƨ禡: �����~�P
	public static void shufflePoker(int[][] x) {
		for(int i = 0; i < x.length; i++)
		{
			// �N�H�����X�����ޭȥ�Jtemp
			int ran = (int)(Math.random() * x.length);
			int[] temp = x[ran];
			x[ran] = x[i];
			x[i] = temp;
		}
	}
	// �ƨ禡: ��@�i�P
	public static int[] drawOne(int[][] x) {
		return x[countPoker++];			
	}
	// �ƨ禡: ��l���A���
	public static void betDisplay(int[][] x) {
		do
		{
		System.out.print("��`�G");
		bet = input.nextInt();
		if(bet > chip)
			System.out.println("�Q���w�X�����A�Э��s�U�`");
		else
			System.out.println("");
		}while(bet > chip);
		
		System.out.println("�~�P�����A�}�l�o�P�K\n���a�o2�i�P\n���a�o2�i�P�G");
		
		// ���a�����ۤv�@�Ʒt�P�B���P �����a
		dealorPoker[0] = drawOne(x);
		dealorPoker[1] = drawOne(x);
		dealorCard = 2;
		playerPoker[0] = drawOne(x);
		playerPoker[1] = drawOne(x);
		playerCard = 2;
		
	}
	// �ƨ禡: �����P���
	public static void cardDisplat(int[][] y, int card) {
		for(int k = card - 1; k >= 0; k--)
		{
			// �������[','
			if(k != card - 1)
				System.out.print(", ");
			// ���
			if(y[k][0] == 0)
				System.out.print("Spade ");
			else if(y[k][0] == 1)
				System.out.print("Heart ");
			else if(y[k][0] == 2)
				System.out.print("Diamond ");
			else if(y[k][0] == 3)
				System.out.print("Club ");
			// �P��
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
	// �ƨ禡: �I�ƧP�_
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
				
				// �����ĤT�i�_
				if(i >= 2 && y[i][1] == 1)
					ace++;
			}
			// ��ACE�����p
			while(ace > 0 && (point + 10) < 21)
			{
				point += 10;
				if(ace == 1)
					break;
			}			
			return point;
		}
			
	}	
	// �ƨ禡: ��ܫ����P���I��
	public static void showAll(int[][] poker, int card) {
		// ��ܫ����P
		cardDisplat(poker, card);
		// ����I��
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
	
	// �ƨ禡: ��X
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
