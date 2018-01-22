/*
 * �Ǩt�]Department�^�G�]�A�W�١B�h�W�H���]��F�H���B�Ѯv�ξǥ͡^
 */
public class CDepartment extends CUniversity
{
	// �]�m��F���
	public CDepartment(String name, CUniversity parent)
	{
		super(name);
		setParent(parent);
	}

	@Override public int menu()
	{
		System.out.print("1:��F�H��, 2:�Юv, 3:�ǥ�, 4:�L�X�Ҧ�����, -1:��^: ");
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
	// ��F�H��
	public void storageData()
	{
		System.out.print("�m�W: ");
		String name = scanner.next();
		System.out.print("¾��: ");
		String title = scanner.next();
			
		this.add(new CFaculty(name, TestUnit.cur, title));		
	}
	// �Юv
	public void storageData2()
	{
		System.out.print("�m�W: ");
		String name = scanner.next();		
		while(true)
		{
			System.out.print("¾��(0��2): ");
			int level = scanner.nextInt();
			if(level >= 0 && level <= 2)
			{
				this.add(new CProfessor(name, TestUnit.cur, level));
				break;
			}
			TestUnit.printError();
		}
	}
	// �ǥ�
	public void storageData3()
	{
		System.out.print("�m�W: ");
		String name = scanner.next();
		System.out.print("�Ǹ�: ");
		String num = scanner.next();
		while(true)
		{
			System.out.print("�J�Ǧ~��: ");
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
