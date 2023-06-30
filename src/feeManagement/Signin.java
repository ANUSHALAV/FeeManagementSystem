package feeManagement;



import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class Signin extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel toppanel;
	private JTextField unamefield;
	private JPasswordField passfield;
	JButton signupbtn,loginbtn,clearbtn;
	Container con = getContentPane();
	String uname, pass;


// -----------------------------------------------------------------------------------------------
	public void pageLayout() {
		JLabel heading = new JLabel("Sign In");
		heading.setBounds(250, 20, 500, 50);
		heading.setFont(new Font("arial", Font.BOLD, 35));
		heading.setForeground(Color.WHITE);
		toppanel.add(heading);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(example.class.getResource("/images/admin.png")));
		lblNewLabel.setBounds(180, 18, 97, 65);
		toppanel.add(lblNewLabel);
//------------------------------------------------------------------------------------------------

		JLabel usernamel = new JLabel("UserName");
		usernamel.setBounds(100, 200, 100, 30);
		usernamel.setFont(new Font("arial", Font.BOLD, 20));
		con.add(usernamel);
		validate();
//-----------------------------------------------------------------------------------------------	

		unamefield = new JTextField();
		unamefield.setBounds(230, 200, 200, 30);
		con.add(unamefield);
		validate();
//-----------------------------------------------------------------------------------------------	

		JLabel passwordl = new JLabel("Password");
		passwordl.setBounds(100, 280, 100, 30);
		passwordl.setFont(new Font("arial", Font.BOLD, 20));
		con.add(passwordl);
		validate();
//-----------------------------------------------------------------------------------------------	

		passfield = new JPasswordField();
		passfield.setBounds(230, 280, 200, 30);
		con.add(passfield);
		validate();
//-----------------------------------------------------------------------------------------------	

		signupbtn = new JButton("Signup");
		signupbtn.setBounds(50, 360, 130, 40);
		signupbtn.setForeground(Color.WHITE);
		signupbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		signupbtn.setBackground(new Color(34, 149, 237));
		signupbtn.setFont(new Font("arial", Font.BOLD, 18));
		con.add(signupbtn);
		signupbtn.addActionListener(this);

		signupbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				signupbtn.setBackground(new Color(21, 126, 207));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				signupbtn.setBackground(new Color(34, 149, 237));
			}
		});

		
		
//-----------------------------------------------------------------------------------------------	

		loginbtn = new JButton("Login");
		loginbtn.setBounds(230, 360, 130, 40);
		loginbtn.setForeground(Color.WHITE);
		loginbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loginbtn.setBackground(new Color(34, 149, 237));
		loginbtn.setFont(new Font("arial", Font.BOLD, 18));
		validate();
		con.add(loginbtn);
		loginbtn.addActionListener(this);

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
//-----------------------------------------------------------------------------------------------	

		clearbtn = new JButton("Clear");
		clearbtn.setBounds(400, 360, 130, 40);
		clearbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		clearbtn.setForeground(Color.WHITE);
		clearbtn.setBackground(new Color(34, 149, 237));
		clearbtn.setFont(new Font("arial", Font.BOLD, 18));
		validate();
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
			@Override
			public void actionPerformed(ActionEvent e) {
				unamefield.setText("");
				passfield.setText("");
			}
		});
		
	}

//-----------------------------------------------------------------------------------------------	
	boolean validData() {
		if (uname.equals("")) {
			JOptionPane.showMessageDialog(this, "Enter the username");
			return false;
		}
		if (pass.equals("")) {
			JOptionPane.showMessageDialog(this, "Enter the password");
			return false;
		}
		return true;
	}

	boolean userChecker(String username, String password) {
		boolean validate = true;
		try {
			Connection con = DBConnection.getConnection();
			String sql = "select * from signup";

			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			
			while (rs.next()) {
				String fetchUsername = rs.getString("uname");
				String fetchPassword = rs.getString("password");
				if ((fetchUsername.equals(username)) && (fetchPassword.equals(password))) {
					return validate;
				}
				else {
					return validate=true;
				}
			}
		} catch (Exception ex) {
			return false;
		}
		return validate;
	}

	
	//signupbtn action listener mathod defination 
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==signupbtn) {
			this.setVisible(false);
			new Signup().setVisible(true); 
		}
		if(e.getSource()==loginbtn) {
			uname = unamefield.getText();
			pass = passfield.getText();
			if (validData()) {
				if ((userChecker(uname, pass))) {
					unamefield.setText("");
					passfield.setText("");
					JOptionPane.showMessageDialog(this, "login successfully");
					this.setVisible(false);
					new HomePage();
				} else {
					unamefield.setText("");
					passfield.setText("");
					JOptionPane.showMessageDialog(this, "login not successfully");
				}
			} else {

			}
		}
	}
	
//	here application start
	public Signin() {
		this.setTitle("Signin");
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
		this.setBounds(300,200,600,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		con.setLayout(null);
		toppanel = new JPanel();
		toppanel.setBounds(0, 0, 600, 100);
		toppanel.setLayout(null);
		toppanel.setBackground(new Color(4, 50, 86));
		con.add(toppanel);
		validate();
		pageLayout();
	}
}
