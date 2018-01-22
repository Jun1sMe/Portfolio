
public class MazePoint
{
	public int row, col;	// 表示迷宮中其中一個座標位置
	public short dir;	// 表示目前位置
	public static offsets move[];
	public static final int directions = 8;

	public MazePoint()
	{
		move = new offsets[directions];
		for(int i = 0 ; i < move.length; i++)
			move[i] = new offsets();
		// N
		move[0].vert = -1;
		move[0].horiz = 0;
		// NE
		move[1].vert = -1;
		move[1].horiz = 1;
		// E
		move[2].vert = 0;
		move[2].horiz = 1;
		// SE
		move[3].vert = 1;
		move[3].horiz = 1;
		// S
		move[4].vert = 1;
		move[4].horiz = 0;
		// SW
		move[5].vert = 1;
		move[5].horiz = -1;
		// W
		move[6].vert = 0;
		move[6].horiz = -1;
		// NW
		move[7].vert = -1;
		move[7].horiz = -1;
	}
	class offsets
	{
		short vert;
		short horiz;
	}

}
