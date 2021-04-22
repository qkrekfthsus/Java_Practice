import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
public class MouseInputEvent extends JFrame implements MouseListener { 
   String msg;
   JLabel sbar;
   //컴포넌트의 생성과 배치 
   public MouseInputEvent() {
      super("마우스에서의 InputEvent");
      sbar = new JLabel();
      add(sbar,BorderLayout.SOUTH);
      addMouseListener(this);
      setSize(300, 200); 
      setVisible(true);
   }
   //마우스 버튼을 클릭했을 때 실행 
   public void mouseClicked(MouseEvent e) {        }
   //프레임안으로 마우스커서가 들어갈 때 발생 
   public void mouseEntered(MouseEvent e) {       }
   //프레임안의 마우스커서가 프레임 밖으로 나갈 때 발생 
   public void mouseExited(MouseEvent e) {         } 
   //마우스 버튼을 눌렀을 때 실행 
   public void mousePressed(MouseEvent e) {
      if((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0)
      {
         msg="마우스 오른쪽 버튼을 눌렀습니다.";
      } else
        {
         msg="마우스 왼쪽 버튼을 눌렀습니다.";
        }
      sbar.setText(msg);
   }
   //마우스 버튼을 놓았을 때 실행 
   public void mouseReleased(MouseEvent e) {
       msg="마우스 버튼을 누르세요.";
       sbar.setText(msg);
   }
   public static void main(String[] args) {
       MouseInputEvent mie= new MouseInputEvent();
       mie.setDefaultCloseOperation(EXIT_ON_CLOSE); 
   }
} 
