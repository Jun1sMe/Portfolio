import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Test12
{

	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		// 把檔案匯入串流
		FileInputStream fi = new FileInputStream("file.tmp");
		// 把檔案匯入物件串流
		ObjectInputStream ois = new ObjectInputStream(fi);

		CMyStudent obj1;
		obj1 = (CMyStudent)ois.readObject();
		obj1.printSum();
		obj1 = (CMyStudent)ois.readObject();
		obj1.printSum();
		obj1 = (CMyStudent)ois.readObject();
		obj1.printSum();

		// close file
		ois.close();
		fi.close();
	}

}

class CMyStudent implements Serializable
{
	// properties
	private String id;
	private String name;
	private int scoreComputer;
	private int scoreMath;
	private int scoreEnglish;
	private int scoreSum;

	// constructor
	public CMyStudent(String str1, String str2, int i, int j, int k)
	{
		id = str1;
		name = str2;
		scoreComputer = i;
		scoreMath = j;
		scoreEnglish = k;
		computeSum();
	}

	// method: sum
	public void computeSum()
	{
		scoreSum = scoreComputer + scoreMath + scoreEnglish;
	}

	// method: print
	public void printSum()
	{
		System.out.println(id + " " + name + " 總分：" + scoreSum);
	}
}
