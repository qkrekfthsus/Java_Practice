package java_pro;
import java.awt.event.*;
import javax.swing.*;
class Semiwindow extends JFrame implements ActionListener{
	public Semiwindow() {
		super("추가");
		setVisible(true);
		setLocation(300,50);
		setSize(400,300);
		JCheckBox ckb1 = new JCheckBox("스케쥴",true);
		JCheckBox ckb2 = new JCheckBox("계산기",true);
		JCheckBox ckb3 = new JCheckBox("마이웹",true);
		JPanel ckpanel = new JPanel();
		ckpanel.add(ckb1);
		ckpanel.add(ckb2);
		ckpanel.add(ckb3);
		add(ckpanel, "North");                  }
	public void actionPerformed(ActionEvent e) {       }
}

