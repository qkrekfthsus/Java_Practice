public class Main {
	public static void main(String[] args) {
		Passbook psb = new Passbook();	//money가 100만인 Passbook 생성
		
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
