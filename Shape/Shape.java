// abstract: base class
abstract class Shape {
	// shared member variable
	protected double area;
	protected double perimeter;
	// abstract: function
	abstract double area();
	abstract double perimeter();
}

// derived class: Rectangle
class Rectangle extends Shape {
	private double wid, hei;
	// constructor: load the width and the height
	public Rectangle(double width, double height) {
		wid = width;
		hei = height;		
	}
	
	// implement the abstract method
	// override: area
	@Override public double area() {
		return area = wid * hei;	
	}
	// override: perimeter
	@Override public double perimeter() {
		return perimeter = 2 * (wid + hei);
	}	
}
//derived class: Circle
class Circle extends Shape {
	private double rad;
	// constant pi
	private final double pi = 3.14;
	// constructor: load the radius
	public Circle (double radius) {
		rad = radius;
	}
	
	// implement the abstract method
	// override: area
	@Override public double area() {
		return area = rad * rad * pi;	
	}
	// override: perimeter
	@Override public double perimeter() {
		return perimeter = 2 * rad * pi;
	}
}
//derived class: Trapezoid
class Trapezoid extends Shape {
	private double upp, low, hei;
	// constructor: load the upper, lower, and height	
	public Trapezoid (double upper, double lower, double height) {
		upp = upper;
		low = lower;
		hei = height;
	}
	
	// implement the abstract method
	// override: area
	@Override public double area() {
		return area = (upp + low) * hei / 2;	
	}
	// override: perimeter
	@Override public double perimeter() {
		// declare hypotenuse as hyp
		double hyp = Math.sqrt(Math.pow((low - upp), 2) + Math.pow(hei, 2));	
		return perimeter = upp + low + (hyp * 2);
	}
}
