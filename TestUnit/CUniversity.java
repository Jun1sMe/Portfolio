/*
 * 大學：名稱，多個單位（行政單位或學系）
 */
import java.util.Arrays;
public class CUniversity extends CUnit
{
	private CUnit[] departList; // 大學單位
	private int departCount; // 大學單位數
	
	// 設置大學
	public CUniversity(String name)
	{
		super(name);
		departList = new CUnit[10];
		departCount = 0;
	}
	// 設置其他
	public CUniversity(String name, CUniversity parent)
	{
		super(name);
		setParent(parent);
		departList = new CUnit[10];
		departCount = 0;
	}
	@Override public int menu()
	{
		System.out.print("1:新增, 2:進入, 3:印出所有人員, -1:結束: ");
		return scanner.nextInt();
	}
	// 取得單位數
	public int getDepartCount()
	{
		return departCount;
	}	
	// 取得物件陣列
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
				depart = "行政";
			else if(departList[i] instanceof CProfessor)
				depart = "教師";
			else if(departList[i] instanceof CStudent)
				depart = "學生";				
			System.out.printf("%2s\t%4s\t%4s\n",depart, departList[i].getName(), ((CUniversity) departList[i]).getTitle());
			count++;			
		}
		if(count == 0)
			System.out.println("尚無資料");
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
		System.out.print("選項 (輸入-1返回): ");
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
