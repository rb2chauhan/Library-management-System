package showLibrarianTable;
import adminSection.AdminSection;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ShowLibrarianTable  implements ActionListener
{
 private JFrame f1; 
 private JTable tb1;
 
 int i,j,p=0;

 public ShowLibrarianTable()
 {  f1=new JFrame();
    JButton b1=new JButton("BACK");
    f1.add(b1);
    b1.setBounds(500,600,70,30);
    try
  {

     Class.forName("com.mysql.jdbc.Driver");
     System.out.println("Driver loaded");
     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
     Statement stmt=con.createStatement();  
     ResultSet rs=stmt.executeQuery("select * from addlibrarian");  
      
     ResultSetMetaData rsmd=rs.getMetaData();
     int count=rsmd.getColumnCount();
     System.out.println("No. of Column = "+count);
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

     /* while(rs.next())
      {
       for(i=1;i<=count;i++)
       {
       System.out.println(rs.getString(i)+" data ");
       } 
      }*/
     int l=0;
     while(rs.next())      
      {       
          
           int k=1;
                 
         for(j=0;j<count;j++)
         { 
                 
         data[l][j]=rs.getString(k);
        // System.out.println(rs.getString(k)+" data ");
        k++;
         } 
        l++;  
      }System.out.println("l = "+l);
      tb1=new JTable(data,column);
      tb1.setBounds(5,5,200,300);
      JScrollPane sp=new JScrollPane(tb1);   
      f1.add(sp);
     
    
     f1.setVisible(true);  
     f1.setSize(800,700);
     f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
    
  
  }catch(Exception ex){System.out.println("Exception occures");}


 b1.addActionListener(this);
 
 }

 public void actionPerformed(ActionEvent e)
 {
  f1.dispose();
  new AdminSection();   
 }
 public static void main(String args[])
 {
  new ShowLibrarianTable();

 }
}





