package chap18;

import java.io.IOException;
import java.io.InputStream;

/* 입력스트림 예제
 * 바이트형 입력스트림 : InputStream. -> 1바이트 단위로 읽음.
 * 문자형 입력스트림 : Reader		   -> 2바이트(1문자) 단위로 읽음.
 * 
 *  자바에서 제공하는 표준 입출력 객체
 *  표준입력스트림  : InputStream System.in => 키보드에서 입력
 *  표준출력스트림 : PrintStream System.out => 콘솔(화면) 출력
 *  표준오류스트림 : PrintStream System.err => 콘솔(화면) 출력
 * 
 * */

public class InputStreamEx1 {
	public static void main(String[] args) throws IOException {
		InputStream in = System.in;
		int data =0;
		//in.read() : 바이트 단위 읽기
		while((data=in.read()) != -1) //ctrl+z
			System.out.print((char)data);
		
	}

}
