import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//이벤트 패키지 추가
public class ButtonEvent extends JFrame implements ActionListener { 
   
   static String msg="";
   JRadioButton rb1, rb2, rb3,rb4;
   JButton bt;
   ButtonGroup bg;  
   JLabel lb;                        

   ButtonEvent() {
      super("라디오 버튼 이벤트 처리");	//JFrame 이름 설정
      setLayout(new FlowLayout());
      rb1 = new JRadioButton("사이다",true);	//사이다 RadioButton 생성, 
      									  	//먼저 선택되도록 함
      rb2 = new JRadioButton("콜라");			//콜라 RadioButton 생성
      rb3 = new JRadioButton("오렌지쥬스");    //오렌지쥬스 RadioButton 생성                 
      rb4 = new JRadioButton("녹차");			//녹차 RadioButton 생성
      bt = new JButton("실행");				//실행 Button 생성
      lb = new JLabel();					//Label 생성
      ButtonGroup bg = new ButtonGroup();	//ButtonGroup 생성
      

      bg.add(rb1); bg.add(rb2); bg.add(rb3); bg.add(rb4);
      add(rb1); add(rb2); add(rb3);	add(rb4);
      add(bt);
      add(lb);
							//각각의 컴포넌트들을 Frame에 추가
      
      bt.addActionListener(this);			//Button ActionListener 설정
      
}
 

   public static void main(String[] args) {
    ButtonEvent bt= new ButtonEvent();
      bt.setSize(400, 300);                   bt.setVisible(true); 
      bt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      
   }





@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()== bt) {
		if(rb1.isSelected()==true) {	//버튼을 눌렀을 때, "사이다"
										//라디오버튼이 선택될 시
			msg="선택된 음료수 : "+ rb1.getText()+" ";
		}
		else if(rb1.isSelected()==false)//선택이 안되었을 시
            msg = msg.replace(rb1.getText()+ " ","");
		if(rb2.isSelected()==true) {	//버튼을 눌렀을 때, "콜라"
										//라디오버튼이 선택될 시
			msg="선택된 음료수 : "+ rb2.getText()+" ";
		}
		else if(rb2.isSelected()==false)//선택이 안되었을 시
            msg = msg.replace(rb2.getText()+ " ","");
		if(rb3.isSelected()==true) {	//버튼을 눌렀을 때, "오렌지쥬스"
										//라디오버튼이 선택될 시
			msg="선택된 음료수 : "+ rb3.getText()+" ";
		}
		else if(rb3.isSelected()==false)//선택이 안되었을 시
            msg = msg.replace(rb3.getText()+ " ","");
		if(rb4.isSelected()==true) {	//버튼을 눌렀을 때, "녹차"
										//라디오버튼이 선택될 시
			msg="선택된 음료수 : "+ rb4.getText()+" ";
		}
		
		else if(rb4.isSelected()==false)//선택이 안되었을 시
            msg = msg.replace(rb4.getText()+ " ","");
		lb.setText(msg);
	}
}
} 