package lesson5_3;
import java.util.Scanner;
public class countingStar3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the size of the diamond: ");
		int getLength = scanner.nextInt();						// �Τ���w�٧Τ��j�p
		for(int i = 0; i < getLength; i++)						// i���C������Bj���檺����
		{
			if(i == 0)											// ���C�A�Ȧ�'*'
				for(int j = 0; j < getLength * 2 - 1; j++)
					System.out.print("*");
			else
			{
				for(int j = 0; j < getLength - i; j++)			// ���'*'�A�P�Ƭ��ؤo��1
					System.out.print("*");						// �̦C����G4�B3�B2...
				for(int j= 0 ; j < 2 * i -1; j++)				// ���' '�A�P�ƨ�i����
					System.out.print(" ");
				for(int j = 0; j < getLength - i; j++)			// ���'*'�A�P�Ƭ��ؤo��1
					System.out.print("*");						// �̦C����G4�B3�B2...			
			}
			System.out.print("\n");								// �C�C���槹���A����		
		}
		
		for(int i = 0; i < getLength - 1; i++)					// �U�褧�ϤT���A�̪��C�ѥ��T������
		{														// �Q�Ψ��D�G����'*'�A�æb�e��W�['*'
			for(int j = 0; j < i + 1; j++)						// ���'*'�A�Ů�Ƭ��C�����W
				System.out.print("*");							// �̦C����G1�B2�B3...
			if(i != getLength - 2)								// �D���C�A'*'��2
			{
				System.out.print("*");
				for(int j = 0; j < 2 * getLength - 5 - 2 * i; j++)	// ���' '�A�Ů��
				{													// �̦C����G5�B3�B1...
					System.out.print(" ");
				}
				System.out.print("*");
			}
			else												// ���C'*'���ƦC�Ȧh1
				System.out.print("*");
			for(int j = 0; j < i + 1; j++)						// ���'*'�A�Ů�Ƭ��C�����W
				System.out.print("*");							// �̦C����G1�B2�B3...
			System.out.print("\n");
		}
	}

}
