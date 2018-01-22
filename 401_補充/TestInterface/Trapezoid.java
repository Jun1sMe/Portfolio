
public class Trapezoid implements Shape
{
	private float upper, lower, height;
	public Trapezoid(float upper, float lower, float height)
	{
		this.upper = upper;
		this.lower = lower;
		this.height = height;
	}
	@Override
	public String getAttributes()
	{
		return "Upper: " + upper + "\nLower: " + lower + "\nHeight: " + height + "\n";
	}
	@Override
	public float getArea()
	{
		return (upper + lower) * height / 2;
	}
	@Override
	public float getPerimeter()
	{
		float edge = (float) Math.sqrt(Math.pow(height, 2) - Math.pow(lower - upper, 2));
		return upper + lower + edge * 2;
	}

}
