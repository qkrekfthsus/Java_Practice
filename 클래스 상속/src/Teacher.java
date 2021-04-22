
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
	////������
	public Teacher(String name, int age, int height, int weight, String teacherID, int monthsalary, int workedYear) {
		super(name, age, height, weight);
		this.teacherID = teacherID;
		this.monthsalary = monthsalary;
		this.workedYear = workedYear;
	}
	
	public void show() {
		System.out.println("----------------------------------");
		System.out.println("���� �̸� : " + getName());
		System.out.println("���� ���� : " + getAge());
		System.out.println("���� Ű : " + getHeight());
		System.out.println("���� ������ : " + getWeight());
		System.out.println("������ ��ȣ : " + getTeacherID());
		System.out.println("���� ���� : " + getMonthsalary());
		System.out.println("���� ���� : " + getWorkedYear());		
	}
	
}
