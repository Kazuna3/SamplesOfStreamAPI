package sec05_59_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		// 文字列要素を保存するコレクションを生成
		List<String> animal = new ArrayList<>();
		animal = Arrays.asList("CAT", "DOG", "FOX");

		// １．文字列の集約処理。各要素を順次結合して、要素数を１つに減らす。要素数を減らすので reduce と言うメソッド名になったと考えられる。
		String result1 = animal.stream()
				.peek(str -> System.out.println("animal:" + str))
				.reduce("", (total, part) -> total + part + " ");

		System.out.println("１．集約処理 = " + result1);
		System.out.println();

		// 数値要素を保存するコレクションを生成
		List<Integer> ls = new ArrayList<>();
		ls = Arrays.asList(10, 20, 30, 40);

		// ２．数値の集約処理。各要素値の和を求めて、要素数を１つに減らす。要素数を減らすので reduce と言うメソッド名になったと考えられる。
		Integer result2 = ls.stream()
				//.peek(i -> System.out.println("ls:" + i))
				.reduce(0, (total, part) -> {

					System.out.println("total :" + total);
					return total + part;

				});

		System.out.print("２．集約処理 = " + result2);

	}

}
