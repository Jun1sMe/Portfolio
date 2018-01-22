import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Test08
{
	// exception status: IO / File
	public static void main(String[] args) throws IOException, FileNotFoundException
	{
		// 提取的位元組
		byte byteData[] = new byte[1];
		FileInputStream fi = new FileInputStream("dog.jpeg");
		FileOutputStream fo = new FileOutputStream("dog1.jpeg");
		
		// 取得串流內可讀取或可略過的位元組數量
		// 可用來代表檔案大小
		int fileSize = fi.available();
		int num;
		
		// 利用迴圈逐一複製每個位元組
		// 取得 ->輸出
		while((num = fi.read(byteData)) != -1)
			fo.write(byteData);
		System.out.println("檔案大小 " + fileSize + "位元組複製完畢");
		// close file
		fi.close();
		fo.close();
	}

}
