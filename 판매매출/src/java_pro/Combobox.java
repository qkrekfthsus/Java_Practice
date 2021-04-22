package java_pro;

import java.sql. *;
import java.awt. *;
import javax.swing. *;
import java.awt.event. *;


public class Combobox extends JComboBox{
	final JComboBox<String> combo = new JComboBox<String> ();
	
	Combobox(){
		try {
			Class.forName ("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection ("jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=Asia/Seoul", "root", "0000");
			Statement st = connect.createStatement ();
			ResultSet rs = st.executeQuery ( "select 이름 from product");
			combo.removeAllItems ();
            	while (rs.next ()) {
            		String name = rs.getString (1);
            		if (name.equals ( "")) {
            				combo.addItem ("");
            				combo.setVisible (false);
            		}else {
            				combo.addItem (rs.getString (1));
            				System.out.println (rs.getString(1));
            				combo.setVisible (true);
            				}
            		}
		}catch (Exception ex) {
 		}
	}
}
