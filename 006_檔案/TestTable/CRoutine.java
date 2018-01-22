
public class CRoutine extends CData
{
	// 班次序，發車時間
	protected String order, departure;
	// Sun. - Sat.
	protected String[] week;

	public CRoutine(String bus, String routeNo, String branch, String round, String routeName, String stop,
			String order, String depart, String mon, String tue, String wed, String thu, String fri, String sat,
			String sun)
	{
		super(bus, routeNo, branch, round, routeName, stop);
		this.setData(order, depart, mon, tue, wed, thu, fri, sat, sun);
	}

	public void setData(String order, String depart, String mon, String tue, String wed, String thu, String fri,
			String sat, String sun)
	{
		week = new String[7];

		this.order = order;
		this.departure = depart;

		this.week[0] = mon;
		this.week[1] = tue;
		this.week[2] = wed;
		this.week[3] = thu;
		this.week[4] = fri;
		this.week[5] = sat;
		this.week[6] = sun;
	}

	public void setOrder(String order)
	{
		this.order = order;
	}

	public String getOrder()
	{
		return this.order;
	}

	public String getDeparture()
	{
		return this.departure;
	}

	public String getWeek()
	{
		String wk = "";
		for (int i = 0 ; i < this.week.length ; i++)
		{
			if(i == 0)
				wk += this.week[i];
			else
				wk += "," + this.week[i];
		}
		return wk;
	}

//	public String getTue()
//	{
//		return this.week[1];
//	}
//
//	public String getWed()
//	{
//		return this.week[2];
//	}
//
//	public String getThu()
//	{
//		return this.week[3];
//	}
//
//	public String getFri()
//	{
//		return this.week[4];
//	}
//
//	public String getSat()
//	{
//		return this.week[5];
//	}
//
//	public String getSun()
//	{
//		return this.week[6];
//	}

	public void printAll()
	{
		// 客運業者 | 路線編號 | 支線 | 往返 | 路線名稱 | 站名
		super.print();
		// 班次序 | 發車時間 | 星期一 | 星期二 | 星期三 | 星期四 | 星期五 | 星期六 | 星期日
		System.out.printf("%3s\t%4s\t%3s\t%3s\t%3s\t%3s\t%3s\t%3s\t%3s\n", order, departure, week[0], week[1], week[2], week[3], week[4],
				week[5], week[6]);
	}
}
