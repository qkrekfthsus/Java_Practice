public class Consumer extends Thread {
	private Buffer b;
	public Consumer(String name, Buffer b) {
		super(name);
		this.b = b;
	}
	public void run() {
		int consumerD;
		for(int i = 0; i < 5; i++) {
			consumerD = b.consume();
			System.out.println(getName() + " : ¼Òºñ = " + consumerD);
		}
	}
}
