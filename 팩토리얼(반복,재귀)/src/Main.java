
public class Main {

	public static int factorial(int number) {	//¹Ýº¹
		int sum = 1;
		for(int i = 2; i <= number; i++) {
			sum *= i;
		}
		return sum;
	}
	public static int factorial2(int number) {	//Àç±Í
		if(number == 1) {
			return 1;
		}
		else
			return number*factorial2(number-1);
	}
	
	public static void main(String[] args) {
		
		System.out.println("10ÆÑÅä¸®¾óÀº "+factorial(10));
		System.out.println("10ÆÑÅä¸®¾óÀº "+factorial2(10));	
		
	}

}
