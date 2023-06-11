package feeManagement;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class Signup extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField fnamefield, lnamefield, unamefield, cnumberfield;
	JPasswordField passfield, cpassfield;
	JDateChooser dobfield;
	String fname, lname, uname, pass, cpass, cnumber;
	java.util.Date dob;

	Container con = getContentPane();
//-----------------------------------------------------------------------------------------------	

	// here singup page start.....
	public Signup() {
		this.setTitle("Sign Up");
		this.setBounds(300, 200, 600, 700);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		con.setLayout(null);

		JPanel toppanel = new JPanel();
		toppanel.setBounds(0, 0, 600, 80);
		toppanel.setLayout(null);
		toppanel.setBackground(new Color(4, 50, 86));
		con.add(toppanel);
		JLabel icon2 = new JLabel("");
		icon2.setIcon(new ImageIcon(example.class.getResource("/images/new-user.png")));
		icon2.setBounds(170, 5, 100, 80);
		toppanel.add(icon2);
		JLabel headingl = new JLabel("Sign Up");
		headingl.setBounds(250, 15, 200, 50);
		headingl.setFont(new Font("arial", Font.BOLD, 30));
		headingl.setForeground(Color.WHITE);
		toppanel.add(headingl);

//-----------------------------------------------------------------------------------------------	

		JLabel fnamel = new JLabel("First Name");
		fnamel.setBounds(130, 110, 100, 30);
		fnamel.setFont(new Font("arial", Font.PLAIN, 15));
		fnamel.setForeground(Color.BLUE);
		con.add(fnamel);
//-----------------------------------------------------------------------------------------------	

		fnamefield = new JTextField();
		fnamefield.setBounds(230, 110, 250, 30);
		con.add(fnamefield);
//-----------------------------------------------------------------------------------------------	

		JLabel lnamel = new JLabel("Last Name");
		lnamel.setBounds(130, 170, 100, 30);
		lnamel.setFont(new Font("arial", Font.PLAIN, 15));
		lnamel.setForeground(Color.BLUE);
		con.add(lnamel);
//-----------------------------------------------------------------------------------------------	

		lnamefield = new JTextField();
		lnamefield.setBounds(230, 170, 250, 30);
		con.add(lnamefield);
//-----------------------------------------------------------------------------------------------	

		JLabel unamel = new JLabel("UserName");
		unamel.setBounds(130, 230, 100, 30);
		unamel.setFont(new Font("arial", Font.PLAIN, 15));
		unamel.setForeground(Color.BLUE);
		con.add(unamel);
//-----------------------------------------------------------------------------------------------	

		unamefield = new JTextField();
		unamefield.setBounds(230, 230, 250, 30);
		con.add(unamefield);
//-----------------------------------------------------------------------------------------------	

		JLabel passl = new JLabel("Password");
		passl.setBounds(130, 290, 100, 30);
		passl.setFont(new Font("arial", Font.PLAIN, 15));
		passl.setForeground(Color.BLUE);
		con.add(passl);
//-----------------------------------------------------------------------------------------------	

		passfield = new JPasswordField();
		passfield.setBounds(230, 290, 250, 30);
		con.add(passfield);
		JLabel passerror = new JLabel("");
		passerror.setForeground(Color.RED);
		passerror.setBounds(410, 290, 250, 30);
		passerror.setFont(new Font("arial", Font.PLAIN, 15));
		con.add(passerror);

//		here passerror message.....
		passfield.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			void passChecker() {
				pass = passfield.getText();

				if (pass.length() >= 8) {
					passerror.setText("");
				} else {
					passerror.setText("Enter 8 digit password");
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				passChecker();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				passChecker();
			}

			@Override
			public void keyTyped(KeyEvent e) {
				passChecker();
			}
		});

//-----------------------------------------------------------------------------------------------	
		JLabel cpassl = new JLabel("Conform Password");
		cpassl.setBounds(60, 350, 150, 30);
		cpassl.setFont(new Font("arial", Font.PLAIN, 15));
		cpassl.setForeground(Color.BLUE);
		con.add(cpassl);
//-----------------------------------------------------------------------------------------------	

		cpassfield = new JPasswordField();
		cpassfield.setBounds(230, 350, 250, 30);
		con.add(cpassfield);

//-----------------------------------------------------------------------------------------------	

		JLabel dobl = new JLabel("D.O.B");
		dobl.setFont(new Font("arial", Font.PLAIN, 15));
		dobl.setForeground(Color.BLUE);
		dobl.setBounds(130, 410, 100, 30);
		con.add(dobl);
//-----------------------------------------------------------------------------------------------	

		dobfield = new JDateChooser();
		dobfield.setBounds(230, 410, 200, 30);
		con.add(dobfield);

//-----------------------------------------------------------------------------------------------	

		JLabel cnumberl = new JLabel("Contect number");
		cnumberl.setBounds(100, 470, 150, 30);
		cnumberl.setFont(new Font("arial", Font.PLAIN, 15));
		cnumberl.setForeground(Color.BLUE);
		con.add(cnumberl);
//-----------------------------------------------------------------------------------------------	

		cnumberfield = new JTextField();
		cnumberfield.setBounds(230, 470, 250, 30);
		con.add(cnumberfield);

		JLabel cnumbererror = new JLabel("");
		cnumbererror.setForeground(Color.RED);
		cnumbererror.setBounds(290, 470, 270, 30);
		cnumbererror.setFont(new Font("arial", Font.PLAIN, 15));
		con.add(cnumbererror);

