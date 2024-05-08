package s02q01;

public class Main {

	public static void main(String[] args) {

		S02Q01T<String> s02q01t_str = new S02Q01T<>();
		s02q01t_str.set("Hoge");
		System.out.println(s02q01t_str.get());

		S02Q01T<Integer> s02q01t_int = new S02Q01T<>();
		s02q01t_int.set(123);
		System.out.println(s02q01t_int.get());

	}

}
