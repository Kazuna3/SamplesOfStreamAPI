package sec04_43_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<String> ls = new ArrayList<>();
		ls = Arrays.asList("Cat", "Dog", "Cow", "Fox");

		// forEach(Consumer<? super E> action)

		/*
		Consumer<String> con = new Consumer<>() {
		
			public void accept(String str) {
		
				System.out.println(str);
		
			};
		
		};
		*/

		ls.forEach(str -> System.out.println(str));
		System.out.println("------------------------------------");
		ls.forEach(System.out::println);

	}

}
