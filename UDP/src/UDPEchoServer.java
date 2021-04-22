import java.io.*; 
import java.net.*; 
public class UDPEchoServer { 
	public static void main(String[] args) throws IOException { 
		DatagramSocket socket=null; //① 
		DatagramPacket packet; 	int serverPort = 3333; 
		int clientPort; 	byte buf[]; 		String str; 
		try { 
			socket = new DatagramSocket(serverPort); //③ 
			while(true) { //④ 
				buf = new byte[512]; //⑤           
				packet = new DatagramPacket(buf, buf.length); //⑥ 
				System.out.println("서버 준비 완료"); 
				socket.receive(packet); //⑦        
				str = new String(packet.getData()); //⑧ 
				System.out.println("수신된 자료 : " + str); //⑨ 
				InetAddress iadr = packet.getAddress(); //⑩ 
				clientPort = packet.getPort(); //⑪ 
				System.out.println("클라이언트 IP : " + iadr + " 클라이언트 포트 : " + clientPort); //⑫ 
				packet = new DatagramPacket(packet.getData(), packet.getData().length, iadr, clientPort); //⑬ 
				socket.send(packet);
			}
			}catch(IOException e) { 
	e.printStackTrace(); 	} 
		socket.close(); 	  }	} 
