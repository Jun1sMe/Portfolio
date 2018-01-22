// �|�����
class MemberData
{
	// �s�� | �m�W | ������ | �ͤ� | �q��
	private int no = 0;
	private String name;
	private String id;
	private MemberBD birthday;
	private String phone;
	
	// �غc�l: �I�s�覡�A�z�L����k�ק��Ƥ��e
	public MemberData(int no, String n, String id, MemberBD bd, String p)
	{
		this.setData(no, n, id, bd, p);
	}
	// ��g ->�غc�l�禡
	public void setData(int no, String n, String id, MemberBD bd, String p)
	{
		// ��l��
		// �s��0, �ͤ�1, 1, 1
		this.no = 0;
		this.name = this.id = this.phone = new String("");
		this.birthday = new MemberBD(1, 1, 1);
		
		if(no != 0)
			this.no = no;
		if (n != null)
			this.name = n;
		if (id != null)
			this.id = id;
		if (bd != null)
			this.birthday = bd;
		if (p != null)
			this.phone = p;
	}
	
	// ���o�|�����
	public int getNo()
	{
		return no;
	}
	public String getName()
	{
		return name;
	}
	public String getId()
	{
		return id;
	}
	public String getPhone()
	{
		return phone;
	}
	public MemberBD getBirthday() {
		return birthday;
	}

}
