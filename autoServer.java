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
				// �U�ȱ����⤧���B
				System.out.print("Amount of withdrawal: ");
				int userWithdrawal = scanner.nextInt();
				// �b��l�B
				lastBalance = (int)(userBalance * (1 + (flInterest / 100))) - userWithdrawal - (int)(userWithdrawal * (flLoading / 100));
				
				// ������B�j��20,000��
				if(userWithdrawal > 20000)
					System.out.println("Amount of transaction exceeds $20000 limit.\nTransaction cancelled.\n");
				// ������B�j��s�کξl�B����NSF
				else if(userWithdrawal > userBalance)
					System.out.println("Cash insufficient.\nTransaction cancelled.\n");
				// ���ڪ��B���T
				else
				{
					while(true)
					{
						System.out.print("Withdraw " + userWithdrawal + " dollars from your account. Sure (y/n)? ");
						char agree = scanner.next().charAt(0);
						// ���: �O�A�i�J
						if(agree == 'Y' || agree == 'y')
						{							
							System.out.println("$" + userWithdrawal + " withdrawn. ");
							System.out.println("Deposit\t" + "\tWithdrawal\t" + "Loading Fee\t" + "Balance");
							System.out.println("----------------------------------------------------------------------------------------------");
							System.out.println(" " + (int)(userBalance * (1 + (flInterest / 100))) + "\t\t" + userWithdrawal + "\t\t" +
									(int)(userWithdrawal * (flLoading / 100)) + "\t\t" + lastBalance + "\n");
							
							// �w��s: �U�Ȥ��Y���i�ξl�B
							userBalance = lastBalance;
							// �w��s: ����O���O�v�B�x�W�Q�v
							floatRating();
							
							System.out.println();
							break;						
						}
						// ���: �_�A�^��D���
						else if(agree == 'N' || agree == 'n')
						{
							System.out.println();
							break;
						}
						// ���: ���~�h����
						else
							System.out.println("Error! Try again.");	
					}
					
				}
				
			}
			else if(option == 'B' || option == 'b')
			{
				// �U�ȱ��s�J�����B
				System.out.print("Amount of deposit: ");
				int userDeposit = scanner.nextInt();
				// �b��l�B
				lastBalance = (int)(userBalance * (1 + (flInterest / 100))) + userDeposit - (int)(userDeposit * (flLoading / 100));
				
				// ������B�j��20,000��
				if(userDeposit > 20000)
					System.out.println("Amount of transaction exceeds $20000 limit.\nTransaction cancelled.\n");
				// ���ڪ��B���T
				else
				{
					while(true)
					{
						System.out.print("Deposit " + userDeposit + " dollars into your account. Sure (y/n)? ");
						char agree = scanner.next().charAt(0);
						// ���: �O�A�i�J
						if(agree == 'Y' || agree == 'y')
						{							
							System.out.println("$" + userDeposit + " withdrawn. ");
							System.out.println("Deposit\t" + "\tuserDeposit\t" + "Loading Fee\t" + "Balance");
							System.out.println("----------------------------------------------------------------------------------------------");
							System.out.println(" " + (int)(userBalance * (1 + (flInterest / 100))) + "\t\t" + userDeposit + "\t\t" +
									(int)(userDeposit * (flLoading / 100)) + "\t\t" + lastBalance + "\n");
							
							// �w��s: �U�Ȥ��Y���i�ξl�B
							userBalance = lastBalance;
							// �w��s: ����O���O�v�B�x�W�Q�v
							floatRating();
							
							System.out.println();
							break;						
						}
						// ���: �_�A�^��D���
						else if(agree == 'N' || agree == 'n')
						{
							System.out.println();
							break;
						}
						// ���: ���~�h����
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
	
	// �ƨ禡 : ��l��
	public static void initialization()
	{	
		// �U�Ȥ��Y���i�ξl�B
		System.out.print("Available balance :");
		userBalance = scanner.nextInt();
		// ATM���i���⪺���B
		System.out.print("Cash available in ATM: ");
		userCash = scanner.nextInt();
		// ����O���O�v
		System.out.print("Loading rate (%):");
		flLoading = scanner.nextDouble();
		// �x�W�Q�v
		System.out.print("Interest rate (%): ");
		flInterest = scanner.nextDouble();
		// �ڬO���j�u
		System.out.println("----------------------------------------------------------------------------------------------\n");
		System.out.println("Welcome. Please enter your option.");
	}
	// �ƨ禡 : �B�ʤ�����O�P�x�W�Q�v
	public static void floatRating()
	{
		// �T�׬�0~10%�A�@11
		int rangeLoading = (int)(Math.random() * 11);
		int rangeInterest = (int)(Math.random() * 11);
		rangeLoading = upsAndDowns(rangeLoading);
		rangeInterest = upsAndDowns(rangeInterest);
		
		// �Nrange�j���૬double�A�קK�P�_�Ȭ�0
		flLoading *= (1 + ((double)rangeLoading / 100));
		flInterest *= (1 + ((double)rangeInterest / 100));
		
		// printf��%�n������J%%�~�����%
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
	// �ƨ禡 : ���^	
	public static int upsAndDowns(int a)
	{
		int A = (int)(Math.random() * 2);
		if(A == 0)
			return a;
		else		
			return -a;
	}
}
