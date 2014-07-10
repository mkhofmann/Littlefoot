/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 * @author Megan
 */
public class AppGrip extends javax.swing.JApplet {
	// my variables
	private String[] gripList = { "contracture" };
	private String[] extensions = { "Protruded Cylinder Hole",
			"Protruded Rectangular Hole", "Angled Cylinder Barrel",
			"Angled Rectangular Barrel", "Straight Cylinder Barrel",
			"Straight Rectangular Barrel" };
	private GripFab gripFab = new GripFab();

	private boolean writingProfile = false;
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Panel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel cH;
    private javax.swing.JTextField cHDiameter;
    private javax.swing.JCheckBox cHLefty;
    private javax.swing.JTextField cHLin;
    private javax.swing.JCheckBox cHThrough;
    private javax.swing.JPanel cL;
    private javax.swing.JTextField cLDiameter;
    private javax.swing.JCheckBox cLLefty;
    private javax.swing.JTextField cLLin;
    private javax.swing.JTextField cLLout;
    private javax.swing.JPanel cU;
    private javax.swing.JTextField cUAngle;
    private javax.swing.JTextField cUDiameter;
    private javax.swing.JCheckBox cULefty;
    private javax.swing.JTextField cULout;
    private javax.swing.JButton chooseExtension;
    private javax.swing.JButton chooseExtensionB;
    private javax.swing.JButton chooseGrip;
    private javax.swing.JPanel eA;
    private javax.swing.JPanel eB;
    private javax.swing.JComboBox extensionBBox;
    private javax.swing.JComboBox extensionsBox;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JPanel finish;
    private javax.swing.JPanel finishProfile;
    private javax.swing.JComboBox gripBox;
    private javax.swing.JPanel grips;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton newCheck;
    private javax.swing.JRadioButton profileCheck;
    private javax.swing.JFileChooser profileChooser;
    private javax.swing.JFileChooser profileLocChooser;
    private javax.swing.JPanel rH;
    private javax.swing.JTextField rHHeight;
    private javax.swing.JCheckBox rHLefty;
    private javax.swing.JTextField rHLin;
    private javax.swing.JCheckBox rHThrough;
    private javax.swing.JTextField rHWidth;
    private javax.swing.JPanel rL;
    private javax.swing.JTextField rLHeight;
    private javax.swing.JCheckBox rLLefty;
    private javax.swing.JTextField rLLin;
    private javax.swing.JTextField rLLout;
    private javax.swing.JTextField rLWidth;
    private javax.swing.JPanel rU;
    private javax.swing.JTextField rUAngle;
    private javax.swing.JTextField rUHeight;
    private javax.swing.JCheckBox rULefty;
    private javax.swing.JTextField rULout;
    private javax.swing.JTextField rUWidth;
    private javax.swing.JCheckBox saveModel;
    private javax.swing.JCheckBox saveProfile;
    private javax.swing.JButton submitCH;
    private javax.swing.JButton submitCHP;
    private javax.swing.JButton submitCL;
    private javax.swing.JButton submitCLP;
    private javax.swing.JButton submitCU;
    private javax.swing.JButton submitCUP;
    private javax.swing.JButton submitFile;
    private javax.swing.JButton submitProfile;
    private javax.swing.JButton submitRH;
    private javax.swing.JButton submitRHP;
    private javax.swing.JButton submitRL;
    private javax.swing.JButton submitRLP;
    private javax.swing.JButton submitRU;
    private javax.swing.JButton submitRUP;
	// End of variables declaration//GEN-END:variables
	/**
	 * Initializes the applet AppGrip
	 */
	@Override
	public void init() {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		resize(600, 500);
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(AppGrip.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(AppGrip.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(AppGrip.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(AppGrip.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the applet */
		try {
			java.awt.EventQueue.invokeAndWait(new Runnable() {
				public void run() {
					initComponents();
				}
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * This method is called from within the init() method to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		buttonGroup1 = new javax.swing.ButtonGroup();
        Panel = new javax.swing.JTabbedPane();
        grips = new javax.swing.JPanel();
        gripBox = new javax.swing.JComboBox();
        chooseGrip = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        profileChooser = new javax.swing.JFileChooser();
        newCheck = new javax.swing.JRadioButton();
        profileCheck = new javax.swing.JRadioButton();
        eB = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        extensionBBox = new javax.swing.JComboBox();
        chooseExtensionB = new javax.swing.JButton();
        cH = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cHLin = new javax.swing.JTextField();
        cHDiameter = new javax.swing.JTextField();
        cHThrough = new javax.swing.JCheckBox();
        cHLefty = new javax.swing.JCheckBox();
        submitCH = new javax.swing.JButton();
        submitCHP = new javax.swing.JButton();
        finish = new javax.swing.JPanel();
        submitFile = new javax.swing.JButton();
        fileChooser = new javax.swing.JFileChooser();
        saveProfile = new javax.swing.JCheckBox();
        eA = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        extensionsBox = new javax.swing.JComboBox();
        chooseExtension = new javax.swing.JButton();
        rH = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        rHLin = new javax.swing.JTextField();
        rHHeight = new javax.swing.JTextField();
        rHThrough = new javax.swing.JCheckBox();
        rHLefty = new javax.swing.JCheckBox();
        submitRH = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        rHWidth = new javax.swing.JTextField();
        submitRHP = new javax.swing.JButton();
        rL = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        rLLin = new javax.swing.JTextField();
        rLHeight = new javax.swing.JTextField();
        rLLefty = new javax.swing.JCheckBox();
        submitRL = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        rLWidth = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        rLLout = new javax.swing.JTextField();
        submitRLP = new javax.swing.JButton();
        cL = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cLLin = new javax.swing.JTextField();
        cLDiameter = new javax.swing.JTextField();
        cLLefty = new javax.swing.JCheckBox();
        submitCL = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cLLout = new javax.swing.JTextField();
        submitCLP = new javax.swing.JButton();
        rU = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        rUAngle = new javax.swing.JTextField();
        rUHeight = new javax.swing.JTextField();
        rULefty = new javax.swing.JCheckBox();
        submitRU = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        rUWidth = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        rULout = new javax.swing.JTextField();
        submitRUP = new javax.swing.JButton();
        cU = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        cUAngle = new javax.swing.JTextField();
        cUDiameter = new javax.swing.JTextField();
        cULefty = new javax.swing.JCheckBox();
        submitCU = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        cULout = new javax.swing.JTextField();
        submitCUP = new javax.swing.JButton();
        finishProfile = new javax.swing.JPanel();
        profileLocChooser = new javax.swing.JFileChooser();
        saveModel = new javax.swing.JCheckBox();
        submitProfile = new javax.swing.JButton();
		
        grips();

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(Panel));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(Panel));
	}// </editor-fold>//GEN-END:initComponents

	private void cHThroughActionPerformed(java.awt.event.ActionEvent evt) {
		if (cHThrough.isSelected()) {
			cHLin.setText("70");
			cHLin.setEditable(false);
			gripFab.lin = 70.0;
		} else {
			cHLin.setEditable(true);
		}
	}

	private void rHThroughActionPerformed(java.awt.event.ActionEvent evt) {
		if (rHThrough.isSelected()) {
			rHLin.setText("70");
			rHLin.setEditable(false);
			gripFab.lin = 70.0;
		} else {
			rHLin.setEditable(true);
		}
	}

	protected void chooseGripActionPerformed(ActionEvent evt)
			throws GripNotFoundException {
		if (newCheck.isSelected()) {
			gripFab.stlTitle = gripBox.getSelectedItem() + ".stl";
			if (gripFab.stlTitle.equals("contracture.stl")) {
				eA();
				showStatus("contrature selected");
			} else
				throw new GripNotFoundException();
		} else if (profileCheck.isSelected()) {
			try {
				gripFab.readProfile(profileChooser.getSelectedFile());
				if (gripFab.position.equals("Protruded Cylinder Hole"))
					cH();
				else if (gripFab.position.equals("Protruded Rectangular Hole"))
					rH();
				else if (gripFab.position.equals("Angled Cylinder Barrel"))
					cU();
				else if (gripFab.position.equals("Angled Rectangular Barrel"))
					rU();
				else if (gripFab.position.equals("Straight Cylinder Barrel"))
					cL();
				else if (gripFab.position.equals("Straight Rectangular Barrel"))
					rL();
				else
					throw new PositionNotSupportedException();
				showStatus("profile selected");
			} catch (NumberFormatException e) {
				showStatus("NumberFormatException, contact developer.");
				e.printStackTrace();
			} catch (IOException e) {
				showStatus("IOException, file not located");
				e.printStackTrace();
			} catch (PositionNotSupportedException e) {
				showStatus("Position in profile is not supported");
				e.printStackTrace();
			}
		} else
			showStatus("please select an option.");
	}

	protected void chooseExtensionActionPerformed(ActionEvent evt)
			throws PositionNotSupportedException {
		gripFab.position = (String) extensionsBox.getSelectedItem();
		if (gripFab.position.equals("Protruded Cylinder Hole"))
			cH();
		else if (gripFab.position.equals("Protruded Rectangular Hole"))
			rH();
		else if (gripFab.position.equals("Angled Cylinder Barrel"))
			cU();
		else if (gripFab.position.equals("Angled Rectangular Barrel"))
			rU();
		else if (gripFab.position.equals("Straight Cylinder Barrel"))
			cL();
		else if (gripFab.position.equals("Straight Rectangular Barrel"))
			rL();
		else
			throw new PositionNotSupportedException();
	}

	protected void submitCHActionPerformed(ActionEvent evt) {
		showStatus("submitting diameter...");
		gripFab.diameter = Double.parseDouble(cHDiameter.getText());
		showStatus("submitting protrusion length...");
		gripFab.lin = Double.parseDouble(cHLin.getText());
		showStatus("submitting lefty...");
		gripFab.lefty = cHLefty.isSelected();
		showStatus("Altering unused settings...");
		gripFab.angle = 0;
		gripFab.height = 0;
		gripFab.width = 0;
		gripFab.lout = 0;
		showStatus("Settings Submitted: Please select File for printing");
		finish();

	}

	protected void submitRHActionPerformed(ActionEvent evt) {
		showStatus("submitting height...");
		gripFab.height = Double.parseDouble(rHHeight.getText());
		showStatus("submitting width...");
		gripFab.width = Double.parseDouble(rHWidth.getText());
		showStatus("submitting protrusion length...");
		gripFab.lin = Double.parseDouble(rHLin.getText());
		showStatus("submitting lefty...");
		gripFab.lefty = rHLefty.isSelected();
		showStatus("Altering unused settings...");
		gripFab.angle = 0;
		gripFab.diameter = 0;
		gripFab.lout = 0;
		showStatus("Settings Submitted: Please select File for printing");
		finish();

	}

	protected void submitCLActionPerformed(ActionEvent evt) {
		showStatus("submitting diameter...");
		gripFab.diameter = Double.parseDouble(cLDiameter.getText());
		showStatus("submitting protrusion length...");
		gripFab.lin = Double.parseDouble(cLLin.getText());
		showStatus("submitting extrusion length...");
		gripFab.lout = Double.parseDouble(cLLout.getText());
		showStatus("submitting lefty...");
		gripFab.lefty = cLLefty.isSelected();
		showStatus("Altering unused settings...");
		gripFab.angle = 0;
		gripFab.height = 0;
		gripFab.width = 0;
		showStatus("Settings Submitted: Please select File for printing");
		finish();
	}

	protected void submitRLActionPerformed(ActionEvent evt) {
		showStatus("submitting height...");
		gripFab.height = Double.parseDouble(rLHeight.getText());
		showStatus("submitting width...");
		gripFab.width = Double.parseDouble(rLWidth.getText());
		showStatus("submitting extrusion length...");
		gripFab.lout = Double.parseDouble(rLLout.getText());
		showStatus("submitting protrusion length...");
		gripFab.lin = Double.parseDouble(rLLin.getText());
		showStatus("submitting lefty...");
		gripFab.lefty = rLLefty.isSelected();
		showStatus("Altering unused settings...");
		gripFab.angle = 0;
		gripFab.diameter = 0;
		showStatus("Settings Submitted: Please select File for printing");
		finish();
	}

	protected void submitCUActionPerformed(ActionEvent evt) {
		showStatus("submitting diameter...");
		gripFab.diameter = Double.parseDouble(cUDiameter.getText());
		showStatus("submitting extrusion length...");
		gripFab.lout = Double.parseDouble(cULout.getText());
		showStatus("submitting lefty...");
		gripFab.lefty = cULefty.isSelected();
		showStatus("submitting angle...");
		gripFab.angle = Double.parseDouble(cUAngle.getText());
		showStatus("Altering unused settings...");
		gripFab.lin = 0;
		gripFab.height = 0;
		gripFab.width = 0;
		showStatus("Settings Submitted: Please select File for printing");
		finish();
	}

	protected void submitRUActionPerformed(ActionEvent evt) {
		showStatus("submitting height...");
		gripFab.height = Double.parseDouble(rUHeight.getText());
		showStatus("submitting width...");
		gripFab.width = Double.parseDouble(rUWidth.getText());
		showStatus("submitting extrusion length...");
		gripFab.lout = Double.parseDouble(rULout.getText());
		showStatus("submitting angle...");
		gripFab.angle = Double.parseDouble(rUAngle.getText());
		showStatus("submitting lefty...");
		gripFab.lefty = rULefty.isSelected();
		showStatus("Altering unused settings...");
		gripFab.lin = 0;
		gripFab.diameter = 0;
		showStatus("Settings Submitted: Please select File for printing");
		finish();
	}

	protected void submitFileActionPerformed(ActionEvent evt) {
		gripFab.filename = fileChooser.getSelectedFile().getAbsolutePath();
		try {
			gripFab.writefile();
		} catch (FileNotFoundException e) {
			showStatus("File not found error present");
			e.printStackTrace();
		} catch (PositionNotSupportedException e) {
			showStatus("position was not supported");
			e.printStackTrace();
		} catch (invalidDiameterException e) {
			showStatus("diameter was not supported");
			e.printStackTrace();
		} catch (STLNotPresentException e) {
			showStatus("STL was not present");
			e.printStackTrace();
		} catch (invalidDimmensionsException e) {
			showStatus("Dimmensions not supported");
			e.printStackTrace();
		} catch (IOException e) {
			showStatus("Files not in correct Directories");
			e.printStackTrace();
		} catch (InterruptedException e) {
			showStatus("interruped Excpetion");
			e.printStackTrace();
		}
		if (saveProfile.isSelected()) {
			try {
				gripFab.profileName = gripFab.filename.substring(0,
						gripFab.filename.lastIndexOf(".")) + ".txt";
				gripFab.writeProfile();
			} catch (FileNotFoundException e) {
				showStatus("File Not found");
				e.printStackTrace();
			}
		}
		showStatus("File was produced in selected folder");
	}

	protected void submitCHPActionPerformed(ActionEvent evt) {
		showStatus("submitting diameter...");
		gripFab.diameter = Double.parseDouble(cHDiameter.getText());
		showStatus("submitting protrusion length...");
		gripFab.lin = Double.parseDouble(cHLin.getText());
		showStatus("submitting lefty...");
		gripFab.lefty = cHLefty.isSelected();
		showStatus("Altering unused settings...");
		gripFab.angle = 0;
		gripFab.height = 0;
		gripFab.width = 0;
		gripFab.lout = 0;
		showStatus("Settings Submitted: Please select Profile Save Location");
		finishProfile();

	}

	protected void submitRHPActionPerformed(ActionEvent evt) {
		showStatus("submitting height...");
		gripFab.height = Double.parseDouble(rHHeight.getText());
		showStatus("submitting width...");
		gripFab.width = Double.parseDouble(rHWidth.getText());
		showStatus("submitting protrusion length...");
		gripFab.lin = Double.parseDouble(rHLin.getText());
		showStatus("submitting lefty...");
		gripFab.lefty = rHLefty.isSelected();
		showStatus("Altering unused settings...");
		gripFab.angle = 0;
		gripFab.diameter = 0;
		gripFab.lout = 0;
		showStatus("Settings Submitted: Please select Profilee Save Location");
		finishProfile();
	}

	protected void submitCLPActionPerformed(ActionEvent evt) {
		showStatus("submitting diameter...");
		gripFab.diameter = Double.parseDouble(cLDiameter.getText());
		showStatus("submitting protrusion length...");
		gripFab.lin = Double.parseDouble(cLLin.getText());
		showStatus("submitting extrusion length...");
		gripFab.lout = Double.parseDouble(cLLout.getText());
		showStatus("submitting lefty...");
		gripFab.lefty = cLLefty.isSelected();
		showStatus("Altering unused settings...");
		gripFab.angle = 0;
		gripFab.height = 0;
		gripFab.width = 0;
		showStatus("Settings Submitted: Please select Profilee Save Location");
		finishProfile();
	}

	protected void submitRLPActionPerformed(ActionEvent evt) {
		showStatus("submitting height...");
		gripFab.height = Double.parseDouble(rLHeight.getText());
		showStatus("submitting width...");
		gripFab.width = Double.parseDouble(rLWidth.getText());
		showStatus("submitting extrusion length...");
		gripFab.lout = Double.parseDouble(rLLout.getText());
		showStatus("submitting protrusion length...");
		gripFab.lin = Double.parseDouble(rLLin.getText());
		showStatus("submitting lefty...");
		gripFab.lefty = rLLefty.isSelected();
		showStatus("Altering unused settings...");
		gripFab.angle = 0;
		gripFab.diameter = 0;
		showStatus("Settings Submitted: Please select Profilee Save Location");
		finishProfile();
	}

	protected void submitRUPActionPerformed(ActionEvent evt) {
		showStatus("submitting height...");
		gripFab.height = Double.parseDouble(rUHeight.getText());
		showStatus("submitting width...");
		gripFab.width = Double.parseDouble(rUWidth.getText());
		showStatus("submitting extrusion length...");
		gripFab.lout = Double.parseDouble(rULout.getText());
		showStatus("submitting angle...");
		gripFab.angle = Double.parseDouble(rUAngle.getText());
		showStatus("submitting lefty...");
		gripFab.lefty = rULefty.isSelected();
		showStatus("Altering unused settings...");
		gripFab.lin = 0;
		gripFab.diameter = 0;
		showStatus("Settings Submitted: Please select Profilee Save Location");
		finishProfile();
	}

	protected void submitCUPActionPerformed(ActionEvent evt) {
		showStatus("submitting diameter...");
		gripFab.diameter = Double.parseDouble(cUDiameter.getText());
		showStatus("submitting extrusion length...");
		gripFab.lout = Double.parseDouble(cULout.getText());
		showStatus("submitting lefty...");
		gripFab.lefty = cULefty.isSelected();
		showStatus("submitting angle...");
		gripFab.angle = Double.parseDouble(cUAngle.getText());
		showStatus("Altering unused settings...");
		gripFab.lin = 0;
		gripFab.height = 0;
		gripFab.width = 0;
		showStatus("Settings Submitted: Please select Profilee Save Location");
		finishProfile();
	}

	protected void submitProfileActionPerformed(ActionEvent evt) {
		gripFab.profileName = profileLocChooser.getSelectedFile()
				.getAbsolutePath();
		try {
			gripFab.writeProfile();
		} catch (FileNotFoundException e) {
			showStatus("File not found error present");
			e.printStackTrace();
		}
		if (saveModel.isSelected()) {
			try {
				gripFab.filename = gripFab.profileName
						.substring(gripFab.profileName.lastIndexOf("."))
						+ ".scad";
				gripFab.writefile();
			} catch (FileNotFoundException e) {
				showStatus("File Not found");
				e.printStackTrace();
			} catch (PositionNotSupportedException e) {
				showStatus("position was not supported");
				e.printStackTrace();
			} catch (invalidDiameterException e) {
				showStatus("diameter was not supported");
				e.printStackTrace();
			} catch (STLNotPresentException e) {
				showStatus("STL was not present");
				e.printStackTrace();
			} catch (invalidDimmensionsException e) {
				showStatus("Dimmensions not supported");
				e.printStackTrace();
			} catch (IOException e) {
				showStatus("Incorrect directories");
				e.printStackTrace();
			} catch (InterruptedException e) {
				showStatus("InterrruptedException");
				e.printStackTrace();
			}
		}
		showStatus("File was produced in selected folder");

	}

	private void grips() {
        gripBox.setModel(new javax.swing.DefaultComboBoxModel(gripList));

        chooseGrip.setText("Choose");
        chooseGrip.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					chooseGripActionPerformed(evt);
				} catch (GripNotFoundException e) {
					showStatus("Grip was not found exception");
					e.printStackTrace();
				}
			}
		});

        jLabel18.setText("or");

        profileChooser.setCurrentDirectory(new java.io.File("C:\\Users\\Megan\\Desktop\\LittlefootPrints"));

        buttonGroup1.add(newCheck);
        newCheck.setSelected(true);
        newCheck.setText("New Grip");

        buttonGroup1.add(profileCheck);
        profileCheck.setText("Grip From Profile:");

        javax.swing.GroupLayout gripsLayout = new javax.swing.GroupLayout(grips);
        grips.setLayout(gripsLayout);
        gripsLayout.setHorizontalGroup(
            gripsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gripsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gripsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profileChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                    .addGroup(gripsLayout.createSequentialGroup()
                        .addComponent(newCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gripBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(gripsLayout.createSequentialGroup()
                        .addComponent(profileCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chooseGrip))
                    .addGroup(gripsLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel18)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        gripsLayout.setVerticalGroup(
            gripsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gripsLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(gripsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gripBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gripsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chooseGrip)
                    .addComponent(profileCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(profileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

		Panel.addTab("Grips", grips);
	}

	private void eA() {
		jLabel3.setText("Extension:");

		extensionsBox
				.setModel(new javax.swing.DefaultComboBoxModel(extensions));

		chooseExtension.setText("Choose");
		chooseExtension.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					chooseExtensionActionPerformed(evt);
				} catch (PositionNotSupportedException e) {
					showStatus("Position was not supported? We are very sorry we put that there, how silly. Choose another option please.");
					e.printStackTrace();
				}
			}
		});

		javax.swing.GroupLayout eALayout = new javax.swing.GroupLayout(eA);
		eA.setLayout(eALayout);
		eALayout.setHorizontalGroup(eALayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						eALayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jLabel3)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(extensionsBox, 0, 359,
										Short.MAX_VALUE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(chooseExtension)
								.addContainerGap()));
		eALayout.setVerticalGroup(eALayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						eALayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										eALayout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel3)
												.addComponent(
														extensionsBox,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(chooseExtension))
								.addContainerGap(375, Short.MAX_VALUE)));
		Panel.addTab("Extension", eA);
		Panel.setSelectedIndex(Panel.indexOfTab("Extension"));
	}

