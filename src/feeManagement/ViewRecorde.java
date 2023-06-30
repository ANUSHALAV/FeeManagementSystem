package feeManagement;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewRecorde extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	DefaultTableModel model;
	private JLabel lblSearch;
	private JTextField searchfield;

	public void setRecordInTable() {
		try {

			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from feesdetail");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int reciptno = rs.getInt("recipt_no");
				String studentname = rs.getString("student_name");
				String parentname = rs.getString("parent_name");
				String coursename = rs.getString("course");
				String paymentmode = rs.getString("payment_mode");
				int totalamount = rs.getInt("total_amount");
				Object[] obj = { reciptno, studentname, parentname, coursename, paymentmode, totalamount };
				model = (DefaultTableModel) table.getModel();
				model.addRow(obj);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Create the frame.
	 */

	public ViewRecorde() {
		this.setBounds(200, 100, 950, 750);
		this.setVisible(true);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(4, 50, 86));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 251, 900, 400);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setForeground(new Color(255, 255, 255));
		table.setBackground(new Color(0, 0, 0));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Recipt no", "Student name", "Parent name", "Course", "Payment mode", "Total amount" }) {
			/**
					 * 
					 */
					private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		JLabel lblSearchRecord = new JLabel("View Record");
		lblSearchRecord.setIcon(new ImageIcon(example.class.getResource("/images/view all record.png")));
		lblSearchRecord.setForeground(new Color(255, 255, 255));
		lblSearchRecord.setFont(new Font("Tahoma", Font.BOLD, 39));
		lblSearchRecord.setBounds(282, 11, 368, 64);
		contentPane.add(lblSearchRecord);

		
		setRecordInTable();

	}

	
}
