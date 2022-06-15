package A13NetworkTest.UDP;

import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPFileSender {
	private DatagramSocket ds;
	private DatagramPacket dp;
	
	private InetAddress receiverAddr;
	private int port;
	private File file;
	
	public UDPFileSender(String receiverIp, int port) {
		try {
			ds = new DatagramSocket();
			this.port = port;
			this.receiverAddr = InetAddress.getByName(receiverIp);
			
			if(!file.exists()) {
				System.out.println("해당 파일이 존재하지 않습니다.");
				System.exit(0);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void start() {
		
		long fileSize = file.length();
		long totalReadBytes = 0;
		
		long startTime = System.currentTimeMillis();
		
		try {
			//전송시작을 알려주기 위한 문자열 전송
			sendData("start".getBytes()); 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 바이트 배열 데이터 전송하기
	 * @param bytes 전송할 바이트 배열
	 * @throws IOException 
	 */
	private void sendData(byte[] bytes) throws IOException {
		sendData(bytes, bytes.length);
	}
	
	/**
	 * 바이트 배열 데이터 전송하기
	 * @param bytes 전송할 바이트 배열
	 * @param length 전송할 실제 사이즈
	 * @throws IOException
	 */
	private void sendData(byte[] bytes, int length) throws IOException {
		dp = new DatagramPacket(bytes, length, receiverAddr, port);
		ds.send(dp);
	}
}
