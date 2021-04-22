
public class GenericMethodEx {

	public static void main(String[] args) {
		GenericClass<String> gmex1 = Utility.gmove("자바 2");
		String strValue = gmex1.getTparam();
		System.out.println("첫번째 호출방식 : " + strValue);

		GenericClass<Integer> gmex2 = Utility.gmove(200);
		int intValue = gmex2.getTparam();
		System.out.println("두번째 호출방식 : " + intValue);
	}

}
