import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

class ComboExample {
	ComboExample() {
		JFrame f = new JFrame();
		f.getContentPane().setLayout(null);
		final JComboBox<String> combo = new JComboBox<String>();
		final JTextField text = new JTextField();
		text.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String ch = text.getText();
				combo.removeAllItems();
				if (ch.equals("")) {
					combo.setVisible(false);
				} else {
					System.out.println(ch);
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection connect = DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=Asia/Seoul", "root",
								"0000");
						Statement st = connect.createStatement();
						ResultSet rs = st.executeQuery("select 이름 from product");
						while (rs.next()) {
							String name = rs.getString(1);
							if (name.equals("")) {
								combo.addItem("");
								combo.setVisible(false);
							} else {
								combo.addItem(rs.getString(1));
								System.out.println(rs.getString(1));
								combo.setVisible(true);
							}
						}
					} catch (Exception ex) {
					}
				}
			}

			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
			}
		});
		text.setBounds(20, 20, 150, 20);
		combo.setBounds(20, 50, 150, 20);
		f.add(text);
		f.add(combo);

		f.setSize(400, 200);
		f.setVisible(true);
		combo.setVisible(true);

	}

	public static void main(String[] args) {
		new ComboExample();
	}
}