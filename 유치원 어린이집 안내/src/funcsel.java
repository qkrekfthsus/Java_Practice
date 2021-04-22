import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
public class funcsel extends JFrame implements ActionListener {
        JButton jbtn1, jbtn2, jbtn3, jbtn4; 
        boolean adck;
        funcsel(boolean admincheck) { 
           super("기능 선택");
           this.adck = admincheck;
           getContentPane().setLayout(null);
           jbtn1 = new JButton("유치원");    
           jbtn1.setBounds(53, 10, 174, 23);getContentPane().add(jbtn1); 
           jbtn2 = new JButton("어린이집");      
           jbtn2.setBounds(53, 43, 174, 23);getContentPane().add(jbtn2); 
           jbtn3 = new JButton("나이별육아정보");  
           jbtn3.setBounds(53, 76, 174, 23);getContentPane().add(jbtn3); 
           jbtn4 = new JButton("문의");     
           jbtn4.setBounds(53, 108, 174, 23);getContentPane().add(jbtn4);
           
           jbtn1.addActionListener(this);
           jbtn2.addActionListener(this); 
           jbtn3.addActionListener(this); 
           jbtn4.addActionListener(this);
           
           setSize(300, 200);
           setVisible(true);}
           public void actionPerformed(ActionEvent e){
              if(e.getSource()==jbtn2) {
            	  if(adck==true) {
            		  DaycareFrame df = new DaycareFrame();
            		  df.setPreferredSize(new Dimension(1100, 400));
            		  df.setLocation(300, 300);
            		  df.pack();
            		  df.setVisible(true);
            		  df.initTableWithDB();
            		  
            	  }
            	  else {
            		  DaycareFrameParents df = new DaycareFrameParents();
            		  df.setPreferredSize(new Dimension(1100, 400));
            		  df.setLocation(300, 300);
            		  df.pack();
            		  df.setVisible(true);
            		  df.initTableWithDB();
            	  }
              }
              if(e.getSource()==jbtn1) {
            	  if(adck==true) {
            		  KindergartenFrame cf = new KindergartenFrame();
            		  cf.setPreferredSize(new Dimension(1100, 400));
            		  cf.setLocation(300, 300);
            		  cf.pack();
            		  cf.setVisible(true);
            		  cf.initTableWithDB();
            	  }
            	  else {
            		  KindergartenFrameParents cf = new KindergartenFrameParents();
            		  cf.setPreferredSize(new Dimension(1100, 400));
            		  cf.setLocation(300, 300);
            		  cf.pack();
            		  cf.setVisible(true);
            		  cf.initTableWithDB();
            	  }
              }
        	   
               if(e.getSource()== jbtn3) {
                  JOptionPane.showMessageDialog(this, "육아종합지원센터 http://central.childcare.go.kr/ccef/main.jsp");
                                                       
               } 
               if(e.getSource()== jbtn4) {
                  JOptionPane.showMessageDialog(this, "tel)031-467-8341");
               }       } 
         }