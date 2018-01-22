
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
		// 遊戲一開始即各產生5名英雄和5隻怪物
		for(int i = 0 ; i < num ; i++)
		{
			// 怪物的種類隨機產生
			mon[i] = new SMonster();
			String tempName = nameMon();
			char[] chName = tempName.toCharArray();
			
			mon[i].name = tempName; 			
			// 名字的每個字元代碼相加後的總和作為血量
			int tempHp = 0, tempAttack = 1;;
			for(int j = 0 ; j < chName.length ; j++)
			{
				tempHp += chName[j];
				tempAttack *= chName[j];
			}
			mon[i].hp = tempHp; 
			if(mon[i].hp < 0)
				mon[i].hp = 10;
			// 字元代碼相乘後取29的餘數作為攻擊力
			mon[i].attack = tempAttack % 29;	
			if(mon[i].attack < 0)
				mon[i].attack = 10;

			// 怪物所攜帶的錢幣請隨機產生（以100為上限）
			mon[i].coin = (int)(Math.random() * 100);
			// 英雄或怪物在被攻擊時，有百分之二十的機會可以閃避而不受攻擊。
			
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
		System.out.print("怪物：");
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
		System.out.print("怪物：");
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
