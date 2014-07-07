/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GripFab {
	protected static String[] positions = { "Full Cylinder Hole",
			"Protruded Cylinder Hole", "Straight Cylinder Barrel",
			"Angled Cylinder Barrel" };
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

	public GripFab() {
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

		// hole
		writer.println("module hole(lin,diameter){");
		writer.println("difference(){");
		writer.println("import(\"gripA.stl\");");
		writer.println("cylinder(lin,diameter/2,diameter/2);");
		writer.println("}}");

		// recHole
		writer.println("module recHole(lin,x,y){");
		writer.println("difference(){");
		writer.println("import(\"gripA.stl\");");
		writer.println("translate([-x/2,-y/2,0]) cube([x,y,lin]);");
		writer.println("}}");

		// cutBarrel to height
		writer.println("module cutB(lout){");
		writer.println("difference(){");
		writer.println("import(\"gripB.stl\");");
		writer.println("translate([0,0,-200-lout]) cylinder(200,200,200);");
		writer.println("}}");

		// straigthCyl
		writer.println("module straightCyl(lin,lout, diameter){");
		writer.println("difference(){");
		writer.println("cutB(lout);");
		writer.println("translate([0,0,-lout]) cylinder(lout+lin,diameter,diameter);");
		writer.println("}}");

		// straightRec
		writer.println("module straightRec(lin,lout,x,y){");
		writer.println("difference(){");
		writer.println("cutB(lout);");
		writer.println("translate([-x/2,-y/2,-lout]) cube([x,y,lin+lout]);");
		writer.println("}}");

		// barrelC
		writer.println("module barrelC(lout,diameter){");
		writer.println("difference(){");
		writer.println("cylinder(lout,4+diameter/2,4+diameter/2);");
		writer.println("cylinder(lout,diameter/2,diameter/2);");
		writer.println("}}");

		// angledC
		writer.println("module angledC(lout,diameter,angle){");
		writer.println("union(){");
		writer.println("import(\"gripA.stl\");");
		writer.println("mirror([0,0,1]) translate([0,0,-diameter*sin(angle)]) rotate([0,angle,0]) barrelC(lout,diameter);");
		writer.println("}}");

		// barrelR
		writer.println("module barrelR(lout,x,y){");
		writer.println("difference(){");
		writer.println("cylinder(lout,10,10);");
		writer.println("translate([-x/2,-y/2,0]) cube([x,y,lout]);");
		writer.println("}}");

		// angledR
		writer.println("module angledR(lout,x,y,angle){");
		writer.println("union(){");
		writer.println("import(\"gripA.stl\");");
		writer.println("mirror([0,0,1]) translate([0,0,-10*sin(angle)]) rotate([0,angle,0]) barrelR(lout,x,y);");
		writer.println("}}");

		// writer.println("scale([2,2,2]){");
		if (position.equals("Protruded Cylinder Hole")) {
			if (lefty)
				writer.println("mirror([0,1,0]){");
			writer.println("hole(" + lin + "," + diameter + ");");
			if (lefty)
				writer.println("}");
		} else if (position.equals("Protruded Rectangular Hole")) {
			if (lefty)
				writer.println("mirror([0,1,0]){");
			writer.println("recHole(" + lin + "," + width + "," + height + ");");
			if (lefty)
				writer.println("}");
		} else if (position.equals("Angled Cylinder Barrel")) {
			if (lefty)
				writer.println("mirror([0,1,0]){");
			writer.println("angledC(" + lout + "," + diameter + "," + angle
					+ ");");
			if (lefty)
				writer.println("}");
		} else if (position.equals("Angled Rectangular Barrel")) {
			if (lefty)
				writer.println("mirror([0,1,0]){");
			writer.println("angledR(" + lout + "," + width + "," + height + ","
					+ angle + ");");
			if (lefty)
				writer.println("}");
		} else if (position.equals("Straight Cylinder Barrel")) {
			if (lefty)
				writer.println("mirror([0,1,0]){");
			writer.println("straightCyl(" + lin + "," + lout + "," + diameter
					+ ");");
			if (lefty)
				writer.println("}");
		} else if (position.equals("Straight Rectangular Barrel")) {
			if (lefty)
				writer.println("mirror([0,1,0]){");
			writer.println("straightRec(" + lin + "," + lout + "," + width
					+ "," + height + ");");
			if (lefty)
				writer.println("}");
		} else {
			throw new PositionNotSupportedException();
		}
		writer.close();

	}

}
