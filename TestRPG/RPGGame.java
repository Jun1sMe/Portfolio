
public class RPGGame
{
	protected SChampion[] cha;
	protected SMonster[] mon;
	protected int num = 5;
	
	public RPGGame()
	{
		this.setData();
	}
	public void setData()
	{		
		cha = new SChampion[num];
		mon = new SMonster[num];
		// �C���@�}�l�Y�U����5�W�^���M5���Ǫ�
		for(int i = 0 ; i < num ; i++)
		{
			// �Ǫ��������H������
			mon[i] = new SMonster();
			String tempName = nameMon();
			char[] chName = tempName.toCharArray();
			
			mon[i].name = tempName; 			
			// �W�r���C�Ӧr���N�X�ۥ[�᪺�`�M�@����q
			int tempHp = 0, tempAttack = 1;;
			for(int j = 0 ; j < chName.length ; j++)
			{
				tempHp += chName[j];
				tempAttack *= chName[j];
			}
			mon[i].hp = tempHp; 
			if(mon[i].hp < 0)
				mon[i].hp = 10;
			// �r���N�X�ۭ����29���l�Ƨ@�������O
			mon[i].attack = tempAttack % 29;	
			if(mon[i].attack < 0)
				mon[i].attack = 10;

			// �Ǫ�����a���������H�����͡]�H100���W���^
			mon[i].coin = (int)(Math.random() * 100);
			// �^���ΩǪ��b�Q�����ɡA���ʤ����G�Q�����|�i�H�{�צӤ��������C
			
		}
	}
	// random mon's name
	public String nameMon()
	{
		String[] name = {"Zombie", "Spider", "Guardian", "Chicken Jockey", "Giant", "Slime", "Witch", 
				"Blaze", "Ghast", "Endermite", "Shulker", "Husk", "Skeleton Trap Horse", "Evoker"};
		int botChoose = (int)(Math.random() * name.length);
		return name[botChoose];
	}
	public void showMon()
	{
		System.out.print("�Ǫ��G");
		for(int i = 0 ; i < num; i++)
		{
			if(i == 0)
				System.out.print(mon[i].name);
			else
				System.out.print(", " + mon[i].name);			
		}
		System.out.println();
	}
	public void hitMon()
	{
		System.out.print("�Ǫ��G");
		for(int i = 0 ; i < num; i++)
		{
			if(i == 0)
				System.out.print((i + 1) + ") " + mon[i].name);
			else
				System.out.print(", "+ (i + 1) + ") "  + mon[i].name);			
		}
		System.out.print(": ");
	}


}
