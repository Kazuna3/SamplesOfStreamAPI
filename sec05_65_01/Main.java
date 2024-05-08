package sec05_65_01;

import java.util.Arrays;
import java.util.List;

public class Main {

	// 動物名取得メソッド
	static String getJAnimal(String eAnimal, String[][] name) {

		for (int i = 0; i < name.length; ++i) {

			if (eAnimal.equals(name[i][0])) {

				return name[i][1];

			}

		}

		return null;

	}

	public static void main(String[] args) {

		// 【ストリーム API 練習問題２】
		// 処理対象コレクション
		List<String> allAnimal = Arrays.asList("CAT", "COW", "DOG", "FOX");

		// 動物名称の２次元配列
		String[][] animalName = {
				{ "CAT", "猫" },
				{ "COW", "牛" },
				{ "DOG", "犬" },
				{ "FOX", "狐" },
		};

		// １．ラムダ式を使わない Java7 以前の実装例。
		System.out.println("１．ラムダ式を使わない Java7 以前の実装例。");

		for (String s : allAnimal) {

			String english = s.substring(0, 3);
			String japan = getJAnimal(english, animalName);
			System.out.println(english + "は" + japan + "です。");

		}

		// ２．forEach のみ使う実装例。
		System.out.println("２．forEach のみ使う実装例。");

		allAnimal.forEach(s -> {

			String english = s.substring(0, 3);
			String japan = getJAnimal(english, animalName);
			System.out.println(english + "は" + japan + "です。");

		});

		// ３．map と forEach を使う実装例。
		System.out.println("３．map と forEach を使う実装例。");

		allAnimal.stream()
				.map(s -> s.substring(0, 3) + "は" + getJAnimal(s.substring(0, 3), animalName) + "です。")
				.forEach(s -> System.out.println(s));

	}

}
