import javax.swing.*;
import java.awt.*; 
public class JLabelTextJApplet extends JFrame { 
   JTextField tf;
   JTextArea ta;
   JPasswordField pf;
   	  JLabelTextJApplet() {
      setLayout(new BorderLayout());
      JLabel lb1 = new JLabel("이름");
      JLabel lb2 = new JLabel("주소");
      JLabel lb3 = new JLabel("비밀");
      tf = new JTextField(20);
      ta = new JTextArea(7, 20);
      pf = new JPasswordField(20);
      JPanel jp1 = new JPanel();
      JPanel jp2 = new JPanel();
      JPanel jp3 = new JPanel();
      jp1.add(lb1);
      jp1.add(tf);
      jp2.add(lb2);
      jp2.add(ta);
      jp3.add(lb3);
      jp3.add(pf);
      add(jp1,"North");
      add(jp2,"Center");
      add(jp3,"South");
 
      setSize(300,250);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}  
