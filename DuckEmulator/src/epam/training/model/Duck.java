package epam.training.model;

public class Duck {

	public final static String symbol = "U";
    private int lengthStep = 1;
	private Position position;
	
	public Duck() {
		super();
	}
	
	public Duck(Position position) {
		this.position = position;
	}
	public void goUp() {
		int y = position.getY();
		position.setY(y -= lengthStep);
	}
	public void goDown() {
		int y = position.getY();
		position.setY(y += lengthStep);
	}
	
	public void goRight() {
		int x = position.getX();
		position.setX(x += lengthStep);
	}

	public void goLeft() {
		int x = position.getX();
		position.setX(x -= lengthStep);
	}
	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getLengthStep() {
		return lengthStep;
	}

	public void setLengthStep(int lengthStep) {
		this.lengthStep = lengthStep;
	}
}
