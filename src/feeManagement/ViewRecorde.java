package feeManagement;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewRecorde extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container con = getContentPane();
	JLabel heading;
	JTable table;
	DefaultTableModel model;

	public ViewRecorde() {
		this.setVisible(true);
		this.setLayout(null);
		this.setBounds(200, 100, 950, 750);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		leftSidePageLayout();
	}
//----------------------------------------------------------------------------------------

	
	void leftSidePageLayout() {
		JPanel leftpanel = new JPanel();
		leftpanel.setBounds(0, 0, 950, 750);
		leftpanel.setBackground(new Color(4, 50, 86));
		leftpanel.setLayout(null);
		con.add(leftpanel);
		
		heading = new JLabel("View Recorde");
		heading.setBounds(350, 20, 300, 50);
		heading.setForeground(Color.WHITE);
		heading.setFont(new Font("arial", Font.BOLD, 35));
		leftpanel.add(heading);
		
		String[] columnsName = { "ReciptNo", "StudentName", "Course", "PaymentMode", "Amount" };
		table = new JTable(model);
		table.setBounds(70, 120, 820, 550);
		table.setBackground(Color.black);
		table.setFont(new Font("arial",Font.BOLD,15));
		table.setForeground(Color.WHITE);
		model = (DefaultTableModel) table.getModel();
		model.addColumn(columnsName);
		leftpanel.add(table);
		setRecordInTable();
		validate();
		
	}
	
	public void setRecordInTable() {
		try {

			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from feesdetail");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int reciptno =rs.getInt("recipt_no");
				String studentname = rs.getString("student_name");
				String coursename = rs.getString("course");
				String paymentmode = rs.getString("payment_mode");
				int totalamount = rs.getInt("total_amount");
				Object[] obj = { reciptno,studentname, coursename, paymentmode, totalamount };
				model.addRow(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}