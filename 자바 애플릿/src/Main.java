import javax.swing.*;
import java.awt.*;

public class Main extends Applet{
	public static void main(String[] args) {
		String title;
		public void init() {
			title=getParameter("param1");
			if(title==null)
				title="전달받은 인수가 없음."
		}
		public void paint(Graphics g) {
			g.drawString(title, 100, 100);
		}
	}

}
