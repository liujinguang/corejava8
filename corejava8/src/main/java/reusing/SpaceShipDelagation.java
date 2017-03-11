package reusing;

public class SpaceShipDelagation {
	public SpaceShipDelagation(String name) {
		this.name = name;
	}
	
	private String name;
	private SpaceShipControls controls = new SpaceShipControls();
}
