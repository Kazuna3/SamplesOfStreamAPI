package sec07_79_01;

import java.util.Comparator;

// ソート クラス
public class SortRule implements Comparator<Student> {

	public int compare(Student s1, Student s2) {

		// 降順
		// return new Integer(s2.getMark()).compareTo(s1.getMark());
		return compare(s2.getMark(), s1.getMark());

		// 昇順
		// return compare(s1.getMark(), s2.getMark());

	}

	private int compare(int x, int y) {

		return (x < y) ? -1 : ((x == y) ? 0 : 1);

	}

}
