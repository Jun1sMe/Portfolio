package lesson6_4;
import java.util.Scanner;
public class engTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int flow = 0;
		int testListen[] = new int[100];
		int testRead[] = new int[100];
		int option, i = 0, count = 0;
		

		
		while(true)
		{
			if(flow == 0)
			{
				System.out.print("主選項: 1)輸入成績 2)統計資料 3)修改成績 -1)結束: ");
				option = scanner.nextInt();
				if(option == 1)
					flow = 1;
				else if(option == 2)
				{
					if(count == 0)
						System.out.println("尚無統計資料");
					else
						flow = 2;						
				}	
				else if(option == 3)
				{
					if(count == 0)
						System.out.println("尚無成績");
					else
						flow = 3;
				}	
				else if(option == -1)
					break;
				else
				System.out.println("輸入錯誤! 請重新輸入");				// 若非指定輸入值					
			}
			
			if(flow == 1)
			{
				boolean state1 = true, state2 = false;				// 控制執行順序
				
				while(state1)
				{
					System.out.print("聽力測驗: ");
					if(testListen[i] <= 0 || testListen[i] > 120)	// 無值或超過正常值時輸入	
					{
						testListen[i] = scanner.nextInt();
						if(testListen[i] < 0 || testListen[i] > 120)// 值不在120內，則重新輸入
						{
							System.out.println("聽力測驗分數輸入錯誤!");
							
						}
						else
						{
							state1 = false;
							state2 = true;
							break;
						}
					}
					else
						i++;								
				}
				
				while(state2)
				{
					System.out.print("閱讀測驗: ");
					if(testRead[i] <= 0 || testRead[i] > 120)	// 無值或超過正常值時輸入
					{
						testRead[i] = scanner.nextInt();
						if(testRead[i] < 0 || testRead[i] > 120)// 值不在120內，則重新輸入
							System.out.println("閱讀測驗分數輸入錯誤!");
						else
						{
							state1 = true;
							state2 = false;
							break;
						}
					}
					else
						i++;								
				}
				
				System.out.println("總分: " + (testListen[i] + testRead[i]));
				System.out.print("\n");
				i++;
				count = i;		
				flow--;
			}
			
			if(flow == 2)
			{
				System.out.println("\t聽力測驗" +"\t閱讀測驗" +"\t總分");
				System.out.println("----------------------------------------------------------");
				for(i = 0; i < count; i++)
					System.out.println((i + 1) + "\t" + testListen[i] + "\t" + testRead[i] + "\t" + (testListen[i] + testRead[i]));

				double avgListen = 0, avgRead = 0, avgSum = 0, sdListen = 0, sdRead = 0, sdSum = 0;
				int minListen = 121, minRead = 121, maxListen = -1, maxRead = -1, minSum = 242, maxSum = -1;
				// 宣告最大值為最小，最小值為最大
					
				for(i = 0; i < count; i++)			
				{
					avgListen += testListen[i];					// avg
					avgRead += testRead[i];
					avgSum += testListen[i] + testRead[i];
					
					if(minListen > testListen[i])				// min, max
						minListen = testListen[i];
					if(minRead > testRead[i])
						minRead = testRead[i];
					if(maxListen < testListen[i])
						maxListen = testListen[i];
					if(maxRead < testRead[i])
						maxRead = testRead[i];
					if(minSum > testListen[i] + testRead[i])
						minSum = testListen[i] + testRead[i];
					if(maxSum < testListen[i] + testRead[i])
						maxSum = testListen[i] + testRead[i];			
					
					sdListen += testListen[i] * testListen[i];	// sd
					sdRead += testRead[i] * testRead[i];		// 標準差 = (平方和的平均 - 平均的平方) 再開根號
					
					sdSum += (testListen[i] + testRead[i]) * (testListen[i] + testRead[i]);
				}
				avgListen = avgListen / count;					// avg count
				avgRead = avgRead / count;
				avgSum = avgSum / count;
				
				sdListen = sdListen / count;					// sd count
				sdRead = sdRead / count;
				sdSum = sdSum / count;
				
				sdListen = Math.sqrt(sdListen - (avgListen * avgListen));
				sdRead = Math.sqrt(sdRead - (avgRead * avgRead));
				sdSum = Math.sqrt(sdSum - (avgSum * avgSum));

				System.out.println("\n" + "\t聽力測驗" +"\t閱讀測驗" +"\t總分");
				System.out.println("----------------------------------------------------------");
				System.out.printf("平均值\t%.2f\t%.2f\t%.2f\n",avgListen ,avgRead, avgSum);
				System.out.printf("標準差\t%.2f\t%.2f\t%.2f\n",sdListen ,sdRead ,sdSum);
				System.out.println("最小值\t" + minListen + "\t" + minRead + "\t" + minSum);
				System.out.println("最大值\t" + maxListen + "\t" + maxRead + "\t" + maxSum);
				
				System.out.print("\n");
				flow = 0;
			}
			
			if(flow == 3)
			{
				System.out.print("編號: ");
				i = scanner.nextInt() - 1;							// 編號輸入數值 - 1 = 陣列數值，陣列索引由0開始
				if(i <= count - 1 && i >= 0)						// 索引值不大於輸入的資料筆數，且不為負數
				{
					while(true)
					{
						System.out.print("修正分數: ");				// 直接修改陣列中的數值
						testListen[i] = scanner.nextInt();
						testRead[i] = scanner.nextInt();
						
						if(testListen[i] < 0 || testListen[i] > 120 || testRead[i] < 0 || testRead[i] > 120)// 值不在120內，則重新輸入
							System.out.println("測驗分數輸入錯誤!");
						else
						{
							flow = 0;
							break;
						}
					}
					
				}
				else
					System.out.println("索引超出範圍！");
					
			}
			
		}
		

	}

}
