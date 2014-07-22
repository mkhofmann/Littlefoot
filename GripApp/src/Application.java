import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.event.ChangeEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * GripFab is used to easiliy create grips with specific dimmensions for motor
 * impaired users
 * 
 * @author Megan
 */
@SuppressWarnings("serial")
public class Application extends javax.swing.JFrame {
	/**
	 * list of possible grips made in this progra
	 */
	private String[] gripList = { "contracture" };
	/**
	 * gripFab object that processes the data to produces a new grip
	 */
	private GripFab gripFab = new GripFab();
	/**
	 * Decimal formatter for variables in textbox's
	 */
	private DecimalFormat df = new DecimalFormat("###.##");
	/**
	 * current hold being used
	 */
	private String hole = "Circle";
	/**
	 * current barrel being used
	 */
	private String barrel = "None";
	/**
	 * maximum hole dimensions
	 */
	private double maxDim = 26;
	/**
	 * maximum grip depth
	 */
	private double maxLin = 62;
	/**
	 * masimum barrel depth
	 */
	private double maxLout = 200;

	/**
	 * Creates new form Application
	 */
	public Application() {
		initComponents();
	}

	/**
	 * initiates the components for use throughout the program opens the grips
	 * tab using grips() {@grips()}
	 */
	@SuppressWarnings("rawtypes")
	private void initComponents() {
		buttonGroup1 = new javax.swing.ButtonGroup();
		Panel = new javax.swing.JTabbedPane();
		grips = new javax.swing.JPanel();
		gripBox = new javax.swing.JComboBox();
		chooseGrip = new javax.swing.JButton();
		jLabel29 = new javax.swing.JLabel();
		profileChooser = new javax.swing.JFileChooser();
		newCheck = new javax.swing.JRadioButton();
		profileCheck = new javax.swing.JRadioButton();
		holeSettings = new javax.swing.JPanel();
		jLabel74 = new javax.swing.JLabel();
		holeChoices = new javax.swing.JComboBox();
		diameterLabel = new javax.swing.JLabel();
		diameterSlider = new javax.swing.JSlider();
		jLabel82 = new javax.swing.JLabel();
		heightSlider = new javax.swing.JSlider();
		jLabel83 = new javax.swing.JLabel();
		widthSlider = new javax.swing.JSlider();
		jLabel84 = new javax.swing.JLabel();
		jLabel85 = new javax.swing.JLabel();
		jLabel86 = new javax.swing.JLabel();
		diameter = new javax.swing.JTextField();
		height = new javax.swing.JTextField();
		width = new javax.swing.JTextField();
		jLabel87 = new javax.swing.JLabel();
		jLabel88 = new javax.swing.JLabel();
		jLabel89 = new javax.swing.JLabel();
		submitHole = new javax.swing.JButton();
		holeDescription = new javax.swing.JLabel();
		holePic = new javax.swing.JLabel();
		barrelSettings = new javax.swing.JPanel();
		jLabel75 = new javax.swing.JLabel();
		barrelChoices = new javax.swing.JComboBox();
		jLabel900 = new javax.swing.JLabel();
		loutSlider = new javax.swing.JSlider();
		jLabel90 = new javax.swing.JLabel();
		linSlider = new javax.swing.JSlider();
		jLabel91 = new javax.swing.JLabel();
		angleSlider = new javax.swing.JSlider();
		jLabel92 = new javax.swing.JLabel();
		jLabel93 = new javax.swing.JLabel();
		jLabel94 = new javax.swing.JLabel();
		lout = new javax.swing.JTextField();
		lin = new javax.swing.JTextField();
		angle = new javax.swing.JTextField();
		jLabel95 = new javax.swing.JLabel();
		jLabel96 = new javax.swing.JLabel();
		jLabel97 = new javax.swing.JLabel();
		submitBarrel = new javax.swing.JButton();
		barrelDescription = new javax.swing.JLabel();
		barrelPic = new javax.swing.JLabel();
		lefty = new javax.swing.JCheckBox();
		finish = new javax.swing.JPanel();
		jLabel77 = new javax.swing.JLabel();
		selectProfile = new javax.swing.JCheckBox();
		selectSTL = new javax.swing.JCheckBox();
		jLabel78 = new javax.swing.JLabel();
		finishChooser = new javax.swing.JFileChooser();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		Panel.setPreferredSize(new java.awt.Dimension(900, 900));

		grips();

		pack();
	}

	/**
	 * sets grips tab for profile's to be selected
	 * 
	 * @param evt
	 */
	private void profileCheckActionPerformed(ActionEvent evt) {
		if (profileCheck.isSelected()) {
			profileChooser.setVisible(true);
			chooseGrip.setVisible(false);
		}
	}

	/**
	 * chooses the profile is the approve option was selected on profileChooser
	 * 
	 * @param evt
	 */
	private void profileChooserActionPerformed(ActionEvent evt) {
		int result = profileChooser.showSaveDialog(this);
		if (result == JFileChooser.APPROVE_OPTION)
			chooseGripActionPerformed(evt);
	}

	/**
	 * if new grip is checked then shows appropriate options
	 * 
	 * @param evt
	 */
	private void newCheckActionPerformed(ActionEvent evt) {
		if (newCheck.isSelected()) {
			profileChooser.setVisible(false);
			chooseGrip.setVisible(true);
		}
	}

