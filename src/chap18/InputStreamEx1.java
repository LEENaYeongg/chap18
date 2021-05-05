package chap18;

import java.io.IOException;
import java.io.InputStream;

/* �Է½�Ʈ�� ����
 * ����Ʈ�� �Է½�Ʈ�� : InputStream. -> 1����Ʈ ������ ����.
 * ������ �Է½�Ʈ�� : Reader		   -> 2����Ʈ(1����) ������ ����.
 * 
 *  �ڹٿ��� �����ϴ� ǥ�� ����� ��ü
 *  ǥ���Է½�Ʈ��  : InputStream System.in => Ű���忡�� �Է�
 *  ǥ����½�Ʈ�� : PrintStream System.out => �ܼ�(ȭ��) ���
 *  ǥ�ؿ�����Ʈ�� : PrintStream System.err => �ܼ�(ȭ��) ���
 * 
 * */

public class InputStreamEx1 {
	public static void main(String[] args) throws IOException {
		InputStream in = System.in;
		int data =0;
		//in.read() : ����Ʈ ���� �б�
		while((data=in.read()) != -1) //ctrl+z
			System.out.print((char)data);
		
	}

}
