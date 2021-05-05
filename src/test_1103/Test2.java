package test_1103;

import java.io.FileInputStream;
import java.io.IOException;

/*
 * bin/chap18/PrintStreamEx1.class ������ ���� �����̴�. 
      �� ������ �о 16������ ����ϱ�
      ==> ���� �����̹Ƿ� ���� reader�� ���� �� ����. �ݵ�� inputStream���� �о����.
*/
public class Test2 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("bin/chap18/PrintStreamEx1.class");// ���������̱� ������ reader �� ������ �ȵ�.
		int data;
		int count = 0;
		while ((data = fis.read()) != -1) {
			System.out.printf("%02X ", data); //���ڸ��� �ƴ� �ֵ��� �տ� 0���� ä��~
			count++;
			if (count == 15) {
				System.out.println();
				count = 0;
			}
		}
	}
}
