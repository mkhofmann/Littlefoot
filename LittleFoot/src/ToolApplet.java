import java.applet.Applet;
import java.awt.*;
import java.io.FileNotFoundException;

public class ToolApplet extends Applet {
	String[] positions = { "a", "b", "c","d" };
	String[] stls = { "gripA.stl" };
	TextField diameter = new TextField("12", 5);
	TextField lout = new TextField("0", 5);
	TextField lin = new TextField("0", 5);
	TextField angle = new TextField("0",5);
	TextField filefield = new TextField(
			"C:\\Users\\Megan\\Desktop\\LittlefootPrints\\grip.scad", 40);
	Choice position = new Choice();
	Choice stl = new Choice();
	Checkbox lefty = new Checkbox("Left Handed", false);
	Button submit = new Button("Submit");

	filewriter writer = new filewriter();

	public void init() {
		resize(400, 100);
		diameter.setEditable(true);
		filefield.setEditable(true);
		lout.setEditable(true);
		lin.setEditable(true);
		angle.setEditable(true);
		for (String s : positions)
			position.add(s);
		for (String s : stls)
			stl.add(s);
		add(diameter);
		add(lout);
		add(lin);
		add(angle);
		add(position);
		add(stl);
		add(filefield);
		add(lefty);
		add(submit);
	}

	@SuppressWarnings("deprecation")
	public boolean action(Event evt, Object arg) {
		if (evt.target.equals(submit)) {
			showStatus("Submitting...");
			writer.position = position.getSelectedItem();
			showStatus("position accepted");
			writer.stlTitle = stl.getSelectedItem();
			showStatus("stl file accepted");
			writer.diameter = Double.parseDouble(diameter.getText());
			showStatus("diameter accepted");
			writer.lout = Double.parseDouble(lout.getText());
			showStatus("Outer length Accepted");
			writer.lin = Double.parseDouble(lin.getText());
			showStatus("Inner Length Accepted");
			writer.angle = Double.parseDouble(angle.getText());
			showStatus("angle accepted");
			writer.filename = filefield.getText();
			showStatus("filename accepted");
			writer.lefty = lefty.getState();
			showStatus("left handed state accepted");
			try {
				writer.writefile();
				showStatus("Submitted File");
			} catch (FileNotFoundException e) {
				showStatus("Error: File Not found");
				e.printStackTrace();
			} catch (PositionNotSupportedException e) {
				showStatus("Error: No position available");
				e.printStackTrace();
			} catch (invalidDiameterException e) {
				showStatus("Error: Diameter Invalid");
				e.printStackTrace();
			} catch (STLNotPresentException e) {
				showStatus("Error: Stl file not present");
				e.printStackTrace();
			}
		} else
			return super.action(evt, arg);
		return true;

	}

}
