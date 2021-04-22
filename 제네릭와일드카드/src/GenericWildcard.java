import java.util.*;
public class GenericWildcard {

	public static void main(String[] args) {
		Vector<String> carlist = new Vector<>();
		carlist.add("�ҳ�Ÿ");
		carlist.add("�ƹݶ�");
		carlist.add("�׷���");
		carlist.add("���׽ý�");
		
		
		Vector<? extends Object> objectlist;   //���ϵ�ī�� ���
		objectlist = carlist;
		
		
		for(Object obj : objectlist) {
			System.out.print(obj + "  ");
		}
		
		
		System.out.println();
		for(Object obj : objectlist) {
			String car = (String)obj;
			System.out.print(car.toUpperCase() + "  ");
		}
	}

}
