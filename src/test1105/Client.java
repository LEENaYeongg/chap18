package test1105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*���� ���߱� Ŭ���̾�Ʈ �����ϱ�
  1. Ű����κ��� 4�ڸ� ���ڸ� �Է��Ͽ� ������ �����͸� �����Ѵ�.
  2. �������� ������ ����� ȭ�鿡 ����Ѵ�.
  3. �������� ���� ���ڰ� ���� ���α׷��� �����Ѵ�.
 * */
public class Client {
	public static void main(String[] args) throws IOException {
		Socket client = new Socket("172.30.1.6", 9000);
		// 1. Ű���� �Է� ��Ʈ��
		BufferedReader sysin = new BufferedReader(new InputStreamReader(System.in));
		// 2. �������� �����͸� ���� �Է� ��Ʈ��
		BufferedReader sbr = new BufferedReader(new InputStreamReader(client.getInputStream()));
		// 3. ������ �����͸� ������ ��Ʈ��
		PrintWriter sw = new PrintWriter(client.getOutputStream());

		while (true) {
			System.out.println("4�ڸ��� ���δٸ� ���ڸ� �Է��ϼ���");
			String number = sysin.readLine();
			sw.println(number);
			sw.flush();
			String data = sbr.readLine();
			System.out.println(data);
			if (data.indexOf("����") >= 0)
				break;
		}
		sysin.close();
		sbr.close();
		sw.close();
		client.close();
	}
}
