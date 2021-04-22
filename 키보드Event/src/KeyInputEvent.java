import java.awt.*; 
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class KeyInputEvent extends JFrame implements KeyListener { 
   String msg;
   JLabel sbar;
   JPanel jp;

   public KeyInputEvent() {
      super("키보드에서의 InputEvent");
      sbar = new JLabel();
      add(sbar); 
      addKeyListener(this);
      setSize(300, 200);
      setVisible(true);
   }
   //키를 눌렀을 때 실행

   public void keyPressed(KeyEvent e) { 
      msg = "KeyPressed : " + e.getKeyText(e.getKeyCode());
      if(e.isShiftDown()) {msg +="<Shift>";} 
      if(e.isControlDown()) {msg +="<Ctrl>";} 
      if(e.isAltDown()) {msg +="<Alt>";} 
      sbar.setText(msg); 
   } 
   //키를 놓았을 때 실행
   public void keyReleased(KeyEvent e) {
      msg = "KeyReleased : " + e.getKeyText(e.getKeyCode());
      if(e.isShiftDown()) {msg +="<Shift>";}
      if(e.isControlDown()) {msg +="<Ctrl>";}
      if(e.isAltDown()) {msg +="<Alt>";}
      sbar.setText(msg); 
   }

   //키를 눌렀다가 놓았을 때 실행
   public void keyTyped(KeyEvent e) {
   }
   public static void main(String[] args) {
      KeyInputEvent kie= new KeyInputEvent();
      kie.setDefaultCloseOperation(EXIT_ON_CLOSE); 
   } 
} 
    
