
public class Main {

	public static void main(String[] args) {
		
		Student student1 = new Student("È«±æµ¿",20,175,70,"20170101",1,4.5);
		Student student2 = new Student("ÀÌ¼ø½Å",30,170,80,"20090505",4,3.0);

		student1.show();
		student2.show();
		/*
		Student[] studnets = new Student[100];
		for(int i = 0; i < 100; i++) {
			studnets[i] = new Student("È«±æµ¿",20,175,70,i+"",1,4.5);
			studnets[i].show();
		}
		*/
		Teacher teacher1 = new Teacher("John Doe",25,180,120,"ABC201",3000000,5);
		teacher1.show();
		
		
	}

}
