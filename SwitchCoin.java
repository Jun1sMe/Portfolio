package lesson009_1;
import java.util.Scanner;
public class SwitchCoin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("1���w���ӼơG");
		int input1 = input.nextInt();
		System.out.print("5���w���ӼơG");
		int input2 = input.nextInt();
		System.out.print("10���w���ӼơG");
		int input3 = input.nextInt();
		System.out.println("---------------------------------------------------------------------------------\n");
		CCalculator obj = new CCalculator(input3, input2, input1);

		while(true)
		{
			System.out.print("���s�� 1)�O 2)�_? ");
			int select = input.nextInt();
			// 1)�O
			if(select == 1)
			{
				int total = 0, throwMoney;
				while(true)
				{
					System.out.print("�Ч�J�{���G 1) 50�� 2) 100�� 3) 500��4) 1000�� 5)���� -1)����: ");
					throwMoney = input.nextInt();
					if(throwMoney == -1)
					{
						System.out.println("�������");
						select = 2;
						break;
					}
					else if(throwMoney >= 1 && throwMoney <= 4)
					{
						switch(throwMoney)
						{
						case 1:
							total += 50;
							break;
						case 2:
							total += 100;
							break;
						case 3:
							total += 500;
							break;
						case 4:
							total += 1000;
							break;
						}
					}
					else if(throwMoney == 5)
						break;					
					else
						System.out.println("Error! Try again.");
				}
				if(throwMoney == 5)
				{
					int[] coin = obj.change(total);
					obj.printOut(coin);
				}
					
			}
			// 2)�_
			if(select == 2)
			{
				System.out.println("�P�¨ϥΥ��t��\n");	
			}
			if(select != 1 && select != 2)
				System.out.println("Error! Try again.");
			
		}
		
	}

}
// �I����
class CCalculator {

	// �ȨѦP���O�s���B�ϥ�
	private int coin10, coin5, coin1;
	// �غc�l�A�]�w�I��������Ʀ���
	public CCalculator(int n10, int n5, int n1)
	{
		if(n10 >= 0)
			coin10 = n10;
		if(n5 >= 0)
			coin5 = n5;
		if(n1 >= 0)
			coin1 = n1;
	}
	// �ƨ�ơAamount�����I�������B�A�бN�ӵw���ƶq��J�}�C����Ǧ^�C
	public int[] change(int amount) {
		
		// ����s
		int get10 = 0, get5 = 0, get1 = 0;
		int[] coin = new int[3];
		
		// 10���w��
		if(coin10 > 0)
		{
			// ���䤧10���w��
			get10 = amount / 10;
			
			// 10���w�������A����5���w��
			if(coin10 < get10)
			{
				get10 = get10 - coin10;
				coin[0] = coin10;
			}
			// 10���w���|��//
			else
			{
				coin[0] = get10;
				get10 = 0;
			}
		}
		else
			coin[0] = 0;
		
		// 5���w��	
		if(coin5 > 0)
		{
			// ���䤧5���w��
			get5 = (amount % 10) / 5 + get10 * 2;
			// 5���w�������A����1���w��
			if(coin5 < get5)
			{
				get5 = get5 - coin5;
				coin[1] = coin5;
			}
			// 5���w���|��
			else
			{
				coin[1] = get5;
				get5 = 0;
			}
		}
		else
			coin[1] = 0;

		// 1���w��		
		if(coin1 > 0)
		{
			// ���䤧1���w��
			get1 = (amount % 10) % 5 + get5 * 5;
			// 1���w������
			if(coin1 < get1)
				return null;
			// 1���w���|��
			else
			{
				coin[2] = get1;
				get1 = 0;
			}
			
		}
		else
			coin[2] = 0;
		
		// �����ѥΤᤧ�w���P�����Ѥ���
		if(amount != coin[0] *10 + coin[1] * 5 + coin[2] *1)
		{
			return null;
		}
		else
		{
			coin10 -= coin[0];
			coin5 -= coin[1];
			coin1 -= coin[2];
			return coin;
		}

	}

	public void printOut(int[] coins) {

		if(coins != null)
		{
			System.out.println("�I��" + (coins[0] * 10 + coins[1] * 5 + coins[2]) + "��");
			System.out.print("�h�^");
			if(coins[0] > 0)
			{
				System.out.print("10���w��" + coins[0] + "��");
				if(coins[1] > 0 || coins[2] > 0)
					System.out.print("�A");
			}
			if(coins[1] > 0)
			{
				System.out.print("5���w��" + coins[1] + "��");
				if(coins[2] > 0)
					System.out.print("�A");
			}
			if(coins[2] > 0)
				System.out.print("1���w��" + coins[2] + "��");				

		}
		else
			System.out.println("�{�������A�L�k��s�A�Ь��d�O�H��");
		
		System.out.println("\n");
	}
}
