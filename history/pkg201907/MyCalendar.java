package history.pkg201907;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar {

    class CalendarItem {

        int start;
        int end;
    }

    private final List<CalendarItem> calendarItems = new ArrayList<>();

    public MyCalendar() {

    }

    public boolean book(final int start, final int end) {
        if (!this.hasItem(start, end)) {
            final CalendarItem calendarItem = new CalendarItem();
            calendarItem.start = start;
            calendarItem.end = end;
            this.calendarItems.add(calendarItem);
            return true;
        }
        return false;
    }

    private boolean hasItem(final int start, final int end) {

        // �ж�start�ڲ���ĳ����Χ��
        for (int i = 0; i < this.calendarItems.size(); i++) {
            final CalendarItem calendarItem = this.calendarItems.get(i);
            // ��һ�����
            if ((calendarItem.start < start && calendarItem.end > start)
                    || (calendarItem.start < end && calendarItem.end > end)) {
                return true;
            }
            // �ڶ������
            if (calendarItem.start >= start && calendarItem.end <= end) {
                return true;
            }
        }
        return false;
    }
}
