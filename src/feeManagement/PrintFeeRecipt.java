package feeManagement;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class PrintFeeRecipt extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container con=getContentPane();
	JLabel  cheque_ddl,banknamel;
	JButton printbtn,bthbtn;
	JLabel stuofield,stuyear,stusem,mrfield,tatalinwordfield;
	JLabel reciptfield,datefield,paymentmodefield,chequenofield,banknamefield,ddfield,recivefield,parentfield,modefield1,amountfield1,amountfield4;
	void rightSidePageLayout() {
	con.setLayout(null);
	}
	
//-------------------------------------------------------------------------------------------------
	
	void leftSidePageLayout() {
		JPanel leftpanel = new JPanel();
		leftpanel.setBounds(0, 0, 1000, 1200);
		leftpanel.setBackground(new Color(24, 59, 86));
		leftpanel.setLayout(null);
		con.add(leftpanel);
		
		JPanel leftprintpanel =new JPanel();
		leftprintpanel.setBounds(40,20,800,720);
		leftprintpanel.setLayout(null);
		leftprintpanel.setBackground(Color.WHITE);
		leftpanel.add(leftprintpanel);
		
		printbtn=new JButton("Print");
		printbtn.setBounds(660,760,150,35);
		printbtn.setFont(new Font("arial",Font.BOLD,15));
		printbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		leftpanel.add(printbtn);
		printbtn.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				PrinterJob job = PrinterJob.getPrinterJob();
	            job.setJobName("Print Data");
	            
	            job.setPrintable(new Printable(){
	            public int print(Graphics pg,PageFormat pf, int pageNum){
	                    pf.setOrientation(PageFormat.LANDSCAPE);
	                 if(pageNum > 0){
	                    return Printable.NO_SUCH_PAGE;
	                }
	                
	                Graphics2D g2 = (Graphics2D)pg;
	                g2.translate(pf.getImageableX(), pf.getImageableY());
	                g2.scale(0.47,0.47);
	                
	                leftprintpanel.print(g2);
	         
	               
	                return Printable.PAGE_EXISTS;
	                         
	                
	            }
	    });
	            boolean ok = job.printDialog();
	        if(ok){
	        try{
	            
	        job.print();
	        }
	        catch (PrinterException ex){
		ex.printStackTrace();
	}
	        }

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		bthbtn=new JButton("Back to Home");
		bthbtn.setBounds(50,760,150,35);
		bthbtn.setFont(new Font("arial",Font.BOLD,15));
		bthbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		leftpanel.add(bthbtn);
		bthbtn.addActionListener(this);
		
		JLabel collegename1=new JLabel("Swami Purnanad");
		collegename1.setFont(new Font("arial",Font.BOLD,25));
		collegename1.setBounds(250,10,300,30);
		leftprintpanel.add(collegename1);
		
		JLabel collegename2=new JLabel("Degree College Of Technical Education");
 		collegename2.setBounds(170,45,500,30);
		collegename2.setFont(new Font("arial",Font.BOLD,20));
		leftprintpanel.add(collegename2);
		
		JLabel collegename3=new JLabel("Kailash Gate Muni ki Reti (Tehri Garhwal)");
		collegename3.setBounds(220,75,300,30);
		collegename3.setFont(new Font("arial",Font.BOLD,15));
		leftprintpanel.add(collegename3);
		
		JPanel border=new JPanel();
		border.setBounds(0,120,900,5);
		border.setBackground(Color.BLUE);
		leftprintpanel.add(border);
		
		
		JLabel reciptl=new JLabel("Recipt no :");
		reciptl.setBounds(50,150,100,20);
		reciptl.setFont(new Font("arial",Font.BOLD,15));
		leftprintpanel.add(reciptl);
		
		reciptfield=new JLabel("");
		reciptfield.setBounds(150,150,100,20);
		reciptfield.setFont(new Font("arial",Font.BOLD,15));
		leftprintpanel.add(reciptfield);
		
		JLabel datel=new JLabel("Date :");
		datel.setBounds(500,150,100,20);
		datel.setFont(new Font("arial",Font.BOLD,15));
		leftprintpanel.add(datel);
		
		datefield=new JLabel("");
		datefield.setBounds(550,150,150,20);
		datefield.setFont(new Font("arial",Font.BOLD,15));
		leftprintpanel.add(datefield);
		
		JLabel paymentmodel=new JLabel("Payment mode :");
		paymentmodel.setBounds(50,190,150,20);
		paymentmodel.setFont(new Font("arial",Font.BOLD,15));
		leftprintpanel.add(paymentmodel);
		
		paymentmodefield=new JLabel("Payment mode :");
		paymentmodefield.setBounds(170,190,150,20);
		paymentmodefield.setFont(new Font("arial",Font.BOLD,15));
		leftprintpanel.add(paymentmodefield);
		
		cheque_ddl=new JLabel("");
		cheque_ddl.setBounds(50,230,100,20);
		cheque_ddl.setFont(new Font("arial",Font.BOLD,15));
		leftprintpanel.add(cheque_ddl);
		
		chequenofield=new JLabel("");
		chequenofield.setBounds(170,230,200,20);
		chequenofield.setFont(new Font("arial",Font.BOLD,15));
		leftprintpanel.add(chequenofield);
		
		ddfield=new JLabel("");
		ddfield.setBounds(170,230,100,20);
		ddfield.setFont(new Font("arial",Font.BOLD,15));
		leftprintpanel.add(ddfield);
		
		banknamel=new JLabel("");
		banknamel.setBounds(50,270,100,20);
		banknamel.setFont(new Font("arial",Font.BOLD,15));
		leftprintpanel.add(banknamel);
		
		banknamefield=new JLabel("");
		banknamefield.setBounds(170,270,200,20);
		banknamefield.setFont(new Font("arial",Font.BOLD,15));
		leftprintpanel.add(banknamefield);
		
		JLabel recivefroml=new JLabel("Recive from :");
		recivefroml.setBounds(50,310,100,20);
		recivefroml.setFont(new Font("arial",Font.BOLD,15));
		leftprintpanel.add(recivefroml);
		
		recivefield=new JLabel("");
		recivefield.setBounds(170,310,200,20);
		recivefield.setFont(new Font("arial",Font.BOLD,15));
		leftprintpanel.add(recivefield);
		
		JLabel parentnamel=new JLabel("Parent :");
		parentnamel.setBounds(400,310,100,20);
		parentnamel.setFont(new Font("arial",Font.BOLD,15));
		leftprintpanel.add(parentnamel);
		
		mrfield=new JLabel("");
		mrfield.setBounds(470,310,50,20);
		mrfield.setFont(new Font("arial",Font.BOLD,15));
		leftprintpanel.add(mrfield);
		
		parentfield=new JLabel("");
		parentfield.setBounds(500,310,400,20);
		parentfield.setFont(new Font("arial",Font.BOLD,15));
		leftprintpanel.add(parentfield);
		
		JLabel studentofl=new JLabel("Student of  :");
		studentofl.setBounds(50,350,100,20);
		studentofl.setFont(new Font("arial",Font.BOLD,15));
		leftprintpanel.add(studentofl);
		
		stuofield=new JLabel("");
		stuofield.setBounds(150,350,100,20);
		stuofield.setFont(new Font("arial",Font.BOLD,15));
		leftprintpanel.add(stuofield);
		
		JLabel studentyearl=new JLabel("Year :");
		studentyearl.setBounds(350,350,100,20);
		studentyearl.setFont(new Font("arial",Font.BOLD,15));
		leftprintpanel.add(studentyearl);
		
		stuyear=new JLabel("");
		stuyear.setBounds(400,350,100,20);
		stuyear.setFont(new Font("arial",Font.BOLD,15));
		leftprintpanel.add(stuyear);
		
		JLabel studentseml=new JLabel("Semester :");
		studentseml.setBounds(500,350,100,20);
		studentseml.setFont(new Font("arial",Font.BOLD,15));
		leftprintpanel.add(studentseml);
		
		stusem=new JLabel("");
		stusem.setBounds(590,350,100,20);
		stusem.setFont(new Font("arial",Font.BOLD,15));
		leftprintpanel.add(stusem);
		
		JSeparator separator1=new JSeparator();
		separator1.setBounds(0,400,800,5);
		separator1.setBackground(Color.BLACK);
		leftprintpanel.add(separator1);
		
		JSeparator separator2=new JSeparator();
		separator2.setBounds(0,440,800,5);
		separator2.setBackground(Color.BLACK);
		leftprintpanel.add(separator2);
		
		JLabel model = new JLabel("Mode");
		model.setBounds(250, 410, 100, 25);
		model.setFont(new Font("arial",Font.BOLD,15));
		leftprintpanel.add(model);
		
		modefield1=new JLabel("");
		modefield1.setBounds(235,470,200,30);
		modefield1.setFont(new Font("arial",Font.BOLD,20));
		leftprintpanel.add(modefield1);
		
		JLabel amountl = new JLabel("Amount");
		amountl.setBounds(580, 410, 100, 25);
		amountl.setFont(new Font("arial",Font.BOLD,15));
		leftprintpanel.add(amountl);

		amountfield1 = new JLabel("");
		amountfield1.setBounds(580, 470, 100, 25);
		amountfield1.setFont(new Font("arial",Font.BOLD,20));
		leftprintpanel.add(amountfield1);
		
		JSeparator separator3=new JSeparator();
		separator3.setBounds(520,570,180,30);
		separator3.setBackground(Color.BLACK);
		leftprintpanel.add(separator3);
		
		amountfield4=new JLabel("");
		amountfield4.setBounds(580,590,200,30);
		amountfield4.setFont(new Font("arial",Font.BOLD,20));
		leftprintpanel.add(amountfield4);
		
		JLabel tatalinwordl=new JLabel("Total In Word :");
		tatalinwordl.setBounds(25,580,200,30);
		tatalinwordl.setFont(new Font("arial",Font.BOLD,15));
		leftprintpanel.add(tatalinwordl);
		
		tatalinwordfield=new JLabel("");
		tatalinwordfield.setBounds(150,580,300,30);
		tatalinwordfield.setFont(new Font("arial",Font.BOLD,15));
		leftprintpanel.add(tatalinwordfield);
		
		}
	
	public void getData() {
		try {
			Connection con=DBConnection.getConnection();
			PreparedStatement pst= con.prepareStatement("select * from feesdetail order by recipt_no desc");
			ResultSet rs=pst.executeQuery();
			rs.next();
			reciptfield.setText(rs.getString("recipt_no"));
			paymentmodefield.setText(rs.getString("payment_mode"));
			
			String paymentmode=rs.getString("payment_mode");
			if(paymentmode.equalsIgnoreCase("cash")) {
				 cheque_ddl.setText("");
				 banknamel.setText("");
			}
			if(paymentmode.equalsIgnoreCase("cheque")) {
				 cheque_ddl.setText("Cheque no :");
				 banknamel.setText("Bank Name :");
				 banknamefield.setText(rs.getString("bank_name"));
				 chequenofield.setText(rs.getString("cheque_number"));
			}
			if(paymentmode.equalsIgnoreCase("dd")) {
				 cheque_ddl.setText("DD no :");
				 banknamel.setText("Bank Name :");
				 banknamefield.setText(rs.getString("bank_name"));
				 ddfield.setText(rs.getString("dd_number"));
			}
			datefield.setText(rs.getString("fee_submit_date"));
			recivefield.setText(rs.getString("student_name"));
			mrfield.setText(rs.getString("mr"));
			parentfield.setText(rs.getString("parent_name"));
			modefield1.setText(rs.getString("course"));
			stuofield.setText(rs.getString("course"));
			stuyear.setText(rs.getString("year"));
			stusem.setText(rs.getString("sem"));
			amountfield1.setText(rs.getString("amount"));
			amountfield4.setText(rs.getString("total_amount"));
			tatalinwordfield.setText(rs.getString("total_amount_in_word"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	void pageLayout() {
		rightSidePageLayout();
		leftSidePageLayout();
		getData();
		
	}
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}
	
	public PrintFeeRecipt(){
		this.setTitle("Print FeeRecipt");
		this.setBounds(200,80,900,850);
		this.setVisible(true);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		pageLayout();
	}
}
