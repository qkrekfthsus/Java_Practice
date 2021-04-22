package java_pro;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


class Product extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DBConnManager dbc;
	JTable table;
	JPanel jpn1;
	JButton editbtn, delbtn, addbtn, resetbtn;
	DefaultTableModel model;

	public Product() { // 물품 테이블
		String[] title = { "이름", "제조사", "단가", "유통기한", "재고", "비고" };
		DefaultTableModel model = new DefaultTableModel(title, 0) { // 테이블을 해당 래퍼런스변수로 만들어줍니다
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return String.class;
				case 1:
					return String.class;
				case 2:
					return Integer.class;
				case 3:
					return String.class;
				case 4:
					return Integer.class;
				case 5:
					return String.class;
				default:
					return String.class;
				}
			}
		};
		table = new JTable(model);

		/// DB와 테이블 연동
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DBConnManager.getConnection();
			Statement st = connect.createStatement();
			ResultSet rs = st.executeQuery("select * from product");
			model = (DefaultTableModel) table.getModel();

			Object data[] = new Object[6];
			while (rs.next()) { // 값이 없을때까지 값을 가져온다
				data[0] = rs.getString(1); // 이름
				data[1] = rs.getString(2); // 제조사
				data[2] = rs.getInt(3); // 단가
				data[3] = rs.getString(4); // 유통기한
				data[4] = rs.getInt(5); // 재고
				data[5] = rs.getString(6); // 비고
				model.addRow(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}

		/// 테이블 중앙정렬
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 테이블셀 렌더러 객체를 생성.
		dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 생성한 렌더러의 가로정렬을 CENTER로
		table.getColumnModel().getColumn(0).setCellRenderer(dtcr);
		table.getColumnModel().getColumn(1).setCellRenderer(dtcr);
		table.getColumnModel().getColumn(2).setCellRenderer(dtcr);
		table.getColumnModel().getColumn(3).setCellRenderer(dtcr);
		table.getColumnModel().getColumn(4).setCellRenderer(dtcr);
		table.getColumnModel().getColumn(5).setCellRenderer(dtcr);
		
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
		editbtn = new JButton("수정");
		delbtn = new JButton("삭제");
		addbtn = new JButton("상품 추가");
		resetbtn = new JButton("새로고침");
		jpn1.add(addbtn);
		jpn1.add(resetbtn);
		jpn1.add(editbtn);
		jpn1.add(delbtn);
		add(jpn1);
		
		// 버튼에 감지기를 달았다.
		addbtn.addActionListener(this); // 상품추가 리스너
		editbtn.addActionListener(this); // 새로고침 리스너
		delbtn.addActionListener(this); // 수정 리스너
		resetbtn.addActionListener(this);// 삭제 리스너
		setLayout(new GridLayout(4, 1));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 자동 생성된 메소드 스텁
		if (e.getSource() == addbtn) { // 상품추가 버튼 클릭시 insert생성자가 실행 된다(새창 띄움).
			Insert ist = new Insert();
			ist.SelectTest();

		} else if (e.getSource() == editbtn) { // 행을 선택해서 값을 바꾸고 수정버튼을 누른다.
			int row = table.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(null, "수정할 행을 선택하여 테이블에서 직접 값을 수정한 후 수정 버튼을 클릭하세요.");
			} else {
				try { // 행을 선택후 값을 바꿨다면 update문을 통해 행값이 수정된다.
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connect = DBConnManager.getConnection();
					PreparedStatement stmt = connect.prepareStatement(
							"update product set 제조사 = ?, 단가 = ?, 유통기한 = ?, 재고 = ?, 비고 = ? where 이름 = ?;");
					DefaultTableModel model = (DefaultTableModel) table.getModel();

					stmt.setString(1, model.getValueAt(row, 1).toString().trim());
					stmt.setInt(2, Integer.parseInt(model.getValueAt(row, 2).toString()));
					stmt.setString(3, model.getValueAt(row, 3).toString().trim());
					stmt.setInt(4, Integer.parseInt(model.getValueAt(row, 4).toString()));
					stmt.setString(5, model.getValueAt(row, 5).toString().trim());
					stmt.setString(6, model.getValueAt(row, 0).toString().trim());

					int num = stmt.executeUpdate();

					if (num > 0) {
						model.fireTableDataChanged();

					} else {
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO 자동 생성된 catch 블록
					e1.printStackTrace();
				}

			}
		}

		else if (e.getSource() == delbtn) { // 행을 선택후 삭제버튼을 누른다.

			int row = table.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(null, "삭제할 행을 먼저 선택한 후 삭제 버튼을 클릭하세요.");
			} else {
				try { //
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connect = DBConnManager.getConnection();
					PreparedStatement stmt = connect.prepareStatement("delete from product where 이름 = ?;");
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					stmt.setString(1, model.getValueAt(row, 0).toString());

					int num = stmt.executeUpdate();

					if (num > 0) {
						model.removeRow(row);
					} else {
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO 자동 생성된 catch 블록
					e1.printStackTrace();
				}

			}
		} else if (e.getSource() == resetbtn) { // 새로고침 버튼
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connect = DBConnManager.getConnection();
				Statement st = connect.createStatement();
				ResultSet rs = st.executeQuery("select * from product"); // product 테이블 값을 다시 불러옵니다.
				model = (DefaultTableModel) table.getModel();

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int rowNum = model.getRowCount();
				for (int i = rowNum - 1; i >= 0; i--)
					model.removeRow(i);
				Object data[] = new Object[6];
				while (rs.next()) {
					for (int i = 0; i < 6; i++) {
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