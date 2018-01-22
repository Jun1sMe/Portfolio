
/*
 * 商品
 */
import java.util.Arrays;

public class Store
{
	// 商品品項初始化為100項、0筆
	private Storage product[] = new Storage[100];
	public int count = 0;

	public Store()
	{

	}

	// 新增商品
	public void add(String no, String name, int pri, String uni, String mak)
	{
		Storage newProduct = new Storage(no, name, pri, uni, mak);
		if (this.count >= product.length)
			product = Arrays.copyOf(product, this.count * 2);
		this.product[this.count++] = newProduct;
	}

	// 貨品數量:
	public boolean numStock(int opt, String no, int sto)
	{
		for(int i = 0 ; i < this.count ; i++)
		{
			if(no.equals(product[i].getNo()))
			{
				if(this.product[i].setStock(opt, sto) == false)
					return false;
				else
					return true;
			}	
		}
		return false;
	}

	// 搜尋編號是否存在：存在回傳其index、否則-1
	public int search(String value)
	{
		for (int i = 0; i < this.count; i++)
		{
			// 該值存在
			if (value.equals(product[i].getNo()))
				return this.count;
		}
		// 不存在
		return -1;
	}

	// 顯示所有示商品資料
	public void showList()
	{
		if (this.count <= 0)
		{
			System.out.println("無商品清單..\n");
			return;
		}
		for (int i = 0; i < this.count; i++)
		{
			Storage showPro = this.product[i];
			String no = showPro.getNo();
			String name = showPro.getName();
			int price = showPro.getPrice();
			String unit = showPro.getUnit();
			int stock = showPro.getStock();
			String maker = showPro.getMaker();

			System.out.println("商品編號: " + no + "\t商品名稱: " + name + "\t單價: " + price + " " + unit + "\t庫存量: " + stock
					+ "\t製造商: " + maker);
		}
		System.out.println();
	}

	// 顯示商品資料
	public boolean showProduct()
	{
		if (this.count <= 0)
		{
			System.out.println("無商品清單..\n");
			return false;
		}
		for (int i = 0; i < this.count; i++)
		{
			Storage showPro = this.product[i];
			String no = showPro.getNo();
			String name = showPro.getName();

			System.out.println("商品編號: " + no + "\t商品名稱: " + name);
		}
		System.out.println();
		return true;
	}

	// provide loading
	public int getCount()
	{
		return count;
	}

}
