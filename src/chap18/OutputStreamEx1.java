package chap18;

import java.io.IOException;
import java.io.OutputStream;
/* OutputStream : ����Ʈ�� ��½�Ʈ��
 * write(int) : 1����Ʈ�� ���
 * 
 * */
public class OutputStreamEx1 {
	public static void main(String[] args) throws IOException {
		OutputStream out = System.out;
		out.write('1');out.write('2');out.write('3');
		out.write('a');out.write('b');out.write('c');
		out.write('��');out.write('��');out.write('��');
		out.flush(); //������ ������ ������(ȭ��)�� ���� ����
	}

}
