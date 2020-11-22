package cz.vesely.skola.natirani.shapes;

public class Rectangle extends Shape {

	public Rectangle(String color, int insideOf, double x, double y) {
		super(color, insideOf, x, y);
	}

	@Override
	protected double calculateArea() {
		return x * y;
	}

	@Override
	public double calculatePerimeter() {
		return 2 * x + 2 * y;
	}

}
