package chap18;

import java.io.File;

/* File 클래스
 *  - 파일, 폴더의 정보를 관리하는 클래스. 없는 파일도 관리됨.
 *  폴더 구분자
 *  윈도우 : \, /
 *  리눅스 : /
 *  */
public class FileEx1 {
	public static void main(String[] args) {
		String filePath = "C:\\"; // C:\ : 묶어서 문자열을 표기하는 큰따음표로 의미. 반드시 \\ 로 써야함.
		File f1 = new File(filePath);
		String[] files = f1.list(); // f1폴더의 하위폴더, 파일들
		for (String f : files) {
			File f2 = new File(filePath, f);
			if (f2.isDirectory()) // 폴더니?
				System.out.printf("%s: 디렉토리%n", f);
			else // 파일이니?
				System.out.printf("%s: 파일(%,dbyte)%n", f, f.length());
			// f2.length() : f2 객체가 지정하는 파일의 크기 리턴
		}
	}
}