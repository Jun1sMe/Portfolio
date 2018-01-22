import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TestMaze
{

	public static void main(String[] args)
	{
		Stack myStack = new Stack();
		Scanner scanner = new Scanner(System.in);
		System.out.println("�п�J�ɮצW��: ");
		String inputName = scanner.next();
		
		// try: load and buffer the file
		try(FileReader fileReader = new FileReader(inputName);
				BufferedReader bufReader = new BufferedReader(fileReader);
				FileWriter fileWriter = new FileWriter("path.txt");	// output 'path.txt'
				BufferedWriter bufWriter = new BufferedWriter(fileWriter);)
		{
			// first line should be the count
			int count = Integer.parseInt(bufReader.readLine());
			Maze[] mArray = new Maze[count];
			// load data
			for(int k = 0 ; k < count ; k++)
			{
				// space and ',' ->"\\s+|,"
				// size, startPoint, endPoint
				String[] arrDate = bufReader.readLine().split("\\s+|,");
				mArray[k] = new Maze(Integer.parseInt(arrDate[0]), Integer.parseInt(arrDate[1]), 
						Integer.parseInt(arrDate[2]), Integer.parseInt(arrDate[3]), 
						Integer.parseInt(arrDate[4]), Integer.parseInt(arrDate[5]));
				// array in
				for(int i = 1; i <= mArray[k].getData(0).row ; i++)
				{
					String[] temp = bufReader.readLine().split(" ");
					for(int j = 1 ; j <= mArray[k].getData(0).row ; j++)
					{
						mArray[k].setMaze(i, j, Short.parseShort(temp[j - 1]));
					}					
				}
				// catch new line for the next catch
				if (k < count - 1)
				{
					bufReader.readLine();
					System.out.println();
				}				
			}	// end for: load data into array, count = 2
			bufReader.close();
			fileReader.close();
			
			for(int k = 0 ; k < count ; k++)
			{
				// set the original position
				int row = mArray[k].getData(Maze.startPoint).row,
						col = mArray[k].getData(Maze.startPoint).col;	
				do
				{
					int dir = -1;
					int nextRow, nextCol;
					mArray[k].setMark(row, col, (short) 1);
					while(++dir < MazePoint.directions)
					{
						nextRow = row + MazePoint.move[dir].vert;
						nextCol = col + MazePoint.move[dir].horiz;
						// ��g�c��ܬ��i�q�L�A�ά����W�������L ->���m�[�J���|
						if(mArray[k].getMaze(nextRow, nextCol) == 0 && 
								mArray[k].getMark(nextRow, nextCol) == 0)
						{
							myStack.push(row, col, dir);	// d���ĴX�Ӥ�V
							row = nextRow;
							col = nextCol;
							break;
						}			
					}
					if(row == mArray[k].getData(Maze.endPoint).row && 
							col == mArray[k].getData(Maze.endPoint).col)
					{
						// �Ӧ��i����|
						myStack.push(row, col, dir);	
//						System.out.print("Path found: ");
						String str = myStack.getItem();
						// write in and new line
						bufWriter.write(str);
						bufWriter.newLine();						
						break;
					}
					// �U���w��L�@��
					if(dir == MazePoint.directions)
					{
						// �����{�s���|�H�^��W�@�h���|
						int[] temp = myStack.pop();
						row = temp[0];
						col = temp[1];
						dir = temp[2];
						
						// �P�ɰ��|�L��ơA��ܵL�i��i���|
						if(myStack.isEmpty() == true)
						{
							String str = "No path!";
							System.out.println(str);
							// write in and new line
							bufWriter.write(str);
							bufWriter.newLine();	
						}
					}
				}while(!myStack.isEmpty());
			}
			// immediate write over
			bufWriter.flush();
			bufWriter.close();
			fileWriter.close();
			System.out.println("\nAll maze break!");
			return;

		}
		catch(FileNotFoundException e)
		{
			System.out.println(inputName + " not found!");
		}
		catch(IOException e)
		{
			
		}
	}
	// print error
	public static void printError()
	{
		System.out.println("Error! Try again.");
	}

}
