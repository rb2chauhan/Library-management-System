package returnBook;
import librarianSection.LibrarianSection;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.sql.*;
public class ReturnBook  implements ActionListener
{
  JFrame f1;
  private JLabel l1,l2,l3,l4;
  private JButton b1,b2;
  private JTextField t1,t2;
  
  public ReturnBook()
  { 
   f1=new JFrame();

   f1.setVisible(true);
   f1.setSize(500,400);
   f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   f1.setLayout(null);

   l1=new JLabel("RETURN BOOK");
   l2=new JLabel("Book_Call_No :-");
   l3=new JLabel("Student_Id:-");
   l4=new JLabel("");
   

   t1=new JTextField();
   t2=new JTextField();

  
   
   b1=new JButton("Return Book");
   b2=new JButton("BACK");

  
   f1.add(l1);
   f1.add(l2);
   f1.add(l3);
   f1.add(l4);
   f1.add(t1);
   f1.add(t2);
   f1.add(b1);
   f1.add(b2);



  l1.setBounds(150,20,100,30);
  l2.setBounds(20,80,100,30);
  l3.setBounds(20,130,100,30);
  t1.setBounds(150,80,100,30);
  t2.setBounds(150,130,100,30);
  b1.setBounds(200,190,120,30);
  b2.setBounds(300,300,70,30);
  l4.setBounds(10,250,200,30);

  b1.addActionListener(this);
  b2.addActionListener(this);
  }
 
 public void actionPerformed(ActionEvent e) 
 { 
   String s1=e.getActionCommand();
   String s2=t1.getText(); 
   if(s1.equals("Return Book"))
   {
        try
  {

     Class.forName("com.mysql.jdbc.Driver");
     System.out.println("Driver loaded");
     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
     Statement stmt=con.createStatement();  

     ResultSet rs=stmt.executeQuery("select * from IssueBooks"); 
     
      while(rs.next()) 
    {
    String s22=t1.getText();
    String s3=rs.getString(1);
    
    String s4=t2.getText();
    String s5=rs.getString(2);
 

 
   
    if(s22.equals(s3) && s4.equals(s5))
    {
    PreparedStatement pstmt=con.prepareStatement("delete from IssueBooks where Book_Call_no=? and Student_id=?");
    pstmt.setString(1,t1.getText());
    pstmt.setString(2,t2.getText());
    pstmt.executeUpdate();


     /*PreparedStatement pstmt1=con.prepareStatement("select Quantity from AddBooks where Call_No=? ");
     pstmt1.setString(1,t1.getText());
     ResultSet rs1=pstmt1.executeQuery();
     int a=Integer.parseInt(rs.getString(5));
     System.out.println("a = "+a);*/

    l4.setText("");
    JOptionPane.showMessageDialog(null,"Return Successfully !");
    } 
   else
    l4.setText("This Book Is Not Issued !");
  
   } 
  con.close();
  System.out.println("disconnected");

  }catch(Exception ex){System.out.println("Exeption occurs : - "+ex);}
   }

  if(s1.equals("BACK"))
  {
   f1.dispose();
   new LibrarianSection();
  }
 }
  public static void  main(String args[])
  {
   new ReturnBook();
  } 
}








