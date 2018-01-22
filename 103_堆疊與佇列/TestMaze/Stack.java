
public class Stack
{
	//請實作包含一個Stack用來紀錄走過的路徑

	//並將紀錄路徑的相關方法寫於此類別中
    private int capacity, capacity2nd;
    private int top;	// 堆疊中頂端的元素，預設無值
    int[][] items;
	
	//堆疊中的每個項目應該都是一個MazePoint的物件
	private MazePoint[] route;

	public Stack()
	{
		capacity = 10;
		capacity2nd = 3;
		items = new int[capacity][capacity2nd];	// (row, col, dir)
		top = -1;
		
	}
	public boolean isEmpty()
	{
		if(top < 0)
			return true;
		return false;
	}
	public boolean isFull()
	{
		if(top >= items.length - 1)
			return true;
		return false;
	}
	// delete in top
	public int[] pop()
	{
		if(this.isEmpty())
			return null;
		return this.items[top--];
	}
	// add in top
	public void push(int row, int col, int dir)
	{
		int[] temp = {row, col, dir};
		if(this.isFull())
			resize(items);
		this.items[++top] = temp;
	}
	public void resize(int[][] x)
	{
		int[][] temp = new int[x.length * 2][3];
		for(int i = 0 ; i < x.length ; i++)
			temp[i] = x[i];
		x = temp;
		temp = null;
	}
	public String getItem()
	{
		String str = "";
		for(int i = 0 ; i <= top ; i++)
		{
			int x = this.items[i][0] - 1,
					y = this.items[i][1] - 1;			
			if(i == 0)
			{
//				System.out.printf("(%1d,%1d) ", x, y);
				str += "(" + x + "," + y + ") ";
			}
			else
			{
//				System.out.printf("- > (%1d,%1d) ", x, y);
				str += "- > (" + x + "," + y + ") ";
			}
		}
		str += "\n";
		System.out.println(str);
		return str;
	}
}
