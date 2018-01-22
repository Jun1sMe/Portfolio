package lesson11_4;
import java.util.Scanner;
public class pokerFiveIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int initialize[][] = generatePoker();		
		// 洗牌之排序
		shufflePoker(initialize, initialize.length);
		// 持有之5張手牌、玩家為4人
		takePoker(initialize, 5, 4);
		
		int z = 1;			// 抽牌順序
		while(true)
		{
			System.out.print("1)繼續抽牌 2)重新洗牌 -1)結束程式: ");
			int option = scanner.nextInt();
			
			if(option == 1)
			{
				if(z++ <= 5)
				{
					takePoker(initialize, 5, 4 + z);
					System.out.println();
				}
				else
					System.out.println("牌匣已空，請重新洗牌\n");			
			}
			else if(option == 2)
			{
				shufflePoker(initialize, initialize.length);
				takePoker(initialize, 5, 4);
				System.out.println();
			}
			else if(option == -1)
			{
				System.out.println("程式關閉。");
				break;
			}
			else
				System.out.println("輸入錯誤，請重新輸入");

		}
		
	}
		
	// 副函式: 撲克牌組
	public static int[][] generatePoker()
	{
		int boxPoker[][] = new int[52][2];

		int k = 0;
		for(int i = 1 ; i <= 4 ; i++)		// 花色為4種
		{
			for(int j = 1 ; j <= 13 ; j++)	// 各13張
			{
				boxPoker[k][0] = i;			// 0 -> 花色
				boxPoker[k][1] = j;			// 1 -> 數字
				k++;						// k遞增
			}					
		}
		return boxPoker; 
	}
	// 副函式: 洗牌
	public static void shufflePoker(int[][] x, int count)
	{
		for(int i = 0 ; i < count ; i++)
		{
			int j = (int)(Math.random() * count);	// 欲互換之索引
			int temp[] = x[j];						// 參考變數指向該位址
			x[j] = x[i];
			x[i] = temp;		
		}
	}
	// 副函式: 抽牌
	public static void takePoker(int[][] x, int count, int player)
	{
		// 放入二維陣列: 索引為1~13，0 -> 總數 、1~4 -> 花色類型
		int sortPoker[][] = new int[14][5];
		
		// 不同的取牌位址
		int k = (int)(Math.random()* (x.length - (count * player)));
		System.out.println("您的手牌有: ");
		
		for(int i = 0 ; i < count ; i++)				// 手牌張數
		{
			k += player;								// 玩家數為取牌間格
			for(int j = 0 ; j <= 1 ; j++)				// 花色及數字
			{				
				if(j == 0)
				{
					if(x[k][0] == 1)
						System.out.print("黑桃 ");
					else if(x[k][0] == 2)
						System.out.print("紅心 ");
					else if(x[k][0] == 3)
						System.out.print("方塊 ");
					else if(x[k][0] == 4)
						System.out.print("梅花 ");						
				}
				else
				{
					if(x[k][1] == 1)
						System.out.print("A");
					else if(x[k][1] == 11)
						System.out.print("J");
					else if(x[k][1] == 12)
						System.out.print("Q");
					else if(x[k][1] == 13)
						System.out.print("K");
					else
						System.out.print(x[k][1]);
					System.out.print("\t");
					
					// 花色值1~4如是1表示存在
					sortPoker[x[k][1]][x[k][0]]++;
					sortPoker[x[k][1]][0]++;
				}
				
			}
						
		}
		System.out.println();
//		printArr(sortPoker);
		
		// 分辨牌型
		judgement(sortPoker);
	}
	// 副函式: 牌型判斷
	public static void judgement(int[][] x)
	{
		int group2 = 0, group3 = 0, group4 = 0, series = 0, seriesA = 0;	// 次數: 一對、三條、四條，連貫為五
		int color1 = 0, color2 = 0, color3 = 0, color4 = 0;					// 花色
		for(int k = 1 ; k <= 13 ; k++)
		{
			if(x[k][0] == 4)
			{
				group4++;
				break;
			}
			if(x[k][0] == 2)
				group2++;
			else if(x[k][0] == 3)
				group3++;
			// 順子判斷
			else if(k <= 9)
			{
				for(int j = 0; j < 5 ; j++)
				{
					if(x[k + j][0] == 1)
						series++;
				}
			}
			// 大順子判斷
			else if(k == 1 && x[k][0] == 1)
			{
				seriesA++;
				for(int j = 9; j < 13 ; j++)
				{
					if(x[k + j][0] == 1)
						series++;
				}
			}
			// 同花判斷
			else if(x[k][1] == 1)
				color1++;
			else if(x[k][2] == 1)
				color2++;
			else if(x[k][3] == 1)
				color3++;
			else if(x[k][4] == 1)
				color4++;				
		}
		
		if(group4 == 1)
			System.out.println("四條");
		else if(group3 == 1)
		{
			if(group2 == 1)
				System.out.println("葫蘆");
			else
				System.out.println("三條");
		}
		else if(group2 == 2)
			System.out.println("兩對");
		else if(group2 == 1)
			System.out.println("一對");
		else if(color1 == 5 || color2 == 5 || color3 == 5 || color4 == 5)
		{
			if(series == 5)
				System.out.println("同花順");
			else if(series == 4 && seriesA == 1)
				System.out.println("同花大順");
			else
				System.out.println("同花");
		}
		else if(series == 5)
			System.out.println("順子");
		else if(series == 4 && seriesA == 1)
			System.out.println("順子");
		else
			System.out.println("散牌");
	}
	
	// 副函式: 輸出
	public static void printArr(int[][] x)
	{
		for(int k = 0 ; k < x.length ; k++)
		{
			for(int j = 0 ; j < x[k].length ; j++)
				System.out.print(x[k][j] + "\t");
			System.out.println();
		}
		System.out.println();
	}
	
}
