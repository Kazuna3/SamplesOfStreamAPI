package sec03_30_02;

public class Main {

	public static void main(String[] args) {

		MHRConsumer<String> con1 = new MHRConsumer<String>() {

			@Override
			public void accept(String t) {

				System.out.println("con1");
				System.out.println("con1 文字列[" + t + "]の大文字 : " + t.toUpperCase());

			}

		};

		//con1.accept("hoge");

		MHRConsumer<String> con2 = new MHRConsumer<String>() {

			@Override
			public void accept(String t) {

				System.out.println("con2");
				System.out.println("con2 文字列[" + t + "]の length : " + t.length());

			}

		};

		//con2.accept("fuga");

		MHRConsumer<String> con3 = con1.andThen(con2);
		con3.accept("abc");

		MHRConsumer<String> con4 = new MHRConsumer<String>() {

			@Override
			public void accept(String t) {

				System.out.println("con4 accept");
				System.out.println("con4 文字列[" + t + "]の小文字 :  " + t.toLowerCase());

			}

			@Override
			public MHRConsumer<String> andThen(MHRConsumer<? super String> after) {

				System.out.println("con4 andThen");
				return MHRConsumer.super.andThen(after);

			}

		};

		MHRConsumer<String> con5 = con4.andThen(con1);
		con5.accept("ABC_efg");

	}

}
