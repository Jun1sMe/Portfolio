
abstract class SRole
{
	protected String name;	//�W��
	protected int hp;	//HP�A��q��
	protected int attack;	//�����O	
	protected int coin;	//��a������	

	//�غc�l
	public SRole()
	{
		// TODO Auto-generated constructor stub
	}

	public abstract void attackArmy(SRole foe); //��Ĥ�foe�o�X����
	public abstract void damage(int aPoint); //�y���l�ˡAaPoint�N����˪��ƭ�
	
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
