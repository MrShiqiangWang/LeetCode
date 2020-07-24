package history.pkg202007;

public class L1185 {
	public static void main(String[] args) {
		System.out.println(new L1185().dayOfTheWeek(1, 1, 1971));
		System.out.println(new L1185().dayOfTheWeek(18, 7, 1999));
		System.out.println(new L1185().dayOfTheWeek(15, 8, 1993));
		System.out.println(new L1185().dayOfTheWeek(21, 12, 1980));
	}

	public String dayOfTheWeek(int day, int month, int year) {
		String[] weeks = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		// 到今年的一月一号的天数
		int sum = 0;
		for (int i = 1971; i < year; i++) {
			if (isRunNian(i)) {
				sum += 366;
				continue;
			}
			sum += 365;
		}

		for (int i = 1; i < month; i++) {
			if (i == 2) {
				if (isRunNian(year)) {
					sum += 29;
				} else {
					sum += 28;
				}
				continue;
			}
			if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
				sum += 31;
				continue;
			}
			sum += 30;
		}
		sum += day;

		sum += 4;
		return weeks[sum % 7];
	}

	private boolean isRunNian(int year) {
		if (year % 100 == 0 && year % 400 == 0) {
			return true;
		}
		if (year % 100 != 0 && year % 4 == 0) {
			return true;
		}
		return false;
	}
}
