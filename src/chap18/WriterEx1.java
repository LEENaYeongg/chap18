package chap18;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/* Writer : ������ ��½�Ʈ��
 * write(int) : 1���� ������ �����
 * 
 * OutputStreamWriter : ����Ʈ�� ��½�Ʈ�� => ������ ��½�Ʈ��
 * */
public class WriterEx1 {

	public static void main(String[] args) throws IOException{
		Writer out = new OutputStreamWriter(System.out);
		out.write('1');out.write('2');out.write('3');
		out.write('a');out.write('b');out.write('c');
		out.write('��');out.write('��');out.write('��');
		out.flush(); //������ ������ ������(ȭ��)�� ���� ����

	}

}