
public class GenericTrans {
	public static void main(String[] args) {
		GenericClass<String> gcs = new GenericClass<>();
		gcs.setTparam("���׸� Ŭ����");
		System.out.println("��ȯ �� -> " + gcs.getTparam());
				
		GenericClass<Integer> gci = new GenericClass<Integer>();
		gci.setTparam(125);
		System.out.println("��ȯ �� -> " + gci.getTparam());
				
		GenericClass<Double> gcd = new GenericClass<Double>();
		gcd.setTparam(18.5);
		System.out.println("��ȯ �� -> " + gcd.getTparam());
		}

	}

