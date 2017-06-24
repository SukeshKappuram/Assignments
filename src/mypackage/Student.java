package mypackage;

public class Student {
	private int studentId;
	private String studentName;
	private float marks;
	
	char grade;
	
	public Student(){
		System.out.println("I am Student cons running");
	}
	
	public Student(int studentId,String studentName,float marks){
		System.out.println("I am Student cons running with 3 para");
		this.studentId=studentId;
		this.studentName=studentName;
		this.marks=marks;
	}
	
	public int getStudentId() {
		return studentId;
	}
	protected void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public float getMarks() {
		return marks;
	}
	public void setMarks(float marks) {
		this.marks = marks;
	}
	
	public void display(){
		System.out.println("I am Student");
	}
	
}
