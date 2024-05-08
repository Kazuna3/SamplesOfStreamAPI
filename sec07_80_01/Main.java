package sec07_80_01;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import sec07_79_01.NewStudents;
import sec07_79_01.PrintStudent;
import sec07_79_01.Student;

public class Main {

	public static void main(String[] args) {

		// List から１個の結果を取得する。

		// 画面表示用オブジェクトの生成。
		PrintStudent ps = new PrintStudent();

		// １．新規 List<Student> の生成
		List<Student> lstd = (new NewStudents()).getStd();
		ps.printStudentList("１．全員表示", lstd);

		// ２．合計点の取得
		int total = lstd.stream().collect(Collectors.summingInt(s -> s.getMark()));
		System.out.println("２．合計点 = " + total);

		// ３．平均点の取得
		double ave = lstd.stream().collect(Collectors.averagingDouble(s -> s.getMark()));
		System.out.println("３．平均点 = " + ave);

		// ４．最低点の取得
		int minMark = 0;
		Optional<Student> minStudent = lstd.stream().collect(Collectors.minBy((s1, s2) -> s1.getMark() - s2.getMark()));

		if (minStudent.isPresent())
			minMark = minStudent.get().getMark();

		System.out.println("４．最低点 = " + minMark);

		// ５．最高点の取得
		int maxMark = 0;
		Optional<Student> maxStudent = lstd.stream().collect(Collectors.maxBy((s1, s2) -> s1.getMark() - s2.getMark()));

		if (maxStudent.isPresent())
			maxMark = maxStudent.get().getMark();

		System.out.println("５．最高点 = " + maxMark);

		// ６．生徒の名前を区切り文字で繋いで表示する。
		String allName = lstd.stream()
				.map(s -> s.getName())
				.collect(Collectors.joining("&"));

		System.out.println("６．生徒の名前を区切り文字で繋いで表示する。");
		System.out.println(allName);

		// ７．６と同じ処理をイテレータで実現した実装例。
		System.out.println("７．６と同じ処理をイテレータで実現した実装例。");
		Iterator<Student> it = lstd.iterator();

		boolean isFirst = true;

		while (it.hasNext()) {

			if (isFirst)
				isFirst = false;
			else
				System.out.print("&");

			System.out.print(it.next().getName());

		}

		System.out.println();

	}

}
