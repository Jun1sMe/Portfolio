
public class Circle implements Shape
{
	private static final float pi = 3.14f;
	private float r;
	public Circle(float r)
	{
		this.r = r;
	}
	@Override
	public String getAttributes()
	{
		return "Radius: " + r + "\n";
	}
	@Override
	public float getArea()
	{
		return r * r * pi;
	}
	@Override
	public float getPerimeter()
	{
		return 2 * r * pi;
	}
}
