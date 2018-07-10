package login1;
import login.Login;
import librarianLogin.LibrarianLogin;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Login1  implements ActionListener 
{
 private JFrame jf1;
 private JLabel l1;
 private JButton b1,b2;

 public  Login1()
 {
  jf1=new JFrame();
  jf1.setVisible(true);
  jf1.setSize(400,350);
  jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  l1=new JLabel("LOGIN PAGE");
  b1=new JButton("Admin Login");
  b2=new JButton("User Login"); 
 
  jf1.add(l1);
  jf1.add(b1);
  jf1.add(b2);

  jf1.setLayout(null);
 
  l1.setBounds(160,40,200,30);
  b1.setBounds(100,100,150,30);
  b2.setBounds(100,180,150,30);


 b1.addActionListener(this);
 b2.addActionListener(this);
 }
   public void actionPerformed(ActionEvent e) 
  {
   String s=e.getActionCommand();
   if(s.equals("Admin Login"))
  { 
   jf1.dispose();
   new Login();
 }
  if(s.equals("User Login"))
 {
   jf1.dispose();
   new LibrarianLogin();

 }
}
 
 public static void main(String args[])
 {
  Login1 f4=new Login1();
 
 }
}