using System;
namespace lesson012_00B
{
    public class CCircle : CShape
    {
        private double radius;

        public CCircle(double r) : base()
        {
            this.radius = r;
        }
		// implement the abstract method
		override public double Area()
        {
            return Math.PI * Math.Pow(this.radius, 2);
        }
        override public double Perimeter()
        {
            return Math.PI * this.radius * 2;
        }
    }
}
