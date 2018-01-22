using System;

namespace lesson203_01
{
    class MainClass
    {
        public enum State { kid, cookie, over };
        public static void Main(string[] args)
        {
            State curState = State.kid;
            Solution mySoultion = new Solution();
            int[] greedFactor = null, cookieSize = null;
            do
            {
                if (curState == State.kid)
                {
                    Console.WriteLine("How many children do you have? ");
                    bool kidBool = Int32.TryParse(Console.ReadLine(), out int kid);
                    if (!kidBool || kid < 0)
                    {
                        printError();
                        continue;
                    }
                    greedFactor = new int[kid];
                    for (int i = 1; i <= kid; i++)
                    {
                        Console.WriteLine("What's the " + i + "'s greedy factor? ");
                        bool tmpBool = Int32.TryParse(Console.ReadLine(), out int tmp);
                        if (!tmpBool || tmp < 0)
                        {
                            printError();
                            i--;
                            continue;
                        }
                        greedFactor[i - 1] = tmp;
                    }
                    curState = State.cookie;
                }
                else
                {
                    Console.WriteLine("How many cookies do you have? ");
                    bool cookBool = Int32.TryParse(Console.ReadLine(), out int cookie);
                    if (!cookBool || cookie < 0)
                    {
                        printError();
                        continue;
                    }
                    cookieSize = new int[cookie];
                    for (int i = 1; i <= cookie; i++)
                    {
                        Console.WriteLine("What's the " + i + "'s cookie size? ");
                        bool tmpBool = Int32.TryParse(Console.ReadLine(), out int tmp);
                        if (!tmpBool || tmp < 0)
                        {
                            printError();
                            i--;
                            continue;
                        }
                        cookieSize[i - 1] = tmp;
                    }
                    curState = State.over;
                }
            } while (curState != State.over);
            // deliver one cookie to one child
            Console.WriteLine("Output: {0}", mySoultion.FindContentChildren(greedFactor, cookieSize));




        }
        public static void printError()
        {
            Console.WriteLine("Error! Try again.");
        }
    }
}
