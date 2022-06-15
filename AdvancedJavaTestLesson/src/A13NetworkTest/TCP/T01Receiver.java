package A13NetworkTest.TCP;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class T01Receiver extends Thread {
	private DataInputStream dis;

	public T01Receiver(Socket socket) {
		try {
			dis = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(dis != null) {
			try {
				System.out.println(dis.readUTF());
			}catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
