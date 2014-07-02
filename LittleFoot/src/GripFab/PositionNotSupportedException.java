package GripFab;

public class PositionNotSupportedException extends Exception{

	public PositionNotSupportedException() {
		super("Position Not supported, Please try a new position.");
	}

}
