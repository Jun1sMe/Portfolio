
public class SChampion extends SRole
{
	protected int job;	//�^��¾�~
	
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
		// �W�r���C�Ӧr���N�X�ۥ[�᪺�`�M�@����q
		this.hp = tempHp;
		// �r���N�X�ۭ����29���l�Ƨ@�������O
		this.attack = tempAttack % 29;; 
		
		if(this.hp < 0)
			this.hp = 10;
		if(this.attack < 0)
			this.attack = 10;

		// �^���ΩǪ��b�Q�����ɡA���ʤ����G�Q�����|�i�H�{�צӤ��������C
		
	}
	
	public void attackArmy(SRole foe) //��Ĥ�foe�o�X����
	{
		
	}
	public void damage(int aPoint) //�y���l�ˡAaPoint�N����˪��ƭ�
	{
		
	}
	
	public String getJob()
	{
		// �]1=�s��B2=�C�h�B3=�]�k�v�^
		String[] jobList = {"�s��", "�C�h", "�]�k�v"};
		return jobList[this.job - 1];
	}

	public void setCoin(int newCoin)
	{
		this.coin += newCoin;
	}


}
