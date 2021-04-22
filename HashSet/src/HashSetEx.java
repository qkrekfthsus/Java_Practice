import java.util.*;
public class HashSetEx {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();
	    set.add("VB");        set.add("JAVA");
	    set.add("VB");        set.add("C");
	    System.out.println("set의 데이터 개수 : " + set.size());
	    set.remove("C");
	    System.out.println("set의 데이터 개수 : " + set.size());
	    Iterator<String> iterator = set.iterator(); //반복자 얻기
	    while(iterator.hasNext()) {
	    	String element = iterator.next();
	    	System.out.println("\t" + element);
	    }
	    /* 향상된 for문 사용 -> 결과는 같다*/
	      for(String str:set) {
	         System.out.println("\t" + str); 
	      }        
	}

}
