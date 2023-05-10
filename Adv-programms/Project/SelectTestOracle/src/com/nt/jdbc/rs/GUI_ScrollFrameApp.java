package com.nt.jdbc.rs;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI_ScrollFrameApp extends JFrame implements ActionListener,WindowListener  {
	
	private static final String GET_ALL_STUDENT_DETAILS="SELECT SID,SNAME,SADDR,SAVG FROM STUDENT";
	private JLabel lsno,lsname,laddr,lavg;
	private JTextField Tsno,Tsname,Taddr,Tavg;
	private JButton bFirst,bNext,bPrevios,bLast;
//	private JButton bSearch;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	GUI_ScrollFrameApp(){
		
		
		System.out.println("GUI_ScrollFrameApp:0-ParamConstructor");
		setTitle("GUI_Front End");
		setSize(300,300);
		setBackground(Color.yellow);
		setLayout(new FlowLayout());
		
		lsno=new JLabel("sno");
		add(lsno);
		Tsno=new JTextField(10);
		add(Tsno);
		
		lsname=new JLabel("sname");
		add(lsname);
		Tsname=new JTextField(10);
		add(Tsname);
		
		laddr=new JLabel("saddr");
		add(laddr);
		Taddr=new JTextField(10);
		add(Taddr);
		
		lavg=new JLabel("avg");
		add(lavg);
		Tavg=new JTextField(10);
		add(Tavg);
		
		bFirst=new JButton("first");
		add(bFirst);
		bNext=new JButton("Next");
		add(bNext);
		bPrevios=new JButton("Previos");
		add(bPrevios);
		bLast=new JButton("Last");
		add(bLast);
	//	bSearch=new JButton("Search");
//		add(bSearch);
		
		bFirst.addActionListener(this);
		bNext.addActionListener(this);
		bPrevios.addActionListener(this);
		bLast.addActionListener(this);
		
		this.addWindowListener(this);
		
		
		Tsno.setEditable(false);
		Tsname.setEditable(false);
		Taddr.setEditable(false);
		Tavg.setEditable(false);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initializeJDBC();
	}
	private void initializeJDBC() {
		System.out.println("GUI_ScrollFrameApp:initializeJDBC()");
		try {
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
		ps=con.prepareStatement(GET_ALL_STUDENT_DETAILS,
				                ResultSet.TYPE_SCROLL_SENSITIVE,
				                ResultSet.CONCUR_UPDATABLE);
		rs=ps.executeQuery();
		}
		catch(SQLException se) {
		 se.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		
	
		System.out.println("GUI_ScrollFrameApp.main--->start");
		new GUI_ScrollFrameApp();
		System.out.println("GUI_ScrollFrameApp.main--->end");
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		try {
			//boolean flag=false;
		System.out.println("GUI_ScrollFrameApp.actionPerformed");
		boolean flag=false;
		if(ae.getSource()==bFirst) {
	    	System.out.println("First Button");
			rs.first(); 
			flag=true;
		}
		else if(ae.getSource()==bNext) {
			System.out.println("Next Button");
			if(!rs.isLast()) {
				rs.next();
				flag=true;
			}
			
		}
		else if(ae.getSource()==bPrevios) {
			System.out.println("Previos Button");
			if(!rs.isFirst()) {
				rs.previous();
				flag=true;
			}
		}
		else  {
			System.out.println("Last Button");
			rs.last();
			flag=true;
			
		}
		if(flag) {
			Tsno.setText(rs.getString(1));
			Tsname.setText(rs.getString(2));
			Taddr.setText(rs.getString(3));
			Tavg.setText(rs.getString(4));
		}
	
	}
	catch(SQLException se) {
		se.printStackTrace();
	}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
    System.out.println("GUI_ScrollFrameApp.windowClosing()");
    try {
    	if(rs!=null)
    	rs.close();
    }
    catch(SQLException se) {
    	se.printStackTrace();
    }
    try {
    	if(ps!=null)
    		ps.close();
    }
    catch(SQLException se) {
    	se.printStackTrace();
    }
    try {
    	if(con!=null)
    		con.close();
    }
    catch(SQLException se) {
    	se.printStackTrace();
    }
    		
    }
		
	
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
	
