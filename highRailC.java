package lesson4_2;
import java.util.Scanner;

public class highRailC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int buyTicket;
		int greaterCash5 = 0, greaterCash1 = 0;						// �ŧi�W�L�w���s�����s��ƭ�
		int smallerCash5 = 0, smallerCash1 = 0;						// �ŧi�L�k��s���s��ƭ�
		int getCash10 = 0, getCash5 = 0, getCash1 = 0;				// �ŧi�Τ��ڨ��o���s��
		int coin10, coin5, coin1;									// �ŧi�s��10���B5���B1���ƶq��30
		
		System.out.println("�u�@�H����J���x���w���Ӽ�: ");
		System.out.print("1���w���Ӽ�: ");
		coin1 = scanner.nextInt();
		System.out.print("5���w���Ӽ�: ");
		coin5 = scanner.nextInt();
		System.out.print("10���w���Ӽ�: ");
		coin10 = scanner.nextInt();
		
		do 															// �T�{�ʲ��i���ư���
		{
			System.out.print("�ʲ� 1)�O 2)�_? ");
			buyTicket = scanner.nextInt();							// �ŧi����ܼ�buyTicket�æs���J��
			if(buyTicket == 2)
				System.out.println("�P�¨ϥΥ��t��!");
			else if(buyTicket == 1)									// �ʲ�����
			{														// �ŧi�_�W���B���ơB�����B�`���B��J���B�ê�l��					
				int startStop, endStop = 0, ticketNum = 0, ticketPrice = 0, cash = 0, throwCash = 0;								
				System.out.println(buyTicket + "\n" + "�}�l�ʲ��I");
				do 													// �^�W�@�B���j�����
				{				
					System.out.println("��ܰ_���G1)�x�_ 2)�x�� 3)���� 4)����: ");
					startStop = scanner.nextInt();									
					switch(startStop)								// �P�_��J���_��
					{
						case 1:
							do
							{
								System.out.println("��ܰW���G1)�x�_ 2)�x�� 3)���� 4)�^�W�@�B 5)����: ");
								endStop = scanner.nextInt();
								if(endStop == 1)
									System.out.println("�_�W���ۦP! �Э��s��ܰW��");
								else if(endStop < 1 || endStop > 5)
									System.out.println("�L���ﶵ! �Э��s��ܰW");
								else if(endStop == 5)
								{
									System.out.println("�����ʲ��I");					// ��J5�h�����ʲ�
									break;				
								}
								else if(endStop == 4)
									break;								
								else if(endStop >= 2 && endStop <= 3)
									do
									{
										System.out.println("��ܱi�ơG1) 1 �i 2) 2 �i 3) 3 �i 4)�^�W�@�B 5)����: ");
										ticketNum = scanner.nextInt();
										if(ticketNum < 1 || ticketNum >5)
											System.out.println("�i�ƿ��~! �Э��s��J�i��");
									}while(ticketNum < 1 || ticketNum > 5);								
									if(ticketNum == 5)
										break;
									else if(ticketNum == 4)
										continue;									
							}while(endStop <= 1 || endStop > 5 || ticketNum == 4);	// �_�W���ۦP�άO��J��L�ȡB�ʲ��^�W�@�B						
							if(endStop == 4)										// ��J4�h�A���s��ܿ�ܰ_��						
								continue;									
							break;													// end case
						
						case 2:
							do
							{
								System.out.println("��ܰW���G1)�x�_ 2)�x�� 3)���� 4)�^�W�@�B 5)����: ");
								endStop = scanner.nextInt();
								if(endStop == 2)
									System.out.println("�_�W���ۦP! �Э��s��ܰW��");
								else if(endStop < 1 || endStop > 5)
									System.out.println("�L���ﶵ! �Э��s��ܰW");
								else if(endStop == 5)
								{
									System.out.println("�����ʲ��I");					// ��J5�h�����ʲ�
									break;				
								}
								else if(endStop == 4)
									break;								
								else if(endStop == 1 || endStop == 3)
									do
									{
										System.out.println("��ܱi�ơG1) 1 �i 2) 2 �i 3) 3 �i 4)�^�W�@�B 5)����: ");
										ticketNum = scanner.nextInt();
										if(ticketNum < 1 || ticketNum >5)
											System.out.println("�i�ƿ��~! �Э��s��J�i��");
									}while(ticketNum < 1 || ticketNum > 5);								
									if(ticketNum == 5)
										break;
									else if(ticketNum == 4)
										continue;									
							}while(endStop < 1 || endStop > 5 || endStop == 2 || ticketNum == 4);// �_�W���ۦP�άO��J��L�ȡB�ʲ��^�W�@�B						
							if(endStop == 4)										// ��J4�h�A���s��ܿ�ܰ_��						
								continue;									
							break;													// end case
							
						case 3:
							do
							{
								System.out.println("��ܰW���G1)�x�_ 2)�x�� 3)���� 4)�^�W�@�B 5)����: ");
								endStop = scanner.nextInt();
								if(endStop == 3)
									System.out.println("�_�W���ۦP! �Э��s��ܰW��");
								else if(endStop < 1 || endStop > 5)
									System.out.println("�L���ﶵ! �Э��s��ܰW");
								else if(endStop == 5)
								{
									System.out.println("�����ʲ��I");					// ��J5�h�����ʲ�
									break;				
								}
								else if(endStop == 4)
									break;								
								else if(endStop == 1 || endStop == 2)
									do
									{
										System.out.println("��ܱi�ơG1) 1 �i 2) 2 �i 3) 3 �i 4)�^�W�@�B 5)����: ");
										ticketNum = scanner.nextInt();
										if(ticketNum < 1 || ticketNum >5)
											System.out.println("�i�ƿ��~! �Э��s��J�i��");
									}while(ticketNum < 1 || ticketNum > 5);								
									if(ticketNum == 5)
										break;
									else if(ticketNum == 4)
										continue;									
							}while(endStop < 1 || endStop > 5 || endStop == 3 || ticketNum == 4);// �_�W���ۦP�άO��J��L�ȡB�ʲ��^�W�@�B						
							if(endStop == 4)										// ��J4�h�A���s��ܿ�ܰ_��						
								continue;									
							break;													// end case
								
						default:
							System.out.println("�����ʲ��I");
							break;					
					}
					if(startStop != 4 && ticketNum >= 1 && ticketNum <=3)		// �����ʲ��h���L���q
					{															// �P�_�_�W������A�ÿ�X����
						if(startStop == 1 && endStop == 2)
							System.out.println("�f�� �x�_��x���C���A�y��@ " + ticketNum + " �i�A���� " + 536 * ticketNum + "��" );
						else if(startStop == 2 && endStop == 1)
							System.out.println("�f�� �x����x�_�C���A�y��@ " + ticketNum + " �i�A���� " + 536 * ticketNum + "��" );	
						else if(startStop == 2 && endStop == 3)
							System.out.println("�f�� �x���찪���C���A�y��@ " + ticketNum + " �i�A���� " + 536 * ticketNum + "��" );		
						else if(startStop == 3 && endStop == 2)
							System.out.println("�f�� ������x���C���A�y��@ " + ticketNum + " �i�A���� " + 536 * ticketNum + "��" );
						else if(startStop == 1 && endStop == 3)
							System.out.println("�f�� �x�_�찪���C���A�y��@ " + ticketNum + " �i�A���� " + 927 * ticketNum + "��" );
						else if(startStop == 3 && endStop == 1)
							System.out.println("�f�� ������x�_�C���A�y��@ " + ticketNum + " �i�A���� " + 927 * ticketNum + "��" );
												
						ticketPrice = Math.abs(startStop - endStop);			// �Q�ί��Z�B���ƭp�Ⲽ��
						switch(ticketPrice)
						{
							case 1:
								ticketPrice = 536 * ticketNum;
								break;
							case 2:
								ticketPrice = 927 * ticketNum;
								break;
						}
						do														// ���ƧP�_��J�{������j�󲼻�
						{
							System.out.print("�Ч�J�{���G 1) 50�� 2) 100�� 3) 500�� 4) 1000�� 5)����: ");
							throwCash = scanner.nextInt();
							switch(throwCash)
							{
								case 1:
									cash += 50;
									break;
								case 2:
									cash += 100;
									break;
								case 3:
									cash += 500;
									break;
								case 4:
									cash += 1000;
									break;
								case 5:
									break;					
							}
						}while(cash < ticketPrice && throwCash != 5);
						
						if (throwCash == 5)
							break;
						if (cash != 0)											// ��J�{������0�A�����I�ګh���L����
							System.out.println("���z" + cash + "��");
						int getCash = cash - ticketPrice;
						if(getCash > 0)											// �ݭn��s�h�i�J���q
						{
							if(coin10 > 0)										// �������|��10���w��
							{
								getCash10 = getCash / 10;						// �p�����䤧10���w��
								if(coin10 < getCash10)							// ���ѥΤᤧ10���w��
								{
									smallerCash5 = getCash10 - coin10;			// �������L10���w���A�h�H5���w������
									getCash10 = coin10;
								}								
							}
							else
								getCash10 = 0;									// �������L10���w��
							if(coin5 > 0)										// �������|��5���w��
							{													// �p�����䤧5���w��
								getCash5 = (getCash % 10) / 5 + smallerCash5 * 2;
								if(coin5 < getCash5)							// ���ѥΤᤧ5���w��
								{
									smallerCash1 = getCash5 - coin5;			// �������L5���w���A�h�H1���w������
									getCash5 = coin5;
								}
							}
							else
								getCash5 = 0;									// �������L5���w��
							if(coin1 > 0)										// �������|��1���w��
							{													// �p�����䤧1���w��
								getCash1 = (getCash % 10) % 5 + smallerCash1 * 5;								
							}
							else
							{
								System.out.println("�{�������A�L�k��s�A�Ь��d�O�H��");
								break;	
							}
							if(getCash != getCash10 *10 + getCash5 * 5 + getCash1 *1)
							{													// �����ѥΤᤧ�w���P�����Ѥ���
								System.out.println("�{�������A�L�k��s�A�Ь��d�O�H��");
								break;	
							}
							coin10 = 30 - getCash10;							// ����������s���w��
							coin5 = 30 - getCash5;
							coin1 = 30 - getCash1;
							
							System.out.println("��z" + getCash + "��");					
							System.out.println("�h�^10���w��" + getCash10 + "�ӡA5���w��" + getCash5 + "�ӡA1���w��" + getCash1 +"��");						
						}
						System.out.println("�O�ѤF�����z�������A����!");
					}			
					
				}while(endStop == 4);								
				System.out.println("�P�¨ϥΥ��t��!");
			}
			else													// �w�C�X1=�O�B2=�_���ʲ��ﶵ�A�����ҥ~���p�w�]
				System.out.println("This button is empty!");
		}while(buyTicket == 1);

	}

}