	private void cH() {
		jLabel5.setText("Diameter:");

		jLabel6.setText("Protrusion Length:");

		cHLin.setText(gripFab.lin + "");

		cHDiameter.setText(gripFab.diameter + "");

		cHThrough.setText("Through");
		cHThrough.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cHThroughActionPerformed(evt);
			}
		});

		cHLefty.setText("Lefty");

		submitCH.setText("Submit File");
		submitCH.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitCHActionPerformed(evt);
			}
		});

		submitCHP.setText("Submit Profile");
		submitCHP.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitCHPActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout cHLayout = new javax.swing.GroupLayout(cH);
		cH.setLayout(cHLayout);
		cHLayout.setHorizontalGroup(cHLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						cHLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										cHLayout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														cHLayout.createSequentialGroup()
																.addGroup(
																		cHLayout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel6)
																				.addComponent(
																						jLabel5))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		cHLayout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						cHDiameter,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGroup(
																						cHLayout.createSequentialGroup()
																								.addComponent(
																										cHLin,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																								.addComponent(
																										cHThrough))))
												.addComponent(cHLefty)
												.addGroup(
														cHLayout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																false)
																.addComponent(
																		submitCH,
																		javax.swing.GroupLayout.Alignment.LEADING,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(
																		submitCHP,
																		javax.swing.GroupLayout.Alignment.LEADING,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)))
								.addContainerGap(345, Short.MAX_VALUE)));
		cHLayout.setVerticalGroup(cHLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						cHLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										cHLayout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel5)
												.addComponent(
														cHDiameter,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										cHLayout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel6)
												.addComponent(
														cHLin,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(cHThrough))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(cHLefty)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(submitCH)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(submitCHP)
								.addContainerGap(351, Short.MAX_VALUE)));

		Panel.remove(rH);
		Panel.remove(cL);
		Panel.remove(rL);
		Panel.remove(cU);
		Panel.remove(rU);
		Panel.addTab("Settings", cH);
		Panel.setSelectedIndex(Panel.indexOfTab("Settings"));
	}

	private void rH() {
		jLabel7.setText("Height:");

		jLabel8.setText("Protrusion Length:");

		rHLin.setText(gripFab.lin + "");

		rHHeight.setText(gripFab.height + "");

		rHThrough.setText("Through");
		rHThrough.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				rHThroughActionPerformed(evt);
			}
		});

		rHLefty.setText("Lefty");

		submitRH.setText("Submit File");
		submitRH.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitRHActionPerformed(evt);
			}
		});

		jLabel9.setText("Width:");

		rHWidth.setText(gripFab.width + "");

		submitRHP.setText("Submit Profile");
		submitRHP.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitRHPActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout rHLayout = new javax.swing.GroupLayout(rH);
		rH.setLayout(rHLayout);
		rHLayout.setHorizontalGroup(rHLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						rHLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										rHLayout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(rHLefty)
												.addGroup(
														rHLayout.createSequentialGroup()
																.addGroup(
																		rHLayout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel8)
																				.addComponent(
																						jLabel9)
																				.addComponent(
																						jLabel7))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		rHLayout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						rHHeight,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						rHWidth,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGroup(
																						rHLayout.createSequentialGroup()
																								.addComponent(
																										rHLin,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																								.addComponent(
																										rHThrough))))
												.addGroup(
														rHLayout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																false)
																.addComponent(
																		submitRH,
																		javax.swing.GroupLayout.Alignment.LEADING,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(
																		submitRHP,
																		javax.swing.GroupLayout.Alignment.LEADING,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)))
								.addContainerGap(371, Short.MAX_VALUE)));
		rHLayout.setVerticalGroup(rHLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						rHLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										rHLayout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel7)
												.addComponent(
														rHHeight,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										rHLayout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel9)
												.addComponent(
														rHWidth,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										rHLayout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel8)
												.addComponent(
														rHLin,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(rHThrough))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(rHLefty)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(submitRH)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(submitRHP)
								.addContainerGap(359, Short.MAX_VALUE)));

		Panel.addTab("Settings", rH);
		Panel.remove(cH);
		Panel.remove(cL);
		Panel.remove(rL);
		Panel.remove(cU);
		Panel.remove(rU);
		Panel.setSelectedIndex(Panel.indexOfTab("Settings"));
	}

	private void cL() {
		jLabel14.setText("Diameter:");

		jLabel15.setText("Protrusion Length:");

		cLLin.setText(gripFab.lin + "");

		cLDiameter.setText(gripFab.diameter + "");

		cLLefty.setText("Lefty");

		submitCL.setText("Submit File");
		submitCL.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitCLActionPerformed(evt);
			}
		});

		jLabel17.setText("Extension Length:");

		cLLout.setText(gripFab.lout + "");

		submitCLP.setText("Submit Profile");
		submitCLP.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitCLPActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout cLLayout = new javax.swing.GroupLayout(cL);
		cL.setLayout(cLLayout);
		cLLayout.setHorizontalGroup(cLLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						cLLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										cLLayout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(cLLefty)
												.addGroup(
														cLLayout.createSequentialGroup()
																.addGroup(
																		cLLayout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel14)
																				.addComponent(
																						jLabel16)
																				.addComponent(
																						jLabel17)
																				.addComponent(
																						jLabel15))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		cLLayout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						cLDiameter,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						cLLin,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						cLLout,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addGroup(
														cLLayout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																false)
																.addComponent(
																		submitCL,
																		javax.swing.GroupLayout.Alignment.LEADING,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(
																		submitCLP,
																		javax.swing.GroupLayout.Alignment.LEADING,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)))
								.addContainerGap(449, Short.MAX_VALUE)));
		cLLayout.setVerticalGroup(cLLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						cLLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										cLLayout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel14)
												.addComponent(
														cLDiameter,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel16)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										cLLayout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														cLLout,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel17))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										cLLayout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel15)
												.addComponent(
														cLLin,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(cLLefty)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(submitCL)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(submitCLP)
								.addContainerGap(346, Short.MAX_VALUE)));

		Panel.remove(cH);
		Panel.remove(rH);
		Panel.remove(rL);
		Panel.remove(cU);
		Panel.remove(rU);
		Panel.addTab("Settings", cL);
		Panel.setSelectedIndex(Panel.indexOfTab("Settings"));
	}

	private void rL() {
		jLabel10.setText("Height:");

		jLabel11.setText("Protrusion Length:");

		rLLin.setText(gripFab.lin + "");

		rLHeight.setText(gripFab.height + "");

		rLLefty.setText("Lefty");

		submitRL.setText("Submit File");
		submitRL.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitRLActionPerformed(evt);
			}
		});

		jLabel12.setText("Width:");

		rLWidth.setText(gripFab.width + "");

		jLabel13.setText("Extension Length:");

		rLLout.setText(gripFab.lout + "");

		submitRLP.setText("Submit Profile");
		submitRLP.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitRLPActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout rLLayout = new javax.swing.GroupLayout(rL);
		rL.setLayout(rLLayout);
		rLLayout.setHorizontalGroup(rLLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						rLLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										rLLayout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														rLLayout.createSequentialGroup()
																.addComponent(
																		jLabel12)
																.addGap(75, 75,
																		75)
																.addComponent(
																		rLWidth,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(rLLefty)
												.addGroup(
														rLLayout.createSequentialGroup()
																.addGroup(
																		rLLayout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel13)
																				.addComponent(
																						jLabel10))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(
																		rLLayout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						rLHeight,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						rLLout,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addGroup(
														rLLayout.createSequentialGroup()
																.addComponent(
																		jLabel11)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		rLLin,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(
														rLLayout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																false)
																.addComponent(
																		submitRL,
																		javax.swing.GroupLayout.Alignment.LEADING,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(
																		submitRLP,
																		javax.swing.GroupLayout.Alignment.LEADING,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)))
								.addContainerGap(446, Short.MAX_VALUE)));
		rLLayout.setVerticalGroup(rLLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						rLLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										rLLayout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel10)
												.addComponent(
														rLHeight,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										rLLayout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel12)
												.addComponent(
														rLWidth,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										rLLayout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel13)
												.addComponent(
														rLLout,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										rLLayout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel11)
												.addComponent(
														rLLin,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(rLLefty)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(submitRL)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(submitRLP)
								.addContainerGap(324, Short.MAX_VALUE)));

		Panel.addTab("Settings", rL);
		Panel.remove(cH);
		Panel.remove(rH);
		Panel.remove(cL);
		Panel.remove(rU);
		Panel.remove(cU);
		Panel.setSelectedIndex(Panel.indexOfTab("Settings"));
	}

	private void cU() {
		jLabel26.setText("Diameter:");

		jLabel27.setText("Angle:");

		cUAngle.setText(gripFab.angle + "");

		cUDiameter.setText(gripFab.diameter + "");

		cULefty.setText("Lefty");

		submitCU.setText("Submit File");
		submitCU.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitCUActionPerformed(evt);
			}
		});

		jLabel29.setText("Extension Length:");

		cULout.setText(gripFab.lout + "");

		submitCUP.setText("Submit Profile");
		submitCUP.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitCUPActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout cULayout = new javax.swing.GroupLayout(cU);
		cU.setLayout(cULayout);
		cULayout.setHorizontalGroup(cULayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						cULayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										cULayout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(cULefty)
												.addGroup(
														cULayout.createSequentialGroup()
																.addComponent(
																		jLabel26)
																.addGap(56, 56,
																		56)
																.addComponent(
																		cUDiameter,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(
														cULayout.createSequentialGroup()
																.addGroup(
																		cULayout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel29)
																				.addComponent(
																						jLabel27))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(
																		cULayout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						cUAngle,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						cULout,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addGroup(
														cULayout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																false)
																.addComponent(
																		submitCU,
																		javax.swing.GroupLayout.Alignment.LEADING,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(
																		submitCUP,
																		javax.swing.GroupLayout.Alignment.LEADING,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)))
								.addContainerGap(446, Short.MAX_VALUE)));
		cULayout.setVerticalGroup(cULayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						cULayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										cULayout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel26)
												.addComponent(
														cUDiameter,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										cULayout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel29)
												.addComponent(
														cULout,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										cULayout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel27)
												.addComponent(
														cUAngle,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(cULefty)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(submitCU)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(submitCUP)
								.addContainerGap(359, Short.MAX_VALUE)));
		Panel.remove(cH);
		Panel.remove(rH);
		Panel.remove(cL);
		Panel.remove(rL);
		Panel.remove(rU);
		Panel.addTab("Settings", cU);
		Panel.setSelectedIndex(Panel.indexOfTab("Settings"));
	}

	private void rU() {
		jLabel22.setText("Height:");

		jLabel23.setText("Angle:");

		rUAngle.setText(gripFab.angle + "");

		rUHeight.setText(gripFab.height + "");

		rULefty.setText("Lefty");

		submitRU.setText("Submit File");
		submitRU.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitRUActionPerformed(evt);
			}
		});

		jLabel24.setText("Width:");

		rUWidth.setText(gripFab.width + "");

		jLabel25.setText("Extension Length:");

		rULout.setText(gripFab.lout + "");

		submitRUP.setText("Submit Profile");
		submitRUP.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitRUPActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout rULayout = new javax.swing.GroupLayout(rU);
		rU.setLayout(rULayout);
		rULayout.setHorizontalGroup(rULayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						rULayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										rULayout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														rULayout.createSequentialGroup()
																.addComponent(
																		jLabel24)
																.addGap(75, 75,
																		75)
																.addComponent(
																		rUWidth,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(rULefty)
												.addGroup(
														rULayout.createSequentialGroup()
																.addGroup(
																		rULayout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel25)
																				.addComponent(
																						jLabel22)
																				.addComponent(
																						jLabel23))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(
																		rULayout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						rUAngle,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						rUHeight,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						rULout,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addGroup(
														rULayout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																false)
																.addComponent(
																		submitRU,
																		javax.swing.GroupLayout.Alignment.LEADING,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(
																		submitRUP,
																		javax.swing.GroupLayout.Alignment.LEADING,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)))
								.addContainerGap(446, Short.MAX_VALUE)));
		rULayout.setVerticalGroup(rULayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						rULayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										rULayout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel22)
												.addComponent(
														rUHeight,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										rULayout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel24)
												.addComponent(
														rUWidth,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										rULayout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel25)
												.addComponent(
														rULout,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										rULayout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel23)
												.addComponent(
														rUAngle,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(rULefty)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(submitRU)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(submitRUP)
								.addContainerGap(324, Short.MAX_VALUE)));

		Panel.remove(cH);
		Panel.remove(rH);
		Panel.remove(cL);
		Panel.remove(rL);
		Panel.remove(cU);
		Panel.addTab("Settings", rU);
		Panel.setSelectedIndex(Panel.indexOfTab("Settings"));
	}

	private void finish() {
		submitFile.setText("Submit");
		submitFile.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitFileActionPerformed(evt);
			}
		});

		fileChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
		fileChooser.setCurrentDirectory(new java.io.File(
				"C:\\Users\\Megan\\Desktop\\LittlefootPrints"));

		saveProfile.setText("Save Profile In same Location?");

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
														.addGroup(
																finishLayout
																		.createSequentialGroup()
																		.addComponent(
																				fileChooser,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				0,
																				Short.MAX_VALUE)
																		.addContainerGap())
														.addGroup(
																finishLayout
																		.createSequentialGroup()
																		.addComponent(
																				saveProfile)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				284,
																				Short.MAX_VALUE)
																		.addComponent(
																				submitFile)
																		.addGap(26,
																				26,
																				26)))));
		finishLayout
				.setVerticalGroup(finishLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								finishLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												fileChooser,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												finishLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																submitFile)
														.addComponent(
																saveProfile))
										.addContainerGap()));
		Panel.remove(finishProfile);
		Panel.addTab("Finish", finish);
		Panel.setSelectedIndex(Panel.indexOfTab("Finish"));
	}

	public void finishProfile() {
		profileLocChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
		profileLocChooser.setCurrentDirectory(new java.io.File(
				"C:\\Users\\Megan\\Desktop\\LittlefootPrints"));

		saveModel.setText("save model file in same directory?");

		submitProfile.setText("submit");
		submitProfile.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitProfileActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout finishProfileLayout = new javax.swing.GroupLayout(
				finishProfile);
		finishProfile.setLayout(finishProfileLayout);
		finishProfileLayout
				.setHorizontalGroup(finishProfileLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								finishProfileLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												finishProfileLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																finishProfileLayout
																		.createSequentialGroup()
																		.addComponent(
																				profileLocChooser,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				574,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(0,
																				0,
																				Short.MAX_VALUE))
														.addGroup(
																finishProfileLayout
																		.createSequentialGroup()
																		.addComponent(
																				saveModel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				submitProfile)))
										.addContainerGap()));
		finishProfileLayout
				.setVerticalGroup(finishProfileLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								finishProfileLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												profileLocChooser,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												482, Short.MAX_VALUE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												finishProfileLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																saveModel,
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																submitProfile,
																javax.swing.GroupLayout.Alignment.TRAILING))
										.addContainerGap()));

		Panel.remove(finish);
		Panel.addTab("Finish", finishProfile);
		Panel.setSelectedIndex(Panel.indexOfTab("Finish"));
	}

}
