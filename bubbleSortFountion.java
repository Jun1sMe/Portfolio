package lesson10_4;

public class bubbleSortFountion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// �ŧi�ëإ�X����ư}�C�A�s�񤻭Ӿ��
		int x[] = {25, 10, 39, 40, 33, 12};	
		System.out.println("�Ƨǫe: ");		
		show(x, x.length);
		
		bubbleSort(x, x.length);
		
		System.out.println("�Ƨǫ�: ");
		show(x, x.length);
	}
		
	// �ƨ禡 ��w�ƧǪk
	public static void bubbleSort(int[] source, int count)
	{
		// ��w�ƧǪk���榸�Ƭ� count - 2
		for(int i = 0 ; i < count - 2 ; i++)
		{
			// ����count - 1��
			for(int j = 0 ; j < count - 1 ; j++)
			{
				// �e�̤j���̫h���������W�Ƨ�
				if(source[j] > source[j + 1])
				{
					int temp = source[j];
					source[j] = source[j + 1];
					source[j + 1] = temp;
				}
			}
		}
	}
	// �ƨ禡show
	public static void show(int a[], int n)
	{
		for(int i = 0 ; i < n ; i++)
			System.out.print(a[i] + " ");
		System.out.print("\n");
	}

}
