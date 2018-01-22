using System;
using System.IO;

namespace lesson012_00C
{
    public class CTrader
    {
        private string stock, sourceFile, targetFile;

        public CTrader(string stock, string source, string target)
        {
            setData(stock, source, target);
        }
        // make it set
        public void setData(string stock, string source, string target)
        {
			this.stock = stock;
			this.sourceFile = source;
			this.targetFile = target;           
        }

        public bool filterStock()
        {
            try
            {
				FileStream fromStream = new FileStream(sourceFile, FileMode.Open, FileAccess.Read);
                StreamReader fileReader = new StreamReader(fromStream);
                FileStream toStream = new FileStream(targetFile, FileMode.Create, FileAccess.Write);
                StreamWriter fileWriter = new StreamWriter(toStream);
                // title line
				string title = fileReader.ReadLine();
                fileWriter.WriteLine(title);
                // other line
                string temp;
                while((temp = fileReader.ReadLine()) != null)
                {
                    string[] tempMod = temp.Split(',');
                    // index2: stock
					if (tempMod[2] == stock)
					{
                        fileWriter.WriteLine(temp);
					}
                }
                // output all
                fileWriter.Flush();
                // close file
                fileReader.Close();
				fromStream.Close();
                fileWriter.Close();
                toStream.Close();

                return true;
			}
			catch
			{
                Console.WriteLine("File " + sourceFile + " don't exist!");
                return false;
			}
        }

    }
}
