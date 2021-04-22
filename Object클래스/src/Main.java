
public class Main{

	public static void main(String[] args) {
		
		Archer archer1 = new Archer("궁수1","상");
		Archer archer2 = new Archer("궁수1","상");
		System.out.println(archer1 == archer2);	//다른인스턴스라서 false
		System.out.println(archer1.equals(archer2));	//인스턴스의 내부값을 비교하기때문에 true
	}

}
