/* 
 * 隨機從1~52的數字選取四個，直到選完，其中不能重複。
 * */
public class PokerFour
{

	public static void main(String[] args)
	{
		int n = 52, count = 0;
		int[] a = new int[n];
		a = initPoker(a, n);
		
		for(int i = 0; i < n; i+= 4) // 4 item a group
		{
			for(int j = 1 ; j <= 4 ; j++)
			{
				int tmp = getRandom(n - count); // get untaken number
				System.out.println((i + j) + ": " + a[tmp]);
				swap(a, tmp, n - ++count); // make the number behind				
			}			
		}
	}
	public static void swap(int[] a, int i, int j)
	{
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	public static int getRandom(int count)
	{
		return (int)(Math.random() * count);
	}
	public static int[] initPoker(int[] a, int n)
	{
		for(int i = 0 ; i < n ; i++)
			a[i] = i + 1;
		return a;
	}
	public static void print(int[] a, int n)
	{
		for(int i = 0 ; i < n ; i++)
			System.out.println(a[i]);		
	}

}
