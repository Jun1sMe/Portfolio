package lesson2_7;
import java.util.Scanner;

public class countTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("叫块ヴ種计");
		int getSec = scanner.nextInt();         // getSec块ぇ计
		int day = getSec / (24 * 60 * 60);
		System.out.println(day + " day");	
		int hour1 = getSec % (24 * 60 * 60);    // hour计埃ぱ计ぇ緇计盢緇计埃计
		int hour2 = hour1 / (60 * 60);
		System.out.println(hour2 + " hours");	
		int min1 = getSec % (60 * 60);          // min计埃计ぇ緇计盢緇计埃计
		int min2 = min1 / 60;
		System.out.println(min2 + " minutes");
		int sec = getSec % 60;
		System.out.println(sec + " seconds");

	}

}
