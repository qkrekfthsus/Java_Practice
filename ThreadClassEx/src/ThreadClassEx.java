public class ThreadClassEx extends Thread{
	int delay;								//�����ð�
	ThreadClassEx(String name, int delay){	//������
		super(name);
		this.delay= delay;					//delay set
	}
	public void run() {
		try {
			for(int i = 0; i < 5; i++) {
				sleep(delay);				//sleep(�����ð�(���� : ms))
				System.out.println(getName());	//getName() : �������� �̸� ��ȯ
			}
		}catch(Exception e) {System.out.println("error");return;}
	}
}
