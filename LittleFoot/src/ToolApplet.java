import java.applet.Applet;
import java.awt.*;
import java.io.FileNotFoundException;

public class ToolApplet extends Applet {
	private String[] positions= filewriter.positions;
	private String[] stls = { "gripA.stl" };
	private Button stlsChoose = new Button("Choose");
	private TextField diameter = new TextField("Diameter", 20);
	private TextField lout = new TextField("Extruded Length", 20);
	private TextField lin = new TextField("Protruded Length", 20);
	private TextField angle = new TextField("Angle",20);
	private TextField height = new TextField("Height", 20);
	private TextField width = new TextField("Width",20);
	private TextField filefield = new TextField("File Name", 40);
	private Choice position = new Choice();
	private Button positionChoose = new Button("Choose");
	private Choice stl = new Choice();
	private Checkbox lefty = new Checkbox("Left Handed", false);
	private Button submit = new Button("Submit");
	private Button back = new Button("Back");
	
	//phases
	private boolean stlChosen = false;
	private boolean positionChosen = false;
	private boolean submitted = false;

	private filewriter writer = new filewriter();

	public void init() {
		resize(400, 100);
		diameter.setEditable(true);
		filefield.setEditable(true);
		lout.setEditable(true);
		lin.setEditable(true);
		angle.setEditable(true);
		height.setEditable(true);
		width.setEditable(true);
		
		for (String s : positions)
			position.add(s);
		for (String s : stls)
			stl.add(s);
		
		chooseStl();
	}

	@SuppressWarnings("deprecation")
	public boolean action(Event evt, Object arg) {
		if(evt.target.equals(back)){
			if(positionChosen){
				positionChosen =false;
				choosePosition();
			}
			else if(stlChosen){
				stlChosen = false;
				chooseStl();
			}
		}
		if(evt.target.equals(stlsChoose) ){
			stlChosen=true;
			choosePosition();
		}
		if(evt.target.equals(positionChoose)){
			positionChosen =true;
			setParams();
		}
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
				submitted=true;
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
	
	private void chooseStl(){
		removeAll();
		add(stl);
		add(stlsChoose);
		
	}
	
	private void choosePosition(){
		removeAll();
		add(back);
		add(position);
		add(positionChoose);
	}
	
	private void setParams(){
		removeAll();
		add(back);
		if(position.equals(positions[0])){
			add(diameter);
			add(lefty);
		}
		else if(position.equals(positions[1])){
			add(diameter);
			add(lin);
			add(lefty);
		}
		else if(position.equals(positions[2])){
			add(diameter);
			add(lin);
			add(lout);
			add(lefty);
		}
		else if(position.equals(positions[3])){
			add(diameter);
			add(lout);
			add(angle);
			add(lefty);
		}
		add(submit);
			
	}

}
