package java_pro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//DB �뿰寃� �꽕�젙 諛� �빐�젣
public class DBConnManager {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  // jdbc 드라이버 주소
	static String dbServerAddr = "jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=Asia/Seoul";
	static String user = "root"; // �뿬�윭遺� 怨꾩젙 �씠由꾩쑝濡� �닔�젙
	static String pswd = "0000"; // �뿬�윭遺� 鍮꾨�踰덊샇濡� �닔�젙
	
	// DB �뿰寃� �꽕�젙
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(dbServerAddr, user, pswd);
	}
	
	public static Connection getConnection(String dbName) throws SQLException {
		return DriverManager.getConnection(dbServerAddr + dbName, user, pswd);
	}
	
	// DB �뿰寃� �빐�젣
	public static void closeConnection(Connection conn) throws SQLException {
		if (conn != null)
			conn.close();
	}
}
