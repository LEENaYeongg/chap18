package chap18;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;

/*
 * FileOutputStream�� �̿��� error �α� ���� ����
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
         throw new Exception("���Ͽ� ���� �޽��� �����ϱ�");
      } 
      
      catch(Exception e) { //���� �߻�
         e.printStackTrace(); //ǥ�� ���� ���
         
         try {
/*
* ("error.log",true)
* error.log :  ����� ������ �̸�. ������ ���� ��� ����, ������ ����
* true : ������ ������ �������� �ʰ�, ���ο� ������ append ��.
* 			���ο� ������ �߰� ���.
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