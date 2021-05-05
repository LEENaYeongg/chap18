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
 * 1. SImpleWebServerEx2 �ϼ��ϱ�

������ ������ �����ϱ� : �̹������Ϸ� ó�� �ǵ��� ���α׷� �ۼ��ϱ�
 1. ������ ����Ʈ���Է½�Ʈ��(InputStream)���� �б�
 2. Ŭ���̾�Ʈ�� ���۽� ����Ʈ����½�Ʈ��(OutputStream) ����ϱ�
 * 
 * */
public class Test1 {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8001); //os���� 8001�� ����ϰ� ���ε� �ض�~
		while(true) { //���ѹݺ� �ϸ鼭 ���
			System.out.println("Ŭ���̾�Ʈ ���� ���");
			//accept: client�� ������ ��ٸ��ٰ� ������ �Ǹ�, Socket ��ü ����.
			Socket client = server.accept();
			// 1���� Ŭ���̾�Ʈ(������) �� 1���� Thread�� �Ҵ�.
			HttpThread t = new HttpThread(client);
			t.start();
		}
	}
	static class HttpThread extends Thread {
		private Socket client;
		BufferedReader br;
		OutputStream pw;
//		PrintWriter pw; ==> ������
		HttpThread(Socket client){
			this.client = client;
			try { //Ŭ���̾�Ʈ�� ������ �����͸� �Է¹���
				br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				pw = client.getOutputStream();
			//	("HTTP/1.0 200 OK\r\nContent-Type:text/html\r\n\r\n".getBytes()); ==> ũ�ҿ��� �����ϰ� �ϴ°�.
			}catch(IOException e) {
				e.printStackTrace();
			}
			//����Ǿ��� ������� ȭ�鿡 ���
			System.out.println("server ip : "+client.getLocalAddress());
			System.out.println("server port : "+client.getLocalPort());
			System.out.println("client ip : "+ client.getInetAddress());
			System.out.println("client port : "+ client.getPort());
					}
		public void run() {
			//������ �б� ���� ��Ʈ��.
			FileInputStream fbr = null; 
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
				fbr = new FileInputStream(filename); //reader�� �о �̹����� ������ ����. byte ������ �ٲ����. => InputStream ���.
				byte[] buf = new byte[8096]; 
				int len =0;
					while((len = fbr.read(buf)) != -1) {
					pw.write(buf,0,len); // Ŭ���̾�Ʈ�� ������ ���� (pw:Ŭ���̾�Ʈ)
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
	
