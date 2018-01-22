import java.util.Arrays;

public class Maze
{
	private MazePoint[] data;	// 迷宮的尺寸
	private int[][] maze;	// 包含一個二維陣列紀錄迷宮的內容
	private int[][] mark;	// 標示路徑的陣列
	// 0: size, 1: startPoint, 2: endPoint ->數據數: previous 3 item
	public static final int arrSize = 0;
	public static final int startPoint = 1;
	public static final int endPoint = 2;
	private static final int dataSpace = 3;

	//相關的方法有初始化迷宮內容、標印出迷宮內容等等
	public Maze(int sizeX, int sizeY, int startPointX, int startPointY, int endPointX, int endPointY)
	{
		// matrix size and initialization
		maze = new int[(sizeX + 2) * (sizeY + 2)][(sizeX + 2) * (sizeY + 2)];
		mark = new int[(sizeX + 2) * (sizeY + 2)][(sizeX + 2) * (sizeY + 2)];
		for(int i = 0 ; i < sizeY + 2 ; i++)
		{
			for(int j = 0 ; j < sizeX + 2 ; j++)
			{
				// up and down bound
				if(i == 0 || i == sizeX + 1)
				{
					this.setMark(i, j, (short)1);
					this.setMaze(i, j, (short)1);
				}
				// left and right bound
				else
				{
					if(j == 0 || j == sizeX + 1)
					{
						this.setMark(i, j, (short)1);
						this.setMaze(i, j, (short)1);
					}
					else
						this.setMark(i, j, (short)0);
				}
			}
		}
		// initialize data: size, start, end
		data = new MazePoint[dataSpace];
		for(int i = 0 ; i < dataSpace; i++)
			data[i] = new MazePoint();
		data[arrSize].row = sizeX;
		data[arrSize].col = sizeY;
		data[startPoint].row = startPointX + 1;
		data[startPoint].col = startPointY + 1;
		data[endPoint].row = endPointX + 1;
		data[endPoint].col = endPointY + 1;	
	}
	public MazePoint getData(int index)
	{
		return this.data[index];
	}
	public int getMaze(int x, int y)
	{
		return this.maze[x][y];
	}
	public int getMark(int x, int y)
	{
		return this.mark[x][y];
	}
	public void setMaze(int x, int y, short dir)
	{
//		if(count >= maze.length)
//			maze = Arrays.copyOf(maze, maze.length * 2);
		this.maze[x][y] = dir;
	}
	public void setMark(int x, int y, short dir)
	{
//		if(count >= mark.length)
//			mark = Arrays.copyOf(mark, mark.length * 2);
		this.mark[x][y] = dir;
	}
	
	

}
