package java_pro;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JComboBox;
import java.awt.*; 
public class Frame extends JFrame implements ActionListener { 
	JButton j1,j2,j3,j4;	//�̺�Ʈ ��ư
    JPanel bu1;				//�̺�Ʈ ��ư �г�
    Combobox cb1;
   public Frame() { 
      super("�������� ���� ���α׷�");
      getContentPane().setLayout(null);
      /////////////////////////////////////////////////////////////////////
      cb1 = new Combobox();
      cb1.setBounds(69, 51, 69, 23);
      getContentPane().add(cb1);
      /////////////////////////////////////////////////////////////////////
      /////////////////////////////////////////////////////////////////////event ��ư start
      
      bu1 = new JPanel(new FlowLayout());
      bu1.setBounds(12, 10, 345, 33);
      j1 = new JButton("��ǰ�߰�");
      j2 = new JButton("��ǰ����");
      j3 = new JButton("�ܾ�Ȯ��");
      j4 = new JButton("���߿��߰�");
      j1.addActionListener(this);
      j2.addActionListener(this);
      j3.addActionListener(this);     
      j4.addActionListener(this);
      bu1.add(j4);
      
      bu1.add(j1); bu1.add(j2); bu1.add(j3);
      getContentPane().add(bu1);
      //////////////////////////////////////////////////////////////////////event ��ư end

      JMenuBar jmb = new JMenuBar();
      JMenu jmu1 = new JMenu("����");
      JMenu jmu2 = new JMenu("����"); 
      JMenu jmu3 = new JMenu("����"); 
      JMenuItem jmi1 = new JMenuItem("���θ����");
      JMenuItem jmi2 = new JMenuItem("����"); 
      JMenuItem jmi3 = new JMenuItem("����");
      jmu1.add(jmi1);   jmu1.add(jmi2);    jmu1.add(jmi3);
      JMenuItem jmi4 = new JMenuItem("�߶󳻱�");
      JMenuItem jmi5 = new JMenuItem("����");
      JMenuItem jmi6 = new JMenuItem("�ٿ��ֱ�");
      jmu2.add(jmi4);    jmu2.add(jmi5);    jmu2.add(jmi6);
      JMenuItem jmi7 = new JMenuItem("��������");
      JMenuItem jmi8 = new JMenuItem("����ǥ����");
      jmu3.add(jmi7);     jmu3.add(jmi8);     
      jmb.add(jmu1);    jmb.add(jmu2);      jmb.add(jmu3);
      setJMenuBar(jmb);
      /////////////////////////////////////////////////////���̺� start
      JTabbedPane jtp = new JTabbedPane(JTabbedPane.TOP);
      jtp.setBounds(12, 181, 1162, 549);
      JPanel jpn2 = new JPanel(); 
      JPanel jpn3 = new JPanel();
      JPanel jpn4 = new JPanel();
      JPanel jpn5 = new JPanel();
      IncomeSpending jt2 = new IncomeSpending(); 
      IncomeSpending jt3 = new IncomeSpending();
      MonthTable jt4 = new MonthTable();
      dayTable jt5 = new dayTable();jpn2.add(jt2);      jpn3.add(jt3); 
      jpn4.add(jt4);	jpn5.add(jt5);JPanel jpn1 = new JPanel();
Product jt1 = new Product();

jpn1.add(jt1);     

   jtp.addTab("��ǰ", jpn1);        
jtp.addTab("����", jpn2); 
      jtp.addTab("����", jpn3);       jtp.addTab("��������",jpn4);
      jtp.addTab("�Ϻ�����", jpn5);
      /////////////////////////////////////////////////////���̺� end
      getContentPane().add(jtp);
      
      JLabel lblDfsfa = new JLabel("��ǰ�� : ");
      lblDfsfa.setBounds(22, 55, 69, 19);
      getContentPane().add(lblDfsfa);
      setSize(1200, 800); 
      setVisible(true);
   }
   	public static void main(String[] args) {
	          Frame jt= new Frame();
	          jt.setDefaultCloseOperation(jt.EXIT_ON_CLOSE);
	      }
	 
	 @Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == j1) {
			//j1 �̺�Ʈ
		}
		if(e.getSource() == j2) {
			//j2 �̺�Ʈ
		}
		if(e.getSource() == j3) {
	         Semiwindow sw = new Semiwindow();  
	   }
		if(e.getSource() == j4) {
			Semiwindow sw = new Semiwindow(); 
		}
	}
}
