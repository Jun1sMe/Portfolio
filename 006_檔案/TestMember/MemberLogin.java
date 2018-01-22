import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class MemberLogin
{
	static Scanner scanner = new Scanner(System.in);
	static MemberList myList = new MemberList();

	// exception status: IO / File
	public static void main(String[] args) throws IOException, FileNotFoundException
	{
		// initialize step
		int opt = 0;

		System.out.print("���J����ɡG");
		String loadFile = scanner.next();
		// read file and buffered in
		FileReader fileRead = new FileReader(loadFile);
		BufferedReader bufReadIn = new BufferedReader(fileRead);
		// assign line by line to tempString
		// load over and return null
		String firstLine, tempString, loadString = "";
		// load the title line
		// title line into titleArray
		firstLine = bufReadIn.readLine();
		String firstArr[] = firstLine.split("\\s+");

		// load except the first
		while ((tempString = bufReadIn.readLine()) != null)
			loadString += tempString + " ";
		// file date into loadArray
		String loadArr[] = loadString.split("\\s+");

		for (int i = 0; i < loadArr.length; i += 5)
		{
			// parse: string to integer
			// split 3 part to Birthday
			String tempBD[] = loadArr[i + 3].split("/");
			MemberBD bd = new MemberBD(Integer.parseInt(tempBD[0]), Integer.parseInt(tempBD[1]),
					Integer.parseInt(tempBD[2]));

			myList.add(Integer.parseInt(loadArr[i]), (loadArr[i + 1]), (loadArr[i + 2]), bd, (loadArr[i + 4]));
		}

		// close
		fileRead.close();

		while (true)
		{
			if (opt == 0)
			{
				System.out.print("�ﶵ�G1)�˵�����, 2)�s�W, 3)�R��, 4)�ק�, 5)�z��s��, -1) ����? ");
				opt = scanner.nextInt();
			}
			// �˵�����
			if (opt == 1)
			{
				// print the title
				System.out.printf("%2s\t%3s\t%6s\t%6s\t%14s\n", firstArr[0], firstArr[1], firstArr[2], firstArr[3],
						firstArr[4]);
				System.out.println("===========================================================");
				// print all data
				myList.print();
				System.out.println();

				// �^��D���
				opt = 0;
			}
			// �s�W
			else if (opt == 2)
			{
				// �s��
				int no = myList.judgeNo(2);
				while (no == -1 || no == -2)
					no = myList.judgeNo(2);
				int exist = myList.search(no);
				if (exist != -1)
					System.out.println("�s���w�s�b�I\n");
				// ��L��T
				else
					insert(2, no);

				// �^��D���
				opt = 0;
			}
			// �R��
			else if (opt == 3)
			{
				System.out.print("��J�s���G");
				int no = scanner.nextInt();

				// �^���˵�����
				if (myList.delete(no) == true)
					opt = 1;
				// �^��D���
				else
					opt = 0;
			}
			// �ק�
			else if (opt == 4)
			{
				// �s��
				int no = myList.judgeNo(4);
				while (no == -1 || no == -2)
					no = myList.judgeNo(4);
				int index = myList.search(no);
				if (index == -1)
				{
					System.out.println("�s�����s�b�I\n");
					// �^��D���
					opt = 0;
				}
				// ��L��T
				else
				{
					insert(4, no);
					// �^���˵�����
					opt = 1;
				}
			}
			// �z��s��
			else if (opt == 5)
			{
				int startNo = 0, endNo = 0, flow = 0, startIndex = 0, endIndex = 0;
				while (true)
				{
					if (flow == 0)
					{
						System.out.print("��J�_�l�s���G");
						startNo = scanner.nextInt();
						// start no is 1~100
						if (startNo >= 1 && startNo <= 100)
						{
							while ((startIndex = myList.search(startNo)) == -1)
							{
								startNo--;
								if (startIndex == 0)
									break;
							}
							flow++;
						} 
						else
							System.out.println("���~�I�Э��s��J�I");
					}

					if (flow == 1)
					{
						System.out.print("��J�����s���G");
						endNo = scanner.nextInt();
						// end no is 1~100
						if (startNo > endNo || endNo > 100)
						{
							System.out.println("���~�I�Э��s��J�I");
							flow--;
						} 
						else
						{
							while ((endIndex = myList.search(endNo)) == -1)
							{
								if (startNo < endNo)
									endNo--;
								// equal
								else
									break;
							}
							flow++;
						}
					}

					if (flow == 2)
					{
						System.out.print("��X����ɦW�G");
						String nameFile = scanner.next();
						// write file and buffered
						FileWriter fileWrite = new FileWriter(nameFile);
						BufferedWriter bufWriteOut = new BufferedWriter(fileWrite, 20);

						// title line
						bufWriteOut.write(firstLine);
						// new line
						bufWriteOut.newLine();

						// Output data
						String[] opLine = new String[myList.getCount()];

						for (int i = startIndex; i <= endIndex; i++)
						{
							MemberData[] each = myList.getMemberData();
							int no = each[i].getNo();
							String name = each[i].getName();
							String id = each[i].getId();
							MemberBD bd = each[i].getBirthday();
							int y = bd.getYear();
							int m = bd.getMonth();
							int d = bd.getDay();
							String phone = each[i].getPhone();

							opLine[i] = no + "\t" + name + "\t" + id + "\t" + y + "/" + m + "/" + d + "\t" + phone;
							bufWriteOut.write(opLine[i]);
							// new line
							bufWriteOut.newLine();
						}

						// �N�w�İϪ����e�ߨ�g�J���ɮ�
						// �S�g�i��ɭP�ɮפ��e������
						bufWriteOut.flush();
						// close file
						fileWrite.close();

						System.out.println("�ɮ׼g�J���\�I\n");

						// �^��D���
						opt = 0;
						break;
					}
				}

			}
			// ����
			else if (opt == -1)
			{
				 System.out.println("�g�J" + loadFile + "���\�I\n�{�������C");
				break;
			}
			// exception
			else
			{
				System.out.println("���~�I�Э��s��J�I");
				opt = 0;
			}
		}

	}

	// method: add or modify
	public static void insert(int opt, int no)
	{
		// �m�W
		System.out.print("�m�W�G");
		String n = scanner.next();
		// ������
		String id = myList.judgeId();
		while (id.equals(""))
			id = myList.judgeId();
		// �ͤ�
		MemberBD bd;
		while (true)
		{
			System.out.print("�ͤ�]�~/��/��^�G");
			int y = scanner.nextInt();
			int m = scanner.nextInt();
			int d = scanner.nextInt();
			if (MemberBD.isValid(y, m, d))
			{
				bd = new MemberBD(y, m, d);
				break;
			}
			System.out.println("���~�I�Э��s��J�I");
		}
		// �q��
		String p = myList.judgePhone();
		while (p.equals(""))
			p = myList.judgePhone();

		if (opt == 2)
		{
			myList.add(no, n, id, bd, p);
			System.out.println("�|���s�W���\!\n");
		} 
		else if (opt == 4)
		{
			myList.modify(no, n, id, bd, p);
			System.out.println("�|���ק令�\!\n");
		}

	}

}
