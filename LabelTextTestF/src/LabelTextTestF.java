import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class LabelTextTestF extends JFrame implements ActionListener{
	JTextField tf1 =new JTextField(15);
	JPasswordField tf2 = new JPasswordField(8);
	JTextArea ta = new JTextArea(3,25);
	JButton bt1 = new JButton("OK");
	String s1 = new String();	String s2 = new String();
	LabelTextTestF(){
		FlowLayout flayout = new FlowLayout();
		setLayout(flayout);
		add(new Label("이름 입력"));	add(tf1);
		add(new Label("패스워드 입력"));	add(tf2);
		add(ta);	add(bt1);
		bt1.addActionListener(this);
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
public void actionPerformed(ActionEvent e) {
			ta.setText("이름");
			ta.append(tf1.getText()+"\n");
			//ta.append("패스워드 : " + tf2.getPassword());
			char[] pw = tf2.getPassword();
			String pass = new String(pw);
			ta.append("패스워드 : " + pass);		
			}
			public static void main(String[] args) {
				new LabelTextTestF();
	}
}