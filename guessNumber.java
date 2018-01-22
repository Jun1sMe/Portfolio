import java.util.Scanner;
public class guessNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String player = "���a";						// �ŧi�r���ܼƪ��a�B�q��
		String computer = "�q��";
		boolean again = true;						// ���s�C���P�_
		int winP = 0, winC = 0;						// �ӧQ����
		int who1st = randomAorB();					// �ŧiwho1st���P�_�G��@
		int leftHandP, rightHandP, guessHandP = 0;
		System.out.print("�H���M�w����G");
		if(who1st == 0)
			System.out.print(player);
		else
			System.out.print(computer);			
		System.out.println("���C");
		System.out.println("======�C���}�l======");

		while(again)								// �C���`��
		{
			while(true)								// �X������0��5
			{
				System.out.print("�X���]����/�k��^�G ");
				leftHandP = scanner.nextInt();
				rightHandP = scanner.nextInt();
				if(leftHandP == 0 || leftHandP == 5)
					if(rightHandP == 0 || rightHandP == 5)
						break;
				System.out.println("�p����: �X���ȯ�0��5");
			}		
			System.out.println(leftHandP + " " + rightHandP);
			
			if(who1st == 0)							// ���a����A�h�q���y
			{
				while(true)
				{
					System.out.print("���y�G");
					guessHandP = scanner.nextInt();
					if(guessHandP == 0 || guessHandP == 5 || guessHandP == 10
							|| guessHandP == 15 || guessHandP == 20)
						if(guessHandP >= leftHandP + rightHandP)
							break;					
						else
							System.out.println("�p����: ���y���j��ε���ۤv�X���`�M");	
					else
						System.out.println("�p����: ���y�����������ơA�ܦh20");	
				}
				if(guessHandP == 0)
					System.out.println("�S��");
				else
					System.out.println(guessHandP);
			}
			
			int leftHandC = randomAorB();			// �P�_�G��@: ����
			int rightHandC = randomAorB();			// �P�_�G��@: �k��
			int guessHandC = 0;						// ���y�����p��M��
			System.out.print("�q��: ");
			System.out.print(rightHandC + " ");
			System.out.print(leftHandC + " ");
			
			if(who1st == 5)							// �q������A�h�q���y
			{										// ���y�����v��+0~+10 
				guessHandC = randomAtoC() + leftHandC + rightHandC;			
				if(guessHandC == 0)
					System.out.print("�S��");
				else
					System.out.print(guessHandC);
			}			
			System.out.print("\n");
			
			// �`��
			int sumHand = leftHandP + rightHandP + leftHandC + rightHandC;
			System.out.print("���a: " + leftHandP + " " + rightHandP + " ");
			if(who1st == 0)							// ���a����A��ܮ��y
				System.out.print(guessHandP);
			System.out.println("\n�`��: " + sumHand);	// ����`��

			if(who1st == 0 && guessHandP == sumHand)
			{										// ���a����B�q��
				if(++winP < 2)						// ��Ӥ����ť�P
					System.out.println(player + "ť�P");
			}
			else if(who1st == 5 && guessHandC == sumHand)
			{										// �q������B�q��
				if(++winC < 2)						// ��Ӥ����ť�P
					System.out.println(computer + "ť�P");
			}
			else
			{
				System.out.println("�U�@�^�X");
				if(who1st == 0)						// ��u����
					who1st = 5;
				else
					who1st = 0;
			}				
			System.out.print("\n");					// �C���������Z
			
			if(winP == 1 || winC == 1)				// �K�ߴ���
			{
				System.out.print("�`�N! ");
				if(winP == 1)
					System.out.print(player);
				else
					System.out.print(computer);
				System.out.print("�wť�P\n");
			}	

			if(winP == 2 || winC == 2)				// ��o��ӧY�ӥX
			{				
				if(winP == 2)
					System.out.println(player + "��ӡI");
				else
					System.out.println(computer + "��ӡI");
				
				while(true)							// �P�_�~��P�_
				{
					System.out.print("�аݬO�_�~�� (Y/N)�H ");
					char gameX = scanner.next().charAt(0);
					if(gameX == 'Y' || gameX == 'y')
					{
						winP = 0;						// �k�s
						winC = 0;
						System.out.print("\n");			// �C���������Z
						break;
					}
					else if(gameX == 'N' || gameX == 'n')
					{
						again = false;					// �C������
						System.out.println("\n" + "�C�������C");
						break;
					}
					else
						System.out.println("\n" + "��J���~! ����: ");					
				}
				
			}

		}

	}
	
// �ƨ禡��	
	public static int randomAorB()					// �P�_�G��@: �^��0��5
	{
		int A = (int)(Math.random() * 10);			// �j���ഫ������ܼơA�ƭ�0~9
		if(A < 5)									// 0~4���P�_�@�B5~9���P�_�G
			return 0;
		else
			return 5;
	}
	public static int randomAtoC()					// �P�_�T��@: �^�ǤT�Ӽƭ�
	{
		int A = (int)(Math.random() * 4 + 1);		// �j���ഫ������ܼơA�ƭ�1~4
		if(A == 1)									// ���a�X��0, 0���|1/4
			return 0;
		else if(A >= 2 && A <= 3)					// ���a�X��0, 5���|1/2
			return 5;
		else										// ���a�X��5, 5���|1/4
			return 10;
	}
	
}
