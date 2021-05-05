package chap18;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* InputStream �� �̿��Ͽ� �ٸ� ���μ����� ����� ����ϱ� 
 * 
 * Process : �ٸ� ���μ����� ����.
 * */
public class ProcessEx1 {
	public static void main(String[] args) throws IOException {
		// Runtime.getRuntime(). : OS�κ��� ���μ����� ���� ������ ����.
		// exec(���μ�����) : ���μ��� ����.
		Process p = Runtime.getRuntime().exec("ping 172.30.1.254");
		// p.getInputStream() : �Է½�Ʈ��.
		// ���μ����� �����ϴ� �����͸� ���� �� �ִ� ��ü
		Reader r = new InputStreamReader(p.getInputStream());
		int data = 0;
		while ((data = r.read()) != -1)
			System.out.print((char) data);
		p = Runtime.getRuntime().exec("notepad.exe");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		p.destroy(); // p ���μ����� ������ ����
	}
}
