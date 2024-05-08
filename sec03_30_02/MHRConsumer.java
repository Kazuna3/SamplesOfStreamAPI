package sec03_30_02;

public interface MHRConsumer<T> {

	void accept(T t);

	default MHRConsumer<T> andThen(MHRConsumer<? super T> after) {

		//Objects.requireNonNull(after);
		return (T t) -> {

			accept(t);
			after.accept(t);

		};

	}

}
