package sec06_68_01;

import java.util.function.Consumer;

//Consumer<T> を引数や戻り値として利用する。
public class Main {

	public static void main(String[] args) {

		// Consumer<T> : 引数 T、戻り値なし

		// １行の場合
		Consumer<String> co1 = s -> System.out.println("\n" + s);
		co1.accept("PANDA");
		printConsumer(co1, "PANDA");

		// 複数行の場合
		Consumer<String> co2 = s -> {

			System.out.println();
			System.out.println(s + "その１");
			System.out.println(s + "その２");

		};
		co2.accept("HORSE");
		printConsumer(co2, "HORSE");

		// 戻り値として返す場合
		Consumer<String> co3 = getConsumer();
		co3.accept("MOUSE");
		printConsumer(co3, "MOUSE");

	}

	// Consumer<T> を戻す。
	static Consumer<String> getConsumer() {

		Consumer<String> co1 = s -> {

			System.out.println();
			System.out.println(s + "&DOC");
			System.out.println(s + "&CAT");
			System.out.println(s + "&COW");
			System.out.println(s + "&FOX");

		};

		return co1;

	}

	static void printConsumer(Consumer<String> con, String str) {

		con.accept(str);

	}

}
