package generic_utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JavaUtility {
	public static String currentTime() {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);

		return DateTimeFormatter.ofPattern("HHmmss_ddMMyyyy").format(now);
	}

	public static int generateRandomNum() {
		double random = Math.random() * 9999;
		int ranNum = (int) random;

		return ranNum;
	}
}
