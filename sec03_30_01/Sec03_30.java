package sec03_30_01;

import java.util.function.Consumer;

public class Sec03_30 {

	public static void main(String[] args) {

		Consumer<String> con1 = new Consumer<String>() {

			@Override
			public void accept(String t) {

				System.out.println("con1");
				System.out.println("con1 文字列[" + t + "]の大文字 : " + t.toUpperCase());

			}

		};

		con1.accept("hoge");

		Consumer<String> con2 = new Consumer<String>() {

			@Override
			public void accept(String t) {

				System.out.println("con2");
				System.out.println("con2 文字列[" + t + "]の length : " + t.length());

			}

		};

		con2.accept("fuga");

		Consumer<String> con3 = new Consumer<String>() {

			@Override
			public void accept(String t) {

				System.out.println("con3 accept");
				System.out.println("con3 文字列[" + t + "]の小文字 : " + t.toLowerCase());

			}

			@Override
			public Consumer<String> andThen(Consumer<? super String> after) {

				System.out.println("con3 andThen");
				return Consumer.super.andThen(after);

			}

		};

		Consumer<String> con4 = con3.andThen(con1);
		con4.accept("ABC_efg");

	}

}
