import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//�̺�Ʈ ��Ű�� �߰�
public class ButtonEvent extends JFrame implements ActionListener { 
   
   static String msg="";
   JRadioButton rb1, rb2, rb3,rb4;
   JButton bt;
   ButtonGroup bg;  
   JLabel lb;                        

   ButtonEvent() {
      super("���� ��ư �̺�Ʈ ó��");	//JFrame �̸� ����
      setLayout(new FlowLayout());
      rb1 = new JRadioButton("���̴�",true);	//���̴� RadioButton ����, 
      									  	//���� ���õǵ��� ��
      rb2 = new JRadioButton("�ݶ�");			//�ݶ� RadioButton ����
      rb3 = new JRadioButton("�������꽺");    //�������꽺 RadioButton ����                 
      rb4 = new JRadioButton("����");			//���� RadioButton ����
      bt = new JButton("����");				//���� Button ����
      lb = new JLabel();					//Label ����
      ButtonGroup bg = new ButtonGroup();	//ButtonGroup ����
      

      bg.add(rb1); bg.add(rb2); bg.add(rb3); bg.add(rb4);
      add(rb1); add(rb2); add(rb3);	add(rb4);
      add(bt);
      add(lb);
							//������ ������Ʈ���� Frame�� �߰�
      
      bt.addActionListener(this);			//Button ActionListener ����
      
}
 

   public static void main(String[] args) {
    ButtonEvent bt= new ButtonEvent();
      bt.setSize(400, 300);                   bt.setVisible(true); 
      bt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      
   }





@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()== bt) {
		if(rb1.isSelected()==true) {	//��ư�� ������ ��, "���̴�"
										//������ư�� ���õ� ��
			msg="���õ� ����� : "+ rb1.getText()+" ";
		}
		else if(rb1.isSelected()==false)//������ �ȵǾ��� ��
            msg = msg.replace(rb1.getText()+ " ","");
		if(rb2.isSelected()==true) {	//��ư�� ������ ��, "�ݶ�"
										//������ư�� ���õ� ��
			msg="���õ� ����� : "+ rb2.getText()+" ";
		}
		else if(rb2.isSelected()==false)//������ �ȵǾ��� ��
            msg = msg.replace(rb2.getText()+ " ","");
		if(rb3.isSelected()==true) {	//��ư�� ������ ��, "�������꽺"
										//������ư�� ���õ� ��
			msg="���õ� ����� : "+ rb3.getText()+" ";
		}
		else if(rb3.isSelected()==false)//������ �ȵǾ��� ��
            msg = msg.replace(rb3.getText()+ " ","");
		if(rb4.isSelected()==true) {	//��ư�� ������ ��, "����"
										//������ư�� ���õ� ��
			msg="���õ� ����� : "+ rb4.getText()+" ";
		}
		
		else if(rb4.isSelected()==false)//������ �ȵǾ��� ��
            msg = msg.replace(rb4.getText()+ " ","");
		lb.setText(msg);
	}
}
} 