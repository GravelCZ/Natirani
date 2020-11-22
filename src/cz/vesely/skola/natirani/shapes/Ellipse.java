package cz.vesely.skola.natirani.shapes;

public class Ellipse extends Shape {

	public Ellipse(String color, int insideOf, double x, double y) {
		super(color, insideOf, x, y);
	}

	@Override
	protected double calculateArea() {
		return Math.PI * x * y;
	}

	@Override
	public double calculatePerimeter() {
		if (x == y) {
			return 2 * Math.PI * x;
		} else {
			// There is no equation for the area of an ellipse, we can only estimate. Here I am using method by Ramanujan
			double h = Math.pow((x - y), 2) / Math.pow((x + y), 2);
			double p = Math.PI * (x + y) * (1 + (3 * h / (10 + Math.sqrt(4 - 3 * h))));
			
			return p;
		}
	}

}
