package sec04_39_40_41;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * 【セクション4:04 ラムダ式とメソッド参照】
 * 確認の為に実装した。
 * 
 * @author Kazunari
 *
 */
public class Refer {

	public static void main(String[] args) {

		valueOf_StaticMethodRef(123);
		valueOf_Lambda(456);

		toUpperCase_InstanceMethodRef("abc");
		toUpperCase_Lambda("def");

		new_ConstructorRef();
		new_Lambda();

	}

	/* ↓↓↓スタティック メソッド参照の確認用プログラムの開始位置↓↓↓ */
	/**
	 * valueOf をスタティック メソッド参照で実装した。
	 */
	static void valueOf_StaticMethodRef(int paraInt) {

		Function<Integer, String> fnc = String::valueOf;
		System.out.println(fnc.apply(paraInt));

	}

	/**
	 * valueOf をラムダ式で実装した。
	 */
	static void valueOf_Lambda(int paraInt) {

		Function<Integer, String> fnc = i -> String.valueOf(i);
		System.out.println(fnc.apply(paraInt));

	}
	/* ↑↑↑スタティック メソッド参照の確認用プログラムの修了位置↑↑↑ */

	/* ↓↓↓インスタンス メソッド参照の確認用プログラムの開始位置↓↓↓ */
	/**
	 * toUpperCase をインスタンス メソッド参照で実装した。
	 */
	static void toUpperCase_InstanceMethodRef(String paraStr) {

		UnaryOperator<String> uOpe = String::toUpperCase;
		System.out.println(uOpe.apply(paraStr));

	}

	/**
	 * toUpperCase をラムダ式で実装した。
	 */
	static void toUpperCase_Lambda(String paraStr) {

		UnaryOperator<String> uOpe = s -> s.toUpperCase();
		System.out.println(uOpe.apply(paraStr));

	}
	/* ↑↑↑インスタンス メソッド参照の確認用プログラムの修了位置↑↑↑ */

	/* ↓↓↓コンストラクタ参照の確認用プログラムの開始位置↓↓↓ */
	/**
	 * コンストラクタ参照で実装した。
	 */
	static void new_ConstructorRef() {

		Supplier<String> sp = String::new;
		System.out.println("[" + sp.get() + "]");

	}

	/**
	 * ラムダ式で実装した。
	 */
	static void new_Lambda() {

		// 次行は、最も省略したコードである。
		// Supplier<String> sp = () -> new String();

		Supplier<String> sp = () -> {

			return new String();

		};

		System.out.println("[" + sp.get() + "]");

	}
	/* ↑↑↑コンストラクタ参照の確認用プログラムの修了位置↑↑↑ */

}
