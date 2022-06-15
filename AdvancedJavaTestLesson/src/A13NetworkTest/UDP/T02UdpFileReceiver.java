package A13NetworkTest.UDP;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class T02UdpFileReceiver {
	private DatagramSocket ds;
	private DatagramPacket dp;

	private byte[] buffer;

	public T02UdpFileReceiver(int port) {
		try {
			ds = new DatagramSocket(port);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 바이트 배열 수신하기
	 * @return
	 * @throws IOException
	 */
	private byte[] receiveData() throws IOException {
		buffer = new byte[1000]; //버퍼 초기화
		
		dp = new DatagramPacket(buffer, buffer.length);
		ds.receive(dp);
		
		return dp.getData();
	}
	
	public void start() throws IOException {
		long fileSize = 0;
		long totalReadBytes = 0;
		
		int readBytes = 0;
		
		System.out.println("파일 수신 대기 중");
		
		String str = new String(receiveData()).trim();
		
		if(str.equals("start")) { // Sender에서 전송을 시작한 경우
			//파일명 받기
			str = new String(receiveData()).trim();
			FileOutputStream fos = new FileOutputStream("d:/C_Lib/" + str);
			
			//파일크기 (bytes) 받기
			str = new String(receiveData()).trim();
			fileSize = Long.parseLong(str);
			
			long startTime = System.currentTimeMillis();
			
			while(true) {
				byte[] data = receiveData();
				readBytes = dp.getLength(); // 받은 데이터의 길이
				fos.write(data, 0, readBytes);
				
				totalReadBytes += readBytes;
				System.out.println("진행상태 : " + totalReadBytes + "/" + fileSize + "Bytes ("
						+ (totalReadBytes * 100 / fileSize) + "%)");
				
				if(totalReadBytes >= fileSize) {
					break;
				}
			}
			
			long endTime = System.currentTimeMillis();
			long diffTime = endTime - startTime;
			double transferSpeed = fileSize / diffTime;
			
			System.out.println("소요시간 : " + diffTime  + "(ms)");
			System.out.println("평균 수신 속도 : " + transferSpeed + " Bytes/ms");
			System.out.println("수신 완료");
			
			fos.close();
			ds.close();
		}
	}
	
	public static void main(String[] args) throws IOException {
		new T02UdpFileReceiver(8888).start();
	}
}
