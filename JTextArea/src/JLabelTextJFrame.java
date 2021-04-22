import java.awt.*;
import javax.swing.*;
public class JLabelTextJFrame extends JFrame{
	JLabel lb1, lb2, lb3;
	JTextField tf;
	JTextArea ta;
	JPasswordField pf;
	JLabelTextJFrame(){
		super("텍스트 입출력");
		setLayout(new FlowLayout());
		setSize(00, 500);
		setVisible(true);
		lb1 = new JLabel("이름");
		tf = new JTextField(20);
		lb2 = new JLabel("주소");
		ta = new JTextArea(7, 20);
		lb3 = new JLabel("비밀번호");
		pf = new JPasswordField(20);
	    add(lb1);
	    add(tf);
	    add(lb2);
	    add(ta);
	    add(lb3);
	    add(pf);
		
	}
}
