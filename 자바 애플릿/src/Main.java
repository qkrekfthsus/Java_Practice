import javax.swing.*;
import java.awt.*;

public class Main extends Applet{
	public static void main(String[] args) {
		String title;
		public void init() {
			title=getParameter("param1");
			if(title==null)
				title="���޹��� �μ��� ����."
		}
		public void paint(Graphics g) {
			g.drawString(title, 100, 100);
		}
	}

}
