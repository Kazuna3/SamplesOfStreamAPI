package sec05_62_01;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		// 【補足】本 Section 5 の No 62 のレクチャーのソースは、一部が不明であり、瑕疵だった。
		System.out.println("【補足】");
		System.out.println("本 Section 5 の No 62 のレクチャーのソースは、一部が不明であり、瑕疵だった。");

		// 【ストリームの型変換の実装例。】
		System.out.println("【ストリームの型変換の実装例。】");

		// １．Stream<String> を Stream<Integer> に変換する。
		System.out.println("１．Stream<String> を Stream<Integer> に変換する。");
		Stream<String> streamString1 = Stream.of("10", "20", "30");
		Stream<Integer> streamInteger1 = streamString1.map(s -> Integer.valueOf(s));
		System.out.print("streamInteger1 = ");
		streamInteger1.forEach(i -> System.out.print(" " + i));

		// ２．Stream<String> を IntStream に変換する。
		System.out.println("\n２．Stream<String> を IntStream に変換する。");
		Stream<String> streamString2 = Stream.of("40", "50", "60");
		IntStream intStream2 = streamString2.mapToInt(s -> Integer.valueOf(s));
		System.out.print("intStream2 = ");
		intStream2.forEach(i -> System.out.print(" " + i));

		// ３．Stream<Integer> を Stream<String> に変換する。
		System.out.println("\n３．Stream<Integer> を Stream<String> に変換する。");
		Stream<Integer> streamInteger3 = Stream.of(70, 80, 90);
		Stream<String> streamString3 = streamInteger3.map(i -> String.valueOf(i));
		System.out.print("streamString3 = ");
		streamString3.forEach(i -> System.out.print(" " + i));

		// ４．Stream<Integer> を IntStream に変換する。
		System.out.println("\n４．Stream<Integer> を IntStream に変換する。");
		Stream<Integer> streamInteger4 = Stream.of(100, 110, 120);
		IntStream intStream4 = streamInteger4.mapToInt(i -> Integer.valueOf(i));
		System.out.print("intStream4 = ");
		intStream4.forEach(i -> System.out.print(" " + i));

		// ５．IntStream を Stream<String> に変換する。
		System.out.println("\n５．IntStream を Stream<String> に変換する。");
		IntStream intStream5 = IntStream.of(130, 140, 150);
		Stream<String> streamString5 = intStream5.mapToObj(i -> String.valueOf(i));
		System.out.print("streamString5 = ");
		streamString5.forEach(i -> System.out.print(" " + i));

		// ６．IntStream を Stream<Integer> に変換する。
		System.out.println("\n６．IntStream を Stream<Integer> に変換する。");
		IntStream intStream6 = IntStream.of(160, 170, 180);
		Stream<Integer> streamInteger6 = intStream6.boxed();
		System.out.print("streamInteger6 = ");
		streamInteger6.forEach(i -> System.out.print(" " + i));

	}

}
