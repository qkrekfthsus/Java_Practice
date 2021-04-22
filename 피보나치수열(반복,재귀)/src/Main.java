
public class Main {

	public static int fibonacci(int number){	//반복
		int one = 1;
		int two = 1;
		int result = -1;
		if(number == 1) {
			return one;
		}
		else if(number == 2){
			return two;
		}
		else{
			for(int i = 2; i < number; i++){
				result = one + two;
				one = two;
				two = result;
			}
		}
		return result;
	}
	
	public static int fibonacci2(int number) {	//재귀(number가 커질수록 함수 호출이 많아짐)
		if(number == 1) {
			return 1;
		}
		else if(number == 2) {
			return 1;
		}
		else {
			return fibonacci2(number - 1) + fibonacci2(number - 2);
		}
	
	}
	
	public static void main(String[] args) {
		
		System.out.println("피보나치 수열의 10번째 원소는 "+fibonacci(10)+"입니다.");
		System.out.println("피보나치 수열의 10번째 원소는 "+fibonacci2(10)+"입니다.");
		
	}

}
