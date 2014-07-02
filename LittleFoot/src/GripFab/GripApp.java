/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GripFab;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

/**
 * 
 * @author Megan
 */
public class GripApp extends javax.swing.JApplet {

	/**
	 * Initializes the applet GripApp
	 */

	// my variables
	String[] grips = { "gripA.stl", "gripB.stl" };
	String[] extensions = { "Protruded Cylinder Hole",
			"Protruded Rectangular Hole", "Angled Cylinder Barrel",
			"Angled Rectangular Barrel" };
	String[] extensionsB = { "Straight Cylinder Barrel",
			"Straight Rectangular Barrel" };
	GripFab gripFab = new GripFab();

	boolean extenstionTab = false;
	boolean extenstionBTab = false;
	boolean cylUlTab = false;
	boolean cylLTab = false;
	boolean recULTab = false;
	boolean recLTab = false;
	boolean recHoleTab = false;
	boolean cylHoleTab = false;
	boolean finishTab = false;

	// Variables declaration - do not modify//GEN-BEGIN:variables

	private javax.swing.JLabel ExtensionLabel;
	private javax.swing.JLabel ExtensionLabelB;
	private javax.swing.JTabbedPane Panel;
	private javax.swing.JTextField angleCyl;
	private javax.swing.JLabel angleCylLabel;
	private javax.swing.JTextField angleULRec;
	private javax.swing.JButton chooseExtension;
	private javax.swing.JButton chooseExtensionB;
	private javax.swing.JButton chooseFile;
	private javax.swing.JButton chooseGrips;
	private javax.swing.JTextField cylHoleLin;
	private javax.swing.JLabel cylHoleLinLabel;
	private javax.swing.JInternalFrame cylHoleSetPanel;
	private javax.swing.JInternalFrame cylLSetPanel;
	private javax.swing.JCheckBox cylThroughCheck;
	private javax.swing.JInternalFrame cylULSetPanel;
	private javax.swing.JTextField diameterL;
	private javax.swing.JLabel diameterLLabel;
	private javax.swing.JTextField diameterUL;
	private javax.swing.JLabel diameterULLabel;
	private javax.swing.JComboBox extensionBox;
	private javax.swing.JComboBox extensionBoxB;
	private javax.swing.JInternalFrame extrusionPanel;
	private javax.swing.JInternalFrame extrusionPanelB;
	private javax.swing.JLabel fileLabel;
	private javax.swing.JTextField fileLocation;
	private javax.swing.JInternalFrame finishPanel;
	private javax.swing.JLabel gripLabel;
	private javax.swing.JInternalFrame gripPanel;
	private javax.swing.JComboBox gripsBox;
	private javax.swing.JTextField heightL;
	private javax.swing.JTextField heightUL;
	private javax.swing.JLabel heigthLLabel;
	private javax.swing.JTextField holeDiameter;
	private javax.swing.JLabel holeDiameterLabel;
	private javax.swing.JTextField holeHeight;
	private javax.swing.JLabel holeHeightLabel;
	private javax.swing.JTextField holeWidth;
	private javax.swing.JLabel holeWidthLabel;
	private javax.swing.JFileChooser jFileChooser1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JCheckBox leftyCylHole;
	private javax.swing.JCheckBox leftyCylUL;
	private javax.swing.JCheckBox leftyLCyl;
	private javax.swing.JCheckBox leftyLRec;
	private javax.swing.JCheckBox leftyRecHole;
	private javax.swing.JCheckBox leftyULRec;
	private javax.swing.JTextField linCyl;
	private javax.swing.JLabel linCylLabel;
	private javax.swing.JTextField linRec;
	private javax.swing.JLabel linRecLabel;
	private javax.swing.JLabel loutCylULLabel;
	private javax.swing.JTextField loutLCyl;
	private javax.swing.JLabel loutLCylLabel;
	private javax.swing.JTextField loutLRec;
	private javax.swing.JLabel loutLRecLabel;
	private javax.swing.JTextField loutULCyl;
	private javax.swing.JTextField loutULRec;
	private javax.swing.JTextField recHoleLin;
	private javax.swing.JLabel recHoleLinLabel;
	private javax.swing.JInternalFrame recHoleSetPanel;
	private javax.swing.JInternalFrame recLocSetPanel;
	private javax.swing.JCheckBox recThroughCheck;
	private javax.swing.JInternalFrame recUnlockSetPanel;
	private javax.swing.JButton submitCylHole;
	private javax.swing.JButton submitFile;
	private javax.swing.JButton submitLCyl;
	private javax.swing.JButton submitLRec;
	private javax.swing.JButton submitRecHole;
	private javax.swing.JButton submitULCyl;
	private javax.swing.JButton submitULRec;
	private javax.swing.JTextField widthL;
	private javax.swing.JLabel widthLLabel;
	private javax.swing.JTextField widthUL;

