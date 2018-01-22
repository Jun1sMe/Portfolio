
class TryCard
{
	protected int suit;
	protected int point;

	private int boxCards[];
	public int count;
	

	public TryCard()
	{
		boxCards = new int[30];
		this.newCards();
		this.shuffle();
	}

	// 產生一副新牌
	void newCards()
	{
		for (int i = 0; i < this.boxCards.length; i++)
		{
			boxCards[i] = i;
		}
	}

	// 進行洗牌
	public void shuffle()
	{
		for (int i = 0; i < this.boxCards.length; i++)
		{
			int tempIndex = (int) (Math.random() * this.boxCards.length);
			int temp = this.boxCards[i];
			this.boxCards[i] = this.boxCards[tempIndex];
			this.boxCards[tempIndex] = temp;
		}
	}

	// 抽出一張牌
	public int deal()
	{
		return this.boxCards[this.count++];
	}

	// print
	public void print(int i)
	{
		String[] sSuit = { "剪刀", "石頭", "布" };
		System.out.print(sSuit[i / 10] + " " + (i % 10 + 1));

	}
}
