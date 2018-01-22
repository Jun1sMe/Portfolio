package lesson8_2;
import java.util.Scanner;
public class multipleDArrary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int coordinate[][] = new int[100][2];
		double distance[][] = new double[100][2];
		int option = 0, i, count = 0;
		for(i = 0 ; i < distance.length ; i++)							// 將距離值設為-1
			distance[i][0] = -1;		
		i = 0;															// 將i回到初始化
		
		while(true)
		{
			if(option == 0)
			{
				System.out.print("Option: 1) Insert. 2) Output. -1) Quit? ");
				option = scanner.nextInt();
				
				if(option != 1 && option != 2 && option != -1)
				{
					System.out.println("Value error! Try again!");
					option = 0;
				}
			}
			
			if(option == 1)
			{
				System.out.print("請輸入座標:");
				coordinate[i][0] = scanner.nextInt();
				coordinate[i][1] = scanner.nextInt();
				i++;
				count = i;

				System.out.println();
				option--;
			}
			
			if(option == 2)
			{				
				for(i = 0 ; i < count ; i++)
				{
					for(int j = i + 1 ; j < count ; j++)					// 數值跟其他數值比較
					{						
						double temp = Math.sqrt(Math.pow((coordinate[i][0] - coordinate[j][0]), 2) + Math.pow((coordinate[i][1] - coordinate[j][1]), 2));
						
						if(distance[j][0] == -1 || temp < distance[j][0])
						{
							distance[j][0] = temp;							// 將數值鏡射 (0, 1) -> (1, 0)
							distance[j][1] = i;								// 該位址存入索引1							
						}
						
						if(temp < distance[i][0] || distance[i][0] == -1 )	// 較小值
						{	
							distance[i][0] = temp;
							distance[i][1] = j;								// 該位址存入索引1
						}
					}
					
				}
				
				for(i = 0 ; i < count ; i++)								// 列印最小距離及該座標
				{
					int xy = (int)distance[i][1];
					System.out.printf("(%3d, %3d)\t->\t(%3d, %3d)\t距離：%.2f\n", 
							coordinate[i][0], coordinate[i][1], coordinate[xy][0], coordinate[xy][1], distance[i][0]);
				}
				option = 0;
			}
		}
	}

}
