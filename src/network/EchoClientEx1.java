package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * Echo 클라이언트 프로그램
 * 키보드에서 데이터를 입력받고, 데이터를 서버로 전송
 * 서버의 데이터를 화면 출력
 * 
 * */
public class EchoClientEx1 {
	public static void main(String[] args) {
		int port = 5000;
		String ip = "192.168.4.14";
		Socket client = null;
		PrintWriter out = null;
		BufferedReader br = null;
		try {
			String input;
			//stdin: 키보드에서 문자를 입력받을 수 있는 스트림
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
			//Socket 생성: 
			client = new Socket(ip, port);
			br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintWriter(client.getOutputStream());
			System.out.println("local port:" + client.getLocalPort());
			System.out.println("local ip:" + client.getLocalAddress());
			System.out.println("server port:" + client.getPort());
			System.out.println("server ip:" + client.getInetAddress());
			while ((input = stdin.readLine()) != null) {
				if (input.equals("bye"))
					break;
				out.println(input);
				out.flush();
				//br.readLine() : 서버가 입력한 데이터
				System.out.println("server echo:" + br.readLine());
				System.out.println("메시지 입력");
			}
			out.close();
			br.close();
			stdin.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}