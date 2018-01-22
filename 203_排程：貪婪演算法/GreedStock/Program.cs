using System;

namespace lesson203_02
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            Solution mySoultion = new Solution();
            int day;
            int[] stockPrice;
            do
            {
                Console.WriteLine("How many days do you know the price of given stock? ");
                bool dayBool = Int32.TryParse(Console.ReadLine(), out day);
                if (!dayBool || day < 0)
                {
                    printError();
                    continue;
                }
            } while (day < 0);
            stockPrice = new int[day];
            for (int i = 1; i <= day; i++)
            {
                Console.WriteLine("What's the price of the " + i + "'s day? ");
                bool tmpBool = Int32.TryParse(Console.ReadLine(), out int tmp);
                if (!tmpBool || tmp < 0)
                {
                    printError();
                    i--;
                    continue;
                }
                stockPrice[i - 1] = tmp;
            }
            // check the result
            Console.WriteLine("Output: {0}", mySoultion.maxProfit(stockPrice));

        }
        public static void printError()
        {
            Console.WriteLine("Error! Try again.");
        }
    }
}
