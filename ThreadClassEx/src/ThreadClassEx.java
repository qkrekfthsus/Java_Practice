public class ThreadClassEx extends Thread{
	int delay;								//지연시간
	ThreadClassEx(String name, int delay){	//생성자
		super(name);
		this.delay= delay;					//delay set
	}
	public void run() {
		try {
			for(int i = 0; i < 5; i++) {
				sleep(delay);				//sleep(지연시간(단위 : ms))
				System.out.println(getName());	//getName() : 쓰레드의 이름 반환
			}
		}catch(Exception e) {System.out.println("error");return;}
	}
}
