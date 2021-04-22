import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener; 
//�̺�Ʈ ��Ű�� �߰�
public class JCheckBoxEvent extends JFrame implements ItemListener { 
   
   static String msg="";	//TextField�� �� ����
   JCheckBox cb1 , cb2, cb3;       
   JPanel jp1;                                          
   JTextField jtf ;                                    

   JCheckBoxEvent() {
      super("üũ�ڽ� ��ư �����");		//Frame �̸� ����
      setLayout(new FlowLayout());
      cb1 = new JCheckBox("���ǰ���");	//���ǰ��� CheckBox ����            
      cb2 = new JCheckBox("���");   	//��� CheckBox ����                  
      cb3 = new JCheckBox("����");   //���� CheckBox ����                   
      jtf = new JTextField(15);    	//TextField(���� 15) ����
      jp1 = new JPanel();			//JPanel ����
      
      add(jp1); jp1.add(cb1); jp1.add(cb2);jp1.add(cb3); add(jtf);   //������ ������Ʈ ��
      																 //���ӿ� �߰�
    
      cb1.addItemListener(this);                       
      cb2.addItemListener(this);
      cb3.addItemListener(this);	//���� �޺��ڽ� ItemListener ����
}
 
          
 
  
@Override
public void itemStateChanged(ItemEvent e) {                                
       if(e.getSource()==cb1) {
          if(e.getStateChange()==ItemEvent.SELECTED)	//���ǰ��� �޺��ڽ� üũ��
             msg+=cb1.getText()+" ";					//msg�� "���ǰ���" �߰�
          else if(e.getStateChange()==ItemEvent.DESELECTED)	//���ǰ��� �޺��ڽ� ������
        	  msg = msg.replace(cb1.getText()+ " ","");	//msg�� "���ǰ���"�� ""�� �ٲ�
       }

       if(e.getSource()==cb2) {
          if(e.getStateChange()==ItemEvent.SELECTED)	//��� �޺��ڽ� üũ��
             msg+=cb2.getText()+" ";					//msg�� "���" �߰�
          else if(e.getStateChange()==ItemEvent.DESELECTED)	//��� �޺��ڽ� ������
        	 msg = msg.replace(cb2.getText()+ " ","");	//msg�� "���"�� ""�� �ٲ�
       }
       if(e.getSource()==cb3) {
          if(e.getStateChange()==ItemEvent.SELECTED)	//���� �޺��ڽ� üũ��
             msg+=cb3.getText()+" ";					//msg�� "����" �߰�
          else if(e.getStateChange()==ItemEvent.DESELECTED)	//���� �޺��ڽ� ������
        	  msg = msg.replace(cb3.getText()+" ","");	//msg�� "����"�� ""�� �ٲ�
       }
       jtf.setText(msg);	//msg�� �ؽ�Ʈ�� �ؽ�Ʈ�ʵ忡 ����
   
}
   public static void main(String[] args) {
    JCheckBoxEvent bt= new JCheckBoxEvent();
      bt.setSize(300, 200);                   bt.setVisible(true); 
      bt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      
   }

  
} 