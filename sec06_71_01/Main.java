package sec06_71_01;

import java.util.function.Predicate;

// Predicate<T> を引数や戻り値として利用する。
public class Main {

	public static void main(String[] args) {

		// Predicate<T> : 引数 T、戻り値 boolean

		// １行の場合
		Predicate<String> pr1 = p -> true;
		boolean b1 = printPredicate(pr1, "PANDA");
		System.out.println(b1);

		// 複数行の場合
		Predicate<String> pr2 = s -> {

			System.out.println(s);

			if (s.equals("HORSE")) {

				return true;

			} else {

				return false;

			}

		};
		boolean bl2 = printPredicate(pr2, "TIGER");
		System.out.println(bl2);

		// 戻り値として返す場合
		boolean bl3 = printPredicate(getPredicate(), "MOUSE");
		System.out.println(bl3);

	}

	// Predicate<String> を戻す。
	static Predicate<String> getPredicate() {

		Predicate<String> pre = s -> {

			System.out.println("DOC");
			System.out.println("CAT");
			System.out.println("COW");
			System.out.println("FOX");

			// return s.equals("MOUSE");
			if (s.equals("MOUSE")) {

				return true;

			} else {

				return false;

			}

		};

		return pre;

	}

	static boolean printPredicate(Predicate<String> pre, String str) {

		System.out.println();
		return pre.test(str);

	}

}
