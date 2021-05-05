package chap18;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx1 {

	public static void main(String[] args) throws IOException {
	FileReader fis = new FileReader("src/chap18/InputStreamEx1.java");
	int data;
	System.out.println("============ read() �޼��� �̿��Ͽ� �б�");
	while((data=fis.read()) != -1)
		System.out.print((char)data);
	System.out.println("============ read(buf) �޼��� �̿��Ͽ� �б�");
	fis = new FileReader("src/chap18/InputStreamEx1.java");
	char[] buf =  new char[1024];
	while((data=fis.read()) != -1)
		System.out.print((char)data);
	System.out.println("============ read(buf,start,len) �޼��� �̿��Ͽ� �б�");
	fis = new FileReader("src/chap18/InputStreamEx1.java");
	while((data=fis.read(buf,0,buf.length)) != -1)
		System.out.print(new String(buf,0,data));
	}
}
