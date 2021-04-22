import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
	public static void main(String[] args) throws IOException {

		int port = 3333;
		Socket echoSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		InetAddress iadr = InetAddress.getLocalHost(); // ①
		try {
			echoSocket = new Socket(iadr, port);
			out = new PrintWriter(echoSocket.getOutputStream(), true); // ③
			in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream())); // ④
		} catch (UnknownHostException e) {
			System.err.println("호스트가 잘 못 되었습니다.");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for " + iadr);
			System.exit(1);
		}

		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in)); // 키보드로부터 데이터 입력용으로 생성.
		String userInput;
		while ((userInput = stdIn.readLine()) != null) { // ⑤
			System.out.println(userInput); // ⑥
			System.out.println("echo: " + in.readLine()); // ⑦
		}

		out.close();
		in.close();
		stdIn.close();
		echoSocket.close();
	}
}
