package chap18;
/* c:\windows ������ ���� ���� ����, ������ ��ũ�⸦ ����ϱ�  */

import java.io.File;

public class Exam3 {
	public static void main(String[] args) {
		File f1 = new File("c:/windows");
		int dircnt = 0, filecnt = 0;
		long size = 0;
		String[] files = f1.list(); // f1������ ��������, ���ϵ�
		for (String f : files) {
			File f2 = new File(f1, f);
			if (f2.isDirectory())
				dircnt++;
			else if (f2.isFile()) {// �����̴�?
				filecnt++;
				size += f2.length();

			}
		}
		System.out.println("������ ����: " + dircnt);
		System.out.println("������ ����: " + filecnt);
		System.out.printf("������ �� ũ��: %,dbyte", size);
	}
}
