package com.carlesramos.conectarsqlite;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class InterfazConectar extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazConectar frame = new InterfazConectar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazConectar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel mensaje = new JLabel("Database?");
		mensaje.setBounds(130, 24, 76, 37);
		getContentPane().add(mensaje);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				mensaje.setText((String)comboBox.getSelectedItem());
			}
		});
		comboBox.addMouseListener(new MouseAdapter() {
			
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"SQlite", "H2", "Derby", "MySql"}));
		comboBox.setBounds(224, 30, 105, 24);
		getContentPane().add(comboBox);
		
	}
}
