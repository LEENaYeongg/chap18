package chap18;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/* 화면에서 파일명을 입력받고, 저장할 데이터를 exit 문자가 입력될 때까지 입력받아,
 * 파일명에 저장하는 프로그램 작성하기
 * */
public class Exam1 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("파일명을 입력하세요.");
		String txt = scan.nextLine();
		FileOutputStream fos = new FileOutputStream(txt);
		System.out.println("저장할 데이터를 입력하세요. 종료(exit)");
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
