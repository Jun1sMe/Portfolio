/* v0819
 * -�קﳡ��-
 * --����s��P�_�A��l�Ʃ�J�j��
 * --�ư����ƼƦr��ܡA������W
 * --�W�[�t�ƧP�_�A�ƭȻ��W
 */

import java.util.Scanner;
public class Problem2_add {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		int match[][] = new int[10][10];
		// ��J10�Ӿ�ƼƦr
		System.out.print("Numbers: ");
		int num[] = new int[10];
		for(int i = 0 ; i < num.length ; i++)
			num[i] = scanner.nextInt();
		 		
		int n = 0;
		while(n != -1)
		{
			// ��l�ƨ�Ƭۥ[�B�T�Ƭۥ[�B��ƭ�
			int add2 = 0, add3 = 0, cons = 0;
			
			// ���N��n�A�̱��񤧬ۥ[:
			System.out.print("\nn (-1 to quit): ");
			n = scanner.nextInt();
			// �������J��
			cons = n;
			
			// ��Ƭۥ[
			do
			{
				for(int i = 0 ; i < num.length - 1 ; i++)
				{
					// ���L�w�p��
					for(int j = i + 1 ; j < num.length - 1 ; j++)
					{
						// ��Ƭۥ[���G
						if(n == num[i] + num[j] && num[i] != 0 && num[j] != 0)
						{
							System.out.print("Answer 1 (two numbers): " + num[i] + " " + num[j] + "\n");
							// �Ȼݭn��ܨ䤤�@�էY�i
							i = 100;
							add2 = 1;
							break;
						}
					}
				}
				// n�����ƫh����A�t�ƫh���W
				if(n > 0)
					n--;
				else if(n < 0)
					n++;
			}while(add2 != 1);	
			// ��_���J��
			n = cons;
			
			// �T�Ƭۥ[
			do
			{
				for(int i = 0 ; i < num.length - 1 ; i++)
				{
					// ���L�w�p��
					for(int j = i + 1 ; j < num.length - 1 ; j++)
					{
						for(int k = j + 1 ; k < num.length - 1 ; k++)
						{
							if(n == num[i] + num[j] + num[k] && num[i] != 0 && num[j] != 0 && num[k] != 0)
							{
								System.out.print("Answer 2 (three numbers): " + num[i] + " " + num[j] + " " + num[k] + "\n");
								// �Ȼݭn��ܨ䤤�@�էY�i
								i = 100;
								j = 100;
								add3 = 1;
								break;
							}
						}
					}
				}
				// n�����ƫh����A�t�ƫh���W
				if(n > 0)
					n--;
				else if(n < 0)
					n++;			
			}while(add3 != 1);			
			// ��_���J��
			n = cons;		
		}
	}

}
