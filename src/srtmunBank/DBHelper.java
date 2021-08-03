package srtmunBank;


import javax.swing.JOptionPane;
import java.sql.*;



public class DBHelper {

	public static Connection dbConnect() {
		try {
				//load the Driver for database
			Class.forName("com.mysql.jdbc.Driver");
			Connection dbConnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/srtmun_bank_master_database","root","");
			return dbConnection;
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}

}
