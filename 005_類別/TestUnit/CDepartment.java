/*
 * 學系（Department）：包括名稱、多名人員（行政人員、老師或學生）
 */
public class CDepartment extends CUniversity
{
	// 設置行政單位
	public CDepartment(String name, CUniversity parent)
	{
		super(name);
		setParent(parent);
	}

	@Override public int menu()
	{
		System.out.print("1:行政人員, 2:教師, 3:學生, 4:印出所有成員, -1:返回: ");
		int opt = scanner.nextInt();
		if(opt == 1)
			this.storageData();
		else if(opt == 2)
			this.storageData2();
		else if(opt == 3)
			this.storageData3();
		else if(opt == 4)
		{
			this.printList();
		}
		else if(opt == -1);
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
		String title = scanner.next();
			
		this.add(new CFaculty(name, TestUnit.cur, title));		
	}
	// 教師
	public void storageData2()
	{
		System.out.print("姓名: ");
		String name = scanner.next();		
		while(true)
		{
			System.out.print("職等(0到2): ");
			int level = scanner.nextInt();
			if(level >= 0 && level <= 2)
			{
				this.add(new CProfessor(name, TestUnit.cur, level));
				break;
			}
			TestUnit.printError();
		}
	}
	// 學生
	public void storageData3()
	{
		System.out.print("姓名: ");
		String name = scanner.next();
		System.out.print("學號: ");
		String num = scanner.next();
		while(true)
		{
			System.out.print("入學年份: ");
			int year = scanner.nextInt();
			if(year >= 1912 && year <= 2017)
			{
				this.add(new CStudent(name, TestUnit.cur, num ,year));
				break;
			}
			TestUnit.printError();
		}	
	}	
}
