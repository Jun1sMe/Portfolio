import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test10
{
	// exception status: IO / File
	public static void main(String[] args) throws IOException, FileNotFoundException
	{
		// �줸�ճB�z
		FileInputStream fi = new FileInputStream("text1.txt");
		FileOutputStream fo = new FileOutputStream("text5.txt");
		BufferedInputStream bufIn = new BufferedInputStream(fi);
		BufferedOutputStream bufOut = new BufferedOutputStream(fo);

		// ���o��y���iŪ���Υi���L���줸�ռƶq
		// �i�ΨӥN���ɮפj�p
		int fileSize = fi.available();
		byte byteData[] = new byte[fileSize];
		bufIn.read(byteData, 0, fileSize);
		bufOut.write(byteData, 0, fileSize);

		String str1 = new String(byteData);
		// �N�w�İϪ����e�ߨ�g�J���ɮ�
		// �S�g�i��ɭP�ɮפ��e������
		bufOut.flush();

		System.out.println("�ɮ׽ƻs�����A���e�p�U:");
		System.out.println(str1);
		// close file
		fi.close();
		fo.close();
	}

}
