import java.util.Arrays;

public class CDirectory extends FileEntity
{
	// storage directory and file
	private FileEntity[] list;

	private int itemCount;

	// constructor: for root directory
	public CDirectory(String name)
	{
		super(name);
		list = new FileEntity[10];
		itemCount = 0;
	}

	// constructor: for others
	public CDirectory(String name, CDirectory parentEntity)
	{
		super(name);
		list = new FileEntity[10];
		setParent(parentEntity);
		itemCount = 0;
	}

	public int getItemCount()
	{
		return itemCount;
	}

	@Override
	public String getName()
	{
		return name;
	}

	// add a directory or file
	public void addFileEntity(FileEntity entity)
	{
		if (itemCount >= list.length)
			list = Arrays.copyOf(list, itemCount * 2);
		list[itemCount++] = entity;
	}

	// judge the file exists or not in the file
	public int find(String key)
	{
		// Sequential Search
		for (int i = 0; i < itemCount; i++)
			if (list[i].getName().equals(key))
				return i;
		// don't exist
		return -1;
	}

	public CDirectory getDirectory(String key)
	{
		// judge
		int index = find(key);
		if (index == -1)
			return null;
		// judge the obj's type
		// find and return
		if (list[index] instanceof CDirectory)
			return (CDirectory) list[index];
		else
			return null;
	}

	// list all data
	public String ls()
	{
		// initialize variables
		String str = "";
		int dirCount = 0, fileCount = 0;

		for (int i = 0; i < itemCount; i++)
		{
			// directory obj
			if (list[i] instanceof CDirectory)
			{
				str += ("[" + list[i].getName() + "]" + "\n");
				dirCount++;
			}
			// file obj
			else if (list[i] instanceof CFile)
			{
				str += (list[i].getName() + "\n");
				fileCount++;
			}
		}

		// nothing
//		if (str.equals(""))
//			return "file/directory not found";

		str += "Total: " + fileCount + " files, " + dirCount + " directories\n" ;
		return str;
	}

	// search one data, and use recursion
	// tmp ->this directory | return this path
	public String[] search(CDirectory tmp, String keyword)
	{
		// storage the result
		String[] str = new String[10];
		int count = 0;
		// search the lower directory one by one
		for (int i = 0; i < tmp.itemCount; i++)
		{
			// recall string contains
			if (tmp.list[i].getName().contains(keyword))
			{
				if (count >= str.length)
					str = Arrays.copyOf(str, str.length * 2);
				// match for adding
				// look for path
				str[count++] = tmp.list[i].getPath();
			}
			// directory: dig deeper
			String[] others = {};
			if (tmp.list[i] instanceof CDirectory)
			{
				if (((CDirectory) tmp.list[i]).itemCount > 0)
					others = search((CDirectory) tmp.list[i], keyword);
			}
			for (int k = 0; k < others.length; k++)
			{
				if (count + others.length >= str.length)
					str = Arrays.copyOf(str, count + others.length);
				str[count++] = others[k];
			}
		}
		// fix the array space and return result
		str = Arrays.copyOf(str, count);
		return str;
	}

}
