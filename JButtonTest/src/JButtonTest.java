import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
public class JButtonTest extends JFrame implements ActionListener{ 
   JButton jbtn1, jbtn2, jbtn3;
   JLabel lb1;
   JButtonTest() {
      super("버튼(JButton) 추가");		//JFrame 이름 설정
      getContentPane().setLayout(new FlowLayout());
      
      
      jbtn1 = new JButton("입력"); 	
      add(jbtn1);					//입력버튼 생성 및 추가
      jbtn2 = new JButton("추가"); 
      add(jbtn2);					//추가버튼 생성 및 추가
      jbtn3 = new JButton("삭제");
      add(jbtn3);					//삭제버튼 생성 및 추가
      lb1 = new JLabel("");
      add(lb1);						//Label 생성 및 추가
      
      jbtn1.addActionListener(this);
      jbtn2.addActionListener(this);
      jbtn3.addActionListener(this);		//버튼별 ActionListener 추가
      
      setSize(300, 200);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   } 
   public static void main(String[] args) {
	      new JButtonTest();
	   }
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource() == jbtn1) {
		//jbtn1 이벤트
		lb1.setText("입력");					//Label에 텍스트 설정
	}
	if(e.getSource() == jbtn2) {
		//jbtn2 이벤트'
		lb1.setText("추가");					//Label에 텍스트 설정
	}
	if(e.getSource() == jbtn3) {
		//jbtn3 이벤트							//Label에 텍스트 설정
		lb1.setText("삭제");
   }
	
} 
}
