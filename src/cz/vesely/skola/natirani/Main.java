package cz.vesely.skola.natirani;

import java.io.File;
import java.util.List;
import java.util.Map.Entry;

import cz.vesely.skola.natirani.shapes.Shape;

public class Main {

	public static void main(String[] args) {
		File in = new File("./input.txt");
		if (!in.exists()) {
			System.out.println("File input.txt not found");
			return;
		}
		
		try {
			List<String> lines = Loader.loadLines(in);
			List<Shape> shapes = Parser.parseLines(lines);
			
			Result result = AreaSummer.calculate(shapes);

			double totalAmountColor = 0.0;
			
			StringBuilder sb = new StringBuilder("We have to buy ");
			for (Entry<String, Double> e : result.getAreasOfColors().entrySet()) {
				// ceil because we want a spare and not to have missing
				double colorAmount = Math.ceil(e.getValue() / 10.0);
				totalAmountColor += colorAmount;
				sb.append(colorAmount).append(" ").append(e.getKey()).append(" crayons, ");
			}
			
			// yes, yes I know that %s is NOT for numbers but it is the only easy way I can make it put a dot instead of a comma, so here it will stay
			System.out.println(String.format("For painting the area we will need %s amount color", totalAmountColor));
			System.out.println(String.format("Calculated perimeter: %s", result.getPerimeter()));
			
			System.out.println(sb.toString());
		} catch (Exception e) {
			// we don't want to see the whole exception, it might scare the user (perhaps a good thing so that they know they messed up)
			// for now i just print the cause of the exception
			System.out.println(e.getMessage());
		}
	}

}
