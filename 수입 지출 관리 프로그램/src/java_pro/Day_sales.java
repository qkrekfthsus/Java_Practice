package java_pro;

import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

class Day_sales extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable table;
	DBConnManager dbc;
	JButton resetbtn;
	JPanel jpn1;
	DefaultTableModel model;

	public Day_sales() {
		String[] title = { "날짜", "순이익", "총 판매금액", "총  구매금액" }; // JTable 칼럼 이름
		DefaultTableModel model = new DefaultTableModel(title, 0) {// 테이블을 해당 래퍼런스변수 형태 로 만들어준다.
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return String.class;
				case 1:
					return Integer.class;
				case 2:
					return Integer.class;
				case 3:
					return Integer.class;
				default:
					return String.class;
				}
			}
		};
		table = new JTable(model);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DBConnManager.getConnection(); // DB연동
			Statement st = connect.createStatement();
			ResultSet rs = st.executeQuery("select * from sales_day"); // sales_day 테이블의 모든값을 가져온다.
			model = (DefaultTableModel) table.getModel();

			Object data[] = new Object[4];
			while (rs.next()) {
				data[0] = rs.getString(1); // 날짜(일)
				data[1] = rs.getInt(2); // 순이익
				data[2] = rs.getInt(3); // 총 판매금액
				data[3] = rs.getInt(4); // 총 구매금액
				model.addRow(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 테이블셀 렌더러 객체를 생성.
		dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 생성한 렌더러의 가로정렬을 CENTER로
		table.getColumnModel().getColumn(0).setCellRenderer(dtcr);
		table.getColumnModel().getColumn(1).setCellRenderer(dtcr);
		table.getColumnModel().getColumn(2).setCellRenderer(dtcr);
		table.getColumnModel().getColumn(3).setCellRenderer(dtcr);

		// 오름차순 내림차순 정렬
		table.setAutoCreateRowSorter(true);
		TableRowSorter<TableModel> tablesorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(tablesorter);

		// ScrollPane
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
		JScrollPane js = new JScrollPane(table, v, h);
		js.setPreferredSize(new Dimension(1150, 475));
		add(js);

		jpn1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) jpn1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		resetbtn = new JButton("새로고침");
		jpn1.add(resetbtn);
		add(jpn1);

		//버튼 감지기를 달았다.
		resetbtn.addActionListener(this);
		setLayout(new GridLayout(4, 1));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 자동 생성된 메소드 스텁
		if (e.getSource() == resetbtn) { // 새로고침 버튼
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connect = DBConnManager.getConnection();

				Statement st = connect.createStatement();
				ResultSet rs = st.executeQuery("select * from sales_day"); // sales_day 모든 값을 불러온다

				// 테이블에 불로온 값 배치
				model = (DefaultTableModel) table.getModel();
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int rowNum = model.getRowCount();

				for (int i = rowNum - 1; i >= 0; i--)
					model.removeRow(i);
				Object data[] = new Object[4];

				while (rs.next()) {
					for (int i = 0; i < 4; i++) {
						data[i] = rs.getString(i + 1);
					}
					model.addRow(data);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();

			}
		}
	}
}
