package lesson008_7;
import java.util.Scanner;
public class RecursionHanoi {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true)
		{
			Scanner scan = new Scanner(System.in);
			// �_�l�W�B�����W�B�����W
			int colStart = 1, colMid = 2, colEnd = 3;		
			System.out.print("Please select the numble of item: ");
			int no = scan.nextInt();
			if(no < 1)
				System.out.println("Error! Try again.");
			else
			{
				towersOfHanoi(no, colStart, colEnd, colMid);
				System.out.println();
			}
		}
	}
	
	// function: Recursion
	// �q�W�lfrom | ���ʽs��no���L�l | ��W�lto�h  |�A�P�ɥH�W�ltemp�@������
	public static void towersOfHanoi(int no, int from, int to, int temp) {
		// base case
		if(no <= 1)
			printMove(no, from, to);
		// recursive step
		// �_�� ->����to | ���� ->����temp | no:1, 121, 1213121 | move: 121
		else
		{
			towersOfHanoi(no - 1, from, temp, to);
			printMove(no, from, to);
			towersOfHanoi(no - 1, temp, to, from);
		}
	}	
	// function: printMove
	public static void printMove(int no, int from, int to) {
		System.out.print("Move �L�l�s�� " + no +" from �ӷ��W�l�s�� " + 
				from +" to �ӷ��W�l�s�� " + to + "\n");
	}
	
//		// ���� ->����temp
//		if(count == 2)
//		{
//			printMove(1, from, temp);
//			printMove(2, from, to);
//			printMove(1, temp, to);
//		}
//		// �_�� ->����to
//		if(count == 3)
//		{
//			printMove(1, from, to);
//			printMove(2, from, temp);
//			printMove(1, to, temp);
//			printMove(3, from, to);
//			printMove(1, temp, from);
//			printMove(2, temp, to);
//			printMove(1, from, to);
//		}
//		// ���� ->����temp
//		if(count == 4)
//		{
//			printMove(1, from, temp);
//			printMove(2, from, to);
//			printMove(1, temp, to);
//			printMove(3, from, temp);
//			printMove(1, to, from);
//			printMove(2, to, temp);
//			printMove(1, from, temp);
//			printMove(4, from, to);
//			printMove(1, temp, to);
//			printMove(2, temp, from);
//			printMove(1, to, from);
//			printMove(3, temp, to);
//			printMove(1, from, temp);
//			printMove(2, from, to);
//			printMove(1, temp, to);
//		}
		

}
