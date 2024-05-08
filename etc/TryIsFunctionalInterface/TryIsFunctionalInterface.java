package etc.TryIsFunctionalInterface;

public class TryIsFunctionalInterface {

	public static void main(String[] args) {

		GetMax<Integer> getMax = (i1, i2) -> {

			if (i1 > i2) {

				return i1;

			} else {

				return i2;

			}

		};

		printMax(getMax, 50, 50);

		System.out.println(getMax.toString());

		GetMax<Integer> getMax2 = getMax;

		System.out.println("getMax と getMax2は、等しいか？：" + getMax.equals(getMax2));

		GetMax<Integer> getMax3 = null;

		System.out.println("getMax と getMax3は、等しいか？：" + getMax.equals(getMax3));

	}

	static void printMax(GetMax<Integer> gm, Integer t, Integer u) {

		System.out.println("値：" + t + "と、値：" + u + "で、大きい値は、" + gm.max(t, u) + "です。");

	}

}
