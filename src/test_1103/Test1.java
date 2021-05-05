package test_1103;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*1.�ݺ����� �̿��Ͽ� ���ϸ��� �Է¹޾Ƽ� �ش� ������ �����ϸ� �ش����ϸ�.bak ���� �����ϱ�
���ϸ� exit �� �ԷµǸ�, ���α׷� ����.
�ش� ������ ������ �ش� ������ �����ϴ�. �޼��� ���
*/
public class Test1 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("���ϸ��� �Է��ϼ���.");
			String filename = scan.next();
			if (filename.equals("exit"))
				break;
			int lastdot = filename.lastIndexOf(".");
			String bakfile = null;
			if (lastdot < 0)
				bakfile = filename + ".bak";
			else
				bakfile = filename.substring(0, filename.lastIndexOf(".")) + ".bak";
			FileInputStream fis = null;
			FileOutputStream fos = null;
			try {
				fis = new FileInputStream(filename);
				fos = new FileOutputStream(bakfile);
				byte[] buf = new byte[8096];
				int len = 0;
				while ((len = fis.read(buf)) != -1) {
					fos.write(buf, 0, len);
				}
				System.out.println(filename + "=>" + bakfile + " ����Ϸ�");
			} catch (FileNotFoundException e) {
				System.out.println("������ ������ �����ϴ�.");

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (fos != null)
					fos.flush();
				if (fis != null)
					fis.close();
				if (fos != null)
					fos.close();
			}
		}
	}
}
