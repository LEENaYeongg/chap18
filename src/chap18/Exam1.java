package chap18;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/* ȭ�鿡�� ���ϸ��� �Է¹ް�, ������ �����͸� exit ���ڰ� �Էµ� ������ �Է¹޾�,
 * ���ϸ� �����ϴ� ���α׷� �ۼ��ϱ�
 * */
public class Exam1 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("���ϸ��� �Է��ϼ���.");
		String txt = scan.nextLine();
		FileOutputStream fos = new FileOutputStream(txt);
		System.out.println("������ �����͸� �Է��ϼ���. ����(exit)");
		String data = null;
		while (true) {
			data = scan.nextLine();
			if (data.equals("exit"))
				break;
			fos.write((data + "\n").getBytes()); //write(String)
		}
		fos.flush();
		fos.close();
	}
}
