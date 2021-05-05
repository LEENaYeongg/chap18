package chap18;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*  ObjectOutputStreamEx1 ����
 * 1. ��ü�� �ܺη� ������ �� �ִ� ��Ʈ��
 * 2. ������ �Ǵ� ��ü�� �ݵ�� Serializable �������̽� ��ü���� �Ѵ�.
 * 		java.io.NotSerializableException ���� �߻�.
 * 3. ��ü�� �ܺη� �����ϴ� ����� ����ȭ�� �Ѵ�.
 * 4. ObjectOutputStream ���� ��ü�� ���� �� �ִ�.
 * 
 * */
class Customer implements Serializable{
	private String name;
	//trancsient : ����ȭ�� ���ܵǴ� ��������� ������ �� ����ϴ� �����.
	private transient int age; //����ȭ�� ���ܵǴ� ������. 
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String toString() {
		return String.format("[%s:%d]", name, age);
	}
}
public class ObjectOutputStreamEx1 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos =  new FileOutputStream("object.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Customer c1 = new Customer("ȫ�浿",20);
		Customer c2 = new Customer("���",30);
		oos.writeObject(c1);oos.writeObject(c2); // oos.writeObject ��ü�� ������~
		System.out.println(c1 + ","+ c2);
		oos.close(); fos.close();
	}
}
