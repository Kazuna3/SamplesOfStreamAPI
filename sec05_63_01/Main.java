package sec05_63_01;

import java.util.stream.Stream;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// ストリーム処理で犯しやすい実装ミス事例。

		Stream<String> animal1 = Stream.of("CAT", "FOX", "DOG");
		Stream<String> animal2 = Stream.of("CAT", "FOX", "DOG");
		Stream<String> animal3 = Stream.of("CAT", "FOX", "DOG");
		Stream<String> animal4 = Stream.of("CAT", "FOX", "DOG");

		// 1. 終端処理を２回以上実装するとコンパイルエラーとなる。
		// long cnt1 = animal1.count().forEach(s -> System.out.print(s));

		// 2. 終端処理の戻り値と、文全体の戻り値の型が合っていなければ、コンパイルエラーとなる。
		// long cnt2 = animal2.forEach(s -> System.out.print(s));

		// 3. 仮引数と実引数の型が合っていなければ、コンパイルエラーとなる。
		// forEachの引数の型の仕様は、Consumer であって Predicate ではない為、コンパイルエラーとなる。
		// animal3.forEach(s -> 'C' == s.charAt(0));

		// 4. 終端操作が実行されたストリームに対して、再度終端操作を実行すると、
		//    実行時エラーである IllegalStateException が発生する。
		long cnt4 = animal4.count();
		animal4.forEach(System.out::printf);

	}

}
