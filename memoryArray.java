package lesson9_2;
import java.util.Scanner;
public class memoryArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int input = 0, count = 0;
		int freq[] = new int[100];
		
		while(input != -1)
		{
			System.out.print("Input (-1 to end): ");
			input = scanner.nextInt();
			if(input == -1)
				break;
			else if(input <= 0)
			{
				System.out.println("Error!");
			}
			else
			{
				freq[input]++;
				count++;
			}
		}
		for(int i = 0 ; i < freq.length ; i++)
		{
			if(freq[i] > 0)								// Print the value who exists 
			{
				System.out.print(i +"\t");
				for(int j = 0 ; j < freq[i] ; j++)		// Print the number of value 
					System.out.print("*");
				System.out.println();
			}
			
		}
		
	}

}
