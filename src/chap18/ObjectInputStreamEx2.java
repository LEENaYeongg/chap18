package chap18;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/*
 * object.ser파일에 등록된 객페를 읽어서 화면 출력
 */
public class ObjectInputStreamEx2 {

   public static void main(String[] args) 
         throws ClassNotFoundException, IOException {
      ObjectInputStream ois = new ObjectInputStream
            (new FileInputStream("object2.ser"));
      User u1 = (User)ois.readObject();
      User u2 = (User)ois.readObject();
      System.out.println("복원된 사용자:"+u1+","+u2);

   }
}