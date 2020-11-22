package cz.vesely.skola.natirani.shapes;

public class Triangle extends Shape {

	public Triangle(String color, int insideOf, double x, double y) {
		super(color, insideOf, x, y);
	}
	
	@Override
	protected double calculateArea() {
		// only for right angle triangle
		return (x * y) / 2;
	}

	@Override
	public double calculatePerimeter() {
		// only for right angle triangle
		return Math.sqrt(x * x + y * y);
	}

}
