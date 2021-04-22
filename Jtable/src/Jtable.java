import javax.swing.*;
import java.awt.*; 
public class Jtable extends JFrame { 
   Jtable() {
      setLayout(new BorderLayout()); 
      String[] title={"사번","성명","부서"};
      String[][] data={{"1","이명박","총무과"},
                                    {"2","이승엽","인사과"},
                                    {"3","박태환","전산과"}};
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
