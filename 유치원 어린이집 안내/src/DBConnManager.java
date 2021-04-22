import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//DB 연결 설정 및 해제
public class DBConnManager {
	static String dbServerAddr = "jdbc:mysql://localhost:3306/";
	static String dbName = "mydatabase"; // 여러분 DB 이름으로 수정
	static String user = "root"; // 여러분 계정 이름으로 수정
	static String pswd = "0000"; // 여러분 비밀번호로 수정

	// DB 연결 설정
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(dbServerAddr + dbName + "?useSSL=false&serverTimezone=Asia/Seoul", user,
				pswd);
	}

	// DB 연결 해제
	public static void closeConnection(Connection conn) throws SQLException {
		if (conn != null)
			conn.close();
	}
}
