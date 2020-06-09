// https://leetcode.com/problems/my-calendar-i/

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarI {
    private TreeMap<Integer, Integer> intervals;

    public MyCalendarI() {
        intervals = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> floorEntry = intervals.floorEntry(start);
        Integer ceilingStart = intervals.ceilingKey(start);

        if (floorEntry != null && floorEntry.getValue() > start ||
                ceilingStart != null && ceilingStart < end) return false;

        intervals.put(start, end);

        return true;
    }

    public static void main(String[] args) {
        MyCalendarI calendarI = new MyCalendarI();
        System.out.println(calendarI.book(10, 20));
        System.out.println(calendarI.book(15, 25));
        System.out.println(calendarI.book(20, 30));
    }
}
