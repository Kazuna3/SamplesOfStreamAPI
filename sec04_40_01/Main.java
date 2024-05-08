package sec04_40_01;

import java.util.function.UnaryOperator;

public class Main {

	public static void main(String[] args) {

		UnaryOperator<String> uo_anonymous = new UnaryOperator<>() {

			@Override
			public String apply(String t) {

				return t.toUpperCase();

			}

		};
		System.out.println("uo_anonymous" + uo_anonymous.apply("ABC_def_ghi"));

		UnaryOperator<String> uo_lambda_1 = (String t) -> t.toUpperCase();
		System.out.println("uo_lambda_1 :" + uo_lambda_1.apply("ABC_def_ghi"));

		UnaryOperator<String> uo_lambda_2 = t -> t.toUpperCase();
		System.out.println("uo_lambda_2 :" + uo_lambda_2.apply("ABC_def_ghi"));

		UnaryOperator<String> uo_method_ref = String::toUpperCase;
		System.out.println("uo_method_ref :" + uo_method_ref.apply("ABC_def_ghi"));

	}

}
