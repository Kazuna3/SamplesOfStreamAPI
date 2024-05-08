package sec05_48;

/**/
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		System.out.println("↓↓↓無名クラスを利用した処理↓↓↓");

		// ストリームオブジェクトを生成する。
		Stream<String> animals1 = Stream.of("CAT", "FOX", "PIG", "DOG", "COW", "BAT");

		Predicate<String> pre1 = new Predicate<>() {

			public boolean test(String str) {

				return 'C' == str.charAt(0);

			}

		};

		// 先頭文字が'C'である動物を選択して表示する。
		animals1.filter(pre1)
				.forEach(s -> System.out.println(s));

		System.out.println("↓↓↓ラムダ式を利用した処理（その１）↓↓↓");

		// ストリームオブジェクトを生成する。
		Stream<String> animals2 = Stream.of("CAT", "FOX", "PIG", "DOG", "COW", "BAT");

		Predicate<String> pre2 = s -> 'C' == s.charAt(0);

		// 先頭文字が'C'である動物を選択して表示する。
		animals2.filter(pre2)
				.forEach(s -> System.out.println(s));

		System.out.println("↓↓↓ラムダ式を利用した処理（その２）↓↓↓");

		// ストリームオブジェクトを生成する。
		Stream<String> animals3 = Stream.of("CAT", "FOX", "PIG", "DOG", "COW", "BAT");

		// 先頭文字が'C'である動物を選択して表示する。
		animals3.filter(s -> 'C' == s.charAt(0))
				.forEach(s -> System.out.println(s));

	}

}

// Yahoo の知恵袋で質問した。質問内容は次の通り。
// https://detail.chiebukuro.yahoo.co.jp/qa/question_detail/q10294069780
// 【質問】
// ラムダ式を、メソッド参照に書き換える方法を教えてください。
/*
//import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		//ストリームオブジェクトを生成する。
		Stream<String> animals = Stream.of("CAT", "FOX", "PIG", "DOG", "COW", "BAT");

		//先頭文字が'C'である動物を選択して表示する。
		animals.filter(s -> 'C' == s.charAt(0)) // ← この行のラムダ式を、メソッド参照に書き換える方法を教えてください。
				.forEach(s -> System.out.println(s));

	}

}
*/

// 【上の質問に対する回答（その１）】
/* 
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		// ストリームオブジェクトを生成する。
		Stream<String> animals = Stream.of("CAT", "FOX", "PIG", "DOG", "COW", "BAT");
		// 先頭文字が'C'である動物を選択して表示する。
		animals.filter(Main::charAt).forEach(System.out::println);

	}

	static boolean charAt(String s) {

		return 'C' == s.charAt(0);

	}

}
*/

//【上の質問に対する回答（その２）】
/*
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		// ストリームオブジェクトを生成する。
		Stream<String> animals = Stream.of("CAT", "FOX", "PIG", "DOG", "COW", "BAT");

		// 先頭文字が'C'である動物を選択して表示する。
		Predicate<String> startWithC = s -> 'C' == s.charAt(0);

		animals.filter(startWithC)
				.forEach(System.out::println);

	}

}
*/
