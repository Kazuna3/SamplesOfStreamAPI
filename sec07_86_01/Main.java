package sec07_86_01;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import sec07_79_01.NewStudents;
import sec07_79_01.PrintStudent;
import sec07_79_01.Student;

public class Main {

	public static void main(String[] args) {

		// SE8 応用プログラミング練習問題１

		// 画面表示用オブジェクトの生成。
		PrintStudent ps = new PrintStudent();

		// 新規 List<Student> の生成
		List<Student> lstd = (new NewStudents()).getStd();

		// １．List<Student> の明細を表示。
		ps.printStudentList("１．List<Student> の明細を表示。", lstd);

		// ２．クラス毎の点数の最大値を取得する。
		Map<String, Optional<Student>> map2 = lstd.stream()
				.collect(
						// new Student("01A01", "青木", 50),
						Collectors.groupingBy(s -> s.getKey().substring(0, 3),
								Collectors.maxBy((v1, v2) -> v1.getMark() - v2.getMark())));

		ps.printStudentMap4("２．クラス毎の点数の最大値を取得する。", map2);

		// ３．クラス毎の点数の合計値を取得する。
		Map<String, Long> map3 = lstd.stream()
				.collect(
						Collectors.groupingBy(s -> s.getKey().substring(0, 3),
								Collectors.summingLong(s -> s.getMark())));

		ps.printStudentMap3("３．クラス毎の点数の合計値を取得する。", map3);

		// ４．クラス毎の点数の平均点を取得する。
		Map<String, Double> map4 = lstd.stream()
				.collect(
						Collectors.groupingBy(s -> s.getKey().substring(0, 3),
								Collectors.averagingDouble(s -> s.getMark())));

		ps.printStudentMap5("４．クラス毎の点数の平均点を取得する。", map4);

	}

}
