package lesson12_1;
import java.util.Scanner;
public class gradeCalculate {

	public enum Status{
		PASSED, RANK
	}
	public static Status sta;
	public static boolean showTotal;
	public static Scanner scanner = new Scanner(System.in);
	public static int stuCount = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �_�l�y�{��1
		int option = 1, optionEM;
		// �Ǹ��B�^����ơB�ƾǤ��ơB�����B�ƦW
		int stuNum, stuEng, stuMath;
		int stu[][] = new int[100][5];
		
		while(true)
		{
			if(option == 0)
			{
				System.out.print("\nOption: 1) Add. 2) Histogram. 3) Output. 4) Query. 5) Rank. -1) Quit: ");
				option = scanner.nextInt();
			}
			// Quit
			else if(option == -1)
			{
				System.out.println("Bye!");
				break;
			}
			// Add
			else if(option == 1)
			{
				System.out.print("Insert new data (SN/ENGLISH/MATH): ");
				stuNum = scanner.nextInt();
				stuEng = scanner.nextInt();
				stuMath = scanner.nextInt();
				
				int again = 0;
				
				// �ȧ���-1�h�i�J���
				if(stuNum == -1 && stuEng == -1 && stuMath == -1)
				{
					option = 0;
					continue;
				}
				else if(stuNum > stu.length)
				{
					System.out.println("The student number exceeds!");
					continue;
				}
				
				for(int i = 0 ; i < stuCount ; i++)
				{
					if(stu[i][0] == stuNum)
					{
						System.out.println("Data \'" + stuNum + "\' duplicated!");
						again++;
						break;
					}
				}
				
				if(again == 0)
				{
					stu[stuCount][0] = stuNum;
					stu[stuCount][1] = stuEng;
					stu[stuCount][2] = stuMath;
					stu[stuCount][3] = (stuEng +stuMath) / 2;
					stuCount++;					
				}

			}
			// Histogram
			else if(option == 2)
			{
				System.out.print("1) English. 2) Math. -1) Back: ");
				optionEM = scanner.nextInt();
				
				// Back
				if(optionEM == -1)
				{
					System.out.println();
					option = 0;
					continue;
				}				
				// 1: English, 2: Math are the same as array's index 
				if( optionEM == 1 || optionEM == 2)
				{
					drawHistogram(stu, optionEM);	
				}				
				else
					System.out.println("Error! Try again.");		
				
			}
			// Output
			else if(option == 3)
			{
				sta = Status.PASSED;
				showTotal = false;
				// �}�C�B���(����)�B�}�l�B���� ->��ܱ���:����
				drawTablePassed(stu, 3, 0, 100);
				System.out.println();
				showTotal = true;
				option = 0;				
			}
			// Query
			else if(option == 4)
			{
				System.out.print("1) English. 2) Math. 3) Average. -1) Back: ");
				optionEM = scanner.nextInt();
				
				// Back
				if(optionEM == -1)
				{
					System.out.println("");
					option = 0;
					continue;
				}				
				// 1: English, 2: Math are the same as array's index 
				if( optionEM == 1 || optionEM == 2 || optionEM == 3)
				{
					System.out.print("Start: ");
					int gradeStart = scanner.nextInt();
					System.out.print("End: ");
					int gradeEnd = scanner.nextInt();
					System.out.println();
					
					sta = Status.PASSED;
					// �}�C�B���(����)�B�}�l�B����
					drawTablePassed(stu, optionEM, gradeStart, gradeEnd);					
					option = 0;
				}				
				else
					System.out.println("Error! Try again.");		
			}
			// Rank
			else if(option == 5)
			{			
				System.out.print("1) English. 2) Math. 3) Average. -1) Back: ");
				optionEM = scanner.nextInt();
						
				// Back
				if(optionEM == -1)
				{
					System.out.println("");
					option = 0;
					continue;
				}				
				// 1: English, 2: Math are the same as array's index 
				if( optionEM == 1 || optionEM == 2 || optionEM == 3)
				{			
					System.out.print("Start: ");
					int gradeStart = scanner.nextInt();
					System.out.print("End: ");
					int gradeEnd = scanner.nextInt();
					
					sta = Status.RANK;
					// �}�C�B���(����)�B�}�l�B����
					drawTablePassed(stu, optionEM, gradeStart, gradeEnd);					
					option = 0;
				}				
				else
					System.out.println("Error! Try again.");
				
			}			
			else
			{
				System.out.println("Error! Try again.");
				option = 0;
			}			
		}		
		
	}
	
