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
	protected double angle;

	public filewriter(String stl, boolean l, double d, double out, double in,
			String pos, String fn, double a) {
		stlTitle = stl;
		lefty = l;
		diameter = d;
		lout = out;
		lin = in;
		position = pos;
		filename = fn + ".scad";
		angle=a;
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

	@SuppressWarnings("resource")
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
		writer.println("translate([0,0,-length]) cylinder(length+1,(8+diameter)/2,(8+diameter)/2);");
		writer.println("translate([0,0,-length]) cylinder(length+1,diameter/2,diameter/2);");
		writer.println("}}");

		//writer.println("scale([2,2,2]){");
		if (position.equals("a")) {// all the way through
			if (lefty)
				writer.println("mirror([1,0,0]){");
			writer.println("protrusion(65," + diameter + ");");
			if (lefty)
				writer.println("}");
		} else if (position.equals("b")) {// Protrusion
			if (lefty)
				writer.println("mirror([1,0,0]){");
			writer.println("protrusion(" + lin + "," + diameter + ");");
			if (lefty)
				writer.println("}");
		} else if (position.equals("c")) {// protrusion and barrel
			if (lefty)
				writer.println("mirror([1,0,0]){");
			writer.println("translate([0,0,43]) rotate([180,0,0]) union(){");
			writer.println("protrusion(" + lin + "," + diameter + ");");
			writer.println("barrelA(" + lout + "," + diameter + ");");
			writer.println("}");
			if (lefty)
				writer.println("}");
		}  else if (position.equals("d")) {// protrusion and barrel
			if (lefty)
				writer.println("mirror([1,0,0]){");
			writer.println("translate([0,0,43]) rotate([180,0,0]) union(){");
			writer.println("protrusion(" + lin + ",0);");
			writer.println("translate([0,0,"+extension()+ "]) rotate([0,"+ angle +",0,]) barrelA(" + (lout+heightA()) + "," + diameter + ");");
			writer.println("}");
			if (lefty)
				writer.println("}");
		} else {
			throw new PositionNotSupportedException();
		}
		writer.close();

	}
	
	private double heightA(){
		return diameter*Math.sin(angle);
	}
	private double extension(){
		return diameter*Math.cos(angle);
	}

	public static void main(String[] args) {
		filewriter writer = new filewriter();
		try {
			writer.writefile();
		} catch (FileNotFoundException | PositionNotSupportedException e) {
			e.printStackTrace();
		}

	}

}
