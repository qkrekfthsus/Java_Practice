
public class Teacher extends Person{

	private String teacherID;
	private int monthsalary;
	private int workedYear;
	////Getter Setter
	public String getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}
	public int getMonthsalary() {
		return monthsalary;
	}
	public void setMonthsalary(int monthsalary) {
		this.monthsalary = monthsalary;
	}
	public int getWorkedYear() {
		return workedYear;
	}
	public void setWorkedYear(int workedYear) {
		this.workedYear = workedYear;
	}
	////생성자
	public Teacher(String name, int age, int height, int weight, String teacherID, int monthsalary, int workedYear) {
		super(name, age, height, weight);
		this.teacherID = teacherID;
		this.monthsalary = monthsalary;
		this.workedYear = workedYear;
	}
	
	public void show() {
		System.out.println("----------------------------------");
		System.out.println("교사 이름 : " + getName());
		System.out.println("교사 나이 : " + getAge());
		System.out.println("교사 키 : " + getHeight());
		System.out.println("교사 몸무게 : " + getWeight());
		System.out.println("교직원 번호 : " + getTeacherID());
		System.out.println("교사 월급 : " + getMonthsalary());
		System.out.println("교사 연차 : " + getWorkedYear());		
	}
	
}
