import java.util.Scanner;
public class TestCards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// generate new cards and shuffle them
		ShuffleCards myCard = new ShuffleCards();
			
		while(true)
		{
			Scanner scanner = new Scanner(System.in);
			System.out.print("Options: 1)remain cards , 2)get card, 3)發四副牌, -1)Quit: ");
			int opt = scanner.nextInt();
			// remain cards
			if(opt == 1)
			{
				System.out.println("Remain cards: " + myCard.remainCards());
			}
			// get card: 1張
			else if(opt == 2)
			{
				if(myCard.remainCards() < 1)
					myCard.setData();
				int get = myCard.getCard();
				System.out.print("Get a card: ");
				myCard.identify(get);
			}
			// 發四副牌: 52張
			// 請確認牌數是否足夠，否則請產生新牌
			else if(opt == 3)
			{
				if(myCard.remainCards() < 52)
					myCard.setData();
				// 取得整盒牌
				System.out.println("My cards: ");
				for(int i = 0; i < 52; i++)
					myCard.identify(myCard.getCard());
			}
			// Quit
			else if(opt == -1)
			{
				System.out.println("Thanks for using system.");
				break;
			}
			else
				System.out.println("Error! Try again.");
		}
	}

}