	/**
	 * grip is selected and holes menu is opened
	 * 
	 * @param evt
	 *            {@code holes()}
	 *            {@code gripFab.readProfile(profileChooser.getSelectedFile());}
	 */
	private void chooseGripActionPerformed(ActionEvent evt) {
		if (newCheck.isSelected()) {
			if ((gripBox.getSelectedItem() + ".stl").equals("contracture.stl")) {
				holes();
			}
		} else if (profileCheck.isSelected()) {
			try {
				gripFab.readProfile(profileChooser.getSelectedFile());
				holes();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * changes the available settings depending on the hole chosen
	 * 
	 * @param evt
	 *            {@code setHole(holeChoices.getSelectedItem())}
	 */
	private void holeChoicesActionPerformed(ActionEvent evt) {
		setHole((String) holeChoices.getSelectedItem());
	}

	/**
	 * changes the text value based off slider
	 * 
	 * @param evt
	 */
	private void diameterSliderStateChanged(ChangeEvent evt) {
		diameter.setText(df.format((diameterSlider.getValue() * maxDim) / 1000));
	}

	/**
	 * changes the text value based off slider
	 * 
	 * @param evt
	 */
	private void heightSliderStateChanged(ChangeEvent evt) {
		height.setText(df.format((heightSlider.getValue() * maxDim) / 1000));
	}

	/**
	 * changes the text value based off slider
	 * 
	 * @param evt
	 */
	private void widthSliderStateChanged(ChangeEvent evt) {
		width.setText(df.format((widthSlider.getValue() * maxDim) / 1000));
	}

	/**
	 * barrel variables made available based off chosen barrel
	 * 
	 * @param evt
	 */
	private void barrelChoicesActionPerformed(ActionEvent evt) {
		setBarrel((String) barrelChoices.getSelectedItem());
	}

	/**
	 * changes the text value based off slider
	 * 
	 * @param evt
	 */
	private void loutSliderStateChanged(ChangeEvent evt) {
		lout.setText(df.format((loutSlider.getValue() * maxLout) / 1000));
	}

	/**
	 * changes the text value based off slider
	 * 
	 * @param evt
	 */
	private void linSliderStateChanged(ChangeEvent evt) {
		lin.setText(df.format((linSlider.getValue() * maxLin) / 1000));
	}

	/**
	 * changes the text value based off slider
	 * 
	 * @param evt
	 */
	private void angleSliderStateChanged(ChangeEvent evt) {
		angle.setText(df.format((angleSlider.getValue() * 90.0) / 1000));
	}

	/**
	 * Takes the given variables and assigns them to appropriate files from
	 * selection renders stl {@code gripFab.processFileName}
	 * {@code gripFab.writeProfile} {@code gripFab.writeFile}
	 * {@code gripFab.writeSTL}
	 * 
	 * @param evt
	 * @throws PositionNotSupportedException
	 * @throws invalidDiameterException
	 * @throws STLNotPresentException
	 * @throws invalidDimmensionsException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	protected void finishChooserActionPerformed(ActionEvent evt) {
		// TODO: make files come from Mac friendly location
		// TODO: make unnecessary files delete themselves once printed
		int result = finishChooser.showSaveDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			gripFab.lefty = lefty.isSelected();
			gripFab.hole = hole;
			gripFab.barrel = barrel;
			gripFab.processFileName(finishChooser.getSelectedFile()
					.getAbsolutePath());
			if (selectProfile.isSelected()) {
				try {
					gripFab.writeProfile();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					dispose();
				}
				dispose();
			}
			if (selectSTL.isSelected()) {
				// add grip files to final directory
				// File f = new File("contractureA.stl");
				Path source = Paths
						.get("C:\\Program Files (x86)\\GripFab\\contractureA.stl");
				Path dirFinal = Paths.get(gripFab.directory);
				try {
					Files.copy(source, dirFinal.resolve(source.getFileName()),
							StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					e.printStackTrace();
					dispose();
				}
				source = Paths
						.get("C:\\Program Files (x86)\\GripFab\\contractureB.stl");
				try {
					Files.copy(source, dirFinal.resolve(source.getFileName()),
							StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					e.printStackTrace();
					dispose();
				}
				source = Paths
						.get("C:\\Program Files (x86)\\GripFab\\openscad.exe");
				try {
					Files.copy(source, dirFinal.resolve(source.getFileName()),
							StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					e.printStackTrace();
					dispose();
				}
				// write scad file to dirScad
				try {
					gripFab.writefile();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					dispose();
				} catch (PositionNotSupportedException e) {
					e.printStackTrace();
					dispose();
				}
				try {
					gripFab.writeSTL();
				} catch (IOException e) {
					e.printStackTrace();
					dispose();
				} catch (InterruptedException e) {
					e.printStackTrace();
					dispose();
				}
				// dispose();
				// delete scad files
				// delete = Paths.get(dirFinal + "\\contractureA.stl");
				// Files.deleteIfExists(delete);
				// delete = Paths.get(dirFinal + "\\contractureB.stl");
				// Files.deleteIfExists(delete);
				// delete = Paths.get(dirFinal + "\\" + gripFab.name + ".stl");
				// Files.deleteIfExists(delete);
				// delete = Paths.get(dirFinal + "\\openscad.exe");
				// Files.deleteIfExists(delete);
			}

		}
	}

	/**
	 * changes slider to set value
	 * 
	 * @param evt
	 */
	private void diameterActionPerformed(java.awt.event.ActionEvent evt) {
		double text = Double.parseDouble(diameter.getText());
		diameterSlider.setValue((int) (text * 1000 / maxDim));
	}

	/**
	 * changes slider to set value
	 * 
	 * @param evt
	 */
	private void heightActionPerformed(java.awt.event.ActionEvent evt) {
		double text = Double.parseDouble(height.getText());
		heightSlider.setValue((int) (text * 1000 / maxDim));
	}

	/**
	 * changes slider to set value
	 * 
	 * @param evt
	 */
	private void widthActionPerformed(java.awt.event.ActionEvent evt) {
		double text = Double.parseDouble(width.getText());
		widthSlider.setValue((int) (text * 1000 / maxDim));
	}

	/**
	 * enters hole variables into gripFab and moves on to barrels menu
	 * {@code barrels();}
	 * 
	 * @param evt
	 */
	private void submitHoleActionPerformed(java.awt.event.ActionEvent evt) {
		hole = (String) holeChoices.getSelectedItem();
		gripFab.diameter = Double.parseDouble(diameter.getText());
		gripFab.height = Double.parseDouble(height.getText());
		gripFab.width = Double.parseDouble(width.getText());
		barrels();
	}

	/**
	 * changes slider to set value
	 * 
	 * @param evt
	 */
	private void loutActionPerformed(java.awt.event.ActionEvent evt) {
		double text = Double.parseDouble(lout.getText());
		loutSlider.setValue((int) (text * 1000 / maxLout));
	}

	/**
	 * changes slider to set value
	 * 
	 * @param evt
	 */
	private void linActionPerformed(java.awt.event.ActionEvent evt) {
		double text = Double.parseDouble(lin.getText());
		linSlider.setValue((int) (text * 1000 / maxLin));
	}

	/**
	 * changes slider to set value
	 * 
	 * @param evt
	 */
	private void angleActionPerformed(java.awt.event.ActionEvent evt) {
		double text = Double.parseDouble(angle.getText());
		angleSlider.setValue((int) (text * 1000 / 90));
	}

	/**
	 * enters barrel dimensions into gripFab and moves to final menu
	 * {@code finish()}
	 * 
	 * @param evt
	 */
	private void submitBarrelActionPerformed(java.awt.event.ActionEvent evt) {
		barrel = (String) barrelChoices.getSelectedItem();
		gripFab.lin = Double.parseDouble(lin.getText());
		gripFab.lout = Double.parseDouble(lout.getText());
		gripFab.angle = Double.parseDouble(angle.getText());
		finish();
	}

	/**
	 * sets the variables open to user based on string that represents hole
	 * choice
	 * 
	 * @param h
	 *            : hole chosen
	 */
	private void setHole(String h) {
		if (h.equals(gripFab.holeList[0])) {
			holeDescription
					.setText("Creates a circular hole for the item to slide into. Good for pens.");
			diameterSlider.setEnabled(true);
			diameter.setEditable(true);
			heightSlider.setEnabled(false);
			heightSlider.setValue(0);
			height.setEditable(false);
			height.setText("" + 0.00);
			widthSlider.setEnabled(false);
			widthSlider.setValue(0);
			width.setEditable(false);
			width.setText("" + 0);
			holePic.setIcon(new javax.swing.ImageIcon(getClass().getResource(
					"Circular.gif"))); // NOI18N
		} else if (h.equals(gripFab.holeList[1])) {
			holeDescription
					.setText("Creates a rectangular hole for the item to slide into.");
			diameterSlider.setEnabled(false);
			diameterSlider.setValue(0);
			diameter.setEditable(false);
			diameter.setText("" + 0);
			heightSlider.setEnabled(true);
			height.setEditable(true);
			widthSlider.setEnabled(true);
			width.setEditable(true);
			holePic.setIcon(new javax.swing.ImageIcon(getClass().getResource(
					"Rectangular.gif"))); // NOI18N
		}
	}

	/**
	 * sets the variables open to user based on string that represents barrel
	 * choice
	 * 
	 * @param b
	 *            : barrel chosen
	 */
	private void setBarrel(String b) {
		if (b.equals(gripFab.barrelList[0])) {// none
			barrelDescription
					.setText("Creates a simple grip with a hole for items to slide into.");
			linSlider.setEnabled(true);
			lin.setEditable(true);
			loutSlider.setEnabled(false);
			loutSlider.setValue(0);
			lout.setEditable(false);
			lout.setText("" + 0);
			angleSlider.setEnabled(false);
			angleSlider.setValue(0);
			angle.setEditable(false);
			angle.setText("" + 0);
			barrelPic.setIcon(new javax.swing.ImageIcon(getClass().getResource(
					"none.gif"))); // NOI18N
		} else if (b.equals(gripFab.barrelList[1])) {// straight
			barrelDescription
					.setText("Creates an straight barrel. Adds support to longer items. Great for writing.");
			linSlider.setEnabled(true);
			lin.setEditable(true);
			loutSlider.setEnabled(true);
			lout.setEditable(true);
			angleSlider.setEnabled(false);
			angleSlider.setValue(0);
			angle.setEditable(true);
			angle.setText("" + 0);
			barrelPic.setIcon(new javax.swing.ImageIcon(getClass().getResource(
					"straight.gif"))); // NOI18N
		} else if (b.equals(gripFab.barrelList[2])) {// angled
			barrelDescription
					.setText("Creates an angled barrel. Adds support to the item and points it at and angle.");
			linSlider.setEnabled(false);
			linSlider.setValue(0);
			lin.setEditable(false);
			lin.setText("" + 0);
			loutSlider.setEnabled(true);
			lout.setEditable(true);
			angleSlider.setEnabled(true);
			angle.setEditable(true);
			barrelPic.setIcon(new javax.swing.ImageIcon(getClass().getResource(
					"angled.gif"))); // NOI18N
		}
	}

	/**
	 * generates and opens the grip menu
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void grips() {
		gripBox.setModel(new DefaultComboBoxModel(gripList));
		chooseGrip.setText("Choose");
		chooseGrip.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				chooseGripActionPerformed(evt);
			}
		});

		jLabel29.setText("or");

		profileChooser.setVisible(false);
		profileChooser.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				profileChooserActionPerformed(evt);
			}
		});

		buttonGroup1.add(newCheck);
		newCheck.setSelected(true);
		newCheck.setText("New Grip");
		newCheck.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				newCheckActionPerformed(evt);
			}
		});

		buttonGroup1.add(profileCheck);
		profileCheck.setText("Grip From Profile:");
		profileCheck.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				profileCheckActionPerformed(evt);
			}
		});

		setLayouts();
		Panel.addTab("Grips", grips);
		Panel.setSelectedIndex(Panel.indexOfTab("Grips"));
		setLayouts();
	}

	/**
	 * generates and opens holes menu
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void holes() {
		jLabel74.setText("How would you like the hole shaped?");

		holeChoices.setModel(new DefaultComboBoxModel(gripFab.holeList));
		holeChoices.setSelectedItem(hole);
		holeChoices.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				holeChoicesActionPerformed(evt);
			}
		});
		diameterLabel.setText("Diameter:");
		diameter.setColumns(3);
		diameter.setText("" + gripFab.diameter);
		diameter.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				diameterActionPerformed(evt);
			}
		});

		height.setText("" + gripFab.height);
		height.setColumns(3);
		height.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				heightActionPerformed(evt);
			}
		});

		width.setText("" + gripFab.width);
		width.setColumns(3);
		width.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				widthActionPerformed(evt);
			}
		});

		diameterSlider.setMaximum(1000);
		double text = Double.parseDouble(diameter.getText());
		diameterSlider.setValue((int) (text * 1000 / maxDim));
		diameterSlider
				.addChangeListener(new javax.swing.event.ChangeListener() {
					@Override
					public void stateChanged(javax.swing.event.ChangeEvent evt) {
						diameterSliderStateChanged(evt);
					}
				});

		jLabel82.setText("The diameter of your circle should fit tightly around your object.");

		heightSlider.setMaximum(1000);
		text = Double.parseDouble(height.getText());
		heightSlider.setValue((int) (text * 1000 / maxDim));
		heightSlider.addChangeListener(new javax.swing.event.ChangeListener() {
			@Override
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				heightSliderStateChanged(evt);
			}
		});

		jLabel83.setText("The height of your rectangle should fit tightly around your object.");

		widthSlider.setMaximum(1000);
		text = Double.parseDouble(width.getText());
		widthSlider.setValue((int) (text * 1000 / maxDim));
		widthSlider.addChangeListener(new javax.swing.event.ChangeListener() {
			@Override
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				widthSliderStateChanged(evt);
			}
		});

		jLabel84.setText("The width of your rectangle should fit tightly around your object.");

		jLabel85.setText("Height:");

		jLabel86.setText("Width:");

		jLabel87.setText("mm");

		jLabel88.setText("mm");

		jLabel89.setText("mm");

		submitHole.setText("Submit Hole");
		submitHole.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitHoleActionPerformed(evt);
			}
		});

		setHole(hole);
		Panel.remove(barrelSettings);
		Panel.remove(finish);
		Panel.addTab("Hole Settings", holeSettings);
		Panel.setSelectedIndex(Panel.indexOfTab("Hole Settings"));
		setLayouts();
	}

	/**
	 * generates and opens barrels menu
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void barrels() {
		jLabel75.setText("What kind of barrel would you like?");

		barrelChoices.setModel(new DefaultComboBoxModel(gripFab.barrelList));
		barrelChoices.setSelectedItem(barrel);
		barrelChoices.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				barrelChoicesActionPerformed(evt);
			}
		});
		jLabel900.setText("Grip Depth:");

		lout.setColumns(3);
		lout.setText("" + gripFab.lout);
		lout.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loutActionPerformed(evt);
			}
		});

		lin.setColumns(3);
		lin.setText("" + gripFab.lin);
		lin.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				linActionPerformed(evt);
			}
		});

		angle.setColumns(3);
		angle.setText("" + gripFab.angle);
		angle.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				angleActionPerformed(evt);
			}
		});

		loutSlider.setMaximum(1000);
		double text = Double.parseDouble(lout.getText());
		loutSlider.setValue((int) (text * 1000 / maxLout));
		loutSlider.addChangeListener(new javax.swing.event.ChangeListener() {
			@Override
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				loutSliderStateChanged(evt);
			}
		});

		jLabel90.setText("The diameter of your circle should fit tightly around your object.");

		linSlider.setMaximum(1000);
		text = Double.parseDouble(lin.getText());
		linSlider.setValue((int) (text * 1000 / maxLin));
		linSlider.addChangeListener(new javax.swing.event.ChangeListener() {
			@Override
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				linSliderStateChanged(evt);
			}
		});

		jLabel91.setText("The barrel length should run the length of the item it is supporting. ");

		angleSlider.setMaximum(1000);
		text = Double.parseDouble(angle.getText());
		angleSlider.setValue((int) (text * 1000 / 90));
		angleSlider.addChangeListener(new javax.swing.event.ChangeListener() {
			@Override
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				angleSliderStateChanged(evt);
			}
		});

		jLabel92.setText("The angle at which you want the barrel to point");

		jLabel93.setText("Barrel Length:");

		jLabel94.setText("Angle:");

		jLabel95.setText("mm");

		jLabel96.setText("mm");

		jLabel97.setText("mm");

		submitBarrel.setText("Submit Barrel");
		submitBarrel.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitBarrelActionPerformed(evt);
			}
		});

		lefty.setText("Left Handed Grip?");
		lefty.setSelected(gripFab.lefty);

		setBarrel(barrel);
		Panel.remove(finish);
		Panel.addTab("Barrel Settings", barrelSettings);
		Panel.setSelectedIndex(Panel.indexOfTab("Barrel Settings"));
		setLayouts();
	}

	/**
	 * generates and opens finish menu
	 */
	private void finish() {
		jLabel77.setText("Select desired Files:");

		selectProfile.setText("Profile");

		finishChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
		finishChooser.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				finishChooserActionPerformed(evt);
			}
		});

		selectSTL.setText("STL File (for printing)");

		jLabel78.setText("Rendering STLs takes time. Up to 5 Minutes. Be Patient while your files are created.");

		Panel.addTab("Finish", finish);
		setLayouts();
		Panel.setSelectedIndex(Panel.indexOfTab("Finish"));

	}