	// �ƨ禡: �����
	public static void drawHistogram(int[][] x, int subject)
	{		
		int i;
		int count[] = new int[11];
		
		// ����Ϫ�l��
		for(i = 0; i <= 9 ; i++)
			System.out.print((i * 10) + "\t");
		System.out.println(i * 10);
		for(i = 0; i <= 9 ; i++)	
			for(int j = 0 ; j < 8 ; j++)
				System.out.print("-");
		System.out.println("----");
		
		// ����*�A0~9�Q�Ӭ��@��
		for(int k = 0 ; k < stuCount ; k++)
		{
			if(x[k][subject]>= 0 && x[k][subject] < 10)
				count[0]++;
			else if(x[k][subject]>= 10 && x[k][subject] < 20)
				count[1]++;
			else if(x[k][subject]>= 20 && x[k][subject] < 30)
				count[2]++;
			else if(x[k][subject]>= 30 && x[k][subject] < 40)
				count[3]++;
			else if(x[k][subject]>= 40 && x[k][subject] < 50)
				count[4]++;
			else if(x[k][subject]>= 50 && x[k][subject] < 60)
				count[5]++;
			else if(x[k][subject]>= 60 && x[k][subject] < 70)
				count[6]++;
			else if(x[k][subject]>= 70 && x[k][subject] < 80)
				count[7]++;
			else if(x[k][subject]>= 80 && x[k][subject] < 90)
				count[8]++;
			else if(x[k][subject]>= 90 && x[k][subject] < 100)
				count[9]++;
			else
				count[10]++;			
		}
		
		// ��̤j�ȥH������ܦC
		int bigValue = 0;
		for(int k = 0 ; k < 10 ; k++)
		{
			if(count[k] > count[k + 1] && count[k] > bigValue)
				bigValue = count[k];
			else if(count[k] < count[k + 1] && count[k + 1] > bigValue) 
				bigValue = count[k + 1];				
		}
		
		// ��X*
		for(int k = 1 ; k<= bigValue ; k++)
		{
			for(i = 0; i <= 10 ; i++)
			{
				if(count[i] >= k)
					System.out.print("*\t");
				else
					System.out.print(" \t");
			}
			// ��������
			System.out.println();
		}
		System.out.println();
	}
	// �ƨ禡: ��� ->����passed�Brank
	public static void drawTablePassed(int[][] x, int subject, int start, int end)
	{
		// ��l�Ƥ@: ����start�Ʀr�p�Bend�Ʀr�j 
		if(start > end)
		{
			int temp = start;
			start = end;
			end = temp;
		}
		
		// ��l�ƤG: �ܼ�
		int stuTotal = 0;
		double avg = 0;
		double sum = 0;
		int med[] = new int[100];
		int j = 0;
		
		// ��l�ƤT: ��ܶ���		
		String item = "PASSED";
		if(sta == Status.RANK)
		{
			item = "Rank";
			
			// �Ǹ��B���Z�s�J��Ƨ�
			int rank[][] = new int[stuCount][2];			
			for(int i = 0 ; i < stuCount; i++)
			{
				rank[i][0] = x[i][0];
				rank[i][1] = x[i][3];
			}
			
			// n-1����1��
			for(int k = 0 ; k < stuCount - 1 ; k++)
			{
				// �C����n-1���A��[�J���i��O�̤j�A�G���ק令�ѭ����}�l
				for(int i = 0 ; i < stuCount - 1 ; i++)
				{
					if(rank[i][1] < rank[i + 1][1])	// �Ѥj��p
					{
						int temp[] = rank[i];
						rank[i] = rank[i + 1];
						rank[i + 1] = temp;
					}
				}
			}
						
			for(int i = 0 ; i < stuCount ; i++)
			{
				for(int k = 0 ; k < stuCount ; k++)
				{
					if(i == 0)
					{
						if(x[k][0] == rank[i][0])
							x[k][4] = i + 1;
					}
					else
					{
						if(x[k][0] == rank[i][0])
						{
							// �P���h�ƦW�ۦP
							if(rank[i][1] == rank[i - 1][1])
								x[k][4] = i;
							else
								x[k][4] = i + 1;
						}
					}
				}				
			}
		}	
		
		System.out.println("SN\t" + "ENG.\t" + "MATH.\t" + "AVG.\t" + item);
		System.out.println("----------------------------------------------------------------------");
		for(int i = 0 ; i < stuCount ; i++)
		{
			// �ŦX����h��X
			if(x[i][subject] >= start && x[i][subject] <= end)
			{
				System.out.print(x[i][0] + "\t" + x[i][1] + "\t" + x[i][2] + "\t" + x[i][3] + "\t");
				if(sta == Status.PASSED)
				{
					if(x[i][3] >= 60)
						System.out.println("y");
					else
						System.out.println("n");
				}
				else if(sta == Status.RANK)
					System.out.println(x[i][4]);
				
				// �έp��
				stuTotal++;
				
				// Average
				avg += x[i][subject];
				// STD
				sum += (x[i][subject] * x[i][subject]);		
				// Median
				med[j++] = x[i][subject];
			}			
		}
		// �϶��L��
		if(stuTotal == 0)
			System.out.println("�L������");
		
		// ��ܶ���
		else if(sta == Status.PASSED && showTotal != false)
		{
			System.out.println("----------------------------------------------------------------------");
			System.out.println("Total: " + stuTotal);
		}
		else if(sta == Status.RANK)
		{
			System.out.println("----------------------------------------------------------------------");
			
			avg /= stuCount;
			sum /= stuCount;
			sum -= (avg * avg); 
			sum = Math.sqrt(sum);
			
			System.out.printf("Average: %.2f \n", avg);
			System.out.printf("STD: %.2f \n", sum);
			
			if(stuTotal % 2 == 0)
				System.out.println("Median: " + med[(stuTotal / 2) - 1]);
			else
				System.out.println("Median: " + med[(stuTotal / 2)]);		
		}
		
	}	

	// �ƨ禡: ��X
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
