package A13NetworkTest.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class T01UdpClient {
	private DatagramSocket ds;
	private DatagramPacket dp;

	private byte[] msg;

	public T01UdpClient() {
		try {
			msg = new byte[100];
			// 소켓 객체 생성(포트번호 명시하지 않으면 포트번호는 사용가능한 임의의 포트번호 할당)
			ds = new DatagramSocket();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void start() {
		try {
			InetAddress serverAddr = InetAddress.getByName("192.168.141.3");
			dp = new DatagramPacket(msg, 1, serverAddr, 8888);
			ds.send(dp); // 패킷 전송
			dp = new DatagramPacket(msg, msg.length);
			ds.receive(dp); // 패킷 수신 대기
			//String str = new String(dp.getData());
			System.out.println("서버의 현재시간 : " + new String(dp.getData()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new T01UdpClient().start();
		}
}
