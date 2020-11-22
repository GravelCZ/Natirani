package cz.vesely.skola.natirani.shapes;

public enum ShapeType {

	RECTANGLE(/*Rectangle.class*/) {
		@Override
		public Shape newInstance(String color, int insideOf, double x, double y) {
			return new Rectangle(color, insideOf, x, y);
		}
	},
	SQUARE(/*Rectangle.class*/) {
		@Override
		public Shape newInstance(String color, int insideOf, double x, double y) {
			return new Rectangle(color, insideOf, x, x); // yes, both arguments have to be x
		}
	}, 
	ELLIPSE(/*Ellipse.class*/) {
		@Override
		public Shape newInstance(String color, int insideOf, double x, double y) {
			return new Ellipse(color, insideOf, x, y);
		}
	}, 
	CIRCLE(/*Ellipse.class*/) {
		@Override
		public Shape newInstance(String color, int insideOf, double x, double y) {
			return new Ellipse(color, insideOf, x, x); // yes, both arguments have to be x 
		}
	}, 
	TRIANGLE(/*Triangle.class*/) {
		@Override
		public Shape newInstance(String color, int insideOf, double x, double y) {
			return new Triangle(color, insideOf, x, y);
		}
	};
	
	// originally i used reflection but because of readabliity of code and the fact that mistakes in reflection are noticed only on runtime
	// i decided to just use an abstact method
	/*private Class<?> clazz;
	
	private ShapeType(Class<?> clazz) {
		this.clazz = clazz;
	}*/
	
	public abstract Shape newInstance(String color, int insideOf, double x, double y);
	
	/*public Shape newInstance(String color, int insideOf, double x, double y) {
		try {
			Constructor<?> cons = clazz.getConstructor(String.class, int.class, double.class, double.class);
			return (Shape) cons.newInstance(color, insideOf, x, y);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}*/
	
}
