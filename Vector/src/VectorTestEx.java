import java.util.*;
public class VectorTestEx {

	public static void main(String[] args) {
		Vector<EmpInfo> vector = new Vector<>();
		vector.add(new EmpInfo("ȫ�浿", "010-3221-6789","���� ����"));
		vector.add(new EmpInfo("�̱���", "010-3253-1234","���� ���α�"));
		vector.add(new EmpInfo("�̸��", "010-5234-5222","���� ��������"));
	      				
		System.out.println("������ ũ�� : " + vector.size());
		System.out.println("������ ����뷮 : " + vector.capacity());
			 
		vector.remove(2);
		System.out.println();
		for(int i=0; i<vector.size(); i++) {
			EmpInfo info = vector.get(i);
			System.out.println(info.name + "\t" + info.tel + "\t" + info.address);			
		}			 
	}
}
