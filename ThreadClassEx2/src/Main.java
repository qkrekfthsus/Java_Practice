public class Main {
	public static void main(String[] args) {
		Passbook psb = new Passbook();	//money�� 100���� Passbook ����
		
		ThreadClassEx t1 = new ThreadClassEx(psb);
		ThreadClassEx t2 = new ThreadClassEx(psb);
		ThreadClassEx t3 = new ThreadClassEx(psb);
		ThreadClassEx t4 = new ThreadClassEx(psb);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
