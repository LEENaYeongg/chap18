package chap18;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * FileOutputStream 예제 : 파일에 데이터를 파일로 저장.
 * 						  파일이 존재하지 않으면 파일 생성
 * 						  파일이 존재하면 파일 수정
 * void write(int data) : 1바이트 출력
 * void write(byte[] buf) : buf 의 내용을 출력
 * void write(byte[] buf, int start, int len) :
 * 		buf의 start 인덱스부터 len 만큼 내용을 출력
 * 
 * */
public class FileOutputStreamEx1 {
	public static void main(String[] args) throws IOException {
		System.out.println("out.txt 파일에 출력됩니다.");
		FileOutputStream fos = new FileOutputStream("out.txt");
		//fos : out.txt 파일에 쓸수있는 출력 스트림
		// 		생성자 FileNotFoundException 예외 처리해야 함.
		// 		파일을 생성할 권한이 없는 경우 예외 발생함.
		fos.write('1');fos.write('2');fos.write('3');
		fos.write('a');fos.write('b');fos.write('c');
		fos.write('가');fos.write('나');fos.write('다');
		// getBytes : 문자열을 byte[] 리턴
		byte[] buf = "\n반갑습니다. FileOutputStream 예제 입니다.\n".getBytes();
		fos.write(buf);
		fos.write(buf,3,6); //출력을 할 때 지정된 형태로 출력 가능. 3부터 6까지

	}

}
