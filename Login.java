package login;
import adminSection.AdminSection;
import login1.Login1;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
public class Login  implements ActionListener
{   
  private JFrame f1;
  private JLabel l1,l2,l3,l4;
  private JButton b1,b2;
  private JTextField t1;
  private JPasswordField p1;

  public  Login()
  { 
   f1=new JFrame();
   f1.setVisible(true);
   f1.setSize(400,300);
   f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   l1=new JLabel("Login Page");
   l2=new JLabel("Admin_Id");
   l3=new JLabel("Password");
   l4=new JLabel("");
   f1.add(l1);
   f1.add(l2);
   f1.add(l3);
   f1.add(l4);

   t1=new JTextField();
   p1=new JPasswordField();

   f1.add(t1);
   f1.add(p1);
   
   b1=new JButton("Login");
   b2=new JButton("BACK");

   f1.add(b1);
   f1.add(b2);


  f1.setLayout(null);

  l1.setBounds(100,30,100,30);
  l2.setBounds(20,80,80,30);
  l3.setBounds(20,130,80,30);
  l4.setBounds(10,250,100,30);

  t1.setBounds(120,80,140,30);
  p1.setBounds(120,130,140,30); 

  b1.setBounds(100,190,70,30);
  b2.setBounds(190,230,70,30);
  
  b1.addActionListener(this);
  b2.addActionListener(this);
  }
 
 public void actionPerformed(ActionEvent e) 
 { 
   String s1=e.getActionCommand();
   String s2=t1.getText(); 
   String s3=new String(p1.getPassword());
   if(s1.equals("Login"))
   {
   if(s2.equals("admin") && s3.equals("rxu"))
   {
     f1.dispose();
     new AdminSection();
   }
  else
   JOptionPane.showMessageDialog(null,"Invalid Admin");   
 }
  if(s1.equals("BACK"))
  {
   f1.dispose();
   new Login1();
  }
 }
  public static void  main(String args[])
  {
   new Login();
   

  } 
}








