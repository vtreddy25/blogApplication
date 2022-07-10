package studentmgntapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDao {
	
	public static boolean insertStudentToDB(Student st) {
		
		
		boolean f=false;
		//Jdbc code
		Connection con=CP.create();
		String q="insert into students(sname,sphone,scity) values(?,?,?)";
		//prepared statement
		try {
			PreparedStatement psmt=con.prepareStatement(q);
			
			//set the values of parameter
			psmt.setString(1, st.getStuName());
			psmt.setString(2, st.getStuPhone());
			psmt.setString(3, st.getStuCity());
			
			//execute query
			psmt.executeUpdate();
			f=true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	public static boolean deleteStudent(int userId) {
	    

		boolean f=false;
		//Jdbc code
		Connection con=CP.create();
		String q="delete from students where sid=?";
		//prepared statement
		try {
			PreparedStatement psmt=con.prepareStatement(q);
			
			//set the values of parameter
			psmt.setInt(1,userId);
			
			
			//execute query
			psmt.executeUpdate();
			f=true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
		
	}

	public static void showAllStudents() {
		
		boolean f=false;
		//Jdbc code
		Connection con=CP.create();
		String q="select * from students;";
		//prepared statement
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(q);
			
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String phone=rs.getString(3);
				String city=rs.getString(4);
				System.out.println("ID :"+id);
				System.out.println("Name :"+name);
				System.out.println("Phone :"+phone);
				System.out.println("City :"+city);
				System.out.println("---------------------------------");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
