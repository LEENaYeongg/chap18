package test_1102;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*Test1 */
class Employee {
	private String name; // 이름
	private String work; // 업무
	private String position; // 직급
	private int age; // 나이

	public Employee(String name, String work, String position, int age) {
		this.name = name;
		this.work = work;
		this.position = position;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getWork() {
		return work;
	}

	public String getPosition() {
		return position;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "name=" + name + ", work=" + work + ", position=" + position + ", age=" + age;
	}
}

// 1. emp.txt 파일을 읽어서, st 객체에 저장
// 2. 사원들이 속한 직급 정보 출력하기
// 3. 업무별 이름 출력하기
// 4. 직급별 나이의 평균 출력하기
public class Test1 {
	public static void main(String[] args) throws IOException {
		Stream<Employee> st = null;
		// 1. emp.txt 파일을 읽어서, st 객체에 저장
		st = makeStream();

		// 2. 사원들이 속한 직급 정보 출력하기
		System.out.println("=====사원들이 속한 직급 정보=====");
		makeStream().map(e -> e.getPosition()).distinct().forEach(s -> System.out.print(s + ","));
		System.out.println();

		// 3. 업무별 이름 출력하기
		System.out.println("===== 업무별 이름 =====");
		Map<String, String> map = makeStream().collect(Collectors.groupingBy(Employee::getWork,
				Collectors.mapping(Employee::getName, Collectors.joining(","))));
		for (String s : map.keySet())
			System.out.println(s + "=" + map.get(s));

		// 4. 직급별 나이의 평균 출력하기
		System.out.println("=====직급별 나이의 평균=====");
		Map<String, Double> map2 = makeStream()
				.collect(Collectors.groupingBy(Employee::getPosition, Collectors.averagingDouble(Employee::getAge)));
		for (String s : map2.keySet())
			System.out.println(s + "=" + map2.get(s));

	}

	private static Stream<Employee> makeStream() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("emp.txt"));
		Stream<Employee> emp = br.lines().map(data -> {
			String str[] = data.split(",");
			Employee e = new Employee(str[0], str[1], str[2], Integer.parseInt(str[3]));
			return e;
		});
		return emp;
	}
}
