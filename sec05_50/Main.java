package sec05_50;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import sec07_79_01.Student;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// 1.ストリームの種類

		// 1.1 Stream<T>
		Stream<String> stream111 = Stream.of("CAT", "FOX", "PIG"); // T は String

		Stream<Student> stream112 = Stream.of( // T は Student
				new Student("01A01", "青木", 50),
				new Student("01A02", "青山", 70),
				new Student("01B01", "伊藤", 40));

		// 1.2 IntStream
		IntStream stream12 = IntStream.of(100, 200, 300);

		// 1.3 LongStream
		LongStream stream13 = LongStream.of(100, 200, 300);

		// 1.4 DoubleStream
		DoubleStream stream14 = DoubleStream.of(100.0, 200.0, 300.0);

		// 2.パイプラインの例
		Stream<String> stream21 = Stream.of("CAT", "FOX", "PIG", "COW", "BAT", "DOG");
		// ストリームのデータをソートして、上位４までを表示する。
		stream21.sorted().limit(4).forEach(s -> System.out.println(s));

	}

}
