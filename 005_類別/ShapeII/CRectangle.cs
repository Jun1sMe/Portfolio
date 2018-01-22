using System;
namespace lesson012_00B
{
    public class CRectangle : CShape
    {
        private double length, width;

        public CRectangle(double l, double w) : base()
        {
            this.length = l;
            this.width = w;
        }
		// implement the abstract method
		override public double Area()
        {
            return this.length * this.width;
        }
        override public double Perimeter()
        {
            return (this.length + this.width) * 2;
        }
    }
}
