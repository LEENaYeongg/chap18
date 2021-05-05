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
	private String name; // �̸�
	private String work; // ����
	private String position; // ����
	private int age; // ����

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

// 1. emp.txt ������ �о, st ��ü�� ����
// 2. ������� ���� ���� ���� ����ϱ�
// 3. ������ �̸� ����ϱ�
// 4. ���޺� ������ ��� ����ϱ�
public class Test1 {
	public static void main(String[] args) throws IOException {
		Stream<Employee> st = null;
		// 1. emp.txt ������ �о, st ��ü�� ����
		st = makeStream();

		// 2. ������� ���� ���� ���� ����ϱ�
		System.out.println("=====������� ���� ���� ����=====");
		makeStream().map(e -> e.getPosition()).distinct().forEach(s -> System.out.print(s + ","));
		System.out.println();

		// 3. ������ �̸� ����ϱ�
		System.out.println("===== ������ �̸� =====");
		Map<String, String> map = makeStream().collect(Collectors.groupingBy(Employee::getWork,
				Collectors.mapping(Employee::getName, Collectors.joining(","))));
		for (String s : map.keySet())
			System.out.println(s + "=" + map.get(s));

		// 4. ���޺� ������ ��� ����ϱ�
		System.out.println("=====���޺� ������ ���=====");
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
