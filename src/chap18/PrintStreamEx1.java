package chap18;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/*
 * 보조 스트림 : PrintStream
 * 1. OutputStream 하위 클래스. 바이트형 출력스트림
 * 2. write() 기능을 다양하게 확장한 클래스
 * 	  print(), println(), printf() 메서드 추가
 * 	  => 모든 자료형을 출력.
 *    => 예외처리 생략 가능
 * 3. 표준출력(System.out), 표준오류(System.err) 객체의 자료형
 * 
 * */
public class PrintStreamEx1 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("print.txt");
		System.out.println();
		PrintStream ps = new PrintStream(fos);
		ps.println("홍길동");
		ps.println(1234);
		ps.println(true);
		ps.println(65);
		ps.write(65);
		ps.println('A');
		ps.flush();
		ps.close();

	}

}
