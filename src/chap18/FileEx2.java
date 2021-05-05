package chap18;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

/* FileŬ������ �ֿ� �޼���
* getAbsolutePath() : File�� ���� ���
* getName() : ������ �̸�
* boolean mkdir() : ���� ����
* boolean createNewFile() : ���� ����.
* boolean renameTo(File) : �̸� ����
* long lastModified() : ���� �����ð�. 1970�� ���ĺ���  ���ϼ����ð������� �и��ʷ� ����.
* boolean delete() : ���� ����
*/
public class FileEx2 {

   public static void main(String[] args) throws IOException {
      File f1 = new File("c:/temp1"); //����
      System.out.printf("%s �������� : %b%n",
            f1.getAbsolutePath(),f1.mkdir()); 
      File f2 = new File("c:/temp1/test.txt"); //����
      System.out.printf("%s ���ϻ��� : %b%n",
            f2.getAbsolutePath(),f2.createNewFile());
      System.out.printf("�����̸�:%s, ����ũ��:%d byte%n",
            f2.getName(),f2.length());
      File f3 = new File("c:/temp1/test2.txt");
      System.out.printf("%s->%s �̸� ���� : %b%n",f2.getName(),f3.getName(),f2.renameTo(f3));
      System.out.printf("%s ���� ���� ���� �ð� : %s%n",f3.getName(),new Date(f3.lastModified()));
      System.out.printf("%s ���� ����: %b%n",f3.getName(),f3.getName(),f3.delete());
   }

}