import java.awt.*;
import javax.swing.*;
public class JLabelTextJFrame extends JFrame{
	JLabel lb1, lb2, lb3;
	JTextField tf;
	JTextArea ta;
	JPasswordField pf;
	JLabelTextJFrame(){
		super("�ؽ�Ʈ �����");
		setLayout(new FlowLayout());
		setSize(00, 500);
		setVisible(true);
		lb1 = new JLabel("�̸�");
		tf = new JTextField(20);
		lb2 = new JLabel("�ּ�");
		ta = new JTextArea(7, 20);
		lb3 = new JLabel("��й�ȣ");
		pf = new JPasswordField(20);
	    add(lb1);
	    add(tf);
	    add(lb2);
	    add(ta);
	    add(lb3);
	    add(pf);
		
	}
}
