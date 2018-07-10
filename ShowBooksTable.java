package showBooksTable;
import librarianSection.LibrarianSection;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class ShowBooksTable implements ActionListener
{
 JFrame jf1;
 private JTable tb1;
 private JButton b1;
 int i,j,p=0;
 public  ShowBooksTable()
 { 
   jf1=new JFrame();

   b1=new JButton("BAck");
   jf1.add(b1);
   b1.setBounds(600,400,70,30);

   try
  {

     Class.forName("com.mysql.jdbc.Driver");
     System.out.println("Driver loaded");
     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
     Statement stmt=con.createStatement();  
     ResultSet rs=stmt.executeQuery("select * from AddBooks");  
      
     ResultSetMetaData rsmd=rs.getMetaData();
     int count=rsmd.getColumnCount();
    // System.out.println("No. of Column = "+count);
     String column[]=new String[count];
    
     for(i=0;i<count;i++)
     {
        p++;
       column[i]=rsmd.getColumnName(p);
     
    }       
           for(i=0;i<count;i++)
           {
           
           System.out.println("c_name :- "+column[i]);
           }
     
  /*  int x=0;    
     while(rs.next())      
      {       
      x++;       
      } */
  
   String data[][]=new String[9][count];

    
     int l=0;
     while(rs.next())      
      {       
          
           int k=1;
                 
         for(j=0;j<count;j++)
         { 
                 
         data[l][j]=rs.getString(k);
        k++;
         } 
        l++;  
      }System.out.println("l = "+l);
      tb1=new JTable(data,column);
      tb1.setBounds(5,5,200,300);
      JScrollPane sp=new JScrollPane(tb1);   
      jf1.add(sp);
      
      jf1.setVisible(true);
      jf1.setSize(700,500);
      jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         
 
  
  }catch(Exception ex){System.out.println("Exception occures");}

 
 b1.addActionListener(this);

 }

 public void actionPerformed(ActionEvent e)
 {
  jf1.dispose();
  new LibrarianSection();
 }
 
 public static void main(String args[])
 {
  ShowBooksTable tb2=new ShowBooksTable();

 }
}


 
 


