package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/* EchoServer 구현하기
 * 클라이언트에서 받은 데이터를 그대로 클라이언트로 전송함.
 * */
public class EchoServerEx1 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(5000);
			while(true) {
				System.out.println("클라이언트 접속 대기");
				Socket client = server.accept(); //accept : 대기(Socket을 받으려고 준비)
				ServerThread th = new ServerThread(client);
				th.start();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
class ServerThread extends Thread{
	private Socket client;
	PrintWriter out;
	BufferedReader br;
	ServerThread(Socket client){
		this.client = client;
		System.out.println("client ip :"+client.getInetAddress());
		System.out.println("client port :"+client.getPort());
		try {
			out=new PrintWriter(client.getOutputStream());
			br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		String input;
		try {
			while((input = br.readLine()) != null) {
				out.println(input);
				out.flush();
				System.out.println("client data : "+ input);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
