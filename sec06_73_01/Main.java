package sec06_73_01;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

//関数型インタフェースを利用して検索を行う。
public class Main {

	public static void main(String[] args) {

		Map<String, String> bloodMap = new HashMap<>();
		bloodMap.put("A", "威風堂々として人です。");
		bloodMap.put("B", "芸術に優れた人です。");
		bloodMap.put("O", "責任感の強い人です。");
		bloodMap.put("AB", "几帳面な人です。");

		// BiFunction<T, U, R>
		// R apply(T t, U u);
		BiFunction<Map<String, String>, String, String> bif = (map, key) -> map.get(key);

		String bloodType = "AB";
		String bloodTypeExplanation = bif.apply(bloodMap, bloodType);
		System.out.println("血液型の " + bloodType + "型は" + bloodTypeExplanation);

	}

}
