using System;
namespace lesson201_01
{
    public class Node
    {
        private int data;
        private Node link;
        public Node(int data)
        {
            this.data = data;
            this.link = null;
        }
        public int GetData()
        {
            return this.data;
        }
        public Node GetLink()
        {
            return this.link;
        }
        public void SetLink(Node link)
        {
            this.link = link;
        }
    }
}
