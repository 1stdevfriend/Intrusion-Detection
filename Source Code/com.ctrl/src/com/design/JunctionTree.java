package com.design;

import com.*;
import com.ctrl.JunctionTreeConnection;


/*
 * JunctionTree.java
 *
 * Created on __DATE__, __TIME__
 */

/**
 * 
 * @author __USER__
 */
public class JunctionTree extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Creates new form JunctionTree */
	public JunctionTree() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		btnConnReg = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jta = new javax.swing.JTextArea();
		btnExit = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		btnConnReg.setText("Connection Recognition");
		btnConnReg.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnConnRegActionPerformed(evt);
			}
		});
		getContentPane().add(btnConnReg);
		btnConnReg.setBounds(20, 30, 180, 23);

		jScrollPane1.setViewportView(jta);

		getContentPane().add(jScrollPane1);
		jScrollPane1.setBounds(20, 60, 660, 340);

		btnExit.setText("Exit");
		btnExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnExitActionPerformed(evt);
			}
		});
		getContentPane().add(btnExit);
		btnExit.setBounds(553, 420, 130, 23);

		setSize(720, 500);
		setTitle("Intrusion Detection System");
		setResizable(false);
		setVisible(true);
	}// </editor-fold>

	// GEN-END:initComponents

	private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		System.exit(0);
	}

	private void btnConnRegActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		try {
			com.ctrl.JunctionTreeConnection jc=new JunctionTreeConnection();
			jc.init(taianpath, testpath, jta);
			jc.start();
			btnConnReg.setEnabled(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton btnConnReg;
	private javax.swing.JButton btnExit;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jta;
	String taianpath;
	String testpath;

	// End of variables declaration//GEN-END:variables
	public void init(String taianpath, String testpath) {
		// TODO Auto-generated method stub
		this.taianpath=taianpath;this.testpath=testpath;
	}
}