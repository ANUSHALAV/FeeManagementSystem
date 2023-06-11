package feeManagement;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class SearchRecorde extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container con = getContentPane();
	JLabel heading, searchl;
	JTextField searchfield;
	JTable table;
	DefaultTableModel model;

	public SearchRecorde() {
		this.setBounds(200,100, 950, 750);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		leftSidePageLayout();

	}

	void leftSidePageLayout() {
		JPanel leftpanel = new JPanel();
		leftpanel.setBounds(0, 0, 950, 750);
		leftpanel.setBackground(new Color(4, 50, 86));
		leftpanel.setLayout(null);
		con.add(leftpanel);

		heading = new JLabel("Search Recorde");
		heading.setBounds(330, 20, 300, 50);
		heading.setForeground(Color.WHITE);
		heading.setFont(new Font("arial", Font.BOLD, 35));
		leftpanel.add(heading);
		
		searchl=new JLabel("Enter Search String :");
		searchl.setBounds(230,150,300,30);
		searchl.setForeground(Color.WHITE);
		searchl.setFont(new Font("arial",Font.BOLD,18));
		leftpanel.add(searchl);
		
		searchfield=new JTextField();
		searchfield.setBounds(430,150,250,30);
		leftpanel.add(searchfield);
		searchfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String searchString=searchfield.getText();
				search(searchString);
			}
		});

		String[] columnsName = { "ReciptNo", "StudentName", "Course", "PaymentMode", "Amount" };
		table = new JTable(model);
		table.setBounds(40, 230, 840, 470);
		table.setBackground(Color.black);
		table.setFont(new Font("arial",Font.BOLD,15));
		table.setForeground(Color.WHITE);
		model = (DefaultTableModel) table.getModel();
		leftpanel.add(table);
		model.addColumn(columnsName);
		setRecordInTable();
		

	}

	public void setRecordInTable() {
		try {

			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from feesdetail");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int reciptno = rs.getInt("recipt_no");
				String studentname = rs.getString("student_name");
				String coursename = rs.getString("course");
				String paymentmode = rs.getString("payment_mode");
				int totalamount = rs.getInt("total_amount");
				Object[] obj = { reciptno, studentname, coursename, paymentmode, totalamount };
				model.addRow(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void search(String str) {
		model=(DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> trs=new TableRowSorter<>();
		table.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
		
	}
}