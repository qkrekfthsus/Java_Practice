import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement; 


public class Login extends JFrame implements ActionListener {
	JLabel idlb, pwlb;
	JTextField id;
	JPasswordField pw;
	JButton login, cancel, register; 
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
Login() { 
	super("로그인");
	setLayout(new FlowLayout()); 

	idlb = new JLabel("  아이디 : ")	; add(idlb);
	id = new JTextField(15); add(id);
	pwlb = new JLabel("비밀번호 : "); add(pwlb);
	pw = new JPasswordField(15); add(pw);
	
	login = new JButton("로그인");	add(login);
	cancel = new JButton("취소"); add(cancel);
	register = new JButton("회원 가입"); add(register);
	
	login.addActionListener(this); 
	cancel.addActionListener(this);  
	register.addActionListener(this);
	setSize(250, 150); 
	setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()== login) { 
			 try {
					Class.forName ("com.mysql.cj.jdbc.Driver");
					DBConnManager dbc = new DBConnManager();
					Connection conn = dbc.getConnection();
					Statement st = conn.createStatement ();
					ResultSet rs = st.executeQuery ( "select id, pw from director");
					String pass = new String(pw.getPassword());
					boolean logincheck = false;
		          	while (rs.next ()) {
		          		String dinfo = rs.getString (1) + "\n" + rs.getString(2);
		          		if(dinfo.equals(id.getText() + "\n" + pass)) {
		          			JOptionPane.showMessageDialog(this, "관리자 로그인에 성공하였습니다.");
		          			logincheck = true;
		          			dispose();
		          			funcsel fs = new funcsel(true);
		          			fs.setDefaultCloseOperation(EXIT_ON_CLOSE);
		          		
		          		}		          		
		          	}
		          	rs = st.executeQuery ( "select id, pw from parents");
		          	while(rs.next()) {
	          			String pinfo = rs.getString (1) + "\n" + rs.getString(2);
	          			if(pinfo.equals(id.getText() + "\n" + pass)) {
	          				JOptionPane.showMessageDialog(this, "사용자 로그인에 성공하였습니다.");
		          			logincheck = true;
		          			dispose();
		          			funcsel fs = new funcsel(false);
		          			fs.setDefaultCloseOperation(EXIT_ON_CLOSE);
	          			}
	          		}
		          	if(logincheck == false) {
		          		JOptionPane.showMessageDialog(this, "로그인에 실패하였습니다.");
		          	}
				}catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		if(e.getSource()== cancel) {
			dispose();
		}
		if(e.getSource()==register) {
			register rg = new register();
			rg.setTitle("회원가입");
			rg.up = new userpanel(rg);
			rg.ap = new adminpanel(rg);
			
			rg.add(rg.ap);
			rg.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			rg.setSize(250, 200); 
			rg.setVisible(true);
		}

	}

	public static void main(String[] args) { 
		Login aet = new Login(); 
		aet.setDefaultCloseOperation(aet.EXIT_ON_CLOSE);
	}
}

