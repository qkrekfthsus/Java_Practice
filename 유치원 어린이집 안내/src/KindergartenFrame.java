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

public class KindergartenFrame extends JFrame implements ActionListener {
	static String sqlSelectAll = "select * from kindergarten;";
	static String sqlInsert = "insert kindergarten(name, tel,address,publicprivate,Facilitytype) values(?, ?, ?,?,?);";
	static String sqlDelete = "delete from kindergarten where name = ? AND tel=?;";
	static String sqlSearch = "select * from kindergarten where name = ? AND tel=?;";
	static String sqlSearchAll = "select name, tel,address,publicprivate,Facilitytype from kindergarten;";

	Connection conn = null;
	
	JTable table;
	JTextField nameText, phoneText, adText,puText,faText;
	JButton insButton, delButton, searchButton;
	JPanel panel;
	JLabel status;

	
	KindergartenFrame() {
		setTitle("유치원 DB 관리(원장)");
		
		
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
		adText = new JTextField(10);
		puText=new JTextField(10);
		faText=new JTextField(10);
		insButton = new JButton("삽입");
		delButton = new JButton("삭제");
		searchButton = new JButton("검색");
		inputPanel.add(new JLabel("이름"));
		inputPanel.add(nameText);
		inputPanel.add(new JLabel("전화번호"));
		inputPanel.add(phoneText);
		inputPanel.add(new JLabel("주소"));
		inputPanel.add(adText);
		inputPanel.add(new JLabel("공사립"));
		inputPanel.add(puText);
		inputPanel.add(insButton);
		inputPanel.add(delButton);
		inputPanel.add(searchButton);

		panel = new JPanel(new BorderLayout());
		panel.add(inputPanel, BorderLayout.CENTER);
		panel.add(status, BorderLayout.SOUTH);
		
		contentPane.add(panel, BorderLayout.SOUTH);
		
		// action listener
		insButton.addActionListener(this);
		delButton.addActionListener(this);
		searchButton.addActionListener(this);
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
			
			setStatus(count + "개의 유치원 정보가 DB에 존재합니다.");
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
			if (src == insButton) { 		// 삽입
				stmt = conn.prepareStatement(sqlInsert);
				
				String nameStr = nameText.getText().trim();
				String phoneStr = phoneText.getText().trim();
				String adStr = adText.getText().trim();
				String puStr=puText.getText().trim();
				stmt.setString(1,nameStr);
				stmt.setString(2, phoneStr);
				stmt.setString(3, adStr);
				stmt.setString(4, puStr);
				stmt.setString(5, "유치원");

				setStatus("DB에 추가 중...");
				int num = stmt.executeUpdate();
				
				if (num > 0) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					String arr[] = new String[5];
					arr[0] = nameStr;
					arr[1] = phoneStr;
					arr[2] = adStr;
					arr[3] = puStr;
					arr[4] = "유치원";
					model.addRow(arr);
					
					setStatus(num + "개의 유치원 정보가 추가되었습니다.");
				}
				else
					setStatus("유치원 정보가 추가되지 않았습니다.");
			}
			else if (src == delButton) {	// 삭제
				int row = table.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(null, "삭제할 행을 먼저 선택한 후 삭제 버튼을 클릭하세요.");
				}
				else {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					stmt = conn.prepareStatement(sqlDelete);
					stmt.setString(1, model.getValueAt(row, 0).toString());
					stmt.setString(2, model.getValueAt(row, 1).toString());
					
					setStatus("DB에서 삭제 중...");
					int num = stmt.executeUpdate();
					
					if (num > 0) {
						model.removeRow(row);
						setStatus(num + "개의 유치원 정보가 삭제되었습니다.");
					}
					else
						setStatus("유치원 정보가 삭제되지 않았습니다.");

				}
			}
			else if (src == searchButton) {	// 검색
				
				String name = nameText.getText().trim();
				String phone=phoneText.getText().trim();
				if (name.compareTo("") == 0)
					stmt = conn.prepareStatement(sqlSearchAll);
				else {
					stmt = conn.prepareStatement(sqlSearch);	
					stmt.setString(1, name);
					stmt.setString(2,phone);
					
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
				
				setStatus(count + "개의 유치원이 검색되었습니다.");
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
	
	public static void main(String[] args) {
		KindergartenFrame frame = new KindergartenFrame();
		frame.setPreferredSize(new Dimension(1100, 400));
		frame.setLocation(500, 400);
		frame.pack();
		frame.setVisible(true);
		
		frame.initTableWithDB();
	}


}
