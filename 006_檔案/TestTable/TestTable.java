import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TestTable
{
	public static String[] titleArr;
	public static Scanner scanner = new Scanner(System.in);

	// exception status: IO / File
	public static void main(String[] args) throws IOException, FileNotFoundException
	{
		System.out.print("���J����ɡG");
		String loadfile = scanner.next();
		// read file and buffered in
		FileReader fileRead = new FileReader(loadfile);
		BufferedReader bufInRead = new BufferedReader(fileRead);

		String titleLine, allLine;
		String[] allArr = new String[100];
		int count = 0;
		// load title line and into array
		titleLine = bufInRead.readLine();
		titleArr = titleLine.split(",");

		// load other line and into array
		CData[] input = new CData[100];
		while ((allLine = bufInRead.readLine()) != null)
		{
			if (count >= allArr.length)
				allArr = Arrays.copyOf(allArr, allArr.length * 2);
			allArr[count] = allLine;
			String[] temp = allArr[count].split(",");

			// 8 ->14 Mon. to Sun.
			if (count >= input.length)
				input = Arrays.copyOf(input, input.length * 2);

			input[count++] = new CRoutine(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7],
					temp[8], temp[9], temp[10], temp[11], temp[12], temp[13], temp[14]);
		}
		// close file
		fileRead.close();

		while (true)
		{
			printMark();
			System.out.print("�п�ܥH�U�ާ@�G\n1) �˵��Ҧ����u��T\n2) ��J�s���u���\n3) �R�����w���u\n4) ��ܫ��w���u\n5) ��X�s�����\n>>>");
			int opt = scanner.nextInt();
			printMark();

			// 1: �˵��Ҧ����u��T
			if (opt == 1)
			{
				// print the title
				printTitleData();
				System.out.println();

				for (int i = 0; i < count; i++)
				{
					if (i < count - 1)
					{
						// the route
						if (input[i].getRoute().equals(input[i + 1].getRoute()))
							continue;
					}
					input[i].print();
					System.out.println();
				}
				// new line
				System.out.println();
			}
			// 2: ��J�s���u���
			else if (opt == 2)
			{
				// new route initialize '1'
				String bus, no, branch, round, name = "", stop = "", departure, order = "1";
				String[] week = new String[7];
				// match previous 4 item for helping the next two item
				int flow = 0;
				// bus: 4 Mandarin including '�ȹB'
				while (true)
				{
					System.out.print("�ȹB�~��: ");
					bus = scanner.next();
					if (bus.length() != 4 || !bus.substring(2).equals("�ȹB"))
						printError();
					else
						break;
				}
				// route no: 4 letter
				no = typeNo();
				// branch: 0 or capital
				branch = typeBranch();
				// round: single Mandarin
				while (true)
				{
					System.out.print("���� 1)�� 2)��: ");
					round = scanner.next();
					try
					{
						int testRd = Integer.parseInt(round);
						if (testRd == 1)
						{
							round = "��";
							break;
						} else if (testRd == 2)
						{
							round = "��";
							break;
						}
					} catch (Exception e)
					{
					}
					printError();
				}

				for (int i = 0; i < count; i++)
				{
					if (input[i].getHalfRoute().equals(bus + no + branch + round))
					{
						name = input[i].getName();
						stop = input[i].getStop();
						flow++;
						break;
					}
				}
				// don't match previous 4 item
				if (flow == 0)
				{
					// route name: 5 letter
					while (true)
					{
						System.out.print("���u�W��: ");
						name = scanner.next();
						if (name.length() < 5)
							printError();
						else
							break;
					}
					// stop: 2 letter
					while (true)
					{
						System.out.print("���W: ");
						stop = scanner.next();
						if (stop.length() < 2)
							printError();
						else
							break;
					}
				}
				// departure
				while (true)
				{
					System.out.print("�o���ɶ� (�� ��): ");
					String h = scanner.next();
					String m = scanner.next();
					try
					{
						int testH = Integer.parseInt(h);
						int testM = Integer.parseInt(m);
						if (CTime.isValid(testH, testM) == true)
						{
							CTime time = new CTime(testH, testM);
							departure = time.getTime();
							break;
						}
					} catch (Exception e)
					{
					}
					printError();
				}
				// determine the order by departure
				// assign into the order
				CData[] newObj = new CRoutine[count + 1];
				int curCount = 0;
				
				for (int i = 0, k = 0, flow2 = 0; i < count; i++)
				{
					if (input[i].getRoute()
							.equals(bus + "," + no + "," + branch + "," + round + "," + name + "," + stop) == false)
					{
						newObj[i + k] = input[i];
					}
					// route exists
					else
					{
						CRoutine temp = (CRoutine) input[i];
						String curStr = temp.getDeparture();
						int curInt = Integer.parseInt(curStr);
						int addInt = Integer.parseInt(departure);
						if (addInt >= curInt)
						{
							newObj[i + k] = input[i];
							continue;
						}

						String curOrder = temp.getOrder();
						if (flow2 == 0)
						{
							// while addInt < curInt, assign this current order
							order = curOrder;
							// assign this count
							curCount = i;
							k++;
							flow2++;
						}
						// original plus 1 and type to string
						int modify = Integer.parseInt(curOrder) + 1;
						temp.setOrder(modify + "");
						newObj[i + k] = input[i];
					}
				}
				// assign new obj
				input = newObj;
				newObj = null;
				

				// week
				String weekDay[] = { "�P���@", "�P���G", "�P���T", "�P���|", "�P����", "�P����", "�P����" };
				for (int i = 0; i < weekDay.length; i++)
				{
					while (true)
					{
						System.out.print(weekDay[i] + " 0)���p 1)��p: ");
						String run = scanner.next();
						try
						{
							int testR = Integer.parseInt(run);
							if (testR == 0 || testR == 1)
							{
								week[i] = run;
								break;
							}
						} catch (Exception e)
						{
						}
						printError();
					}
				}
				input[curCount] = new CRoutine(bus, no, branch, round, name, stop, order, departure, week[0], week[1],
						week[2], week[3], week[4], week[5], week[6]);
				count++;
				
			}
			// 3: �R�����w���u
			else if (opt == 3)
			{
				String no, branch;
				no = typeNo();
				branch = typeBranch();

				int k = 0;
				for (int i = 0; i < count; i++)
				{
					// route exists
					if (input[i].getQuarRoute().equals(no + branch))
						continue;
					input[k++] = input[i];
				}
				count = k - 1;

			}
			// 4: ��ܫ��w���u
			else if (opt == 4)
			{
				String no, branch;
				no = typeNo();
				branch = typeBranch();

				// print the title
				printTitleData();
				printTitleRoutine();

				for (int i = 0; i < count; i++)
				{
					// route exists
					if (input[i].getQuarRoute().equals(no + branch))
					{
						((CRoutine) input[i]).printAll();
					}
				}
				// new line
				System.out.println();
			}
			// 5: ��X�s�����
			else if (opt == 5)
			{
				System.out.print("�п�J�ɦW: ");
				String outfile = scanner.next();
				// write file and buffered out
				// file.csv
				FileWriter fileWrite = new FileWriter(outfile + ".csv");
				BufferedWriter bufOutWrite = new BufferedWriter(fileWrite);

				// title line and new line
				bufOutWrite.write(titleLine);
				bufOutWrite.newLine();

				// output data
				String[] opLine = new String[count];

				for (int i = 0; i < count; i++)
				{
					CRoutine temp = (CRoutine) input[i];
					opLine[i] = temp.getRoute() + "," + temp.getOrder() + "," + temp.getDeparture() + ","
							+ temp.getWeek();
					System.out.println(opLine[i]);

					// other lines and new line
					bufOutWrite.write(opLine[i]);
					bufOutWrite.newLine();
				}
				// cache into file right now
				// avoiding data miss
				bufOutWrite.flush();
				// close file
				fileWrite.close();
			}
			// exception
			else
				printError();
		}

	}

	public static String typeNo()
	{
		String no;
		// route no: 4 letter
		while (true)
		{
			System.out.print("���u�s��: ");
			no = scanner.next();
			try
			{
				int testNo = Integer.parseInt(no);
				if (no.length() == 4)
					return no;
			} catch (Exception e)
			{
			}
			printError();
		}
	}

	public static String typeBranch()
	{
		String branch;
		// branch: 0 or capital
		while (true)
		{
			System.out.print("��uA-Z (�L�h��J0): ");
			branch = scanner.next();
			if (branch.length() == 1)
			{
				branch = branch.toUpperCase();
				char[] testBh = branch.toCharArray();
				// 0, A-Z
				if (testBh[0] == 48 || (testBh[0] >= 65 && testBh[0] <= 90))
					return branch;
			}
			printError();
		}
	}

	public static void printMark()
	{
		System.out.println("===================");
	}

	public static void printError()
	{
		System.out.println("Error! Try again.");
	}

	public static void printTitleData()
	{
		// �ȹB�~�� | ���u�s�� | ��u | ���� | ���u�W�� | ���W
		System.out.printf("%4s\t%4s\t%2s\t%2s\t%14s\t%4s\t", titleArr[0], titleArr[1], titleArr[2], titleArr[3],
				titleArr[4], titleArr[5]);
	}

	public static void printTitleRoutine()
	{
		// �Z���� | �o���ɶ� | �P���@ | �P���G | �P���T | �P���| | �P���� | �P���� | �P����
		System.out.printf("%3s\t%4s\t%3s\t%3s\t%3s\t%3s\t%3s\t%3s\t%3s", titleArr[6], titleArr[7], titleArr[8],
				titleArr[9], titleArr[10], titleArr[11], titleArr[12], titleArr[13], titleArr[14]);
		System.out.println();
	}

}