//		here mobile number error message.....
		cnumberfield.addKeyListener(new KeyAdapter() {
			void mnumberChecker() {
				cnumber = cnumberfield.getText();

				if (cnumber.length() == 10) {
					cnumbererror.setText("");
				} else {
					cnumbererror.setText("Enter 10 digit mobile number");
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				mnumberChecker();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				mnumberChecker();
			}

			@Override
			public void keyTyped(KeyEvent e) {
				mnumberChecker();
			}
		});
//-----------------------------------------------------------------------------------------------	
		JButton singupbtn = new JButton("Sing Up");
		singupbtn.setBounds(50, 550, 120, 35);
		singupbtn.setFont(new Font("arial", Font.PLAIN, 15));
		singupbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		singupbtn.setForeground(Color.WHITE);
		singupbtn.setBackground(new Color(34, 149, 237));
		con.add(singupbtn);
		singupbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				singupbtn.setBackground(new Color(21, 126, 207));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				singupbtn.setBackground(new Color(34, 149, 237));
			}
		});
		singupbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validData()) {// validData method variables in top and method defination is down....
					if (insertData() > 0) {// insertData method variables in top and method defination is down....
						JOptionPane.showMessageDialog(new Signup(), "Record insert successfully");
					} else {
						JOptionPane.showMessageDialog(new Signup(), "Record not insert");
					}
				}

			}
		});
//-----------------------------------------------------------------------------------------------		
		JButton clearbtn = new JButton("Clear");
		clearbtn.setBounds(220, 550, 120, 35);
		clearbtn.setFont(new Font("arial", Font.PLAIN, 15));
		clearbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		clearbtn.setForeground(Color.WHITE);
		clearbtn.setBackground(new Color(34, 149, 237));
		con.add(clearbtn);
		clearbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				clearbtn.setBackground(new Color(21, 126, 207));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				clearbtn.setBackground(new Color(34, 149, 237));
			}
		});
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fnamefield.setText("");
				lnamefield.setText("");
				unamefield.setText("");
				passfield.setText("");
				cpassfield.setText("");
				dobfield.setDate(null);
				cnumberfield.setText("");
				passerror.setText("");
				cnumbererror.setText("");
			}
		});
//-----------------------------------------------------------------------------------------------		
		JButton loginbtn = new JButton("Login");
		loginbtn.setBounds(380, 550, 120, 35);
		loginbtn.setFont(new Font("arial", Font.PLAIN, 15));
		loginbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loginbtn.setForeground(Color.WHITE);
		loginbtn.setBackground(new Color(34, 149, 237));
		loginbtn.addActionListener(this);
		con.add(loginbtn);
		loginbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				loginbtn.setBackground(new Color(21, 126, 207));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				loginbtn.setBackground(new Color(34, 149, 237));
			}
		});

	}
//-----------------------------------------------------------------------------------------------

	@SuppressWarnings("deprecation")
	boolean validData() {

		fname = fnamefield.getText();
		lname = lnamefield.getText();
		uname = unamefield.getText();
		pass = passfield.getText();
		cpass = cpassfield.getText();
		dob = dobfield.getDate();
		cnumber = cnumberfield.getText();

		if (fname.equals("")) {
			JOptionPane.showMessageDialog(this, "Enter the first name");
			return false;
		}
		if (lname.equals("")) {
			JOptionPane.showMessageDialog(this, "Enter the lasr name");
			return false;
		}
		if (uname.equals("")) {
			JOptionPane.showMessageDialog(this, "Enter the user name");
			return false;
		}
		if (pass.equals("")) {
			JOptionPane.showMessageDialog(this, "Enter the password");
			return false;
		}
		if (cpass.equals("")) {
			JOptionPane.showMessageDialog(this, "Enter the conform password");
			return false;
		}
		try {
			if (dob.equals(null)) {

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Enter the date of birth");
			return false;
		}
		if (cnumber.equals("")) {
			JOptionPane.showMessageDialog(this, "Enter the Mobile number");
			return false;
		}

		return true;
	}

	int id = 0;

	int getId() {
		ResultSet rs = null;
		try {
			Connection con = DBConnection.getConnection();

			String sql = "select max(id) from signup";

			Statement st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				id = rs.getInt(1);
				id++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;

	}

	@SuppressWarnings("deprecation")
	int insertData() {
		int i = 0;
		try {

			Connection con = DBConnection.getConnection();

			fname = (String) fnamefield.getText();
			lname = (String) lnamefield.getText();
			uname = (String) unamefield.getText();
			pass = passfield.getText();
			dob = dobfield.getDate();
			cnumber = (String) cnumberfield.getText();

			PreparedStatement psmt = con.prepareStatement("insert into signup values(?,?,?,?,?,?,?)");
			psmt.setInt(1, getId());
			psmt.setString(2, fname);
			psmt.setString(3, lname);
			psmt.setString(4, uname);
			psmt.setString(5, pass);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			String newdob = sdf.format(dob);
			psmt.setString(6, newdob);
			psmt.setString(7, cnumber);

			i = psmt.executeUpdate();
			fnamefield.setText("");
			lnamefield.setText("");
			unamefield.setText("");
			passfield.setText("");
			cpassfield.setText("");
			dobfield.setDate(null);
			cnumberfield.setText("");

			System.out.println(id);
			System.out.println(fname);
			System.out.println(lname);
			System.out.println(uname);
			System.out.println(pass);
			System.out.println(newdob);
			System.out.println(cnumber);

			con.close();

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return i;
	}

	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
		new Signin();
	}
}