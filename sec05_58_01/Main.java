package sec05_58_01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		// ストリームの中間操作メソッドである flatMap による平坦化処理の実装例。

		List<String> zoo1 = Arrays.asList("CAT", "DOG", "FOX");

		// 初期値を表示する。
		System.out.print("zoo1 の初期値：");
		zoo1.stream().forEach(str -> System.out.print(str + " "));

		List<String> zoo2 = Arrays.asList("COW", "PIG", "BAT");

		// 初期値を表示する。
		System.out.println();
		System.out.print("zoo2 の初期値：");
		zoo2.stream().forEach(str -> System.out.print(str + " "));

		List<List<String>> allZoo = Arrays.asList(zoo1, zoo2);

		// 初期値を表示する。
		System.out.println();
		System.out.print("allZoo の初期値：");
		// void forEach(Consumer<? super T> action);
		allZoo.stream().forEach(aryLs -> System.out.print(aryLs + " "));

		// １．平坦化した実行結果を保存する実装例。
		// <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
		List<String> detailAnimal = allZoo
				.stream()
				.flatMap(ls -> ls.stream())
				.collect(Collectors.toList());

		// ２．１の実行結果を表示する実装例。
		System.out.println();
		System.out.println("allZoo のデータを平坦化した detailAnimal を表示する");
		System.out.print("detailAnimal の値：");
		detailAnimal.stream().forEach(str -> System.out.print(str + " "));

	}

}
