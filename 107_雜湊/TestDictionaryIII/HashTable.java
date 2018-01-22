
public class HashTable
{
	private Node[][] ht;
	private int b, s;
	public HashTable(int bucket, int slot)
	{
		ht = new Node[bucket][slot];
		b = bucket;
		s = slot;
	}
	public int getBucket()
	{
		return this.b;
	}
	// hash function
	private int h(String key)
	{
		int tempInt = 0;
		char[] tempCh = key.toCharArray();
		for(int j = 0 ; j < tempCh.length ; j++)
			tempInt += (int)tempCh[j] * (j + 1);	
		if(ht != null)
			return tempInt % b;
		return -1;
	}
	public void rehashing()
	{
		// new array and resize
		Node[][] temp = new Node[b * 2][s];
		b *= 2;
		// original size
		for(int i = 0 ; i < b / 2 ; i++)
		{
			for(int j = 0 ; j < s; j++)
			{
				Node reTemp = reInsert(ht[i][j].getValue(), temp);
				if(reTemp != null)
					reTemp.setTimes(ht[i][j].getTimes());
			}
		}	
		// assign
		ht = temp;
		System.out.println("Rehashing¡K\nDone!\n");
	}
	public Node reInsert(String str, Node[][] arr)
	{
		// anti-invalid
		if(str == null || str == "")
			return null;
		int j = 0;
		int homeBucket = this.h(str);
		int curBucket = homeBucket;
		while(arr[curBucket][j] != null)	// occupy
		{
			j++;
			if(j == 5)	// slot is full
			{
				j = 0;
				curBucket = (curBucket + 1) % b;
			}
		}
		arr[curBucket][j] = new Node(curBucket, str);
		return arr[curBucket][j];
	}
	public void insert(String str)
	{
		// eliminate ',', '.' and Lower
		str = str.replace('.', ' ').replace(',', ' ').replace(':', ' ').toLowerCase();
		String[] tempStr = str.split("\\s+");
		// ready to insert
		for(int i = 0; i < tempStr.length ; i++)
		{
			// anti-invalid
			if(tempStr[i] == null || tempStr[i] == "")
				continue;
			// exists
			Node temp = this.searchNode(tempStr[i]);
			if(temp != null)
			{
				temp.setTimes();
				continue;
			}
			int j = 0;
			int homeBucket = this.h(tempStr[i]);
			int curBucket = homeBucket;
			while(ht[curBucket][j] != null)	// occupy
			{
				j++;
				if(j == 5)	// slot is full
				{
					j = 0;
					curBucket = (curBucket + 1) % b;
					if(curBucket == homeBucket)
					{
						System.out.println("The table is full! Do resizing¡K\n"
								+ "The size of hash table goes to " + b * 2 + " from " + b + ".");
						rehashing();						
					}
				}
			}
			ht[curBucket][j] = new Node(curBucket, tempStr[i]);
		}	// end for loop: sentence was done
	}	
	public String search(String key)
	{
		int homeBucket = this.h((key = key.toLowerCase()));
		int curBucket = homeBucket;
		int j = 0;
		while(ht[curBucket][j] != null && !ht[curBucket][j].getValue().equals(key))
		{
			j++;
			if(j == 5)	// slot go a run
			{
				j = 0;
				// circular table
				curBucket = (curBucket + 1) % b;
				// go a run, and no space
				if(curBucket == homeBucket)
					return null;
			}			
		}
		// the one is finding out, and the other is nothing
		if(ht[curBucket][j] != null)
			return curBucket + " " + j + " " + ht[curBucket][j].getTimes();
		return null; 
	}
	public Node searchNode(String key)
	{
		int homeBucket = this.h((key = key.toLowerCase()));
		int curBucket = homeBucket;
		int j = 0;
		while(ht[curBucket][j] != null && !ht[curBucket][j].getValue().equals(key))
		{
			j++;
			if(j == 5)	// slot go a run
			{
				j = 0;
				// circular table
				curBucket = (curBucket + 1) % b;
				// go a run, and no space
				if(curBucket == homeBucket)
					return null;
			}			
		}
		// the one is finding out, and the other is nothing
		return ht[curBucket][j];
	}
}
