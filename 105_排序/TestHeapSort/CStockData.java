
public class CStockData
{
	private String[] title;
	private String nameStock, numBroker, nameBroker;
	private int day, numStock, ticketBuy, ticketSell;
	private double price;
	// constructor for title
	public CStockData(String[] title)
	{
		this.title = title;
	}
	// constructor for other inf.
	public CStockData(int day, int numSto, String nameSto, String numBro, String nameBro, 
			double price, int ticketBuy, int ticketSell)
	{
		this.setData(day, numSto, nameSto, numBro, nameBro, price, ticketBuy, ticketSell);
	}
	public void setData(int day, int numSto, String nameSto, String numBro, String nameBro, 
			double price, int ticketBuy, int ticketSell)
	{
		this.day = day;
		this.numStock = numSto;
		this.nameStock = nameSto;
		this.numBroker = numBro;
		this.nameBroker = nameBro;
		this.price = price;
		this.ticketBuy = ticketBuy;
		this.ticketSell = ticketSell;
	}
	public double getKey(int index)
	{
		if(index == 0)	// 0: day
			return this.day;
		else		// 5: price
			return this.price;
	}
	public String getFull()
	{
		String str = "";
		if(this.title != null)	// get title
		{
			for(int i = 0 ; i < this.title.length ; i++)
			{
				if(i == 0)
					str += this.title[i];
				else
					str += "," + this.title[i]; 
			}
		}
		else		// others
		{
			str += this.day + "," + this.numStock + "," + this.nameStock + "," + this.numBroker + "," +
					this.nameBroker + "," + this.price + "," +  this.ticketBuy + "," +  this.ticketSell;
		}
		return str;
	}
	// confirm data: 8 character(year, month, day)
	public static int isDay(String day)
	{
		if(day.length() == 8)
		{
			try
			{
				int temp = Integer.parseInt(day);
				return temp;
			} catch (Exception e){}			
		}
		return -1;
	}
	// confirm numStock: 2 character
	public static int isNumStock(String num)
	{
		if(num.length() == 2)
		{
			try
			{
				int temp = Integer.parseInt(num);
				return temp;
			} catch (Exception e){}			
		}
		return -1;
	}
	// confirm price: greater than 0
	public static double isPrice(String pri)
	{
		try
		{
			double temp = Double.parseDouble(pri);
			if(temp > 0 && temp < 1000)
				return temp;
		} catch (Exception e){}	
		return -1;
	}
	// confirm ticket: natural number
	public static int isTicketBuy(String num)
	{
		try
		{
			int temp = Integer.parseInt(num);
			if(temp >= 0)
				return temp;
		} catch (Exception e){}	
		return -1;
	}
	// confirm ticket: natural number
	public static int isTicketSell(String num)
	{
		try
		{
			int temp = Integer.parseInt(num);
			if(temp >= 0)
				return temp;
		} catch (Exception e){}	
		return -1;
	}
}
