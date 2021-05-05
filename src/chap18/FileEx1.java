package chap18;

import java.io.File;

/* File Ŭ����
 *  - ����, ������ ������ �����ϴ� Ŭ����. ���� ���ϵ� ������.
 *  ���� ������
 *  ������ : \, /
 *  ������ : /
 *  */
public class FileEx1 {
	public static void main(String[] args) {
		String filePath = "C:\\"; // C:\ : ��� ���ڿ��� ǥ���ϴ� ū����ǥ�� �ǹ�. �ݵ�� \\ �� �����.
		File f1 = new File(filePath);
		String[] files = f1.list(); // f1������ ��������, ���ϵ�
		for (String f : files) {
			File f2 = new File(filePath, f);
			if (f2.isDirectory()) // ������?
				System.out.printf("%s: ���丮%n", f);
			else // �����̴�?
				System.out.printf("%s: ����(%,dbyte)%n", f, f.length());
			// f2.length() : f2 ��ü�� �����ϴ� ������ ũ�� ����
		}
	}
}