import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Test08
{
	// exception status: IO / File
	public static void main(String[] args) throws IOException, FileNotFoundException
	{
		// �������줸��
		byte byteData[] = new byte[1];
		FileInputStream fi = new FileInputStream("dog.jpeg");
		FileOutputStream fo = new FileOutputStream("dog1.jpeg");
		
		// ���o��y���iŪ���Υi���L���줸�ռƶq
		// �i�ΨӥN���ɮפj�p
		int fileSize = fi.available();
		int num;
		
		// �Q�ΰj��v�@�ƻs�C�Ӧ줸��
		// ���o ->��X
		while((num = fi.read(byteData)) != -1)
			fo.write(byteData);
		System.out.println("�ɮפj�p " + fileSize + "�줸�սƻs����");
		// close file
		fi.close();
		fo.close();
	}

}
