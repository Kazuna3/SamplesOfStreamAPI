package sec04_44_01;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {

	public static void main(String[] args) {

		// 		■ラムダ式による文字列操作
		System.out.println("■ラムダ式による文字列操作");

		String baseChar = " CAT dog FOX cow ";

		// １．スペースサプレス結果の取得
		System.out.println("\n【１．スペースサプレス結果の取得】");

		String result71 = baseChar.trim();
		System.out.println("【SE7】result71 : \"" + result71 + "\"");

		UnaryOperator<String> uo81 = str -> str.trim();
		String result81 = uo81.apply(baseChar);
		System.out.println("【SE8】result81 : \"" + result81 + "\"");

		// ２．文字列長の取得
		System.out.println("\n【２．文字列長の取得】");

		Integer result72 = baseChar.length();
		System.out.println("【SE7】result72 : " + result72);

		Function<String, Integer> fc82 = str -> str.length();
		Integer result82 = fc82.apply(baseChar);
		System.out.println("【SE8】result82 : " + result82);

		// ３．指定位置の文字の取得（その１）
		System.out.println("\n【３．指定位置の文字の取得（その１）】");

		Character result73 = baseChar.charAt(1);
		System.out.println("【SE7】result73 : " + result73);

		Function<String, Character> fc83 = str -> str.charAt(1);
		Character result83 = fc83.apply(baseChar);
		System.out.println("【SE8】result83 : " + result83);

		// ４．指定位置の文字の取得（その２）※処理内容は、３と同じ
		System.out.println("\n【４．指定位置の文字の取得（その２）※処理内容は、３と同じ】");

		int in1 = 1;

		Character result74 = baseChar.charAt(in1);
		System.out.println("【SE7】result74 : " + result74);

		BiFunction<String, Integer, Character> biFc84 = (str, itg) -> str.charAt(itg);
		Character result84 = biFc84.apply(baseChar, in1);
		System.out.println("【SE8】result84 : " + result84);

		// ５．検索対象文字列の存在確認（その１）
		System.out.println("\n【５．検索対象文字列の存在確認（その１）");

		boolean result75 = baseChar.contains("FOX");
		System.out.println("【SE7】result75 : " + result75);

		Function<String, Boolean> fc85 = str -> str.contains("FOX");
		Boolean result85 = fc85.apply(baseChar);
		System.out.println("【SE8】result85 : " + result85);

		// ６．検索対象文字列の存在確認（その２）※処理内容は、５と同じ
		System.out.println("\n【６．検索対象文字列の存在確認（その２）※処理内容は、５と同じ");

		String search = "FOX";
		boolean result76 = baseChar.contains(search);
		System.out.println("【SE7】result76 : " + result76);

		BiFunction<String, String, Boolean> biFc86 = (str1, str2) -> str1.contains(str2);
		Boolean result86_1 = biFc86.apply(baseChar, search);
		System.out.println("【SE8】result86_1 : " + result86_1);

		BiPredicate<String, String> biPrd86 = (str1, str2) -> str1.contains(str2);
		Boolean result86_2 = biPrd86.test(baseChar, search);
		System.out.println("【SE8】result86_2 : " + result86_2);

		// ７．１と６を連続して行う（その１）
		System.out.println("\n【７．１と６を連続して行う（その１）");

		Boolean result87 = biFc86.apply(uo81.apply(baseChar), search);
		System.out.println("【SE8】result87 : " + result87);

		// ８．１と６を連続して行う（その２）
		System.out.println("\n【８．１と６を連続して行う（その２）");

		BiFunction<String, String, Boolean> biFc88 = (str1, str2) -> str1.trim().contains(str2);
		Boolean result88 = biFc88.apply(baseChar, search);
		System.out.println("【SE8】result88 : " + result88);

	}

}
