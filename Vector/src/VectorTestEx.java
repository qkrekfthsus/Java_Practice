import java.util.*;
public class VectorTestEx {

	public static void main(String[] args) {
		Vector<EmpInfo> vector = new Vector<>();
		vector.add(new EmpInfo("홍길동", "010-3221-6789","서울 은평구"));
		vector.add(new EmpInfo("이근형", "010-3253-1234","서울 구로구"));
		vector.add(new EmpInfo("이명박", "010-5234-5222","서울 연등포구"));
	      				
		System.out.println("벡터의 크기 : " + vector.size());
		System.out.println("벡터의 저장용량 : " + vector.capacity());
			 
		vector.remove(2);
		System.out.println();
		for(int i=0; i<vector.size(); i++) {
			EmpInfo info = vector.get(i);
			System.out.println(info.name + "\t" + info.tel + "\t" + info.address);			
		}			 
	}
}
