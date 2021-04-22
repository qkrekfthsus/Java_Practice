import javax.swing.*;

class fTable extends JPanel { 
	public fTable() { 
		String[] title={"호봉","근무평점"}; 
		String[][] data={{"0506","보통"},{"0401","우수"},{"0701","미흡"}};
		JTable table = new JTable(data, title); 
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS; 
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; 
		JScrollPane js = new JScrollPane(table, v, h); 
		add(js);
	}
}