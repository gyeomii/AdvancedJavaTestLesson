package A13NetworkTest.http;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 간단한 웹서버 예제
 * 
 * @author "Gyeom"
 *
 */
public class T01MyHTTPServer {
	private final int port = 80;
	private final String encoding = "UTF-8";

	// 시작 메서드
	public void start() {
		System.out.println("HTTP 서버가 시작되었습니다.");
		try (ServerSocket server = new ServerSocket(this.port)) {

			while (true) {
				try {
					Socket socket = server.accept();
					HttpHandler handler = new HttpHandler(socket);
					
					new Thread(handler).start(); //요청 처리 시작
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	/**
	 * HTTP 요청 처리를 위한 Runnable 클래스
	 * @author "Gyeom"
	 */
	private class HttpHandler implements Runnable {
		private final Socket socket;

		public HttpHandler(Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {
			OutputStream out = null;
			BufferedReader br = null;
			
			try {
				out = new BufferedOutputStream(socket.getOutputStream());
				//바이트 기반 InputStream을 (socket.getInputStream)
				//문자 기반 으로 바꿔주기 위해 InputStream을 사용
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				//요청헤더 정보 파싱하기
				StringBuilder sb = new StringBuilder();
				while(true) {
					String str = br.readLine();
					
					if(str.equals("")) break; //empty line 체크
					
					sb.append(str + "\n");
				}
				
				//헤더 정보(Request Line + Header)
				String reqHeaderStr = sb.toString();
				
				System.out.println("요청 헤더 : \n" + reqHeaderStr);
				System.out.println("======================================");
				
			}catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					//소켓 연결 끊기
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	public static void main(String[] args) {
		new T01MyHTTPServer().start();
	}
}
