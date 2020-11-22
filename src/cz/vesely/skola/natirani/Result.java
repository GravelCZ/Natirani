package cz.vesely.skola.natirani;

import java.util.HashMap;

public class Result {
	
	private double area, perimeter;
	private HashMap<String, Double> areasOfColors;
	
	public Result(double area, double perimeter, HashMap<String, Double> map) {
		this.area = area;
		this.areasOfColors = map;
		this.perimeter = perimeter;
	}
	
	public double getPerimeter() {
		return perimeter;
	}
	
	public double getArea() {
		return area;
	}
	
	public HashMap<String, Double> getAreasOfColors() {
		return areasOfColors;
	}
	
}