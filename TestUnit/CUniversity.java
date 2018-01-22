/*
 * �j�ǡG�W�١A�h�ӳ��]��F���ξǨt�^
 */
import java.util.Arrays;
public class CUniversity extends CUnit
{
	private CUnit[] departList; // �j�ǳ��
	private int departCount; // �j�ǳ���
	
	// �]�m�j��
	public CUniversity(String name)
	{
		super(name);
		departList = new CUnit[10];
		departCount = 0;
	}
	// �]�m��L
	public CUniversity(String name, CUniversity parent)
	{
		super(name);
		setParent(parent);
		departList = new CUnit[10];
		departCount = 0;
	}
	@Override public int menu()
	{
		System.out.print("1:�s�W, 2:�i�J, 3:�L�X�Ҧ��H��, -1:����: ");
		return scanner.nextInt();
	}
	// ���o����
	public int getDepartCount()
	{
		return departCount;
	}	
	// ���o����}�C
	public CUnit[] getDepartList()
	{
		return departList;
	}

	// adding
	public void add(CUnit item)
	{
		if (departCount >= departList.length)
			departList = Arrays.copyOf(departList, departList.length * 2);
		departList[departCount++] = item;
	}

	// print
	public int printAll()
	{
		int count = 0;
		for(int i = 0 ; i < departCount; i++)
		{
			System.out.printf("%3s\t%4s\t%4s\n",departList[i].getParent().getName(), departList[i].getName(), ((CUniversity) departList[i]).getTitle());
			count++;
		}
		return count;
	}
	public void printList()
	{
		int count = 0;
		for(int i = 0 ; i < departCount; i++)
		{
			String depart = "";
			if(departList[i] instanceof CFaculty)
				depart = "��F";
			else if(departList[i] instanceof CProfessor)
				depart = "�Юv";
			else if(departList[i] instanceof CStudent)
				depart = "�ǥ�";				
			System.out.printf("%2s\t%4s\t%4s\n",depart, departList[i].getName(), ((CUniversity) departList[i]).getTitle());
			count++;			
		}
		if(count == 0)
			System.out.println("�|�L���");
		// new line
		System.out.println();
	}
	// show enter list
	public int showList()
	{
		for (int i = 0; i < departCount; i++)
		{
			if (departList[i] != null)
				System.out.println((i + 1) + "." + departList[i].getName());
		}
		System.out.print("�ﶵ (��J-1��^): ");
		return scanner.nextInt();
	}

	// get position
	public CUniversity getPos(int i)
	{
		return (CUniversity) departList[i];
	}
//	public CUniversity getPos(String name)
//	{
//		int index = getIndex(name);
//		if (index == -1)
//			return null;
//		return (CUniversity) departList[index];
//	}
//	// get index
//	public int getIndex(String key)
//	{
//		for (int i = 0; i < departCount++; i++)
//			if (departList[i].getName().equals(key))
//				return i;
//		return -1;
//	}
}
