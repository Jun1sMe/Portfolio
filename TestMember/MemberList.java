import java.util.Scanner;

// 會員清單
public class MemberList
{
	private MemberData mbList[];
	private int count;
	Scanner scanner = new Scanner(System.in);

	// 建構子
	public MemberList()
	{
		// 建立會員資料的物件陣列，初始化為101筆空間 | 資料筆數初始化為0
		 mbList = new MemberData[101];
		 count = 0;
	}
	// 取得次數
	public int getCount()
	{
		return count;
	}
	
	// 取得陣列
	public MemberData[] getMemberData()
	{
		return mbList;
	}
	
	// 顯示資料
	public void print()
	{
		for(int i = 0 ; i < this.count ; i++)
		{
			MemberData each = this.mbList[i];
			int no = each.getNo();
			String name = each.getName();
			String id = each.getId();
			MemberBD bd = each.getBirthday();
			String phone = each.getPhone();
			
			System.out.printf("%03d\t%3s\t%10s\t", no, name, id);
			bd.print();
			System.out.printf("\t%10s\n", phone);			
		}	
	}
	
	//  修改一筆會員資料: 編號、姓名、身分證、生日、電話
	public void modify(int no, String n, String id, MemberBD bd, String p)
	{
		int index = this.search(no);
		this.mbList[index] = new MemberData(no, n, id, bd, p);
	}

	// 加入一筆會員資料: 編號、姓名、身分證、生日、電話
	public void add(int no, String n, String id, MemberBD bd, String p)
	{
		// 新增物件
		MemberData newData = new MemberData(no, n, id, bd, p);
		// 空間不足則擴充
		if (this.count >= mbList.length)
			this.resize();
		// 把資料存入陣列
		this.mbList[this.count++] = newData;
	}

	// 刪除一筆會員資料: 編號
	public boolean delete(int no)
	{
		int index = this.search(no);
		if (index == -1)
		{
			System.out.println("編號不存在！\n");
			return false;
		}
		else
		{
			// 由後者遞補前者
			for (int i = 0; i < this.count - 1; i++)
			{
				if (i >= index)
					this.mbList[i] = this.mbList[i + 1];
			}
			// 刪除一筆
			this.count--;
			System.out.println("刪除成功！");
		}
		return true;

	}

	// 動態空間
	private void resize()
	{
		MemberData tempData[] = new MemberData[mbList.length * 2];
		for (int i = 0; i < this.count; i++)
			tempData[i] = this.mbList[i];
		// mbList指向物件
		this.mbList = null;
		this.mbList = tempData;
	}

	// 值存在則回傳index, 不存在則-1
	public int search(int x)
	{
		for (int i = 0; i < this.count; i++)
		{
			if (x == this.mbList[i].getNo())
				return i;
		}
		// 不存在
		return -1;
	}

	// 編號判斷
	public int judgeNo(int opt)
	{
		// 2: add | 4: modify
		if (opt == 2)
			System.out.print("編號(介於0-100)：");
		else if (opt == 4)
			System.out.print("輸入編號：");
		int no = scanner.nextInt();

		// 會員編號必須介於0至100之間: 錯誤！超出範圍！ -> '-1'
		if (no < 0 || no > 100)
		{
			System.out.println("錯誤！超出範圍！");
			return -1;
		}
		// 該位址尚未使用: 正確 -> '-3'
		if (this.search(no) == -1)
		{
			// opt4: 錯誤！編號不存在！ -> '-2'
			if (opt == 4)
			{
				System.out.println("錯誤！編號不存在！");
				return -2;
			}
			// opt = 2
			else
				return no;
		}
		// 該位址存在: 
		else
		{
			// opt2: 錯誤！編號重複！ -> '-2'
			if (opt == 2)
			{
				System.out.println("錯誤！編號重複！");
				return -2;
			}
			// opt = 4
			else
				return no;
		}

	}

	// 編號判斷
	public String judgeId()
	{
		System.out.print("身分證：");
		String id = scanner.next();
		// 英文轉換成大寫，數字固定
		char idArr[] = id.toUpperCase().toCharArray();
		int codeTrue = 0;
		// 身分證字母：A-Z
		int charArr[] = { 10, 11, 12, 13, 14, 15, 16, 17, 34, 18, 19, 20, 21, 22, 35, 23, 24, 25, 26, 27, 28, 29, 32,
				30, 31, 33 };
		
		// 英文：十進位 A-Z: 65-90 
		if ((int) idArr[0] >= 65 && (int) idArr[0] <= 90)
		{
			// 性別：十進位 1-2: 49-50
			if ((int) idArr[1] >= 49 && (int) idArr[1] <= 50)
			{
				// 1~7編號：十進位 0-9: 48-57
				for (int i = 2; i <= 8; i++)
				{
					// codeTrue all right is '7'
					if ((int) idArr[i] >= 48 && (int) idArr[i] <= 57)
						codeTrue++;
				}
				if (codeTrue == 7)
				{
					// A-Z: 65-90 轉成index表示 A: 65 ->0
					// char: 
					int firstChar = idArr[0] - 'A';
					int num1 = charArr[firstChar] / 10 + (charArr[firstChar] % 10) * 9;
					int total = num1;

					// 計算並比對檢查碼
					for (int i = 1, j = 8; i <= 8; i++, j--)
						total += ((idArr[i] - '0') * (j));

					if (idArr[9] - '0' == 10 - (total % 10))
						return id;
				}

			}

		}
		// 身分證字號有錯
		System.out.println("錯誤！請重新輸入！");
		return "";

	}

	// 電話判斷
	public String judgePhone()
	{
		System.out.print("電話：");
		String phone = scanner.next();
		char idArr[] = phone.toCharArray();
		if (idArr[0] == '0')
			if (idArr.length >= 9 && idArr.length <= 10)
				return phone;

		// 電話號碼有錯
		System.out.println("錯誤！請重新輸入！");
		return "";
	}

}
