package sec05_57_01;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		// ストリームの中間操作２（文字列操作）map

		// 【補足】本 Section 5 の No 57 で、stream の終端操作であるメソッド collect の説明があった。
		System.out.println("【補足】");
		System.out.println("本 Section 5 の No 57 で、stream の終端操作であるメソッド collect の説明があった。");

		List<String> zoo = Arrays.asList("CaT", "D8G", "F8x", "C8W", "Li8N", "W8LF");

		// 初期値を表示する。
		System.out.print("\n初期値：\n　　");
		zoo.stream().forEach(str -> System.out.print(str + " "));

		// １．全動物の名称を大文字に変換して表示する。
		System.out.print("\n１．");
		zoo
				.stream()
				.map(str -> str.toUpperCase())
				.forEach(str -> System.out.print(str + " "));

		// ２．全動物の名称に含まれる'8'を'0'に変換して表示する。
		System.out.print("\n２．");
		zoo
				.stream()
				.map(str -> str.replace("8", "O"))
				.forEach(str -> System.out.print(str + " "));

		// ３．全動物の名称の先頭に昇順の番号を追加して表示する。
		System.out.print("\n３．");

		AtomicInteger cnt = new AtomicInteger(1);

		zoo
				.stream()
				.map(str -> cnt.getAndIncrement() + "." + str)
				.forEach(str -> System.out.print(str + " "));

		// ４．１～３の処理を、メソッドチェーン（パイプライン）とした実装例。※処理結果のデータは保存できていない。）
		System.out.print("\n４．");
		cnt.set(1); // カウンターオブジェクトを１で初期化する。
		zoo
				.stream()
				.map(str -> str.toUpperCase())
				.map(str -> str.replace("8", "O"))
				.map(str -> cnt.getAndIncrement() + "." + str)
				.forEach(str -> System.out.print(str + " "));

		// ５．４と同等の処理の結果を保存する実装例。
		System.out.print("\n５．データの表示処理は６にて実行する。");
		cnt.set(1); // カウンターオブジェクトを１で初期化する。
		List<String> lastAnimal = zoo
				.stream()
				.map(str -> str.toUpperCase())
				.map(str -> str.replace("8", "O"))
				.map(str -> cnt.getAndIncrement() + "." + str)
				// 次行によって、全ての中間処理を施した結果のデータを、List 型のオブジェクトにセットできる。
				.collect(Collectors.toList());

		// ６．５の処理結果を表示する。
		System.out.print("\n６．");
		lastAnimal.stream().forEach(str -> System.out.print(str + " "));

	}

}
