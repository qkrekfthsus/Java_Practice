import javax.swing.*;
import java.awt.*; 
public class Jtable extends JFrame { 
   Jtable() {
      setLayout(new BorderLayout()); 
      String[] title={"���","����","�μ�"};
      String[][] data={{"1","�̸��","�ѹ���"},
                                    {"2","�̽¿�","�λ��"},
                                    {"3","����ȯ","�����"}};
      JTable table = new JTable(data, title);
      int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
      int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
      JScrollPane js = new JScrollPane(table, v, h);
      add(js, BorderLayout.CENTER);
      setSize(300, 300);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   } 
}  
