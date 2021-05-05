package chap18;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * FileOutputStream ���� : ���Ͽ� �����͸� ���Ϸ� ����.
 * 						  ������ �������� ������ ���� ����
 * 						  ������ �����ϸ� ���� ����
 * void write(int data) : 1����Ʈ ���
 * void write(byte[] buf) : buf �� ������ ���
 * void write(byte[] buf, int start, int len) :
 * 		buf�� start �ε������� len ��ŭ ������ ���
 * 
 * */
public class FileOutputStreamEx1 {
	public static void main(String[] args) throws IOException {
		System.out.println("out.txt ���Ͽ� ��µ˴ϴ�.");
		FileOutputStream fos = new FileOutputStream("out.txt");
		//fos : out.txt ���Ͽ� �����ִ� ��� ��Ʈ��
		// 		������ FileNotFoundException ���� ó���ؾ� ��.
		// 		������ ������ ������ ���� ��� ���� �߻���.
		fos.write('1');fos.write('2');fos.write('3');
		fos.write('a');fos.write('b');fos.write('c');
		fos.write('��');fos.write('��');fos.write('��');
		// getBytes : ���ڿ��� byte[] ����
		byte[] buf = "\n�ݰ����ϴ�. FileOutputStream ���� �Դϴ�.\n".getBytes();
		fos.write(buf);
		fos.write(buf,3,6); //����� �� �� ������ ���·� ��� ����. 3���� 6����

	}

}
