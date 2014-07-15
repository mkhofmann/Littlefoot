/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * GripFab processing class: Contains data about grips being developed and
 * processes information for file output.
 * 
 * @author Megan K. Hofmann
 * 
 */
public class GripFab {
	/**
	 * directory selected for file outputs
	 */
	protected String directory = "";
	/**
	 * name of files to be output
	 */
	protected String name = "";
	/**
	 * positions available for printing
	 */
	protected static String[] positions = { "Full Cylinder Hole",
			"Protruded Cylinder Hole", "Straight Cylinder Barrel",
			"Angled Cylinder Barrel" };
	protected boolean lefty = false;
	protected double diameter = 0; // in mm
	protected double lout = 0; // length out of grip (in mm)
	protected double lin = 0; // length into grip (in mm)
	protected String position = ""; // a, b, c: add more as needed
	protected double angle = 0;
	protected double width = 0;
	protected double height = 0;

	private boolean throwDiameter = false;
	private boolean throwDims = false;

	protected GripFab() {

	}

	@SuppressWarnings("resource")
	protected void writefile() throws PositionNotSupportedException,
			invalidDiameterException, STLNotPresentException,
			invalidDimmensionsException, IOException, InterruptedException {
		if (diameter > 16) {
			diameter = 16;
			throwDiameter = true;
		}
		if (width > 13) {
			width = 13;
			throwDims = true;
		}
		if (height > 13) {
			height = 13;
			throwDims = true;
		}
		PrintWriter writer = new PrintWriter(directory + "\\" + name + ".scad");

		// variables
		writer.println("position = \"" + position + "\";");
		writer.println("diameter =" + diameter + ";");
		writer.println("x=" + width + ";");
		writer.println("y=" + height + ";");
		writer.println("lin=" + lin + ";");
		writer.println("lout=" + lout + ";");
		writer.println("angle=" + angle + ";");
		// hole
		writer.println("module hole(){");
		writer.println("difference(){");
		writer.println("import(\"contractureA.stl\");");
		writer.println("cylinder(lin,diameter/2,diameter/2);");
		writer.println("}}");

		// recHole
		writer.println("module recHole(){");
		writer.println("difference(){");
		writer.println("import(\"contractureA.stl\");");
		writer.println("translate([-x/2,-y/2,0]) cube([x,y,lin]);");
		writer.println("}}");

		// cutBarrel to height
		writer.println("module cutB(){");
		writer.println("difference(){");
		writer.println("import(\"contractureB.stl\");");
		writer.println("translate([0,0,-200-lout]) cylinder(200,200,200);");
		writer.println("}}");

		// straigthCyl
		writer.println("module straightCyl(){");
		writer.println("difference(){");
		writer.println("cutB(lout);");
		writer.println("translate([0,0,-lout]) cylinder(lout+lin,diameter,diameter);");
		writer.println("}}");

		// straightRec
		writer.println("module straightRec(){");
		writer.println("difference(){");
		writer.println("cutB(lout);");
		writer.println("translate([-x/2,-y/2,-lout]) cube([x,y,lin+lout]);");
		writer.println("}}");

		// barrelC
		writer.println("module barrelC(){");
		writer.println("difference(){");
		writer.println("cylinder(lout,4+diameter/2,4+diameter/2);");
		writer.println("cylinder(lout,diameter/2,diameter/2);");
		writer.println("}}");

		// angledC
		writer.println("module angledC(){");
		writer.println("union(){");
		writer.println("import(\"contractureA.stl\");");
		writer.println("mirror([0,0,1]) translate([0,0,-diameter*sin(angle)]) rotate([0,angle,0]) barrelC(lout,diameter);");
		writer.println("}}");

		// barrelR
		writer.println("module barrelR(){");
		writer.println("difference(){");
		writer.println("cylinder(lout,10,10);");
		writer.println("translate([-x/2,-y/2,0]) cube([x,y,lout]);");
		writer.println("}}");

		// angledR
		writer.println("module angledR(){");
		writer.println("union(){");
		writer.println("import(\"contractureA.stl\");");
		writer.println("mirror([0,0,1]) translate([0,0,-10*sin(angle)]) rotate([0,angle,0]) barrelR(lout,x,y);");
		writer.println("}}");

		writer.println("render(1){");
		if (position.equals("Protruded Cylinder Hole")) {
			if (lefty)
				writer.println("mirror([0,1,0]){");
			writer.println("hole();");
			if (lefty)
				writer.println("}");
		} else if (position.equals("Protruded Rectangular Hole")) {
			if (lefty)
				writer.println("mirror([0,1,0]){");
			writer.println("recHole();");
			if (lefty)
				writer.println("}");
		} else if (position.equals("Angled Cylinder Barrel")) {
			if (lefty)
				writer.println("mirror([0,1,0]){");
			writer.println("angledC();");
			if (lefty)
				writer.println("}");
		} else if (position.equals("Angled Rectangular Barrel")) {
			if (lefty)
				writer.println("mirror([0,1,0]){");
			writer.println("angledR();");
			if (lefty)
				writer.println("}");
		} else if (position.equals("Straight Cylinder Barrel")) {
			if (lefty)
				writer.println("mirror([0,1,0]){");
			writer.println("straightCyl();");
			if (lefty)
				writer.println("}");
		} else if (position.equals("Straight Rectangular Barrel")) {
			if (lefty)
				writer.println("mirror([0,1,0]){");
			writer.println("straightRec();");
			if (lefty)
				writer.println("}");
		} else {
			throw new PositionNotSupportedException();
		}
		writer.println("}");

		if (throwDiameter)
			throw new invalidDiameterException();
		if (throwDims)
			throw new invalidDimmensionsException();
		writer.close();
	}

	protected void writeSTL() throws IOException {
		Runtime.getRuntime().exec(
				"cmd.exe /c start " + directory + "\\export.bat " + directory
						+ " " + name + ".stl " + name + ".scad");
	}

	protected void writeProfile() throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(directory + "\\" + name + ".txt");
		writer.println(position);
		writer.flush();
		writer.println(diameter);
		writer.flush();
		writer.println(width);
		writer.flush();
		writer.println(height);
		writer.flush();
		writer.println(lin);
		writer.flush();
		writer.println(lout);
		writer.flush();
		writer.println(angle);
		writer.flush();
		writer.println(lefty);
		writer.flush();
		writer.close();

	}

	protected void readProfile(File profile) throws NumberFormatException,
			IOException {
		BufferedReader reader = new BufferedReader(new FileReader(profile));
		position = reader.readLine();
		diameter = Double.parseDouble(reader.readLine());
		width = Double.parseDouble(reader.readLine());
		height = Double.parseDouble(reader.readLine());
		lin = Double.parseDouble(reader.readLine());
		lout = Double.parseDouble(reader.readLine());
		angle = Double.parseDouble(reader.readLine());
		lefty = Boolean.parseBoolean(reader.readLine());
		reader.close();
	}

	protected void printFromProfile(File profile) throws NumberFormatException,
			IOException, PositionNotSupportedException,
			invalidDiameterException, STLNotPresentException,
			invalidDimmensionsException {
		readProfile(profile);

	}

	protected void processFileName(String filename) {
		directory = filename.substring(0, filename.lastIndexOf("\\")) + "\\";
		name = filename.substring(filename.lastIndexOf("\\"),
				filename.lastIndexOf("."));

	}

	// public static void main(String[] args){
	// GripFab gripFab = new GripFab();
	// grripFab.writeFile();
	//
	// }
}
