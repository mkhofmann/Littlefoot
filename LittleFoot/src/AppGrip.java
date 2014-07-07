/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;


/**
 * 
 * @author Megan
 */
public class AppGrip extends javax.swing.JApplet {
	// my variables
	private String[] gripList = { "gripA.stl", "gripB.stl" };
	private String[] extensions = { "Protruded Cylinder Hole",
			"Protruded Rectangular Hole", "Angled Cylinder Barrel",
			"Angled Rectangular Barrel" };
	private String[] extensionsB = { "Straight Cylinder Barrel",
			"Straight Rectangular Barrel" };
	private GripFab gripFab = new GripFab();
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTabbedPane Panel;
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
	private javax.swing.JTextField fileLocation;
	private javax.swing.JPanel finish;
	private javax.swing.JComboBox gripBox;
	private javax.swing.JPanel grips;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel22;
	private javax.swing.JLabel jLabel23;
	private javax.swing.JLabel jLabel24;
	private javax.swing.JLabel jLabel25;
	private javax.swing.JLabel jLabel26;
	private javax.swing.JLabel jLabel27;
	private javax.swing.JLabel jLabel29;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
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
	private javax.swing.JButton submitCH;
	private javax.swing.JButton submitCL;
	private javax.swing.JButton submitCU;
	private javax.swing.JButton submitFile;
	private javax.swing.JButton submitRH;
	private javax.swing.JButton submitRL;
	private javax.swing.JButton submitRU;

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
		resize(600, 425);
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

