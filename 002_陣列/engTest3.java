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
				System.out.print("�D�ﶵ: 1)��J���Z 2)�έp��� 3)�ק令�Z -1)����: ");
				option = scanner.nextInt();
				if(option == 1)
					flow = 1;
				else if(option == 2)
				{
					if(count == 0)
						System.out.println("�|�L�έp���");
					else
						flow = 2;						
				}	
				else if(option == 3)
				{
					if(count == 0)
						System.out.println("�|�L���Z");
					else
						flow = 3;
				}	
				else if(option == -1)
					break;
				else
				System.out.println("��J���~! �Э��s��J");				// �Y�D���w��J��					
			}
			
			if(flow == 1)
			{
				boolean state1 = true, state2 = false;				// ������涶��
				
				while(state1)
				{
					System.out.print("ť�O����: ");
					if(testListen[i] <= 0 || testListen[i] > 120)	// �L�ȩζW�L���`�Ȯɿ�J	
					{
						testListen[i] = scanner.nextInt();
						if(testListen[i] < 0 || testListen[i] > 120)// �Ȥ��b120���A�h���s��J
						{
							System.out.println("ť�O������ƿ�J���~!");
							
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
					System.out.print("�\Ū����: ");
					if(testRead[i] <= 0 || testRead[i] > 120)	// �L�ȩζW�L���`�Ȯɿ�J
					{
						testRead[i] = scanner.nextInt();
						if(testRead[i] < 0 || testRead[i] > 120)// �Ȥ��b120���A�h���s��J
							System.out.println("�\Ū������ƿ�J���~!");
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
				
				System.out.println("�`��: " + (testListen[i] + testRead[i]));
				System.out.print("\n");
				i++;
				count = i;		
				flow--;
			}
			
			if(flow == 2)
			{
				System.out.println("\tť�O����" +"\t�\Ū����" +"\t�`��");
				System.out.println("----------------------------------------------------------");
				for(i = 0; i < count; i++)
					System.out.println((i + 1) + "\t" + testListen[i] + "\t" + testRead[i] + "\t" + (testListen[i] + testRead[i]));

				double avgListen = 0, avgRead = 0, avgSum = 0, sdListen = 0, sdRead = 0, sdSum = 0;
				int minListen = 121, minRead = 121, maxListen = -1, maxRead = -1, minSum = 242, maxSum = -1;
				// �ŧi�̤j�Ȭ��̤p�A�̤p�Ȭ��̤j
					
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
					sdRead += testRead[i] * testRead[i];		// �зǮt = (����M������ - ����������) �A�}�ڸ�
					
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

				System.out.println("\n" + "\tť�O����" +"\t�\Ū����" +"\t�`��");
				System.out.println("----------------------------------------------------------");
				System.out.printf("������\t%.2f\t%.2f\t%.2f\n",avgListen ,avgRead, avgSum);
				System.out.printf("�зǮt\t%.2f\t%.2f\t%.2f\n",sdListen ,sdRead ,sdSum);
				System.out.println("�̤p��\t" + minListen + "\t" + minRead + "\t" + minSum);
				System.out.println("�̤j��\t" + maxListen + "\t" + maxRead + "\t" + maxSum);
				
				System.out.print("\n");
				flow = 0;
			}
			
			if(flow == 3)
			{
				System.out.print("�s��: ");
				i = scanner.nextInt() - 1;							// �s����J�ƭ� - 1 = �}�C�ƭȡA�}�C���ޥ�0�}�l
				if(i <= count - 1 && i >= 0)						// ���ޭȤ��j���J����Ƶ��ơA�B�����t��
				{
					while(true)
					{
						System.out.print("�ץ�����: ");				// �����ק�}�C�����ƭ�
						testListen[i] = scanner.nextInt();
						testRead[i] = scanner.nextInt();
						
						if(testListen[i] < 0 || testListen[i] > 120 || testRead[i] < 0 || testRead[i] > 120)// �Ȥ��b120���A�h���s��J
							System.out.println("������ƿ�J���~!");
						else
						{
							flow = 0;
							break;
						}
					}
					
				}
				else
					System.out.println("���޶W�X�d��I");
					
			}
			
		}
		

	}

}
