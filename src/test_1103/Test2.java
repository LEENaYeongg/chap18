package test_1103;

import java.io.FileInputStream;
import java.io.IOException;

/*
 * bin/chap18/PrintStreamEx1.class 파일은 이진 파일이다. 
      이 파일을 읽어서 16진수로 출력하기
      ==> 이진 파일이므로 절대 reader로 읽을 수 없음. 반드시 inputStream으로 읽어야함.
*/
public class Test2 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("bin/chap18/PrintStreamEx1.class");// 이진파일이기 때문에 reader 로 읽으면 안됨.
		int data;
		int count = 0;
		while ((data = fis.read()) != -1) {
			System.out.printf("%02X ", data); //두자리가 아닌 애들은 앞에 0으로 채워~
			count++;
			if (count == 15) {
				System.out.println();
				count = 0;
			}
		}
	}
}
