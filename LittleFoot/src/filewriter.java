import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class filewriter {
	protected String stlTitle;
	protected boolean lefty;
	protected double diameter; // in mm
	protected double length; // in mm
	protected double angle; // in degrees
	protected String position; // a, b, c: add more as needed
	protected String filename;// concatinates .scad to end of given name

	public filewriter(String stl, boolean l, double d, double le, double a,
			String pos, String fn) {
		stlTitle = stl;
		lefty = l;
		diameter = d;
		length = le;
		angle = a;
		position = pos;
		filename = fn + ".scad";
	}
	public filewriter(){
		stlTitle = "gripA.stl";
		lefty=false;
		diameter =5;
		length=100;
		angle=0;
		position="a";
		filename="gripFile.scad";
	}
	
	

	public void writefile() throws PositionNotSupportedException, FileNotFoundException {

		PrintWriter writer = new PrintWriter(filename);

		// basic hole module for difference()
		writer.println("module hole(length,diameter){");
		writer.println("cylinder(length,diameter/2,diameter/2);");
		writer.println("}");

		// type qualifications
		// position A (all the way through top area
		if (position.equals("a")) {
			writer.println("module holeA(){");
			writer.println("difference(){");
			writer.println("import(\"" + stlTitle + "\");");
			writer.println("hole(62," + diameter + ");");
			writer.println("}}");
			writer.println("holeA();");
		} else {
			throw new PositionNotSupportedException();
		}
		writer.close();

	}

	public static void main(String[] args) {
		filewriter writer = new filewriter();
		try {
			writer.writefile();
		} catch (FileNotFoundException | PositionNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