	/**
	 * sets the layouts of each menu
	 */
	private void setLayouts() {

		// grips
		javax.swing.GroupLayout gripsLayout = new javax.swing.GroupLayout(grips);
		grips.setLayout(gripsLayout);
		gripsLayout
				.setHorizontalGroup(gripsLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								gripsLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gripsLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																profileChooser,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																660,
																Short.MAX_VALUE)
														.addGroup(
																gripsLayout
																		.createSequentialGroup()
																		.addComponent(
																				newCheck)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				gripBox,
																				0,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
														.addGroup(
																gripsLayout
																		.createSequentialGroup()
																		.addComponent(
																				profileCheck)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				chooseGrip))
														.addGroup(
																gripsLayout
																		.createSequentialGroup()
																		.addGap(24,
																				24,
																				24)
																		.addComponent(
																				jLabel29)
																		.addGap(0,
																				0,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		gripsLayout
				.setVerticalGroup(gripsLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								gripsLayout
										.createSequentialGroup()
										.addGap(12, 12, 12)
										.addGroup(
												gripsLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																gripBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(newCheck))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel29)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												gripsLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																chooseGrip,
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																profileCheck))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												profileChooser,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												505, Short.MAX_VALUE)
										.addContainerGap()));
		// hole Settings
		javax.swing.GroupLayout holeSettingsLayout = new javax.swing.GroupLayout(
				holeSettings);
		holeSettings.setLayout(holeSettingsLayout);
		holeSettingsLayout
				.setHorizontalGroup(holeSettingsLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								holeSettingsLayout
										.createSequentialGroup()
										.addGroup(
												holeSettingsLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																holeSettingsLayout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addGroup(
																				holeSettingsLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								holeSettingsLayout
																										.createSequentialGroup()
																										.addGap(10,
																												10,
																												10)
																										.addComponent(
																												holeChoices,
																												0,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE))
																						.addGroup(
																								holeSettingsLayout
																										.createSequentialGroup()
																										.addGroup(
																												holeSettingsLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jLabel74)
																														.addGroup(
																																holeSettingsLayout
																																		.createSequentialGroup()
																																		.addGroup(
																																				holeSettingsLayout
																																						.createParallelGroup(
																																								javax.swing.GroupLayout.Alignment.LEADING)
																																						.addComponent(
																																								diameterLabel)
																																						.addComponent(
																																								jLabel85)
																																						.addComponent(
																																								jLabel86))
																																		.addPreferredGap(
																																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																		.addGroup(
																																				holeSettingsLayout
																																						.createParallelGroup(
																																								javax.swing.GroupLayout.Alignment.LEADING)
																																						.addComponent(
																																								jLabel82)
																																						.addComponent(
																																								jLabel83)
																																						.addComponent(
																																								jLabel84)
																																						.addGroup(
																																								holeSettingsLayout
																																										.createSequentialGroup()
																																										.addGroup(
																																												holeSettingsLayout
																																														.createParallelGroup(
																																																javax.swing.GroupLayout.Alignment.TRAILING,
																																																false)
																																														.addComponent(
																																																diameterSlider,
																																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																																513,
																																																Short.MAX_VALUE)
																																														.addComponent(
																																																widthSlider,
																																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																																Short.MAX_VALUE)
																																														.addComponent(
																																																heightSlider,
																																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																																Short.MAX_VALUE))
																																										.addPreferredGap(
																																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																										.addGroup(
																																												holeSettingsLayout
																																														.createParallelGroup(
																																																javax.swing.GroupLayout.Alignment.LEADING)
																																														.addGroup(
																																																holeSettingsLayout
																																																		.createSequentialGroup()
																																																		.addGroup(
																																																				holeSettingsLayout
																																																						.createParallelGroup(
																																																								javax.swing.GroupLayout.Alignment.LEADING)
																																																						.addComponent(
																																																								height,
																																																								javax.swing.GroupLayout.PREFERRED_SIZE,
																																																								javax.swing.GroupLayout.DEFAULT_SIZE,
																																																								javax.swing.GroupLayout.PREFERRED_SIZE)
																																																						.addComponent(
																																																								width,
																																																								javax.swing.GroupLayout.Alignment.TRAILING,
																																																								javax.swing.GroupLayout.PREFERRED_SIZE,
																																																								javax.swing.GroupLayout.DEFAULT_SIZE,
																																																								javax.swing.GroupLayout.PREFERRED_SIZE))
																																																		.addPreferredGap(
																																																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																																		.addGroup(
																																																				holeSettingsLayout
																																																						.createParallelGroup(
																																																								javax.swing.GroupLayout.Alignment.LEADING)
																																																						.addComponent(
																																																								jLabel88)
																																																						.addComponent(
																																																								jLabel89)))
																																														.addGroup(
																																																holeSettingsLayout
																																																		.createSequentialGroup()
																																																		.addComponent(
																																																				diameter,
																																																				javax.swing.GroupLayout.PREFERRED_SIZE,
																																																				javax.swing.GroupLayout.DEFAULT_SIZE,
																																																				javax.swing.GroupLayout.PREFERRED_SIZE)
																																																		.addPreferredGap(
																																																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																																		.addComponent(
																																																				jLabel87))))))
																														.addComponent(
																																holePic))
																										.addGap(0,
																												10,
																												Short.MAX_VALUE))))
														.addGroup(
																holeSettingsLayout
																		.createSequentialGroup()
																		.addGap(41,
																				41,
																				41)
																		.addComponent(
																				holeDescription)
																		.addGap(0,
																				0,
																				Short.MAX_VALUE))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																holeSettingsLayout
																		.createSequentialGroup()
																		.addGap(0,
																				0,
																				Short.MAX_VALUE)
																		.addComponent(
																				submitHole)))
										.addContainerGap()));
		holeSettingsLayout
				.setVerticalGroup(holeSettingsLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								holeSettingsLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabel74)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												holeChoices,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(holeDescription)
										.addGap(8, 8, 8)
										.addGroup(
												holeSettingsLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																diameterLabel)
														.addComponent(
																diameterSlider,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																holeSettingsLayout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				diameter,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				jLabel87)))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel82)
										.addGap(18, 18, 18)
										.addGroup(
												holeSettingsLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																heightSlider,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel85)
														.addGroup(
																holeSettingsLayout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				height,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				jLabel88)))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel83)
										.addGap(18, 18, 18)
										.addGroup(
												holeSettingsLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																widthSlider,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel86)
														.addGroup(
																holeSettingsLayout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				width,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				jLabel89)))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel84)
										.addGap(18, 18, 18)
										.addComponent(
												holePic,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												250,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												43, Short.MAX_VALUE)
										.addComponent(submitHole)
										.addContainerGap()));
		// barrel Settings
		javax.swing.GroupLayout barrelSettingsLayout = new javax.swing.GroupLayout(
				barrelSettings);
		barrelSettings.setLayout(barrelSettingsLayout);
		barrelSettingsLayout
				.setHorizontalGroup(barrelSettingsLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								barrelSettingsLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												barrelSettingsLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																barrelChoices,
																javax.swing.GroupLayout.Alignment.TRAILING,
																0,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																barrelSettingsLayout
																		.createSequentialGroup()
																		.addGroup(
																				barrelSettingsLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addGroup(
																								barrelSettingsLayout
																										.createSequentialGroup()
																										.addGroup(
																												barrelSettingsLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																barrelPic)
																														.addGroup(
																																barrelSettingsLayout
																																		.createSequentialGroup()
																																		.addGroup(
																																				barrelSettingsLayout
																																						.createParallelGroup(
																																								javax.swing.GroupLayout.Alignment.LEADING)
																																						.addComponent(
																																								jLabel93)
																																						.addComponent(
																																								jLabel94))
																																		.addPreferredGap(
																																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																		.addGroup(
																																				barrelSettingsLayout
																																						.createParallelGroup(
																																								javax.swing.GroupLayout.Alignment.LEADING)
																																						.addComponent(
																																								jLabel90)
																																						.addComponent(
																																								jLabel91)
																																						.addComponent(
																																								jLabel92)))
																														.addComponent(
																																jLabel75))
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addGroup(
																												barrelSettingsLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																lefty,
																																javax.swing.GroupLayout.Alignment.TRAILING)
																														.addComponent(
																																submitBarrel,
																																javax.swing.GroupLayout.Alignment.TRAILING)))
																						.addGroup(
																								barrelSettingsLayout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel900)
																										.addGap(23,
																												23,
																												23)
																										.addComponent(
																												linSlider,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												501,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												lin,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addComponent(
																												jLabel95))
																						.addGroup(
																								barrelSettingsLayout
																										.createSequentialGroup()
																										.addGap(88,
																												88,
																												88)
																										.addGroup(
																												barrelSettingsLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																loutSlider,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)
																														.addComponent(
																																angleSlider,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE))
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																										.addGroup(
																												barrelSettingsLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addGroup(
																																barrelSettingsLayout
																																		.createSequentialGroup()
																																		.addComponent(
																																				lout,
																																				javax.swing.GroupLayout.PREFERRED_SIZE,
																																				javax.swing.GroupLayout.DEFAULT_SIZE,
																																				javax.swing.GroupLayout.PREFERRED_SIZE)
																																		.addPreferredGap(
																																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																		.addComponent(
																																				jLabel96))
																														.addGroup(
																																barrelSettingsLayout
																																		.createSequentialGroup()
																																		.addComponent(
																																				angle,
																																				javax.swing.GroupLayout.PREFERRED_SIZE,
																																				javax.swing.GroupLayout.DEFAULT_SIZE,
																																				javax.swing.GroupLayout.PREFERRED_SIZE)
																																		.addPreferredGap(
																																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																		.addComponent(
																																				jLabel97)))))
																		.addGap(22,
																				22,
																				22)))
										.addGap(19, 19, 19))
						.addGroup(
								barrelSettingsLayout
										.createSequentialGroup()
										.addGap(41, 41, 41)
										.addComponent(barrelDescription)
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		barrelSettingsLayout
				.setVerticalGroup(barrelSettingsLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								barrelSettingsLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabel75)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												barrelChoices,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(8, 8, 8)
										.addComponent(barrelDescription)
										.addGroup(
												barrelSettingsLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																barrelSettingsLayout
																		.createSequentialGroup()
																		.addGap(40,
																				40,
																				40)
																		.addComponent(
																				jLabel90))
														.addGroup(
																barrelSettingsLayout
																		.createSequentialGroup()
																		.addGap(17,
																				17,
																				17)
																		.addGroup(
																				barrelSettingsLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								linSlider,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jLabel900)
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								barrelSettingsLayout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.BASELINE)
																										.addComponent(
																												lin,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												jLabel95)))))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												13, Short.MAX_VALUE)
										.addGroup(
												barrelSettingsLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																barrelSettingsLayout
																		.createSequentialGroup()
																		.addGroup(
																				barrelSettingsLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								barrelSettingsLayout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel93)
																										.addGap(14,
																												14,
																												14)
																										.addComponent(
																												jLabel91)
																										.addGap(18,
																												18,
																												18))
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								barrelSettingsLayout
																										.createSequentialGroup()
																										.addGroup(
																												barrelSettingsLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.BASELINE)
																														.addComponent(
																																lout,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																jLabel96))
																										.addGap(38,
																												38,
																												38)))
																		.addGroup(
																				barrelSettingsLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								angleSlider,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jLabel94)
																						.addGroup(
																								barrelSettingsLayout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.BASELINE)
																										.addComponent(
																												angle,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												jLabel97))))
														.addComponent(
																loutSlider,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel92)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												barrelSettingsLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addGroup(
																barrelSettingsLayout
																		.createSequentialGroup()
																		.addComponent(
																				lefty)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				submitBarrel))
														.addComponent(barrelPic))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		// finish
		javax.swing.GroupLayout finishLayout = new javax.swing.GroupLayout(
				finish);
		finish.setLayout(finishLayout);
		finishLayout
				.setHorizontalGroup(finishLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								finishLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												finishLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																finishChooser,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																660,
																Short.MAX_VALUE)
														.addGroup(
																finishLayout
																		.createSequentialGroup()
																		.addGroup(
																				finishLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								selectProfile)
																						.addComponent(
																								selectSTL)
																						.addComponent(
																								jLabel78)
																						.addComponent(
																								jLabel77))
																		.addGap(0,
																				0,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		finishLayout
				.setVerticalGroup(finishLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								finishLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabel77)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(selectProfile)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(selectSTL)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel78)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												finishChooser,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												500, Short.MAX_VALUE)
										.addContainerGap()));
		// group
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addComponent(Panel,
								javax.swing.GroupLayout.PREFERRED_SIZE, 689,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addComponent(Panel,
								javax.swing.GroupLayout.PREFERRED_SIZE, 651,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));
	}

	// TODO: document individual interface objects
	// Variables declaration - do not modify
	private javax.swing.JTabbedPane Panel;
	private javax.swing.JTextField angle;
	private javax.swing.JSlider angleSlider;
	private javax.swing.JComboBox<?> barrelChoices;
	private javax.swing.JLabel barrelDescription;
	private javax.swing.JLabel barrelPic;
	private javax.swing.JPanel barrelSettings;
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JButton chooseGrip;
	private javax.swing.JTextField diameter;
	private javax.swing.JLabel diameterLabel;
	private javax.swing.JSlider diameterSlider;
	private javax.swing.JPanel finish;
	private javax.swing.JFileChooser finishChooser;
	private javax.swing.JComboBox<?> gripBox;
	private javax.swing.JPanel grips;
	private javax.swing.JTextField height;
	private javax.swing.JSlider heightSlider;
	private javax.swing.JComboBox<?> holeChoices;
	private javax.swing.JLabel holeDescription;
	private javax.swing.JLabel holePic;
	private javax.swing.JPanel holeSettings;
	private javax.swing.JLabel jLabel29;
	private javax.swing.JLabel jLabel74;
	private javax.swing.JLabel jLabel75;
	private javax.swing.JLabel jLabel77;
	private javax.swing.JLabel jLabel78;
	private javax.swing.JLabel jLabel82;
	private javax.swing.JLabel jLabel83;
	private javax.swing.JLabel jLabel84;
	private javax.swing.JLabel jLabel85;
	private javax.swing.JLabel jLabel86;
	private javax.swing.JLabel jLabel87;
	private javax.swing.JLabel jLabel88;
	private javax.swing.JLabel jLabel89;
	private javax.swing.JLabel jLabel90;
	private javax.swing.JLabel jLabel900;
	private javax.swing.JLabel jLabel91;
	private javax.swing.JLabel jLabel92;
	private javax.swing.JLabel jLabel93;
	private javax.swing.JLabel jLabel94;
	private javax.swing.JLabel jLabel95;
	private javax.swing.JLabel jLabel96;
	private javax.swing.JLabel jLabel97;
	private javax.swing.JCheckBox lefty;
	private javax.swing.JTextField lin;
	private javax.swing.JSlider linSlider;
	private javax.swing.JTextField lout;
	private javax.swing.JSlider loutSlider;
	private javax.swing.JRadioButton newCheck;
	private javax.swing.JRadioButton profileCheck;
	private javax.swing.JFileChooser profileChooser;
	private javax.swing.JCheckBox selectProfile;
	private javax.swing.JCheckBox selectSTL;
	private javax.swing.JButton submitBarrel;
	private javax.swing.JButton submitHole;
	private javax.swing.JTextField width;
	private javax.swing.JSlider widthSlider;

	// End of variables declaration
	/**
	 * This creates and holds all data about the grip being built.
	 * 
	 * @author Megan K. Hofmann
	 */
	private class GripFab {
		/**
		 * directory selected for file outputs
		 */
		protected String directory = "";
		/**
		 * name of files to be output
		 */
		protected String name = "";
		/**
		 * possible barrels to choose
		 */
		protected Object[] barrelList = { "None", "Straight", "Angled" };
		/**
		 * possible holes to choose
		 */
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
		 * hole type of grip: Must match a value in holeList[]
		 */
		protected String hole = "";
		/**
		 * barrel type of grip: Must match a value in barrelList[]
		 */
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
		 * height of rectangular holes in mm
		 */
		protected double height = 0;

		protected GripFab() {

		}

		/**
		 * Writes a openscad file to given directory with given name and preset
		 * variables.
		 * 
		 * @throws FileNotFoundException
		 * 
		 * @throws PositionNotSupportedException
		 * @throws invalidDiameterException
		 * @throws STLNotPresentException
		 * @throws invalidDimmensionsException
		 * @throws IOException
		 * @throws InterruptedException
		 * @throws GripNotFoundException
		 */
		@SuppressWarnings("resource")
		protected void writefile() throws FileNotFoundException,
				PositionNotSupportedException {
			PrintWriter writer = new PrintWriter(directory + "\\" + name
					+ ".scad");

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
			writer.println("cutB();");
			writer.println("translate([0,0,-lout]) cylinder(lout+lin,diameter/2,diameter/2);");
			writer.println("}}");

			// straightRec
			writer.println("module straightRec(){");
			writer.println("difference(){");
			writer.println("cutB();");
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
			writer.println("mirror([0,0,1]) translate([0,0,-diameter*sin(angle)]) rotate([0,angle,0]) barrelC();");
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
		 * @throws InterruptedException
		 */
		protected void writeSTL() throws IOException, InterruptedException {
			Runtime.getRuntime()
					.exec("cmd /c " + directory + "\\openscad.exe -o "
							+ directory + "\\" + name + ".stl " + directory
							+ "\\" + name + ".scad").waitFor();
			Runtime.getRuntime().exec("cmd /c exit");
		}

		/**
		 * writes a profile to a text document using already set values
		 * 
		 * @throws FileNotFoundException
		 */
		protected void writeProfile() throws FileNotFoundException {
			PrintWriter writer = new PrintWriter(directory + "\\" + name
					+ ".txt");
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
		 * pulls values in from a previously determined file, will not work if
		 * does not have correct format
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
		 * takes a file name and splits it into directory and title and sets
		 * values as variables
		 * 
		 * @param filename
		 *            : filename for processing
		 */
		protected void processFileName(String filename) {
			directory = filename.substring(0, filename.lastIndexOf("\\"))
					+ "\\";
			if (filename.lastIndexOf(".") == -1)
				name = filename.substring(filename.lastIndexOf("\\"));
			else
				name = filename.substring(filename.lastIndexOf("\\"),
						filename.lastIndexOf("."));

		}
	}

	private class PositionNotSupportedException extends Exception {

		public PositionNotSupportedException() {
			super("Position Not supported, Please try a new position.");
		}

	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Application.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Application.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Application.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Application.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Application().setVisible(true);
			}
		});
	}
}
