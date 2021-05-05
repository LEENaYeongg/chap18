package chap18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* ȭ�鿡�� ���ϸ��� �Է¹ް�, ����� ������ ���۶���, ���� ���μ��� �Է¹޾�
 * ���۶��κ��� ���μ��� ������ ȭ�鿡 ����ϱ�.
 * ��, ��½� ���μ��� �Բ� ����ϱ� Scanner ��� �Ұ� 
 * */
public class Exam2 {
	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("���ϸ��� �Է��ϼ���.");
		String filename = stdin.readLine();
		System.out.println("����� ���۶��ΰ�, ��¶��� ���� �Է��ϼ���");
		String stdnum = stdin.readLine();
		String[] strnum = stdnum.split(" ");
		int start = Integer.parseInt(strnum[0].trim());
		int len = Integer.parseInt(strnum[1].trim());
		BufferedReader br = new BufferedReader(new FileReader(filename));
		int line = 0;
		String data = null;
		int cnt = 0;
		while ((data = br.readLine()) != null) { //readLine ���پ� �ۼ� ����
			++line;
			if (line < start)
				continue;
			if (cnt >= len)
				break;
			++cnt;
			System.out.println(line + ":" + data);
		}
		br.close();
	}
}
