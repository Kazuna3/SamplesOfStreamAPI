package sec06_76_01;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

	// 練習問題

	// Consumer<T> ---> void accept(T t);
	static void printConsumer(Consumer<String> arg) { // 設問 A => 回答：ア

		arg.accept("CAT");

	}

	// Supplier<T> ---> T get();
	static void printSupplier(Supplier<String> arg) { // 設問 B => 回答：ウ

		System.out.println(arg.get());

	}

	// Predicate<T> ---> boolean test(T t);
	static void printPredicate(Predicate<String> arg) { // 設問 C => 回答：エ

		System.out.println(arg.test("FOX"));

	}

	public static void main(String[] args) {

		/*
		 * 練習問題 1
		 * 上の static method を main method で利用する際、引数として適切な物を次の選択肢から選びなさい。
		 * 
		 * ア：a -> System.out.println(a)
		 * イ：(a1, a2) -> {int a3 = a1 + a2; return a3;}
		 * ウ：() -> { return "DOG"; }
		 * エ：a -> {
					     if (a.equals("FOX")) {
					         return true;
					     } else {
						     return false;
					     }
					 }
		 */

		printConsumer(a -> System.out.println(a));
		printSupplier(() -> {

			return "DOG";

		});
		printPredicate(a -> {

			if (a.equals("FOX")) {

				return true;

			} else {

				return false;

			}

		});

	}

}
