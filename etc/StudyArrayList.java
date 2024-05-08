package etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StudyArrayList {

	public static void main(String[] args) {

		System.out.println("■処理 A");
		List<String> animals_A = new ArrayList<>();
		animals_A = Arrays.asList("CAT", "DOG", "FOX");

		// animals_A.add("Sheep");	// 左は実行時エラーとなる。理由は次の通り。

		/*
		 * 直上のコメント行は、実行時エラーとなる。
		 * Arrays.asList() が返すインスタンスは、java.util.Arraysの内部クラスのArrayListであるため、
		 * addやremoveで要素を追加したり削除することができなくなる。故に要注意である！
		 */

		Stream<String> strm1 = animals_A.stream();
		strm1.forEach(System.out::println);

		System.out.println("■処理 B");
		List<String> animals_B = new ArrayList<>(Arrays.asList("CAT", "DOG", "FOX"));
		animals_B.add("Elephant");

		Stream<String> strm2 = animals_B.stream();
		strm2.forEach(System.out::println);

		System.out.println("■処理 C");
		List<String> animals_C = new ArrayList<>() {

			{

				add("CAT");
				add("DOG");
				add("FOX");

			}

		};
		animals_C.add("Mouse");

		Stream<String> strm3 = animals_C.stream();
		strm3.forEach(System.out::println);

	}

}
