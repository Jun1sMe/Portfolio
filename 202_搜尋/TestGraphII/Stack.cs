using System;
namespace lesson202_01
{
    public class Stack
    {
        private int top;
        private int[] items;
        public Stack(int size)
        {
            top = -1;
            items = new int[size];
        }
        public bool IsEmpty()
        {
            if (top < 0)
                return true;
            return false;
        }
        public bool IsFull()
        {
            if (top >= items.Length - 1)
                return true;
            return false;
        }
		public void Push(int item)
		{
            if (!IsFull())
                items[++top] = item;
		}
        public int Pop()
        {
            if (IsEmpty())
                return -1;
            return items[top--];
        }
    }
}
