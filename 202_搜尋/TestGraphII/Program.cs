using System;
using System.IO;

namespace lesson202_01
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            Graph myGraph;
            int num = 0,    // vertices
                graph = 0;; // direction
            while(true)
            {
                Console.Write("Input a file(Y/N): ");
                bool loadBool = Char.TryParse(Console.ReadLine().ToLower(), out char load);
				String loadFile = "";
				try
				{
					if (loadBool && load == 'y')
					{
						Console.Write("File name: ");
						loadFile = Console.ReadLine();
						StreamReader sr = new StreamReader(loadFile);
						bool graphBool = Int32.TryParse(sr.ReadLine(), out graph);
						if(graphBool && graph >=0 && graph <= 1)
						{
							bool numBool = Int32.TryParse(sr.ReadLine(), out num);
							if(numBool && num > 0)
							{
								myGraph = new Graph(num, graph);
								string tmp = sr.ReadLine();         // pass '\n'
								while((tmp = sr.ReadLine()) != null)// exists
								{
									// first: vertex, num
									string[] tmpArr = tmp.Split();
									if(tmpArr.Length == 2)
									{
										int head = int.Parse(tmpArr[0]), count = int.Parse(tmpArr[1]);
										for (int i = 0; i < count; i++)
										{
											sr.ReadLine();          // pass '\n'
											string[] tmpVetex = sr.ReadLine().Split();
											if(tmpVetex.Length == 2)
											{
												int tail = int.Parse(tmpVetex[0]), weight = int.Parse(tmpVetex[1]);
												myGraph.Insert(head, tail, weight);
											}
										}
									}
									sr.ReadLine();  // pass '\n'
								}
                                sr.Close(); // close StreamReader
                                break;
							}
						}
					}
					else if(loadBool && load == 'n')
					{
						int flow = 0;
						while (true)
						{
							if (flow == 0)
							{
								// 1st line: '0' is undirected, '1' is directed
								Console.Write("0)Undirected graph 1)Directed graph: ");
								bool graphBool = Int32.TryParse(Console.ReadLine(), out graph);
								if (graphBool && graph >= 0 && graph <= 1)
									flow++;
							}
							if (flow == 1)
							{
								// 2nd line: vertices
								// 要求使用者輸入節點個數
								Console.Write("Input node number: ");
								bool numBool = Int32.TryParse(Console.ReadLine(), out num);
								if (numBool && num > 0)
								{
									myGraph = new Graph(num, graph);
									break;
								}
							}
							PrintError();
						}
						break;
					}
					
				}
				catch
				{
					Console.WriteLine("File " + loadFile + " don't exist!");
					continue;
				}			
				PrintError();
			}

            while (true)
            {
                Console.Write("1)Add 2)Delete 3)Print/Output 4)BFS 5)DFS -1)Quit: ");
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
                    else if (myGraph.Search(node1, node2) != null)
                        Console.WriteLine("Cannot generate the-same-edge!");
                    else
                    {
                        Console.Write("weight: ");
                        bool weiBool = Int32.TryParse(Console.ReadLine(), out int weight);
                        if (!weiBool && weight < 0)
                        {
                            PrintError();
                            continue;
                        }
                        myGraph.Insert(node1, node2, weight);
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
                    else if (myGraph.Search(node1, node2) == null)
                        Console.WriteLine("Edge don't exist!");
                    else
                    {
                        myGraph.Delete(node1, node2);
                        PrintSuccess();
                    }
                }
                // 將圖的點集合、邊集合印出並匯出
                else if (opt == "3")
                {
                    try
                    {
                        string OutputFile = "";
                        Console.Write("File name: ");
                        OutputFile = Console.ReadLine();
                        StreamWriter sw = new StreamWriter(OutputFile);
                        string tmp = myGraph.ToString();
                        Console.WriteLine(tmp);
                        sw.WriteLine(tmp);
                        sw.Flush(); // cache in
                        sw.Close(); // close StreamWriter
                    }
                    catch
                    {
                        PrintError();
                        continue;
                    }

                }
                else if (opt == "4")    // BFS
                {
                    Console.Write("Input a node: ");
                    bool nodeBool = Int32.TryParse(Console.ReadLine(), out int node);
                    if (!nodeBool && (node < 1 || node > num))
                    {
                        PrintError();
                        continue;
                    }
                    int[] tmp = myGraph.BFS(node, num);
                    for (int i = 0; i < tmp.Length; i++)
                    {
                        int result = tmp[i];
                        if(result != 0)
						    Console.Write(result + "\t");
                    }
                    Console.WriteLine();
                }
                else if (opt == "5")    // DFS
                {
                    Console.Write("Input a node: ");
                    bool nodeBool = Int32.TryParse(Console.ReadLine(), out int node);
                    if (!nodeBool && (node < 1 || node > num))
                    {
                        PrintError();
                        continue;
                    }
                    int[] tmp = myGraph.DFS(node, num);
                    for (int i = 0; i < tmp.Length; i++)
                    {
                        int result = tmp[i];
                        if (result != 0)
                            Console.Write(result + "\t");
                    }
                    Console.WriteLine();
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
