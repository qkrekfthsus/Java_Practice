public class Main {
	public static void main(String[] args) {
	
	MethodReferenceTestEx ex = new MethodReferenceTestEx();
	ex.oper((a,b) -> MethodReferenceTestEx.mul(a, b) , 1, 1);
	//���� �޼ҵ� ����
	ex.oper(MethodReferenceTestEx::mul, 1, 1);

	ex.oper((a, b) -> ex.add(a, b),1,1);
	//�ν��Ͻ� �޼ҵ� ����
	ex.oper(ex::add,1,1);
	
	ex.operS(s->s.toLowerCase(), "STRING");
	//�Ű������� �޼ҵ� ����
	ex.operS(String::toLowerCase,"STRING");

	}
}
