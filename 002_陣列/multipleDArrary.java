package lesson8_2;
import java.util.Scanner;
public class multipleDArrary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int coordinate[][] = new int[100][2];
		double distance[][] = new double[100][2];
		int option = 0, i, count = 0;
		for(i = 0 ; i < distance.length ; i++)							// �N�Z���ȳ]��-1
			distance[i][0] = -1;		
		i = 0;															// �Ni�^���l��
		
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
				System.out.print("�п�J�y��:");
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
					for(int j = i + 1 ; j < count ; j++)					// �ƭȸ��L�ƭȤ��
					{						
						double temp = Math.sqrt(Math.pow((coordinate[i][0] - coordinate[j][0]), 2) + Math.pow((coordinate[i][1] - coordinate[j][1]), 2));
						
						if(distance[j][0] == -1 || temp < distance[j][0])
						{
							distance[j][0] = temp;							// �N�ƭ���g (0, 1) -> (1, 0)
							distance[j][1] = i;								// �Ӧ�}�s�J����1							
						}
						
						if(temp < distance[i][0] || distance[i][0] == -1 )	// ���p��
						{	
							distance[i][0] = temp;
							distance[i][1] = j;								// �Ӧ�}�s�J����1
						}
					}
					
				}
				
				for(i = 0 ; i < count ; i++)								// �C�L�̤p�Z���θӮy��
				{
					int xy = (int)distance[i][1];
					System.out.printf("(%3d, %3d)\t->\t(%3d, %3d)\t�Z���G%.2f\n", 
							coordinate[i][0], coordinate[i][1], coordinate[xy][0], coordinate[xy][1], distance[i][0]);
				}
				option = 0;
			}
		}
	}

}
