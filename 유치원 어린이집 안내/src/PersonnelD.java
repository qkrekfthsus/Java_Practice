import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PersonnelD extends JFrame{
	Connection conn = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	 JTable table;
	 String title[] = {"어린이집","전화번호","교직원 수","정원","현원"};

	PersonnelD(String dname, String dtel){
		super(dname+" 인원 정보");
		DBConnManager dbc = new DBConnManager();
		DefaultTableModel model = new DefaultTableModel(title, 0) {
	         public boolean isCellEditable(int row, int col) {
	            if (col == 0) return false;
	            else return true;
	         }
	      };
	      table = new JTable(model);
		try {
			Class.forName ("com.mysql.cj.jdbc.Driver");
			Connection conn = dbc.getConnection();
			st = conn.prepareStatement("SELECT * FROM `personnel` WHERE `kindergarten_name` = ? AND `kindergarten_tel` = ?");
			st.setString(1, dname);
			st.setString(2, dtel);
			rs = st.executeQuery ();
			 Container contentPane = getContentPane();
		      
			 	 model = (DefaultTableModel) table.getModel();
		         String arr[] = new String[5];
		         while (rs.next()) {
		            arr[0] = rs.getString(1);
		            arr[1] = rs.getString(2);
		            arr[2] = rs.getString(3);
		            arr[3] = rs.getString(4);
		            arr[4] = rs.getString(5);            
		            model.addRow(arr);
		         }
		         contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
		addWindowListener(new WindowAdapter(){
			  public void windowClosing(WindowEvent we){
			  setVisible(false);
			  }
			  }
		  );
	
		
	}

}
