package studentmgntapp;

public class Student {

	private int sid;
	private String stuName;
	private String stuPhone;
	private String stuCity;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int sid, String stuName, String stuPhone, String stuCity) {
		super();
		this.sid = sid;
		this.stuName = stuName;
		this.stuPhone = stuPhone;
		this.stuCity = stuCity;
	}
	public Student(String stuName, String stuPhone, String stuCity) {
		super();
		this.stuName = stuName;
		this.stuPhone = stuPhone;
		this.stuCity = stuCity;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuPhone() {
		return stuPhone;
	}
	public void setStuPhone(String stuPhone) {
		this.stuPhone = stuPhone;
	}
	public String getStuCity() {
		return stuCity;
	}
	public void setStuCity(String stuCity) {
		this.stuCity = stuCity;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", stuName=" + stuName + ", stuPhone=" + stuPhone + ", stuCity=" + stuCity + "]";
	}
	
}
