import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DaycareFrameParents extends JFrame implements ActionListener {
	static String sqlSelectAll = "select name, tel,address,publicprivate,Facilitytype from daycarecenter;";
	static String sqlSearch = "select name, tel,address,publicprivate,Facilitytype from daycarecenter where name = ? AND tel=?;";
	static String sqlSearchAll = "select name, tel,address,publicprivate,Facilitytype from daycarecenter;";

	Connection conn = null;
	
	JTable table;
	JTextField nameText, phoneText;
	JButton searchButton, infobtn, personbtn;
	JPanel panel;
	JLabel status;

	
	DaycareFrameParents() {
		setTitle("어린이집 DB (학부모)");

		Container contentPane = getContentPane();
		
		// table
		String colNames[] = {"이름", "전화번호","주소", "공사립","시설구분"};
		DefaultTableModel model = new DefaultTableModel(colNames, 0) {
			public boolean isCellEditable(int row, int col) {
				if (col == 0) return false;
				else return true;
			}
		};
		table = new JTable(model);
		status = new JLabel();
		
		contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
		
		// panel
		JPanel inputPanel = new JPanel();
		nameText = new JTextField(10);
		phoneText = new JTextField(10);

		
		searchButton = new JButton("검색");
		infobtn = new JButton("정보");
		personbtn = new JButton("인원");
		inputPanel.add(new JLabel("이름"));
		inputPanel.add(nameText);
		inputPanel.add(new JLabel("전화번호"));
		inputPanel.add(phoneText);
		
		
		inputPanel.add(searchButton);
		inputPanel.add(infobtn);
		inputPanel.add(personbtn);

		panel = new JPanel(new BorderLayout());
		panel.add(inputPanel, BorderLayout.CENTER);
		panel.add(status, BorderLayout.SOUTH);
		
		contentPane.add(panel, BorderLayout.SOUTH);
		
		// action listener
		
		searchButton.addActionListener(this);
		infobtn.addActionListener(this);
		personbtn.addActionListener(this);
		addWindowListener(new WindowAdapter(){
			  public void windowClosing(WindowEvent we){
			  setVisible(false);
			  }
			  }
		  );
	}

	//소멸자
	protected void finalize() {
		closeDBConnection();
	}
	
	//DB 연결이 유효한지 확인. 유효하지 않으면 새로운 연결 수립
	void validateDBConnection() {
		try {
			if (conn == null) {
				conn = DBConnManager.getConnection();
				System.err.println("DB가 연결되었습니다.");
			}
			else if (!conn.isValid(15)) { //15초 이내에 정상적인 응답이 없으면,
				conn.close();
				conn = DBConnManager.getConnection();
				System.err.println("DB가 재연결되었습니다.");
			}
		}
		catch (SQLException e) {
			System.err.println("DB에 접근할 수 없습니다.");
			e.printStackTrace();
		}
	}
	
	//DB 연결 해제
	void closeDBConnection() {
		try {
			DBConnManager.closeConnection(conn);
			System.err.println("DB 연결이 해제되었습니다.");
		}
		catch (SQLException e) {
			System.err.println("DB 연결 해제 중 에러!");
			e.printStackTrace();
		}
	}
	
	// 테이블 초기화 (모든 레코드)
	public int initTableWithDB() {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			// DB 연결
			status.setText("DB 연결 중...");
			validateDBConnection();
			status.setText("DB 연결 완료");
			
			// statement 준비
			stmt = conn.prepareStatement(sqlSelectAll);
			
			// sql 실행
			rs = stmt.executeQuery();
			
			// 테이블에 세팅
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			String arr[] = new String[5];
			
			while (rs.next()) {
				arr[0] = rs.getString(1);
				arr[1] = rs.getString(2);
				arr[2] = rs.getString(3);
				arr[3] = rs.getString(4);
				arr[4] = rs.getString(5);
				model.addRow(arr);
				count++;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			// 리소스 반환
			if (rs != null)		try { rs.close(); }		catch (Exception e) {}
			if (stmt != null)	try { stmt.close(); }	catch (Exception e) {}
			
			setStatus(count + "개의 어린이집 정보가 DB에 존재합니다.");
		}
		
		return count;
	}

	// 삽입/삭제/수정/검색 처리
	public void actionPerformed(ActionEvent ae) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// DB 연결 확인
			validateDBConnection();
			
			Object src = ae.getSource();
			if (src == searchButton) {	// 검색
				
				String name = nameText.getText().trim();
				String phone=phoneText.getText().trim();
				if (name.compareTo("") == 0)
					stmt = conn.prepareStatement(sqlSearchAll);
				else {
					stmt = conn.prepareStatement(sqlSearch);	
					stmt.setString(1, name);
					stmt.setString(2, phone);
				}

				setStatus("DB 검색 중...");
				rs = stmt.executeQuery();

				// 테이블에 세팅
				int count=0;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int rowNum = model.getRowCount();
				for(int i=rowNum-1; i >= 0; i--)
					model.removeRow(i);
				String arr[] = new String[5];
				while (rs.next()) {
					arr[0] = rs.getString(1);
					arr[1] = rs.getString(2);
					arr[2] = rs.getString(3);
					arr[3] = rs.getString(4);
					arr[4] = rs.getString(5);
					model.addRow(arr);
					count++;
				}
				
				setStatus(count + "개의 어린이집이 검색되었습니다.");
			}
			else if (src==infobtn) {	//정보
				int row = table.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(null, "정보를 확인할 어린이집을 선택해주세요.");
				}
				else {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					String dname = model.getValueAt(row, 0).toString().trim();
					String dtel = model.getValueAt(row, 1).toString().trim();
					Detail dt = new Detail(dname, dtel);
					dt.setSize(600,200);
				    dt.setVisible(true);
		
				}
			}
			else if (src==personbtn) {	//인원
				int row = table.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(null, "인원을 확인할 어린이집을 선택해주세요.");
				}
				else {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					String dname = model.getValueAt(row, 0).toString().trim();
					String dtel = model.getValueAt(row, 1).toString().trim();
					PersonnelD dt = new PersonnelD(dname, dtel);
					dt.setSize(600,200);
				    dt.setVisible(true);
				}
			}
		}
		catch (SQLException e) {
			setStatus("DB에 접근할 수 없거나 SQL을 실행할 수 없습니다.");
			e.printStackTrace();
		}
		finally {
			// 리소스 반환
			if (rs != null)		try { rs.close(); }		catch (Exception e) {}
			if (stmt != null)	try { stmt.close(); }	catch (Exception e) {}
		}
	}
	
	public void setStatus(String s) {
		status.setText(s);
		this.validate();
	}


}
