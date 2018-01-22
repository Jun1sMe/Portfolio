package lesson13_10;
import java.util.Scanner;
public class stringPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		while(true)
		{
			// 块﹃じ皚
			String str = input.next();
			char[] ch = str.toCharArray();
			
			// 虫ぃ穦禬筁20
			if(ch.length > 20)
			{
				System.out.print("Your words is too long! Shorter!");
				continue;
			}
			
			// 璸衡单Ω计
			int count = 0;
			
			// Ω计单ダ
			for(int i = 0 ; i < ch.length / 2 ; i++)
				if(ch[i] == ch[ch.length - 1 - i])
					count++;
			
			if(count == ch.length / 2)
				System.out.print("Yes");
			else
				System.out.print("No");
		}

	}

}
