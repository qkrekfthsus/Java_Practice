import javax.swing.*;

class eTable extends JPanel{ 
	public eTable() { 
		String[] title={"입사일","주소","전화"}; 
		String[][] data={{"2001-1-1","은평구 응암동","303-5555"}, 
				{"2000-5-30","마포구 도화동","555-6666"}, 
				{"2008-1-1","구로구 신도림동","777-1234"}};
		JTable table = new JTable(data, title); 
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS; 
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; 
		JScrollPane js = new JScrollPane(table, v, h); 
		add(js);              }    }