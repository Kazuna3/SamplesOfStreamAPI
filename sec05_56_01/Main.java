package sec05_56_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		// ストリームの中間操作で汎用性の高いメソッド。

		// 文字列要素の処理対象コレクションを生成する。
		List<String> animal = new ArrayList<>();

		// 初期値を設定。※ DOG を故意に２つ設定する。
		animal = Arrays.asList("CAT", "DOG", "FOX", "COW", "PIG", "DOG");

		// 初期値を表示する。
		System.out.print("\n初期値：");
		animal.stream().forEach(s -> System.out.print(s + " "));

		// １．distinct（重複している要素データを、非重複なデータにする実装例。）
		Stream<String> stream = animal.stream(); // stream の初期化処理。
		stream = stream.distinct();
		System.out.print("\n１．distinct =");
		stream.forEach(str -> System.out.print(" " + str));

		// ２．filter（条件に合致する要素データのみを抽出する実装例。）
		// Stream<T> filter(Predicate<? super T> predicate);
		// ↓
		// boolean test(T t);
		stream = animal.stream(); // stream の初期化処理。
		stream = stream.filter(c -> c.charAt(0) == 'C'); //先頭が'C'で始まる文字列を抽出する。
		System.out.print("\n２．filter =");
		stream.forEach(str -> System.out.print(" " + str));

		// ３．sorted（要素データを昇順にソートする実装例。）
		stream = animal.stream(); // stream の初期化処理。
		stream = stream.sorted();
		System.out.print("\n３．sorted =");
		stream.forEach(str -> System.out.print(" " + str));

		// ４．limit（要素データの先頭要素から、指定した個数の要素データを取得する実装例。）
		stream = animal.stream(); // stream の初期化処理。
		stream = stream.limit(3);
		System.out.print("\n４．limit =");
		stream.forEach(str -> System.out.print(" " + str));

		// ５．map（何らかの処理を施した要素データを生成する実装例。）
		// <R> Stream<R> map(Function<? super T, ? extends R> mapper);
		// ↓
		// R apply(T t);
		stream = animal.stream(); // stream の初期化処理。
		//stream = stream.map(str -> '（' + str.toLowerCase() + '）');
		stream = stream.map(str -> "（" + str.toLowerCase() + "）");
		System.out.print("\n５．map =");
		stream.forEach(str -> System.out.print(" " + str));

		// ６．１～５の処理を、メソッドチェーン（パイプライン）とした実装例。※処理結果のデータは保存できていない。）
		stream = animal.stream(); // stream の初期化処理。
		System.out.print("\n６．１～５の処理を、メソッドチェーン（パイプライン）とした処理結果：");
		stream
				.distinct()
				.filter(c -> c.charAt(0) == 'C')
				.sorted()
				.limit(3)
				.map(str -> '（' + str.toLowerCase() + '）')
				.forEach(str -> System.out.print("◆" + str));

		// ７．１～５の処理を、メソッドチェーン（パイプライン）とした実装例。※処理結果は List<String> result に保存。）
		stream = animal.stream(); // stream の初期化処理。
		System.out.print("\n７．１～５の処理を、メソッドチェーン（パイプライン）とした処理結果：");
		List<String> result = stream
				.distinct()
				.filter(c -> c.charAt(0) == 'C')
				.sorted()
				.limit(3)
				.map(str -> '（' + str.toLowerCase() + '）')
				// 次行によって、全ての中間処理を施した結果のデータを、List 型のオブジェクトにセットできる。
				.collect(Collectors.toList());

		// List<String> resultの要素データを表示する実装例（その１）。
		result.stream().forEach(str -> System.out.print("●" + str));

		// List<String> resultの要素データを表示する実装例（その２）。
		System.out.print("\n８．７の表示処理と異なる実装による表示：");

		for (String str : result) {

			System.out.print("◎" + str);

		}

	}

}
