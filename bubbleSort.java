package lesson7_1;

public class bubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x[] = {25, 10, 39, 40, 33, 12};				// �ŧi�ëإ�X����ư}�C�A�s�񤻭Ӿ��
		System.out.println("�Ƨǫe: ");
		for(int i = 0 ; i < x.length ; i++)
			System.out.print(x[i] + " ");
		System.out.print("\n");
		
		for(int pass = 1 ; pass < x.length ; pass++)	// ��w�ƧǪk
		{
			for(int i = 0 ; i < x.length - pass ; i++)	// �C�������e�@��
			{
				if(x[i] > x[i + 1])						// �᭱�Ƥj��e�̡A�ƭȤ���
				{
					int temp = x[i];
					x[i] = x[i + 1];
					x[i + 1] = temp;
				}
			}
		}
		
		System.out.println("�Ƨǫ�: ");
		for(int i = 0; i < x.length ; i++)
			System.out.print(x[i] + " ");
		System.out.print("\n");
					
	}

}
