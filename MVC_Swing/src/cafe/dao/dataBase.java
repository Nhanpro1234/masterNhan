package cafe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class dataBase {
	private Connection conn = null;
	
	public Connection conn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmcafes?useUnicode=true&characterEncoding=utf8", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(conn != null) {
			return conn;
		}
		
		return conn;
	}
	
	public void disconect(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
