package lesson009_2;
import java.util.Scanner;
public class TestPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sca = new Scanner(System.in);
		Path path = new Path();
		int opt, count = 0;
		
		while(true)
		{
			System.out.print("Options: 1) Append, 2)Output, -1)Quit: ");
			opt = sca.nextInt();
			if(opt == -1)
			{
				System.out.println("Program quits.");
				break;
			}
			// 1) Append
			else if(opt == 1)
			{
				int x = sca.nextInt();
				int y = sca.nextInt();
				path.append(x, y);
				count++;
			}
			// 2)Output
			else if(opt == 2)
			{
				for(int i = 0; i < count; i++)
				{
					int temp[] = path.getPoint(i); 
					System.out.print("(" + temp[0] + ", " + temp[1] + ") ");	
				}
				// 路徑的總長
				System.out.println("\nCount of edges: " + path.getEdge());
				// 歐基里德距離
				System.out.printf("Euclidean length: %.2f\n", path.length());
				// simple path
				if(path.isSimple() == true)
					System.out.println("This is a simple path!");
				else
					System.out.println("This isn't a simple path!");			
				
				System.out.println();
			}
			else
				System.out.println("Error! Try again.");
		}
		
		
	}

}

//請在此宣告陣列與相關屬性/變數用來記錄路徑點座標
//屬性的封裝層級必須為private。
//注意：一個點包含兩個座標值（x與y）。
class Path {
	
	private int[][] series = new int[100][2];
	private int count = 0;
	//建構子
	public Path() {
	}
	//將新增的座標點(x, y)加入序列的最後
	public void append(int x, int y) {
		series[count][0] = x;
		series[count][1] = y;
		count++;
	}			
	//取得編號inx的點座標，將結果寫入陣列後回傳
	public int[] getPoint(int inx) {
		return series[inx];
	}
	//回傳此路徑的總長: 幾段
	public int getEdge(){
		if(count == 0)
			return 0;
		else
			return (count - 1);
	}
	
	//回傳true代表該路徑為simple path，否則回傳false
	public boolean isSimple(){
		for(int i = 0; i < count; i++)
		{
			for(int j = i + 1; j < count; j++)
			{
				if(series[i][0] == series[j][0] && series[i][1] == series[j][1])
				 return false;
			}
		}
		return true;
	}
	//計算路徑所有邊長的歐基里德距離（Euclidean length）
	public double length(){
		double totLegnth = 0;
		// 兩者才有距離
		for(int i = 0; i < count - 1; i++)
			totLegnth += Math.sqrt(
					Math.pow((series[i][0] - series[i + 1][0]), 2) + 
					Math.pow((series[i][1] - series[i + 1][1]), 2));
		return totLegnth;
	}	
	 
};


