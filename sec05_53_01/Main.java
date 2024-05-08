package sec05_53_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		// 文字列要素を保存するコレクションを生成
		List<String> animal = new ArrayList<>();

		animal = Arrays.asList("CAT", "DOG", "FOX", "PIG");

		// ストリームオブジェクトを４個生成
		Stream<String> stream1 = animal.stream();
		Stream<String> stream2 = animal.stream();
		Stream<String> stream3 = animal.stream();
		Stream<String> stream4 = animal.stream();

		// １．要素の先頭文字のみ取得する。 mapの構文：（戻り値：<R> Stream<R>	シグネチャ：map(Function<? super T,? extends R> mapper)）
		// a.charAt(0) の戻り値は char 型で、オートボクシングにより Character 型となっている。
		// よって、map メソッドの引数 T は String 型で、戻り値の R は Character 型である。
		System.out.print("\n１．");
		stream1.map(a -> a.charAt(0)).forEach(a -> System.out.print(a + " "));

		// ２．１に return を追加する。
		System.out.print("\n２．");
		stream2.map(a -> {

			return a.charAt(0);

		}).forEach(a -> System.out.print(a + " "));

		// ３．２を複数の文にする。（複数文にすると return 文は省略不可となる。）
		System.out.print("\n３．");
		stream3.map(a -> {

			String str = "先頭の文字：";
			return str + a.charAt(0);

		}).forEach(a -> System.out.print(a + " "));

		// ４．１文字目の取得処理を substring で代替する。
		// map メソッドの引数に実装されている Lambda 式の引数と戻り値の型は、String 型である。※実は、Function の T と R が同型でも、コンパイルエラーにならない。
		System.out.print("\n４．");
		stream4.map(a -> a.substring(0, 1)).forEach(a -> System.out.print(a + " "));

		// ５．１でのメソッドチェーン（パイプライン）を不使用とした場合の実装コード。
		System.out.print("\n５．");
		Stream<String> stream5_1 = animal.stream();
		Stream<Character> stream5_2 = stream5_1.map(a -> a.charAt(0));
		stream5_2.forEach(a -> System.out.print(a + " "));

	}

}
