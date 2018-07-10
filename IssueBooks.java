 package issueBooks;
import librarianSection.LibrarianSection;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class IssueBooks implements ActionListener
{
JFrame obj5=new JFrame();
JLabel la,lb,lc,ld,le,l1;
JTextField ta,tb,tc,td;
JButton ba,bb;

public IssueBooks(){
la=new JLabel("Issue Book");
lb=new JLabel("Book Callno:");
lc=new JLabel("Student Id:");
ld=new JLabel("Student Name:");
le=new JLabel("Student Contact:");
l1=new JLabel("");

ta=new JTextField();
tb=new JTextField();
tc=new JTextField();
td=new JTextField();

ba=new JButton("Issue Books");
bb=new JButton("Back");
obj5.setSize(500,500);
obj5.setVisible(true);
obj5.setLayout(null);

la.setBounds(180,20,100,30);
lb.setBounds(30,90,100,30);
lc.setBounds(30,140,100,30);
ld.setBounds(30,190,100,30);
le.setBounds(30,240,100,30);
ta.setBounds(180,90,180,30);
tb.setBounds(180,140,180,30);
tc.setBounds(180,190,180,30);
td.setBounds(180,240,180,30);
ba.setBounds(200,330,110,35);
bb.setBounds(370,380,70,35);
l1.setBounds(10,420,220,35);
obj5.add(la);
obj5.add(lb);
obj5.add(lc);
obj5.add(ld);
obj5.add(le);
obj5.add(l1);
obj5.add(ta);
obj5.add(tb);
obj5.add(tc);
obj5.add(td);
obj5.add(ba);
obj5.add(bb);
obj5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

ba.addActionListener(this);
bb.addActionListener(this);
}

public void actionPerformed(ActionEvent e)
{
 String s1=e.getActionCommand();
  if(s1.equals("Issue Books"))
  {
   try
   {
    Class.forName("com.mysql.jdbc.Driver");
    System.out.println("Driver Loaded");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library"+ "?verifyServerCertificate=false"
                    + "&useSSL=false"
                    + "&requireSSL=false","root","");
    System.out.println("Connnection Established");
    PreparedStatement pstmt=con.prepareStatement("insert into IssueBooks(Book_Call_No,Student_Id,Student_Name,Student_Contact) values(?,?,?,?)");
    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select * from AddBooks");
    while(rs.next())
    {
     String s11=rs.getString(1); 
     String s22=ta.getText();
     int qty=Integer.parseInt(rs.getString(5));
     System.out.println("Qty = "+qty);
    
     if(s11.equals(s22))
     {
     
      System.out.println("Matched");
      pstmt.setString(1,ta.getText());
      pstmt.setString(2,tb.getText());
      pstmt.setString(3,tc.getText());
      pstmt.setString(4,td.getText());
 
      pstmt.executeUpdate();
      
      qty=qty-1;
      PreparedStatement pstmt1=con.prepareStatement("update AddBooks set Quantity=? where Call_No=?");
      pstmt1.setInt(1,qty);
      pstmt1.setString(2,s11);
      pstmt1.executeUpdate();
      con.close();
      l1.setText("");
      JOptionPane.showMessageDialog(null,"Books Issue Successfully!");        
      System.out.println("Connection DisConnected");
     }
     else
      l1.setText("This Book Is Not Available In Library!");
    }
   }
   catch(Exception ee)
   {
    System.out.println("Connection not established");
   }
  }

  if(s1.equals("Back"))
  {
   obj5.dispose();
   new LibrarianSection();
  }
}



public static void main(String args[])
{
  new IssueBooks();		
}

}