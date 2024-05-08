package s02q02;

import java.util.ArrayList;
import java.util.List;

class Q02A {

}

class Q02B extends Q02A {

}

class Q02C extends Q02B {

}

public class S02Q02 {

	public static void main(String[] args) {

		List<Q02B> Q02List = new ArrayList<>();

		// Q02List.add(new Q02A());		// (A) NG
		Q02List.add(new Q02B()); // (B) OK
		Q02List.add(new Q02C()); // (C) OK
		// Q02List.add(new String("TEST");	// (D) NG
		// Q02List.add(new Object());		// (E) NG

	}

}
