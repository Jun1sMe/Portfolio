/*
 * �Ŷ������סG
 * �渹21~24, 25~27, 29~35, 36~41, 46, 47~51, 55~56, 59~62�u���@���x�s�Ŷ� ��(1)
 * �渹63~67��(n + 1)��(1) ->��(n)
 * 
 * 
 * �ɶ������סG
 * �渹21~24, 25~27, 46, 47~51, 59~62����n��, 55~56����logn�� ��(n)
 * �渹29~35����n*n��, �渹36~41����n*logn�� ��(n^2)
 * �渹63~67����2*n�� ��(n)
 * 
 * 
 */
import java.util.Scanner;

public class TestSum
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);		
		while(true)
		{
			System.out.println("Please select the number, and type them: ");
			int num = scanner.nextInt();
			if(num >= 1 && num <= 10)
			{
				long[] output = new long[num];
				// input
				for(int i = 0 ; i < num ; i++)
				{
					long input = scanner.nextLong();
					if(num >= 1 && num <= (long)Math.pow(10, 16))
					{
						output[i] = input;
					}
					else
					{
						// retry
						i--;
						printError();
					}					
				}
				// separate
				System.out.println();
				// output
				int recheck = (int)Math.pow(10, 9) + 7;
				for(int i = 0 ; i < num ; i++)
				{
					long result = (long)Math.sqrt(sum(output[i]));
					System.out.println(((result % recheck) * (result % recheck)) % recheck);
				}				
				// separate
				System.out.println();
			}
			else
				printError();			
		}		
	}
	public static void printError()
	{
		System.out.println("Error! Try again.");
	}
	public static long sum(long n)
	{
		if(n > 1)
			return 2 * n - 1 + sum(n - 1);
		return 1;	
	}

}