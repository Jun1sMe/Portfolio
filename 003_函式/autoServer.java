package lesson10_5;
import java.util.Scanner;
public class autoServer {
	public static Scanner scanner = new Scanner(System.in);
	static int userBalance, userCash, lastBalance;
	static double flLoading, flInterest;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initialization();
		
		while(true)
		{
			System.out.print("A) Withdrawal. B) Deposit. C) Quit: ");
			char option = scanner.next().charAt(0);
			if(option == 'A' || option == 'a')
			{
				// 顧客欲提領之金額
				System.out.print("Amount of withdrawal: ");
				int userWithdrawal = scanner.nextInt();
				// 帳戶餘額
				lastBalance = (int)(userBalance * (1 + (flInterest / 100))) - userWithdrawal - (int)(userWithdrawal * (flLoading / 100));
				
				// 提領金額大於20,000元
				if(userWithdrawal > 20000)
					System.out.println("Amount of transaction exceeds $20000 limit.\nTransaction cancelled.\n");
				// 提領金額大於存款或餘額不足NSF
				else if(userWithdrawal > userBalance)
					System.out.println("Cash insufficient.\nTransaction cancelled.\n");
				// 提款金額正確
				else
				{
					while(true)
					{
						System.out.print("Withdraw " + userWithdrawal + " dollars from your account. Sure (y/n)? ");
						char agree = scanner.next().charAt(0);
						// 選擇: 是，進入
						if(agree == 'Y' || agree == 'y')
						{							
							System.out.println("$" + userWithdrawal + " withdrawn. ");
							System.out.println("Deposit\t" + "\tWithdrawal\t" + "Loading Fee\t" + "Balance");
							System.out.println("----------------------------------------------------------------------------------------------");
							System.out.println(" " + (int)(userBalance * (1 + (flInterest / 100))) + "\t\t" + userWithdrawal + "\t\t" +
									(int)(userWithdrawal * (flLoading / 100)) + "\t\t" + lastBalance + "\n");
							
							// 已更新: 顧客戶頭內可用餘額
							userBalance = lastBalance;
							// 已更新: 手續費的費率、儲蓄利率
							floatRating();
							
							System.out.println();
							break;						
						}
						// 選擇: 否，回到主選單
						else if(agree == 'N' || agree == 'n')
						{
							System.out.println();
							break;
						}
						// 選擇: 錯誤則重選
						else
							System.out.println("Error! Try again.");	
					}
					
				}
				
			}
			else if(option == 'B' || option == 'b')
			{
				// 顧客欲存入之金額
				System.out.print("Amount of deposit: ");
				int userDeposit = scanner.nextInt();
				// 帳戶餘額
				lastBalance = (int)(userBalance * (1 + (flInterest / 100))) + userDeposit - (int)(userDeposit * (flLoading / 100));
				
				// 提領金額大於20,000元
				if(userDeposit > 20000)
					System.out.println("Amount of transaction exceeds $20000 limit.\nTransaction cancelled.\n");
				// 提款金額正確
				else
				{
					while(true)
					{
						System.out.print("Deposit " + userDeposit + " dollars into your account. Sure (y/n)? ");
						char agree = scanner.next().charAt(0);
						// 選擇: 是，進入
						if(agree == 'Y' || agree == 'y')
						{							
							System.out.println("$" + userDeposit + " withdrawn. ");
							System.out.println("Deposit\t" + "\tuserDeposit\t" + "Loading Fee\t" + "Balance");
							System.out.println("----------------------------------------------------------------------------------------------");
							System.out.println(" " + (int)(userBalance * (1 + (flInterest / 100))) + "\t\t" + userDeposit + "\t\t" +
									(int)(userDeposit * (flLoading / 100)) + "\t\t" + lastBalance + "\n");
							
							// 已更新: 顧客戶頭內可用餘額
							userBalance = lastBalance;
							// 已更新: 手續費的費率、儲蓄利率
							floatRating();
							
							System.out.println();
							break;						
						}
						// 選擇: 否，回到主選單
						else if(agree == 'N' || agree == 'n')
						{
							System.out.println();
							break;
						}
						// 選擇: 錯誤則重選
						else
							System.out.println("Error! Try again.");	
					}
					
				}
	
			}
			else if(option == 'C' || option == 'c')
			{
				System.out.println("Program quits");
				break;
			}
			else
				System.out.println("Error! Try again.");					
		}
		
		
	}
	
	// 副函式 : 初始化
	public static void initialization()
	{	
		// 顧客戶頭內可用餘額
		System.out.print("Available balance :");
		userBalance = scanner.nextInt();
		// ATM中可提領的金額
		System.out.print("Cash available in ATM: ");
		userCash = scanner.nextInt();
		// 手續費的費率
		System.out.print("Loading rate (%):");
		flLoading = scanner.nextDouble();
		// 儲蓄利率
		System.out.print("Interest rate (%): ");
		flInterest = scanner.nextDouble();
		// 我是分隔線
		System.out.println("----------------------------------------------------------------------------------------------\n");
		System.out.println("Welcome. Please enter your option.");
	}
	// 副函式 : 浮動之手續費與儲蓄利率
	public static void floatRating()
	{
		// 幅度為0~10%，共11
		int rangeLoading = (int)(Math.random() * 11);
		int rangeInterest = (int)(Math.random() * 11);
		rangeLoading = upsAndDowns(rangeLoading);
		rangeInterest = upsAndDowns(rangeInterest);
		
		// 將range強制轉型double，避免判斷值為0
		flLoading *= (1 + ((double)rangeLoading / 100));
		flInterest *= (1 + ((double)rangeInterest / 100));
		
		// printf的%要雙重輸入%%才能顯示%
		System.out.printf("Loading rate (%%): %.3f", flLoading);
		if(rangeLoading >= 0)
			System.out.println(" (+" + rangeLoading + "%)");
		else
			System.out.println(" (" + rangeLoading + "%)");
		System.out.printf("Loading rate (%%): %.3f", flInterest);
		if(rangeInterest >= 0)
			System.out.println(" (+" + rangeInterest + "%)");
		else
			System.out.println(" (" + rangeInterest + "%)");
		
	}
	// 副函式 : 漲跌	
	public static int upsAndDowns(int a)
	{
		int A = (int)(Math.random() * 2);
		if(A == 0)
			return a;
		else		
			return -a;
	}
}
