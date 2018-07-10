package ShowLibrarian;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

public class ShowLibrarian extends JFrame implements ActionListener 
{

 private JTable table;
 private JButton b1;

 public void ShowLibrarian()
 {

		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setSurrendersFocusOnKeystroke(true);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		//table.setBounds(0, 11, 424, 48);
		//frame.getContentPane().add(table);


  b1=new JButton("ShowLibrarian");

 
  add(table);
  add(b1);


 setLayout(null);
 
 table.setBounds(10,10,370,150);
 b1.setBounds(100,250,150,30);


 b1.addActionListener(this);

 }
 public void actionPerformed(ActionEvent e) 
 { 
  
  {
   try
   {
    Class.forName("com.mysql.jdbc.Driver");
    System.out.println("Driver Loaded");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","");
    System.out.println("Connnection Established");
    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select * from addlibrarian");
  
    while(rs.next())
    {
     String s1=rs.getString(1);
     table.setText(s1);
    }
    con.close();
    System.out.println("Connection DisConnected");
   }
   catch(Exception ee)
   {
    System.out.println("Connection not established");
   }
  }
   
 }  public ShowLibrarian(String s)
  {
   super(s);
  }
  
 public static void main(String args[])
 {
  ShowLibrarian f4=new ShowLibrarian("Login Page");
  f4.ShowLibrarian();
  f4.setVisible(true);
  f4.setSize(400,350);
  f4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
 }
}