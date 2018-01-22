/*
 * determine time
 */
public class CTime
{
	protected int hour;
	protected int minute;

	public CTime(int h, int m)
	{
		this.setData(h, m);
	}

	// initialize
	public void setData(int h, int m)
	{
		if (m >= 0 && m <= 59)
			this.minute = m;
		else
			this.minute = 0;
		if (h >= 0 && h <= 23)
		{
			if (m == 60)
			{
				this.hour = h + 1;
			}
			else
				this.hour = h;
		} 
		else
			this.hour = 0;
		
		// 2400 equals 0000
		if ((h == 24 && m == 0) || (this.hour == 24 && this.minute == 0))
		{
			this.hour = 0;
			this.minute = 0;
		}
	}

	public static boolean isValid(int h, int m)
	{
		if (h >= 0 && h <= 23 && m >= 0 && m <= 60)
			return true;
		// the last 2400
		else if (h == 24 && m == 0)
			return true;
		return false;
	}

	public String getTime()
	{
		if (this.minute < 10)
			return this.hour + "0" + this.minute;
		return this.hour + "" + this.minute;
	}
}
