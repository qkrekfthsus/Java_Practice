public class Buffer {
	private int value;
	private boolean aval = false;
	public synchronized int consume(){
		while(aval == false) {
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		notify();	//������ ������ ����
		aval = false;
		return value;
	}
	public synchronized void produce(int d) {
		while(aval == true) {
			try {
				wait();
			}catch(InterruptedException e) {}		
		}
		value = d;
		notify();
		aval = true;
	}
}
