
public class GenericMethodEx {

	public static void main(String[] args) {
		GenericClass<String> gmex1 = Utility.gmove("�ڹ� 2");
		String strValue = gmex1.getTparam();
		System.out.println("ù��° ȣ���� : " + strValue);

		GenericClass<Integer> gmex2 = Utility.gmove(200);
		int intValue = gmex2.getTparam();
		System.out.println("�ι�° ȣ���� : " + intValue);
	}

}
