/*
 * ��F���G�]�A�W�١B�h�W��F�H��
 */
public class CAdministration extends CUniversity
{
	// �]�m��F���
	public CAdministration(String name, CUniversity parent)
	{
		super(name);
		setParent(parent);
	}

	@Override public int menu()
	{
		System.out.print("1:��F�H��, 2:�L�X�Ҧ�����, -1:��^: ");
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

	// ��F�H��
	public void storageData()
	{
		System.out.print("�m�W: ");
		String name = scanner.next();
		System.out.print("¾��: ");
		title = scanner.next();

		this.add(new CFaculty(name, TestUnit.cur, title));
	}

}