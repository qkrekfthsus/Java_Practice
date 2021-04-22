import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class adminpanel extends JPanel implements ActionListener, ItemListener{
	JLabel idlb, pwlb, tellb;
	JTextField id, tel;
	JPasswordField pw;
	ButtonGroup bg;
	JRadioButton admin, user;
	JButton register, cancel;
	register rg;
adminpanel(register rg){
	this.rg = rg;
	setLayout(new FlowLayout()); 
	bg = new ButtonGroup();
	admin = new JRadioButton("관리자            ", true);
	user = new JRadioButton("일반 사용자            ");
	bg.add(admin);	bg.add(user);
	add(admin);	add(user);
	
	idlb = new JLabel("  아이디 : ")	; add(idlb);
	id = new JTextField(15); add(id);
	pwlb = new JLabel("비밀번호 : "); add(pwlb);
	pw = new JPasswordField(15); add(pw);
	tellb = new JLabel("전화번호 : "); add(tellb);
	tel = new JTextField(15); add(tel);
	register = new JButton("회원가입");	add(register);
	cancel = new JButton("취소"); add(cancel);
	
	user.addItemListener(this);
	register.addActionListener(this);
	cancel.addActionListener(this);  
	setSize(250, 200); 
	setVisible(true);
}

@Override
public void itemStateChanged(ItemEvent e) {
	// TODO 자동 생성된 메소드 스텁
	if(e.getSource() == user) {
		if(e.getStateChange()==ItemEvent.SELECTED) {
			rg.change("up");
		}
	}
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO 자동 생성된 메소드 스텁
	if(e.getSource()==register) {
	try {
		Class.forName ("com.mysql.cj.jdbc.Driver");
		DBConnManager dbc = new DBConnManager();
		Connection conn = dbc.getConnection();
		PreparedStatement st = conn.prepareStatement("insert director(id, pw, tel) values(?, ?, ?);");
		String pass = new String(pw.getPassword());
		st.setString(1, id.getText());
		st.setString(2, pass);
		st.setString(3, tel.getText());
		st.executeUpdate();
		JOptionPane.showMessageDialog(this, "관리자 회원가입을 축하합니다!");
	} catch (ClassNotFoundException | SQLException e1) {
		// TODO 자동 생성된 catch 블록
		e1.printStackTrace();
	}
	}
	if(e.getSource()==cancel) {
		rg.dispose();
	}
}
}

