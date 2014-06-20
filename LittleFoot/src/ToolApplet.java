import java.applet.Applet;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ToolApplet extends Applet {
	String[] positions = { "a" };
	String[] stls = { "gripA.stl" };
	TextField diameter = new TextField("5", 10);
	TextField posfield = new TextField("a", 20);
	TextField stlfield = new TextField("gripA.stl", 20);
	TextField filefield = new TextField("grip.scad", 20);
	Choice position = new Choice();
	Choice stl = new Choice();
	Button posButton = new Button("Choose Position");
	Button stlButton = new Button("Choose stl");
	Button diamButton = new Button("Submit Diameter");
	Button submit = new Button("Submit");

	filewriter writer = new filewriter();

	public void init() {
		diameter.setEditable(true);
		filefield.setEditable(true);
		posfield.setEditable(false);
		stlfield.setEditable(false);
		for (String s : positions)
			position.add(s);
		for (String s : stls)
			stl.add(s);
		add(diameter);
		add(posfield);
		add(position);
		add(stlfield);
		add(stl);
		add(filefield);
		add(submit);
	}

	public boolean action(Event evt, Object arg) {
		if (evt.target.equals(position))
			posfield.setText(position.getSelectedItem());
		else if (evt.target.equals(stl))
			stlfield.setText(stl.getSelectedItem());
		else if (evt.target.equals(submit)) {
//			System.out.println("made it here");
//			writer.position = posfield.getText();
//			writer.stlTitle = stlfield.getText();
//			writer.diameter = Double.parseDouble(diameter.getText());
			writer.filename = filefield.getText();
			try {
				System.out.println(writer.filename);
				writer.writefile();
			} catch (FileNotFoundException | PositionNotSupportedException e) {
				e.printStackTrace();
			}
		} else
			return super.action(evt, arg);
		return true;

	}

}
