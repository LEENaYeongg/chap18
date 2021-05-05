package network;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/* 
 * ������ ������ �����ϱ�
 * */
public class SimpleWebServerEx1 {
	public static void main(String[] args) throws IOException {
		//8000 ��Ʈ  ���� ��� ��. OS�κ��� 8000�� ��Ʈ�� �Ҵ����.(binding)
		ServerSocket server = new ServerSocket(8000);
		while(true) {
			System.out.println("Ŭ���̾�Ʈ ���� ���");
			//accept :  client�� ������ ��ٸ��� ��.
			//Socket : Ŭ���̾�Ʈ�� ������ ������ ������ accept��
			Socket client = server.accept();
			HttpThread t = new HttpThread(client);
			t.start();
		}
	}
	static class HttpThread extends Thread {
		private Socket client;
		BufferedReader br;
		PrintWriter pw;
		HttpThread(Socket client){
			this.client = client;
			try {
				br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				pw = new PrintWriter(client.getOutputStream());
			}catch(IOException e) {
				e.printStackTrace();
			}
			System.out.println("server ip : "+client.getLocalAddress());
			System.out.println("server port : "+client.getLocalPort());
			System.out.println("client ip : "+ client.getInetAddress());
			System.out.println("client port : "+ client.getPort());
					}
		public void run() {
			BufferedReader fbr = null;
			try {
				//GET /HTTP/1.1
				//GET / Tulips.jpg HTTP/1.1
				//br : Ŭ���̾�Ʈ�� �����͸� �б� ���� �Է½�Ʈ��
				String line = br.readLine();
				System.out.println("Http Header : "+line);
				int start = line.indexOf("/") +1;
				int end = line.lastIndexOf("HTTP") -1;
				String filename = line.substring(start,end);
				if(filename.equals("")) filename="index.html"; //���ڿ��̸� "index.html" �̰��� ���� �̸����� ����.
				// fbr : ������ �б� ���� �Է� ��Ʈ��
				fbr = new BufferedReader(new FileReader(filename)); //reader�� �о �̹����� ������ ����. byte ������ �ٲ����.
				String fline = null;
					while((fline = fbr.readLine()) != null) {
					pw.println(fline); // Ŭ���̾�Ʈ�� ������ ���� (pw:Ŭ���̾�Ʈ)
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
