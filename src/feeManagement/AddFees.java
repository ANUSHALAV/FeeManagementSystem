package feeManagement;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class AddFees extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel heading1, heading2;
	JTextField parenttextfield,ddfield,chequenofield,banknamefield,recivefield;
	JTextField reciptfield, datefield, modetextfield1, modetextfield2, modetextfield3, amounttextfield1,
			amounttextfield2;
	Font font = new Font("arial", Font.BOLD, 15);
	Container con = getContentPane();
	JComboBox coursefield, yearfield, semfield, parentfield, mrfield,mopfield;
	JLabel reciptl, datel,Recivel,coursel,yearl,seml,parentl, mopl  ;

//-------------------------------------------------------------------------------------------------------
	public void  setVisibility() {
		this.setVisible(false);
	}
	public void rightpanelLayout() {
		JPanel rightpanel = new JPanel();
		rightpanel.setBounds(0, 0, 1000, 90);
		rightpanel.setBackground(new Color(4, 50, 86));
		rightpanel.setLayout(null);
		con.add(rightpanel);

// ---------------------------------------------------------------------------------------
		// rightpanel start
		heading1 = new JLabel("SWAMI PURNANAND DEGREE COLLEGE OF TECHNICAL EDUCATION");
		heading1.setFont(new Font("arial", Font.BOLD, 23));
		heading1.setForeground(Color.WHITE);
		heading1.setBounds(80, 0, 1000, 70);
		rightpanel.add(heading1);

		heading2 = new JLabel("Kailash Gate Muni Ki Reti Rishikesh 249137 (U.K)");
		heading2.setFont(new Font("arial", Font.BOLD, 20));
		heading2.setForeground(Color.WHITE);
		heading2.setBounds(210, 30, 1000, 70);
		rightpanel.add(heading2);
		// rightpanel end
	}
// -------------------------------------------------------------------------------------------------

	public void leftpanelLayout() {
		JPanel leftpanel = new JPanel();
		leftpanel.setBounds(0, 0, 1280, 1200);
		leftpanel.setBackground(new Color(24, 59, 86));
		leftpanel.setLayout(null);
		con.add(leftpanel);

		// leftpanel start
		reciptl = new JLabel("Ricipt No.");
		reciptl.setBounds(30, 100, 100, 30);
		reciptl.setFont(font);
		reciptl.setForeground(Color.WHITE);
		leftpanel.add(reciptl);

		reciptfield = new JTextField();
		reciptfield.setBounds(160, 100, 150, 25);
		int reciptNumber = getReciptNo();
		reciptfield.setText(Integer.toString(reciptNumber));
		leftpanel.add(reciptfield);

		datel = new JLabel("Date");
		datel.setBounds(620, 100, 100, 30);
		datel.setForeground(Color.WHITE);
		datel.setFont(font);
		leftpanel.add(datel);

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");
		String dd = sdf.format(date);
		datefield = new JTextField();
		datefield.setBounds(670, 103, 170, 25);
		datefield.setText(dd);
		leftpanel.add(datefield);

		Recivel = new JLabel("Recive from");
		Recivel.setFont(font);
		Recivel.setForeground(Color.WHITE);
		Recivel.setBounds(30, 150, 120, 30);
		leftpanel.add(Recivel);

		recivefield = new JTextField();
		recivefield.setBounds(160, 150, 200, 25);
		leftpanel.add(recivefield);

		coursel = new JLabel("Student Of");
		coursel.setFont(font);
		coursel.setForeground(Color.WHITE);
		coursel.setBounds(30, 200, 100, 30);
		leftpanel.add(coursel);

		String course[] = { "-------", "BSc IT", "BSc FT", "BSc HS", "B.Com", "BA Yoga", "BA", "DHM" };
		coursefield = new JComboBox(course);
		coursefield.setBounds(160, 200, 140, 25);
		coursefield.setSelectedIndex(0);
		leftpanel.add(coursefield);
		coursefield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modetextfield1.setText(coursefield.getSelectedItem().toString());
			}
		});

		yearl = new JLabel("Year");
		yearl.setFont(font);
		yearl.setForeground(Color.WHITE);
		yearl.setBounds(400, 200, 100, 30);
		leftpanel.add(yearl);

		String year[] = { "-------", "1", "2", "3" };
		yearfield = new JComboBox(year);
		yearfield.setBounds(450, 200, 140, 25);
		yearfield.setSelectedIndex(0);
		leftpanel.add(yearfield);

		seml = new JLabel("Semester");
		seml.setFont(font);
		seml.setForeground(Color.WHITE);
		seml.setBounds(670, 200, 100, 30);
		leftpanel.add(seml);

		String sem[] = { "-------", "1st", "2nd", "3rd", "4th", "5th", "6th" };
		semfield = new JComboBox(sem);
		semfield.setBounds(750, 200, 140, 25);
		semfield.setSelectedIndex(0);
		leftpanel.add(semfield);

		parentl = new JLabel("Parents");
		parentl.setBounds(30, 250, 100, 25);
		parentl.setForeground(Color.WHITE);
		parentl.setFont(font);
		leftpanel.add(parentl);

		String parent[] = { "-----", "S/O", "D/O", "W/O" };
		parentfield = new JComboBox(parent);
		parentfield.setBounds(160, 250, 50, 20);
		leftpanel.add(parentfield);

		String mr[] = { "-----", "Mr.", "Mrs." };
		mrfield = new JComboBox(mr);
		mrfield.setBounds(230, 250, 50, 20);
		leftpanel.add(mrfield);

		parenttextfield = new JTextField();
		parenttextfield.setBounds(300, 250, 180, 25);
		leftpanel.add(parenttextfield);

		mopl = new JLabel("Mode of Payment");
		mopl.setBounds(30, 300, 150, 30);
		mopl.setForeground(Color.WHITE);
		mopl.setFont(font);
		leftpanel.add(mopl);

		String[] str = { "DD", "Cash", "Cheque" };
		mopfield = new JComboBox(str);
		mopfield.setBounds(160, 300, 140, 25);
		mopfield.setSelectedIndex(1);
		leftpanel.add(mopfield);
	
