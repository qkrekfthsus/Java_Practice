package java_pro;


import javax.swing.*;

import java.awt.*;

public class Frame extends JFrame{ 

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public Frame() { 
      super("수입지출 관리 프로그램");
      
      getContentPane().setLayout(new FlowLayout());

      JTabbedPane jtp = new JTabbedPane(JTabbedPane.TOP);
      jtp.setBounds(0, 47, 1187, 549);
      JPanel jpn1 = new JPanel();	//물품탭팬
      JPanel jpn2 = new JPanel();	//수입탭팬
      JPanel jpn3 = new JPanel();	//지출탭팬
      JPanel jpn4 = new JPanel();	//월별매출 탭팬
      JPanel jpn5 = new JPanel();	//일별매출 탭팬
      Product jt1 = new Product();
      Sales jt2 = new Sales("sell"); 
      Sales jt3 = new Sales("buy");
      Month_sales jt4 = new Month_sales();
      Day_sales jt5 = new Day_sales();
      
      jpn1.add(jt1);    jpn2.add(jt2);      jpn3.add(jt3); 
      jpn4.add(jt4);	jpn5.add(jt5);
   
      jtp.addTab("물품", jpn1);        jtp.addTab("수입", jpn2); 
      jtp.addTab("지출", jpn3);       jtp.addTab("월별매출",jpn4);
      jtp.addTab("일별매출", jpn5);
      getContentPane().add(jtp);
      
     
      setSize(1200, 600); 
      setVisible(true);

   }
   	public static void main(String[] args) {
	          Frame jt= new Frame();
	          jt.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	      }

}
