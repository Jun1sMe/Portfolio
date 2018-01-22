
public class SChampion extends SRole
{
	protected int job;	//英雄職業
	
	public SChampion(String name, int job)
	{
		this.setData(name, job);
	}
	public void setData(String name, int job)
	{
		this.name = name;
		this.job = job;
		
		char[] chName = name.toCharArray();
		int tempHp = 0, tempAttack = 1;;
		for(int j = 0 ; j < chName.length ; j++)
		{
			tempHp += chName[j];
			tempAttack *= chName[j];
		}
		// 名字的每個字元代碼相加後的總和作為血量
		this.hp = tempHp;
		// 字元代碼相乘後取29的餘數作為攻擊力
		this.attack = tempAttack % 29;; 
		
		if(this.hp < 0)
			this.hp = 10;
		if(this.attack < 0)
			this.attack = 10;

		// 英雄或怪物在被攻擊時，有百分之二十的機會可以閃避而不受攻擊。
		
	}
	
	public void attackArmy(SRole foe) //對敵方foe發出攻擊
	{
		
	}
	public void damage(int aPoint) //造成損傷，aPoint代表受傷的數值
	{
		
	}
	
	public String getJob()
	{
		// （1=盜賊、2=劍士、3=魔法師）
		String[] jobList = {"盜賊", "劍士", "魔法師"};
		return jobList[this.job - 1];
	}

	public void setCoin(int newCoin)
	{
		this.coin += newCoin;
	}


}
