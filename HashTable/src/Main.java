import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("공백은 분리된 이름과 전화번호 4개를 입력하시오");
		Map<String, String> ht = new Hashtable<>(); // Hash Table 선언
		Scanner scanner = new Scanner(System.in); // Scanner 선언
		for (int i = 0; i < 4; i++) {
			System.out.print("이름 , 전화번호 :");
			String name = scanner.next(); // 이름을 입력받음
			String number = scanner.next(); // 전화번호를 입력받음
			ht.put(name, number); // Hash Table 에 저장
		}

		System.out.println("전화번호를 검색할 이름을 입력하시오.");
		String fname = scanner.next(); // Key값 입력

		if (ht.containsKey(fname)) {
			System.out.println(fname + "의 전화번호는 " + ht.get(fname) + "입니다.");
			// Value값 출력
		} else {
			System.out.println("등록되지 않은 이름입니다." + fname); // 이름이 없을 때
		}

		scanner.close();
	}

}
