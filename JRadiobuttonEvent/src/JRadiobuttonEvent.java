import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener; 
//이벤트 패키지 추가
public class JRadiobuttonEvent extends JFrame implements ItemListener { 
   
   static String msg="";		//텍스트필드에 들어갈 내용
   JRadioButton rb1 , rb2, rb3;                                 
   ButtonGroup bg;                                       
   JTextField jtf ;                                      

   JRadiobuttonEvent() {
      super("라디오 버튼 이벤트 처리");	//JFrame 이름 설정
      setLayout(new FlowLayout());
      rb1 = new JRadioButton("자가");	//자가 라디오버튼 생성             
      rb2 = new JRadioButton("전세");	//전세 라디오버튼 생성                     
      rb3 = new JRadioButton("월세");	//월세 라디오버튼 생성           
      jtf = new JTextField(15);     //TextField(길이 15) 생성        
      ButtonGroup bg = new ButtonGroup();	//ButtoneGroup 생성
      
      bg.add(rb1); bg.add(rb2); bg.add(rb3);
      add(rb1); add(rb2); add(rb3);
      add(jtf);   					//각각의 컴포넌트 JFrame 추가

      rb1.addItemListener(this);                           
      rb2.addItemListener(this);
      rb3.addItemListener(this);	//각각의 RadioButton을 ITemListener 설정
}
 
          
 
  
@Override
public void itemStateChanged(ItemEvent e) {                                    
       if(e.getSource()==rb1) {	
          if(e.getStateChange()==ItemEvent.SELECTED)	//자가 라디오버튼 선택시
             msg+=rb1.getText()+" ";
          else if(e.getStateChange()==ItemEvent.DESELECTED)	//라디오버튼 해제시
              msg = msg.replace(rb1.getText()+ " ","");
       }

       if(e.getSource()==rb2) {
          if(e.getStateChange()==ItemEvent.SELECTED)	//전세 라디오버튼 선택시
             msg+=rb2.getText()+" ";
          else if(e.getStateChange()==ItemEvent.DESELECTED)	//라디오버튼 해제시
        	 msg = msg.replace(rb2.getText()+ " ","");
       }
       if(e.getSource()==rb3) {
          if(e.getStateChange()==ItemEvent.SELECTED)	//월세 라디오버튼 선택시
             msg+=rb3.getText()+" ";
          else if(e.getStateChange()==ItemEvent.DESELECTED)	//라디오버튼 해제시
        	  msg = msg.replace(rb3.getText()+" ","");
       }
       jtf.setText(msg);	//msg의 텍스트를 텍스트필드에 설정
   
}
   public static void main(String[] args) {
    JRadiobuttonEvent bt= new JRadiobuttonEvent();
      bt.setSize(300, 200);                   bt.setVisible(true); 
      bt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   }
} 