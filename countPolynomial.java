import java.util.Scanner;
public class countPolynomial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		double poly[][] = new double[10][100];
		int insertYN = 0;
		int count = 0; 		// ���榸��
	
		while(true)
		{
			// ��ܷs�W�P�_
			if(insertYN == 0)
			{
				System.out.print("Insert a new polynomial (1: yes/2: no)? ");
				insertYN = scanner.nextInt();
				if(insertYN != 1 && insertYN != 2)
					insertYN = 0;
			}
			
			// ��ܷs�W
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
							// ���ޭ�j�s�b�ƭȡA�h���Ӱ}�C�̤j������;���׬�j+1
							// �N�G���}�C���ĤG�����ܤp
							// �Q��break���}�A�H�K�M��U�@�즸��
							double tempArray[] = new double[j + 1];
							for(int k = 0 ; k < j + 1 ; k++)
								tempArray[k] = poly[count][k];
							poly[count] = tempArray;
							break;
						}
						else
						{
							// ��J�Ӷ����A���ȧ���0
							// �N�G���}�C���ĤG�����̤ܳp
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
						// �N�G���}�C���ĤG�����ܤj
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
			
			// ��ܷs�W����
			else if(insertYN == 2)
			{			
				System.out.print("Option: 1) Output. 2) Add. 3) Subtract. -1) Quit? ");
				int option = scanner.nextInt();
				
				// ��X�ﶵ
				if(option == 1)
				{
					System.out.print("Which polynomial: ");
					count = scanner.nextInt();					
				
					// ����J�ƭ�
					if(poly[count].length == 100)
					{
						System.out.println("Polynomial " + count + " does not exist!\n");						
						continue;
					}
					// ��J�Ȭ�0
					if(poly[count].length == 0)
						System.out.print("P" + count + ": 0");
					else
					{						
						System.out.print("P" + count + ": ");
						// �L�X�h�����Aj�����ޭ�
						for(int j = poly[count].length - 1 ; j >= 0 ; j--)
						{
							// �Ĥ@��
							if(j == poly[count].length - 1)
								System.out.print(poly[count][j] + "x^" + j );
							// ��l��
							else if(poly[count][j] != 0 && j != 0 && poly[count][j] > 0)
								System.out.print(" + " + poly[count][j] + "x^" + j );
							else if(poly[count][j] != 0 && j != 0 && poly[count][j] < 0 )
								System.out.print(" - " + (poly[count][j] * (-1)) + "x^" + j );	
							// �`�ƶ�
							if(j == 0)
							{
								if(poly[count][j] > 0)
									System.out.print(" + " + poly[count][0]);
								else if(poly[count][j] < 0)
									System.out.print(" - " + (poly[count][0] * (-1)));
							}
						}	
					}
					// ���y����
					System.out.println();
				}
				
				// �ۥ[�ﶵ
				else if(option == 2)
				{
					// ����J�ƭ�
					if(poly[count].length == 100)
					{
						System.out.println("There's no polynomial!\n");						
						continue;
					}
					
					// �Q�[�ơB�[��
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
					
					// �Q�[�ƭȥᵹcount
					count = summand;
					// �B��
					for(int i = 0 ; i < poly[summand].length  ;i++)
						poly[count][i] = poly[summand][i] + poly[addend][i];
					
					// �[��size��_
					for(int j = poly[addend].length - 1 ; j >= 0  ; j--)
					{
						if(poly[addend][j] != 0)
						{
							// ���ޭ�j�s�b�ƭȡA�h���Ӱ}�C�̤j������;���׬�j+1
							// �N�G���}�C���ĤG�����ܤp
							// �Q��break���}�A�H�K�M��U�@�즸��
							double tempArray[] = new double[j + 1];
							for(int k = 0 ; k < j + 1 ; k++)
								tempArray[k] = poly[addend][k];
							poly[addend] = tempArray;
							break;
						}
					}

					// ��X
					System.out.print("P" + count + ": ");
					// �L�X�h�����Aj�����ޭ�
					for(int j = poly[count].length - 1 ; j >= 0 ; j--)
					{
						// �Ĥ@��
						if(j == poly[count].length - 1)
							System.out.print(poly[count][j] + "x^" + j );
						// ��l��
						else if(poly[count][j] != 0 && j != 0 && poly[count][j] > 0)
							System.out.print(" + " + poly[count][j] + "x^" + j );
						else if(poly[count][j] != 0 && j != 0 && poly[count][j] < 0 )
							System.out.print(" - " + (poly[count][j] * (-1)) + "x^" + j );	
						// �`�ƶ�
						if(j == 0)
						{
							if(poly[count][j] > 0)
								System.out.print(" + " + poly[count][0]);
							else if(poly[count][j] < 0)
								System.out.print(" - " + (poly[count][0] * (-1)));
						}
					}
					// ���y����
					System.out.println();
				}
				
				// �۴�ﶵ
				else if(option == 3)
				{
					// ����J�ƭ�
					if(poly[count].length == 100)
					{
						System.out.println("There's no polynomial!\n");						
						continue;
					}
					
					// �Q��ơB���
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
					
					// �Q��ƭȥᵹcount
					count = minuend;
					// �B��
					for(int i = 0 ; i < poly[minuend].length  ;i++)
						poly[count][i] = poly[minuend][i] - poly[subtrahend][i];
					
					// ���size��_
					for(int j = poly[subtrahend].length - 1 ; j >= 0  ; j--)
					{
						if(poly[subtrahend][j] != 0)
						{
							// ���ޭ�j�s�b�ƭȡA�h���Ӱ}�C�̤j������;���׬�j+1
							// �N�G���}�C���ĤG�����ܤp
							// �Q��break���}�A�H�K�M��U�@�즸��
							double tempArray[] = new double[j + 1];
							for(int k = 0 ; k < j + 1 ; k++)
								tempArray[k] = poly[subtrahend][k];
							poly[subtrahend] = tempArray;
							break;
						}
					}

					// ��X
					System.out.print("P" + count + ": ");
					// �L�X�h�����Aj�����ޭ�
					for(int j = poly[count].length - 1 ; j >= 0 ; j--)
					{
						// �Ĥ@��
						if(j == poly[count].length - 1)
							System.out.print(poly[count][j] + "x^" + j );
						// ��l��
						else if(poly[count][j] != 0 && j != 0 && poly[count][j] > 0)
							System.out.print(" + " + poly[count][j] + "x^" + j );
						else if(poly[count][j] != 0 && j != 0 && poly[count][j] < 0 )
							System.out.print(" - " + (poly[count][j] * (-1)) + "x^" + j );	
						// �`�ƶ�
						if(j == 0)
						{
							if(poly[count][j] > 0)
								System.out.print(" + " + poly[count][0]);
							else if(poly[count][j] < 0)
								System.out.print(" - " + (poly[count][0] * (-1)));
						}
					}
					// ���y����
					System.out.println();
				}
				
				// ���}�ﶵ
				else if(option == -1)
					break;

				else
					continue;
			}
		}

	}

}
