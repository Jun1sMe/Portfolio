package lesson009_1;
import java.util.Scanner;
public class SwitchCoin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("1元硬幣個數：");
		int input1 = input.nextInt();
		System.out.print("5元硬幣個數：");
		int input2 = input.nextInt();
		System.out.print("10元硬幣個數：");
		int input3 = input.nextInt();
		System.out.println("---------------------------------------------------------------------------------\n");
		CCalculator obj = new CCalculator(input3, input2, input1);

		while(true)
		{
			System.out.print("換零錢 1)是 2)否? ");
			int select = input.nextInt();
			// 1)是
			if(select == 1)
			{
				int total = 0, throwMoney;
				while(true)
				{
					System.out.print("請投入現金： 1) 50元 2) 100元 3) 500元4) 1000元 5)結束 -1)取消: ");
					throwMoney = input.nextInt();
					if(throwMoney == -1)
					{
						System.out.println("交易取消");
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
			// 2)否
			if(select == 2)
			{
				System.out.println("感謝使用本系統\n");	
			}
			if(select != 1 && select != 2)
				System.out.println("Error! Try again.");
			
		}
		
	}

}
// 兌幣機
class CCalculator {

	// 僅供同類別存取、使用
	private int coin10, coin5, coin1;
	// 建構子，設定兌幣機的資料成員
	public CCalculator(int n10, int n5, int n1)
	{
		if(n10 >= 0)
			coin10 = n10;
		if(n5 >= 0)
			coin5 = n5;
		if(n1 >= 0)
			coin1 = n1;
	}
	// 副函數，amount為欲兌換的金額，請將個硬幣數量放入陣列中後傳回。
	public int[] change(int amount) {
		
		// 應找零
		int get10 = 0, get5 = 0, get1 = 0;
		int[] coin = new int[3];
		
		// 10元硬幣
		if(coin10 > 0)
		{
			// 應找之10元硬幣
			get10 = amount / 10;
			
			// 10元硬幣不足，提供5元硬幣
			if(coin10 < get10)
			{
				get10 = get10 - coin10;
				coin[0] = coin10;
			}
			// 10元硬幣尚足//
			else
			{
				coin[0] = get10;
				get10 = 0;
			}
		}
		else
			coin[0] = 0;
		
		// 5元硬幣	
		if(coin5 > 0)
		{
			// 應找之5元硬幣
			get5 = (amount % 10) / 5 + get10 * 2;
			// 5元硬幣不足，提供1元硬幣
			if(coin5 < get5)
			{
				get5 = get5 - coin5;
				coin[1] = coin5;
			}
			// 5元硬幣尚足
			else
			{
				coin[1] = get5;
				get5 = 0;
			}
		}
		else
			coin[1] = 0;

		// 1元硬幣		
		if(coin1 > 0)
		{
			// 應找之1元硬幣
			get1 = (amount % 10) % 5 + get5 * 5;
			// 1元硬幣不足
			if(coin1 < get1)
				return null;
			// 1元硬幣尚足
			else
			{
				coin[2] = get1;
				get1 = 0;
			}
			
		}
		else
			coin[2] = 0;
		
		// 欲提供用戶之硬幣與應提供不符
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
			System.out.println("兌換" + (coins[0] * 10 + coins[1] * 5 + coins[2]) + "元");
			System.out.print("退回");
			if(coins[0] > 0)
			{
				System.out.print("10元硬幣" + coins[0] + "個");
				if(coins[1] > 0 || coins[2] > 0)
					System.out.print("，");
			}
			if(coins[1] > 0)
			{
				System.out.print("5元硬幣" + coins[1] + "個");
				if(coins[2] > 0)
					System.out.print("，");
			}
			if(coins[2] > 0)
				System.out.print("1元硬幣" + coins[2] + "個");				

		}
		else
			System.out.println("現金不足，無法找零，請洽櫃臺人員");
		
		System.out.println("\n");
	}
}
