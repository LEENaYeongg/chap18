package chap18;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/*
 * object.ser���Ͽ� ��ϵ� ���並 �о ȭ�� ���
 */
public class ObjectInputStreamEx2 {

   public static void main(String[] args) 
         throws ClassNotFoundException, IOException {
      ObjectInputStream ois = new ObjectInputStream
            (new FileInputStream("object2.ser"));
      User u1 = (User)ois.readObject();
      User u2 = (User)ois.readObject();
      System.out.println("������ �����:"+u1+","+u2);

   }
}