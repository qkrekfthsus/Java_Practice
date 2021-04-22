public class RunnableThread extends Thread{
	String word;
	RunnableThread(String word){
		this.word = word;
	}
	public void run() {
		try {
			while(true) {
				System.out.println(word + " ");
			}
		}catch(Exception e) {}
	}
	public static void main(String[] args) {
		RunnableThread t1 = new RunnableThread("������1");
		RunnableThread t2 = new RunnableThread("������2");
		t1.start();
		t2.start();
	}

}
