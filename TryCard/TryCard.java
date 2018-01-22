
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

	// ���ͤ@�Ʒs�P
	void newCards()
	{
		for (int i = 0; i < this.boxCards.length; i++)
		{
			boxCards[i] = i;
		}
	}

	// �i��~�P
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

	// ��X�@�i�P
	public int deal()
	{
		return this.boxCards[this.count++];
	}

	// print
	public void print(int i)
	{
		String[] sSuit = { "�ŤM", "���Y", "��" };
		System.out.print(sSuit[i / 10] + " " + (i % 10 + 1));

	}
}
