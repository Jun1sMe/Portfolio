/*
 * 空間複雜度：Ｏ(1)
 * 行號21~35, 36~47, 49, 51~52, 60~65, 68~93, 96~99 一個儲存空間 
 * 
 * 
 * 
 * 時間複雜度：Ｏ(n)
 * 行號21~35, 49, 60~65, 96~99 執行1次 
 * 行號36~47, 51~52 執行n次，迴圈陣列大小影響執行次數
 * 行號68~93 執行n次，迴圈滿足結束條件全部移動
 * 
 */
import java.util.Scanner;

public class TestRotate
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter number, distance, and value: ");
		int num = scanner.nextInt();
		// 1 <= n <= 10^5
		if (num < 1 || num > (int) Math.pow(10, 5))
		{
			printError();
			return;
		}
		int dis = scanner.nextInt();
		// 1 <= d <= n
		if (dis < 1 || dis > num)
		{
			printError();
			return;
		}
		int arr[] = new int[num];
		for (int i = 0; i < arr.length; i++)
		{
			int input = scanner.nextInt();
			// 1 <= arr[i] <= 10^6
			if (input < 1 || input > (int) Math.pow(10, 6))
			{
				i--;
				printError();
				continue;
			}
			arr[i] = input;
		}
		// method: leftRotation
		leftRotation(arr, dis);
		// print result
		for (int i : arr)
			System.out.print(i + "\t");
		// new line
		System.out.println();
	}

	public static void leftRotation(int[] arr, int d)
	{
		// 初始化
		int startIndex = 0, count = 0;
		// 紀錄現在索引及值
		int curIndex = startIndex;
		int curValue = arr[curIndex];
		// 紀錄新索引及值
		int nextIndex = 0, nextValue = 0;

		// while 使用時機為達成條件即停止
		while (count < arr.length && d < arr.length)
		{
			// 位移
			int move = curIndex - d;
			if (move < 0)
				move += arr.length;

			// 新索引並將值導入
			nextIndex = move;
			nextValue = arr[nextIndex];
			arr[nextIndex] = curValue;

			// 紀錄該索引位置及該原始值
			curIndex = nextIndex;
			curValue = nextValue;

			// 條件控制變數
			count++;

			// 回到起始位置，索引值增加一並重新初始
			if (curIndex == startIndex)
			{
				curIndex = ++startIndex;
				curValue = arr[curIndex];
			}
		}
	}
	// print error
	public static void printError()
	{
		System.out.println("Error! Try again.");
	}

}
