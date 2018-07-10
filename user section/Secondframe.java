package secondframe;
import thirdframe.Thirdframe;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Secondframe implements ActionListener{
	JFrame obj2=new JFrame();
JLabel l2,l3,l4,L4;
JButton b3;
JTextField t1;
JPasswordField p1;
public Secondframe()
{
l2=new JLabel("Librarian Login Form");	
l3=new JLabel("Enter Name:");
l4=new JLabel("Enter Password:");
L4=new JLabel("");
b3=new JButton("Login");	
t1=new JTextField();	
p1=new JPasswordField();
obj2.setSize(400,400);
obj2.setVisible(true);
obj2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
obj2.setLayout(null);
l2.setBounds(120,30,200,50);	
l3.setBounds(20,120,110,30);	
l4.setBounds(20,190,110,30);
L4.setBounds(30,260,130,40);	
b3.setBounds(130,260,130,40);	
t1.setBounds(150,120,150,30);	
p1.setBounds(150,190,150,30);	
obj2.add(l2);
obj2.add(l3);
obj2.add(l4);
obj2.add(L4);
obj2.add(b3);
obj2.add(t1);
obj2.add(p1);
b3.addActionListener(this);
}

public void actionPerformed(ActionEvent e1)
{
  String s11=e1.getActionCommand();

   if(s11.equals("Login"))
  {

  try
  {

     Class.forName("com.mysql.jdbc.Driver");
     System.out.println("Driver loaded");
     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
     Statement stmt=con.createStatement();  
     ResultSet rs=stmt.executeQuery("select * from AddLibrarian");   
 
    while(rs.next()) 
    {
    String s1=t1.getText();
    String s2=rs.getString(1);
    
    String s3=new String(p1.getText());
    String s4=rs.getString(2);

    if(s1.equals(s2) && s3.equals(s4))
    {
     obj2.dispose();
     Thirdframe ob=new Thirdframe();				
   }
   else
    L4.setText("Invalid User");   
  
}
}catch(Exception exp){System.out.println("Exception Occurs");}
}

}

}
