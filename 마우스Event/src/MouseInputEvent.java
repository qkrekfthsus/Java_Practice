import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
public class MouseInputEvent extends JFrame implements MouseListener { 
   String msg;
   JLabel sbar;
   //������Ʈ�� ������ ��ġ 
   public MouseInputEvent() {
      super("���콺������ InputEvent");
      sbar = new JLabel();
      add(sbar,BorderLayout.SOUTH);
      addMouseListener(this);
      setSize(300, 200); 
      setVisible(true);
   }
   //���콺 ��ư�� Ŭ������ �� ���� 
   public void mouseClicked(MouseEvent e) {        }
   //�����Ӿ����� ���콺Ŀ���� �� �� �߻� 
   public void mouseEntered(MouseEvent e) {       }
   //�����Ӿ��� ���콺Ŀ���� ������ ������ ���� �� �߻� 
   public void mouseExited(MouseEvent e) {         } 
   //���콺 ��ư�� ������ �� ���� 
   public void mousePressed(MouseEvent e) {
      if((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0)
      {
         msg="���콺 ������ ��ư�� �������ϴ�.";
      } else
        {
         msg="���콺 ���� ��ư�� �������ϴ�.";
        }
      sbar.setText(msg);
   }
   //���콺 ��ư�� ������ �� ���� 
   public void mouseReleased(MouseEvent e) {
       msg="���콺 ��ư�� ��������.";
       sbar.setText(msg);
   }
   public static void main(String[] args) {
       MouseInputEvent mie= new MouseInputEvent();
       mie.setDefaultCloseOperation(EXIT_ON_CLOSE); 
   }
} 
