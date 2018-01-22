
public class ChainingHashTable
{
	private Node[] ht;
	private int b;
	
	public ChainingHashTable(int arrSize)
	{
		ht = new Node[arrSize];
		b = arrSize;
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
	public int getBucket()
	{
		return this.b;
	}
	public void insert(String str)
	{
		// eliminate ',', '.' and Lower
		str = str.replace('.', ' ').replace(',', ' ').toLowerCase();
		String[] tempStr = str.split("\\s+");
		// ready to insert
		for(int i  = 0 ; i < tempStr.length ; i++)
		{
			int homeBucket =  this.h(tempStr[i]);
			int curBucket = homeBucket;
			if(this.search(tempStr[i]) == null)
			{
				if(ht[curBucket] != null)		// occupy
				{
					while(ht[curBucket].getLink() != null)	// occupy
						ht[curBucket] = ht[curBucket].getLink();
					ht[curBucket].setLink(new Node(curBucket, tempStr[i]));
				}
				else
					ht[curBucket] = new Node(curBucket, tempStr[i]);
			}
			else
				System.out.println(tempStr[i] + " exists!");
		}	// end for loop: sentence was done	
		System.out.println("Done!");
	}
	public Node search(String key)
	{
		int homeBucket = this.h((key = key.toLowerCase()));
		int curBucket = homeBucket;
		while(ht[curBucket] != null && !ht[curBucket].getValue().equals(key))
			ht[curBucket] = ht[curBucket].getLink();		// find out or not
		// the one is finding out, and the other is nothing
		return ht[curBucket];
	}
	
	
}
