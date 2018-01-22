import java.util.Scanner;
public class TestCards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// generate new cards and shuffle them
		ShuffleCards myCard = new ShuffleCards();
			
		while(true)
		{
			Scanner scanner = new Scanner(System.in);
			System.out.print("Options: 1)remain cards , 2)get card, 3)�o�|�ƵP, -1)Quit: ");
			int opt = scanner.nextInt();
			// remain cards
			if(opt == 1)
			{
				System.out.println("Remain cards: " + myCard.remainCards());
			}
			// get card: 1�i
			else if(opt == 2)
			{
				if(myCard.remainCards() < 1)
					myCard.setData();
				int get = myCard.getCard();
				System.out.print("Get a card: ");
				myCard.identify(get);
			}
			// �o�|�ƵP: 52�i
			// �нT�{�P�ƬO�_�����A�_�h�в��ͷs�P
			else if(opt == 3)
			{
				if(myCard.remainCards() < 52)
					myCard.setData();
				// ���o�㲰�P
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
