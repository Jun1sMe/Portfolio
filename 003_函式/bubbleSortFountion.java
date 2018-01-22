package lesson10_4;

public class bubbleSortFountion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 宣告並建立X為整數陣列，存放六個整數
		int x[] = {25, 10, 39, 40, 33, 12};	
		System.out.println("排序前: ");		
		show(x, x.length);
		
		bubbleSort(x, x.length);
		
		System.out.println("排序後: ");
		show(x, x.length);
	}
		
	// 副函式 氣泡排序法
	public static void bubbleSort(int[] source, int count)
	{
		// 氣泡排序法執行次數為 count - 2
		for(int i = 0 ; i < count - 2 ; i++)
		{
			// 執行count - 1次
			for(int j = 0 ; j < count - 1 ; j++)
			{
				// 前者大於後者則互換→漸增排序
				if(source[j] > source[j + 1])
				{
					int temp = source[j];
					source[j] = source[j + 1];
					source[j + 1] = temp;
				}
			}
		}
	}
	// 副函式show
	public static void show(int a[], int n)
	{
		for(int i = 0 ; i < n ; i++)
			System.out.print(a[i] + " ");
		System.out.print("\n");
	}

}
