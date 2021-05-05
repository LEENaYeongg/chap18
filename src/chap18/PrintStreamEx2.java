package chap18;
// PrintSTream 클래스의 printf 메서드 예제
// String.format() 사용법과 같다.

public class PrintStreamEx2 {
	public static void main(String[] args) {
		//char 형식지정문자 : %c %n==\n
		System.out.printf("%c%n",'A');
		System.out.printf("%5c%n",'A'); //5칸 확보하여 A 출력
		System.out.printf("%-5c%n",'A'); //5칸 확보하여 A 출력 좌측정렬
		
		//정수 형식지정 문자 : %d(10진수), %o(8진수), %x, %x(16진수)
		System.out.printf("%d%n",12345);
		System.out.printf("%10d%n",12345); //10확보
		System.out.printf("%,10d%n",12345); //10확보, 세자리마다 ,(콤마)
		System.out.printf("%-,10d%n",12345); //10확보, 세자리마다 ,(콤마), 좌측정렬
		System.out.printf("%3d%n",12345); //최소자리 3
		System.out.printf("%010d%n",12345); // 10확보. 빈자리 0채움.
		System.out.printf("%o%n",12345); 
		System.out.printf("%o%n",10); //10을 8진수로 출력
		System.out.printf("%x%n",10); // 10을 16진수로 출력
		System.out.printf("%X%n",10); //10을 16진수로 출력
		
		//실수 형식 지정문자 : %f(소수표현), %e(지수표현), %g(근사실수)
		System.out.printf("%f%n",12345.12345); // 
		System.out.printf("%.2f%n",12345.12345); // 소수점이하 2자리 확보
		System.out.printf("%10.2f%n",12345.12345); // 10자리 확보, 소숫점 이하 2자리 확보
		System.out.printf("%,10.2f%n",12345.12345); // 10자리 확보, 소숫점 이하 2자리 확보, 세자리마다 ,(콤마)
		System.out.printf("%e%n",12345.12345); 
		System.out.printf("%g%n",12345.12345); 
		
		//논리형 : %b
		System.out.printf("%b != %b%n", true,false);
		System.out.printf("(2 > 3) == %b%n", (2 > 3));
		
		//문자열 : %s
		System.out.printf("%s는 %s이다%n", "홍길동","의적");
		System.out.printf("%5s는 %5s이다%n", "홍길동","의적");
		
		//문제 : 10진수 255는 8진수 377이고, 16진수 FF다
		System.out.printf("%d진수 %d는 %d진수 %o이고, %d진수 %x이다%n", 10,255,8,255,16,255);

	}
}
