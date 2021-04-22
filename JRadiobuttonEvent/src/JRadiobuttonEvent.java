import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener; 
//�̺�Ʈ ��Ű�� �߰�
public class JRadiobuttonEvent extends JFrame implements ItemListener { 
   
   static String msg="";		//�ؽ�Ʈ�ʵ忡 �� ����
   JRadioButton rb1 , rb2, rb3;                                 
   ButtonGroup bg;                                       
   JTextField jtf ;                                      

   JRadiobuttonEvent() {
      super("���� ��ư �̺�Ʈ ó��");	//JFrame �̸� ����
      setLayout(new FlowLayout());
      rb1 = new JRadioButton("�ڰ�");	//�ڰ� ������ư ����             
      rb2 = new JRadioButton("����");	//���� ������ư ����                     
      rb3 = new JRadioButton("����");	//���� ������ư ����           
      jtf = new JTextField(15);     //TextField(���� 15) ����        
      ButtonGroup bg = new ButtonGroup();	//ButtoneGroup ����
      
      bg.add(rb1); bg.add(rb2); bg.add(rb3);
      add(rb1); add(rb2); add(rb3);
      add(jtf);   					//������ ������Ʈ JFrame �߰�

      rb1.addItemListener(this);                           
      rb2.addItemListener(this);
      rb3.addItemListener(this);	//������ RadioButton�� ITemListener ����
}
 
          
 
  
@Override
public void itemStateChanged(ItemEvent e) {                                    
       if(e.getSource()==rb1) {	
          if(e.getStateChange()==ItemEvent.SELECTED)	//�ڰ� ������ư ���ý�
             msg+=rb1.getText()+" ";
          else if(e.getStateChange()==ItemEvent.DESELECTED)	//������ư ������
              msg = msg.replace(rb1.getText()+ " ","");
       }

       if(e.getSource()==rb2) {
          if(e.getStateChange()==ItemEvent.SELECTED)	//���� ������ư ���ý�
             msg+=rb2.getText()+" ";
          else if(e.getStateChange()==ItemEvent.DESELECTED)	//������ư ������
        	 msg = msg.replace(rb2.getText()+ " ","");
       }
       if(e.getSource()==rb3) {
          if(e.getStateChange()==ItemEvent.SELECTED)	//���� ������ư ���ý�
             msg+=rb3.getText()+" ";
          else if(e.getStateChange()==ItemEvent.DESELECTED)	//������ư ������
        	  msg = msg.replace(rb3.getText()+" ","");
       }
       jtf.setText(msg);	//msg�� �ؽ�Ʈ�� �ؽ�Ʈ�ʵ忡 ����
   
}
   public static void main(String[] args) {
    JRadiobuttonEvent bt= new JRadiobuttonEvent();
      bt.setSize(300, 200);                   bt.setVisible(true); 
      bt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   }
} 