//--------------------------------------------------------------------------------------------------------

		JLabel ddl = new JLabel("DD");
		ddl.setFont(font);
		ddl.setForeground(Color.WHITE);
		ddl.setVisible(false);
		ddl.setBounds(30, 350, 100, 30);
		leftpanel.add(ddl);

		ddfield = new JTextField();
		ddfield.setBounds(160, 350, 150, 25);
		ddfield.setVisible(false);
		leftpanel.add(ddfield);

		JLabel chequenol = new JLabel("Cheque number");
		chequenol.setFont(font);
		chequenol.setForeground(Color.WHITE);
		chequenol.setBounds(30, 350, 120, 30);
		chequenol.setVisible(false);
		leftpanel.add(chequenol);

		chequenofield = new JTextField();
		chequenofield.setBounds(160, 350, 150, 25);
		chequenofield.setVisible(false);
		leftpanel.add(chequenofield);

		JLabel banknamel = new JLabel("Bank name");
		banknamel.setFont(font);
		banknamel.setForeground(Color.WHITE);
		banknamel.setBounds(400, 350, 120, 30);
		banknamel.setVisible(false);
		leftpanel.add(banknamel);

		banknamefield = new JTextField();
		banknamefield.setBounds(500, 350, 200, 25);
		banknamefield.setVisible(false);
		leftpanel.add(banknamefield);

		JSeparator separator1 = new JSeparator();
		separator1.setBounds(0, 400, 1000, 20);
		leftpanel.add(separator1);

		JSeparator separator2 = new JSeparator();
		separator2.setBounds(0, 450, 1000, 20);
		leftpanel.add(separator2);

		JLabel model = new JLabel("Mode");
		model.setBounds(280, 420, 100, 25);
		model.setFont(font);
		model.setForeground(Color.WHITE);
		leftpanel.add(model);

		JLabel amountl = new JLabel("Amount");
		amountl.setBounds(630, 420, 100, 25);
		amountl.setForeground(Color.WHITE);
		amountl.setFont(font);
		leftpanel.add(amountl);

		modetextfield1 = new JTextField();
		modetextfield1.setBounds(150, 480, 300, 30);
		leftpanel.add(modetextfield1);

		JLabel wordl = new JLabel("Amount in word");
		wordl.setBounds(20, 600, 150, 25);
		wordl.setForeground(Color.WHITE);
		wordl.setFont(font);
		leftpanel.add(wordl);

		modetextfield2 = new JTextField();
		modetextfield2.setBounds(150, 600, 300, 30);
		leftpanel.add(modetextfield2);



		amounttextfield1 = new JTextField();
		amounttextfield1.setBounds(590, 480, 150, 30);
		leftpanel.add(amounttextfield1);
		amounttextfield1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				String amount = amounttextfield1.getText();
				amounttextfield2.setText(amount);
				modetextfield2.setText(NumberToWordsConverter.convert(Integer.parseInt(amount)));
				
			}
		});

		JSeparator separator3 = new JSeparator();
		separator3.setBounds(550, 560, 220, 20);
		leftpanel.add(separator3);

		amounttextfield2 = new JTextField();
		amounttextfield2.setBounds(590, 580, 150, 30);
		leftpanel.add(amounttextfield2);

		JButton printbtn = new JButton("Print");
		printbtn.setBounds(700, 680, 150, 40);
		printbtn.addActionListener(this);
		leftpanel.add(printbtn);
		
