package sec06_69_01;

import java.util.function.Supplier;

//Supplier<T> を引数や戻り値として利用する。
public class Main {

	public static void main(String[] args) {

		// Supplier<T> : 引数なし、戻り値 T

		// １行の場合
		Supplier<String> sp1 = () -> "HORSE";
		String str1 = printSupplier(sp1);
		System.out.println(str1);

		// 複数行の場合
		Supplier<String> sp2 = () -> {

			System.out.println("PANDA");
			return "FOX";

		};
		String str2 = printSupplier(sp2);
		System.out.println(str2);

		// 戻り値として返す場合
		Supplier<String> sp3 = getSupplier();
		String str3 = printSupplier(sp3);
		System.out.println(str3);

	}

	// Supplier<T> を戻す。
	static Supplier<String> getSupplier() {

		Supplier<String> sp = () -> {

			System.out.println("DOC");
			System.out.println("CAT");
			System.out.println("COW");
			System.out.println("FOX");
			return "PANDA";

		};

		return sp;

	}

	static String printSupplier(Supplier<String> sup) {

		System.out.println();
		return sup.get();

	}

}
