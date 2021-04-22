
public class ThreadClassEx extends Thread{
	Passbook psb;
	
	ThreadClassEx(Passbook p){	//ThreadClassEx ������
		psb = p;
	}

	public void run() {
		try {
			while(true) {
				synchronized(psb) {	//psb��ü�� �Ӱ迵������ ����
					if(psb.money < 9800) {	//9800���� ���Ƿ�, 9800������ ������ ����
						break;
					}
					psb.money = psb.money-9800;	//9800�� ����
					System.out.println("9800���� ����, ���� �ܾ� : " + psb.money);//���� �ܾ� ǥ��
					if(psb.money < 9800) {
						System.out.println("�ܾ� ����, ���� �ܾ� : " + psb.money + ", ���� �ݾ� : 9800");	//�ܾ� ����
						System.out.println("�Ѿ��� : " + psb.money);	//�Ѿ�
						break;	//while�� Ż��
					}
				}
			}
		}catch(Exception e) {System.out.println(e.getMessage());return;}
	}
}
