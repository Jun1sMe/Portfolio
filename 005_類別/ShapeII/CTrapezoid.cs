using System;
namespace lesson012_00B
{
    public class CTrapezoid : CShape
    {
		private double upper, lower, height;

		public CTrapezoid(double u, double l, double h) : base()
        {
            this.upper = u;
            this.lower = l;
            this.height = h;
		}
		// implement the abstract method
		override public double Area()
		{
            return (this.upper + this.lower) * this.height / 2;
		}
		override public double Perimeter()
		{
			// declare hypotenuse as hyp
            double hyp = Math.Sqrt(Math.Pow((this.lower - this.upper), 2) + Math.Pow(this.height, 2));
            return this.upper + this.lower + (hyp * 2);
        }

    }
}
