package sec06_74_01;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

//関数型インタフェースをコレクション要素として利用する。
public class Main {

	public static void main(String[] args) {

		// BinaryOperator<T> : R apply(T t, U u);

		// 計算用の数字を用意する。
		Integer in1 = 80;
		Integer in2 = 20;

		// 四則演算を関数型インタフェースを利用して処理する。
		BinaryOperator<Integer> add = (b1, b2) -> b1 + b2;
		BinaryOperator<Integer> sub = (b1, b2) -> b1 - b2;
		BinaryOperator<Integer> mul = (b1, b2) -> b1 * b2;
		BinaryOperator<Integer> div = (b1, b2) -> b1 / b2;

		// BinaryOperator インスタンスを List の要素とする。
		List<BinaryOperator<Integer>> ls = new ArrayList<>();

		ls.add(add);
		ls.add(sub);
		ls.add(mul);
		ls.add(div);

		// 四則演算表示メソッドの実行。
		printArith(ls, in1, in2);

	}

	static void printArith(List<BinaryOperator<Integer>> ls, Integer i1, Integer i2) {

		BinaryOperator<Integer> add = ls.get(0);
		BinaryOperator<Integer> sub = ls.get(1);
		BinaryOperator<Integer> mul = ls.get(2);
		BinaryOperator<Integer> div = ls.get(3);

		System.out.println("加算結果 = " + add.apply(i1, i2));
		System.out.println("減算結果 = " + sub.apply(i1, i2));
		System.out.println("乗算結果 = " + mul.apply(i1, i2));
		System.out.println("除算結果 = " + div.apply(i1, i2));

	}

}
