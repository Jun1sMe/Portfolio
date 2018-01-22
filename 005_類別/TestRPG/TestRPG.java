import java.util.Scanner;

public class TestRPG
{
	public static int num = 5;
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		// ���B�A�ͩR��
		int cash = 0, live = num, enLive = num;
		// ��J�^��
		RPGGame RPG = new RPGGame();		
		for(int i = 0 ; i < num ; i++)
		{
			System.out.print("�п�J��" + (i + 1) + "��^���m�W�G");
			String inName = scanner.next();
			while(true)
			{
				System.out.print("�п�J��" + (i + 1) + "��^��¾�~�]1=�s��B2=�C�h�B3=�]�k�v�^�G");
				int inJob = scanner.nextInt();		
				if(inJob >= 1 && inJob <= 3)
				{
					RPG.cha[i] = new SChampion(inName, inJob);
					break;
				}
				printError();				
			}			
		}
		
		// ��ܩǪ�
		RPG.showMon();
		
		String[] round = {"�@", "�G", "�T", "�|", "��", "��", "�C", "�K", "�E", "�Q", "�Q�@", "�Q�G", "�Q�T", "�Q�|", "�Q��"};
		int roundIndex = 0;
		while(true)
		{
			// �^�X
			if(roundIndex < 15)
				System.out.println("\n��" + round[roundIndex++] + "�^�X\n���a����");
			else
				System.out.println("\n��" + (roundIndex + 1) + "�^�X\n���a����");
			// ���a�����ǳ�
			int target[] = new int[num];
			for(int i = 0 ; i < num; i++)
			{
				// dead
				if(RPG.cha[i].getHp() <= 0)
					continue;
				
				System.out.print(RPG.cha[i].getName() + " ������H�G1)�۰�, 2)���w��H: ");
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
				System.out.println(RPG.cha[i].getName() + " �w�Ƨ��� " + RPG.mon[target[i]].getName());
			}
			System.out.println("\n���a�����}�l�I");
			// ����
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
					System.out.println(bot + " ��" + player + " �o�ʧ����A" + player + "�{�סC");
				else
				{
					int afterAtk = botHp - playerAtk;
					// still alive
					if(afterAtk > 0)
					{
						System.out.println(player + " �� " + bot + "�o��" + playerJob + "�����A�y��" + bot + " " + playerAtk + "�l�ˡC");					
						RPG.mon[target[i]].setHp(afterAtk);				
					}
					else
					{
						int botCoin = RPG.mon[target[i]].getCoin();
						System.out.println(player + " �� " + bot + "�o��" + playerJob + "�����A�y��" + bot + " " + playerAtk + "�l�ˡA����" + bot + "�A�o" + botCoin + "���C");					
						RPG.mon[target[i]].setHp(0);
						// ����
						RPG.cha[i].setCoin(botCoin);
						cash += botCoin;
						enLive--;
						if(enLive == 0)
						{
							// �̫�п�X�C���ұo������
							System.out.println("�Ǫ����Ʈ����I\n�zĹ�o�ӧQ�A��o " + cash + " ���C");
							return;
						}
					}
				}
				
			}
			// �Ǫ�����
			System.out.println("\n�Ǫ����");
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
					System.out.println(bot + " ��" + player + " �o�ʧ����A" + player + "�{�סC");
				else
				{
					int afterAtk = playerHp - botAtk;
					// still alive
					if(afterAtk > 0)
					{
						System.out.println(bot + " ��" + player + " �o�ʧ����A�y��" + player + " " + botAtk + "�l�ˡC");
						RPG.cha[victim].setHp(afterAtk);	
					}
					else
					{
						System.out.println(bot + " ��" + player + " �o�ʧ����A�y��" + player + " " + botAtk + "�l�ˡA����" + player);
						RPG.cha[victim].setHp(0);
						live--;
						if(live == 0)
						{
							System.out.println("���x�D������I\n�C������");
							return;
						}
					}
				}
				

			}
			// �^�X�פF
			System.out.println("\n�Ĥ@�^�X����\n�^�����o" + cash + "���A���A�G�@" + live + "�H�s��");
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
