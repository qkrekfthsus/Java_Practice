import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
public class KeyEventAdapter extends JFrame{ 
   String msg;
   JLabel sbar;
   public KeyEventAdapter() {
      super("Ű���忡���� InputEvent");
      sbar = new JLabel();
      add(sbar); 
      addKeyListener(new keyHandler());
      setSize(300, 200);
      setVisible(true);
   }
   //����͸� ��ӹ��� ���� Ŭ������ ����
   class keyHandler extends KeyAdapter { 
      //Ű�� ������ �� ����
      public void keyPressed(KeyEvent e) {
         msg = "KeyPressed : " + e.getKeyText(e.getKeyCode());
         if(e.isShiftDown()) {msg ="KeyPressed : <Shift> + "+ msg;}
         if(e.isControlDown()) {msg ="KeyPressed : <Ctrl> + "+ msg;}
         if(e.isAltDown()) {msg ="KeyPressed : <Alt> + "+ msg;}
         sbar.setText(msg); 
      }   
   //Ű�� ������ �� ����
   public void keyReleased(KeyEvent e) {
      msg = "KeyReleased : " + e.getKeyText(e.getKeyCode());
      if(e.isShiftDown()) {msg =e.getKeyText(e.getKeyCode());}
      if(e.isControlDown()) {msg =e.getKeyText(e.getKeyCode());}
      if(e.isAltDown()) {msg =e.getKeyText(e.getKeyCode());}
      sbar.setText(msg); 
   }
}
public static void main(String[] args) {
   KeyEventAdapter kea= new KeyEventAdapter();
   kea.setDefaultCloseOperation(EXIT_ON_CLOSE); 
} 
}     
 

