public class Main {
	public static void main(String[] args) {
		ThreadClassEx t1 = new ThreadClassEx("������1", 300);
		ThreadClassEx t2 = new ThreadClassEx("������2", 800);
		ThreadClassEx t3 = new ThreadClassEx("������3", 400);
		t1.start();
		t2.start();
		t3.start();
	}
}
