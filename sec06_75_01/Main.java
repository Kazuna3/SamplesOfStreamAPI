package sec06_75_01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// ストリームを引数や戻り値として利用する。
public class Main {

	public static void main(String[] args) {

		Stream<String> stream1 = Stream.of("CAT", "DOG", "FOX");
		printStream(stream1);

		List<String> list = Arrays.asList("PANDA", "LION", "MOUSE");
		Stream<String> stream2 = getStream(list);
		printStream(stream2);

	}

	// Stream<String> を画面表示する。
	static void printStream(Stream<String> stream) {

		System.out.println();
		stream.forEach(s -> System.out.println(s));

	}

	// Stream<String> を戻り値とする。
	static Stream<String> getStream(List<String> ls) {

		Stream<String> stream = ls.stream();
		return stream;

	}

}
