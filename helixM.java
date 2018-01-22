package lesson8_3;
import java.util.Scanner;
public class helixM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int size, clock;
		int series = 0, i, j, k, l;				// i為列數，j為行數，k & l為重複次數
		
		while(true)
		{
			size = scanner.nextInt();			// decide the size
			clock = scanner.nextInt();			// decide the direction
			if(size >= 1 && size <= 30)
				if(clock == 1 || clock == 2)
					break;
		}		
		int helix[][] = new int[size][size];	// 輸入為陣列大小
		System.out.print(size + "," + clock + " \n");
		
		if(clock == 2)							// (a)逆時鐘方向
		{
			for(i = 0 ; i < size ; i++)										// 第1行
				helix[i][0] = ++series;										// 由001開始
			for(k = 1, l = 0 ; k < size ; k += 2, l++)
			{
				
				for(j = 0 ; j < size - k ; j++)								// 第"size"列依次遞增
					helix[size - k + l][k - l + j] = ++series;				// 索引: size - 1
				for(i = 0 ; i < size - k ; i++)								// 第"size"行依次遞減
					helix[size - k - 1 + l - i][size - k + l] = ++series;	// 索引: size - 1	
				for(j= 0 ; j < size - k - 1 ; j++)							// 第1列依次遞減
					helix[l][size - k - 1 + l - j] = ++series;			
				for(i = 0 ; i < size - k - 1 ; i++)							// 第2行依次遞增
					helix[k - l + i][k - l] = ++series;
			}
		}
		else if(clock == 1)						// (b)順時鐘方向
		{
			for(j = 0 ; j < size ; j++)										// 第1列
				helix[0][j] = ++series;										// 由001開始
			for(k = 1, l = 0 ; k < size ; k += 2, l++)
			{
				for(i = 0 ; i < size - k ; i++)								// 第"size"行依次遞增
					helix[i + k - l][size - k + l] = ++series;				// 索引: size - 1	
				for(j = 0 ; j < size - k ; j++)								// 第"size"列依次遞減
					helix[size - k + l][size - k - 1 + l - j] = ++series;	// 索引: size - 1
				for(i = 0 ; i < size - k - 1 ; i++)							// 第1行依次遞減
					helix[size - k - 1 + l - i][l] = ++series;
				for(j= 0 ; j < size - k - 1 ; j++)							// 第2列依次遞增
					helix[k - l][j + k - l] = ++series;			
			}	
		}
		
		for(i = 0 ; i < size ; i++)											// 輸出陣列
		{
			for(j = 0 ; j < size - 1 ; j++)									// 未顯示末行
			{
				System.out.printf("%03d, ", helix[i][j]);					// 格式為三位數 + ','
			}
			System.out.printf("%03d\n", helix[i][j]);						// 顯示末行
		}
		
			
			/* 規律計算如下: */
			/* 第一行直接印出，第二次開始計算 */
//			for(i = 0 ; i < size - 1 ; i++)					// 第"size"行，少一次
//				helix[i + 1][size - 1] = ++series;			// 索引: size - 1			
//			for(j = 0 ; j < size - 1 ; j++)					// 第"size"列，少一次
//				helix[size - 1][size - 2 - j] = ++series;	// 索引: size - 1		
//			for(i = 0 ; i < size - 2 ; i++)					// 第1行，少一次 	
//				helix[size - 2 - i][0] = ++series;			
//			for(j= 0 ; j < size - 2 ; j++)					// 第2列，少一次
//				helix[1][j + 1] = ++series;
//			for(i = 0 ; i < size - 3 ; i++)					// 第"size - 1"行，少一次
//				helix[i + 2][size - 2] = ++series;
//			for(j = 0 ; j < size - 3 ; j++)					// 第"size - 1"列，少一次
//				helix[size - 2][size - 3 - j] = ++series;
//			for(i = 0 ; i < size - 4 ; i++)					// 第2行，少一次
//				helix[size - 3 - i][1] = ++series;
//			for(j= 0 ; j < size - 4 ; j++)					// 第3列，少一次
//				helix[2][j + 2] = ++series;
//			for(i = 0 ; i < size - 5 ; i++)					// 第"size - 2"行，少一次
//				helix[i + 3][size - 3] = ++series;
//			for(j = 0 ; j < size - 5 ; j++)					// 第"size - 2"列，少一次
//				helix[size - 3][size - 4 - j] = ++series;
//			for(i = 0 ; i < size - 6 ; i++)					// 第3行，少一次
//				helix[size - 4 - i][2] = ++series;		
//			for(j= 0 ; j < size - 6 ; j++)					// 第4列，少一次
//				helix[3][j + 3] = ++series;
//			for(i = 0 ; i < size - 7 ; i++)					// 第"size - 3"行，少一次
//				helix[i + 4][size - 4] = ++series;			// 最後一個	
//			for(j = 0 ; j < size - 7 ; j++)					// 第"size - 3"行，少一次
//				helix[size - 4][size - 5 - j] = ++series;	// 最後一個	

	}

}
