package package_in_201907;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar {

	class CalendarItem {
		int start;
		int end;
	}

	private List<CalendarItem> calendarItems = new ArrayList<>();

	public MyCalendar() {

	}

	public boolean book(int start, int end) {
		if (!this.hasItem(start, end)) {
			CalendarItem calendarItem = new CalendarItem();
			calendarItem.start = start;
			calendarItem.end = end;
			calendarItems.add(calendarItem);
			return true;
		}
		return false;
	}

	private boolean hasItem(int start, int end) {

		// 判断start在不在某个范围内
		for (int i = 0; i < calendarItems.size(); i++) {
			CalendarItem calendarItem = calendarItems.get(i);
			// 第一种情况
			if ((calendarItem.start < start && calendarItem.end > start)
					|| (calendarItem.start < end && calendarItem.end > end)) {
				return true;
			}
			// 第二种情况
			if (calendarItem.start >= start && calendarItem.end <= end) {
				return true;
			}
		}
		return false;
	}
}
