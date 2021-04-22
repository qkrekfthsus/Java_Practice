public class Main {
	public static void main(String[] args) {
	
	MethodReferenceTestEx ex = new MethodReferenceTestEx();
	ex.oper((a,b) -> MethodReferenceTestEx.mul(a, b) , 1, 1);
	//정적 메소드 참조
	ex.oper(MethodReferenceTestEx::mul, 1, 1);

	ex.oper((a, b) -> ex.add(a, b),1,1);
	//인스턴스 메소드 참조
	ex.oper(ex::add,1,1);
	
	ex.operS(s->s.toLowerCase(), "STRING");
	//매개변수의 메소드 참조
	ex.operS(String::toLowerCase,"STRING");

	}
}
