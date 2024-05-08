package etc;

import java.util.function.Consumer;

/**
 * @author Bing の Copilot が生成したコードである。
 *
 * @param <T>
 * Consumer の API に記載されていた「合成 Consumer」について、問い合わせした際の回答が、このコードである。
 */
public class CompositeConsumer<T> implements Consumer<T> {

	private final Consumer<T> firstOperation;
	private final Consumer<T> afterOperation;

	public CompositeConsumer(Consumer<T> firstOperation, Consumer<T> afterOperation) {

		this.firstOperation = firstOperation;
		this.afterOperation = afterOperation;

	}

	@Override
	public void accept(T input) {

		firstOperation.accept(input);
		afterOperation.accept(input);

	}

	public static void main(String[] args) {

		// 例: 文字列を大文字に変換してから表示する合成Consumer
		Consumer<String> toUpperCase = s -> System.out.println(s.toUpperCase());
		Consumer<String> printLength = s -> System.out.println("Length: " + s.length());

		CompositeConsumer<String> composite = new CompositeConsumer<>(toUpperCase, printLength);
		composite.accept("hello");

	}

}