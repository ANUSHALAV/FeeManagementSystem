package feeManagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main  {
	Timer timer;

	public Main() {
		displayWelcomeScreen();
		
	}

	private void displayWelcomeScreen() {
		final JWindow w = new JWindow();
		w.setBounds(200, 60, 650, 400);
		w.setLocationRelativeTo(null);
		w.setVisible(true);
		w.revalidate();

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(34, 149, 237));
		JLabel icon2 = new JLabel("");
		icon2.setIcon(new ImageIcon(example.class.getResource("/images/download.png")));
		icon2.setBounds(170,100,900,250);
		panel.add(icon2);
		JLabel heading=new JLabel("Welcome To Fee Management");
		heading.setForeground(Color.BLACK);
		heading.setBounds(0,0,1000,50);
		heading.setFont(new Font("verdana",Font.BOLD,28));
		
		icon2.add(heading);
	
		w.add(panel);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		JProgressBar progress = new JProgressBar(0, 100);
		progress.setForeground(new Color(68,189,50));
		progress.setBackground(new Color(0, 0, 0));
		w.add(BorderLayout.PAGE_END, progress);

		timer = new Timer(100, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = progress.getValue();
				if (x == 100) {
					w.dispose();
					new Signin();
					timer.stop();

				} else {
					progress.setValue(x + 7);
				}
			}
		});
		timer.start();
	}

	public static void main(String args[]) {
		new Main();
	}
}
