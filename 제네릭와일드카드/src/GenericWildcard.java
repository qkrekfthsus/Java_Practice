import java.util.*;
public class GenericWildcard {

	public static void main(String[] args) {
		Vector<String> carlist = new Vector<>();
		carlist.add("소나타");
		carlist.add("아반떼");
		carlist.add("그랜져");
		carlist.add("제네시스");
		
		
		Vector<? extends Object> objectlist;   //와일드카드 사용
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
