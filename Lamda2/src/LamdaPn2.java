public class LamdaPn2 {
	public static void main(String[] args) {
		FunctionalInterE fi;
	    FunctionalInterR fir;		
	    //�Ű������� �ִ� ���ٽ� ���  ��
	    fi = (x, y) -> { 
	       int sum = x + y;
	       System.out.println("�Ű������� �ִ� ���ٽ� ��� - �� ���� �� : " + sum); };
	       fi.method(10, 30);
			
	       //�Ű������� �ְ�, ��ȯ���� �ִ� ���ٽ� ���  ��
	       fir = (x, y) -> { 
		int result = x + y;
		return result;
	         };
	         System.out.println("�Ű������� �ְ� ��ȯ���� �ִ� ���ٽ� ��� - �� ���� �� : " + fir.method(20, 30));

		}
	}


