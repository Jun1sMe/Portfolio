import java.util.Scanner;
public class countPolynomial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		double poly[][] = new double[10][100];
		int insertYN = 0;
		int count = 0; 		// 執行次數
	
		while(true)
		{
			// 選擇新增與否
			if(insertYN == 0)
			{
				System.out.print("Insert a new polynomial (1: yes/2: no)? ");
				insertYN = scanner.nextInt();
				if(insertYN != 1 && insertYN != 2)
					insertYN = 0;
			}
			
			// 選擇新增
			if(insertYN == 1)
			{
				System.out.print("Add new term (coefficient exponent): ");
				double coefficient = scanner.nextDouble();
				int exponent = scanner.nextInt();
				
				// inserted condition
				if(coefficient == 0 && exponent == 0)
				{
					System.out.println("P" + count + " is inserted!\n");
				
					int match = 0;
					for(int j = poly[count].length - 1 ; j >= 0  ; j--)
					{
						if(poly[count][j] != 0)
						{
							// 索引值j存在數值，則為該陣列最大之次方;長度為j+1
							// 將二維陣列之第二維度變小
							// 利用break離開，以免尋找下一位次方
							double tempArray[] = new double[j + 1];
							for(int k = 0 ; k < j + 1 ; k++)
								tempArray[k] = poly[count][k];
							poly[count] = tempArray;
							break;
						}
						else
						{
							// 輸入該項次，全值均為0
							// 將二維陣列之第二維度變最小
							match++;
							if(match == poly[count].length)
							{
								double tempArray[] = new double[j];
								poly[count] = tempArray;
							}
						}
					}				
					count++;
					insertYN = 0;
				}	
				else if(exponent >= 0)
				{
					// resize array
					while(exponent >= poly[count].length)				
					{
						// 將二維陣列之第二維度變大
						double tempArray[] = new double[poly[count].length * 2];
						for(int k = 0 ; k < poly[count].length ; k++)
							tempArray[k] = poly[count][k];
						poly[count] = tempArray;
					}
					// make exponent as an index
					poly[count][exponent] = coefficient;
				}
				else
					System.out.println("Exponent out of range!");				
			}
			
			// 選擇新增結束
			else if(insertYN == 2)
			{			
				System.out.print("Option: 1) Output. 2) Add. 3) Subtract. -1) Quit? ");
				int option = scanner.nextInt();
				
				// 輸出選項
				if(option == 1)
				{
					System.out.print("Which polynomial: ");
					count = scanner.nextInt();					
				
					// 未輸入數值
					if(poly[count].length == 100)
					{
						System.out.println("Polynomial " + count + " does not exist!\n");						
						continue;
					}
					// 輸入值為0
					if(poly[count].length == 0)
						System.out.print("P" + count + ": 0");
					else
					{						
						System.out.print("P" + count + ": ");
						// 印出多項式，j為索引值
						for(int j = poly[count].length - 1 ; j >= 0 ; j--)
						{
							// 第一項
							if(j == poly[count].length - 1)
								System.out.print(poly[count][j] + "x^" + j );
							// 其餘項
							else if(poly[count][j] != 0 && j != 0 && poly[count][j] > 0)
								System.out.print(" + " + poly[count][j] + "x^" + j );
							else if(poly[count][j] != 0 && j != 0 && poly[count][j] < 0 )
								System.out.print(" - " + (poly[count][j] * (-1)) + "x^" + j );	
							// 常數項
							if(j == 0)
							{
								if(poly[count][j] > 0)
									System.out.print(" + " + poly[count][0]);
								else if(poly[count][j] < 0)
									System.out.print(" - " + (poly[count][0] * (-1)));
							}
						}	
					}
					// 全句完成
					System.out.println();
				}
				
				// 相加選項
				else if(option == 2)
				{
					// 未輸入數值
					if(poly[count].length == 100)
					{
						System.out.println("There's no polynomial!\n");						
						continue;
					}
					
					// 被加數、加數
					System.out.print("Summand: ");
					int summand = scanner.nextInt();
					System.out.print("Addend: ");
					int addend = scanner.nextInt();
					
					// balance size
					if(poly[summand].length > poly[addend].length)
					{
						double tempArray[] = new double[poly[summand].length];
						for(int k = 0 ; k < poly[addend].length ; k++)
							tempArray[k] = poly[addend][k];
						poly[addend] = tempArray;
					}
					else if(poly[summand].length < poly[addend].length)
					{
						double tempArray[] = new double[poly[addend].length];
						for(int k = 0 ; k < poly[summand].length ; k++)
							tempArray[k] = poly[summand][k];
						poly[summand] = tempArray;						
					}
					
					// 被加數值丟給count
					count = summand;
					// 運算
					for(int i = 0 ; i < poly[summand].length  ;i++)
						poly[count][i] = poly[summand][i] + poly[addend][i];
					
					// 加數size恢復
					for(int j = poly[addend].length - 1 ; j >= 0  ; j--)
					{
						if(poly[addend][j] != 0)
						{
							// 索引值j存在數值，則為該陣列最大之次方;長度為j+1
							// 將二維陣列之第二維度變小
							// 利用break離開，以免尋找下一位次方
							double tempArray[] = new double[j + 1];
							for(int k = 0 ; k < j + 1 ; k++)
								tempArray[k] = poly[addend][k];
							poly[addend] = tempArray;
							break;
						}
					}

					// 輸出
					System.out.print("P" + count + ": ");
					// 印出多項式，j為索引值
					for(int j = poly[count].length - 1 ; j >= 0 ; j--)
					{
						// 第一項
						if(j == poly[count].length - 1)
							System.out.print(poly[count][j] + "x^" + j );
						// 其餘項
						else if(poly[count][j] != 0 && j != 0 && poly[count][j] > 0)
							System.out.print(" + " + poly[count][j] + "x^" + j );
						else if(poly[count][j] != 0 && j != 0 && poly[count][j] < 0 )
							System.out.print(" - " + (poly[count][j] * (-1)) + "x^" + j );	
						// 常數項
						if(j == 0)
						{
							if(poly[count][j] > 0)
								System.out.print(" + " + poly[count][0]);
							else if(poly[count][j] < 0)
								System.out.print(" - " + (poly[count][0] * (-1)));
						}
					}
					// 全句完成
					System.out.println();
				}
				
				// 相減選項
				else if(option == 3)
				{
					// 未輸入數值
					if(poly[count].length == 100)
					{
						System.out.println("There's no polynomial!\n");						
						continue;
					}
					
					// 被減數、減數
					System.out.print("Minuend: ");
					int minuend = scanner.nextInt();
					System.out.print("Subtrahend: ");
					int subtrahend = scanner.nextInt();					
			
					// balance size
					if(poly[minuend].length > poly[subtrahend].length)
					{
						double tempArray[] = new double[poly[minuend].length];
						for(int k = 0 ; k < poly[subtrahend].length ; k++)
							tempArray[k] = poly[subtrahend][k];
						poly[subtrahend] = tempArray;
					}
					else if(poly[minuend].length < poly[subtrahend].length)
					{
						double tempArray[] = new double[poly[subtrahend].length];
						for(int k = 0 ; k < poly[minuend].length ; k++)
							tempArray[k] = poly[minuend][k];
						poly[minuend] = tempArray;						
					}
					
					// 被減數值丟給count
					count = minuend;
					// 運算
					for(int i = 0 ; i < poly[minuend].length  ;i++)
						poly[count][i] = poly[minuend][i] - poly[subtrahend][i];
					
					// 減數size恢復
					for(int j = poly[subtrahend].length - 1 ; j >= 0  ; j--)
					{
						if(poly[subtrahend][j] != 0)
						{
							// 索引值j存在數值，則為該陣列最大之次方;長度為j+1
							// 將二維陣列之第二維度變小
							// 利用break離開，以免尋找下一位次方
							double tempArray[] = new double[j + 1];
							for(int k = 0 ; k < j + 1 ; k++)
								tempArray[k] = poly[subtrahend][k];
							poly[subtrahend] = tempArray;
							break;
						}
					}

					// 輸出
					System.out.print("P" + count + ": ");
					// 印出多項式，j為索引值
					for(int j = poly[count].length - 1 ; j >= 0 ; j--)
					{
						// 第一項
						if(j == poly[count].length - 1)
							System.out.print(poly[count][j] + "x^" + j );
						// 其餘項
						else if(poly[count][j] != 0 && j != 0 && poly[count][j] > 0)
							System.out.print(" + " + poly[count][j] + "x^" + j );
						else if(poly[count][j] != 0 && j != 0 && poly[count][j] < 0 )
							System.out.print(" - " + (poly[count][j] * (-1)) + "x^" + j );	
						// 常數項
						if(j == 0)
						{
							if(poly[count][j] > 0)
								System.out.print(" + " + poly[count][0]);
							else if(poly[count][j] < 0)
								System.out.print(" - " + (poly[count][0] * (-1)));
						}
					}
					// 全句完成
					System.out.println();
				}
				
				// 離開選項
				else if(option == -1)
					break;

				else
					continue;
			}
		}

	}

}
