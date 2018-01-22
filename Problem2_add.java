/* v0819
 * -修改部分-
 * --執行連續判斷，初始化放入迴圈
 * --排除重複數字顯示，控制項遞增
 * --增加負數判斷，數值遞增
 */

import java.util.Scanner;
public class Problem2_add {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		int match[][] = new int[10][10];
		// 輸入10個整數數字
		System.out.print("Numbers: ");
		int num[] = new int[10];
		for(int i = 0 ; i < num.length ; i++)
			num[i] = scanner.nextInt();
		 		
		int n = 0;
		while(n != -1)
		{
			// 初始化兩數相加、三數相加、原數值
			int add2 = 0, add3 = 0, cons = 0;
			
			// 任意數n，最接近之相加:
			System.out.print("\nn (-1 to quit): ");
			n = scanner.nextInt();
			// 紀錄原輸入值
			cons = n;
			
			// 兩數相加
			do
			{
				for(int i = 0 ; i < num.length - 1 ; i++)
				{
					// 跳過已計算
					for(int j = i + 1 ; j < num.length - 1 ; j++)
					{
						// 兩數相加結果
						if(n == num[i] + num[j] && num[i] != 0 && num[j] != 0)
						{
							System.out.print("Answer 1 (two numbers): " + num[i] + " " + num[j] + "\n");
							// 僅需要顯示其中一組即可
							i = 100;
							add2 = 1;
							break;
						}
					}
				}
				// n為正數則遞減，負數則遞增
				if(n > 0)
					n--;
				else if(n < 0)
					n++;
			}while(add2 != 1);	
			// 恢復原輸入值
			n = cons;
			
			// 三數相加
			do
			{
				for(int i = 0 ; i < num.length - 1 ; i++)
				{
					// 跳過已計算
					for(int j = i + 1 ; j < num.length - 1 ; j++)
					{
						for(int k = j + 1 ; k < num.length - 1 ; k++)
						{
							if(n == num[i] + num[j] + num[k] && num[i] != 0 && num[j] != 0 && num[k] != 0)
							{
								System.out.print("Answer 2 (three numbers): " + num[i] + " " + num[j] + " " + num[k] + "\n");
								// 僅需要顯示其中一組即可
								i = 100;
								j = 100;
								add3 = 1;
								break;
							}
						}
					}
				}
				// n為正數則遞減，負數則遞增
				if(n > 0)
					n--;
				else if(n < 0)
					n++;			
			}while(add3 != 1);			
			// 恢復原輸入值
			n = cons;		
		}
	}

}
