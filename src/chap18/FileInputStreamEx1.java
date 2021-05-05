package chap18;

import java.io.FileInputStream;
import java.io.IOException;

/*
 * FileInputStream 예제 : 파일의 내용을 읽어서, 화면에 출력하기
 * 주요 메서드
 * int read() : 1byte 씩 읽어서 내용을 리턴
 * int read(byte[] buf) : buf의 크기만큼 읽어서 buf에 데이터 저장
 * 					 	   읽은 바이트 수를 리턴
 * int read(byte[] buf, int start, int len) :
 * 		buf로 len 바이트 만큼 읽어서 start 인덱스부터 buf에 저장
 * 		읽은 바이트 수를 리턴
 * available() : 읽기 가능 바이트 수 리턴
 * 
 * */
public class FileInputStreamEx1 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("src/chap18/InputStreamEx1.java");
		int data = 0;
//		System.out.println("======read() 메서드를 이용하여 읽기");
//		while((data=fis.read()) != -1) {
//			System.out.print((char)data);
		System.out.println("======read(byte[]) 메서드를 이용하여 읽기");
		//fis.available() : fis 파일의 읽기 가능한 바이트 수 리턴
		byte[] buf = new byte[1000];
		//data : 실제로 읽은 바이트수 리턴
		//buf : 읽은 내용 저장
//		while ((data = fis.read(buf)) != -1)
//			System.out.print(new String(buf, 0, data));
		System.out.println();
		System.out.println("======read(byte[], int start,int len) 메서드를 이용하여 읽기");
		//data : 실제로 읽은 바이트수 저장.
		//buf : 최대 buf.length만큼 읽어서, 0번 인덱스부터 데이터 저장.
		while((data=fis.read(buf,10,buf.length-10)) != -1)
			System.out.println(new String (buf,0,data));

	}
}
