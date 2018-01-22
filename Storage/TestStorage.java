import java.util.Scanner;

public class TestStorage
{
	public static Scanner scanner = new Scanner(System.in);
	// �`��+�����`�ƪ�l��10�a
	public static Store stores[] = new Store[10];

	public static void main(String[] args)
	{
		// �C�a�������~��
		for (int i = 0; i < stores.length; i++)
			stores[i] = new Store();

		// initialize the first flow
		int flow = 0;
		int storeNum = 0;

		while (true)
		{

			System.out.println("�u���x�޲z�t��v2.0�v");
			// ��������: ��ܤ���
			if (flow == 0)
			{
				while (true)
				{
					System.out.print("�п�J�����N��(0~9): ");
					storeNum = scanner.nextInt();
					if (storeNum >= 0 && storeNum <= 9)
					{
						// stores[storeNum] = new Store();
						flow++;
						break;
					}
					System.out.println("��J���~�I");
				}
			}

			System.out.println("=====�п�ܤU�C�ާ@=====");
			System.out.print("1) ��ܩҦ����\n" + "2) �W�[�ӫ~���\n" + "3) �X�f�n��\n" + "4) �i�f�n��\n" + "5) ���}�t��\n>>>");
			int opt = scanner.nextInt();
			System.out.println("===================");

			// ��ܩҦ����
			if (opt == 1)
			{
				for (int i = 0; i < stores.length; i++)
				{
					System.out.println("�N��" + i + "����: ");
					stores[i].showList();
				}
				// stores[storeNum].showList();

				System.out.print("�O�_�i�J��L�����i��ާ@(y/n): ");
				String changeStore = scanner.next();
				if (changeStore.equalsIgnoreCase("y"))
					flow = 0;
				
				System.out.println();
			}

			// �W�[�ӫ~���
			else if (opt == 2)
			{
				System.out.println("�п�J�U�C��T:");
				String no;
				while (true)
				{
					System.out.print("�ӫ~�s��: ");
					no = scanner.next();
					// �s���w�s�b
					if (stores[storeNum].search(no) != -1)
						System.out.print("�ӽs���w�s�W�A�Э��s��J");
					else
						break;
				}

				System.out.print("�ӫ~�W��: ");
				String name = scanner.next();
				System.out.print("���: ");
				int pri = scanner.nextInt();
				System.out.print("���: ");
				String uni = scanner.next();
				System.out.print("�s�y��: ");
				String mak = scanner.next();
				stores[storeNum].add(no, name, pri, uni, mak);
				System.out.println();
			}
			// �X/�i�f�n��: �t�η|����ܥثe�w�g�إߪ��ӫ~�A�A�n�D�ϥΪ̿�J�ӫ~
			else if (opt == 3 || opt == 4)
			{
				loadStuff(opt, storeNum);
			}
			// ���}�t��
			else if (opt == 5)
			{
				System.out.println("�P�±z�ϥΥ��t�ΡA\n�A��!");
				break;
			} 
			else
				System.out.println("��J���~�A�Э��աC\n");
		}

	}

	// function: loading stuff
	public static void loadStuff(int opt, int storeNum)
	{
		// �t�η|����ܥثe�w�g�إߪ��ӫ~
		if (stores[storeNum].showProduct())
		{
			// �ӫ~�s��
			String no;
			while (true)
			{
				System.out.print("�п�J�ӫ~�s��: ");
				no = scanner.next();
				// �s�����s�b
				if (stores[storeNum].search(no) == -1)
				{
					System.out.print("�ӽs�����s�b�A");
					continue;
				}
				break;
			}
			System.out.print("�п�J�ӫ~");
			if (opt == 3)
				System.out.print("�X");
			else
				System.out.print("�i");
			System.out.print("�f�ƶq: ");

			int numStock = scanner.nextInt();
			if (numStock < 1)
			{
				numStock = 0;
				System.out.println("�ާ@���ѡI\n");
			} 
			else
			{
				if (stores[storeNum].numStock(opt, no, numStock) == true)
					System.out.println("�ާ@���\�I\n");
				else
					System.out.println("�ӫ~�L�w�s�I\n");
			}

		}
	}

}
