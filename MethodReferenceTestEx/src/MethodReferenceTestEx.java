import java.util.function.*;
public class MethodReferenceTestEx {
	public int add(int a, int b) {
		return a+b;
	}
	public static int mul(int a, int b) {
		return a*b;
	}
	public void oper(IntBinaryOperator operator, int a, int b) {
		System.out.println("����/�ν��Ͻ� �޼ҵ� ���� : " + operator.applyAsInt(a, b));
	}
	public void operS(Function<String, String> stringOperator, String a) {
		System.out.println("�Ű������� �޼ҵ� ���� : " + stringOperator.apply(a));
	}
}