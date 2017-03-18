package polymorphisim.shape;

public class Shapes {
	private static RandomShapeGenerator gen = new RandomShapeGenerator();
	
	public static void main(String[] args) {
		Shape[] s = new Shape[9];
		
		//file up the array with shapes
		for (int i =0; i < s.length; i++) {
			s[i] = gen.next();
		}
		
		//make polymorphic method calls
		for (Shape shp : s) {
			shp.draw();
		}
	}
}