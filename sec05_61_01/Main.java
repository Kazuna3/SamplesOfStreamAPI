package sec05_61_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		// 【補足】本 Section 5 の No 61 の教材の実行結果は間違っていた。

		// 1. コレクションからストリームオブジェクトを生成する。
		List<String> list11 = new ArrayList<>();
		list11 = Arrays.asList("CAT", "FOX", "PIG", "DOG", "COW", "BAT");
		Stream<String> zoo11 = list11.stream();

		// 2.先頭文字が'C'である動物を選択して表示する。
		zoo11.filter(s -> 'C' == s.charAt(0))
				.map(s -> s + "&" + s.toLowerCase())
				.sorted()
				.limit(5)
				//.forEach(System.out::println);
				.forEach(s -> System.out.print(s + " "));

	}

}
