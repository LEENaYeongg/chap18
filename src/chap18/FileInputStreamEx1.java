package chap18;

import java.io.FileInputStream;
import java.io.IOException;

/*
 * FileInputStream ���� : ������ ������ �о, ȭ�鿡 ����ϱ�
 * �ֿ� �޼���
 * int read() : 1byte �� �о ������ ����
 * int read(byte[] buf) : buf�� ũ�⸸ŭ �о buf�� ������ ����
 * 					 	   ���� ����Ʈ ���� ����
 * int read(byte[] buf, int start, int len) :
 * 		buf�� len ����Ʈ ��ŭ �о start �ε������� buf�� ����
 * 		���� ����Ʈ ���� ����
 * available() : �б� ���� ����Ʈ �� ����
 * 
 * */
public class FileInputStreamEx1 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("src/chap18/InputStreamEx1.java");
		int data = 0;
//		System.out.println("======read() �޼��带 �̿��Ͽ� �б�");
//		while((data=fis.read()) != -1) {
//			System.out.print((char)data);
		System.out.println("======read(byte[]) �޼��带 �̿��Ͽ� �б�");
		//fis.available() : fis ������ �б� ������ ����Ʈ �� ����
		byte[] buf = new byte[1000];
		//data : ������ ���� ����Ʈ�� ����
		//buf : ���� ���� ����
//		while ((data = fis.read(buf)) != -1)
//			System.out.print(new String(buf, 0, data));
		System.out.println();
		System.out.println("======read(byte[], int start,int len) �޼��带 �̿��Ͽ� �б�");
		//data : ������ ���� ����Ʈ�� ����.
		//buf : �ִ� buf.length��ŭ �о, 0�� �ε������� ������ ����.
		while((data=fis.read(buf,10,buf.length-10)) != -1)
			System.out.println(new String (buf,0,data));

	}
}
