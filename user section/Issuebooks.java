import javax.swing.*;


public class Issuebooks{
JFrame obj5=new JFrame();
JLabel la,lb,lc,ld,le;
JTextField ta,tb,tc,td;
JButton ba,bb;

 Issuebooks(){
la=new JLabel("Issue Book");
lb=new JLabel("Book Callno:");
lc=new JLabel("Student Id:");
ld=new JLabel("Student Name:");
le=new JLabel("Student Contact:");

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
obj5.add(la);
obj5.add(lb);
obj5.add(lc);
obj5.add(ld);
obj5.add(le);
obj5.add(ta);
obj5.add(tb);
obj5.add(tc);
obj5.add(td);
obj5.add(ba);
obj5.add(bb);
obj5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

public static void main(String args[])
{
Issuebooks objjj=new Issuebooks();		
}

}