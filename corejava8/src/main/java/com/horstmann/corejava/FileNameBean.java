package com.horstmann.corejava;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileNameBean extends JPanel {
	public FileNameBean() {
		dialogButton = new JButton("...");
		nameField = new JTextField(30);
		
		chooser = new JFileChooser();
		setPreferredSize(new Dimension(XPRESIZE, YPRESIZE));
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 100;
		gbc.weighty = 100;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(nameField, gbc);
		
		dialogButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				chooser.setFileFilter(new FileNameExtensionFilter(Arrays.toString(extensions), extensions));
				
				int r = chooser.showOpenDialog(null);
				if (r == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					String name = file.getAbsolutePath();
					setFileName(name);
				}
			}
		});
		nameField.setEditable(false);
		
		gbc.weightx = 0;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 1;
		add(dialogButton, gbc);
	}
	
	/** Sets the fileName property
	 * @param newValue
	 */
	public void setFileName(String newValue) {
		String oldValue = nameField.getText();
		nameField.setText(newValue);
		firePropertyChange("fileName", oldValue, newValue);
	}
	
	/** Gets the filename property
	 * @return the name of the selected file
	 */
	public String getFileName() {
		return nameField.getText();
	}
	
	/** 
	 * Get the extensions property
	 * @return the default extensions in the file chooser
	 */
	public String[] getExtensions() {
		return extensions;
	}
	
	/**
	 * Sets the extensions property
	 * @param newValue the new default extensions
	 */
	public void setExtensions(String[] newValue) {
		extensions = newValue;
	}
	
	/** Gets one of the extensions property values
	 * @param i the index of the property value
	 * @return the value at the given index
	 */
	public String getExtensions(int i) {
		if (0 <= i && i < extensions.length) {
			return extensions[i];
		} else {
			return "";
		}
	}
	
	/** set one of the extensions property values
	 * @param i the index of the property value
	 * @param newValue the new value at the give index
	 */
	public void setExtensions(int i, String newValue) {
		if (0 <= i && i < extensions.length) {
			extensions[i] = newValue;
		}
	}

	private static final int XPRESIZE = 200;
	private static final int YPRESIZE = 20;
	private JButton dialogButton;
	private JTextField nameField;
	private JFileChooser chooser;
	private String[] extensions = {"gif", "png"};
}
