package java_pro;

import java.awt.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.*;

public class Insert extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DBConnManager dbc;
	static String sqlInsert = "insert product(이름, 제조사, 단가, 유통기한, 재고, 비고) values(?, ?, ?, ?, ?, ?);"; // insert
	JPanel p;
	JTextField tfId, tfMoney, tfAnum, prMname, tfText; // 상품명,단가,재고,제조사,비고
	JTextField tfTel1, tfTel2, tfTel3; // 전화번
	JButton btnInsert, btnCancel, btnUpdate, btnDelete; // 가입, 취소, 수정 , 탈퇴 버튼
	// 물품 등록할떄 사용할 클래스 변수들
	static String TFID, PRPWD, TFNAME, TFADDR, TFADDRR, TFTEL1, TFTEL2, TFTEL3, TFTEL5;
	GridBagLayout gb;
	GridBagConstraints gbc;

	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	Insert() {
		this.setLocation(600, 400);
	}

	public void SelectTest() {
		{
			try {
				// DB 연결
				conn = DBConnManager.getConnection();
			} catch (SQLException e) {
				System.err.println("DB에 접근할 수 없거나 SQL을 실행할 수 없습니다.");
				e.printStackTrace();
			}
		}

		this.setTitle("물품 추가");
		gb = new GridBagLayout();
		setLayout(gb);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;

		// 상품명
		JLabel bId = new JLabel("상품명 : ");
		tfId = new JTextField(20);
		// 그리드백에 붙이기
		gbAdd(bId, 0, 0, 1, 1);
		gbAdd(tfId, 1, 0, 3, 1);

		// 제조사
		JLabel bPwd = new JLabel("제조사 : ");
		prMname = new JTextField(20);
		gbAdd(bPwd, 0, 1, 1, 1);
		gbAdd(prMname, 1, 1, 3, 1);

		// 단가
		JLabel bName = new JLabel("단가 :");
		tfMoney = new JTextField(20);
		gbAdd(bName, 0, 2, 1, 1);
		gbAdd(tfMoney, 1, 2, 3, 1);

		// 유통기한
		JLabel bTel = new JLabel("유통기한 :");
		JPanel pTel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		tfTel1 = new JTextField(8);
		tfTel2 = new JTextField(4);
		tfTel3 = new JTextField(4);
		pTel.add(tfTel1);
		pTel.add(new JLabel(" - "));
		pTel.add(tfTel2);
		pTel.add(new JLabel(" - "));
		pTel.add(tfTel3);
		gbAdd(bTel, 0, 3, 1, 1);
		gbAdd(pTel, 1, 3, 3, 1);

		// 재고
		JLabel bAddr = new JLabel("재고 : ");
		tfAnum = new JTextField(20);
		gbAdd(bAddr, 0, 4, 1, 1);
		gbAdd(tfAnum, 1, 4, 3, 1);

		// 비고
		JLabel bAddrr = new JLabel("비고 : ");
		tfText = new JTextField(20);
		gbAdd(bAddrr, 0, 5, 1, 1);
		gbAdd(tfText, 1, 5, 3, 1);

		// 버튼
		JPanel pButton = new JPanel();
		btnInsert = new JButton("추가");
		btnCancel = new JButton("취소");
		pButton.add(btnInsert);
		pButton.add(btnCancel);
		gbAdd(pButton, 0, 10, 4, 1);

		// 버튼에 감지기를 붙이자
		btnInsert.addActionListener(this);
		btnCancel.addActionListener(this);

		setSize(350, 300);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				setVisible(false);
			}
		});

	}

	// createUI 그리드백레이아웃에 붙이는 메소드
	private void gbAdd(JComponent c, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gb.setConstraints(c, gbc);
		gbc.insets = new Insets(2, 2, 2, 2);
		add(c, gbc);
	}// gbAdd

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnInsert) { // insert 화면 입력창
			TFID = tfId.getText();
			PRPWD = prMname.getText();
			TFNAME = tfMoney.getText();
			TFTEL1 = tfTel1.getText();
			TFTEL2 = tfTel2.getText();
			TFTEL3 = tfTel3.getText();
			TFTEL5 = (TFTEL1 + "-" + TFTEL2 + "-" + TFTEL3);
			TFADDR = tfAnum.getText();
			TFADDRR = tfText.getText();
			try {
				stmt = conn.prepareStatement(sqlInsert); // (이름, 제조사, 단가, 유통기한, 재고, 비고) 순서대로 insert 한다.
				stmt.setString(1, TFID);
				stmt.setString(2, PRPWD);
				stmt.setInt(3, Integer.parseInt(TFNAME));
				stmt.setString(4, TFTEL5);
				stmt.setInt(5, Integer.parseInt(TFADDR));
				stmt.setString(6, TFADDRR);
				stmt.executeUpdate();
				dispose();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "같은 상품명을 입력할 수 없습니다.");
				dispose();
				Insert ist = new Insert();
				ist.SelectTest();
				e1.printStackTrace();
			} finally {
				// 리소스 반환
				if (rs != null)
					try {
						rs.close();
					} catch (Exception e1) {
					}
				if (stmt != null)
					try {
						stmt.close();
					} catch (Exception e1) {
					}
				if (conn != null)
					try {
						conn.close();
					} catch (Exception e1) {
					}

			}
		}
		if (e.getSource() == btnCancel) {
			dispose();
			// 리소스 반환
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e1) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e1) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e1) {
				}
		}
	}
}// end