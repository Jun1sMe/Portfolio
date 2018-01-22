using System;

namespace lesson201_01
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            int num;
            while(true)
            {
				// 要求使用者輸入節點個數
				Console.Write("Input node number: ");
				String numStr = Console.ReadLine();
				bool numA = Int32.TryParse(numStr, out num);
				if (numA == true && num > 0)
					break;
                PrintError();
            }
            LinkedList[] myList = new LinkedList[num];
            // 節點請用{1, 2, ...}進行編號
            for (int i = 0; i < num; i++)
                myList[i] = new LinkedList(i + 1);
            while(true)
            {
                Console.Write("1)Add 2)Delete 3)Output -1)Quit: ");
				String opt = Console.ReadLine().ToLower();
                // 為此圖形新增edge功能（輸入兩端點編號來決定一邊）
                if (opt == "1")
                {
                    if (!InputStatus(num, out int node1, out int node2))
						continue;
					// 不可產生自參考
					if (node1 == node2)
						Console.WriteLine("Cannot generate self-edge!");
					// 不可產生重複邊
					else if (myList[node1 - 1].Search(node2) != null)
						Console.WriteLine("Cannot generate the-same-edge!");
					else
					{
						myList[node1 - 1].Insert(node2);
                        PrintSuccess();
					}
                }
                // 刪除功能，用來去除圖中的一邊
                else if (opt == "2")
                {
                    if (!InputStatus(num, out int node1, out int node2))
                        continue;
                    // 無自參考
                    if (node1 == node2)
                        Console.WriteLine("No self-edge!");
                    else if (myList[node1 - 1].Search(node2) == null)
                        Console.WriteLine("Edge don't exist!");
                    else
                    {
                        myList[node1 - 1].Delete(node2);
                        PrintSuccess();
                    }
                }
                // 將圖的點集合、邊集合印出
                else if (opt == "3")
                {
                    string nodeAll = "", edgeAll = "";
                    for (int i = 0; i < num; i++)
                    {
                        nodeAll += myList[i].getFirstNode().GetData() + "\t";
                        string tmp = myList[i].ToString();
                        if(tmp != "")
                            edgeAll += tmp + "\t";
                    }
                    Console.WriteLine(nodeAll + "\n" + edgeAll);
                }
                else if (opt == "-1")
                {
                    Console.WriteLine("Thank you for using!");
                    return;
                }
                else
                    PrintError();
            }
        }
        public static void PrintError()
        {
            Console.WriteLine("Error! Try again.");
        }
        public static void PrintSuccess()
        {
            Console.WriteLine("Success!");
        }
        public static bool InputStatus(int num, out int node1, out int node2)
        {
            Console.Write("Input an edge,\nfirst node: ");
            String node1str = Console.ReadLine();
            Console.Write("second node: ");
            String node2str = Console.ReadLine();
            //int node1, node2;
            //node1 = Int32.Parse(node1str);
            //node2 = Int32.Parse(node2str);
            bool nodeA = Int32.TryParse(node1str, out node1);
            bool nodeB = Int32.TryParse(node2str, out node2);
            // value issue
            if ((nodeA == false || nodeB == false) ||
                node1 > num || node1 < 1 || node2 > num || node2 < 1)
            {
				PrintError();
                return false;            
            }
            return true;
        }
    }
}
