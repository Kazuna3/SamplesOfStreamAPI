package sec07_87_01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import sec07_79_01.Student;

public class Main {

	public static void main(String[] args) {

		// SE8 応用プログラミング練習問題２

		// List<Student> を生成する。
		List<Student> student1 = Arrays.asList(
				new Student("01B02", "伊林", 90),
				new Student("02A01", "川井", 60),
				new Student("02A02", "川村", 80));

		List<Student> student2 = Arrays.asList(
				new Student("01A01", "青木", 50),
				new Student("01A02", "青山", 70),
				new Student("01B01", "伊藤", 40));

		// 二つのコレクションを併合する。
		List<List<Student>> listStudent = Arrays.asList(student1, student2);

		// List<List<Student>> listStudent を平坦化して List<Student> にする。
		List<Student> heitanList = listStudent.stream()
				.flatMap(v -> v.stream())
				.collect(Collectors.toList());

		heitanList.stream()
				.forEach(v -> System.out.println("出席番号：" + v.getKey() + " 名前：" + v.getName() + " 点数：" + v.getMark()));

	}

}
