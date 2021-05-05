package chap18;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* File Ŭ������ �̿��Ͽ� ���� �о� ���� */
public class FileEx3 {
	public static void main(String[] args) throws IOException {
		File f = new File("aaa.txt");
		if (!f.exists()) {
			System.out.println("�ش� ������ �������� �ʽ��ϴ�.");
			return;
		}
		FileInputStream fis = new FileInputStream(f);
		int len = 0;
		byte[] buf = new byte[8096];
		while ((len = fis.read(buf)) != -1) {
			System.out.println(new String(buf, 0, len));
		}
		fis.close(); // fis �� �����ֱ� ������ �ݰ� ��������.
		f.delete(); // ���� ����
	}
}
