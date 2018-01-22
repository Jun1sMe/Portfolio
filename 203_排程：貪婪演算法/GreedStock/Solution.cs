using System;
namespace lesson203_02
{
    public class Solution
    {
        public int maxProfit(int[] prices)
        {
            int profit = 0;
            for (int i = 0; i < prices.Length; i++)
            {
                if (i < prices.Length - 1 && prices[i] < prices[i + 1])
                    profit += prices[i + 1] - prices[i];
            }
            return profit;
        }
    }
}
