package test_1102;

/*2.화면에서 파일명을 입력받아서 해당 파일의 내용을 화면에 출력하기.
만약 파일이 없는 경우는 '해당 파일 없음' 을 출력하기(한글은 깨지지 않아야 함.)
FileInputStream 사용하기
*/
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) throws IOException {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("파일명을 입력하세요.");
			String txt = scan.next();
			
			//입력된 파일명에 해당하는 파일이 없을 경우 => FileNotFoundException 에러 발생
			FileInputStream fis = new FileInputStream("src/chap18/"+txt);
			int len = 0; // 실제로 읽은 바이트 수
			byte[] buf = new byte[fis.available()]; // 파일의 읽기 가능 바이트 수 리턴, 하나도 안읽은 상태 : 파일의 바이트
			while ((len = fis.read(buf)) != -1) {
				System.out.println(new String(buf, 0, len));
			}

		} catch (FileNotFoundException e) {
			System.out.println("해당 파일 업음");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*		======== 내가 한 소스
		try {
			FileInputStream fis = new FileInputStream("src/chap18/"+txt);
		int data = 0;
		byte[] buf = new byte[1000];
		while ((data = fis.read(buf, 10, buf.length - 10)) != -1)
			System.out.println(new String(buf, 0, data));
		}catch (Exception e) {
		}
		System.out.println("해당 파일 없음");
*/
	}
}
