package chap18;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* InputStream 을 이용하여 다른 프로세스의 결과를 출력하기 
 * 
 * Process : 다른 프로세스를 지정.
 * */
public class ProcessEx1 {
	public static void main(String[] args) throws IOException {
		// Runtime.getRuntime(). : OS로부터 프로세스의 실행 권한을 얻음.
		// exec(프로세스명) : 프로세스 실행.
		Process p = Runtime.getRuntime().exec("ping 172.30.1.254");
		// p.getInputStream() : 입력스트림.
		// 프로세스가 전달하는 데이터를 읽을 수 있는 객체
		Reader r = new InputStreamReader(p.getInputStream());
		int data = 0;
		while ((data = r.read()) != -1)
			System.out.print((char) data);
		p = Runtime.getRuntime().exec("notepad.exe");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		p.destroy(); // p 프로세스를 강제로 종료
	}
}
