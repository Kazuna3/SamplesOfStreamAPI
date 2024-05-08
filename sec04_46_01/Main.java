package sec04_46_01;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		System.out.println("正解は、B, C, B, A。");

		// 問題１
		// Consumer<String> con1 = System.out.println(s);		// (A)
		Consumer<String> con2 = s -> System.out.println(s); // (B)
		// Consumer<String> con3 = s -> return (s + "AB");		// (C)

		// 問題２
		// Supplier<String> sup1 = return s + "AB";			// (A)
		// Supplier<String> sup2  =  s -> return s + "AB";		// (B)
		Supplier<String> sup3 = () -> {

			return "AB";

		}; // (C)

		// 問題３
		// Function<String, Integer> fun1 = return 100;		// (A)
		Function<String, Integer> fun2 = s -> 100; // (B)
		// Function<String, Integer> fun3 = s -> return 100;	// (C)

		// 問題４
		Predicate<String> pre1 = s -> {

			s = s + "AB";
			return false;

		}; // (A)
			// Predicate<String> pre2 = s -> {false};							// (B)
			// Predicate<String> pre3 = s -> retrun false;						// (C)

	}

}
