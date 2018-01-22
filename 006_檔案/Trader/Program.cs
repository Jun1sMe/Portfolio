using System;
using System.IO;

namespace lesson012_00C
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            while(true)
            {
                Console.Write("Oreder 1)Filter -1)Quit: ");
                string opt = Console.ReadLine();
                // quit
                if (opt == "-1")
                {
                    Console.WriteLine("Thanks for using.");
                    break;
                }
                // filter
                else if (opt == "1")
                {
                    Console.Write("Please enter a stock name: ");
                    string stock = Console.ReadLine();
                    Console.Write("Please enter a input filename: ");
                    string source = Console.ReadLine();
                    Console.Write("Please enter a output filename: ");
                    string target = Console.ReadLine();

                    CTrader tempTrader = new CTrader(stock, source, target);
                    if(tempTrader.filterStock())
                        Console.WriteLine("Success!");
                    Console.WriteLine();
                }
                else
                    PrintError();
            }


        }
        // error
        public static void PrintError()
        {
            Console.WriteLine("Error! Try again.");
        }
    }
}
