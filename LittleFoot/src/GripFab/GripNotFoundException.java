package GripFab;

public class GripNotFoundException extends Exception {
	GripNotFoundException(){
		super("Grip Type is not available. Please choose different Grip type.");
	}
}
