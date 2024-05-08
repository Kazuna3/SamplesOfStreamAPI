package sec07_84_01;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import sec07_79_01.NewStudents;
import sec07_79_01.PrintStudent;
import sec07_79_01.Student;

public class Main {

	public static void main(String[] args) {

		// List から真偽ごとの Map を生成する。

		// 画面表示用オブジェクトの生成。
		PrintStudent ps = new PrintStudent();

		// 新規 List<Student> の生成
		List<Student> lstd = (new NewStudents()).getStd();

		// ０．List<Student> の明細を表示。
		System.out.println("０．List<Student> の明細を表示。");
		lstd.stream().forEach(s -> s.printDetail());
		// lstd.stream().forEach(Student::printDetail);	// ←インスタンス メソッド参照による実装例。

		// １．List<Student> から Map<Boolean, List<Student>> を生成する。
		// 点数が70点以上なら判断結果を True とし、そうでない場合は、False とする。
		Map<Boolean, List<Student>> map = lstd.stream()
				.collect(Collectors.partitioningBy(s -> s.getMark() >= 70));

		ps.printStudentBoMap(
				"１．List<Student> から Map<Boolean, List<Student>> を生成する。"
						+ "\n点数が70点以上なら判断結果を True とし、そうでない場合は、False とする。",
				map);

	}

}
