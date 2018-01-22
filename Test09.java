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
		// ���o��y���iŪ���Υi���L���줸�ռƶq
		// �i�ΨӥN���ɮפj�p
		int fileSize = fi.available();
		// BMP���ɪ����Y��T: 54�Ӧ줸��
		// Ū��0~53���줸��
		int num = fi.read(data, 0, 54);
		int title[] = new int[6];
		// 2~5: �N���ɮפj�p
		for (int i = 2; i < 5; i++)
		{
			// �Y��� > 127(3FH)�A127~255 / 7F~FF
			// �h�|�Q�P�w���t�ȡA�G�ݭץ�������
			if (data[i] < 0)
				title[i] = (int) data[i] + 256;
			else
				title[i] = (int) data[i];
		}
		// low���Ӧ�ơBhigh���Q���
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

		// �ɮפj�p�ѳo�|�Ӧ�}�x�s
		System.out.println("�ɮפj�p�G " + filesize + "�Ӧ줸��");
		System.out.println("�ɮפj�p(available)�G " + fileSize + "�Ӧ줸��");
		// close file
		fi.close();
	}

}
