package lesson5_1;
import java.util.Scanner;
public class countingStar1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the size of the diamond: ");
		int getLength = scanner.nextInt();						// �Τ���w�٧Τ��j�p
		for(int i = 0; i < getLength; i++)						// i���C������Bj���檺����
		{
			for(int j = 0; j < getLength -1 - i; j++)			// ���' '�A�Ů�Ƭ��ؤo��1												
				System.out.print(" ");							// �̦C����G4�B3�B2...
			for(int j = 0; j < 2 * i + 1; j++)					// ���'*'�A�P�ƨ�i��������
				System.out.print("*");							// �̦C����G1���B3�B5...
			
			System.out.print("\n");								// �C�C���槹���A����			
		}
		for(int i = 0; i < getLength - 1; i++)					// �U�褧�ϤT���A�̪��C�ѥ��T������
		{
			for(int j = 0; j < i + 1; j++)						// ���' '�A�Ů�Ƭ��C�����W
				System.out.print(" ");							// �̦C����G1�B2�B3...
			for(int j = 0; j < 2 * getLength - 3 - 2 * i; j++)	// ���'*'�A�P�Ƴ̤j�C�ѥ��T����ܡA�G��ܤU�@���h�A�⭿�ؤo��3
				System.out.print("*");							// �̦C����G7�B5�B3...

			System.out.print("\n");
		}
	}

}
