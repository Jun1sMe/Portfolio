/* v0819
 * -�קﳡ��-
 * --�ˬd���Ƹ��X�A�Y���ƫh�ӼƤ��p�J
 * --�վ�}�����G�A���T���
 * --�ק襤������A�p��I�����B: �����H���i���
 * --�u�Ƥ����P�_�A�R�������j��B�h���P�_
 * --�w�]��l�ƭȡA���`�ϥα���
 */


import java.util.Scanner;
public class Problem1_lot {

	public static int urCash, gamble, prize;
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ��l��
		initialization();
		int option = 0;
		
		while(true)
		{
			if(option == 0)
			{
				System.out.print("1) ñ�` 2) �פ�: ");
				option = scanner.nextInt();
			}
			
			if(option == 1)
			{
				System.out.print("�ʶR�i�ơG");
				int ticket = scanner.nextInt();
				
				// ����`���B�B�j���ܼ�
				int total = 0, bigPrize = 0;
				
				if(ticket * gamble > urCash)
				{
					System.out.println("�{�������I");
					continue;
				}
				else
					System.out.println("\n�z�ʶR�F" + ticket + "�i�ֳz�C");
				
				int ticketArr[][] = new int[ticket][5];
				for(int i = 0 ; i < ticket ; i++)
				{
					geneRandom(ticketArr[i]);
				}
				// �ֳz�}��
				int lottoNumbers[] = new int[5];
				geneRandom(lottoNumbers);
				System.out.print("�����}�X���X�G ");
				printArr(lottoNumbers);
				System.out.println("\n");
				
				// �q���︹
				for(int i = 0 ; i < ticket ; i++)
				{
					System.out.print("�zñ�`����" + (i + 1) +"�ո��X���G");
					printArr(ticketArr[i]);
					System.out.print("�K�K");
					int react = Match(ticketArr[i], lottoNumbers);
					if(react == 1)
					{
						System.out.println("���߱z�I���Y��");
						if(bigPrize++ == 0)
							total += prize;
					}
					else if(react == 2)
					{
						System.out.println("���߱z�I���L��");
						total += prize * 0.2;
					}
					else if(react == 3)
					{
						System.out.println("���߱z�I���Ѽ�");
						total += prize * 0.01;
					}
					else
						System.out.println("�b�t");
				}			

				System.out.println("�z�`�@�o��" + total + "���I");
				urCash = urCash + total - (ticket * gamble);
				System.out.println("��������Ѿl  " + urCash + " ��\n");
				
				// �����Ѿl: ���������o�X�A���W�W�[�B��
				prize = (int)((prize - total) * 1.06);
				// �����k�s��
				if(prize <= 0)
					prize = 10000000;
				
				if(urCash == 0)
					option = 2;
				else			
					option = 0;
			}
			
			else if(option == 2)
			{
				System.out.println("�P�±z�ϥΥ��t��!");
				break;
			}
			
			else
			{
				System.out.println("��J���~! �Э���");
				option = 0;
			}
		}

	}
	
	// �ƨ禡: ��l��
	public static void initialization()
	{
		// urCash
		while(true)
		{
			System.out.print("��������G");
			urCash = scanner.nextInt();
			if(urCash < 1)
			{
				System.out.print("��J���~! �Э��s��J");
			}
			else
				break;
		}
		// gamble
		while(true)
		{
			System.out.print("\n�ֳz�m�@�`ñ�`���B�G");
			gamble = scanner.nextInt();
			if(gamble < 1)
			{
				gamble = 50;
				System.out.println("��T���~! �@�`ñ�`���B: " + gamble);
			}
			break;
		}
		// prize
		while(true)
		{
			System.out.print("�ֿn�����G");
			prize = scanner.nextInt();
			if(prize < 1)
			{
				prize = 10000000;
				System.out.println("��T���~! �ثe�ֿn����: " + prize);
			}
			break;
		}
		System.out.println("=========================");
	}
	
	// �ƨ禡: �H�����X
	public static void geneRandom(int[] Numbers)
	{
		for(int i = 0 ; i < 5 ; i++)
		{
			int temp = (int)(Math.random() * 32) + 1;
			if(isDuplicated(temp, Numbers) == 0)
				Numbers[i] = temp;
			// �����ƪ��Ʀr�A�h�������p
			else
				i--;
		}
	}
	
	// �ƨ禡: ��X
	public static void printArr(int[] Numbers)
	{
		for(int i = 0 ; i < Numbers.length ; i++)
			System.out.print(Numbers[i] + " ");
	}
	
	// �ƨ禡: ���1 ->�P�_key�O�_���b�}�Cs��
	public static int isDuplicated(int key, int[] s)
	{
		for(int i = 0 ; i < s.length ; i++)
			//�����ƪ��Ʀr�A�Ц^��1
			if(key == s[i])
				return 1;
		// �_�h�^��0
		return 0;
	}
	
	// �ƨ禡: ���2 ->ñ�`���ƦrmyNumbers�O�_�P�}�X���ƦrlottoNumbers�ۦP
	public static int Match(int[] myNumbers, int[] lottoNumbers)
	{	
		int same3 = 0, same4 = 0, same5 = 0;
	
		for(int i = 0; i < myNumbers.length; i++)
		{
			// �Y�����
			if(isDuplicated(myNumbers[i], lottoNumbers) == 1)
				same5++;
			// �L�����
			if(i == 1 && myNumbers[i] == lottoNumbers[i])
				same4++;
			// �Ѽ����
			else if(i >= 2 && myNumbers[i] == lottoNumbers[i])
				same3++;
		}
		// ���X�����o������100%�]�Y���^ ->�襤�Y���^��1
		if(same5 == myNumbers.length)
			return 1;
		// ��|�X�o������20%�]�L���^ ->�襤�G���^��2
		else if(same4 == 1 && same3 == myNumbers.length - 2)
			return 2;
		// ��T�X�o������1%�]�Ѽ��^ ->�襤�Ѽ��^��3
		else if(same3 == myNumbers.length - 2)
			return 3;
		// �_�h�^��0
		return 0;
	}

}
