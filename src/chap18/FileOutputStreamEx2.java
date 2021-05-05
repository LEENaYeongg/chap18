package chap18;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;

/*
 * FileOutputStream을 이용해 error 로그 파일 생성
 */


public class FileOutputStreamEx2 {

   public static void main(String[] args) {
      firstMethod();
   }

   private static void firstMethod() {
      secondMethod();
   }

   private static void secondMethod() {
      try {
         throw new Exception("파일에 예외 메시지 저장하기");
      } 
      
      catch(Exception e) { //예외 발생
         e.printStackTrace(); //표준 오류 출력
         
         try {
/*
* ("error.log",true)
* error.log :  저장될 파일의 이름. 파일이 없는 경우 생성, 있으면 수정
* true : 기존의 내용을 삭제하지 않고, 새로운 내용을 append 함.
* 			새로운 내용을 추가 기능.
* */
            FileOutputStream fos = new FileOutputStream("error.log");
            fos.write(e.getMessage().getBytes());
            e.printStackTrace(new PrintStream(fos));
            fos.write((new Date() + ": =============\n\n").getBytes());
         }
         
         catch (IOException e2) {
            e2.printStackTrace();
         }
      }
   }
}