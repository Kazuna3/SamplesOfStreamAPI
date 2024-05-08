package sec07_83_01;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import sec07_79_01.NewStudents;
import sec07_79_01.PrintStudent;
import sec07_79_01.Student;

public class Main {

	public static void main(String[] args) {

		// List からキー毎の要素を持つ Map を取得する。

		// 画面表示用オブジェクトの生成。
		PrintStudent ps = new PrintStudent();

		// 新規 List<Student> の生成
		List<Student> lstd = (new NewStudents()).getStd();

		// ０．List<Student> の明細を表示。
		System.out.println("０．List<Student> の明細を表示。");
		lstd.stream().forEach(s -> s.printDetail());

		// １．学年毎の最高点を取得する。
		Map<String, Optional<Student>> mapd1 = lstd.stream()
				.collect(
						Collectors.groupingBy(s -> s.getKey().substring(0, 2),
								Collectors.maxBy((s1, s2) -> s1.getMark() - s2.getMark())));
		ps.printStudentMap4("１．学年毎の最高点を取得する。", mapd1);

		// ２．学年毎の合計点を取得する。
		Map<String, Long> mapd2 = lstd.stream()
				.collect(
						Collectors.groupingBy(s -> s.getKey().substring(0, 2),
								Collectors.summingLong(s -> s.getMark())));
		ps.printStudentMap3("２．学年毎の合計点を取得する。", mapd2);

		// ３．学年毎の平均点を取得する。
		Map<String, Double> mapd3 = lstd.stream()
				.collect(
						Collectors.groupingBy(s -> s.getKey().substring(0, 2),
								Collectors.averagingDouble(s -> s.getMark())));
		ps.printStudentMap5("２．学年毎の平均点を取得する。", mapd3);

	}

}
