package chap18;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

/* File클래스의 주요 메서드
* getAbsolutePath() : File의 절대 경로
* getName() : 파일의 이름
* boolean mkdir() : 폴더 생성
* boolean createNewFile() : 파일 생성.
* boolean renameTo(File) : 이름 변경
* long lastModified() : 최종 수정시간. 1970년 이후부터  파일수정시간까지를 밀리초로 저장.
* boolean delete() : 파일 삭제
*/
public class FileEx2 {

   public static void main(String[] args) throws IOException {
      File f1 = new File("c:/temp1"); //폴더
      System.out.printf("%s 폴더생성 : %b%n",
            f1.getAbsolutePath(),f1.mkdir()); 
      File f2 = new File("c:/temp1/test.txt"); //파일
      System.out.printf("%s 파일생성 : %b%n",
            f2.getAbsolutePath(),f2.createNewFile());
      System.out.printf("파일이름:%s, 파일크기:%d byte%n",
            f2.getName(),f2.length());
      File f3 = new File("c:/temp1/test2.txt");
      System.out.printf("%s->%s 이름 변경 : %b%n",f2.getName(),f3.getName(),f2.renameTo(f3));
      System.out.printf("%s 파일 최종 수정 시간 : %s%n",f3.getName(),new Date(f3.lastModified()));
      System.out.printf("%s 파일 삭제: %b%n",f3.getName(),f3.getName(),f3.delete());
   }

}