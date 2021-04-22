
public class ThreadClassEx extends Thread{
	Passbook psb;
	
	ThreadClassEx(Passbook p){	//ThreadClassEx 생성자
		psb = p;
	}

	public void run() {
		try {
			while(true) {
				synchronized(psb) {	//psb객체를 임계영역으로 선언
					if(psb.money < 9800) {	//9800원씩 뺴므로, 9800원보다 적으면 종료
						break;
					}
					psb.money = psb.money-9800;	//9800원 인출
					System.out.println("9800원을 인출, 남은 잔액 : " + psb.money);//남은 잔액 표시
					if(psb.money < 9800) {
						System.out.println("잔액 부족, 현재 잔액 : " + psb.money + ", 인출 금액 : 9800");	//잔액 부족
						System.out.println("총액은 : " + psb.money);	//총액
						break;	//while문 탈출
					}
				}
			}
		}catch(Exception e) {System.out.println(e.getMessage());return;}
	}
}
