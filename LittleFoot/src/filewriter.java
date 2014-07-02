import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class filewriter {
	protected static String[] positions = { "Full Cylinder Hole", "Protruded Cylinder Hole", "Straight Cylinder Barrel","Angled Cylinder Barrel" };
	protected String stlTitle;
	protected boolean lefty;
	protected double diameter; // in mm
	protected double lout; // length out of grip (in mm)
	protected double lin; // length into grip (in mm)
	protected String position; // a, b, c: add more as needed
	protected String filename;// Concatenates .scad to end of given name
	protected double angle;
	protected double width;
	protected double height;

	public filewriter() {
		stlTitle = "gripA.stl";
		lefty = false;
		diameter = 0;
		lout = 0;
		lin = 0;
		angle = 0;
		width = 0;
		height = 0;
		position = "a";
		filename = "grip.scad";
	}

	@SuppressWarnings("resource")
	public void writefile() throws PositionNotSupportedException,
			FileNotFoundException, invalidDiameterException,
			STLNotPresentException {

		PrintWriter writer = new PrintWriter(filename);
		// File stlTest = new File(stlTitle);
		// if(!stlTest.exists() || stlTest.isDirectory())
		// throw new STLNotPresentException();
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
		writer.println("translate([0,0,-length]) cylinder(length+1,(6+diameter)/2,(6+diameter)/2);");
		writer.println("translate([0,0,-length]) cylinder(length+1,diameter/2,diameter/2);");
		writer.println("}}");

		// rectangular attachment
		writer.println("module rectangular(length, width,height){");
		writer.println("translate([-width/2-3,-height/2-3,-length])linear_extrude(length){");
		writer.println("difference(){");
		writer.println("square([width+6,height+6]);");
		writer.println("translate([3,3,0]) square([width,height]);");
		writer.println("}}}");

		// writer.println("scale([2,2,2]){");
		if (position.equals("Full hole")) {// all the way through
			if (diameter > 16 || diameter <= 0)
				throw new invalidDiameterException();
			if (lefty)
				writer.println("mirror([1,0,0]){");
			writer.println("protrusion(65," + diameter + ");");
			if (lefty)
				writer.println("}");
		} else if (position.equals("Protruded hole")) {// Protrusion
			if (diameter > 16 || diameter <= 0)
				throw new invalidDiameterException();
			if (lefty)
				writer.println("mirror([1,0,0]){");
			writer.println("protrusion(" + lin + "," + diameter + ");");
			if (lefty)
				writer.println("}");
		} else if (position.equals("Straight Barrel")) {// protrusion and barrel
			if (diameter > 13 || diameter <= 0)
				throw new invalidDiameterException();
			if (lefty)
				writer.println("mirror([1,0,0]){");
			writer.println("translate([0,0,65]) rotate([180,0,0]) union(){");
			writer.println("protrusion(" + lin + "," + diameter + ");");
			writer.println("barrelA(" + lout + "," + diameter + ");");
			writer.println("}");
			if (lefty)
				writer.println("}");
		} else if (position.equals("d")) {// angled barrel
			if (lefty)
				writer.println("mirror([1,0,0]){");
			writer.println("translate([0,0,43]) rotate([180,0,0]) union(){");
			writer.println("import(\"gripA.stl\");");
			writer.println("translate([0,0," + extension() + "]) rotate([0,"
					+ angle + ",0,]) barrelA(" + (lout + heightA()) + ","
					+ diameter + ");");
			writer.println("}");
			if (lefty)
				writer.println("}");
		} else if (position.equals("e")) {// protrusion and barrel
			if (lefty)
				writer.println("mirror([1,0,0]){");
			writer.println("translate([0,0,43]) rotate([180,0,0]) union(){");
			writer.println("import(\"gripA.stl\");");
			writer.println("rectangular("+lout+","+width+","+height+");");
			writer.println("}");
			if (lefty)
				writer.println("}");
		} else {
			throw new PositionNotSupportedException();
		}
		writer.close();

	}

	private double heightA() {
		return diameter * Math.sin(angle);
	}

	private double extension() {
		return diameter * Math.cos(angle);
	}

}
