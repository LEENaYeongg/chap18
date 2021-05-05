package chap18;

import java.io.FileWriter;
import java.io.IOException;

/* FileWriter 예제 : 파일에 텍스트 형태의 데이터를 저장
 * 
 * void write(int data) : 2바이트(한문자) 출력
 * void write(char[] buf) : buf의 내용을 파일에 출력
 * void write(char[] buf, int start, int len) 
 * 		: buf의 start 인덱스 부터의 내용을 len 만큼 파일에 출력
 * void write(String data) : data 내용을 파일에 출력
 * 
 * */
public class FileWriterEx1 {
	public static void main(String[] args) throws IOException {
		System.out.println("out2.txt 파일에 출력됩니다.");
		FileWriter fos = new FileWriter("out2.txt");
		fos.write('1');fos.write('2');fos.write('3');
		fos.write('a');fos.write('b');fos.write('c');
		fos.write('가');fos.write('나');fos.write('다');
		char[] buf = "\n반갑습니다. FileOutputStream 예제 입니다.\n".toCharArray();
		fos.write(buf);
		fos.write(buf,0,6);
		fos.write("안녕하세요 홍길동 입니다");
		fos.flush(); //버퍼의 내용을 out2.txt 파일로 강제 전송
	}

}
