public class ThreadTest extends Thread{

	public void run() {
		try {
			for(int i = 0; i < 10; i++) {
				Thread.sleep(200);
				System.out.println("20160947 이종표 ThreadTest : " + String.valueOf(i));
			}
		}catch(InterruptedException e) {
			System.out.println(e);
		}
	}
    public static void main(String[] args) { 
    	ThreadTest t = new ThreadTest();
    	t.start();
    } 
}


