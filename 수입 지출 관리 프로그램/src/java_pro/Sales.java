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
import java.util.Calendar;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

class Sales extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DBConnManager dbc;
	JPanel jpn1; //
	JTable table;
	JButton delbtn, sellbuybtn, resetbtn; // 삭제 버튼, 구매판매 버튼, 새로고침 버튼
	DefaultTableModel model;
	JComboBox<String> combo;
	JTextField amount;
	JLabel label_2;
	JTextField etc;
	String btname;
	String name;
	String curmonth, curday;

	// tablename은 수입탭팬 과 지출탭팬 이 같은 애트리뷰트로 구성이 되어 있기때문에 선택에 따라 이름을 구분해줍니다.(113번줄~117번줄)
	public Sales(String tablename) { 
		String[] title = { "이름", "날짜", "수량", "단가", "가격", "비고" };
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
					return Integer.class;
				case 4:
					return Integer.class;
				case 5:
					return Integer.class;
				case 6:
					return String.class;
				default:
					return String.class;
				}
			}
		};
		this.name = tablename;
		table = new JTable(model);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DBConnManager.getConnection(); // DB연동
			Statement st = connect.createStatement();

			// tablename 이름이 두가지가 있기 때문에 2가지 종류다 값을 불러온다.
			ResultSet rs = st.executeQuery("select * from " + tablename);
			model = (DefaultTableModel) table.getModel();

			Object data[] = new Object[6];
			while (rs.next()) { // 값이 없을때까지 값을 가져온다
				data[0] = rs.getString(1); // 이름
				data[1] = rs.getString(2); // 날짜
				data[2] = rs.getInt(3); // 수량
				data[3] = rs.getInt(4); // 단가
				data[4] = rs.getInt(5); // 가격
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

		/// 테이블 오름차순 내림차순 정렬
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

		if (tablename == "sell") { // 수입탭이면 버튼이름이 "판매"로 활성화
			btname = "판매";
		} else if (tablename == "buy") { // 지출탭이면 버튼이름이 "구매"로 활성화
			btname = "구매";
		}

		delbtn = new JButton("삭제");
		sellbuybtn = new JButton(btname); // 위에서 설정된 변수명으로 버튼이름 활성화
		resetbtn = new JButton("새로고침");
		combo = new JComboBox<String>(); // 콤보박스 형식으로 등록된 이름을 가져와서 선택할 수 있다.
		combo.setEditable(true);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DBConnManager.getConnection(); // DB연동
			Statement st = connect.createStatement();
			ResultSet rs = st.executeQuery("select 이름 from product"); // 상품에 등록된 이름들을 가져온다.
			combo.addItem("");
			while (rs.next()) {
				String name = rs.getString(1);
				if (name.equals("")) {
					combo.addItem("");
					combo.setVisible(false);
				} else {
					combo.addItem(rs.getString(1));
					combo.setVisible(true);
				}
			}
		} catch (Exception ex) {

		}
		JLabel label = new JLabel("물품명 : ");
		JLabel label_1 = new JLabel("물품 수량 : ");
		amount = new JTextField();
		amount.setColumns(10);
		label_2 = new JLabel("비고 : ");
		etc = new JTextField();
		etc.setColumns(10);

		jpn1.add(label);
		jpn1.add(combo);
		jpn1.add(label_1);
		jpn1.add(amount);
		jpn1.add(label_2);
		jpn1.add(etc);
		jpn1.add(sellbuybtn);
		jpn1.add(resetbtn);
		jpn1.add(delbtn);
		add(jpn1);

		// 버튼 감지기를 달았다.
		sellbuybtn.addActionListener(this);
		delbtn.addActionListener(this);
		resetbtn.addActionListener(this);
		setLayout(new GridLayout(4, 1));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sellbuybtn) {	//구매,판매 버튼
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connect = DBConnManager.getConnection(); // DB연동
				int num = Integer.parseInt(amount.getText()); // 재고 +/-
				if (name == "sell") { // sell 판매
					btname = "판매";
				} else if (name == "buy") {// buy는 재고에서
					btname = "구매";
					num = num * -1;
				}
				PreparedStatement stmt = connect.prepareStatement("SET FOREIGN_KEY_CHECKS = 0;"); // 외래키 제약조건 해제구문.
				stmt.executeUpdate();
				stmt = connect.prepareStatement(

						// 데이터 삽입
						"INSERT " + name + "(이름, " + btname + "일자, " + btname + "수량, 비고) VALUES(?, CURDATE(), ?,?);");
				stmt.setString(1, combo.getSelectedItem().toString());
				stmt.setInt(2, Integer.parseInt(amount.getText()));
				stmt.setString(3, etc.getText());
				stmt.executeUpdate();

				// procut에서 이름을 찾아서 product에 있는 단가랑 맞춰서 설정하겠다.
				stmt = connect.prepareStatement("UPDATE " + name + ", product SET " + name
						+ ".단가 = product.단가 WHERE product.이름 = " + name + ".이름;");
				stmt.executeUpdate();
				// 총 판매가격은 수량*단가
				stmt = connect.prepareStatement("UPDATE " + name + " SET " + name + ".`총 " + btname + "가격` = " + name
						+ "." + btname + "수량*" + name + ".단가;");
				stmt.executeUpdate();

				// 재고를 바꿔주게 되는데 name이 buy라면 num에 -를 곱하게 되서 재고를 더하게됨.
				stmt = connect.prepareStatement(
						"UPDATE " + name + ",product SET product.재고 = product.재고-? WHERE product.이름 = ?");
				stmt.setInt(1, num);
				stmt.setString(2, combo.getSelectedItem().toString());
				stmt.executeUpdate();

				// 일별 월별에 데이터참조를 위해 수정구문.
				stmt = connect.prepareStatement("UPDATE " + name + " SET `" + name + "`.`월`= SUBSTRING(`" + name + "`.`"
						+ btname + "일자`,1,7);");
				stmt.executeUpdate();
				stmt = connect.prepareStatement(
						"UPDATE " + name + " SET `" + name + "`.`날짜`=`" + name + "`.`" + btname + "일자`;");
				stmt.executeUpdate();

				//월별에 데이터 삽입을 할때 같은월이 없으면 추가를 한다
				stmt = connect.prepareStatement("select 월 from sales_month where 월= ?");
				Calendar oCalendar = Calendar.getInstance();	//calendar를 사용해 현제 월을 받아온다.
				curmonth = String.valueOf(oCalendar.get(Calendar.YEAR)) + "-"
						+ String.valueOf(oCalendar.get(Calendar.MONTH) + 1);
				stmt.setString(1, curmonth);
				ResultSet rs = stmt.executeQuery();
				int count = 0;
				while (rs.next()) {
					count++;
				}
				if (count == 0) {
					stmt = connect.prepareStatement("INSERT sales_month(월) VALUES(?)");
					stmt.setString(1, curmonth);
					stmt.executeUpdate();
				}
				
				//월별 총 판매가격 update
				stmt = connect.prepareStatement(
						"UPDATE `sales_month`,`sell` SET `sales_month`.`총 판매 금액` = (SELECT SUM(`총 판매가격`) FROM `sell` WHERE `월` = CONCAT(YEAR(CURDATE()),'-',MONTH(CURDATE()))) WHERE `sales_month`.`월` = CONCAT(YEAR(CURDATE()),'-',MONTH(CURDATE()));");
				stmt.executeUpdate();
				
				//월별 총 구매가격 update
				stmt = connect.prepareStatement(
						"UPDATE `sales_month`,`buy` SET `sales_month`.`총 구매 금액` = (SELECT SUM(`총 구매가격`) FROM `buy` WHERE `월` = CONCAT(YEAR(CURDATE()),'-',MONTH(CURDATE()))) WHERE `sales_month`.`월` = CONCAT(YEAR(CURDATE()),'-',MONTH(CURDATE()));");
				stmt.executeUpdate();
				stmt = connect.prepareStatement("UPDATE `sales_month` SET `월별 순이익` = `총 판매 금액`-`총 구매 금액`");
				stmt.executeUpdate();
				
				//월별에 데이터 삽입을 할때 같은월이 없으면 추가를 한다
				stmt = connect.prepareStatement("select 날짜 from sales_day where 날짜 = ?");
				String curday = String.valueOf(oCalendar.get(Calendar.YEAR)) + "-" + String.valueOf(
						oCalendar.get(Calendar.MONTH) + 1 + "-" + String.valueOf(oCalendar.get(Calendar.DAY_OF_MONTH)));
				stmt.setString(1, curday);
				ResultSet rst = stmt.executeQuery();
				int countd = 0;
				while (rst.next()) {
					countd++;
				}
				if (countd == 0) {
					stmt = connect.prepareStatement("INSERT sales_day(날짜) VALUES(?)");
					stmt.setString(1, curday);
					stmt.executeUpdate();
				}
				//일별 총 판매가격 update
				stmt = connect.prepareStatement(
						"UPDATE `sales_day`,`sell` SET `sales_day`.`총 판매금액` = (SELECT SUM(`총 판매가격`) FROM `sell` WHERE 날짜 = CONCAT(YEAR(CURDATE()),'-',MONTH(CURDATE()), '-', DAY(CURDATE()))) WHERE `sales_day`.`날짜` = CONCAT(YEAR(CURDATE()),'-',MONTH(CURDATE()), '-', DAY(CURDATE()));");
				stmt.executeUpdate();
				//일별 총 구매가격 update
				stmt = connect.prepareStatement(
						"UPDATE `sales_day`,`buy` SET `sales_day`.`총 구매금액` = (SELECT SUM(`총 구매가격`) FROM `buy` WHERE 날짜 = CONCAT(YEAR(CURDATE()),'-',MONTH(CURDATE()), '-', DAY(CURDATE()))) WHERE `sales_day`.`날짜` = CONCAT(YEAR(CURDATE()),'-',MONTH(CURDATE()), '-', DAY(CURDATE()));");
				stmt.executeUpdate();
				// 순이익 연산 update
				stmt = connect.prepareStatement("UPDATE `sales_day` SET `순이익` = `총 판매금액`-`총 구매금액`");
				stmt.executeUpdate();

			} catch (ClassNotFoundException | SQLException e1) {
				// TODO 자동 생성된 catch 블록
				e1.printStackTrace();
			}

		}

		else if (e.getSource() == resetbtn) { //새로고침 버튼실행
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connect = DBConnManager.getConnection(); //DB연동
				Statement st = connect.createStatement();
				ResultSet rs = st.executeQuery("select * from " + name); //String 변수 name에 해당하는 테이블의 값을 가져온다.
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
		} else if (e.getSource() == delbtn) {
			int row = table.getSelectedRow();
			if (name == "sell") {
				btname = "판매";
			} else if (name == "buy") {
				btname = "구매";
			}
			if (row == -1) {
				JOptionPane.showMessageDialog(null, "삭제할 행을 먼저 선택한 후 삭제 버튼을 클릭하세요.");
			} else {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connect = DBConnManager.getConnection();
					PreparedStatement stmt = connect.prepareStatement(
							"DELETE FROM " + name + " WHERE 이름=? AND " + btname + "수량=? ORDER BY num DESC LIMIT 1;");
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					stmt.setString(1, model.getValueAt(row, 0).toString());
					stmt.setInt(2, Integer.parseInt(model.getValueAt(row, 2).toString()));
					int num = stmt.executeUpdate();
					
					//삭제를 할때 연동된, 월별,일별 값을 변경한다.
					if (num > 0) {
						model.removeRow(row);
						stmt = connect.prepareStatement(
								"UPDATE `sales_month`,`sell` SET `sales_month`.`총 판매 금액` = (SELECT SUM(`총 판매가격`) FROM `sell` WHERE `월` = CONCAT(YEAR(CURDATE()),'-',MONTH(CURDATE()))) WHERE `sales_month`.`월` = CONCAT(YEAR(CURDATE()),'-',MONTH(CURDATE()))");
						stmt.executeUpdate();
						stmt = connect.prepareStatement(
								"UPDATE `sales_month`,`buy` SET `sales_month`.`총 구매 금액` = (SELECT SUM(`총 구매가격`) FROM `buy` WHERE `월` = CONCAT(YEAR(CURDATE()),'-',MONTH(CURDATE()))) WHERE `sales_month`.`월` = CONCAT(YEAR(CURDATE()),'-',MONTH(CURDATE()))");
						stmt.executeUpdate();
						stmt = connect.prepareStatement("UPDATE `sales_month` SET `월별 순이익` = `총 판매 금액`-`총 구매 금액`");
						stmt.executeUpdate();
						stmt = connect.prepareStatement(
								"UPDATE `sales_day`,`sell` SET `sales_day`.`총 판매금액` = (SELECT SUM(`총 판매가격`) FROM `sell` WHERE 날짜 = CONCAT(YEAR(CURDATE()),'-',MONTH(CURDATE()), '-', DAY(CURDATE()))) WHERE `sales_day`.`날짜` = CONCAT(YEAR(CURDATE()),'-',MONTH(CURDATE()), '-', DAY(CURDATE()));");
						stmt.executeUpdate();
						stmt = connect.prepareStatement(
								"UPDATE `sales_day`,`buy` SET `sales_day`.`총 구매금액` = (SELECT SUM(`총 구매가격`) FROM `buy` WHERE 날짜 = CONCAT(YEAR(CURDATE()),'-',MONTH(CURDATE()), '-', DAY(CURDATE()))) WHERE `sales_day`.`날짜` = CONCAT(YEAR(CURDATE()),'-',MONTH(CURDATE()), '-', DAY(CURDATE()));");
						stmt.executeUpdate();
						stmt = connect.prepareStatement("UPDATE `sales_day` SET `순이익` = `총 판매금액`-`총 구매금액`");
						stmt.executeUpdate();
					} else {
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO 자동 생성된 catch 블록
					e1.printStackTrace();
				}

			}
		}

	}
}
