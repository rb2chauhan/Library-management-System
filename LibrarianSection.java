package librarianSection;
import addbooks.Addbooks;
import showBooksTable.ShowBooksTable;
import issueBooks.IssueBooks;
import showIssueBooksTable.ShowIssueBooksTable;
import returnBook.ReturnBook;
import login1.Login1;
import javax.swing.*;
import java.awt.event.*;
public class LibrarianSection implements ActionListener{
	JFrame obj3=new JFrame();
JButton b4,b5,b6,b7,b8,b9;
public LibrarianSection()
{
b4=new JButton("Add Books");
b5=new JButton("View Books");
b6=new JButton("Issue Book");
b7=new JButton("View Issued Books");
b8=new JButton("Return Book");
b9=new JButton("Logout");
obj3.setSize(400,500);
obj3.setVisible(true);
obj3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
obj3.setLayout(null);
b4.setBounds(130,60,130,40);
b5.setBounds(130,130,130,40);
b6.setBounds(130,200,130,40);
b7.setBounds(130,270,130,40);
b8.setBounds(130,340,130,40);
b9.setBounds(130,410,130,40);
obj3.add(b4);
obj3.add(b5);
obj3.add(b6);
obj3.add(b7);
obj3.add(b8);
obj3.add(b9);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
b7.addActionListener(this);
b8.addActionListener(this);
b9.addActionListener(this);
}
public void actionPerformed(ActionEvent e2)
{
 String s3=e2.getActionCommand();
 if(s3.equals("Add Books"))
 {
  obj3.dispose();
  new Addbooks();
 } 
 if(s3.equals("View Books"))
 {
  obj3.dispose();
  new ShowBooksTable();
 }
 if(s3.equals("Issue Book"))
 {
  obj3.dispose();
  new IssueBooks();
 }

 if(s3.equals("View Issued Books")) 
 {
  obj3.dispose();
  new ShowIssueBooksTable();
 }
 if(s3.equals("Return Book")) 
 {
  obj3.dispose();
  new ReturnBook();
 }
 if(s3.equals("Logout")) 
 {
  obj3.dispose();
  new Login1();
 }
}
}