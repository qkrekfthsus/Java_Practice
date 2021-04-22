import java.util.*;
public class LinkedListTest {
	public static void main(String[] args) {
		LinkedList<String> llist = new LinkedList<String>();
		ArrayList<String> alist = new ArrayList<String>();
		long sttime; long endtime; long calctime;
		llist.add("end");	alist.add("end");
		sttime = System.nanoTime();
		for(int x = 0; x < 5000; x++) {
			llist.add(0, String.valueOf(x));
		}
		endtime = System.nanoTime();
		calctime = endtime - sttime;
		System.out.println("LinkedList °´Ã¼ »ðÀÔ ÃøÁ¤ ½Ã°£ : " + calctime + " ns");
		sttime = System.nanoTime();
		for(int x = 0; x < 5000; x++) {
			alist.add(0, String.valueOf(x));
		}
		endtime = System.nanoTime();
		calctime = endtime - sttime;
		System.out.println("ArrayList °´Ã¼ »ðÀÔ ÃøÁ¤ ½Ã°£ : " + calctime + " ns");
	}

}
