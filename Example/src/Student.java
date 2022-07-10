
public class Student {

	private int studentId;
	private String name;
	private String subject;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int studentId, String name, String subject) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.subject = subject;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", subject=" + subject + "]";
	}
	
}
