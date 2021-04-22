import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//DB �뿰寃� �꽕�젙 諛� �빐�젣
public class DBConnManager {
	static String dbServerAddr = "";
	static String dbName = ""; // �뿬�윭遺� DB �씠由꾩쑝濡� �닔�젙
	static String user = ""; // �뿬�윭遺� 怨꾩젙 �씠由꾩쑝濡� �닔�젙
	static String pswd = ""; // �뿬�윭遺� 鍮꾨�踰덊샇濡� �닔�젙

	// DB �뿰寃� �꽕�젙
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(dbServerAddr + dbName, user, pswd);
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
