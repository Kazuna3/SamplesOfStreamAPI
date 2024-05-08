package sec04_45_01;

import java.util.function.Consumer;

public interface AllAnimalLambda {

	static final Consumer<String> cs1 = str -> System.out.println(str);

	static final Consumer<String> cs2 = str -> {

		System.out.println("CAT");
		System.out.println(str);

	};

	static final Consumer<String> cs3 = str -> {

		System.out.println("CAT");
		System.out.println("DOG");
		System.out.println(str);

	};

}
