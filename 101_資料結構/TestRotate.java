/*
 * �Ŷ������סG��(1)
 * �渹21~35, 36~47, 49, 51~52, 60~65, 68~93, 96~99 �@���x�s�Ŷ� 
 * 
 * 
 * 
 * �ɶ������סG��(n)
 * �渹21~35, 49, 60~65, 96~99 ����1�� 
 * �渹36~47, 51~52 ����n���A�j��}�C�j�p�v�T���榸��
 * �渹68~93 ����n���A�j�麡�����������������
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
		// ��l��
		int startIndex = 0, count = 0;
		// �����{�b���ޤέ�
		int curIndex = startIndex;
		int curValue = arr[curIndex];
		// �����s���ޤέ�
		int nextIndex = 0, nextValue = 0;

		// while �ϥήɾ����F������Y����
		while (count < arr.length && d < arr.length)
		{
			// �첾
			int move = curIndex - d;
			if (move < 0)
				move += arr.length;

			// �s���ިñN�ȾɤJ
			nextIndex = move;
			nextValue = arr[nextIndex];
			arr[nextIndex] = curValue;

			// �����ӯ��ަ�m�θӭ�l��
			curIndex = nextIndex;
			curValue = nextValue;

			// ���󱱨��ܼ�
			count++;

			// �^��_�l��m�A���ޭȼW�[�@�í��s��l
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
