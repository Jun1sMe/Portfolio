using System;

namespace PrimeNum
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            while(true)
            {
				Console.Write("Please input an integer: ");
				String input = Console.ReadLine();
				int num = Int32.Parse(input);
				if (num < 2)
					Console.WriteLine("false");
				else
				{
					int i;
					for (i = 2; i < num; i++)
						if (num % i == 0)
							break;
					if (i == num)
						Console.WriteLine("true");
					else
						Console.WriteLine("false");
				}                
            }
        }
    }
}
