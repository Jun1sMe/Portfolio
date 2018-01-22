import java.util.Scanner;

public class TestUnit
{
	// �����ثe��m
	public static CUniversity cur;
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		// �ŧi�j�ǦW��
		CUniversity myUni = new CUniversity("OO�j��");
		cur = myUni;
		// ���A����
		int flow = 0, optA = -1, optB = -1;

		while (true)
		{
			// �Ǯ�
			if (flow == 0)
			{
				if(optA == -1)
				{
					// ���Y(���|)
					System.out.println(cur.getPath());
					optA++;
				}
				// ���
				if(optA == 0)
					optA = cur.menu();
				// 1:�s�W
				if (optA == 1)
				{
					// ���G
					System.out.print("1:�Ǩt, 2:��F���, -1:����: ");
					int optA3 = scanner.nextInt();
					// �Ǩt
					if (optA3 == 1)
					{
						System.out.print("�W�١G");
						String name = scanner.next();
						CUniversity temp = new CDepartment(name, myUni);
						myUni.add(temp);
						System.out.println("�s�W���\�I\n");
						optA = 0;
					} 
					// ��F���
					else if (optA3 == 2)
					{
						System.out.print("�W�١G");
						String name = scanner.next();
						CUniversity temp = new CAdministration(name, myUni);
						myUni.add(temp);
						System.out.println("�s�W���\�I\n");
						optA = 0;
					} 
					// ����
					else if (optA3 == -1)
						optA = 0;
					// error
					else
						printError();
				}
				// 2:�i�J
				else if (optA == 2)
				{
					if (myUni.getDepartCount() == 0)
					{
						System.out.println("�S�������ơI\n");
						optA = 0;
					} 
					else
					{
						// ��ܤj�ǳ���				
						int opt2 = myUni.showList();
						// ��^
						if (opt2 == -1)
							optA = 0;
						// error
						else if(opt2 <= 0 || opt2 > myUni.getDepartCount())
							printError();
						else
						{
							cur = myUni.getPos(opt2 - 1);
							System.out.println();
							flow = 1;
							optA = -1;
						}
					}
				}
				// 3:�L�X�Ҧ��H��
				else if (optA == 3)
				{
					int count = 0;
					// Method1
//					((CUniversity) myUni.getDepartList()[i]).printAll();						
					// Method2
					for(int i = 0 ; i < myUni.getDepartCount(); i++)
						count += myUni.getPos(i).printAll();					
					
					if(count == 0)
						System.out.println("�|�L���");
					// new line
					System.out.println();					
					optA = 0;
				}
				// -1:����
				else if (optA == -1)
				{
					System.out.println("�P�¨ϥΥ��t�ΡC");
					break;
				}
				// error
				else
				{
					printError();
					optA = 0;
				}
				
			}
			// ����
			if(flow == 1)
			{				
				if(optB == -1)
				{
					// ���Y�B���|
					System.out.println(cur.getPath());
					optB++;
				}
				if(optB == 0)
				{	
					int reply = cur.menu();
					// ���G -1��^
					if(reply == -1)
					{
						System.out.println();
						cur = myUni;
						flow = 0;
						optA = -1;
						optB = -1;
					}
					// 4: print, 5: error
					else if(reply == 4 || reply == 5)
						continue;
					else
						System.out.println("�s�W���\�I\n");
									
				}

			}

		}

	}
	// print error
	public static void printError()
	{
		System.out.println("Error! Try again.");
	}

}
