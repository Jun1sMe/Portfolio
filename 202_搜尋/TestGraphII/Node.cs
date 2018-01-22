using System;
namespace lesson202_01
{
    public class Node
    {
        private int data;
        private int weight;
        private Node link;
        public Node()
        {
            
        }
        public Node(int data, int weight)
        {
            this.data = data;
            this.weight = weight;
            this.link = null;
        }
        public int GetData()
        {
            return this.data;
        }
        public int GetWeight()
        {
            return this.weight;
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
