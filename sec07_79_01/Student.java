package sec07_79_01;

public class Student {

	// 出席番号（学年２桁、クラス名１桁、番号２桁）
	private String key;

	// 名前
	private String name;

	// 点数
	private int mark;

	//評価（合格 or 不合格）
	private String result;

	public Student(String key, String name, int mark) {

		this.key = key;
		this.name = name;
		this.mark = mark;
		this.result = null;

	}

	public String getKey() {

		return key;

	}

	//	public void setKey(String key) {
	//	
	//		this.key = key;
	//	
	//	}

	public String getName() {

		return name;

	}

	//	public void setName(String name) {
	//
	//		this.name = name;
	//
	//	}

	public int getMark() {

		return mark;

	}

	//	public void setMark(int mark) {
	//
	//		this.mark = mark;
	//
	//	}

	public String getResult() {

		return result;

	}

	// 合否結果
	public void setResult(String result) {

		this.result = result;

	}

	// 表示用メソッド
	public void printDetail() {

		String result_ = "";

		if (getResult() != null) {

			result_ = getResult();

		}

		System.out.println(getKey() + " " + getName() + " " + getMark() + " " + result_);

	}

}
