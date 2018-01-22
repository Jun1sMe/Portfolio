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

		System.out.print("載入資料檔：");
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
				System.out.print("選項：1)檢視全部, 2)新增, 3)刪除, 4)修改, 5)篩選編號, -1) 結束? ");
				opt = scanner.nextInt();
			}
			// 檢視全部
			if (opt == 1)
			{
				// print the title
				System.out.printf("%2s\t%3s\t%6s\t%6s\t%14s\n", firstArr[0], firstArr[1], firstArr[2], firstArr[3],
						firstArr[4]);
				System.out.println("===========================================================");
				// print all data
				myList.print();
				System.out.println();

				// 回到主選單
				opt = 0;
			}
			// 新增
			else if (opt == 2)
			{
				// 編號
				int no = myList.judgeNo(2);
				while (no == -1 || no == -2)
					no = myList.judgeNo(2);
				int exist = myList.search(no);
				if (exist != -1)
					System.out.println("編號已存在！\n");
				// 其他資訊
				else
					insert(2, no);

				// 回到主選單
				opt = 0;
			}
			// 刪除
			else if (opt == 3)
			{
				System.out.print("輸入編號：");
				int no = scanner.nextInt();

				// 回到檢視全部
				if (myList.delete(no) == true)
					opt = 1;
				// 回到主選單
				else
					opt = 0;
			}
			// 修改
			else if (opt == 4)
			{
				// 編號
				int no = myList.judgeNo(4);
				while (no == -1 || no == -2)
					no = myList.judgeNo(4);
				int index = myList.search(no);
				if (index == -1)
				{
					System.out.println("編號不存在！\n");
					// 回到主選單
					opt = 0;
				}
				// 其他資訊
				else
				{
					insert(4, no);
					// 回到檢視全部
					opt = 1;
				}
			}
			// 篩選編號
			else if (opt == 5)
			{
				int startNo = 0, endNo = 0, flow = 0, startIndex = 0, endIndex = 0;
				while (true)
				{
					if (flow == 0)
					{
						System.out.print("輸入起始編號：");
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
							System.out.println("錯誤！請重新輸入！");
					}

					if (flow == 1)
					{
						System.out.print("輸入結束編號：");
						endNo = scanner.nextInt();
						// end no is 1~100
						if (startNo > endNo || endNo > 100)
						{
							System.out.println("錯誤！請重新輸入！");
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
						System.out.print("輸出資料檔名：");
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

						// 將緩衝區的內容立刻寫入到檔案
						// 沒寫可能導致檔案內容不完整
						bufWriteOut.flush();
						// close file
						fileWrite.close();

						System.out.println("檔案寫入成功！\n");

						// 回到主選單
						opt = 0;
						break;
					}
				}

			}
			// 結束
			else if (opt == -1)
			{
				 System.out.println("寫入" + loadFile + "成功！\n程式結束。");
				break;
			}
			// exception
			else
			{
				System.out.println("錯誤！請重新輸入！");
				opt = 0;
			}
		}

	}

	// method: add or modify
	public static void insert(int opt, int no)
	{
		// 姓名
		System.out.print("姓名：");
		String n = scanner.next();
		// 身分證
		String id = myList.judgeId();
		while (id.equals(""))
			id = myList.judgeId();
		// 生日
		MemberBD bd;
		while (true)
		{
			System.out.print("生日（年/月/日）：");
			int y = scanner.nextInt();
			int m = scanner.nextInt();
			int d = scanner.nextInt();
			if (MemberBD.isValid(y, m, d))
			{
				bd = new MemberBD(y, m, d);
				break;
			}
			System.out.println("錯誤！請重新輸入！");
		}
		// 電話
		String p = myList.judgePhone();
		while (p.equals(""))
			p = myList.judgePhone();

		if (opt == 2)
		{
			myList.add(no, n, id, bd, p);
			System.out.println("會員新增成功!\n");
		} 
		else if (opt == 4)
		{
			myList.modify(no, n, id, bd, p);
			System.out.println("會員修改成功!\n");
		}

	}

}
