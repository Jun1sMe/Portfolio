
public class SortList <T>
{
	T[] arr;
	int size;
	@SuppressWarnings("unchecked")	// statement: unchecked method
	public SortList()
	{
		arr = (T[]) new Object[2];
		size = 0;
	}
	public void add(T element)
	{
		if(size == arr.length)
			resize();
		arr[size++] = element;
	}
	public T get(int index)
	{
		if(index > size)
			return null;
		return arr[index];
	}
	public void bubbleSort(Compare<T> c)
	{
		for(int i = 0 ; i < size - 1 ; i++)
		{
			for(int j = 0 ; j < size - i - 1; j++)
			{
				// implement
				if(c.compare(arr[j], arr[j + 1]) > 0)
					swap(arr, j, j + 1);
			}
		}
	}
	@Override
	public String toString()
	{
		String str = "";
		for(int i = 0 ; i < size ; i++)
			str += arr[i] + " ";
		return str;
	}
	public void swap(T[] arr, int i1, int i2)
	{
		T tmp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = tmp;
	}
	public void resize()
	{
		T[] arrTmp = (T[]) new Object[size * 2];
		for(int i = 0 ; i < size ; i++)
			arrTmp[i] = arr[i];
		arr = arrTmp;
	}	
}
