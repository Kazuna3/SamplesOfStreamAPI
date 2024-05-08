package sec05_64_01;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		// 【ストリーム API 練習問題１】
		List<String> allAnimal = Arrays.asList("[CAT：猫]", "[COW：牛]", "[DOG：犬]", "[FOX：狐]");

		// １．ラムダ式を使わない Java7 以前の実装例。
		System.out.println("１．ラムダ式を使わない Java7 以前の実装例。");

		for (String s : allAnimal) {

			String english = s.substring(1, 4);
			String japan = s.substring(5, 6);
			System.out.println(english + "は" + japan + "です。");

		}

		// ２．forEach のみ使う実装例。
		System.out.println("２．forEach のみ使う実装例。");

		allAnimal.forEach(s -> System.out.println(s.substring(1, 4) + "は" + s.substring(5, 6) + "です。"));

		// ３．map と forEach を使う実装例。
		System.out.println("３．map と forEach を使う実装例。");

		allAnimal.stream()
				.map(s -> s.substring(1, 4) + "は" + s.substring(5, 6) + "です。")
				.forEach(s -> System.out.println(s));

	}

}