		Panel = new javax.swing.JTabbedPane();
		grips = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		gripBox = new javax.swing.JComboBox();
		chooseGrip = new javax.swing.JButton();
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
		finish = new javax.swing.JPanel();
		jLabel4 = new javax.swing.JLabel();
		fileLocation = new javax.swing.JTextField();
		submitFile = new javax.swing.JButton();
		fileChooser = new javax.swing.JFileChooser();
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
		cU = new javax.swing.JPanel();
		jLabel26 = new javax.swing.JLabel();
		jLabel27 = new javax.swing.JLabel();
		cUAngle = new javax.swing.JTextField();
		cUDiameter = new javax.swing.JTextField();
		cULefty = new javax.swing.JCheckBox();
		submitCU = new javax.swing.JButton();
		jLabel29 = new javax.swing.JLabel();
		cULout = new javax.swing.JTextField();

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
			cHLin.setText("60");
			cHLin.setEditable(false);
			gripFab.lin = 60.0;
		} else {
			cHLin.setEditable(true);
		}
	}

	private void rHThroughActionPerformed(java.awt.event.ActionEvent evt) {
		if (rHThrough.isSelected()) {
			rHLin.setText("60");
			rHLin.setEditable(false);
			gripFab.lin = 60.0;
		} else {
			rHLin.setEditable(true);
		}
	}

	protected void chooseGripActionPerformed(ActionEvent evt)
			throws GripNotFoundException {
		gripFab.stlTitle = (String) gripBox.getSelectedItem();
		if (gripFab.stlTitle.equals("gripA.stl")) {
			eA();
			showStatus("gripA selected");
		}
		if (gripFab.stlTitle.equals("gripB.stl")) {
			eB();
			showStatus("gripB selected");
		} else
			;
		throw new GripNotFoundException();
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

	protected void chooseExtensionBActionPerformed(ActionEvent evt)
			throws PositionNotSupportedException {
		gripFab.position = (String) extensionBBox.getSelectedItem();
		if (gripFab.position.equals("Straight Cylinder Barrel"))
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

	protected void submitCUhActionPerformed(ActionEvent evt) {
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
		fileLocation.setText(fileChooser.getSelectedFile().getAbsolutePath());
		gripFab.filename = fileLocation.getText();
		try {
			gripFab.writefile();
		} catch (FileNotFoundException e) {
			showStatus("File not found error present");
			e.printStackTrace();
		} catch (PositionNotSupportedException e) {
			showStatus("Position Was not supported, this should never be reached.");
			e.printStackTrace();
		} catch (invalidDiameterException e) {
			showStatus("You gave an invalid Diameter. Please use less then 10mm");
			e.printStackTrace();
		} catch (STLNotPresentException e) {
			showStatus("StL was not present. this should never be reached");
			e.printStackTrace();
		}
	}

	private void grips() {
		jLabel1.setText("Grip:");

		gripBox.setModel(new javax.swing.DefaultComboBoxModel(gripList));

		chooseGrip.setText("Choose");
		chooseGrip.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					chooseGripActionPerformed(evt);
				} catch (GripNotFoundException e) {
					showStatus("Grip was not found, please check file system for stl or use different grip.");
					e.printStackTrace();
				}
			}
		});

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
										.addComponent(jLabel1)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(gripBox, 0, 390,
												Short.MAX_VALUE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(chooseGrip)
										.addContainerGap()));
		gripsLayout
				.setVerticalGroup(gripsLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								gripsLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gripsLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel1)
														.addComponent(
																gripBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																chooseGrip))
										.addContainerGap(375, Short.MAX_VALUE)));

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
		Panel.remove(eB);
		Panel.addTab("Extension", eA);
		Panel.setSelectedIndex(Panel.indexOfTab("Extension"));
	}

	private void eB() {
		jLabel2.setText("Extension:");

		extensionBBox
				.setModel(new javax.swing.DefaultComboBoxModel(extensionsB));

		chooseExtensionB.setText("Choose");
		chooseExtensionB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					chooseExtensionBActionPerformed(evt);
				} catch (PositionNotSupportedException e) {
					showStatus("We are so sorry that this position is not supported? We were stupid to make it an option. Please try another.");
					e.printStackTrace();
				}
			}
		});

		javax.swing.GroupLayout eBLayout = new javax.swing.GroupLayout(eB);
		eB.setLayout(eBLayout);
		eBLayout.setHorizontalGroup(eBLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						eBLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jLabel2)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(extensionBBox, 0, 359,
										Short.MAX_VALUE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(chooseExtensionB)
								.addContainerGap()));
		eBLayout.setVerticalGroup(eBLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						eBLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										eBLayout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel2)
												.addComponent(
														extensionBBox,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(chooseExtensionB))
								.addContainerGap(375, Short.MAX_VALUE)));
		Panel.remove(eA);
		Panel.addTab("Extension", eB);
		Panel.setSelectedIndex(Panel.indexOfTab("Extension"));
	}

	private void cH() {
		jLabel5.setText("Diameter:");

		jLabel6.setText("Protrusion Length:");

		cHLin.setText("000");

		cHDiameter.setText("0");

		cHThrough.setText("Through");
		cHThrough.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cHThroughActionPerformed(evt);
			}
		});

		cHLefty.setText("Lefty");

		submitCH.setText("Submit");
		submitCH.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitCHActionPerformed(evt);
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
												.addComponent(submitCH))
								.addContainerGap(295, Short.MAX_VALUE)));
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
								.addContainerGap(281, Short.MAX_VALUE)));
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

		rHLin.setText("00");

		rHHeight.setText("0");

		rHThrough.setText("Through");
		rHThrough.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				rHThroughActionPerformed(evt);
			}
		});

		rHLefty.setText("Lefty");

		submitRH.setText("Submit");
		submitRH.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitRHActionPerformed(evt);
			}
		});

		jLabel9.setText("Width:");

		rHWidth.setText("0");

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
												.addComponent(submitRH)
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
																										rHThrough)))))
								.addContainerGap(302, Short.MAX_VALUE)));
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
								.addContainerGap(258, Short.MAX_VALUE)));
		Panel.remove(cH);
		Panel.remove(cL);
		Panel.remove(rL);
		Panel.remove(cU);
		Panel.remove(rU);
		Panel.addTab("Settings", rH);
		Panel.setSelectedIndex(Panel.indexOfTab("Settings"));
	}

	private void cL() {
		jLabel14.setText("Diameter:");

		jLabel15.setText("Protrusion Length:");

		cLLin.setText("00");

		cLDiameter.setText("0");

		cLLefty.setText("Lefty");

		submitCL.setText("Submit");
		submitCL.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitCLActionPerformed(evt);
			}
		});

		jLabel17.setText("Extension Length:");

		cLLout.setText("000");

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
												.addComponent(submitCL)
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
																						javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addContainerGap(380, Short.MAX_VALUE)));
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
								.addContainerGap(245, Short.MAX_VALUE)));

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

		rLLin.setText("00");

		rLHeight.setText("0");

		rLLefty.setText("Lefty");

		submitRL.setText("Submit");
		submitRL.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitRLActionPerformed(evt);
			}
		});

		jLabel12.setText("Width:");

		rLWidth.setText("0");

		jLabel13.setText("Extension Length:");

		rLLout.setText("000");

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
												.addComponent(submitRL))
								.addContainerGap(377, Short.MAX_VALUE)));
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
								.addContainerGap(223, Short.MAX_VALUE)));

		Panel.remove(cH);
		Panel.remove(rH);
		Panel.remove(cL);
		Panel.remove(rU);
		Panel.remove(cU);
		Panel.addTab("Settings", rL);
		Panel.setSelectedIndex(Panel.indexOfTab("Settings"));
	}

	private void cU() {
		jLabel26.setText("Diameter:");

		jLabel27.setText("Angle:");

		cUAngle.setText("00");

		cUDiameter.setText("0");

		cULefty.setText("Lefty");

		submitCU.setText("Submit");
		submitCU.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitCUhActionPerformed(evt);
			}
		});

		jLabel29.setText("Extension Length:");

		cULout.setText("000");

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
												.addComponent(submitCU)
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
																						javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addContainerGap(377, Short.MAX_VALUE)));
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
								.addContainerGap(258, Short.MAX_VALUE)));

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

		rUAngle.setText("00");

		rUHeight.setText("0");

		rULefty.setText("Lefty");

		submitRU.setText("Submit");
		submitRU.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitRUActionPerformed(evt);
			}
		});

		jLabel24.setText("Width:");

		rUWidth.setText("0");

		jLabel25.setText("Extension Length:");

		rULout.setText("000");

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
												.addComponent(submitRU)
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
																						javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addContainerGap(377, Short.MAX_VALUE)));
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
								.addContainerGap(223, Short.MAX_VALUE)));

		Panel.remove(cH);
		Panel.remove(rH);
		Panel.remove(cL);
		Panel.remove(rL);
		Panel.remove(cU);
		Panel.addTab("Settings", rU);
		Panel.setSelectedIndex(Panel.indexOfTab("Settings"));
	}

	private void finish() {
		jLabel4.setText("FileLocation:");

		fileLocation.setText("enter File Location");

		submitFile.setText("Submit");
		submitFile.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitFileActionPerformed(evt);
			}
		});

		fileChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
		fileChooser.setCurrentDirectory(new java.io.File(
				"C:\\Users\\Megan\\Desktop\\LittlefootPrints"));

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
																				jLabel4)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				fileLocation)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				submitFile))
														.addGroup(
																finishLayout
																		.createSequentialGroup()
																		.addComponent(
																				fileChooser,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				505,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
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
										.addGroup(
												finishLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel4)
														.addComponent(
																fileLocation,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																submitFile))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												fileChooser,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												355,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		Panel.addTab("Finish", finish);
		Panel.setSelectedIndex(Panel.indexOfTab("Finish"));
	}

}
