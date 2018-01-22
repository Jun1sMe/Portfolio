using System;

namespace lesson012_00A
{
    class MainClass
    {
        public static void Main(string[] args)
        {
			int count = 0;
            double sum = 0;
			string[] result = new string[100];

            while(true)
            {
                Console.Write("a) Add, b) Output, c)Quit: ");
                String opt = Console.ReadLine().ToLower();

                // add
                if(opt.Equals("a"))
                {
                    // condition
                    char[] delimiter = { ' ', ',', ':','\t'};

                    // put line into array
                    Console.Write("Input a sentence: ");
                    string input = Console.ReadLine();
                    string[] newInput = input.Split(delimiter);

                    for (int i = 0; i < newInput.Length; i++)
                    {
                        // try parse int to sum up
                        if (Int32.TryParse(newInput[i], out int num))
                            sum += num;
                        // try parse double to sum up
                        else if(Double.TryParse(newInput[i], out double num2))
                            sum += num2;
                        else
                        {
                            // don't exist
                            if (Search(result, newInput[i], newInput.Length) == false && newInput[i] != "")
                            {
                                if (count >= result.Length)
                                    result = Resize(result, result.Length * 2, count);
								result[count++] = newInput[i];
                            }
                        }
                    }
                    // 'dot' but not double
                    string more = "";
                    int decount = 0;
                    for (int i = 0, k = 0; i < count; i++)
                    {
                        // initialize not the same
                        bool same = false;
                        char[] chTemp = result[i].ToCharArray();

                        // pick '.'
                        for (int j = 0; j < chTemp.Length; j++)
                        {
                            if (chTemp[j] == '.')
                            {
								more += result[i] + ".";
                                same = true;
                                decount++;
                                break;
                            }
                                
                        }
                        // recover the mover
                        if (same == false) 
                            result[k++] = result[i];
                            
                    }
                    count -= decount;

                    // the rest
                    string[] restInput = more.Split('.');
                    for (int i = 0; i < restInput.Length; i++)
                    {
						// don't exist
						if (Search(result, restInput[i], count) == false && restInput[i] != "")
						{
							if (count >= result.Length)
								result = Resize(result, result.Length * 2, count);
							result[count++] = restInput[i];
						}
                    }


                    // count inserted word
                    Console.WriteLine("{0} words inserted!\nSum: {1:F2}", count ,sum);

                }
                // output
				else if (opt.Equals("b"))
				{
					Console.WriteLine("Sum: {0:F2}", sum);

                    InsertionSort(result, count);
                    for(int i = 0 ; i < count ; i++)
                        Console.WriteLine(result[i]);
                    // new line
                    Console.WriteLine();

                }
                // quit
				else if (opt.Equals("c"))
				{
					Console.WriteLine("Thanks for using!");
                    break;
                }
                // exception
                else
                    Console.WriteLine("Error! Try again.");

            }
        }

        // dynamics array
        public static string[] Resize(string[] arr, int length, int count)
        {
            string[] temp = new string[length];
            for (int i = 0; i < count; i++)
                temp[i] = arr[i];
            return temp;
        }
        // judge the same words
        public static bool Search(string[] arr, string key, int count)
        {
            for (int i = 0; i < count; i++)
            {
                if (key == arr[i])
                    return true;
            }
            return false;
        }
        // sort
        public static void InsertionSort(string[] arr, int count)
        {
            for (int i = 1; i < count; i++)
            {
                string temp = arr[i];
                int j = i - 1 ;
                while(j >= 0 && string.Compare(temp, arr[j], true) < 0)
                {
                    arr[j + 1] = arr[j];
                    j--;
                }
				arr[j + 1] = temp;
            }
        }

    }
}
