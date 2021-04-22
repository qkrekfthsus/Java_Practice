public class ThreadClass extends Thread{
	String word;
	ThreadClass(String word){
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
		ThreadClass t1 = new ThreadClass("쓰레드1");
		ThreadClass t2 = new ThreadClass("쓰레드2");
		t1.start();
		t2.start();
	}

}
