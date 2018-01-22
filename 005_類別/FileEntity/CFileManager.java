
public class CFileManager
{
	// Current directory
	CDirectory curDir = null;

	// constructor: default the root directory
	public CFileManager()
	{
		curDir = new CDirectory("root");
	}

	public CDirectory getCurrentDir()
	{
		return this.curDir;
	}

	public boolean mkdir(String dirName)
	{
		if (curDir == null)
			return false;
		// no data for adding
		if (curDir.getDirectory(dirName) == null)
		{
			curDir.addFileEntity(new CDirectory(dirName, this.curDir));
			return true;
		}
		return false;
	}

	public boolean cd(String dirName)
	{
		if (curDir == null)
			return false;
		// data for entering
		CDirectory nextDir = curDir.getDirectory(dirName);
		if (nextDir != null)
		{
			this.curDir = nextDir;
			return true;
		}
		return false;
	}
	
	public boolean back()
	{
		if (curDir == null)
			return false;
		// data to back
		CDirectory perDir = curDir.parent;
		if(perDir != null)
		{
			this.curDir = perDir;
			return true;
		}
		return false;
	}

	public String ls()
	{
		if (curDir == null)
			return "";
		return curDir.ls();
	}

	public boolean touch(String dirName)
	{
		if (curDir == null)
			return false;
		// no data for adding
		if (curDir.find(dirName) == -1)
		{
			curDir.addFileEntity(new CFile(dirName, this.curDir));
			return true;
		}
		return false;
	}

	public String[] search(String keyword)
	{
		if (curDir == null)
			return null;
		return curDir.search(curDir, keyword);
	}
}
