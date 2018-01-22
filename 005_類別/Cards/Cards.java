// base class
class Cards {
	//�ŧiint���A���}�C�H�ά����ݩʡA�]�A���P�I��
	protected int suit;
	protected int point;
	protected int poker[];
	// ���P��
	protected int count;
	// constructor
	public Cards() {		
		poker = new int[52];
		this.newCards();
	}
	// generate a new one
	void newCards() {
		// �@�ƵP��0~51�A�A���O�p����εP��
		for(int i = 0; i < 52; i++)
			poker[i] = i;
	}
	
	// function: identify -> suit and point
	public void identify(int i) {	
		// index: 0 = spade, 1 = heart, 2 = diamond, 3 = club
		this.suit = poker[i] / 13;
		// index: 0 ~ 12
		this.point = poker[i] % 13;
		
		String strSuit[] = {"Spade", "Heart", "Diamond", "Club"};
		String strPoint[] = {"A", "2", "3", "4", "5", "6", "7", "8", "9", 
							"10", "J", "Q", "K"};
		
		System.out.printf("%7s %2s", strSuit[this.suit], strPoint[this.point]);
		System.out.println();
	}
	// function for override
	public int getCard() {
		return 0;
	}
}
// derived class: Cards
class ShuffleCards extends Cards {
	// constructor: recall for shuffle
	public ShuffleCards() {
		this.setData();
	}
	// function: reset
	public void setData() {
		for(int i = 0; i < poker.length; i++)
		{
			int ranIndex = (int)(Math.random() * 52);
			int temp = poker[i];
			poker[i] = poker[ranIndex];
			poker[ranIndex] = temp;
		}
		// ���ƫh�k�s�p��
		count = 0;
	}
	
	// function: return the rest of number
	int remainCards() {
		return poker.length - count;
	}
	// override: if exists getCard. or generate
	@Override public int getCard() {
		return poker[count++];
	}
	// override: print the rest of cards
	@Override public String toString() {
		for(int i = count; i < poker.length; i++)
			identify(i);
		return " ";
	}
	
	
}
