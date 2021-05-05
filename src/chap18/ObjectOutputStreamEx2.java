package chap18;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * ��� ���迡���� ����ȭ
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
   //����ȭ�� �߰��� �� �ִ� ���
   private void writeObject(ObjectOutputStream out)
   throws IOException{
      out.writeUTF(name); //String ��ü�� ����ȭ�� �߰�
      out.writeUTF(password);
      out.defaultWriteObject(); //�⺻���� ����ȭ ����� �� ���
   }
   //����ȭ���� ������ ��ü���� �߰��� ������ ���� �� �ִ� ���
 //  Object reader�� writer�� ����. => ����: ??
   private void readObject(ObjectInputStream in) //���������ڸ� private���� 
   throws IOException,ClassNotFoundException{
      name = in.readUTF(); //String ��ü�� ����
      password = in.readUTF();
      in.defaultReadObject();
   }
}
public class ObjectOutputStreamEx2 {
   public static void main(String[] args) throws IOException{
      ObjectOutputStream oos = new ObjectOutputStream
            (new FileOutputStream("object2.ser"));
      User u1 = new User("ȫ�浿","1234",20);
      User u2 = new User("���","5678",30);
      oos.writeObject(u1);
      oos.writeObject(u2);
      System.out.println("�����:"+u1+","+u2);
      
   }
}