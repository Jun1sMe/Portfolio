/* 
 * 商品內容
 */
class Storage
{
	// 商品編號
	private String proNo;
	// 商品名稱
	private String proName;
	// 單價
	private int proPrice;
	// 單位
	private String proUnit;
	// 庫存量
	private int proStock;
	// 製造商
	private String proMaker;

	public Storage(String no, String name, int pri, String uni, String mak)
	{
		this.setData(no, name, pri, uni, mak);
	}

	// 新增商品資料
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

	// 貨品數量:
	public boolean setStock(int opt, int sto)
	{
		// 出貨
		if (opt == 3)
		{
			if (sto > proStock)
				return false;
			proStock -= sto;
		}
		// 進貨
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
