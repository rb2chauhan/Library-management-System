package deleteLibrarian;
import adminSection.AdminSection;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.sql.*;
public class DeleteLibrarian  implements ActionListener
{
  private JFrame f1;
  private JLabel l1,l2,l3;
  private JButton b1,b2;
  private JTextField t1;
  

  public  DeleteLibrarian()
  { 
   f1=new JFrame();
   f1.setVisible(true);
   f1.setSize(400,300);
   f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   l1=new JLabel("Name : ");
   f1.add(l1);

   t1=new JTextField();

   f1.add(t1);
 
   
   b1=new JButton("Delete");
   b2=new JButton("BACK");

   f1.add(b1);
   f1.add(b2);


  f1.setLayout(null);

  l1.setBounds(40,80,140,30);
  t1.setBounds(120,80,140,30);
  b1.setBounds(130,190,70,30);
  b2.setBounds(240,220,70,30);
  
  b1.addActionListener(this);
  b2.addActionListener(this);
  }
 
 public void actionPerformed(ActionEvent e) 
 { 
   String s1=e.getActionCommand();
  // String s2=t1.getText(); 
   if(s1.equals("Delete"))
   {
        try
  {

     Class.forName("com.mysql.jdbc.Driver");
     System.out.println("Driver loaded");
     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
     Statement stmt=con.createStatement();  
     ResultSet rs=stmt.executeQuery("select * from addlibrarian"); 
      while(rs.next()) 
    {
    String s2=t1.getText();
    String s3=rs.getString(1);
    System.out.println(s2);   
    System.out.println(s3);
    if(s2.equals(s3))
    {
    PreparedStatement pstmt=con.prepareStatement("delete from addlibrarian where Name=?");
    pstmt.setString(1,t1.getText());
    pstmt.executeUpdate();
    JOptionPane.showMessageDialog(null,"Delete Successfully !");
    } 
   else
  JOptionPane.showMessageDialog(null,"Librarian Not Exist !");
  
   } 
  con.close();
  System.out.println("disconnected");

  }catch(Exception ex){System.out.println("Exeption occurs : - "+ex);}
   }
   if(s1.equals("BACK"))
   {
    f1.dispose();
    new AdminSection();
   
   }
   
 }
  public static void  main(String args[])
  {
   new DeleteLibrarian();
  
  } 
}








