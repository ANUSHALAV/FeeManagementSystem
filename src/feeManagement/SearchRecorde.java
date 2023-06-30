package feeManagement;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SearchRecorde extends JFrame {

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
				String year=rs.getString("year");
				String semester=rs.getString("sem");
				String paymentmode = rs.getString("payment_mode");
				String bankname=rs.getString("bank_name");
				int totalamount = rs.getInt("total_amount");
				String date=rs.getString("fee_submit_date");
				Object[] obj = { reciptno, studentname, parentname, coursename,year,semester,paymentmode,bankname, totalamount,date };
				model = (DefaultTableModel) table.getModel();
				model.addRow(obj);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public SearchRecorde() {
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
				new String[] { "Recipt no", "Student name", "Parent name", "Course","Year","semester", "Payment mode","Bank name", "Total amount","Date" }) {
			/**
					 * 
					 */
					private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false,false, false,false,false, false, false,false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		JLabel lblSearchRecord = new JLabel("Search Record");
		lblSearchRecord.setIcon(new ImageIcon(example.class.getResource("/images/search2.png")));
		lblSearchRecord.setForeground(new Color(255, 255, 255));
		lblSearchRecord.setFont(new Font("Tahoma", Font.BOLD, 39));
		lblSearchRecord.setBounds(282, 11, 368, 64);
		contentPane.add(lblSearchRecord);

		lblSearch = new JLabel("Search ");
		lblSearch.setForeground(new Color(255, 255, 255));
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblSearch.setBounds(196, 148, 86, 33);
		contentPane.add(lblSearch);

		searchfield = new JTextField();
		searchfield.setBounds(282, 150, 329, 31);
		contentPane.add(searchfield);
		searchfield.setColumns(10);
		searchfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String searchString = searchfield.getText();
				search(searchString);
			}
		});
		setRecordInTable();

	}

	public void search(String str) {
		model = (DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
		table.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));

	}
}
