package chap18;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/* Reader : ������ �Է½�Ʈ��. 1����(2����Ʈ) ������ ����
 * InputStreamReader : ����Ʈ�� �Է½�Ʈ�� => ������ �Է½�Ʈ��
 * ����.				 : ������ �Է½�Ʈ�� => ����Ʈ�� �Է½�Ʈ��
 * */
public class ReaderEx1 {
	public static void main(String[] args) throws IOException {
		Reader in = new InputStreamReader(System.in);
		int data;
		//in.read() : 2����Ʈ(1 char) ������ ����
		while((data=in.read()) != -1) {
			System.out.print((char)data);
		}
	}
}
