package chap18;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/*
 * ���� ��Ʈ�� : PrintStream
 * 1. OutputStream ���� Ŭ����. ����Ʈ�� ��½�Ʈ��
 * 2. write() ����� �پ��ϰ� Ȯ���� Ŭ����
 * 	  print(), println(), printf() �޼��� �߰�
 * 	  => ��� �ڷ����� ���.
 *    => ����ó�� ���� ����
 * 3. ǥ�����(System.out), ǥ�ؿ���(System.err) ��ü�� �ڷ���
 * 
 * */
public class PrintStreamEx1 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("print.txt");
		System.out.println();
		PrintStream ps = new PrintStream(fos);
		ps.println("ȫ�浿");
		ps.println(1234);
		ps.println(true);
		ps.println(65);
		ps.write(65);
		ps.println('A');
		ps.flush();
		ps.close();

	}

}
