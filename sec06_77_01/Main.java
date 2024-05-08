package sec06_77_01;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

	// 練習問題

	// Consumer<T> ---> void accept(T t);
	static void printConsumer(Consumer<String> con) { // 設問 A => 回答：

		con.accept("CAT");

	}

	// Supplier<T> ---> T get();
	static void printSupplier(Supplier<String> sup) { // 設問 B => 回答：

		System.out.println(sup.get());

	}

	// Predicate<T> ---> boolean test(T t);
	static void printPredicate(Predicate<String> pre) { // 設問 C => 回答：

		System.out.println(pre.test("FOX"));

	}

	public static void main(String[] args) {

		/*
		 * 練習問題 2
		 * 上の static method を main method で利用する際、引数として適切な変数名を次の選択肢から選びなさい。
		 */

		// 選択肢：con
		Consumer<String> con = a -> System.out.println(a);

		// 選択肢：sup 
		Supplier<String> sup = () -> {

			return "DOG";

		};

		// 選択肢：pre
		Predicate<String> pre = a -> {

			if (a.equals("FOX")) {

				return true;

			} else {

				return false;

			}

		};

		// 以下回答。（結果は全部正解だった。）
		printConsumer(con);
		printSupplier(sup);
		printPredicate(pre);

	}

}
