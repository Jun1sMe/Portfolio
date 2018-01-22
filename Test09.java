import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

public class Test09
{
	// exception status: IO / File
	public static void main(String[] args) throws IOException, FileNotFoundException
	{
		byte data[] = new byte[54];
		int filesize, value1, value2, value3, value4, low, high;

		FileInputStream fi = new FileInputStream("dogg.bmp");
		// 取得串流內可讀取或可略過的位元組數量
		// 可用來代表檔案大小
		int fileSize = fi.available();
		// BMP圖檔的表頭資訊: 54個位元組
		// 讀取0~53的位元組
		int num = fi.read(data, 0, 54);
		int title[] = new int[6];
		// 2~5: 代表檔案大小
		for (int i = 2; i < 5; i++)
		{
			// 若資料 > 127(3FH)，127~255 / 7F~FF
			// 則會被判定為負值，故需修正為正值
			if (data[i] < 0)
				title[i] = (int) data[i] + 256;
			else
				title[i] = (int) data[i];
		}
		// low為個位數、high為十位數
		low = title[2] % 16;
		high = (title[2] - low) / 16;
		value1 = high * 16 + low;

		low = title[3] % 16;
		high = (title[3] - low) / 16;
		value2 = high * 16 * 16 * 16 + low * 16 * 16;

		low = title[4] % 16;
		high = (title[4] - low) / 16;
		value3 = high * 16 * 16 * 16 * 16 * 16 + low * 16 * 16 * 16 * 16;

		low = title[5] % 16;
		high = (title[5] - low) / 16;
		value4 = high * 16 * 16 * 16 * 16 * 16 * 16 * 16 + low * 16 * 16 * 16 * 16 * 16 * 16;

		filesize = value1 + value2 + value3 + value4;

		// 檔案大小由這四個位址儲存
		System.out.println("檔案大小： " + filesize + "個位元組");
		System.out.println("檔案大小(available)： " + fileSize + "個位元組");
		// close file
		fi.close();
	}

}
