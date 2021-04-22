import javax.swing.*;
import java.awt.*; 
public class JTabbedPaneFrame extends JFrame { 
	public JTabbedPaneFrame() { 
		super("사원 개인정보 조회(JTabbedPane)"); 
		JTabbedPane jtp = new JTabbedPane(JTabbedPane.TOP);
		JPanel jpn1 = new JPanel();
		JPanel jpn2 = new JPanel(); 
		JPanel jpn3 = new JPanel(); 
		bTable jt1 = new bTable();
		eTable jt2 = new eTable(); 
		fTable jt3 = new fTable(); 
		jpn1.add(jt1);     jpn2.add(jt2);      jpn3.add(jt3); 
	
		jtp.addTab("기본내용", jpn1);        jtp.addTab("추가내용", jpn2); 
		jtp.addTab("보안내용", jpn3); 
		add(jtp, BorderLayout.CENTER);
		setSize(500, 200); 
		setVisible(true);
	}
}
