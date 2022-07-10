package studentmgntapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP {
	
	static Connection con;
	
	public static Connection create() {
		
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create connection
			String user="root";
			String pass="vtrias12@";
			String url="jdbc:mysql://localhost:3306/stu_mgnt";
			con=DriverManager.getConnection(url, user, pass);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

}
