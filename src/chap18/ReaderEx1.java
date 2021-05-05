package chap18;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/* Reader : 문자형 입력스트림. 1문자(2바이트) 단위로 읽음
 * InputStreamReader : 바이트형 입력스트림 => 문자형 입력스트림
 * 없다.				 : 문자형 입력스트림 => 바이트형 입력스트림
 * */
public class ReaderEx1 {
	public static void main(String[] args) throws IOException {
		Reader in = new InputStreamReader(System.in);
		int data;
		//in.read() : 2바이트(1 char) 단위로 읽음
		while((data=in.read()) != -1) {
			System.out.print((char)data);
		}
	}
}
