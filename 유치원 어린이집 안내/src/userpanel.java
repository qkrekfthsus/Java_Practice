import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class userpanel extends JPanel implements ActionListener, ItemListener{
	JLabel idlb, pwlb, agelb, addresslb;
	JTextField id, age, address;
	JPasswordField pw;
	ButtonGroup bg;
	JRadioButton admin, user;
	JButton register, cancel;
	register rg;
userpanel(register rg){
	this.rg = rg;
	setLayout(new FlowLayout()); 
	bg = new ButtonGroup();
	admin = new JRadioButton("관리자            ");
	user = new JRadioButton("일반 사용자            ", true);
	bg.add(admin);	bg.add(user);
	add(admin);	add(user);
	
	idlb = new JLabel("  아이디 : ")	; add(idlb);
	id = new JTextField(15); add(id);
	pwlb = new JLabel("비밀번호 : "); add(pwlb);
	pw = new JPasswordField(15); add(pw);
	agelb = new JLabel("자녀나이 : "); add(agelb);
	age = new JTextField(15); add(age);
	addresslb = new JLabel("사는 곳(시) : "); add(addresslb);
	address = new JTextField(14); add(address);
	register = new JButton("회원가입");	add(register);
	cancel = new JButton("취소"); add(cancel);
	
	admin.addItemListener(this);
	register.addActionListener(this);
	cancel.addActionListener(this);  
	setSize(250, 250); 
	setVisible(true);
}

@Override
public void itemStateChanged(ItemEvent e) {
	// TODO 자동 생성된 메소드 스텁
	if(e.getSource() == admin) {
		if(e.getStateChange()==ItemEvent.SELECTED) {
			rg.change("ap");
		}
	}
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO 자동 생성된 메소드 스텁
	if(e.getSource() == register) {
	try {
		Class.forName ("com.mysql.cj.jdbc.Driver");
		DBConnManager dbc = new DBConnManager();
		Connection conn = dbc.getConnection();
		PreparedStatement st = conn.prepareStatement("insert parents(id, pw, age, city) values(?, ?, ?, ?);");
		String pass = new String(pw.getPassword());
		st.setString(1, id.getText());
		st.setString(2, pass);
		st.setString(3, age.getText());
		st.setString(4, address.getText());	
		st.executeUpdate();
		JOptionPane.showMessageDialog(this, "일반사용자 회원가입을 축하합니다!");
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
