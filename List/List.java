// base class
class List
{
	protected int arr[], count;

	// constructor: initialize array and property
	public List()
	{
		this.setData();
	}

	// function: reset
	public void setData()
	{
		arr = new int[10];
	}

	// function: resize
	private void resize()
	{
		int temp[] = new int[arr.length * 2];
		for (int i = 0; i < arr.length; i++)
			temp[i] = arr[i];
		arr = temp;
	}

	// function: add the value on bottom and show the result
	boolean add(int x)
	{
		if (count >= arr.length)
			resize();
		this.arr[count++] = x;
		return true;
	}

	// function: remove all of the value and show the result
	// tip: keep the sequence moving on, and release the 0
	boolean remove(int x)
	{
		// tag the index and initialize -1
		int tag = -1;
		int temp[] = new int[arr.length];
		for (int i = 0; i < count; i++)
		{
			// find the value x
			if (x == arr[i])
				tag++;
			if (tag == -1)
				temp[i] = arr[i];
			// move toward: tag from -1
			else
				temp[i] = arr[i + (tag + 1)];
		}
		arr = temp;

		// can't find the value x
		if (tag == -1)
			return false;
		return true;
	}

}

// derived class
class SearchList extends List
{
	// function: if value exists, return index. or not -1
	int search(int x)
	{
		for (int i = 0; i < this.count; i++)
		{
			// exist
			if (x == this.arr[i])
				return i;
		}
		// don't exist
		return -1;
	}

	// function: return the biggest
	int findMax()
	{
		// initialize Max value -1
		int Max = -1;
		for (int i = 0; i < this.count; i++)
		{
			if (this.arr[i] > Max)
				Max = this.arr[i];
		}
		return Max;
	}

	// function: replace the all of x to y
	boolean replace(int x, int y)
	{
		// the number of replacing
		int num = 0;
		for (int i = 0; i < this.count; i++)
		{
			if (x == this.arr[i])
			{
				this.arr[i] = y;
				num++;
			}
		}
		if (num == 0)
			return false;
		return true;
	}

}

// derived class
class AdvancedSearchList extends SearchList
{

	// function: sort List -> from small to big
	void sort()
	{
		// bubble sort
		for (int i = 1; i < this.count; i++)
		{
			for (int j = 0; j < this.count - i; j++)
			{
				if (this.arr[j] > this.arr[j + 1])
				{
					int temp = this.arr[j + 1];
					this.arr[j + 1] = this.arr[j];
					this.arr[j] = temp;
				}
			}
		}
	}

	// function: binary search -> if value exists, return index. or return -1
	int search(int x)
	{
		int right = 0, left = this.count;

		while (true)
		{
			// adjust the mid
			int mid = (right + left) / 2;

			if (x == arr[mid])
				return mid;
			if (x > arr[mid])
				left = mid + 1;
			else if (x < arr[mid])
				right = mid - 1;
			// don't exist
			if (left > right)
				return -1;
		}
	}

	// function: remove the value of index,
	// keep the sequence moving on, and release the 0
	boolean remove(int index)
	{
		// can't find the index
		if (index > count - 1 || index < 0)
			return false;

		// tag the index and initialize -1
		int tag = -1;
		int temp[] = new int[arr.length];
		for (int i = 0; i < count; i++)
		{
			if (i != index && tag == -1)
				temp[i] = arr[i];
			// move toward
			else
			{
				tag++;
				temp[i] = arr[i + 1];
			}
		}
		arr = temp;
		count--;
		return true;
	}

	// function: remove the value of previous number
	// if num is -1, remove the all
	boolean remove(int x, int num)
	{
		// tag the index and initialize -1
		int tag = -1;
		int temp[] = new int[arr.length];

		// num equals -1 or greater than count
		if (num > count || num == -1)
			num = count;
		else if (num < 1)
			return false;

		for (int i = 0, k = 0; i < count; i++)
		{
			// find the value x
			if (x == arr[i] && num-- > 0)
			{
				tag++;
				continue;
			}
			temp[k++] = arr[i];

		}
		arr = temp;
		// the rest
		count -= (tag + 1);

		// can't find the value x
		if (tag == -1)
			return false;
		return true;
	}

	// function: print
	void print()
	{
		for (int i = 0; i < this.count; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

}
