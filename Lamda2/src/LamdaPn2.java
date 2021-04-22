public class LamdaPn2 {
	public static void main(String[] args) {
		FunctionalInterE fi;
	    FunctionalInterR fir;		
	    //매개변수가 있는 람다식 사용  ①
	    fi = (x, y) -> { 
	       int sum = x + y;
	       System.out.println("매개변수가 있는 람다식 사용 - 두 수의 합 : " + sum); };
	       fi.method(10, 30);
			
	       //매개변수가 있고, 반환값이 있는 람다식 사용  ②
	       fir = (x, y) -> { 
		int result = x + y;
		return result;
	         };
	         System.out.println("매개변수가 있고 반환값이 있는 람다식 사용 - 두 수의 합 : " + fir.method(20, 30));

		}
	}


