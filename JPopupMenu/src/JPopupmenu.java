import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 
public class JPopupmenu extends JFrame { 
		String[] title={"사번","성명","부서"};
		JRadioButtonMenuItem rbm[]; 
		public JPopupmenu() {
		super("팝업메뉴에서 항목 선택"); 
		final JPopupMenu pmenu = new JPopupMenu();
		ButtonGroup tgroup = new ButtonGroup();
		rbm = new JRadioButtonMenuItem[3];
		
		for(int i=0; i<rbm.length; i++) {
			rbm[i] = new JRadioButtonMenuItem(title[i]); 
			pmenu.add(rbm[i]); 
			tgroup.add(rbm[i]); 
			
		} 
		addMouseListener(new MouseAdapter() { 
		public void mousePressed(MouseEvent e) 
			 {checkForTriggerEvent(e);} 
		public void mouseReleased(MouseEvent e) 
			{checkForTriggerEvent(e);} 
		private void checkForTriggerEvent(MouseEvent e) { 
			 //마우스 오른쪽 버튼을 누르거나 해제할 때 발생 
			if(e.isPopupTrigger()) 
				pmenu.show(e.getComponent(), e.getX(), e.getY());
		} 
		}); 
		setSize(300, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
