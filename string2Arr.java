package lesson13_6;
import java.util.Scanner;
public class string2Arr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String[] name = new String[3];
		
		for(int i = 0 ; i < 3 ; i++)
		{
			System.out.print("請輸入第" + (i + 1) + "個姓名: ");
			name[i] = scanner.next();
		}
		// 方法一
//		char[] charName0 = name[0].toCharArray();
//		for(int i = 0 ; i < charName0.length ; i++)
//			System.out.print(charName0[i]);
//		System.out.println();
//		char[] charName1 = name[1].toCharArray();
//		for(int i = 0 ; i < charName1.length ; i++)
//			System.out.print(charName1[i]);
//		System.out.println();
//		char[] charName2 = name[2].toCharArray();
//		for(int i = 0 ; i < charName2.length ; i++)
//			System.out.print(charName2[i]);
//		System.out.println();
		
		// 方法二
		char[][] charName = new char[10][10];
		for(int i = 0 ; i < name.length; i++)
			charName[i] = name[i].toCharArray();
		for(int i = 0 ; i < name.length; i++)
			System.out.println(charName[i]);
		
		
	}

}
