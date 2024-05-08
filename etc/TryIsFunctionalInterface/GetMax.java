package etc.TryIsFunctionalInterface;

/**
 * 本インターフェースは、抽象メソッドが２つ以上存在しても、関数型インターフェースとして機能するのか確認するために実装した。
 * Objectクラスのメソッドを、抽象メソッドとして実装しても、そのメソッドは、抽象メソッドとしてカウントされないという
 * 仕様があるらしい。maxメソッドのみが、本インターフェースの唯一の抽象メソッドとして、認識されている事が確認できた。
 * @author Kazunari
 *
 * @param <T>
 */
@FunctionalInterface
public interface GetMax<T> {

	T max(T t1, T t2);

	boolean equals(Object obj);

	String toString();

}
