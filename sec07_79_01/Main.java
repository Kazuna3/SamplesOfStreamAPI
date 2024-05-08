package sec07_79_01;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		// List<Student> を取得する。

		// 画面表示用オブジェクトの生成。
		PrintStudent ps = new PrintStudent();

		// 合否メッセージ追加オブジェクトの取得
		Function<Student, Student> fc = MhrUtil.getFnc();

		// 合格者判断オブジェクトの取得
		Predicate<Student> pd = MhrUtil.getPre();

		// １．新規 List<Student> の生成
		List<Student> lstd1 = (new NewStudents()).getStd();

		// 明細表示。合否未設定。
		ps.printStudentList("１．全員表示", lstd1);

		// ２．合否を持つ List<Student> を作成。

		//【補足】実装方法：A, B は、実装方法が少し違うが、処理内容として、やっている事は同じである。
		// 実装方法：A
		List<Student> lstd2 = lstd1.stream()
				.map(MhrUtil.getFnc())
				.collect(Collectors.toList());

		// 実装方法：B
		//		List<Student> lstd2 = lstd1.stream()
		//				.collect(Collectors.mapping(fc, Collectors.toList()));

		// 明細表示。合否設定。
		ps.printStudentList("２．全員表示", lstd2);

		// ３．合格者のみの List<Student> を作成。
		List<Student> lstd3 = lstd1.stream()
				.filter(pd)
				.collect(Collectors.mapping(fc, Collectors.toList()));

		// 明細表示。
		ps.printStudentList("３．合格者のみ表示", lstd3);

		// ４．合格者の点数降順に List<Student> を作成。
		List<Student> lstd4 = lstd1.stream()
				.filter(pd)
				.sorted(new SortRule())
				.collect(Collectors.mapping(fc, Collectors.toList()));

		// 明細表示。
		ps.printStudentList("４．合格者の点数降順表示", lstd4);

	}

	// ※以下のメソッドは、MhrUtil Class へ public メソッドとして切り出した。

	//	// Function<Student, Student> オブジェクトの取得
	//	static Function<Student, Student> getFnc() {
	//
	//		Function<Student, Student> fnc = s -> {
	//
	//			String result;
	//
	//			if (s.getMark() >= 70) {
	//
	//				result = "合格";
	//
	//			} else {
	//
	//				result = "不合格";
	//
	//			}
	//
	//			s.setResult(result);
	//
	//			// ラムダ式のリターン文。 
	//			return s;
	//
	//		};
	//
	//		// getFnc() メソッドのリターン文。
	//		return fnc;
	//
	//	}
	//
	//	// Predicate<Student> の取得
	//	static Predicate<Student> getPre() {
	//
	//		Predicate<Student> pre = s -> s.getMark() >= 70;
	//
	//		return pre;
	//
	//	}

}
