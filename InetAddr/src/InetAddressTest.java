import java.net.*; 
public class InetAddressTest { 
	public static void main(String args[]) throws UnknownHostException { 
		InetAddress iadr; 
		iadr = InetAddress.getLocalHost();
		System.out.println("로컬 호스트 이름 : " + iadr.getHostName()); //② 
		System.out.println("로컬 호스트 IP 주소 : " + iadr.getHostAddress()); //③ 
		iadr = InetAddress.getByName("en.wikipedia.org");
		System.out.println("위키피디아 호스트 이름 : " + iadr.getHostName());
		System.out.println("위키피디아 호스트 IP 주소 : " + iadr.getHostAddress());
		byte[] addr = new byte[4]; //⑦ 
		addr[0] = (byte)208; //⑧ 
		addr[1] = (byte)80;   addr[2] = (byte)152; 
		addr[3] = (byte)2; //⑨ 
		iadr = InetAddress.getByAddress(addr); //⑩    
		System.out.println("줌 호스트 이름 : " + iadr.getHostName()); //⑪ 
		System.out.println("줌 호스트 이름 : " + iadr.getCanonicalHostName()); // ⑫ 
		System.out.println("줌 호스트 IP 주소 : " + iadr.getHostAddress()); 
		InetAddress iadrArray[];
		iadrArray = InetAddress.getAllByName("www.naver.com"); //⑭ 
		for (InetAddress seq : iadrArray) { //⑮ 
			System.out.println("네이버 호스트 이름 : " + seq.getHostName()); 
			System.out.println("네이버 호스트 IP 주소 : " + seq.getHostAddress());
		}
	}
}
