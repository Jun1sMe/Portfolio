// 一張牌的資料
class Card
{
	protected int suit;
	protected int point;
	
	// print
	public void print()
	{
		String[] sSuit = { "剪刀", "石頭", "布" };
		System.out.print(sSuit[this.suit] + " " + (this.point + 1));
//		System.out.println(sSuit[this.boxCards[i].suit] + " " + (this.boxCards[i].point + 1));
	}
}

// 牌組
class Cards
{
	// 宣告Card陣列以及相關屬性、方法與建構子，使其得以實現下列方法
	private Card boxCards[];
	public int count;

	public Cards()
	{
		boxCards = new Card[30];
		this.newCards();
		this.shuffle();
	}

	// 產生一副新牌
	void newCards()
	{
		for (int i = 0; i < this.boxCards.length; i++)
		{			
			this.boxCards[i] = new Card();
			// suit 0, 1, 2
			this.boxCards[i].suit = i / 10;
			// pint 0 ~ 9
			this.boxCards[i].point = i % 10;
		}
	}

	// 進行洗牌
	public void shuffle()
	{
		for (int i = 0; i < this.boxCards.length; i++)
		{
			int tempIndex = (int) (Math.random() * this.boxCards.length);
			Card temp = this.boxCards[i];
			this.boxCards[i] = this.boxCards[tempIndex];
			this.boxCards[tempIndex] = temp;
		}
	}

	// 抽出一張牌
	public Card deal()
	{
		return this.boxCards[this.count++];
	}

}
