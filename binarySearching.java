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
		location = binarySearch(workArr, workArr.length, findNum);	// 陣列、陣列長度、欲找數
		
		if(location == -1)
			System.out.println("That's no \"" + findNum + "\" in the array!");
		else
			System.out.println("It's index at " + location);
	}
	
	public static int binarySearch(int[] x, int count, int k)
	{
		int left = 0, right, middle;
		right = count - 1;				// 最右側索引值為長度少一
		
		// left必大於right之索引值
		while(left <= right)
		{
			middle = (left + right ) / 2;
			if(k == x[middle])
				return middle;
			// 在右側，左側由中間之下位開始
			else if(k > x[middle])
				left = middle + 1;
			// 在左側，右側由中間之下位開始
			else
				right = middle - 1;
		}
		return -1;
	}

}
