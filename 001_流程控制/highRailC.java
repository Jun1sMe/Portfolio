package lesson4_2;
import java.util.Scanner;

public class highRailC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int buyTicket;
		int greaterCash5 = 0, greaterCash1 = 0;						// 宣告超過已有零錢的存放數值
		int smallerCash5 = 0, smallerCash1 = 0;						// 宣告無法找零的存放數值
		int getCash10 = 0, getCash5 = 0, getCash1 = 0;				// 宣告用戶實際取得之零錢
		int coin10, coin5, coin1;									// 宣告零錢10元、5元、1元數量為30
		
		System.out.println("工作人員投入機台的硬幣個數: ");
		System.out.print("1元硬幣個數: ");
		coin1 = scanner.nextInt();
		System.out.print("5元硬幣個數: ");
		coin5 = scanner.nextInt();
		System.out.print("10元硬幣個數: ");
		coin10 = scanner.nextInt();
		
		do 															// 確認購票可重複執行
		{
			System.out.print("購票 1)是 2)否? ");
			buyTicket = scanner.nextInt();							// 宣告整數變數buyTicket並存放輸入值
			if(buyTicket == 2)
				System.out.println("感謝使用本系統!");
			else if(buyTicket == 1)									// 購票條件
			{														// 宣告起訖站、票數、票價、總價、投入金額並初始化					
				int startStop, endStop = 0, ticketNum = 0, ticketPrice = 0, cash = 0, throwCash = 0;								
				System.out.println(buyTicket + "\n" + "開始購票！");
				do 													// 回上一步的迴圈條件
				{				
					System.out.println("選擇起站：1)台北 2)台中 3)高雄 4)取消: ");
					startStop = scanner.nextInt();									
					switch(startStop)								// 判斷輸入之起站
					{
						case 1:
							do
							{
								System.out.println("選擇訖站：1)台北 2)台中 3)高雄 4)回上一步 5)取消: ");
								endStop = scanner.nextInt();
								if(endStop == 1)
									System.out.println("起訖站相同! 請重新選擇訖站");
								else if(endStop < 1 || endStop > 5)
									System.out.println("無此選項! 請重新選擇訖");
								else if(endStop == 5)
								{
									System.out.println("取消購票！");					// 輸入5則取消購票
									break;				
								}
								else if(endStop == 4)
									break;								
								else if(endStop >= 2 && endStop <= 3)
									do
									{
										System.out.println("選擇張數：1) 1 張 2) 2 張 3) 3 張 4)回上一步 5)取消: ");
										ticketNum = scanner.nextInt();
										if(ticketNum < 1 || ticketNum >5)
											System.out.println("張數錯誤! 請重新輸入張數");
									}while(ticketNum < 1 || ticketNum > 5);								
									if(ticketNum == 5)
										break;
									else if(ticketNum == 4)
										continue;									
							}while(endStop <= 1 || endStop > 5 || ticketNum == 4);	// 起訖站相同或是輸入其他值、購票回上一步						
							if(endStop == 4)										// 輸入4則再重新顯示選擇起站						
								continue;									
							break;													// end case
						
						case 2:
							do
							{
								System.out.println("選擇訖站：1)台北 2)台中 3)高雄 4)回上一步 5)取消: ");
								endStop = scanner.nextInt();
								if(endStop == 2)
									System.out.println("起訖站相同! 請重新選擇訖站");
								else if(endStop < 1 || endStop > 5)
									System.out.println("無此選項! 請重新選擇訖");
								else if(endStop == 5)
								{
									System.out.println("取消購票！");					// 輸入5則取消購票
									break;				
								}
								else if(endStop == 4)
									break;								
								else if(endStop == 1 || endStop == 3)
									do
									{
										System.out.println("選擇張數：1) 1 張 2) 2 張 3) 3 張 4)回上一步 5)取消: ");
										ticketNum = scanner.nextInt();
										if(ticketNum < 1 || ticketNum >5)
											System.out.println("張數錯誤! 請重新輸入張數");
									}while(ticketNum < 1 || ticketNum > 5);								
									if(ticketNum == 5)
										break;
									else if(ticketNum == 4)
										continue;									
							}while(endStop < 1 || endStop > 5 || endStop == 2 || ticketNum == 4);// 起訖站相同或是輸入其他值、購票回上一步						
							if(endStop == 4)										// 輸入4則再重新顯示選擇起站						
								continue;									
							break;													// end case
							
						case 3:
							do
							{
								System.out.println("選擇訖站：1)台北 2)台中 3)高雄 4)回上一步 5)取消: ");
								endStop = scanner.nextInt();
								if(endStop == 3)
									System.out.println("起訖站相同! 請重新選擇訖站");
								else if(endStop < 1 || endStop > 5)
									System.out.println("無此選項! 請重新選擇訖");
								else if(endStop == 5)
								{
									System.out.println("取消購票！");					// 輸入5則取消購票
									break;				
								}
								else if(endStop == 4)
									break;								
								else if(endStop == 1 || endStop == 2)
									do
									{
										System.out.println("選擇張數：1) 1 張 2) 2 張 3) 3 張 4)回上一步 5)取消: ");
										ticketNum = scanner.nextInt();
										if(ticketNum < 1 || ticketNum >5)
											System.out.println("張數錯誤! 請重新輸入張數");
									}while(ticketNum < 1 || ticketNum > 5);								
									if(ticketNum == 5)
										break;
									else if(ticketNum == 4)
										continue;									
							}while(endStop < 1 || endStop > 5 || endStop == 3 || ticketNum == 4);// 起訖站相同或是輸入其他值、購票回上一步						
							if(endStop == 4)										// 輸入4則再重新顯示選擇起站						
								continue;									
							break;													// end case
								
						default:
							System.out.println("取消購票！");
							break;					
					}
					if(startStop != 4 && ticketNum >= 1 && ticketNum <=3)		// 取消購票則跳過此段
					{															// 判斷起訖站為何，並輸出票價
						if(startStop == 1 && endStop == 2)
							System.out.println("搭乘 台北到台中列車，座位共 " + ticketNum + " 張，票價 " + 536 * ticketNum + "元" );
						else if(startStop == 2 && endStop == 1)
							System.out.println("搭乘 台中到台北列車，座位共 " + ticketNum + " 張，票價 " + 536 * ticketNum + "元" );	
						else if(startStop == 2 && endStop == 3)
							System.out.println("搭乘 台中到高雄列車，座位共 " + ticketNum + " 張，票價 " + 536 * ticketNum + "元" );		
						else if(startStop == 3 && endStop == 2)
							System.out.println("搭乘 高雄到台中列車，座位共 " + ticketNum + " 張，票價 " + 536 * ticketNum + "元" );
						else if(startStop == 1 && endStop == 3)
							System.out.println("搭乘 台北到高雄列車，座位共 " + ticketNum + " 張，票價 " + 927 * ticketNum + "元" );
						else if(startStop == 3 && endStop == 1)
							System.out.println("搭乘 高雄到台北列車，座位共 " + ticketNum + " 張，票價 " + 927 * ticketNum + "元" );
												
						ticketPrice = Math.abs(startStop - endStop);			// 利用站距、票數計算票價
						switch(ticketPrice)
						{
							case 1:
								ticketPrice = 536 * ticketNum;
								break;
							case 2:
								ticketPrice = 927 * ticketNum;
								break;
						}
						do														// 重複判斷投入現金直到大於票價
						{
							System.out.print("請投入現金： 1) 50元 2) 100元 3) 500元 4) 1000元 5)取消: ");
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
						if (cash != 0)											// 輸入現金不為0，取消付款則跳過此行
							System.out.println("收您" + cash + "元");
						int getCash = cash - ticketPrice;
						if(getCash > 0)											// 需要找零則進入此段
						{
							if(coin10 > 0)										// 機器內尚有10元硬幣
							{
								getCash10 = getCash / 10;						// 計算應找之10元硬幣
								if(coin10 < getCash10)							// 提供用戶之10元硬幣
								{
									smallerCash5 = getCash10 - coin10;			// 機器內無10元硬幣，則以5元硬幣提供
									getCash10 = coin10;
								}								
							}
							else
								getCash10 = 0;									// 機器內無10元硬幣
							if(coin5 > 0)										// 機器內尚有5元硬幣
							{													// 計算應找之5元硬幣
								getCash5 = (getCash % 10) / 5 + smallerCash5 * 2;
								if(coin5 < getCash5)							// 提供用戶之5元硬幣
								{
									smallerCash1 = getCash5 - coin5;			// 機器內無5元硬幣，則以1元硬幣提供
									getCash5 = coin5;
								}
							}
							else
								getCash5 = 0;									// 機器內無5元硬幣
							if(coin1 > 0)										// 機器內尚有1元硬幣
							{													// 計算應找之1元硬幣
								getCash1 = (getCash % 10) % 5 + smallerCash1 * 5;								
							}
							else
							{
								System.out.println("現金不足，無法找零，請洽櫃臺人員");
								break;	
							}
							if(getCash != getCash10 *10 + getCash5 * 5 + getCash1 *1)
							{													// 欲提供用戶之硬幣與應提供不符
								System.out.println("現金不足，無法找零，請洽櫃臺人員");
								break;	
							}
							coin10 = 30 - getCash10;							// 結算機器內存之硬幣
							coin5 = 30 - getCash5;
							coin1 = 30 - getCash1;
							
							System.out.println("找您" + getCash + "元");					
							System.out.println("退回10元硬幣" + getCash10 + "個，5元硬幣" + getCash5 + "個，1元硬幣" + getCash1 +"個");						
						}
						System.out.println("別忘了取走您的車票，謝謝!");
					}			
					
				}while(endStop == 4);								
				System.out.println("感謝使用本系統!");
			}
			else													// 已列出1=是、2=否之購票選項，此為例外狀況預設
				System.out.println("This button is empty!");
		}while(buyTicket == 1);

	}

}
