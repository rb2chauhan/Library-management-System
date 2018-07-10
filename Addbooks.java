package addbooks;
import librarianSection.LibrarianSection;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Addbooks implements ActionListener
{
JFrame obj4=new JFrame();
JLabel la,lb,lc,ld,le,lf;
JTextField t1,t2,t3,t4,t5;
JButton ba,bb;

public Addbooks(){
la=new JLabel("Add Books");
lb=new JLabel("Call No:");
lc=new JLabel("Name:");
ld=new JLabel("Auth...");
le=new JLabel("Publisher");
lf=new JLabel("Quantity");

t1=new JTextField();
t2=new JTextField();
t3=new JTextField();
t4=new JTextField();
t5=new JTextField();

ba=new JButton("Add Books");
bb=new JButton("Back");
obj4.setSize(500,500);
obj4.setVisible(true);
obj4.setLayout(null);

la.setBounds(180,20,100,30);
lb.setBounds(30,90,100,30);
lc.setBounds(30,140,100,30);
ld.setBounds(30,190,100,30);
le.setBounds(30,240,100,30);
lf.setBounds(30,290,100,30);
t1.setBounds(180,90,180,30);
t2.setBounds(180,140,180,30);
t3.setBounds(180,190,180,30);
t4.setBounds(180,240,180,30);
t5.setBounds(180,290,180,30);
ba.setBounds(200,330,110,35);
bb.setBounds(370,380,70,35);
obj4.add(la);
obj4.add(lb);
obj4.add(lc);
obj4.add(ld);
obj4.add(le);
obj4.add(lf);
obj4.add(t1);
obj4.add(t2);
obj4.add(t3);
obj4.add(t4);
obj4.add(t5);
obj4.add(ba);
obj4.add(bb);

obj4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

ba.addActionListener(this);
bb.addActionListener(this);
}

public void actionPerformed(ActionEvent e)
{
 String s1=e.getActionCommand();
  if(s1.equals("Add Books"))
  {
   try
   {
    Class.forName("com.mysql.jdbc.Driver");
    System.out.println("Driver Loaded");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library"+ "?verifyServerCertificate=false"
                    + "&useSSL=false"
                    + "&requireSSL=false","root","");
    System.out.println("Connnection Established");
    PreparedStatement stmt=con.prepareStatement("insert into AddBooks(Call_no,Name,Author,Publisher,Quantity) values(?,?,?,?,?)");
   
    stmt.setString(1,t1.getText());
    stmt.setString(2,t2.getText());
    stmt.setString(3,t3.getText());
    stmt.setString(4,t4.getText());
    stmt.setString(5,t5.getText());
 
    stmt.executeUpdate();
    con.close();
     JOptionPane.showMessageDialog(null,"Books Added Successfully!");  
    System.out.println("Connection DisConnected");
   }
   catch(Exception ee)
   {
    System.out.println("Connection not established");
   }
  }

  if(s1.equals("Back"))
  {
   obj4.dispose();
   new LibrarianSection();
  }
}






}