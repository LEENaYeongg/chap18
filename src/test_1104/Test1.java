package test_1104;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 1. SImpleWebServerEx2 완성하기

간단한 웹서버 구현하기 : 이미지파일로 처리 되도록 프로그램 작성하기
 1. 파일을 바이트형입력스트림(InputStream)으로 읽기
 2. 클라이언트에 전송시 바이트형출력스트림(OutputStream) 출력하기
 * 
 * */
public class Test1 {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8001); //os한테 8001번 대기하고 바인딩 해라~
		while(true) { //무한반복 하면서 대기
			System.out.println("클라이언트 접속 대기");
			//accept: client의 접속을 기다리다가 연결이 되면, Socket 객체 리턴.
			Socket client = server.accept();
			// 1개의 클라이언트(브라우저) 당 1개의 Thread가 할당.
			HttpThread t = new HttpThread(client);
			t.start();
		}
	}
	static class HttpThread extends Thread {
		private Socket client;
		BufferedReader br;
		OutputStream pw;
//		PrintWriter pw; ==> 문자형
		HttpThread(Socket client){
			this.client = client;
			try { //클라이언트가 전송한 데이터를 입력받음
				br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				pw = client.getOutputStream();
			//	("HTTP/1.0 200 OK\r\nContent-Type:text/html\r\n\r\n".getBytes()); ==> 크롬에서 가능하게 하는것.
			}catch(IOException e) {
				e.printStackTrace();
			}
			//연결되어진 내용들을 화면에 출력
			System.out.println("server ip : "+client.getLocalAddress());
			System.out.println("server port : "+client.getLocalPort());
			System.out.println("client ip : "+ client.getInetAddress());
			System.out.println("client port : "+ client.getPort());
					}
		public void run() {
			//파일을 읽기 위한 스트림.
			FileInputStream fbr = null; 
			try {
				//GET /HTTP/1.1
				//GET / Tulips.jpg HTTP/1.1
				//br : 클라이언트의 데이터를 읽기 위한 입력스트림
				String line = br.readLine();
				System.out.println("Http Header : "+line);
				int start = line.indexOf("/") +1;
				int end = line.lastIndexOf("HTTP") -1;
				String filename = line.substring(start,end);
				if(filename.equals("")) filename="index.html"; //빈문자열이면 "index.html" 이것을 파일 이름으로 지정.
				// fbr : 파일을 읽기 위한 입력 스트림
				fbr = new FileInputStream(filename); //reader로 읽어서 이미지는 읽히지 않음. byte 형으로 바꿔야함. => InputStream 사용.
				byte[] buf = new byte[8096]; 
				int len =0;
					while((len = fbr.read(buf)) != -1) {
					pw.write(buf,0,len); // 클라이언트로 데이터 전송 (pw:클라이언트)
					pw.flush();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}finally {
				try {
					if(fbr != null) fbr.close();
					if(br != null) br.close();
					if(pw != null) pw.close();
					if(client != null) client.close();
				}catch(IOException e) {}
			}
		}		
	}
}
	
