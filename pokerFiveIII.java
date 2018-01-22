package lesson11_4;
import java.util.Scanner;
public class pokerFiveIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int initialize[][] = generatePoker();		
		// �~�P���Ƨ�
		shufflePoker(initialize, initialize.length);
		// ������5�i��P�B���a��4�H
		takePoker(initialize, 5, 4);
		
		int z = 1;			// ��P����
		while(true)
		{
			System.out.print("1)�~���P 2)���s�~�P -1)�����{��: ");
			int option = scanner.nextInt();
			
			if(option == 1)
			{
				if(z++ <= 5)
				{
					takePoker(initialize, 5, 4 + z);
					System.out.println();
				}
				else
					System.out.println("�P�X�w�šA�Э��s�~�P\n");			
			}
			else if(option == 2)
			{
				shufflePoker(initialize, initialize.length);
				takePoker(initialize, 5, 4);
				System.out.println();
			}
			else if(option == -1)
			{
				System.out.println("�{�������C");
				break;
			}
			else
				System.out.println("��J���~�A�Э��s��J");

		}
		
	}
		
	// �ƨ禡: ���J�P��
	public static int[][] generatePoker()
	{
		int boxPoker[][] = new int[52][2];

		int k = 0;
		for(int i = 1 ; i <= 4 ; i++)		// ��⬰4��
		{
			for(int j = 1 ; j <= 13 ; j++)	// �U13�i
			{
				boxPoker[k][0] = i;			// 0 -> ���
				boxPoker[k][1] = j;			// 1 -> �Ʀr
				k++;						// k���W
			}					
		}
		return boxPoker; 
	}
	// �ƨ禡: �~�P
	public static void shufflePoker(int[][] x, int count)
	{
		for(int i = 0 ; i < count ; i++)
		{
			int j = (int)(Math.random() * count);	// ������������
			int temp[] = x[j];						// �Ѧ��ܼƫ��V�Ӧ�}
			x[j] = x[i];
			x[i] = temp;		
		}
	}
	// �ƨ禡: ��P
	public static void takePoker(int[][] x, int count, int player)
	{
		// ��J�G���}�C: ���ެ�1~13�A0 -> �`�� �B1~4 -> �������
		int sortPoker[][] = new int[14][5];
		
		// ���P�����P��}
		int k = (int)(Math.random()* (x.length - (count * player)));
		System.out.println("�z����P��: ");
		
		for(int i = 0 ; i < count ; i++)				// ��P�i��
		{
			k += player;								// ���a�Ƭ����P����
			for(int j = 0 ; j <= 1 ; j++)				// ���μƦr
			{				
				if(j == 0)
				{
					if(x[k][0] == 1)
						System.out.print("�®� ");
					else if(x[k][0] == 2)
						System.out.print("���� ");
					else if(x[k][0] == 3)
						System.out.print("��� ");
					else if(x[k][0] == 4)
						System.out.print("���� ");						
				}
				else
				{
					if(x[k][1] == 1)
						System.out.print("A");
					else if(x[k][1] == 11)
						System.out.print("J");
					else if(x[k][1] == 12)
						System.out.print("Q");
					else if(x[k][1] == 13)
						System.out.print("K");
					else
						System.out.print(x[k][1]);
					System.out.print("\t");
					
					// ����1~4�p�O1��ܦs�b
					sortPoker[x[k][1]][x[k][0]]++;
					sortPoker[x[k][1]][0]++;
				}
				
			}
						
		}
		System.out.println();
//		printArr(sortPoker);
		
		// ����P��
		judgement(sortPoker);
	}
	// �ƨ禡: �P���P�_
	public static void judgement(int[][] x)
	{
		int group2 = 0, group3 = 0, group4 = 0, series = 0, seriesA = 0;	// ����: �@��B�T���B�|���A�s�e����
		int color1 = 0, color2 = 0, color3 = 0, color4 = 0;					// ���
		for(int k = 1 ; k <= 13 ; k++)
		{
			if(x[k][0] == 4)
			{
				group4++;
				break;
			}
			if(x[k][0] == 2)
				group2++;
			else if(x[k][0] == 3)
				group3++;
			// ���l�P�_
			else if(k <= 9)
			{
				for(int j = 0; j < 5 ; j++)
				{
					if(x[k + j][0] == 1)
						series++;
				}
			}
			// �j���l�P�_
			else if(k == 1 && x[k][0] == 1)
			{
				seriesA++;
				for(int j = 9; j < 13 ; j++)
				{
					if(x[k + j][0] == 1)
						series++;
				}
			}
			// �P��P�_
			else if(x[k][1] == 1)
				color1++;
			else if(x[k][2] == 1)
				color2++;
			else if(x[k][3] == 1)
				color3++;
			else if(x[k][4] == 1)
				color4++;				
		}
		
		if(group4 == 1)
			System.out.println("�|��");
		else if(group3 == 1)
		{
			if(group2 == 1)
				System.out.println("��Ī");
			else
				System.out.println("�T��");
		}
		else if(group2 == 2)
			System.out.println("���");
		else if(group2 == 1)
			System.out.println("�@��");
		else if(color1 == 5 || color2 == 5 || color3 == 5 || color4 == 5)
		{
			if(series == 5)
				System.out.println("�P�ᶶ");
			else if(series == 4 && seriesA == 1)
				System.out.println("�P��j��");
			else
				System.out.println("�P��");
		}
		else if(series == 5)
			System.out.println("���l");
		else if(series == 4 && seriesA == 1)
			System.out.println("���l");
		else
			System.out.println("���P");
	}
	
	// �ƨ禡: ��X
	public static void printArr(int[][] x)
	{
		for(int k = 0 ; k < x.length ; k++)
		{
			for(int j = 0 ; j < x[k].length ; j++)
				System.out.print(x[k][j] + "\t");
			System.out.println();
		}
		System.out.println();
	}
	
}
