package addLibrarian;
import adminSection.AdminSection;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.sql.*;
public class AddLibrarian   implements ActionListener
{ 
  private JFrame f1;
  private JLabel l1,l2,l3,l4,l5,l6,l7;
  private JButton b1,b2;
  private JTextField t1,t2,t3,t4,t5;
  private JPasswordField p1;


  public AddLibrarian()
  { 
   f1=new JFrame();

   
   f1.setVisible(true);
   f1.setSize(450,550);
   f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   l1=new JLabel("ADD LIBRARIAN");
   l2=new JLabel("Name :");
   l3=new JLabel("Pssword :");
   l4=new JLabel("Email :");
   l5=new JLabel("Address :");
   l6=new JLabel("City :");
   l7=new JLabel("Contact_No :");
   f1.add(l1);
   f1.add(l2);
   f1.add(l3);
   f1.add(l4);
   f1.add(l5);
   f1.add(l6);
   f1.add(l7);


   t1=new JTextField();
   t2=new JTextField();
   t3=new JTextField();
   t4=new JTextField();
   t5=new JTextField();
   p1=new JPasswordField();

   f1.add(t1);
   f1.add(t2);
   f1.add(t3);
   f1.add(t4);
   f1.add(t5);
   f1.add(p1);
   
   b1=new JButton("Add Librarian");
   b2=new JButton("Back");

   f1.add(b1);
   f1.add(b2);


  f1.setLayout(null);

  l1.setBounds(100,30,100,30);
  l2.setBounds(20,80,80,30);
  l3.setBounds(20,130,80,30);
  l4.setBounds(20,180,80,30);
  l5.setBounds(20,230,80,30);
  l6.setBounds(20,280,80,30);
  l7.setBounds(20,330,80,30);


  t1.setBounds(120,80,140,30);
  p1.setBounds(120,130,140,30); 
  t2.setBounds(120,180,140,30);
  t3.setBounds(120,230,140,30);
  t4.setBounds(120,280,140,30);
  t5.setBounds(120,330,140,30);

  b1.setBounds(120,390,140,30);
  b2.setBounds(140,440,70,30);
  
  b1.addActionListener(this);
  b2.addActionListener(this);
  }
 
 public void actionPerformed(ActionEvent e) 
 { 
  String s1=e.getActionCommand();
  if(s1.equals("Add Librarian"))
  {
   try
   {
    Class.forName("com.mysql.jdbc.Driver");
    System.out.println("Driver Loaded");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library"+ "?verifyServerCertificate=false"
                    + "&useSSL=false"
                    + "&requireSSL=false","root","");
    System.out.println("Connnection Established");
    PreparedStatement stmt=con.prepareStatement("insert into AddLibrarian(Name,Password,Email,Address,City,Contact_no) values(?,?,?,?,?,?)");
   
    stmt.setString(1,t1.getText());
    stmt.setString(2,new String(p1.getText()));
    stmt.setString(3,t2.getText());
    stmt.setString(4,t3.getText());
    stmt.setString(5,t4.getText());
    stmt.setInt(6,Integer.parseInt(t5.getText()));
 
    stmt.executeUpdate();
    con.close();
     JOptionPane.showMessageDialog(null,"Librarian Added Successfully!");  
    System.out.println("Connection DisConnected");
   }
   catch(Exception ee)
   {
    System.out.println("Connection not established");
   }
  }
  if(s1.equals("Back"))
  {
   f1.dispose();
   new AdminSection();
  }
   
 }
  public static void  main(String args[])
  {
   new AddLibrarian();


  } 
}








