import java.util.Scanner;

// �|���M��
public class MemberList
{
	private MemberData mbList[];
	private int count;
	Scanner scanner = new Scanner(System.in);

	// �غc�l
	public MemberList()
	{
		// �إ߷|����ƪ�����}�C�A��l�Ƭ�101���Ŷ� | ��Ƶ��ƪ�l�Ƭ�0
		 mbList = new MemberData[101];
		 count = 0;
	}
	// ���o����
	public int getCount()
	{
		return count;
	}
	
	// ���o�}�C
	public MemberData[] getMemberData()
	{
		return mbList;
	}
	
	// ��ܸ��
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
	
	//  �ק�@���|�����: �s���B�m�W�B�����ҡB�ͤ�B�q��
	public void modify(int no, String n, String id, MemberBD bd, String p)
	{
		int index = this.search(no);
		this.mbList[index] = new MemberData(no, n, id, bd, p);
	}

	// �[�J�@���|�����: �s���B�m�W�B�����ҡB�ͤ�B�q��
	public void add(int no, String n, String id, MemberBD bd, String p)
	{
		// �s�W����
		MemberData newData = new MemberData(no, n, id, bd, p);
		// �Ŷ������h�X�R
		if (this.count >= mbList.length)
			this.resize();
		// ���Ʀs�J�}�C
		this.mbList[this.count++] = newData;
	}

	// �R���@���|�����: �s��
	public boolean delete(int no)
	{
		int index = this.search(no);
		if (index == -1)
		{
			System.out.println("�s�����s�b�I\n");
			return false;
		}
		else
		{
			// �ѫ�̻��ɫe��
			for (int i = 0; i < this.count - 1; i++)
			{
				if (i >= index)
					this.mbList[i] = this.mbList[i + 1];
			}
			// �R���@��
			this.count--;
			System.out.println("�R�����\�I");
		}
		return true;

	}

	// �ʺA�Ŷ�
	private void resize()
	{
		MemberData tempData[] = new MemberData[mbList.length * 2];
		for (int i = 0; i < this.count; i++)
			tempData[i] = this.mbList[i];
		// mbList���V����
		this.mbList = null;
		this.mbList = tempData;
	}

	// �Ȧs�b�h�^��index, ���s�b�h-1
	public int search(int x)
	{
		for (int i = 0; i < this.count; i++)
		{
			if (x == this.mbList[i].getNo())
				return i;
		}
		// ���s�b
		return -1;
	}

	// �s���P�_
	public int judgeNo(int opt)
	{
		// 2: add | 4: modify
		if (opt == 2)
			System.out.print("�s��(����0-100)�G");
		else if (opt == 4)
			System.out.print("��J�s���G");
		int no = scanner.nextInt();

		// �|���s����������0��100����: ���~�I�W�X�d��I -> '-1'
		if (no < 0 || no > 100)
		{
			System.out.println("���~�I�W�X�d��I");
			return -1;
		}
		// �Ӧ�}�|���ϥ�: ���T -> '-3'
		if (this.search(no) == -1)
		{
			// opt4: ���~�I�s�����s�b�I -> '-2'
			if (opt == 4)
			{
				System.out.println("���~�I�s�����s�b�I");
				return -2;
			}
			// opt = 2
			else
				return no;
		}
		// �Ӧ�}�s�b: 
		else
		{
			// opt2: ���~�I�s�����ơI -> '-2'
			if (opt == 2)
			{
				System.out.println("���~�I�s�����ơI");
				return -2;
			}
			// opt = 4
			else
				return no;
		}

	}

	// �s���P�_
	public String judgeId()
	{
		System.out.print("�����ҡG");
		String id = scanner.next();
		// �^���ഫ���j�g�A�Ʀr�T�w
		char idArr[] = id.toUpperCase().toCharArray();
		int codeTrue = 0;
		// �����Ҧr���GA-Z
		int charArr[] = { 10, 11, 12, 13, 14, 15, 16, 17, 34, 18, 19, 20, 21, 22, 35, 23, 24, 25, 26, 27, 28, 29, 32,
				30, 31, 33 };
		
		// �^��G�Q�i�� A-Z: 65-90 
		if ((int) idArr[0] >= 65 && (int) idArr[0] <= 90)
		{
			// �ʧO�G�Q�i�� 1-2: 49-50
			if ((int) idArr[1] >= 49 && (int) idArr[1] <= 50)
			{
				// 1~7�s���G�Q�i�� 0-9: 48-57
				for (int i = 2; i <= 8; i++)
				{
					// codeTrue all right is '7'
					if ((int) idArr[i] >= 48 && (int) idArr[i] <= 57)
						codeTrue++;
				}
				if (codeTrue == 7)
				{
					// A-Z: 65-90 �নindex��� A: 65 ->0
					// char: 
					int firstChar = idArr[0] - 'A';
					int num1 = charArr[firstChar] / 10 + (charArr[firstChar] % 10) * 9;
					int total = num1;

					// �p��ä���ˬd�X
					for (int i = 1, j = 8; i <= 8; i++, j--)
						total += ((idArr[i] - '0') * (j));

					if (idArr[9] - '0' == 10 - (total % 10))
						return id;
				}

			}

		}
		// �����Ҧr������
		System.out.println("���~�I�Э��s��J�I");
		return "";

	}

	// �q�ܧP�_
	public String judgePhone()
	{
		System.out.print("�q�ܡG");
		String phone = scanner.next();
		char idArr[] = phone.toCharArray();
		if (idArr[0] == '0')
			if (idArr.length >= 9 && idArr.length <= 10)
				return phone;

		// �q�ܸ��X����
		System.out.println("���~�I�Э��s��J�I");
		return "";
	}

}
