package feeManagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class About extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container con = getContentPane();
	JLabel heading;
	JTextArea textarea;
	JSeparator seprator1, seprator2;
	JButton backbtn;

	public About() {
		this.setVisible(true);
		this.setBounds(300, 100, 800, 700);
		this.setTitle("About");
		this.setResizable(false);
		con.setLayout(null);
		con.setBackground(new Color(4, 50, 86));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLayout();
	}

	public void setLayout() {
		JLabel icon3 = new JLabel("");
		icon3.setIcon(new ImageIcon(example.class.getResource("/images/copyright.png")));
		icon3.setBounds(5,25,200,55);
		con.add(icon3);
		heading = new JLabel("CopyRight 2023,All Right Reserved");
		heading.setForeground(Color.WHITE);
		heading.setBounds(50, 35, 500, 30);
		heading.setFont(new Font("arial", Font.BOLD, 25));
		con.add(heading);

		seprator1 = new JSeparator();
		seprator1.setBounds(0, 100, 800, 10);
		seprator1.setBackground(Color.orange);
		con.add(seprator1);

		textarea = new JTextArea();
		textarea.setBounds(0, 150, 700, 350);
		textarea.setFont(new Font("arial", Font.PLAIN, 20));
		textarea.setForeground(Color.WHITE);
		textarea.setBackground(new Color(4, 50, 86));
		textarea.setText("\n\n\n\tNO Part of the software may reproduced in "
				+ "whole or in parts\n\tWithout the specific written permission "
				+ "of the owner.\n\tThe software is developed by :-\n\n\tMr. Anushalv bhatt"
				+ "\n\tMr. Bipin Purohit\n\tMr. Animesh Bisht");
		con.add(textarea);

		seprator2 = new JSeparator();
		seprator2.setBounds(0, 500, 800, 10);
		seprator2.setBackground(Color.orange);
		con.add(seprator2);

		backbtn = new JButton("");
		backbtn.setBounds(30, 550, 70, 30);
		backbtn.setBackground(new Color(34,149,237));
		backbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		JLabel icon4 = new JLabel("");
		icon4.setIcon(new ImageIcon(example.class.getResource("/images/back1.png")));
		icon4.setBounds(10,30,200,100);
		
		backbtn.add(icon4);
		con.add(backbtn);
		backbtn.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
		new HomePage().setVisible(true);
	}
	
}
