package lesson11_1;
import java.util.Scanner;
public class binarySearching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int workArr[] = {33,41,52,54,63,74,79,86};
		int findNum, location;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Please enter the number you look for: ");
		findNum = scanner.nextInt();
		location = binarySearch(workArr, workArr.length, findNum);	// �}�C�B�}�C���סB�����
		
		if(location == -1)
			System.out.println("That's no \"" + findNum + "\" in the array!");
		else
			System.out.println("It's index at " + location);
	}
	
	public static int binarySearch(int[] x, int count, int k)
	{
		int left = 0, right, middle;
		right = count - 1;				// �̥k�����ޭȬ����פ֤@
		
		// left���j��right�����ޭ�
		while(left <= right)
		{
			middle = (left + right ) / 2;
			if(k == x[middle])
				return middle;
			// �b�k���A�����Ѥ������U��}�l
			else if(k > x[middle])
				left = middle + 1;
			// �b�����A�k���Ѥ������U��}�l
			else
				right = middle - 1;
		}
		return -1;
	}

}
