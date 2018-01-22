using System;
namespace lesson201_01
{
    public class LinkedList
    {
        Node first;
        public LinkedList()
        {
            this.first = null;
        }
        public LinkedList(int data)
        {
            this.first = new Node(data);
        }
        public Node Search(int key)
        {
            Node tmp = first;
            while (tmp != null && tmp.GetData() != key)
                tmp = tmp.GetLink();
            return tmp;
        }
        public void Insert(int key)
        {
            Node tmp = first;
            while (tmp.GetLink() != null)
                tmp = tmp.GetLink();
            tmp.SetLink(new Node(key));
        }
        public void Delete(int key)
        {
            Node cur = first, pa = null;
            while (cur != null && cur.GetData() != key)
            {
                pa = cur;            
				cur = cur.GetLink();
            }
            if (pa == null)         // the first
                first = first.GetLink();
            else if (cur != null)   // the middle
                pa.SetLink(cur.GetLink());
            else                    // the last
                pa.SetLink(cur);
        }
        // print edges
        public override string ToString()
        {
            string str = "";
            Node tmp = first;
            while ((tmp = tmp.GetLink()) != null)
                str += "(" + first.GetData() + "," + tmp.GetData() + ")\t";
            return str;
        }
        public Node getFirstNode()
        {
            return this.first;
        }
    }
}
