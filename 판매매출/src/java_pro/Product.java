package java_pro;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.table.TableRowSorter;

class Product extends JPanel{ 
   public Product() { 
   String[] title={"이름","제조사","단가","유통기한","재고","비고"}; 
   String[][] data={{"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""},
		   {"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""}
		   ,{"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""}
		   ,{"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""}
		   ,{"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""}
		   ,{"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""}};
   JTable table = new JTable(data, title); 
   table.setAutoCreateRowSorter(true);
   TableRowSorter tablesorter = new TableRowSorter(table.getModel());
   table.setRowSorter(tablesorter);
   int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS; 
   int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; 
   JScrollPane js = new JScrollPane(table, v, h);
   js.setPreferredSize(new Dimension(1150,500));
   add(js);
   }
}
