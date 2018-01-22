using System;
namespace lesson202_01
{
    public class Graph
    {
        private Node[] edges;
        private int dir;
        public Graph(int num, int dir)
        {
            this.dir = dir;
            this.edges = new Node[num];
            for (int i = 0; i < num; i++)
				this.edges[i] = new Node();
        }
        public Node Search(int head, int tail)
        {
            Node tmp = edges[head - 1];
            while (tmp != null && tmp.GetData() != tail)
                tmp = tmp.GetLink();
            return tmp;
        }
        public void Insert(int head, int tail, int weight)
        {
            Node tmp = edges[head - 1];
            while (tmp.GetLink() != null)
                tmp = tmp.GetLink();
            tmp.SetLink(new Node(tail, weight));
        }
        public void Delete(int head, int tail)
        {
            Node cur = edges[head - 1], pa = null;
            while (cur != null && cur.GetData() != tail)
            {
                pa = cur;
                cur = cur.GetLink();
            }
            if (pa == null)         // the first
                edges[head - 1] = edges[head - 1].GetLink();
            else if (cur != null)   // the middle
                pa.SetLink(cur.GetLink());
        }
        // print edges
        override public string ToString()
        {
            string str = this.dir + "\n" + edges.Length + "\n\n";
            int i;
            for (i = 0; i < edges.Length; i++)
            {
                string tmpStr = "";
                int count = 0;
                Node tmp = edges[i];
                while ((tmp = tmp.GetLink()) != null)
                {
                    tmpStr += tmp.GetData() + " " + tmp.GetWeight() + "\n\n";
                    count++;
                }
                // vetex: i + 1 && count: number
                str += (i + 1) + " " + count + "\n\n" + tmpStr;
            }
            return str;
        }
        public int GetDir()
        {
            return this.dir;
        }
        public int GetSize()
        {
            return this.edges.Length;
        }
        public int[] BFS(int head, int num)
        {
            Queue myQueue = new Queue(num); // non-traversal
            int[] visited = new int[num],   // visited
                  ans = new int[num];       // order
            int count = 0;
            for (int i = 0; i < num; i++)
                visited[i] = 0;
            // starting vetex
            visited[head - 1] = 1;
            ans[count++] = head;
            myQueue.Push(head);
            while(!myQueue.IsEmpty())
            {
				Node tmpNode = edges[myQueue.Pop() - 1].GetLink();
                while(tmpNode != null)
                {
                    int tmp = tmpNode.GetData();
                    if(visited[tmp - 1] == 0)   // vetex unvisited
                    {
                        ans[count++] = tmp;
                        myQueue.Push(tmp);
                        visited[tmp - 1] = 1;
                    }
                    tmpNode = tmpNode.GetLink();
                }
            }
            return ans;
        }
        public int[] DFS(int head, int num)
        {
            Stack myStack = new Stack(num); // non-traversal
            int[] visited = new int[num],   // visited
                   ans = new int[num];      // order
            int count = 0;
            for (int i = 0; i < num; i++)
                visited[i] = 0;
            // starting vetex
            visited[head - 1] = 1;
            ans[count++] = head;
            myStack.Push(head);
            Node tmpNode = null;
            int tmp = head;
            int k = 0;  // sentinel
            while (tmp > 0)
            {
                if(k == 0)
    				tmpNode = edges[tmp - 1].GetLink();
				if(tmpNode != null)    
				{
					tmp = tmpNode.GetData();
					if(visited[tmp - 1] == 0)   // vetex unvisited
					{
						ans[count++] = tmp;
						myStack.Push(tmp);
						visited[tmp - 1] = 1;
                        k = 0;
					}
                    else
                    {
                        tmpNode = tmpNode.GetLink();
                        k++;
                    }
				}
				else
				{
					tmp = myStack.Pop();
                    k = 0;					
				}
            }
            return ans;
        }
    }
}
