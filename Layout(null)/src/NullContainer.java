import javax.swing.*;
import java.awt.*; 
public class NullContainer extends JFrame { 
   JButton jbtn1, jbtn2, jbtn3;
   NullContainer() {
       super("Null Container의 버튼 배치");	
       setLayout(null);    //레이아웃 매니저 삭제
       jbtn1 = new JButton("입력");
       jbtn1.setBounds(20, 50, 100, 30); //버튼의 위치와 크기 설정
       jbtn2 = new JButton("추가");	
       jbtn2.setBounds(20, 100, 100, 30);
       jbtn3 = new JButton("삭제");
       jbtn3.setBounds(20, 150, 100, 30);
       add(jbtn1); 
       add(jbtn2);
       add(jbtn3);
       setSize(300, 300);  
       setVisible(true);  
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //⑤
   }
}
