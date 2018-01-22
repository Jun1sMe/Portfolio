
public class HashTable
{
	private Element[] ht;
	private int b;
	public HashTable(int arrSize)
	{
		ht = new Element[arrSize];
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
		for(int i = 0 ; i < tempStr.length ; i++)
		{
			int homeBucket = this.h(tempStr[i]);
			int curBucket = homeBucket;
			while(ht[curBucket] != null)		// occupy
			{
				curBucket = (curBucket + 1) % b;
				if(curBucket == homeBucket)
				{
					System.out.println("Dictionary is full");
					return;	// there's no space
				}
			}
			if(this.search(tempStr[i]) == null)
				ht[curBucket] = new Element(curBucket, tempStr[i]);
			else
				System.out.println(tempStr[i] + " exists!");
		}	// end for loop: sentence was done	
		System.out.println("Done!");
	}	
	public Element search(String key)
	{
		int homeBucket = this.h((key = key.toLowerCase()));
		int curBucket = homeBucket;
		while(ht[curBucket] != null && !ht[curBucket].getValue().equals(key))
		{
			// circular table
			curBucket = (curBucket + 1) % b;
			// go a run, and no space
			if(curBucket == homeBucket)
				return null;
		}
		// the one is finding out, and the other is nothing
		return ht[curBucket];
	}
}
