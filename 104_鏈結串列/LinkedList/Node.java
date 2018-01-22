
public class Node
{
	int[] score;
	Node link;

	public Node(int num, int eng, int math)
	{
		score = new int[3];
		score[0] = num;
		score[1] = eng;
		score[2] = math;
		this.link = null;
	}
	public void setLink(Node link)
	{
		this.link = link;
	}
	public Node getLink()
	{
		return this.link;
	}
	public int[] getData()
	{
		return score;
	}
}
