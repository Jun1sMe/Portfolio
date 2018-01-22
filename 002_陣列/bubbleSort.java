package lesson7_1;

public class bubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x[] = {25, 10, 39, 40, 33, 12};				// 宣告並建立X為整數陣列，存放六個整數
		System.out.println("排序前: ");
		for(int i = 0 ; i < x.length ; i++)
			System.out.print(x[i] + " ");
		System.out.print("\n");
		
		for(int pass = 1 ; pass < x.length ; pass++)	// 氣泡排序法
		{
			for(int i = 0 ; i < x.length - pass ; i++)	// 每次執行到前一個
			{
				if(x[i] > x[i + 1])						// 後面數大於前者，數值互換
				{
					int temp = x[i];
					x[i] = x[i + 1];
					x[i + 1] = temp;
				}
			}
		}
		
		System.out.println("排序後: ");
		for(int i = 0; i < x.length ; i++)
			System.out.print(x[i] + " ");
		System.out.print("\n");
					
	}

}
