import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement; 
public class register extends JFrame{
	JLabel idlb, pwlb;
	JTextField id;
	JPasswordField pw;
	JRadioButton admin,user;
	ButtonGroup bg;
	JButton  register, cancel; 
	JPanel jp;
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;

	userpanel up = null;
	adminpanel ap = null;

	public void change(String panelName) {
		if(panelName.equals("up")) {
			getContentPane().removeAll();
			getContentPane().add(up);
			revalidate();
			repaint();
			up.user.setSelected(true);
		}
		else {
			getContentPane().removeAll();
			getContentPane().add(ap);
			revalidate();
			repaint();
			ap.admin.setSelected(true);
		}
	}
	
}
