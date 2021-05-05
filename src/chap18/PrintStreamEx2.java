package chap18;
// PrintSTream Ŭ������ printf �޼��� ����
// String.format() ������ ����.

public class PrintStreamEx2 {
	public static void main(String[] args) {
		//char ������������ : %c %n==\n
		System.out.printf("%c%n",'A');
		System.out.printf("%5c%n",'A'); //5ĭ Ȯ���Ͽ� A ���
		System.out.printf("%-5c%n",'A'); //5ĭ Ȯ���Ͽ� A ��� ��������
		
		//���� �������� ���� : %d(10����), %o(8����), %x, %x(16����)
		System.out.printf("%d%n",12345);
		System.out.printf("%10d%n",12345); //10Ȯ��
		System.out.printf("%,10d%n",12345); //10Ȯ��, ���ڸ����� ,(�޸�)
		System.out.printf("%-,10d%n",12345); //10Ȯ��, ���ڸ����� ,(�޸�), ��������
		System.out.printf("%3d%n",12345); //�ּ��ڸ� 3
		System.out.printf("%010d%n",12345); // 10Ȯ��. ���ڸ� 0ä��.
		System.out.printf("%o%n",12345); 
		System.out.printf("%o%n",10); //10�� 8������ ���
		System.out.printf("%x%n",10); // 10�� 16������ ���
		System.out.printf("%X%n",10); //10�� 16������ ���
		
		//�Ǽ� ���� �������� : %f(�Ҽ�ǥ��), %e(����ǥ��), %g(�ٻ�Ǽ�)
		System.out.printf("%f%n",12345.12345); // 
		System.out.printf("%.2f%n",12345.12345); // �Ҽ������� 2�ڸ� Ȯ��
		System.out.printf("%10.2f%n",12345.12345); // 10�ڸ� Ȯ��, �Ҽ��� ���� 2�ڸ� Ȯ��
		System.out.printf("%,10.2f%n",12345.12345); // 10�ڸ� Ȯ��, �Ҽ��� ���� 2�ڸ� Ȯ��, ���ڸ����� ,(�޸�)
		System.out.printf("%e%n",12345.12345); 
		System.out.printf("%g%n",12345.12345); 
		
		//���� : %b
		System.out.printf("%b != %b%n", true,false);
		System.out.printf("(2 > 3) == %b%n", (2 > 3));
		
		//���ڿ� : %s
		System.out.printf("%s�� %s�̴�%n", "ȫ�浿","����");
		System.out.printf("%5s�� %5s�̴�%n", "ȫ�浿","����");
		
		//���� : 10���� 255�� 8���� 377�̰�, 16���� FF��
		System.out.printf("%d���� %d�� %d���� %o�̰�, %d���� %x�̴�%n", 10,255,8,255,16,255);

	}
}
