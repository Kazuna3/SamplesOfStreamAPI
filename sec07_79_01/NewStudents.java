package sec07_79_01;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NewStudents {

	private List<Student> std;

	public NewStudents() {

		std = Arrays.asList(
				new Student("01A01", "青木", 50),
				new Student("01A02", "青山", 70),
				new Student("01B01", "伊藤", 40),
				new Student("01B02", "伊林", 90),
				new Student("02A01", "川井", 60),
				new Student("02A02", "川村", 80));

	}

	// List<Student> 
	public List<Student> getStd() {

		return std;

	}

	// List<Student> を Map<String, Student>へ変換して返す。
	public Map<String, Student> getMap() {

		Map<String, Student> mapd = std.stream().collect(Collectors.toMap(s -> s.getKey(), s -> s));
		return mapd;

	}

}
