package lesson7_2;
import java.util.Scanner;

public class linearSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int studentNum[] = new int[100];			// 宣告並建立整數陣列: 學號、英文成績、數學成績
		int gradeEng[] = new int[100];
		int gradeMath[] = new int[100];
		int avg[] = new int[100];					// 宣告並建立整數陣列: 將平均存放
		int flow = 1, option, i = 0 ,count = 0;		// 宣告起始流程為1
		int pos;									// 陣列停駐點

		while(true)
		{
			if(flow == 0)
			{
				System.out.print("\nOption: 1) Add. 2) Output. -1) Quit: ");
				option = scanner.nextInt();
				if(option == 1)
					flow = 1;
				else if(option == 2)
					flow = 2;			
				else if(option == -1)
				{
					System.out.println("Bye!");
					break;
				}
				else
					System.out.println("Error! Please try again");							// 若非指定輸入值
			}

			if(flow == 1)
			{
				while(true)
				{
					System.out.print("Insert new data (SN/ENGLISH/MATH): ");
					studentNum[i] = scanner.nextInt();
					gradeEng[i] = scanner.nextInt();
					gradeMath[i] = scanner.nextInt();

					if(studentNum[i] == -1 && gradeEng[i] == -1 && gradeMath[i] == -1)		// 值均為-1則進入選單
					{
//						studentNum[i] = 0;													// 數值回到初始值
//						gradeEng[i] = 0; 
//						gradeMath[i] = 0;
						flow--;
						break;
					}

					for(pos = 0 ; pos < count ; pos++)					
					{
						if(studentNum[pos] == studentNum[i])								// 學號已建檔
						{
							System.out.println("Student number exists! Try again!");
							studentNum[i] = studentNum[pos];								// 數值回到原值
							gradeEng[i] = gradeEng[pos]; 
							gradeMath[i] = gradeMath[pos];
							i--;															// 該次不計
							break;
						}
					}

					if(studentNum[i] < 1 || studentNum[i] > 100)							// 學號值為1~100
						System.out.println("Stundent number error! Try again!");			// 成績為0~100					
					if(gradeEng[i] < 0 || gradeEng[i] > 100 || gradeMath[i] < 0 || gradeMath[i] > 100)
						System.out.println("Grade error! Try again!");
					else if(studentNum[i] > 0 && studentNum[i] <= 100 && gradeEng[i] >= 0 && 
							gradeEng[i] <= 100 && gradeMath[i] >= 0 && gradeMath[i] <= 100)
					{	
						avg[i] = (gradeEng[i] + gradeMath[i]) / 2;							// 計算平均					
						i++;
						count = i;
						break;
					}

				}

			}

			if(flow == 2)
			{
				System.out.println("SN\t" + "ENG.\t" +"MATH.\t" + "AVG.\t");
				for(int pass = 1 ; pass < avg.length ; pass++)								// 利用氣泡排序法，並精簡執行
				{
					for(i = 0 ; i < count - pass ; i++)
					{
						if(avg[i] < avg[i+1])
						{
							int temp = avg[i];
							avg[i] = avg[i + 1];
							avg[i + 1] = temp;

							temp = gradeEng[i];
							gradeEng[i] = gradeEng[i + 1];
							gradeEng[i + 1] = temp;

							temp = gradeMath[i];
							gradeMath[i] = gradeMath[i + 1];
							gradeMath[i + 1] = temp;	

							temp = studentNum[i];
							studentNum[i] = studentNum[i + 1];
							studentNum[i + 1] = temp;
						}
					}
				}
				for(i = 0 ; i < count ; i++)
					System.out.println( studentNum[i] + "\t" + gradeEng[i] + "\t" + gradeMath[i] + "\t" + avg[i] + "\t");

				flow = 0;

			}
		}

	}

}
