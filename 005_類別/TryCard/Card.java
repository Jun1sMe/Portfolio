// �@�i�P�����
class Card
{
	protected int suit;
	protected int point;
	
	// print
	public void print()
	{
		String[] sSuit = { "�ŤM", "���Y", "��" };
		System.out.print(sSuit[this.suit] + " " + (this.point + 1));
//		System.out.println(sSuit[this.boxCards[i].suit] + " " + (this.boxCards[i].point + 1));
	}
}

// �P��
class Cards
{
	// �ŧiCard�}�C�H�ά����ݩʡB��k�P�غc�l�A�Ϩ�o�H��{�U�C��k
	private Card boxCards[];
	public int count;

	public Cards()
	{
		boxCards = new Card[30];
		this.newCards();
		this.shuffle();
	}

	// ���ͤ@�Ʒs�P
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

	// �i��~�P
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

	// ��X�@�i�P
	public Card deal()
	{
		return this.boxCards[this.count++];
	}

}
