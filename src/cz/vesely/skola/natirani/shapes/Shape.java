package cz.vesely.skola.natirani.shapes;

public abstract class Shape {

	private int insideOf;
	protected double x, y;
	private double calculatedArea;
	private String color;
	
	public Shape(String color, int insideOf, double x, double y) {
		this.color = color;
		this.insideOf = insideOf;
		this.x = x;
		this.y = y;
		
		this.calculatedArea = calculateArea();
	}
	
	protected abstract double calculateArea();
	
	public abstract double calculatePerimeter();
	
	public double getCalculatedArea() {
		return calculatedArea;
	}
	
	public void setCalculatedArea(double calculatedArea) {
		this.calculatedArea = calculatedArea;
	}
	
	public String getColor() {
		return color;
	}

	public int getInsideOf() {
		return insideOf;
	}
	
}
