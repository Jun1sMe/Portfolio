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
		// 位元組處理
		FileInputStream fi = new FileInputStream("text1.txt");
		FileOutputStream fo = new FileOutputStream("text5.txt");
		BufferedInputStream bufIn = new BufferedInputStream(fi);
		BufferedOutputStream bufOut = new BufferedOutputStream(fo);

		// 取得串流內可讀取或可略過的位元組數量
		// 可用來代表檔案大小
		int fileSize = fi.available();
		byte byteData[] = new byte[fileSize];
		bufIn.read(byteData, 0, fileSize);
		bufOut.write(byteData, 0, fileSize);

		String str1 = new String(byteData);
		// 將緩衝區的內容立刻寫入到檔案
		// 沒寫可能導致檔案內容不完整
		bufOut.flush();

		System.out.println("檔案複製完畢，內容如下:");
		System.out.println(str1);
		// close file
		fi.close();
		fo.close();
	}

}
