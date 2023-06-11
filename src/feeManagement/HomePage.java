package feeManagement;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class HomePage extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container con = getContentPane();
	JButton jb7,jb8,jb1;
	Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
	JPanel jb1panel;

	public HomePage() {
		this.setTitle("Home Page");
		this.setVisible(true);
		this.setResizable(false);
		this.setBounds(200, 100, 950, 750);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		con.setLayout(null);

		JPanel jp = new JPanel();
		jp.setBounds(0, 0, 1280, 120);
		jp.setBackground(new Color(4, 50, 86));
		jp.setLayout(null);
		con.add(jp);


		JLabel heading1 = new JLabel("Swami Purnanad Degree College Of Technical Education");
		heading1.setBounds(150, 10, 800, 50);
		heading1.setFont(new Font("arial", Font.BOLD, 25));
		heading1.setForeground(Color.WHITE);
		jp.add(heading1);
//-----------------------------------------------------------------------------------------------

		JLabel heading2 = new JLabel("Kailash Gate Muni Ki Reti (Tehri Garhwal)-249137");
		heading2.setBounds(230, 50, 800, 50);
		heading2.setFont(new Font("arial", Font.BOLD, 20));
		heading2.setForeground(Color.WHITE);
		jp.add(heading2);
//	----------------------------------------------------------------------------------------------
		JPanel mainjp = new JPanel();
		mainjp.setBounds(0, 120, 950, 800);
		mainjp.setBackground(new Color(24, 59, 86));
		mainjp.setLayout(null);
		con.add(mainjp);

		jb1panel=new JPanel();
		jb1panel.setBounds(280,50,350,150);
		jb1panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, new Color(64, 64, 64), Color.WHITE, new Color(255, 255, 255)));
		jb1panel.setLayout(null);
		mainjp.add(jb1panel);
		jb1 = new JButton("            Add Fees");
		jb1.setBounds(0, 0, 350, 150);
		jb1.setForeground(Color.WHITE);
		jb1.setFont(new Font("arial", Font.BOLD, 20));
		jb1.setBackground(new Color(34,149,237));
		jb1.setCursor(cursor);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(example.class.getResource("/images/plus.png")));
		lblNewLabel.setBounds(10,50,150,100);
		jb1.add(lblNewLabel);
		jb1panel.add(jb1);
		jb1.addActionListener(this);
		
		jb1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jb1.setBackground(new Color(21,126,207));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jb1.setBackground(new Color(34,149,237));
			}
		});
//-----------------------------------------------------------------------------------------------
		
		jb1panel=new JPanel();
		jb1panel.setBounds(280,220,350,150);
		jb1panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, new Color(64, 64, 64), Color.WHITE, new Color(255, 255, 255)));
		jb1panel.setLayout(null);
		mainjp.add(jb1panel);
		JButton jb2 = new JButton("               Search Recorde");
		jb2.setBounds(0,0, 350, 150);
		jb2.setForeground(Color.WHITE);
		jb2.setFont(new Font("arial", Font.BOLD, 20));
		jb2.setBackground(new Color(34,149,237));
		jb2.setCursor(cursor);
		JLabel icon2 = new JLabel("");
		icon2.setIcon(new ImageIcon(example.class.getResource("/images/search-document.png")));
		icon2.setBounds(10,40,200,100);
		jb2.add(icon2);
		jb1panel.add(jb2);
		
		jb2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jb2.setBackground(new Color(21,126,207));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jb2.setBackground(new Color(34,149,237));
			}
		});
		
		jb2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new SearchRecorde();
			}
		});
//-----------------------------------------------------------------------------------------------

		jb1panel=new JPanel();
		jb1panel.setBounds(280,400,350,150);
		jb1panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, new Color(64, 64, 64), Color.WHITE, new Color(255, 255, 255)));
		jb1panel.setLayout(null);
		mainjp.add(jb1panel);
		JButton jb6 = new JButton("                  View Recorde");
		jb6.setBounds(0,0, 350, 150);
		jb6.setFont(new Font("arial", Font.BOLD, 20));
		jb6.setBackground(new Color(34,149,237));
		jb6.setForeground(Color.WHITE);
		jb6.setCursor(cursor);
		JLabel icon3 = new JLabel("");
		icon3.setIcon(new ImageIcon(example.class.getResource("/images/text-book-opened-from-top-view.png")));
		icon3.setBounds(10,30,200,100);
		jb6.add(icon3);
		jb1panel.add(jb6);
		jb6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jb6.setBackground(new Color(21,126,207));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jb6.setBackground(new Color(34,149,237));
			}
		});
		jb6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new ViewRecorde();
				}
		});
//-----------------------------------------------------------------------------------------------

		jb7 = new JButton("LOGOUT");
		jb7.setBounds(20, 520, 200, 50);
		jb7.setFont(new Font("arial", Font.BOLD, 20));
		jb7.setCursor(cursor);
		jb7.setForeground(Color.WHITE);
		jb7.setBackground(new Color(34,149,237));
		mainjp.add(jb7);
		jb7.addActionListener(this);
		jb7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jb7.setBackground(new Color(21,126,207));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jb7.setBackground(new Color(34,149,237));
			}
		});
//-----------------------------------------------------------------------------------------------

		jb8 = new JButton("ABOUT");
		jb8.setBounds(700, 520, 200, 50);
		jb8.setFont(new Font("arial", Font.BOLD, 20));
		jb8.setForeground(Color.WHITE);
		jb8.setCursor(cursor);
		jb8.setBackground(new Color(34,149,237));
		jb8.addActionListener(this);
		mainjp.add(jb8);
		jb8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jb8.setBackground(new Color(21,126,207));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jb8.setBackground(new Color(34,149,237));
			}
		});

	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1) {
				new AddFees();
				}
		if(e.getSource()==jb7) {
			this.setVisible(false);
			new Signin().setVisible(true);
		}
		if(e.getSource()==jb8) {
			this.setVisible(false);
			new About().setVisible(true);
		}
	}
//-----------------------------------------------------------------------------------------------
	public static void main(String args[]) {
		new HomePage();
	}
}
