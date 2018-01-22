package lesson8_3;
import java.util.Scanner;
public class helixM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int size, clock;
		int series = 0, i, j, k, l;				// i���C�ơAj����ơAk & l�����Ʀ���
		
		while(true)
		{
			size = scanner.nextInt();			// decide the size
			clock = scanner.nextInt();			// decide the direction
			if(size >= 1 && size <= 30)
				if(clock == 1 || clock == 2)
					break;
		}		
		int helix[][] = new int[size][size];	// ��J���}�C�j�p
		System.out.print(size + "," + clock + " \n");
		
		if(clock == 2)							// (a)�f������V
		{
			for(i = 0 ; i < size ; i++)										// ��1��
				helix[i][0] = ++series;										// ��001�}�l
			for(k = 1, l = 0 ; k < size ; k += 2, l++)
			{
				
				for(j = 0 ; j < size - k ; j++)								// ��"size"�C�̦����W
					helix[size - k + l][k - l + j] = ++series;				// ����: size - 1
				for(i = 0 ; i < size - k ; i++)								// ��"size"��̦�����
					helix[size - k - 1 + l - i][size - k + l] = ++series;	// ����: size - 1	
				for(j= 0 ; j < size - k - 1 ; j++)							// ��1�C�̦�����
					helix[l][size - k - 1 + l - j] = ++series;			
				for(i = 0 ; i < size - k - 1 ; i++)							// ��2��̦����W
					helix[k - l + i][k - l] = ++series;
			}
		}
		else if(clock == 1)						// (b)��������V
		{
			for(j = 0 ; j < size ; j++)										// ��1�C
				helix[0][j] = ++series;										// ��001�}�l
			for(k = 1, l = 0 ; k < size ; k += 2, l++)
			{
				for(i = 0 ; i < size - k ; i++)								// ��"size"��̦����W
					helix[i + k - l][size - k + l] = ++series;				// ����: size - 1	
				for(j = 0 ; j < size - k ; j++)								// ��"size"�C�̦�����
					helix[size - k + l][size - k - 1 + l - j] = ++series;	// ����: size - 1
				for(i = 0 ; i < size - k - 1 ; i++)							// ��1��̦�����
					helix[size - k - 1 + l - i][l] = ++series;
				for(j= 0 ; j < size - k - 1 ; j++)							// ��2�C�̦����W
					helix[k - l][j + k - l] = ++series;			
			}	
		}
		
		for(i = 0 ; i < size ; i++)											// ��X�}�C
		{
			for(j = 0 ; j < size - 1 ; j++)									// ����ܥ���
			{
				System.out.printf("%03d, ", helix[i][j]);					// �榡���T��� + ','
			}
			System.out.printf("%03d\n", helix[i][j]);						// ��ܥ���
		}
		
			
			/* �W�߭p��p�U: */
			/* �Ĥ@�檽���L�X�A�ĤG���}�l�p�� */
//			for(i = 0 ; i < size - 1 ; i++)					// ��"size"��A�֤@��
//				helix[i + 1][size - 1] = ++series;			// ����: size - 1			
//			for(j = 0 ; j < size - 1 ; j++)					// ��"size"�C�A�֤@��
//				helix[size - 1][size - 2 - j] = ++series;	// ����: size - 1		
//			for(i = 0 ; i < size - 2 ; i++)					// ��1��A�֤@�� 	
//				helix[size - 2 - i][0] = ++series;			
//			for(j= 0 ; j < size - 2 ; j++)					// ��2�C�A�֤@��
//				helix[1][j + 1] = ++series;
//			for(i = 0 ; i < size - 3 ; i++)					// ��"size - 1"��A�֤@��
//				helix[i + 2][size - 2] = ++series;
//			for(j = 0 ; j < size - 3 ; j++)					// ��"size - 1"�C�A�֤@��
//				helix[size - 2][size - 3 - j] = ++series;
//			for(i = 0 ; i < size - 4 ; i++)					// ��2��A�֤@��
//				helix[size - 3 - i][1] = ++series;
//			for(j= 0 ; j < size - 4 ; j++)					// ��3�C�A�֤@��
//				helix[2][j + 2] = ++series;
//			for(i = 0 ; i < size - 5 ; i++)					// ��"size - 2"��A�֤@��
//				helix[i + 3][size - 3] = ++series;
//			for(j = 0 ; j < size - 5 ; j++)					// ��"size - 2"�C�A�֤@��
//				helix[size - 3][size - 4 - j] = ++series;
//			for(i = 0 ; i < size - 6 ; i++)					// ��3��A�֤@��
//				helix[size - 4 - i][2] = ++series;		
//			for(j= 0 ; j < size - 6 ; j++)					// ��4�C�A�֤@��
//				helix[3][j + 3] = ++series;
//			for(i = 0 ; i < size - 7 ; i++)					// ��"size - 3"��A�֤@��
//				helix[i + 4][size - 4] = ++series;			// �̫�@��	
//			for(j = 0 ; j < size - 7 ; j++)					// ��"size - 3"��A�֤@��
//				helix[size - 4][size - 5 - j] = ++series;	// �̫�@��	

	}

}
