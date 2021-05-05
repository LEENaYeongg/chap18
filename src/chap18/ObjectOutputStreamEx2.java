package chap18;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * 상속 관계에서의 직렬화
 */
class UserInfo {
   protected String name;
   protected String password;
   public UserInfo() {}
   public UserInfo(String name, String password) {
      this.name = name;
      this.password = password;
   }
   
   public String toString() {
      return String.format("[%s,%s]",name,password);
   }
}
class User extends UserInfo implements Serializable {
   private int age;
   public User(String name, String password, int age) {
      super(name,password);
      this.age = age;
   }
   public String toString() {
      return String.format("[%s,%s,%d]",name, password, age);
   }
   //직렬화에 추가할 수 있는 기능
   private void writeObject(ObjectOutputStream out)
   throws IOException{
      out.writeUTF(name); //String 객체를 직렬화에 추가
      out.writeUTF(password);
      out.defaultWriteObject(); //기본적인 직렬화 대상인 값 출력
   }
   //직렬화에서 복원된 객체에서 추가된 내용을 읽을 수 있는 기능
 //  Object reader와 writer은 없음. => 이유: ??
   private void readObject(ObjectInputStream in) //접근제어자를 private으로 
   throws IOException,ClassNotFoundException{
      name = in.readUTF(); //String 객체를 복원
      password = in.readUTF();
      in.defaultReadObject();
   }
}
public class ObjectOutputStreamEx2 {
   public static void main(String[] args) throws IOException{
      ObjectOutputStream oos = new ObjectOutputStream
            (new FileOutputStream("object2.ser"));
      User u1 = new User("홍길동","1234",20);
      User u2 = new User("김삿갓","5678",30);
      oos.writeObject(u1);
      oos.writeObject(u2);
      System.out.println("사용자:"+u1+","+u2);
      
   }
}