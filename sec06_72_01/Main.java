package sec06_72_01;

import java.util.function.BinaryOperator;

//BinaryOperator<T> を引数として利用する。
public class Main {

	public static void main(String[] args) {

		// BinaryOperator<T> : R apply(T t, U u);

		// ２個の数字の加算結果を表示する。
		Integer in1 = 80;
		Integer in2 = 20;
		System.out.println("加算結果A = " + (in1 + in2));

		// ２個の数字の加算結果を表示する。但し関数型インタフェースを利用して処理する。
		BinaryOperator<Integer> bio = (b1, b2) -> b1 + b2;
		Integer ans = bio.apply(80, 20);
		// Integer ans = bio.apply(in1, in2);
		System.out.println("加算結果B = " + ans);

		// 四則演算を関数型インタフェースを利用して処理する。
		BinaryOperator<Integer> add = (b1, b2) -> b1 + b2;
		BinaryOperator<Integer> sub = (b1, b2) -> b1 - b2;
		BinaryOperator<Integer> mul = (b1, b2) -> b1 * b2;
		BinaryOperator<Integer> div = (b1, b2) -> b1 / b2;
		System.out.println("加算結果 = " + getArith(add, in1, in2));
		System.out.println("減算結果 = " + getArith(sub, in1, in2));
		System.out.println("乗算結果 = " + getArith(mul, in1, in2));
		System.out.println("除算結果 = " + getArith(div, in1, in2));

	}

	static Integer getArith(BinaryOperator<Integer> bio, Integer i1, Integer i2) {

		return bio.apply(i1, i2);

	}

}
