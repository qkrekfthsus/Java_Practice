
public class Main implements Dog, Cat{

	public static void main(String[] args) {		
	
		Main main = new Main();
		main.crying();
		main.one();
		main.two();
	}

	@Override
	public void crying() {
		System.out.println("¿ù! ¿ù!");
	}

	@Override
	public void one() {
		System.out.println("One!");
	}

	@Override
	public void two() {
		System.out.println("Two!");
	}


}
