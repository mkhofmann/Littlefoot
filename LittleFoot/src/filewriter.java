import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class filewriter {
	protected String stlTitle;
	protected boolean lefty;
	protected double diameter; // in mm
	protected double lout; // length out of grip (in mm)
	protected double lin; // length into grip (in mm)
	protected String position; // a, b, c: add more as needed
	protected String filename;// concatinates .scad to end of given name

	public filewriter(String stl, boolean l, double d, double out, double in,
			String pos, String fn) {
		stlTitle = stl;
		lefty = l;
		diameter = d;
		lout = out;
		lin = in;
		position = pos;
		filename = fn + ".scad";
	}

	public filewriter() {
		stlTitle = "gripA.stl";
		lefty = false;
		diameter = 5;
		lout = 10;
		lin = 62;
		position = "a";
		filename = "gripFile.scad";
	}

	public void writefile() throws PositionNotSupportedException,
			FileNotFoundException {

		PrintWriter writer = new PrintWriter(filename);

		// basic hole module for difference()
		writer.println("module hole(length,diameter){");
		writer.println("cylinder(length,diameter/2,diameter/2);");
		writer.println("}");

		// stl protrusion
		writer.println("module protrusion(length,diameter){");
		writer.println("difference(){");
		writer.println("import(\"" + stlTitle + "\");");
		writer.println("hole(length,diameter);");
		writer.println("}}");

		// barrelA
		writer.println("module barrelA(length,diameter){");
		writer.println("difference(){");
		writer.println("translate([0,0,-length]) cylinder(length+1,(1+diameter)/2,(1+diameter)/2);");
		writer.println("translate([0,0,-length]) cylinder(length+1,diameter/2,diameter/2);");
		writer.println("}}");

		// type qualifications
		// position A (all the way through top area
		if (position.equals("a")) {
			if (lefty)
				writer.println("mirror([1,0,0]){");
			writer.println("protrusion(62," + diameter + ");");
			if (lefty)
				writer.println("}");
		} else if (position.equals("b")) {
			if (lefty)
				writer.println("mirror([1,0,0]){");
			writer.println("protrusion(" + lin + "," + diameter + ");");
			if (lefty)
				writer.println("}");
		} else if (position.equals("c")) {
			if (lefty)
				writer.println("mirror([1,0,0]){");
			writer.println("union(){");
			writer.println("protrusion(" + lin + "," + diameter + ");");
			writer.println("barrelA(" + lout + "," + diameter + ");");
			writer.println("}");
			if (lefty)
				writer.println("}");
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
