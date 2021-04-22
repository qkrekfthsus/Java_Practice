import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
public class JButtonTest extends JFrame implements ActionListener{ 
   JButton jbtn1, jbtn2, jbtn3;
   JLabel lb1;
   JButtonTest() {
      super("��ư(JButton) �߰�");		//JFrame �̸� ����
      getContentPane().setLayout(new FlowLayout());
      
      
      jbtn1 = new JButton("�Է�"); 	
      add(jbtn1);					//�Է¹�ư ���� �� �߰�
      jbtn2 = new JButton("�߰�"); 
      add(jbtn2);					//�߰���ư ���� �� �߰�
      jbtn3 = new JButton("����");
      add(jbtn3);					//������ư ���� �� �߰�
      lb1 = new JLabel("");
      add(lb1);						//Label ���� �� �߰�
      
      jbtn1.addActionListener(this);
      jbtn2.addActionListener(this);
      jbtn3.addActionListener(this);		//��ư�� ActionListener �߰�
      
      setSize(300, 200);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   } 
   public static void main(String[] args) {
	      new JButtonTest();
	   }
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource() == jbtn1) {
		//jbtn1 �̺�Ʈ
		lb1.setText("�Է�");					//Label�� �ؽ�Ʈ ����
	}
	if(e.getSource() == jbtn2) {
		//jbtn2 �̺�Ʈ'
		lb1.setText("�߰�");					//Label�� �ؽ�Ʈ ����
	}
	if(e.getSource() == jbtn3) {
		//jbtn3 �̺�Ʈ							//Label�� �ؽ�Ʈ ����
		lb1.setText("����");
   }
	
} 
}
