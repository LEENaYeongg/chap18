package test1105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*숫자 맞추기 클라이언트 구현하기
  1. 키보드로부터 4자리 숫자를 입력하여 서버로 데이터를 전송한다.
  2. 서버에서 전송한 결과를 화면에 출력한다.
  3. 서버에서 종료 문자가 오면 프로그램을 종료한다.
 * */
public class Client {
	public static void main(String[] args) throws IOException {
		Socket client = new Socket("172.30.1.6", 9000);
		// 1. 키보드 입력 스트림
		BufferedReader sysin = new BufferedReader(new InputStreamReader(System.in));
		// 2. 서버에서 데이터를 받을 입력 스트림
		BufferedReader sbr = new BufferedReader(new InputStreamReader(client.getInputStream()));
		// 3. 서버로 데이터를 전송할 스트림
		PrintWriter sw = new PrintWriter(client.getOutputStream());

		while (true) {
			System.out.println("4자리의 서로다른 숫자를 입력하세요");
			String number = sysin.readLine();
			sw.println(number);
			sw.flush();
			String data = sbr.readLine();
			System.out.println(data);
			if (data.indexOf("종료") >= 0)
				break;
		}
		sysin.close();
		sbr.close();
		sw.close();
		client.close();
	}
}
