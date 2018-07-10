package adminSection;
import addLibrarian.AddLibrarian;
import showLibrarianTable.ShowLibrarianTable;
import deleteLibrarian.DeleteLibrarian;
import login1.Login1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
public class AdminSection implements ActionListener
{
  JFrame f1;
  private JLabel l1;
  private JButton b1,b2,b3,b4;

  public  AdminSection()
  { 
   f1=new JFrame();
   f1.setVisible(true);
   f1.setSize(400,500);
   f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   l1=new JLabel("Admin Section");
   f1.add(l1);
   
   b1=new JButton("Add Librarian");
   b2=new JButton("View Librarian");
   b3=new JButton("Delete Librarian");
   b4=new JButton("Logout");

   f1.add(b1);
   f1.add(b2);
   f1.add(b3);
   f1.add(b4);

   f1.setLayout(null);

   l1.setBounds(100,30,110,30);

   b1.setBounds(50,80,200,50);
   b2.setBounds(50,150,200,50);
   b3.setBounds(50,220,200,50);
   b4.setBounds(50,290,200,50);

   b1.addActionListener(this);
   b2.addActionListener(this);
   b3.addActionListener(this);
   b4.addActionListener(this);
  }
   

  public void actionPerformed(ActionEvent e)
  {
   String s1=e.getActionCommand();
   if(s1.equals("Add Librarian"))
   {
    f1.dispose();
    new AddLibrarian();
   }

   if(s1.equals("View Librarian"))
   {
     f1.dispose();
     new ShowLibrarianTable();
   }
   if(s1.equals("Delete Librarian"))
   {
    f1.dispose();
    new DeleteLibrarian();
   }

   if(s1.equals("Logout"))
   {
     f1.dispose();
     new Login1();
   }

  }


  public static void  main(String args[])
  {
  new AdminSection();
  

  } 
}








