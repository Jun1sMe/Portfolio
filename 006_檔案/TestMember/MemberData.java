// 會員資料
class MemberData
{
	// 編號 | 姓名 | 身分證 | 生日 | 電話
	private int no = 0;
	private String name;
	private String id;
	private MemberBD birthday;
	private String phone;
	
	// 建構子: 呼叫方式，透過此方法修改資料內容
	public MemberData(int no, String n, String id, MemberBD bd, String p)
	{
		this.setData(no, n, id, bd, p);
	}
	// 改寫 ->建構子函式
	public void setData(int no, String n, String id, MemberBD bd, String p)
	{
		// 初始化
		// 編號0, 生日1, 1, 1
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
	
	// 取得會員資料
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
