package sec03_24;

import java.util.function.Function;

interface Hoge {

	void print(String str);

	static int kasan(int a, int b) {

		return a + b;

	}

}

public class Main {

	public static void main(String[] args) {

		int result = Hoge.kasan(100, 200);
		System.out.println(result);

		Function<Integer, String> fnc = new Function<Integer, String>() {

			@Override
			public String apply(Integer i) {

				return i.toString();

			}

		};

		System.out.println(fnc.apply(555));

	}

}
