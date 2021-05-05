package chap18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 화면에서 파일명을 입력받고, 출력을 시작할 시작라인, 종료 라인수를 입력받아
 * 시작라인부터 라인수의 내용을 화면에 출력하기.
 * 단, 출력시 라인수도 함께 출력하기 Scanner 사용 불가 
 * */
public class Exam2 {
	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("파일명을 입력하세요.");
		String filename = stdin.readLine();
		System.out.println("출력할 시작라인과, 출력라인 수를 입력하세요");
		String stdnum = stdin.readLine();
		String[] strnum = stdnum.split(" ");
		int start = Integer.parseInt(strnum[0].trim());
		int len = Integer.parseInt(strnum[1].trim());
		BufferedReader br = new BufferedReader(new FileReader(filename));
		int line = 0;
		String data = null;
		int cnt = 0;
		while ((data = br.readLine()) != null) { //readLine 한줄씩 작성 가능
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
