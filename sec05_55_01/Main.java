package sec05_55_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		// 文字列要素の処理対象コレクションを生成する。
		List<String> animal = new ArrayList<>();

		// 初期値を設定。
		animal = Arrays.asList("CAT", "DOG", "FOX");

		// １．文字列の集約処理。各要素を順次結合して、要素数を１つに減らす。要素数を減らすので reduce と言うメソッド名になったと考えられる。
		// reduce の第一引数は、集約した文字列の接頭辞（prefix）となる。
		// （※）
		// T reduce(T identity, BinaryOperator<T> accumulator);
		// ↓
		// public interface BinaryOperator<T> extends BiFunction<T,T,T> { //省略 }
		// ↓
		// public interface BiFunction<T, U, R> { //省略 }
		// ↓
		// R apply(T t, U u);
		String result1 = animal.stream().reduce("hoge ", (total, part) -> total + part + " ");
		System.out.println("１．集約処理：" + result1);

		// 数値要素の処理対象コレクションを生成する。
		List<Integer> numList = new ArrayList<>();

		// 初期値を設定。
		numList = Arrays.asList(10, 20, 30, 40);

		// ２．数値の集約処理。各要素値の和を求めて、要素数を１つに減らす。要素数を減らすので reduce と言うメソッド名になったと考えられる。
		// reduce の第一引数は、各要素値の和に加算する初期値となる。
		// 上記の（※）を参照の事。
		int result2 = numList.stream().reduce(10000, (total, part) -> total + part);
		System.out.println("２．集約処理：" + result2);

	}

}
