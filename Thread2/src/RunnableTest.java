public class RunnableTest implements Runnable{
	public void run() {
		try {
			for(int i = 0; i < 10; i ++) {
				Thread.sleep(200);
				System.out.println("201606947 이종표 RunnableTest : " + String.valueOf(i));
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
    public static void main(String[] args) { 
    	RunnableTest r = new RunnableTest();
    	Thread t = new Thread(r);
    	t.start();
    } 
}



