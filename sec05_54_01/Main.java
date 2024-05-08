package sec05_54_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		// 複数の文字列要素を持つストリームから、真偽の結果を求める方法。

		// 文字列要素の処理対象コレクションを生成する。
		List<String> animal = new ArrayList<>();

		// 初期値を設定。
		animal = Arrays.asList("CAT", "DOG", "FOX", "COW", "PIG");

		// １．全要素と一致しているか確認する方法。
		Stream<String> stream = animal.stream(); // stream の初期化処理。

		// boolean allMatch(Predicate<? super T> predicate);
		boolean exist = stream.allMatch(str -> str.equals("DOG"));
		System.out.println("全要素と一致しているか？：" + exist);

		// ２．一致している要素が１つ以上あるか確認する方法。
		stream = animal.stream(); // stream の初期化処理。

		// boolean anyMatch(Predicate<? super T> predicate);
		exist = stream.anyMatch(str -> str.equals("DOG"));
		System.out.println("一致している要素が１つ以上あるか？：" + exist);

		// ３．全要素と不一致であるか確認する方法。
		stream = animal.stream(); // stream の初期化処理。

		// boolean noneMatch(Predicate<? super T> predicate);
		exist = stream.noneMatch(str -> str.equals("DOG"));
		System.out.println("全要素と不一致であるか？：" + exist);

	}

}
