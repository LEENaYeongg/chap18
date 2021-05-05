package test_1102;

/*2.ȭ�鿡�� ���ϸ��� �Է¹޾Ƽ� �ش� ������ ������ ȭ�鿡 ����ϱ�.
���� ������ ���� ���� '�ش� ���� ����' �� ����ϱ�(�ѱ��� ������ �ʾƾ� ��.)
FileInputStream ����ϱ�
*/
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) throws IOException {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("���ϸ��� �Է��ϼ���.");
			String txt = scan.next();
			
			//�Էµ� ���ϸ� �ش��ϴ� ������ ���� ��� => FileNotFoundException ���� �߻�
			FileInputStream fis = new FileInputStream("src/chap18/"+txt);
			int len = 0; // ������ ���� ����Ʈ ��
			byte[] buf = new byte[fis.available()]; // ������ �б� ���� ����Ʈ �� ����, �ϳ��� ������ ���� : ������ ����Ʈ
			while ((len = fis.read(buf)) != -1) {
				System.out.println(new String(buf, 0, len));
			}

		} catch (FileNotFoundException e) {
			System.out.println("�ش� ���� ����");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*		======== ���� �� �ҽ�
		try {
			FileInputStream fis = new FileInputStream("src/chap18/"+txt);
		int data = 0;
		byte[] buf = new byte[1000];
		while ((data = fis.read(buf, 10, buf.length - 10)) != -1)
			System.out.println(new String(buf, 0, data));
		}catch (Exception e) {
		}
		System.out.println("�ش� ���� ����");
*/
	}
}
