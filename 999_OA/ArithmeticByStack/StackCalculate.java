/*
 * Arithmetic by Stack and Singleton
 */

import java.util.Scanner;
public class StackCalculate {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);		
		System.out.print("Calculator: " );
		System.out.println("Answer: " + Calculate.count(scan.next()));

	}

}
