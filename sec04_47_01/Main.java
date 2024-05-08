package sec04_47_01;

@FunctionalInterface
interface Q02Interface<T> {

	void accept(T t);

}

public class Main {

	public static void main(String[] args) {

		// ■練習問題０２
		System.out.println("■練習問題０２");

		// １．抽象メソッドをオバーライドする方法
		System.out.println("\n【１．抽象メソッドをオバーライドする方法】");

		Q02Interface<String> q02 = new Q02Interface<>() {

			public void accept(String str) {

				System.out.println(str);

			}

		};
		q02.accept("練習問題０２ 方法１");

		Q02Interface<String> q = str -> System.out.println(str);
		q.accept("練習問題０２ 方法２");

	}

}
