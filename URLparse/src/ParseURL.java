import java.net.*; 
import java.io.*; 
public class ParseURL { 
	public static void main(String[] args) throws IOException { 
		URL aURL = new URL("http://java.sun.com:80/docs/books/tutorial" 
	+ "/index.html?name=networking#DOWNLOADING"); 
		System.out.println("프로토콜 = " + aURL.getProtocol()); 
		System.out.println("호스트와 포트 = " + aURL.getAuthority()); 
		System.out.println("호스트 = " + aURL.getHost()); 
		System.out.println("포트 = " + aURL.getPort()); 
		System.out.println("경로 = " + aURL.getPath()); 
		System.out.println("질의 = " + aURL.getQuery()); 
		System.out.println("파일명 = " + aURL.getFile()); 
		System.out.println("참조 = " + aURL.getRef()); 

	} 
}  
