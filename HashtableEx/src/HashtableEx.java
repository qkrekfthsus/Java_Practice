import java.util.*;
public class HashtableEx {
	public static void main(String[] args) {
		Map<String, String> ht = new Hashtable<>();
		ht.put("Grapes", "포도");		ht.put("Apple", "사과");
		ht.put("Strawberry", "딸기");		ht.put("Orange", "오렌지");
		System.out.println("hashtable의 키의 수 : " + ht.size());
		System.out.println("hashtable의 키로 값을 찾음 :" + ht.get("Apple"));
		System.out.println();
		
		Set<String> keyset = ht.keySet();
		Iterator<String> keyiterator = keyset.iterator();
		while(keyiterator.hasNext()) {
			String k = keyiterator.next();
			String v = ht.get(k);
			System.out.println("키 : " + k + "---> 값 : " + v);
		}
	}
}
