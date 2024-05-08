package sec06_70_01;

import java.util.function.Function;

//Function<T, R> を引数や戻り値として利用する。
public class Main {

	public static void main(String[] args) {

		// Function<T, R> : 引数 T、戻り値 R

		// １行の場合
		Function<String, Integer> fnc1 = s -> 111;
		Integer int1 = printFunction(fnc1, "222");
		System.out.println(int1);

		// 複数行の場合
		Function<String, Integer> fnc2 = s -> {

			System.out.println(s);
			return Integer.parseInt(s);

		};
		Integer int2 = printFunction(fnc2, "333");
		System.out.println(int2);

		// 戻り値として返す場合
		Integer int3 = printFunction(getFunction(), "444");
		System.out.println(int3);

	}

	// Function<String, Integer> を戻す。
	static Function<String, Integer> getFunction() {

		Function<String, Integer> fnc = s -> {

			System.out.println("DOC");
			System.out.println("CAT");
			System.out.println("COW");
			System.out.println("FOX");

			Integer i = 0;

			try {

				i = Integer.parseInt(s);

			} catch (NumberFormatException e) {

				System.err.println("Error : 引数の文字列は、Integer型に変換できませんでした。");

			}

			return i;

		};

		return fnc;

	}

	static Integer printFunction(Function<String, Integer> fnc, String str) {

		System.out.println();
		// return Integer.valueOf(str);
		return fnc.apply(str);

	}

}
