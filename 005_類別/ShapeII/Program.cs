using System;

namespace lesson012_00B
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            // first loop, second loop
            string opt = "0", opt2 = "0";
            // polymorphism
            CShape[] myShape = new CShape[100];
            int count = 0;

            while (true)
            {
                // initial status
                if (opt == "0")
                {
                    Console.Write("Menu: 1)add, 2)output, -1)Quit: ");
                    opt = Console.ReadLine();
                }
                // add
                if (opt == "1")
                {
                    // initial status
                    if (opt2 == "0")
                    {
                        Console.Write("Options: 1)rectangle, 2)circle, 3)trapezoid, -1)Quit: ");
                        opt2 = Console.ReadLine();
                    }
                    // rectangle
                    if (opt2 == "1")
                    {
                        Console.Write("Please enter the width: ");
                        string input1 = Console.ReadLine();
                        Console.Write("Please enter the heigth: ");
                        string input2 = Console.ReadLine();

                        // try parse int to sum up
                        if (Double.TryParse(input1, out double w) && Double.TryParse(input2, out double h) && w > 0 && h > 0)
                        {
                            myShape[count] = (CShape)new CRectangle(w, h);
                            Console.WriteLine("Area: {0:F2}\nPerimeter: {1:F2}", myShape[count].Area(), myShape[count].Perimeter());
                            count++;
                            opt2 = "0";
                        }
                        else
                            PrintError();
                    }
                    // circle
                    else if (opt2 == "2")
                    {
                        Console.Write("Please enter the radius: ");
                        string input = Console.ReadLine();
                        if (Double.TryParse(input, out double r) && r > 0)
                        {
                            myShape[count] = (CShape)new CCircle(r);
                            Console.WriteLine("Area: {0:F2}\nPerimeter: {1:F2}", myShape[count].Area(), myShape[count].Perimeter());
                            count++;
                            opt2 = "0";
                        }
                        else
                            PrintError();
                    }
                    // trapezoid
                    else if (opt2 == "3")
                    {
                        Console.Write("Please type the upper: ");
                        string input1 = Console.ReadLine();
                        Console.Write("Please type the lower: ");
                        string input2 = Console.ReadLine();
                        Console.Write("Please type the heigth: ");
                        string input3 = Console.ReadLine();
                        if (Double.TryParse(input1, out double u) && Double.TryParse(input2, out double l) && Double.TryParse(input3, out double h) && u > 0 && l > 0 && h > 0)
                        {
                            myShape[count] = (CShape)new CTrapezoid(u, l, h);
                            Console.WriteLine("Area: {0}\nPerimeter: {1:F2}", myShape[count].Area(), myShape[count].Perimeter());
                            count++;
                            opt2 = "0";
                        }
                        else
                            PrintError();
                    }
                    // Quit
                    else if (opt2 == "-1")
                    {
						opt = "0";
                        opt2 = "0";
                    }
                    // exception
                    else
                    {
                        PrintError();
                        opt2 = "0";
                    }

                }
                // output
                else if (opt == "2")
                {
                    for (int i = 0; i < count; i++)
                    {
                        // GetType().Name = getClass().getName()
                        Console.WriteLine("{0}\tArear: {1:F2}\tPerimeter: {2:F2}", myShape[i].GetType().Name, myShape[i].Area(), myShape[i].Perimeter());
                    }
                    Console.WriteLine();
                    opt = "0";
                }
                // Quit
                else if (opt == "-1")
                {
                    Console.WriteLine("Thanks for using!");
                    break;
                }
                // exception
                else
                {
                    PrintError();
                    opt = "0";
                }

            }

        }

        // print Error
        public static void PrintError()
        {
            Console.WriteLine("Error! Try again.");
        }
    }
}
