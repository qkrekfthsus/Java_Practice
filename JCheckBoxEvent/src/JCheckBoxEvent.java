import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener; 
//이벤트 패키지 추가
public class JCheckBoxEvent extends JFrame implements ItemListener { 
   
   static String msg="";	//TextField에 들어갈 내용
   JCheckBox cb1 , cb2, cb3;       
   JPanel jp1;                                          
   JTextField jtf ;                                    

   JCheckBoxEvent() {
      super("체크박스 버튼 만들기");		//Frame 이름 설정
      setLayout(new FlowLayout());
      cb1 = new JCheckBox("음악감상");	//음악감상 CheckBox 생성            
      cb2 = new JCheckBox("등산");   	//등산 CheckBox 생성                  
      cb3 = new JCheckBox("조깅");   //조깅 CheckBox 생성                   
      jtf = new JTextField(15);    	//TextField(길이 15) 생성
      jp1 = new JPanel();			//JPanel 생성
      
      add(jp1); jp1.add(cb1); jp1.add(cb2);jp1.add(cb3); add(jtf);   //각각의 컴포넌트 프
      																 //레임에 추가
    
      cb1.addItemListener(this);                       
      cb2.addItemListener(this);
      cb3.addItemListener(this);	//각각 콤보박스 ItemListener 설정
}
 
          
 
  
@Override
public void itemStateChanged(ItemEvent e) {                                
       if(e.getSource()==cb1) {
          if(e.getStateChange()==ItemEvent.SELECTED)	//음악감상 콤보박스 체크시
             msg+=cb1.getText()+" ";					//msg에 "음악감상" 추가
          else if(e.getStateChange()==ItemEvent.DESELECTED)	//음악감상 콤보박스 해제시
        	  msg = msg.replace(cb1.getText()+ " ","");	//msg의 "음악감상"을 ""로 바꿈
       }

       if(e.getSource()==cb2) {
          if(e.getStateChange()==ItemEvent.SELECTED)	//등산 콤보박스 체크시
             msg+=cb2.getText()+" ";					//msg에 "등산" 추가
          else if(e.getStateChange()==ItemEvent.DESELECTED)	//등산 콤보박스 해제시
        	 msg = msg.replace(cb2.getText()+ " ","");	//msg의 "등산"을 ""로 바꿈
       }
       if(e.getSource()==cb3) {
          if(e.getStateChange()==ItemEvent.SELECTED)	//조깅 콤보박스 체크시
             msg+=cb3.getText()+" ";					//msg에 "조깅" 추가
          else if(e.getStateChange()==ItemEvent.DESELECTED)	//조깅 콤보박스 해제시
        	  msg = msg.replace(cb3.getText()+" ","");	//msg의 "조깅"을 ""로 바꿈
       }
       jtf.setText(msg);	//msg의 텍스트를 텍스트필드에 설정
   
}
   public static void main(String[] args) {
    JCheckBoxEvent bt= new JCheckBoxEvent();
      bt.setSize(300, 200);                   bt.setVisible(true); 
      bt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      
   }

  
} 