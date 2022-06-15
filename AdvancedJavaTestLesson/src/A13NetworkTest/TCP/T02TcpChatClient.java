package A13NetworkTest.TCP;

import java.io.IOException;
import java.net.Socket;

public class T02TcpChatClient {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("192.168.141.16", 7777);
			
			System.out.println("서버에 연결 되었습니다.\\(^@^)/");
			
			T01Sender sender = new T01Sender(socket);
			T01Receiver receiver = new T01Receiver(socket);
			
			sender.start();
			receiver.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}