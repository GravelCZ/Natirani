package cz.vesely.skola.natirani;

import java.util.ArrayList;
import java.util.List;

import cz.vesely.skola.natirani.shapes.Shape;
import cz.vesely.skola.natirani.shapes.ShapeType;

public class Parser {
	
	public static List<Shape> parseLines(List<String> lines) throws Exception {
		List<Shape> shapes = new ArrayList<>();
		for (int i = 0; i < lines.size(); i++) {
			String[] args = lines.get(i).split(" ");
			if (args.length < 4 || args.length > 5) {
				throw new Exception("Invalid line: " + (i + 1));
			}
			String shapeRaw = args[0].toUpperCase();
			ShapeType shape = ShapeType.valueOf(shapeRaw); // throws IllegalArgumentException
			
			String color = args[1].toLowerCase(); // So that "RED", "red" and "Red" is taken as the same color
			int idInside = Integer.valueOf(args[2]);
			double x = Double.parseDouble(args[3]);
			double y = 0.0;
			
			if (args.length == 4) {
				if (shape != ShapeType.CIRCLE && shape != ShapeType.SQUARE) {
					throw new Exception("Invalid line: " + (i + 1));
				}
			} else {
				y = Double.parseDouble(args[4]);
			}
			
			shapes.add(shape.newInstance(color, idInside, x, y));
		}
		return shapes;
	}

}
