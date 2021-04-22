import java.awt.*; 
import javax.swing.*; 
public class GridLayoutTest extends JFrame { 
	String[] title = {"Num","/","*","-","7","8","9","+","4","5","6",
                                "=","1","2","3","Enter","0",".",",","?"}; 
	public GridLayoutTest() { 
		super("그리드 레이아웃"); 
		//그리드 레이아웃 매니저 생성 
		GridLayout glayout = new GridLayout(4, 5); 
		setLayout(glayout); 
		//각 컴포넌트를  컨테이너에 추가 
		JButton btn[]=new JButton[20]; 
		for(int i=0; i<20; i++) { 
			btn[i] = new JButton(title[i]); 
			add(btn[i]); 
			} 
		setSize(400, 200);  setVisible(true);
		}
}