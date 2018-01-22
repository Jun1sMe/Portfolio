/*
 * record route
 */
public class CData
{
	// 客運業者，路線編號，支線，往返，路線名稱，站名
	protected String bus, routeNo, branch, round, routeName, stop;

	public CData(String bus, String routeNo, String branch, String round, String routeName, String stop)
	{
		this.setData(bus, routeNo, branch, round, routeName, stop);
	}

	public void setData(String bus, String routeNo, String branch, String round, String routeName, String stop)
	{
		this.bus = bus;
		this.routeNo = routeNo;
		this.branch = branch;
		this.round = round;
		this.routeName = routeName;
		this.stop = stop;
	}

	public String getName()
	{
		return this.routeName;
	}
	public String getStop()
	{
		return this.stop;
	}
	
	public String getQuarRoute()
	{
		return routeNo + branch;
	}
	public String getHalfRoute()
	{
		return bus + routeNo + branch + round;
	}
	// get route data
	public String getRoute()
	{
		return bus + "," + routeNo + "," + branch + "," + round + "," + routeName + "," + stop;
	}

	public void print()
	{
		// 客運業者 | 路線編號 | 支線 | 往返 | 路線名稱 | 站名
		System.out.printf("%4s\t%5s\t%2s\t%2s\t%14s\t%4s\t", bus, routeNo, branch, round, routeName, stop);
	}
}
