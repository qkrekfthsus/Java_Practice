package java_pro;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.table.TableRowSorter;

class dayTable extends JPanel { 
   public dayTable() { 
      String[] title={"날짜","순이익","총 판매금액","총  구매금액", "총 세금","전일비교"}; 
      String[][] data={{"","","","","",""}};
      JTable table = new JTable(data, title); 
      table.setAutoCreateRowSorter(true);
      TableRowSorter tablesorter = new TableRowSorter(table.getModel());
      table.setRowSorter(tablesorter);
      
      int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS; 
      int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; 
      JScrollPane js = new JScrollPane(table, v, h);
      js.setPreferredSize(new Dimension(1150,500));
      add(js);
      
   }
}
