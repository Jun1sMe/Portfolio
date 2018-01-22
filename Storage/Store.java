
/*
 * �ӫ~
 */
import java.util.Arrays;

public class Store
{
	// �ӫ~�~����l�Ƭ�100���B0��
	private Storage product[] = new Storage[100];
	public int count = 0;

	public Store()
	{

	}

	// �s�W�ӫ~
	public void add(String no, String name, int pri, String uni, String mak)
	{
		Storage newProduct = new Storage(no, name, pri, uni, mak);
		if (this.count >= product.length)
			product = Arrays.copyOf(product, this.count * 2);
		this.product[this.count++] = newProduct;
	}

	// �f�~�ƶq:
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

	// �j�M�s���O�_�s�b�G�s�b�^�Ǩ�index�B�_�h-1
	public int search(String value)
	{
		for (int i = 0; i < this.count; i++)
		{
			// �ӭȦs�b
			if (value.equals(product[i].getNo()))
				return this.count;
		}
		// ���s�b
		return -1;
	}

	// ��ܩҦ��ܰӫ~���
	public void showList()
	{
		if (this.count <= 0)
		{
			System.out.println("�L�ӫ~�M��..\n");
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

			System.out.println("�ӫ~�s��: " + no + "\t�ӫ~�W��: " + name + "\t���: " + price + " " + unit + "\t�w�s�q: " + stock
					+ "\t�s�y��: " + maker);
		}
		System.out.println();
	}

	// ��ܰӫ~���
	public boolean showProduct()
	{
		if (this.count <= 0)
		{
			System.out.println("�L�ӫ~�M��..\n");
			return false;
		}
		for (int i = 0; i < this.count; i++)
		{
			Storage showPro = this.product[i];
			String no = showPro.getNo();
			String name = showPro.getName();

			System.out.println("�ӫ~�s��: " + no + "\t�ӫ~�W��: " + name);
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
