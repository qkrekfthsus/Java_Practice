import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 
public class JPopupmenu extends JFrame { 
		String[] title={"���","����","�μ�"};
		JRadioButtonMenuItem rbm[]; 
		public JPopupmenu() {
		super("�˾��޴����� �׸� ����"); 
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
			 //���콺 ������ ��ư�� �����ų� ������ �� �߻� 
			if(e.isPopupTrigger()) 
				pmenu.show(e.getComponent(), e.getX(), e.getY());
		} 
		}); 
		setSize(300, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
