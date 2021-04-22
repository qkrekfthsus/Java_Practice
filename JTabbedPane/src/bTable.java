import javax.swing.*;

class bTable extends JPanel{ 
	public bTable() { 
	String[] title={"사번","성명","부서"}; 
	String[][] data={{"1","이명박","총무과"},{"2","이승엽","인사과"},{"3","박태환","전산과"}};
	JTable table = new JTable(data, title); 
	int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS; 
	int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; 
	JScrollPane js = new JScrollPane(table, v, h); 
	add(js);
	}
}