package lesson3_2;
import java.util.Scanner;

public class TeamAB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �ڬO��ɶv�AProjectB���ӥ]��
		// �o�]�Ӭ��L�x޳
		Scanner scanner = new Scanner(System.in);
		int num, den, min, ans = 0;						// �ŧi����ܼƤ��l�B�����B	�Ȧs�ơB�̤j���]��
		int i = 1;										// �ŧi�p�ơA�ê�l��1
		
		System.out.println("�п�J��ӥ���ơA���O�����l�B����: ");
		num = scanner.nextInt();
		den = scanner.nextInt();
		System.out.println(
				"Enter numerator: " + num + "\n" + 
				"Enter denominator: " + den);
		while(num <= 0 || den <= 0)						// ��J���ƭȨ�@��0�A�h���s��J
		{
			System.out.println("Error!");
			System.out.println("�п�J��ӥ���ơA���O�����l�B����: ");
			num = scanner.nextInt();
			den = scanner.nextInt();			
		}
		min = num;										// ����̤p�ȩw�� num
		if(num > den)									// �Y�_�A�h�̤p�Ȭ� den
			min = den;
		while(i <= min)									// ���榸�Ƭ��̤p��
		{
			if(den % i == 0)                            // i�C�����滼�W�A���ǥѻ��W��i���Hden and num
			{											// �Y�����A�h��i���̤p���]��
				if(num % i == 0)
					ans = i;			
			}
			i++;
		}
		System.out.println("Answer: " + ans);
	}

}
