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
import java.io.PrintWriter;

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

	protected Object[] barrelList = { "None", "Straight", "Angled" };
	protected String[] holeList = { "Circle", "Rectangle" };
	/**
	 * determines if grip should be mirrored for left handed users
	 */
	protected boolean lefty = false;
	/**
	 * diameter of cylindrical extensions: in mm
	 */
	protected double diameter = 0;
	/**
	 * barrel length: in mm
	 */
	protected double lout = 0;
	/**
	 * grip depth: in mm
	 */
	protected double lin = 0;
	/**
	 * hole type of grip: Must match a value in extensions[]
	 */
	protected String hole = "";
	protected String barrel = "";
	/**
	 * Angle from 0 to 90 degrees for direction of barrel
	 */
	protected double angle = 0;
	/**
	 * width of rectangular holes in mm
	 */
	protected double width = 0;
	/**
	 * heigth of rectangular holes in mm
	 */
	protected double height = 0;

	protected GripFab() {

	}

	/**
	 * Writes a openscad file to given directory with given name and preset
	 * variables.
	 * 
	 * @throws PositionNotSupportedException
	 * @throws invalidDiameterException
	 * @throws STLNotPresentException
	 * @throws invalidDimmensionsException
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws GripNotFoundException
	 */
	protected void writefile() throws PositionNotSupportedException,
			invalidDiameterException, STLNotPresentException,
			invalidDimmensionsException, IOException, InterruptedException {
		PrintWriter writer = new PrintWriter(directory + "\\" + name + ".scad");

		// variables
		writer.println("hole = \"" + hole + "\";");
		writer.println("barrel = \"" + barrel + "\";");
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
		if (hole.equals(holeList[0])) {
			if (barrel.equals(barrelList[0])) {
				if (lefty)
					writer.println("mirror([0,1,0]){");
				writer.println("hole();");
				if (lefty)
					writer.println("}");
			} else if (barrel.equals(barrelList[1])) {
				if (lefty)
					writer.println("mirror([0,1,0]){");
				writer.println("straightCyl();");
				if (lefty)
					writer.println("}");
			} else if (barrel.equals(barrelList[2])) {
				if (lefty)
					writer.println("mirror([0,1,0]){");
				writer.println("angledC();");
				if (lefty)
					writer.println("}");
			} else {
				throw new PositionNotSupportedException();
			}
		} else if (hole.equals(holeList[1])) {
			if (barrel.equals(barrelList[0])) {
				if (lefty)
					writer.println("mirror([0,1,0]){");
				writer.println("recHole();");
				if (lefty)
					writer.println("}");
			} else if (barrel.equals(barrelList[1])) {
				if (lefty)
					writer.println("mirror([0,1,0]){");
				writer.println("straightRec();");
				if (lefty)
					writer.println("}");
			} else if (barrel.equals(barrelList[2])) {
				if (lefty)
					writer.println("mirror([0,1,0]){");
				writer.println("angledR();");
				if (lefty)
					writer.println("}");
			} else {
				throw new PositionNotSupportedException();
			}
		}
		writer.println("}");
		writer.close();
	}

	/**
	 * Uses command prompt to render stl file of openscad file by same name
	 * 
	 * @throws IOException
	 */
	protected void writeSTL() throws IOException {
		Runtime.getRuntime().exec(
				"cmd.exe /c start " + directory + "\\export.bat " + directory
						+ " " + name + ".stl " + name + ".scad");
	}

	/**
	 * writes a profile to a text document using already set values
	 * 
	 * @throws FileNotFoundException
	 */
	protected void writeProfile() throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(directory + "\\" + name + ".txt");
		writer.println(hole);
		writer.flush();
		writer.println(barrel);
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

	/**
	 * pulls values in from a previously determined file, will not work if does
	 * not have correct format
	 * 
	 * @param profile
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	protected void readProfile(File profile) throws NumberFormatException,
			IOException {
		BufferedReader reader = new BufferedReader(new FileReader(profile));
		hole = reader.readLine();
		barrel = reader.readLine();
		diameter = Double.parseDouble(reader.readLine());
		width = Double.parseDouble(reader.readLine());
		height = Double.parseDouble(reader.readLine());
		lin = Double.parseDouble(reader.readLine());
		lout = Double.parseDouble(reader.readLine());
		angle = Double.parseDouble(reader.readLine());
		lefty = Boolean.parseBoolean(reader.readLine());
		reader.close();
	}

	/**
	 * takes a file name and splits it into directory and title and sets values
	 * as variables
	 * 
	 * @param filename
	 *            : filename for processing
	 */
	protected void processFileName(String filename) {
		directory = filename.substring(0, filename.lastIndexOf("\\")) + "\\";
		name = filename.substring(filename.lastIndexOf("\\"),
				filename.lastIndexOf("."));

	}
}
