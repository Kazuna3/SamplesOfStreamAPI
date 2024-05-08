package sec05_60_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		// １．パイプラインにて処理を行う。
		List<String> animal1 = new ArrayList<>();
		animal1 = Arrays.asList("CAT", "DOG", "FOX", "COW", "PIG");
		long cnt1 = animal1.stream().filter(a -> a.charAt(0) == 'C').count();

		// １の確認
		System.out.println("１．cnt1 = " + cnt1);

		// ２．１のパイプライン処理を分解して行う。
		List<String> animal2 = new ArrayList<>();
		animal2 = Arrays.asList("CAT", "DOG", "FOX", "COW", "PIG");
		Stream<String> strm21 = animal2.stream();
		Stream<String> strm22 = strm21.filter(a -> a.charAt(0) == 'C');
		long cnt2 = strm22.count();

		// ２の確認
		System.out.println("２．cnt2 = " + cnt2);

		// 注意：一般的に、実務での実装作業の成果物は、メソッドチェーン（パイプライン）を使用した方が良い。

	}

}
