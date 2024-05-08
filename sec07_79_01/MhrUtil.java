package sec07_79_01;

import java.util.function.Function;
import java.util.function.Predicate;

// Main Class から切り出したメソッドで作成したクラスである。
public class MhrUtil {

	// Function<Student, Student> オブジェクトの取得
	public static Function<Student, Student> getFnc() {

		Function<Student, Student> fnc = s -> {

			String result;

			if (s.getMark() >= 70) {

				result = "合格";

			} else {

				result = "不合格";

			}

			s.setResult(result);

			// ラムダ式のリターン文。 
			return s;

		};

		// getFnc() メソッドのリターン文。
		return fnc;

	}

	// Predicate<Student> の取得
	public static Predicate<Student> getPre() {

		Predicate<Student> pre = s -> s.getMark() >= 70;

		return pre;

	}

}
