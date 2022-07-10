package studentmgntapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.out.println("Welcom to Student management application");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("Press 1 to add student");
			System.out.println("Press 2 to delete student");
			System.out.println("Press 3 to display student");
			System.out.println("Press 4 to exit");
			int c=Integer.parseInt(br.readLine());
			
			if(c==1) {
				//Add student
				System.out.println("Enter user name :");
				String name=br.readLine();
				
				System.out.println("Enter user phone");
				String phone=br.readLine();
				
				System.out.println("Enter user city");
				String city=br.readLine();
				
				//create student object to store
				Student stu=new Student(name,phone,city);
				
				boolean ans=StudentDao.insertStudentToDB(stu);
				
				if(ans) {
					System.out.println("Student added successfully");
					System.out.println(stu);
				}else {
					System.out.println("Something went wrong try again");
				}
				
			}else if(c==2){
				
				System.out.println("Enter student id to delete :");
				int userId=Integer.parseInt(br.readLine());
				boolean f=StudentDao.deleteStudent(userId);
				
				if(f) {
					System.out.println("Student deleted successfully");
					
				}else {
					System.out.println("Something went wrong try again");
				}
				
			}else if(c==3) {
				
		          StudentDao.showAllStudents();
				
			}else if(c==4) {
				
				break;
			}else {
				
			}
			
		}
		System.out.println("Thanks for visiting our application");
		System.out.println("Have a great day....Comeback soon");

	}

}
