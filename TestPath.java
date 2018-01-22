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
				// ���|���`��
				System.out.println("\nCount of edges: " + path.getEdge());
				// �ڰ򨽼w�Z��
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

//�Цb���ŧi�}�C�P�����ݩ�/�ܼƥΨӰO�����|�I�y��
//�ݩʪ��ʸ˼h�ť�����private�C
//�`�N�G�@���I�]�t��Ӯy�Эȡ]x�Py�^�C
class Path {
	
	private int[][] series = new int[100][2];
	private int count = 0;
	//�غc�l
	public Path() {
	}
	//�N�s�W���y���I(x, y)�[�J�ǦC���̫�
	public void append(int x, int y) {
		series[count][0] = x;
		series[count][1] = y;
		count++;
	}			
	//���o�s��inx���I�y�СA�N���G�g�J�}�C��^��
	public int[] getPoint(int inx) {
		return series[inx];
	}
	//�^�Ǧ����|���`��: �X�q
	public int getEdge(){
		if(count == 0)
			return 0;
		else
			return (count - 1);
	}
	
	//�^��true�N��Ӹ��|��simple path�A�_�h�^��false
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
	//�p����|�Ҧ�������ڰ򨽼w�Z���]Euclidean length�^
	public double length(){
		double totLegnth = 0;
		// ��̤~���Z��
		for(int i = 0; i < count - 1; i++)
			totLegnth += Math.sqrt(
					Math.pow((series[i][0] - series[i + 1][0]), 2) + 
					Math.pow((series[i][1] - series[i + 1][1]), 2));
		return totLegnth;
	}	
	 
};


