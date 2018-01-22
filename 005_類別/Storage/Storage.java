/* 
 * �ӫ~���e
 */
class Storage
{
	// �ӫ~�s��
	private String proNo;
	// �ӫ~�W��
	private String proName;
	// ���
	private int proPrice;
	// ���
	private String proUnit;
	// �w�s�q
	private int proStock;
	// �s�y��
	private String proMaker;

	public Storage(String no, String name, int pri, String uni, String mak)
	{
		this.setData(no, name, pri, uni, mak);
	}

	// �s�W�ӫ~���
	public void setData(String no, String name, int pri, String uni, String mak)
	{
		if (no != null)
			proNo = no;
		if (name != null)
			proName = name;
		if (pri > 0)
			proPrice = pri;
		if (uni != null)
			proUnit = uni;
		if (mak != null)
			proMaker = mak;
	}

	// �f�~�ƶq:
	public boolean setStock(int opt, int sto)
	{
		// �X�f
		if (opt == 3)
		{
			if (sto > proStock)
				return false;
			proStock -= sto;
		}
		// �i�f
		else
			proStock += sto;
		return true;
	}

	// provide loading
	public String getNo()
	{
		return proNo;
	}

	public String getName()
	{
		return proName;
	}

	public int getPrice()
	{
		return proPrice;
	}

	public String getUnit()
	{
		return proUnit;
	}

	public int getStock()
	{
		return proStock;
	}

	public String getMaker()
	{
		return proMaker;
	}

}
