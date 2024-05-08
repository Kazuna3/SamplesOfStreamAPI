package sec04_40_02;

import java.util.ArrayList;
import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) {

		Supplier<String> spStr_anonymous = new Supplier<>() {

			@Override
			public String get() {

				return "Hoge";

			}

		};
		System.out.println("spStr_anonymous: " + spStr_anonymous.get());

		Supplier<String> spStr_lambda_1 = () -> "Hoge";
		System.out.println("spStr_lambda_1: " + spStr_lambda_1.get());

		Supplier<String> spStr_ref = String::new;
		System.out.println("spStr_ref: " + spStr_ref.get());

		System.out.println("------------------------------------");

		Supplier<ArrayList<String>> spList_anonymous = new Supplier<>() {

			@Override
			public ArrayList<String> get() {

				return new ArrayList<String>() {

					{

						add("hoge");
						add("fuga");

					}

				};

			}

		};
		System.out.println("spList_anonymous: " + spList_anonymous.get());

		Supplier<ArrayList<String>> spList_lambda_1 = () -> new ArrayList<String>() {

			{

				add("hoge");
				add("fuga");

			}

		};
		System.out.println("spList_lambda_1: " + spList_lambda_1.get());

		Supplier<ArrayList<String>> spList_ref = ArrayList<String>::new;
		System.out.println("spList_ref: " + spList_ref.get());

	}

}
