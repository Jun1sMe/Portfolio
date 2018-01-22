using System;
namespace lesson203_01
{
    public class Solution
    {
        // g: greed factor | children ; s: size | cookie
        // if size >= greed, success
        public int FindContentChildren(int[] g, int[] s)
        {
            // sort: small to big
            InsertSort(g);
            InsertSort(s);
            int match = 0;
            for (int i = 0, j = -1; i < g.Length && j < s.Length; i++)
            {
                while(++j < s.Length)
                {
                    if (s[j] >= g[i])
                    {
						match++;
                        break;
                    }
                }
            }
            return match;
        }
        public void InsertSort(int[] arr)
        {
            for (int i = 1; i < arr.Length; i++)
            {
                int tmp = arr[i], j = i - 1;
                while (j >= 0 && tmp < arr[j])
                {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = tmp;
            }
        }
    }
}
