import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DBSample1 {
	static String dbServerAddr = "jdbc:mysql://220.67.115.32:3306/";
	static String dbName = "stdt023"; // �뿬�윭遺� DB �씠由꾩쑝濡� �닔�젙
	static String user = "stdt023"; // �뿬�윭遺� 怨꾩젙 �씠由꾩쑝濡� �닔�젙
	static String pswd = "ljp513"; // �뿬�윭遺� 鍮꾨�踰덊샇濡� �닔�젙

	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	DBSample1() {}
	
	
	/*
	 * [�떎�뒿1]
	 * STUDENT �뀒�씠釉붿뿉�꽌 ID媛� 20116745 �씤 �븰�깮�쓽 ID, �씠由�, �쟾�솕踰덊샇瑜� 寃��깋�븯�룄濡� SelectTest �븿�닔瑜� �닔�젙�븯�떆�삤.
	 */
	public void SelectTest() {
		try {
			// DB �뿰寃�
			conn = DriverManager.getConnection(dbServerAddr + dbName, user, pswd);

			// SQL �떎�뻾
			stmt = conn.prepareStatement("select ID, NAME, PHONE from STUDENT;");
			rs = stmt.executeQuery();
			
			// Result Set 泥섎━
			System.out.println("ID\t\t이름\t전화번호");
			System.out.println("-------------------------------------");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString("PHONE"));
			}
		}
		catch (SQLException e) {
			System.err.println("DB�뿉 �젒洹쇳븷 �닔 �뾾嫄곕굹 SQL�쓣 �떎�뻾�븷 �닔 �뾾�뒿�땲�떎.");
			e.printStackTrace();
		}
		// 由ъ냼�뒪 諛섑솚
		finally {
			if (rs != null)		try { rs.close(); }		catch (Exception e) {}
			if (stmt != null)	try { stmt.close(); }	catch (Exception e) {}
			if (conn != null)	try { conn.close(); }	catch (Exception e) {}
		}		
	}
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

	/*
	 * [�떎�뒿2]
	 * �떎�쓬怨� 媛숈� 諛⑹떇�쑝濡� �궗�슜�옄濡쒕��꽣 ID瑜� �엯�젰諛쏆븘 �빐�떦 ID �븰�깮�쓽 �씠由꾧낵 �쟾�솕踰덊샇瑜� 寃��깋�븯�룄濡� InputSelectTest �븿�닔瑜� �닔�젙�븯�떆�삤.
	 * �븿�닔 �닔�젙 �썑 main �븿�닔�쓽 而ㅻ찘�듃瑜� �빐�젣�븯�뿬 �떎�뻾�븯�떆�삤.
	 */
	public void InputSelectTest() {
		//사용자로부터 ID를 입력받는 것은 아래 코드를 활용할 것
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// 1. 사용자로부터 검색할 ID를 입력받음
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("검색할 ID를 입력하세요. ID: ");
			String str = reader.readLine();
			
			// 2. DB 연결 확인
			validateDBConnection();
			
			// 3. SQL 실행
			stmt = conn.prepareStatement("select NAME, PHONE from STUDENT where ID = ?;");
			stmt.setInt(1, Integer.parseInt(str));
			rs = stmt.executeQuery();
			
			// 4. Result Set 처리
			System.out.println("이 름\t전화번호");
			System.out.println("----------------------");
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t" + rs.getString(2));
			}
		}
		catch (IOException e) {
			System.out.println("입력 에러!");
		}
		catch (SQLException e) {
			System.out.println("DB에 접근할 수 없거나 SQL을 실행할 수 없습니다.");
			e.printStackTrace();
		}
		// 5. 리소스 반환
		finally {
			if (rs != null)		try { rs.close(); }		catch (Exception e) {}
			if (stmt != null)	try { stmt.close(); }	catch (Exception e) {}
		}	

			
		
	}
	
	public static void main(String[] args) {
		DBSample1 sample = new DBSample1();
		sample.SelectTest();
		sample.InputSelectTest();
	}
}
