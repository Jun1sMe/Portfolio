using System;
namespace lesson202_01
{
    public class Queue
    {
        private int front, rear, count;
        private int[] items;
        public Queue(int size)
        {
            front = rear = -1;
            count = 0;
            items = new int[size];
        }
        public bool IsEmpty()
        {
            if (count == 0)
                return true;
            return false;
        }
        public bool IsFull()
        {
            if (count == items.Length)
                return true;
            return false;
        }
        public void Push(int item)
        {
            if (!IsFull())
            {
                rear = (rear + 1) % items.Length;
                count++;
				items[rear] = item;
            }
        }
        public int Pop()
        {
            if (IsEmpty())
                return -1;
            front = (front + 1) % items.Length;
            count--;
            return items[front];
        }
    }
}
