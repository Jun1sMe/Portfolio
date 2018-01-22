
abstract class SRole
{
	protected String name;	//名稱
	protected int hp;	//HP，血量數
	protected int attack;	//攻擊力	
	protected int coin;	//攜帶的錢幣	

	//建構子
	public SRole()
	{
		// TODO Auto-generated constructor stub
	}

	public abstract void attackArmy(SRole foe); //對敵方foe發出攻擊
	public abstract void damage(int aPoint); //造成損傷，aPoint代表受傷的數值
	
	public String getName()
	{
		return this.name;
	}
	public void setHp(int newHp)
	{
		this.hp = newHp;
	}
	public int getHp()
	{
		return this.hp;
	}
	public int getAttack()
	{
		return this.attack;
	}
	public int getCoin()
	{
		return this.coin;
	}
}
