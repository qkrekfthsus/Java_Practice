import javax.swing.*;
import java.awt.*; 
public class JScroll extends JFrame { 
   JPanel jp; 
   JScroll() {
      setLayout(new BorderLayout()); 
      jp = new JPanel();
      jp.setLayout(new GridLayout(10,5));
      int cnt = 1;
      for (int i=1; i<=10; i++) {
         for(int j=1; j<=5 ; j++) {
	jp.add(new JButton("버튼"+cnt));
	cnt++;
         }
      }
      //수직, 수평 스크롤바를 설정하기 위항 상수를 얻음
      int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS; 
      int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; 
      JScrollPane js = new JScrollPane(jp, v, h); 
      add(js, BorderLayout.CENTER);
      setSize(300, 300);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}  
