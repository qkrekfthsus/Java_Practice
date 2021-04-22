import java.util.*;
public class HashSetEx {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();
	    set.add("VB");        set.add("JAVA");
	    set.add("VB");        set.add("C");
	    System.out.println("set�� ������ ���� : " + set.size());
	    set.remove("C");
	    System.out.println("set�� ������ ���� : " + set.size());
	    Iterator<String> iterator = set.iterator(); //�ݺ��� ���
	    while(iterator.hasNext()) {
	    	String element = iterator.next();
	    	System.out.println("\t" + element);
	    }
	    /* ���� for�� ��� -> ����� ����*/
	      for(String str:set) {
	         System.out.println("\t" + str); 
	      }        
	}

}
