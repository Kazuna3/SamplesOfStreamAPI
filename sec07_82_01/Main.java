package sec07_82_01;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import sec07_79_01.MhrUtil;
import sec07_79_01.NewStudents;
import sec07_79_01.PrintStudent;
import sec07_79_01.Student;

public class Main {

	public static void main(String[] args) {

		// List から Map を取得する。

		// 画面表示用オブジェクトの生成。
		PrintStudent ps = new PrintStudent();

		// 合否メッセージ追加オブジェクトの取得
		Function<Student, Student> fc = MhrUtil.getFnc();

		// 合格者判断オブジェクトの取得
		Predicate<Student> pd = MhrUtil.getPre();

		// 新規 List<Student> の生成
		List<Student> lstd = (new NewStudents()).getStd();

		// ０．List<Student> の明細を表示。
		System.out.println("０．List<Student> の明細を表示。");
		lstd.stream().forEach(s -> s.printDetail());

		// １．全員の明細を表示。実装方法１．テキストの実装方法。
		Map<String, Student> maps1_1 = lstd.stream()
				.collect(Collectors.mapping(fc, Collectors.toMap(s -> s.getKey(), s -> s)));
		ps.printStudentMap("１．全員の明細を表示。実装方法１．テキストの実装方法。", maps1_1);

		// １．全員の明細を表示。実装方法２．mappingの第一引数は、何もしていないのと同じ。
		Map<String, Student> maps1_2 = lstd.stream()
				.map(fc)
				.collect(Collectors.mapping(s -> s, Collectors.toMap(s -> s.getKey(), s -> s)));
		ps.printStudentMap("１．全員の明細を表示。実装方法２．mappingの第一引数は、何もしていないのと同じ。", maps1_2);

		// １．全員の明細を表示。実装方法３．Collectors.mapping を使わず map で処理する実装方法。
		Map<String, Student> maps1_3 = lstd.stream()
				.map(fc)
				.collect(Collectors.toMap(s -> s.getKey(), s -> s));
		ps.printStudentMap("１．全員の明細を表示。実装方法３．Collectors.mapping を使わず map で処理する実装方法。", maps1_3);

		// ２．合格者のみの Map<String, Student> を生成する。
		Map<String, Student> maps2_1 = lstd.stream()
				.filter(pd)
				.collect(Collectors.mapping(fc, Collectors.toMap(s -> s.getKey(), s -> s)));
		ps.printStudentMap("２．合格者のみの Map<String, Student> を生成する。", maps2_1);

		// ３．合格者のみを点数降順で表示する。
		System.out.println();
		System.out.println("３．合格者のみを点数降順で表示する。");
		// 【補足】entrySet とは、Map の Key と Value の一つの組み合わせを意味するとの事。更に Set は、集合の意味なので、Key と Value の集合を意味する模様。
		System.out.println("【補足】");
		System.out.println("entrySet とは、Map の Key と Value の一つの組み合わせを意味するとの事。");
		System.out.println("更に Set は、集合の意味なので、Key と Value の集合を意味する模様。");
		maps2_1.entrySet().stream()
				.sorted((s1, s2) -> s2.getValue().getMark() - s1.getValue().getMark())
				.forEach(s -> s.getValue().printDetail());

		// ４．学生をクラスごとの Map< クラス, Student> として取得する。
		Map<String, List<Student>> maps4_1 = lstd.stream()
				.collect(Collectors.groupingBy(s -> s.getKey().substring(2, 3), Collectors.toList()));
		ps.printStudentMap2("４．学生をクラスごとの Map< クラス, Student> として取得する。", maps4_1);

	}

}