	// End of variables declaration//GEN-END:variables
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
		resize(300,225);
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(GripApp.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GripApp.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GripApp.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GripApp.class.getName()).log(
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

	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		Panel = new javax.swing.JTabbedPane();
		gripPanel = new javax.swing.JInternalFrame();
		gripLabel = new javax.swing.JLabel();
		gripsBox = new javax.swing.JComboBox();
		chooseGrips = new javax.swing.JButton();
		recUnlockSetPanel = new javax.swing.JInternalFrame();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		loutULRec = new javax.swing.JTextField();
		widthUL = new javax.swing.JTextField();
		heightUL = new javax.swing.JTextField();
		angleULRec = new javax.swing.JTextField();
		leftyULRec = new javax.swing.JCheckBox();
		submitULRec = new javax.swing.JButton();
		recLocSetPanel = new javax.swing.JInternalFrame();
		heigthLLabel = new javax.swing.JLabel();
		widthLLabel = new javax.swing.JLabel();
		loutLRecLabel = new javax.swing.JLabel();
		linRecLabel = new javax.swing.JLabel();
		loutLRec = new javax.swing.JTextField();
		widthL = new javax.swing.JTextField();
		heightL = new javax.swing.JTextField();
		linRec = new javax.swing.JTextField();
		leftyLRec = new javax.swing.JCheckBox();
		submitLRec = new javax.swing.JButton();
		cylLSetPanel = new javax.swing.JInternalFrame();
		diameterLLabel = new javax.swing.JLabel();
		loutLCylLabel = new javax.swing.JLabel();
		linCylLabel = new javax.swing.JLabel();
		loutLCyl = new javax.swing.JTextField();
		diameterL = new javax.swing.JTextField();
		linCyl = new javax.swing.JTextField();
		leftyLCyl = new javax.swing.JCheckBox();
		submitLCyl = new javax.swing.JButton();
		cylULSetPanel = new javax.swing.JInternalFrame();
		diameterULLabel = new javax.swing.JLabel();
		loutCylULLabel = new javax.swing.JLabel();
		angleCylLabel = new javax.swing.JLabel();
		loutULCyl = new javax.swing.JTextField();
		diameterUL = new javax.swing.JTextField();
		angleCyl = new javax.swing.JTextField();
		leftyCylUL = new javax.swing.JCheckBox();
		submitULCyl = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel();
		finishPanel = new javax.swing.JInternalFrame();
		fileLabel = new javax.swing.JLabel();
		fileLocation = new javax.swing.JTextField();
		submitFile = new javax.swing.JButton();
		chooseFile = new javax.swing.JButton();
		jFileChooser1 = new javax.swing.JFileChooser();
		extrusionPanel = new javax.swing.JInternalFrame();
		ExtensionLabel = new javax.swing.JLabel();
		extensionBox = new javax.swing.JComboBox();
		chooseExtension = new javax.swing.JButton();
		extrusionPanelB = new javax.swing.JInternalFrame();
		ExtensionLabelB = new javax.swing.JLabel();
		extensionBoxB = new javax.swing.JComboBox();
		chooseExtensionB = new javax.swing.JButton();
		cylHoleSetPanel = new javax.swing.JInternalFrame();
		holeDiameterLabel = new javax.swing.JLabel();
		cylHoleLinLabel = new javax.swing.JLabel();
		cylHoleLin = new javax.swing.JTextField();
		holeDiameter = new javax.swing.JTextField();
		leftyCylHole = new javax.swing.JCheckBox();
		submitCylHole = new javax.swing.JButton();
		cylThroughCheck = new javax.swing.JCheckBox();
		recHoleSetPanel = new javax.swing.JInternalFrame();
		holeWidthLabel = new javax.swing.JLabel();
		recHoleLinLabel = new javax.swing.JLabel();
		recHoleLin = new javax.swing.JTextField();
		holeWidth = new javax.swing.JTextField();
		leftyRecHole = new javax.swing.JCheckBox();
		submitRecHole = new javax.swing.JButton();
		recThroughCheck = new javax.swing.JCheckBox();
		holeHeightLabel = new javax.swing.JLabel();
		holeHeight = new javax.swing.JTextField();

		gripPanel();

		// extrusionPanel();
		//
		// recULSetPanel();
		//
		// recLSetPanel();
		//
		// cylLSetPanel();
		//
		// cylULSetPanel();

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addComponent(Panel,
								javax.swing.GroupLayout.PREFERRED_SIZE, 299,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 101, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addComponent(Panel,
								javax.swing.GroupLayout.PREFERRED_SIZE, 221,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 79, Short.MAX_VALUE)));
	}// </editor-fold>//GEN-END:initComponents

	protected void fileLocationActionPerformed(ActionEvent evt) {
		gripFab.filename = fileLocation.getText();
	}

	protected void loutULCylActionPerformed(ActionEvent evt) {
		gripFab.lout = Double.parseDouble(loutULCyl.getText());
	}

	protected void loutLCylActionPerformed(ActionEvent evt) {
		gripFab.lout = Double.parseDouble(loutLCyl.getText());
	}

	protected void widthLActionPerformed(ActionEvent evt) {
		gripFab.width = Double.parseDouble(widthL.getText());
	}

	protected void loutLRecActionPerformed(ActionEvent evt) {
		gripFab.lout = Double.parseDouble(loutLRec.getText());
	}

	protected void extensionBoxActionPerformed(ActionEvent evt) {
		gripFab.position = (String) extensionBox.getSelectedItem();
	}

	protected void gripsBoxActionPerformed(ActionEvent evt) {
		gripFab.stlTitle = (String) gripsBox.getSelectedItem();
	}

	protected void widthULActionPerformed(ActionEvent evt) {
		gripFab.width = Double.parseDouble(widthUL.getText());
	}

	protected void loutULRecActionPerformed(ActionEvent evt) {
		gripFab.lout = Double.parseDouble(loutULRec.getText());
	}

	protected void heightULActionPerformed(java.awt.event.ActionEvent evt) {
		gripFab.height = Double.parseDouble(heightUL.getText());
	}

	protected void angleULRecActionPerformed(java.awt.event.ActionEvent evt) {
		gripFab.angle = Double.parseDouble(angleULRec.getText());
	}

	protected void leftyULRecActionPerformed(java.awt.event.ActionEvent evt) {
		gripFab.lefty = leftyULRec.isSelected();
	}

	protected void heightLActionPerformed(java.awt.event.ActionEvent evt) {
		gripFab.height = Double.parseDouble(heightL.getText());
	}

	protected void linRecActionPerformed(java.awt.event.ActionEvent evt) {
		gripFab.lin = Double.parseDouble(linRec.getText());
	}

	protected void leftyLRecActionPerformed(java.awt.event.ActionEvent evt) {
		gripFab.lefty = leftyLRec.isSelected();
	}

	protected void diameterLActionPerformed(java.awt.event.ActionEvent evt) {
		gripFab.diameter = Double.parseDouble(diameterL.getText());
	}

	protected void linCylActionPerformed(java.awt.event.ActionEvent evt) {
		gripFab.lin = Double.parseDouble(linCyl.getText());
	}

	protected void leftyLCylActionPerformed(java.awt.event.ActionEvent evt) {
		gripFab.lefty = leftyLCyl.isSelected();
	}

	protected void diameterULActionPerformed(java.awt.event.ActionEvent evt) {
		gripFab.diameter = Double.parseDouble(diameterUL.getText());
	}

	protected void angleCylActionPerformed(java.awt.event.ActionEvent evt) {
		gripFab.angle = Double.parseDouble(angleCyl.getText());
	}

	protected void leftyCylULActionPerformed(java.awt.event.ActionEvent evt) {
		gripFab.lefty = leftyCylUL.isSelected();
	}

	protected void extensionBoxBActionPerformed(ActionEvent evt) {
		gripFab.position = (String) extensionBoxB.getSelectedItem();
	}

	protected void cylThroughCheckActionPerformed(ActionEvent evt) {
		if (cylThroughCheck.isSelected()) {
			cylHoleLin.setText("60");
			cylHoleLin.setEditable(false);
			gripFab.lin = 60.0;
		}
	}

	protected void leftyCylHoleActionPerformed(ActionEvent evt) {
		gripFab.lefty = leftyCylHole.isSelected();
	}

	protected void holeDiameterActionPerformed(ActionEvent evt) {
		gripFab.diameter = Double.parseDouble(holeDiameter.getText());
	}

	protected void recHoleLinCheckActionPerformed(ActionEvent evt) {
		gripFab.lin = Double.parseDouble(recHoleLin.getText());
	}

	protected void holeHeightActionPerformed(ActionEvent evt) {
		gripFab.height = Double.parseDouble(holeHeight.getText());
	}

	protected void recThroughCheckActionPerformed(ActionEvent evt) {
		if (recThroughCheck.isSelected()) {
			recHoleLin.setText("60");
			recHoleLin.setEditable(false);
			gripFab.lin = 60.0;
		}
	}

	protected void leftyRecHoleActionPerformed(ActionEvent evt) {
		gripFab.lefty = leftyRecHole.isSelected();
	}

	protected void holeWidthActionPerformed(ActionEvent evt) {
		gripFab.width = Double.parseDouble(holeWidth.getText());
	}

	protected void chooseGripsActionPerformed(java.awt.event.ActionEvent evt)
			throws GripNotFoundException {
		gripFab.stlTitle = (String) gripsBox.getSelectedItem();
		if (gripFab.stlTitle.equals("gripA.stl")){
			extrusionPanel();
			showStatus("gripA selected");
		}
		if (gripFab.stlTitle.equals("gripB.stl")){
			extrusionPanelB();
			showStatus("gripB selected");
		}
		else
			showStatus("gripnotfound");
			//throw new GripNotFoundException();
	}

	protected void chooseExtensionActionPerformed(ActionEvent evt)
			throws PositionNotSupportedException {
		gripFab.position = (String) extensionBox.getSelectedItem();
		if (gripFab.position.equals("Protruded Cylinder Hole"))
			cylHoleSetPanel();
		else if (gripFab.position.equals("Protruded Rectangular Hole"))
			recHoleSetPanel();
		else if (gripFab.position.equals("Angled Cylinder Barrel"))
			cylULSetPanel();
		else if (gripFab.position.equals("Angled Rectangular Barrel"))
			recULSetPanel();
		else if (gripFab.position.equals("Straight Cylinder Barrel"))
			cylLSetPanel();
		else if (gripFab.position.equals("Straight Rectangular Barrel"))
			recLSetPanel();
		else
			throw new PositionNotSupportedException();
	}

	protected void chooseExtensionBActionPerformed(ActionEvent evt)
			throws PositionNotSupportedException {
		gripFab.position = (String) extensionBoxB.getSelectedItem();
		if (gripFab.position.equals("Straight Cylinder Barrel"))
			cylLSetPanel();
		else if (gripFab.position.equals("Straight Rectangular Barrel"))
			recLSetPanel();
		else
			throw new PositionNotSupportedException();
	}

	protected void submitULRecActionPerformed(ActionEvent evt) {
		showStatus("submitting height...");
		gripFab.height = Double.parseDouble(heightUL.getText());
		showStatus("submitting width...");
		gripFab.width = Double.parseDouble(widthUL.getText());
		showStatus("submitting extrusion length...");
		gripFab.lout = Double.parseDouble(loutULRec.getText());
		showStatus("submitting angle...");
		gripFab.angle = Double.parseDouble(angleULRec.getText());
		showStatus("submitting lefty...");
		gripFab.lefty = leftyULRec.isSelected();
		showStatus("Altering unused settings...");
		gripFab.lin = 0;
		gripFab.diameter = 0;
		showStatus("Settings Submitted: Please select File for printing");
		finishPanel();
	}

	protected void submitLCylActionPerformed(ActionEvent evt) {
		showStatus("submitting diameter...");
		gripFab.diameter = Double.parseDouble(diameterL.getText());
		showStatus("submitting protrusion length...");
		gripFab.lin = Double.parseDouble(linCyl.getText());
		showStatus("submitting extrusion length...");
		gripFab.lout = Double.parseDouble(loutLCyl.getText());
		showStatus("submitting lefty...");
		gripFab.lefty = leftyLCyl.isSelected();
		showStatus("Altering unused settings...");
		gripFab.angle = 0;
		gripFab.height = 0;
		gripFab.width = 0;
		showStatus("Settings Submitted: Please select File for printing");
		finishPanel();
	}

	protected void submitULCylActionPerformed(ActionEvent evt) {
		showStatus("submitting diameter...");
		gripFab.diameter = Double.parseDouble(diameterUL.getText());
		showStatus("submitting extrusion length...");
		gripFab.lout = Double.parseDouble(loutULCyl.getText());
		showStatus("submitting lefty...");
		gripFab.lefty = leftyCylUL.isSelected();
		showStatus("submitting angle...");
		gripFab.angle = Double.parseDouble(angleCyl.getText());
		showStatus("Altering unused settings...");
		gripFab.lin = 0;
		gripFab.height = 0;
		gripFab.width = 0;
		showStatus("Settings Submitted: Please select File for printing");
		finishPanel();
	}

	protected void submitLRecActionPerformed(ActionEvent evt) {
		showStatus("submitting height...");
		gripFab.height = Double.parseDouble(heightL.getText());
		showStatus("submitting width...");
		gripFab.width = Double.parseDouble(widthL.getText());
		showStatus("submitting extrusion length...");
		gripFab.lout = Double.parseDouble(loutLRec.getText());
		showStatus("submitting protrusion length...");
		gripFab.lin = Double.parseDouble(linRec.getText());
		showStatus("submitting lefty...");
		gripFab.lefty = leftyLRec.isSelected();
		showStatus("Altering unused settings...");
		gripFab.angle = 0;
		gripFab.diameter = 0;
		showStatus("Settings Submitted: Please select File for printing");
		finishPanel();
	}

	protected void submitCylHoleActionPerformed(ActionEvent evt) {
		showStatus("submitting diameter...");
		gripFab.diameter = Double.parseDouble(holeDiameter.getText());
		showStatus("submitting protrusion length...");
		gripFab.lin = Double.parseDouble(cylHoleLin.getText());
		showStatus("submitting lefty...");
		gripFab.lefty = leftyCylHole.isSelected();
		showStatus("Altering unused settings...");
		gripFab.angle = 0;
		gripFab.height = 0;
		gripFab.width = 0;
		gripFab.lout = 0;
		showStatus("Settings Submitted: Please select File for printing");
		finishPanel();
	}

	protected void submitRecHoleCheckActionPerformed(ActionEvent evt) {
		showStatus("submitting height...");
		gripFab.height = Double.parseDouble(holeHeight.getText());
		showStatus("submitting width...");
		gripFab.width = Double.parseDouble(holeWidth.getText());
		showStatus("submitting protrusion length...");
		gripFab.lin = Double.parseDouble(recHoleLin.getText());
		showStatus("submitting lefty...");
		gripFab.lefty = leftyRecHole.isSelected();
		showStatus("Altering unused settings...");
		gripFab.angle = 0;
		gripFab.diameter = 0;
		gripFab.lout = 0;
		showStatus("Settings Submitted: Please select File for printing");
		finishPanel();
	}

	protected void submitFileActionPerformed(ActionEvent evt)
			throws FileNotFoundException, PositionNotSupportedException,
			invalidDiameterException, STLNotPresentException {
		showStatus("submitting file location...");
		gripFab.filename = fileLocation.getText();
		showStatus("writing file...");
		gripFab.writefile();
		showStatus("File is written. Open file in OpenScad to Render");
	}

	private void gripPanel() {
		gripPanel.setVisible(true);

		gripLabel.setText("Grip:");

		gripsBox.setModel(new javax.swing.DefaultComboBoxModel(grips));
		gripsBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				gripsBoxActionPerformed(evt);
			}
		});

		chooseGrips.setText("Choose");
		chooseGrips.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					chooseGripsActionPerformed(evt);
				} catch (GripNotFoundException e) {
					showStatus("Grip option not found, faital code error.");
					e.printStackTrace();
				}
			}
		});
		javax.swing.GroupLayout gripPanelLayout = new javax.swing.GroupLayout(
				gripPanel.getContentPane());
		gripPanel.getContentPane().setLayout(gripPanelLayout);
		gripPanelLayout
				.setHorizontalGroup(gripPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								gripPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(gripLabel)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												gripsBox,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												139,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(chooseGrips)
										.addContainerGap()));
		gripPanelLayout
				.setVerticalGroup(gripPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								gripPanelLayout
										.createSequentialGroup()
										.addGap(52, 52, 52)
										.addGroup(
												gripPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(gripLabel)
														.addComponent(
																gripsBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																chooseGrips))
										.addContainerGap(60, Short.MAX_VALUE)));
		Panel.addTab("Grip", gripPanel);// add gripPanel
	}

	private void extrusionPanel() {
		extrusionPanel.setVisible(true);

		ExtensionLabel.setText("Extension:");

		extensionBox.setModel(new javax.swing.DefaultComboBoxModel(extensions));
		extensionBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				extensionBoxActionPerformed(evt);
			}
		});

		chooseExtension.setText("Choose");
		chooseExtension.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					chooseExtensionActionPerformed(evt);
				} catch (PositionNotSupportedException e) {
					showStatus("Position Not Supported. Please choose a different position.");
					e.printStackTrace();
				}
			}
		});
		// configure extrusion Panel
		javax.swing.GroupLayout extrusionPanelLayout = new javax.swing.GroupLayout(
				extrusionPanel.getContentPane());
		extrusionPanel.getContentPane().setLayout(extrusionPanelLayout);
		extrusionPanelLayout
				.setHorizontalGroup(extrusionPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								extrusionPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(ExtensionLabel)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(extensionBox, 0, 108,
												Short.MAX_VALUE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(chooseExtension)
										.addContainerGap()));
		extrusionPanelLayout
				.setVerticalGroup(extrusionPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								extrusionPanelLayout
										.createSequentialGroup()
										.addGap(50, 50, 50)
										.addGroup(
												extrusionPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																extensionBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																ExtensionLabel)
														.addComponent(
																chooseExtension))
										.addContainerGap(62, Short.MAX_VALUE)));
		// ^configure Extrusion Panel
		Panel.remove(extrusionPanelB);
		extenstionBTab = false;
		Panel.addTab("Extrusion", extrusionPanel);
		extenstionTab = true;
	}

	private void extrusionPanelB() {

		extrusionPanelB.setVisible(true);

		ExtensionLabelB.setText("Extension:");

		extensionBoxB
				.setModel(new javax.swing.DefaultComboBoxModel(extensionsB));
		extensionBoxB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				extensionBoxBActionPerformed(evt);
			}
		});

		chooseExtensionB.setText("Choose");
		chooseExtensionB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					chooseExtensionBActionPerformed(evt);
				} catch (PositionNotSupportedException e) {
					showStatus("Position chosen is not supported, Please try a different Position.");
					e.printStackTrace();
				}
			}
		});

		javax.swing.GroupLayout extrusionPanelBLayout = new javax.swing.GroupLayout(
				extrusionPanelB.getContentPane());
		extrusionPanelB.getContentPane().setLayout(extrusionPanelBLayout);
		extrusionPanelBLayout
				.setHorizontalGroup(extrusionPanelBLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								extrusionPanelBLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(ExtensionLabelB)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(extensionBoxB, 0, 108,
												Short.MAX_VALUE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(chooseExtensionB)
										.addContainerGap()));
		extrusionPanelBLayout
				.setVerticalGroup(extrusionPanelBLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								extrusionPanelBLayout
										.createSequentialGroup()
										.addGap(50, 50, 50)
										.addGroup(
												extrusionPanelBLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																extensionBoxB,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																ExtensionLabelB)
														.addComponent(
																chooseExtensionB))
										.addContainerGap(62, Short.MAX_VALUE)));

		Panel.remove(extrusionPanel);
		extenstionTab = false;
		Panel.addTab("Extrusion", extrusionPanelB);
		extenstionBTab = true;
	}

	private void recULSetPanel() {
		recUnlockSetPanel.setVisible(true);

		jLabel1.setText("Height:");

		jLabel2.setText("Width:");

		jLabel3.setText("Extrusion Length:");

		jLabel4.setText("Angle:");

		loutULRec.setText("000");
		loutULRec.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loutULRecActionPerformed(evt);
			}
		});

		widthUL.setText("00");
		widthUL.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				widthULActionPerformed(evt);
			}
		});

		heightUL.setText("00");
		heightUL.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				heightULActionPerformed(evt);
			}
		});

		angleULRec.setText("00");
		angleULRec.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				angleULRecActionPerformed(evt);
			}
		});

		leftyULRec.setText("Left handed");
		leftyULRec.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				leftyULRecActionPerformed(evt);
			}
		});

		submitULRec.setText("Submit");
		submitULRec.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitULRecActionPerformed(evt);
			}
		});
		// configure recULSetPanel
		javax.swing.GroupLayout recUnlockSetPanelLayout = new javax.swing.GroupLayout(
				recUnlockSetPanel.getContentPane());
		recUnlockSetPanel.getContentPane().setLayout(recUnlockSetPanelLayout);
		recUnlockSetPanelLayout
				.setHorizontalGroup(recUnlockSetPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								recUnlockSetPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												recUnlockSetPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel3)
														.addComponent(
																jLabel1,
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jLabel2,
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jLabel4,
																javax.swing.GroupLayout.Alignment.TRAILING))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												recUnlockSetPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																widthUL,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																loutULRec,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																recUnlockSetPanelLayout
																		.createSequentialGroup()
																		.addGroup(
																				recUnlockSetPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								heightUL,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								angleULRec,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGap(36,
																				36,
																				36)
																		.addGroup(
																				recUnlockSetPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								submitULRec)
																						.addComponent(
																								leftyULRec))))
										.addContainerGap(11, Short.MAX_VALUE)));
		recUnlockSetPanelLayout
				.setVerticalGroup(recUnlockSetPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								recUnlockSetPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												recUnlockSetPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabel1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																16,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																heightUL,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																leftyULRec))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												recUnlockSetPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel2)
														.addComponent(
																widthUL,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												recUnlockSetPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel3)
														.addComponent(
																loutULRec,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												recUnlockSetPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel4)
														.addComponent(
																angleULRec,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																submitULRec))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		// ^configure RecULSetPanel
		Panel.remove(cylHoleSetPanel);
		cylHoleTab = false;
		Panel.remove(recHoleSetPanel);
		recHoleTab = false;
		Panel.remove(cylLSetPanel);
		cylLTab = false;
		Panel.remove(recLocSetPanel);
		recLTab = false;
		Panel.remove(cylULSetPanel);
		cylUlTab = false;
		Panel.addTab("Settings", recUnlockSetPanel);
		recULTab = true;
	}

	private void recLSetPanel() {
		recLocSetPanel.setVisible(true);

		heigthLLabel.setText("Height:");

		widthLLabel.setText("Width:");

		loutLRecLabel.setText("Extrusion Length:");

		linRecLabel.setText("Protrusion Length:");

		loutLRec.setText("000");
		loutLRec.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loutLRecActionPerformed(evt);
			}
		});

		widthL.setText("00");
		widthL.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				widthLActionPerformed(evt);
			}
		});

		heightL.setText("00");
		heightL.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				heightLActionPerformed(evt);
			}
		});

		linRec.setText("000");
		linRec.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				linRecActionPerformed(evt);
			}
		});

		leftyLRec.setText("Left handed");
		leftyLRec.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				leftyLRecActionPerformed(evt);
			}
		});

		submitLRec.setText("Submit");
		submitLRec.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitLRecActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout recLocSetPanelLayout = new javax.swing.GroupLayout(
				recLocSetPanel.getContentPane());
		recLocSetPanel.getContentPane().setLayout(recLocSetPanelLayout);
		recLocSetPanelLayout
				.setHorizontalGroup(recLocSetPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								recLocSetPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												recLocSetPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																heigthLLabel,
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																widthLLabel,
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																linRecLabel,
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																loutLRecLabel,
																javax.swing.GroupLayout.Alignment.TRAILING))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												recLocSetPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																widthL,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																loutLRec,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																recLocSetPanelLayout
																		.createSequentialGroup()
																		.addGroup(
																				recLocSetPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								heightL,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								linRec,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				20,
																				Short.MAX_VALUE)
																		.addGroup(
																				recLocSetPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								leftyLRec)
																						.addComponent(
																								submitLRec))))
										.addContainerGap(14, Short.MAX_VALUE)));
		recLocSetPanelLayout
				.setVerticalGroup(recLocSetPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								recLocSetPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												recLocSetPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																heigthLLabel,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																16,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																heightL,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(leftyLRec))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												recLocSetPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																widthLLabel)
														.addComponent(
																widthL,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												recLocSetPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																loutLRecLabel)
														.addComponent(
																loutLRec,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												recLocSetPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																linRecLabel)
														.addComponent(
																linRec,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																submitLRec))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		Panel.remove(cylLSetPanel);
		cylHoleTab = false;
		Panel.remove(recHoleSetPanel);
		recHoleTab = false;
		Panel.remove(cylLSetPanel);
		cylLTab = false;
		Panel.remove(recUnlockSetPanel);
		recULTab = false;
		Panel.remove(cylULSetPanel);
		cylUlTab = false;
		Panel.addTab("Settings", recLocSetPanel);
		recLTab = false;
	}

	private void cylLSetPanel() {
		cylLSetPanel.setVisible(true);

		diameterLLabel.setText("Diameter:");

		loutLCylLabel.setText("Extrusion Length:");

		linCylLabel.setText("Protrusion Length:");

		loutLCyl.setText("000");
		loutLCyl.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loutLCylActionPerformed(evt);
			}
		});

		diameterL.setText("00");
		diameterL.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				diameterLActionPerformed(evt);
			}
		});

		linCyl.setText("000");
		linCyl.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				linCylActionPerformed(evt);
			}
		});

		leftyLCyl.setText("Left handed");
		leftyLCyl.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				leftyLCylActionPerformed(evt);
			}
		});

		submitLCyl.setText("Submit");
		submitLCyl.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitLCylActionPerformed(evt);
			}
		});
		// configure cylLSetPanelLayout
		javax.swing.GroupLayout cylLSetPanelLayout = new javax.swing.GroupLayout(
				cylLSetPanel.getContentPane());
		cylLSetPanel.getContentPane().setLayout(cylLSetPanelLayout);
		cylLSetPanelLayout
				.setHorizontalGroup(cylLSetPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								cylLSetPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												cylLSetPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																diameterLLabel,
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																linCylLabel,
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																loutLCylLabel,
																javax.swing.GroupLayout.Alignment.TRAILING))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												cylLSetPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																cylLSetPanelLayout
																		.createSequentialGroup()
																		.addGroup(
																				cylLSetPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								loutLCyl,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								cylLSetPanelLayout
																										.createSequentialGroup()
																										.addComponent(
																												diameterL,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																												17,
																												Short.MAX_VALUE)
																										.addGroup(
																												cylLSetPanelLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																leftyLCyl)
																														.addComponent(
																																submitLCyl))))
																		.addContainerGap(
																				24,
																				Short.MAX_VALUE))
														.addGroup(
																cylLSetPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				linCyl,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addContainerGap(
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)))));
		cylLSetPanelLayout
				.setVerticalGroup(cylLSetPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								cylLSetPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												cylLSetPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																diameterLLabel,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																16,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																diameterL,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(leftyLCyl))
										.addGroup(
												cylLSetPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																cylLSetPanelLayout
																		.createSequentialGroup()
																		.addGap(69,
																				69,
																				69)
																		.addComponent(
																				submitLCyl)
																		.addContainerGap(
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																cylLSetPanelLayout
																		.createSequentialGroup()
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				cylLSetPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								loutLCylLabel)
																						.addComponent(
																								loutLCyl,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				cylLSetPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								linCylLabel)
																						.addComponent(
																								linCyl,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGap(74,
																				74,
																				74)))));
		// ^configure cylLSetPanel
		Panel.remove(recLocSetPanel);
		recLTab = false;
		Panel.remove(recUnlockSetPanel);
		recULTab = false;
		Panel.remove(cylULSetPanel);
		cylUlTab = false;
		Panel.remove(recHoleSetPanel);
		recHoleTab = false;
		Panel.remove(cylHoleSetPanel);
		cylHoleTab = false;
		Panel.addTab("Settings", cylLSetPanel);
		cylLTab = true;
	}

	private void cylHoleSetPanel() {
		cylHoleSetPanel.setVisible(true);

		holeDiameterLabel.setText("Diameter:");

		cylHoleLinLabel.setText("Protrusion Length:");

		cylHoleLin.setText("00");

		holeDiameter.setText("00");
		holeDiameter.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				holeDiameterActionPerformed(evt);
			}
		});

		leftyCylHole.setText("left handed");
		leftyCylHole.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				leftyCylHoleActionPerformed(evt);
			}
		});

		submitCylHole.setText("Submit");
		submitCylHole.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitCylHoleActionPerformed(evt);
			}
		});

		cylThroughCheck.setText("Through");
		cylThroughCheck.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cylThroughCheckActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout cylHoleSetPanelLayout = new javax.swing.GroupLayout(
				cylHoleSetPanel.getContentPane());
		cylHoleSetPanel.getContentPane().setLayout(cylHoleSetPanelLayout);
		cylHoleSetPanelLayout
				.setHorizontalGroup(cylHoleSetPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								cylHoleSetPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												cylHoleSetPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																cylThroughCheck)
														.addGroup(
																cylHoleSetPanelLayout
																		.createSequentialGroup()
																		.addGroup(
																				cylHoleSetPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								holeDiameterLabel)
																						.addComponent(
																								cylHoleLinLabel))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				cylHoleSetPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								holeDiameter,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								cylHoleLin,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												35, Short.MAX_VALUE)
										.addGroup(
												cylHoleSetPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																leftyCylHole)
														.addComponent(
																submitCylHole))
										.addContainerGap()));
		cylHoleSetPanelLayout
				.setVerticalGroup(cylHoleSetPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								cylHoleSetPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												cylHoleSetPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																holeDiameterLabel)
														.addComponent(
																holeDiameter,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																leftyCylHole))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												cylHoleSetPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																cylHoleLinLabel)
														.addComponent(
																cylHoleLin,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																submitCylHole))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(cylThroughCheck)
										.addContainerGap(42, Short.MAX_VALUE)));
		Panel.remove(recLocSetPanel);
		recLTab = false;
		Panel.remove(recUnlockSetPanel);
		recULTab = false;
		Panel.remove(cylULSetPanel);
		cylUlTab = false;
		Panel.remove(recHoleSetPanel);
		recHoleTab = false;
		Panel.remove(cylLSetPanel);
		cylLTab = false;
		Panel.addTab("Settings", cylHoleSetPanel);
		cylHoleTab = true;
	}

	private void recHoleSetPanel() {
		recHoleSetPanel.setVisible(true);

		holeWidthLabel.setText("Width:");

		recHoleLinLabel.setText("Protrusion Length:");

		recHoleLin.setText("00");
		recHoleLin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				recHoleLinCheckActionPerformed(evt);
			}
		});

		holeWidth.setText("00");
		holeWidth.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				holeWidthActionPerformed(evt);
			}
		});

		leftyRecHole.setText("left handed");
		leftyRecHole.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				leftyRecHoleActionPerformed(evt);
			}
		});

		submitRecHole.setText("Submit");
		submitRecHole.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitRecHoleCheckActionPerformed(evt);
			}
		});

		recThroughCheck.setText("Through");
		recThroughCheck.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				recThroughCheckActionPerformed(evt);
			}
		});

		holeHeightLabel.setText("Height:");

		holeHeight.setText("00");
		holeHeight.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				holeHeightActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout recHoleSetPanelLayout = new javax.swing.GroupLayout(
				recHoleSetPanel.getContentPane());
		recHoleSetPanel.getContentPane().setLayout(recHoleSetPanelLayout);
		recHoleSetPanelLayout
				.setHorizontalGroup(recHoleSetPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								recHoleSetPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												recHoleSetPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																recThroughCheck)
														.addGroup(
																recHoleSetPanelLayout
																		.createSequentialGroup()
																		.addGroup(
																				recHoleSetPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								holeHeightLabel)
																						.addComponent(
																								recHoleLinLabel)
																						.addComponent(
																								holeWidthLabel))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				recHoleSetPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								recHoleLin,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								holeWidth,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								holeHeight,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												35, Short.MAX_VALUE)
										.addGroup(
												recHoleSetPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																submitRecHole)
														.addComponent(
																leftyRecHole))
										.addContainerGap()));
		recHoleSetPanelLayout
				.setVerticalGroup(recHoleSetPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								recHoleSetPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												recHoleSetPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																holeWidthLabel)
														.addComponent(
																holeWidth,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																leftyRecHole))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												recHoleSetPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																holeHeightLabel)
														.addComponent(
																holeHeight,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(9, 9, 9)
										.addGroup(
												recHoleSetPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																recHoleLinLabel)
														.addComponent(
																recHoleLin,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																submitRecHole))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(recThroughCheck)
										.addContainerGap(11, Short.MAX_VALUE)));
		Panel.remove(recLocSetPanel);
		recLTab = false;
		Panel.remove(recUnlockSetPanel);
		recULTab = false;
		Panel.remove(cylULSetPanel);
		cylUlTab = false;
		Panel.remove(cylHoleSetPanel);
		cylHoleTab = false;
		Panel.remove(cylLSetPanel);
		cylLTab = false;
		Panel.addTab("Settings", recHoleSetPanel);
		recHoleTab = true;
	}

	private void cylULSetPanel() {

		cylULSetPanel.setVisible(true);

		diameterULLabel.setText("Diameter:");

		loutCylULLabel.setText("Extrusion Length:");

		angleCylLabel.setText("Angle:");

		loutULCyl.setText("000");
		loutULCyl.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loutULCylActionPerformed(evt);
			}
		});

		diameterUL.setText("00");
		diameterUL.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				diameterULActionPerformed(evt);
			}
		});

		angleCyl.setText("00");
		angleCyl.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				angleCylActionPerformed(evt);
			}
		});

		leftyCylUL.setText("Left handed");
		leftyCylUL.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				leftyCylULActionPerformed(evt);
			}
		});

		submitULCyl.setText("Submit");
		submitULCyl.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitULCylActionPerformed(evt);
			}
		});
		// configure cylUlSetPanel
		javax.swing.GroupLayout cylULSetPanelLayout = new javax.swing.GroupLayout(
				cylULSetPanel.getContentPane());
		cylULSetPanel.getContentPane().setLayout(cylULSetPanelLayout);
		cylULSetPanelLayout
				.setHorizontalGroup(cylULSetPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								cylULSetPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												cylULSetPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																diameterULLabel)
														.addComponent(
																angleCylLabel)
														.addComponent(
																loutCylULLabel)
														.addComponent(jLabel5))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												cylULSetPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																cylULSetPanelLayout
																		.createSequentialGroup()
																		.addGroup(
																				cylULSetPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								loutULCyl,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								cylULSetPanelLayout
																										.createSequentialGroup()
																										.addComponent(
																												diameterUL,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																												20,
																												Short.MAX_VALUE)
																										.addGroup(
																												cylULSetPanelLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																leftyCylUL)
																														.addComponent(
																																submitULCyl))))
																		.addContainerGap(
																				27,
																				Short.MAX_VALUE))
														.addGroup(
																cylULSetPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				angleCyl,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addContainerGap(
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)))));
		cylULSetPanelLayout
				.setVerticalGroup(cylULSetPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								cylULSetPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												cylULSetPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																diameterULLabel,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																16,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																diameterUL,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																leftyCylUL))
										.addGroup(
												cylULSetPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																cylULSetPanelLayout
																		.createSequentialGroup()
																		.addGap(69,
																				69,
																				69)
																		.addComponent(
																				submitULCyl)
																		.addContainerGap(
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																cylULSetPanelLayout
																		.createSequentialGroup()
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addGroup(
																				cylULSetPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								loutCylULLabel)
																						.addComponent(
																								loutULCyl,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				cylULSetPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								angleCylLabel)
																						.addComponent(
																								angleCyl,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel5)
																		.addGap(51,
																				51,
																				51)))));
		// ^Configure cylUlSetPanel
		Panel.remove(cylHoleSetPanel);
		cylHoleTab = false;
		Panel.remove(recHoleSetPanel);
		recHoleTab = false;
		Panel.remove(cylLSetPanel);
		cylLTab = false;
		Panel.remove(recLocSetPanel);
		recLTab = false;
		Panel.remove(recUnlockSetPanel);
		recULTab = false;
		Panel.addTab("Settings", cylULSetPanel);
		cylUlTab = true;
	}

	private void finishPanel() {
		finishPanel.setVisible(true);

		fileLabel.setText("File:");

		fileLocation.setText("file location");
		fileLocation.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				fileLocationActionPerformed(evt);
			}
		});

		submitFile.setText("Finish");
		submitFile.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					submitFileActionPerformed(evt);
				} catch (FileNotFoundException e) {
					showStatus("File Not found error");
					e.printStackTrace();
				} catch (PositionNotSupportedException e) {
					showStatus("Position Was not Supported please choose new position.");
					e.printStackTrace();
				} catch (invalidDiameterException e) {
					showStatus("Diameter was not supported, please reset diameter.");
					e.printStackTrace();
				} catch (STLNotPresentException e) {
					showStatus("STL not present, check folders or select new STL");
					e.printStackTrace();
				}
			}
		});

		javax.swing.GroupLayout finishPanelLayout = new javax.swing.GroupLayout(
				finishPanel.getContentPane());
		finishPanel.getContentPane().setLayout(finishPanelLayout);
		finishPanelLayout
				.setHorizontalGroup(finishPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								finishPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												finishPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																finishPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				fileLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				fileLocation,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				224,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addComponent(
																submitFile,
																javax.swing.GroupLayout.Alignment.TRAILING))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jFileChooser1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));
		finishPanelLayout
				.setVerticalGroup(finishPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								finishPanelLayout
										.createSequentialGroup()
										.addGap(47, 47, 47)
										.addGroup(
												finishPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(fileLabel)
														.addComponent(
																fileLocation,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(submitFile)
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								finishPanelLayout
										.createSequentialGroup()
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(
												jFileChooser1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));

		Panel.addTab("Finish", finishPanel);
	}

}
