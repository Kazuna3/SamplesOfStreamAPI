package sec07_81_01;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import sec07_79_01.MhrUtil;
import sec07_79_01.NewStudents;
import sec07_79_01.PrintStudent;
import sec07_79_01.SortRule;
import sec07_79_01.Student;

public class Main {

	public static void main(String[] args) {

		// List から Set を取得する。

		// 画面表示用オブジェクトの生成。
		PrintStudent ps = new PrintStudent();

		// 合否メッセージ追加オブジェクトの取得
		Function<Student, Student> fc = MhrUtil.getFnc();

		// 合格者判断オブジェクトの取得
		Predicate<Student> pd = MhrUtil.getPre();

		// 新規 List<Student> の生成
		List<Student> lstd1 = (new NewStudents()).getStd();

		// 合否の判定結果データを持つ List<Student> を生成する。
		lstd1.stream().collect(Collectors.mapping(fc, Collectors.toList()));

		// List<Student> の明細表示。
		ps.printStudentList("List<Student> の明細表示。", lstd1);

		// List<Student> で Set<Student> を生成する。
		Set<Student> setStudent1 = lstd1.stream().collect(Collectors.toSet());

		// １．Set<Student> の明細表示。
		ps.printStudentSet("１．Set<Student> の明細表示。", setStudent1);

		// List<Student> の合格者のみで Set<Student> を生成する。
		Set<Student> setStudent2 = lstd1.stream()
				.filter(pd)
				.collect(Collectors.toSet());

		// ２．Set<Student> の明細表示。（合格者のみ）
		ps.printStudentSet("２．Set<Student> の明細表示。（合格者のみ）", setStudent2);

		// ３．２の Set<Student> を、点数の降順で明細表示。
		System.out.println();
		System.out.println("３．２の Set<Student> を、点数の降順で明細表示。");
		setStudent2.stream()
				// 既に合格者のみのデータになっている為、filter は無駄である。よってコメントアウトした。
				// .filter(pd) 
				.sorted(new SortRule())
				.forEach(s -> s.printDetail());

		// ４．３と同じ処理を異なる実装方法で実現した明細表示。
		System.out.println();
		System.out.println("４．３と同じ処理を異なる実装方法で実現した明細表示。");
		setStudent2.stream()
				.sorted(
						(x, y) -> {

							if (x.getMark() < y.getMark()) {

								return -1;

							} else {

								if (x.getMark() == y.getMark()) {

									return 0;

								} else {

									return 1;

								}

							}

						})
				.forEach(s -> s.printDetail());

	}

}
