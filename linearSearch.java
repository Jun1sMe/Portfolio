package lesson7_2;
import java.util.Scanner;

public class linearSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int studentNum[] = new int[100];			// �ŧi�ëإ߾�ư}�C: �Ǹ��B�^�妨�Z�B�ƾǦ��Z
		int gradeEng[] = new int[100];
		int gradeMath[] = new int[100];
		int avg[] = new int[100];					// �ŧi�ëإ߾�ư}�C: �N�����s��
		int flow = 1, option, i = 0 ,count = 0;		// �ŧi�_�l�y�{��1
		int pos;									// �}�C���n�I

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
					System.out.println("Error! Please try again");							// �Y�D���w��J��
			}

			if(flow == 1)
			{
				while(true)
				{
					System.out.print("Insert new data (SN/ENGLISH/MATH): ");
					studentNum[i] = scanner.nextInt();
					gradeEng[i] = scanner.nextInt();
					gradeMath[i] = scanner.nextInt();

					if(studentNum[i] == -1 && gradeEng[i] == -1 && gradeMath[i] == -1)		// �ȧ���-1�h�i�J���
					{
//						studentNum[i] = 0;													// �ƭȦ^���l��
//						gradeEng[i] = 0; 
//						gradeMath[i] = 0;
						flow--;
						break;
					}

					for(pos = 0 ; pos < count ; pos++)					
					{
						if(studentNum[pos] == studentNum[i])								// �Ǹ��w����
						{
							System.out.println("Student number exists! Try again!");
							studentNum[i] = studentNum[pos];								// �ƭȦ^����
							gradeEng[i] = gradeEng[pos]; 
							gradeMath[i] = gradeMath[pos];
							i--;															// �Ӧ����p
							break;
						}
					}

					if(studentNum[i] < 1 || studentNum[i] > 100)							// �Ǹ��Ȭ�1~100
						System.out.println("Stundent number error! Try again!");			// ���Z��0~100					
					if(gradeEng[i] < 0 || gradeEng[i] > 100 || gradeMath[i] < 0 || gradeMath[i] > 100)
						System.out.println("Grade error! Try again!");
					else if(studentNum[i] > 0 && studentNum[i] <= 100 && gradeEng[i] >= 0 && 
							gradeEng[i] <= 100 && gradeMath[i] >= 0 && gradeMath[i] <= 100)
					{	
						avg[i] = (gradeEng[i] + gradeMath[i]) / 2;							// �p�⥭��					
						i++;
						count = i;
						break;
					}

				}

			}

			if(flow == 2)
			{
				System.out.println("SN\t" + "ENG.\t" +"MATH.\t" + "AVG.\t");
				for(int pass = 1 ; pass < avg.length ; pass++)								// �Q�ή�w�ƧǪk�A�ú�²����
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
