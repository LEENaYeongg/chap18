package chap18;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ���� ��Ʈ��
 * 1. ���ο� ����� �߰��� ����� ��Ʈ��
 * 2. ��ü ������ �ٸ� ��Ʈ���� �Ű����� �޴´�.
 *  	new BufferedReader(Reader)
 *  	new BufferedInputStream(InputStream)
 *  BufferedReader : ���� ����� Ȯ���Ͽ� ���� ��� ��Ŵ.
 *  		=> readLine() : ������ �����͸� ���� �� �� �پ� �д� ���.
 * */
//Ű���忡�� �Էµ� ������ buffered.txt ���Ͽ� �����ϱ�
public class BufferedReaderEx1 {
	public static void main(String[] args) throws IOException {
		//Ű����κ��� ���پ� �Է�
		//InputStream System.in
		//new InputStreamReader (InputStream)
		// : InputStream => Reader ���·� ����
		// BufferedReader : ������ �Է½�Ʈ��
		//br : ǥ���Է��� ���پ� ���� �� �ֵ��� BufferedReader Ÿ���� ��ü
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("������ ������ �Է��ϼ���.����(ctrl+z)");
		FileWriter fw = new FileWriter("buffered.txt");
		String data = null;
		while((data =br.readLine()) != null) { //end of file
			System.out.println(data); //ȭ�� ���
			fw.write(data+"\n"); //buffered.txt ���Ͽ� ��� 
		}
		fw.flush();fw.close();br.close();

	}

}
