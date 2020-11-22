package cz.vesely.skola.natirani;

import java.util.HashMap;
import java.util.List;

import cz.vesely.skola.natirani.shapes.Shape;

public class AreaSummer {

	public static Result calculate(List<Shape> shapes) throws Exception {
		// change the shape size depending on other shapes
		// only works when one shape is inside another
		// basically you cannot have a shape(1) inside of another shape(2) if that shape(1) has other shapes inside of it
		// you cannot have a square in a square in a square
		// well, you can you just need to put them in the correct order, not always guaranteed
		// yes, i could build some kind of tree and calculate from that but there might be problems with infinite recursion, 
		// like shape A is inside of shape B and shape B in inside of shape C and shape C is inside of shape A
		for (int i = 0; i < shapes.size(); i++) {
			Shape shape = shapes.get(i);
			//make sure that we ignore shapes that are not inside another one (-1) or have invalid value
			if (shape.getInsideOf() <= -1) {
				continue;
			}
			if (shape.getInsideOf() >= shapes.size()) {
				throw new Exception("Shape cannot be inside of another shape that does not exist.");
			}
			
			if (i == shape.getInsideOf()) {
				throw new Exception("Shape cannot be inside of itself");
			}
			
			//get the shape we want to modify
			Shape s = shapes.get(shape.getInsideOf());
			
			// get the areas of the modified shape and the one that will be used for modifying
			double area = shape.getCalculatedArea();
			double originalArea = s.getCalculatedArea();
			
			if (area > originalArea) {
				throw new Exception("Bigger shapes cannot be inside smaller shapes.");
			}
			
			s.setCalculatedArea(originalArea - area);
		}
		
		//this does it's job perfectly, but I don't like it here, it just looks... wrong... and ugly
		HashMap<String, Double> colors = new HashMap<>();
		
		double perimeterSum = 0.0;
		//sum of the area of all the objects
		double areaTotalSum = 0.0;
		
		for (Shape shape : shapes) {
			String color = shape.getColor();
			
			double currentColorArea = 0;
			double shapeArea = shape.getCalculatedArea();
			
			if (colors.containsKey(color)) {
				currentColorArea = colors.get(color);
			} else {
				colors.put(color, 0d);
				currentColorArea = 0;
			}
			
			currentColorArea += shapeArea;
			areaTotalSum += shapeArea;
			perimeterSum += shape.calculatePerimeter();
			
			colors.put(color, currentColorArea);
		}
		
		return new Result(areaTotalSum, perimeterSum, colors);
	}
	
}
