/* v0819
 * -修改部分-
 * --檢查重複號碼，若重複則該數不計入
 * --調整開獎結果，正確顯示
 * --修改中獎機制，計算兌獎金額: 中獎人均可獲獎
 * --優化中獎判斷，刪除雙重迴圈、多重判斷
 * --預設初始數值，正常使用情境
 */


import java.util.Scanner;
public class Problem1_lot {

	public static int urCash, gamble, prize;
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 初始化
		initialization();
		int option = 0;
		
		while(true)
		{
			if(option == 0)
			{
				System.out.print("1) 簽注 2) 終止: ");
				option = scanner.nextInt();
			}
			
			if(option == 1)
			{
				System.out.print("購買張數：");
				int ticket = scanner.nextInt();
				
				// 獲獎總金額、大獎變數
				int total = 0, bigPrize = 0;
				
				if(ticket * gamble > urCash)
				{
					System.out.println("現金不足！");
					continue;
				}
				else
					System.out.println("\n您購買了" + ticket + "張樂透。");
				
				int ticketArr[][] = new int[ticket][5];
				for(int i = 0 ; i < ticket ; i++)
				{
					geneRandom(ticketArr[i]);
				}
				// 樂透開獎
				int lottoNumbers[] = new int[5];
				geneRandom(lottoNumbers);
				System.out.print("本期開出號碼： ");
				printArr(lottoNumbers);
				System.out.println("\n");
				
				// 電腦選號
				for(int i = 0 ; i < ticket ; i++)
				{
					System.out.print("您簽注的第" + (i + 1) +"組號碼為：");
					printArr(ticketArr[i]);
					System.out.print("……");
					int react = Match(ticketArr[i], lottoNumbers);
					if(react == 1)
					{
						System.out.println("恭喜您！中頭獎");
						if(bigPrize++ == 0)
							total += prize;
					}
					else if(react == 2)
					{
						System.out.println("恭喜您！中貳獎");
						total += prize * 0.2;
					}
					else if(react == 3)
					{
						System.out.println("恭喜您！中參獎");
						total += prize * 0.01;
					}
					else
						System.out.println("槓龜");
				}			

				System.out.println("您總共得到" + total + "元！");
				urCash = urCash + total - (ticket * gamble);
				System.out.println("持有資金剩餘  " + urCash + " 元\n");
				
				// 獎金剩餘: 獎金扣掉發出再乘上增加額度
				prize = (int)((prize - total) * 1.06);
				// 獎金歸零時
				if(prize <= 0)
					prize = 10000000;
				
				if(urCash == 0)
					option = 2;
				else			
					option = 0;
			}
			
			else if(option == 2)
			{
				System.out.println("感謝您使用本系統!");
				break;
			}
			
			else
			{
				System.out.println("輸入錯誤! 請重試");
				option = 0;
			}
		}

	}
	
	// 副函式: 初始化
	public static void initialization()
	{
		// urCash
		while(true)
		{
			System.out.print("持有資金：");
			urCash = scanner.nextInt();
			if(urCash < 1)
			{
				System.out.print("輸入錯誤! 請重新輸入");
			}
			else
				break;
		}
		// gamble
		while(true)
		{
			System.out.print("\n樂透彩一注簽注金額：");
			gamble = scanner.nextInt();
			if(gamble < 1)
			{
				gamble = 50;
				System.out.println("資訊錯誤! 一注簽注金額: " + gamble);
			}
			break;
		}
		// prize
		while(true)
		{
			System.out.print("累積獎金：");
			prize = scanner.nextInt();
			if(prize < 1)
			{
				prize = 10000000;
				System.out.println("資訊錯誤! 目前累積獎金: " + prize);
			}
			break;
		}
		System.out.println("=========================");
	}
	
	// 副函式: 隨機號碼
	public static void geneRandom(int[] Numbers)
	{
		for(int i = 0 ; i < 5 ; i++)
		{
			int temp = (int)(Math.random() * 32) + 1;
			if(isDuplicated(temp, Numbers) == 0)
				Numbers[i] = temp;
			// 有重複的數字，則此次不計
			else
				i--;
		}
	}
	
	// 副函式: 輸出
	public static void printArr(int[] Numbers)
	{
		for(int i = 0 ; i < Numbers.length ; i++)
			System.out.print(Numbers[i] + " ");
	}
	
	// 副函式: 比對1 ->判斷key是否有在陣列s當中
	public static int isDuplicated(int key, int[] s)
	{
		for(int i = 0 ; i < s.length ; i++)
			//有重複的數字，請回傳1
			if(key == s[i])
				return 1;
		// 否則回傳0
		return 0;
	}
	
	// 副函式: 比對2 ->簽注的數字myNumbers是否與開出的數字lottoNumbers相同
	public static int Match(int[] myNumbers, int[] lottoNumbers)
	{	
		int same3 = 0, same4 = 0, same5 = 0;
	
		for(int i = 0; i < myNumbers.length; i++)
		{
			// 頭獎控制項
			if(isDuplicated(myNumbers[i], lottoNumbers) == 1)
				same5++;
			// 貳獎控制項
			if(i == 1 && myNumbers[i] == lottoNumbers[i])
				same4++;
			// 參獎控制項
			else if(i >= 2 && myNumbers[i] == lottoNumbers[i])
				same3++;
		}
		// 五碼全中得獎金的100%（頭獎） ->對中頭獎回傳1
		if(same5 == myNumbers.length)
			return 1;
		// 後四碼得獎金之20%（貳獎） ->對中二獎回傳2
		else if(same4 == 1 && same3 == myNumbers.length - 2)
			return 2;
		// 後三碼得獎金之1%（參獎） ->對中參獎回傳3
		else if(same3 == myNumbers.length - 2)
			return 3;
		// 否則回傳0
		return 0;
	}

}
