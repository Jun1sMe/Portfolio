/*
 * 行政單位：包括名稱、多名行政人員
 */
public class CAdministration extends CUniversity
{
	// 設置行政單位
	public CAdministration(String name, CUniversity parent)
	{
		super(name);
		setParent(parent);
	}

	@Override public int menu()
	{
		System.out.print("1:行政人員, 2:印出所有成員, -1:返回: ");
		int opt = scanner.nextInt();
		if (opt == 1)
			this.storageData();
		else if (opt == 2)
		{
			this.printList();
			opt = 4;
		}
		else if (opt == -1);
		else
		{
			TestUnit.printError();
			opt = 5;
		}
		return opt;
	}

	// 行政人員
	public void storageData()
	{
		System.out.print("姓名: ");
		String name = scanner.next();
		System.out.print("職稱: ");
		title = scanner.next();

		this.add(new CFaculty(name, TestUnit.cur, title));
	}

}