package sec06_67_01;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

// ラムダ式を引数として利用する。
public class Main {

	public static void main(String[] args) {

		printConsumer(t -> System.out.println(t));
		printSupplier(() -> "DOG");

		// printPredicate の実装例その１
		printPredicate(t -> {

			if (t.equals("FOX")) {

				return true;

			} else {

				return false;

			}

		});

		// printPredicate の実装例その２
		// 次行の１行で同じ処理を実現できるが、パッと見て処理内容を理解できるのは、実装例その１かもしれない。
		printPredicate(t -> t.equals("FOX"));

	}

	// Consumer<T> : 引数 T、戻り値なし
	static void printConsumer(Consumer<String> arg) {

		arg.accept("CAT");

	}

	// Supplier<T> : 引数なし、戻り値 T
	static void printSupplier(Supplier<String> arg) {

		System.out.println(arg.get());

	}

	// Predicate<T> : 引数 T、戻り値 boolean
	static void printPredicate(Predicate<String> arg) {

		System.out.println(arg.test("FOX"));

	}

}
