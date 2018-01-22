import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Test11
{

	public static void main(String[] args) throws IOException
	{
		// ���ɮץ�J��y
		FileOutputStream fo = new FileOutputStream("file.tmp");
		// ���ɮץ�J�����y
		ObjectOutputStream oos = new ObjectOutputStream(fo);

		oos.writeObject(new CMyStudent("S9903501", "���j��", 89, 84, 75));
		oos.writeObject(new CMyStudent("S9903502", "���p��", 77, 69, 87));
		oos.writeObject(new CMyStudent("S9903503", "�J�p�s", 65, 68, 77));

		// close file
		oos.close();
		fo.close();
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
		// empty sentence
	}
}