//--------------------------------------------------------------------------------------------------		
		// actionlistener for payment mode combo box
		mopfield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mopfield.getSelectedIndex() == 0) {
					ddl.setVisible(true);
					ddfield.setVisible(true);
					banknamel.setVisible(true);
					banknamefield.setVisible(true);
					chequenol.setVisible(false);
					chequenofield.setVisible(false);
				}
				if (mopfield.getSelectedIndex() == 1) {
					ddl.setVisible(false);
					ddfield.setVisible(false);
					banknamel.setVisible(false);
					banknamefield.setVisible(false);
					chequenol.setVisible(false);
					chequenofield.setVisible(false);
				}
				if (mopfield.getSelectedIndex() == 2) {
					ddl.setVisible(false);
					ddfield.setVisible(false);
					banknamel.setVisible(true);
					banknamefield.setVisible(true);
					chequenol.setVisible(true);
					chequenofield.setVisible(true);

				}

			}
		});
	}
		
		public boolean valiDate() {
				if (recivefield.getText().equals("")) {
					JOptionPane.showMessageDialog(new AddFees("anu"), "please enter the name");
					return false;
				}
				if (datefield.getText().equals("")) {
					JOptionPane.showMessageDialog(new AddFees("anu"), "please enter the date");
					return false;
				}
				if (parenttextfield.getText().equals("")) {
					JOptionPane.showMessageDialog(new AddFees("anu"), "please enter the parent name");
					return false;
				}
				if (amounttextfield1.getText().matches("[0-9]+") == false || amounttextfield1.getText().equals("")) {
					JOptionPane.showMessageDialog(new AddFees("anu"), "please enter amount");
					return false;
				}
				if (mopfield.getSelectedItem().toString().equalsIgnoreCase("cheque")) {
					if (chequenofield.getText().equals("")) {
						JOptionPane.showMessageDialog(new AddFees("anu"), "please enter the cheque number");
						return false;
					}
					if (banknamefield.getText().equals("")) {
						JOptionPane.showMessageDialog(new AddFees("anu"), "please enter the bank name");
						return false;
					}
				}
				if (mopfield.getSelectedItem().toString().equalsIgnoreCase("dd")) {
					if (ddfield.getText().equals("")) {
						JOptionPane.showMessageDialog(new AddFees("anu"), "please enter the dd number");
						return false;
					}
					if (banknamefield.getText().equals("")) {
						JOptionPane.showMessageDialog(new AddFees("anu"), "please enter the bank name");
						return false;
					}
				}
				return true;
			}

			
		String status;
		String insertData() {
				String date, studentname, parentname, mr, paymentmode, chequenumber, bankname, ddnumber, coursename, year,
				sem, totalinwords;
				int reciptNo, amount, totalamount;
				reciptNo = Integer.parseInt(reciptfield.getText());
				date = datefield.getText();
				studentname = recivefield.getText();
				mr = mrfield.getSelectedItem().toString();
				parentname = parenttextfield.getText();
				paymentmode = mopfield.getSelectedItem().toString();
				chequenumber = chequenofield.getText();
				bankname = banknamefield.getText();
				ddnumber = ddfield.getText();
				coursename = coursefield.getSelectedItem().toString();
				year = yearfield.getSelectedItem().toString();
				sem = semfield.getSelectedItem().toString();
				amount = Integer.parseInt(amounttextfield1.getText());
				totalamount = Integer.parseInt(amounttextfield2.getText());
				totalinwords = modetextfield2.getText();

				try {
					Connection con = DBConnection.getConnection();
					PreparedStatement pst = con
							.prepareStatement("insert into feesdetail values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

					pst.setInt(1, reciptNo);
					pst.setString(2, studentname);
					pst.setString(3, mr);
					pst.setString(4, date);
					pst.setString(5, parentname);
					pst.setString(6, paymentmode);
					pst.setString(7, chequenumber);
					pst.setString(8, bankname);
					pst.setString(9, ddnumber);
					pst.setString(10, coursename);
					pst.setString(11, year);
					pst.setString(12, sem);
					pst.setInt(13, amount);
					pst.setInt(14, totalamount);
					pst.setString(15, totalinwords);

					int rowcount = pst.executeUpdate();
					if (rowcount == 1) {
						status = "success";
					} else {
						status = "failed";
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return status;
			}
		
	
			public void actionPerformed(ActionEvent e) {
				if (valiDate()) {
					String result = insertData();

					if (result.equals("success")) {
							recivefield.setText("");
							banknamefield.setText("");
							chequenofield.setText("");
							ddfield.setText("");
							amounttextfield1.setText("");
							amounttextfield2.setText("");
							modetextfield1.setText("");
							datefield.setText("");
							modetextfield1.setText("");
							parenttextfield.setText("");
							coursefield.setSelectedIndex(0);
							semfield.setSelectedIndex(0);
							yearfield.setSelectedIndex(0);
							parentfield.setSelectedIndex(0);
							mrfield.setSelectedIndex(0);
							modetextfield2.setText("");
							JOptionPane.showMessageDialog(this, "record insert successfully");
							setVisibility();
							new PrintFeeRecipt();
						} else {
						JOptionPane.showMessageDialog(this, "record not insert");
					}
				}

			}

			

		// leftpanel end
//-------------------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------------------

		

	public int getReciptNo() {
		int reciptNo = 0;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("select max(recipt_no) from feesdetail");
			ResultSet rs = pst.executeQuery();

			if (rs.next() == true) {
				reciptNo = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reciptNo + 1;
	}

//---------------------------------------------------------------------------------------------------------

	public AddFees(String name) {

	}

	public AddFees() {
		this.setTitle("Add Fees");
		this.setVisible(true);
		this.setBounds(160, 80, 950, 770);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		con.setLayout(null);

		rightpanelLayout();
		leftpanelLayout();

	}
}
