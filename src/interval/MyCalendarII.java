// https://leetcode.com/problems/my-calendar-ii/

package interval;

import java.util.TreeMap;

public class MyCalendarII {

    private TreeMap<Integer, Integer> delta;

    public MyCalendarII() {
        delta = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        delta.put(start, delta.getOrDefault(start, 0) + 1);
        delta.put(end, delta.getOrDefault(end, 0) - 1);

        int count = 0;

        for (int d : delta.values()) {
            count += d;
            if (count >= 3) {
                delta.put(start, delta.get(start) - 1);
                delta.put(end, delta.get(end) + 1);

                if (delta.get(start) == 0) delta.remove(start);
                if (delta.get(end) == 0) delta.remove(end);

                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MyCalendarII calendarI = new MyCalendarII();
        System.out.println(calendarI.book(10, 20));
        System.out.println(calendarI.book(15, 25));
        System.out.println(calendarI.book(20, 30));
    }
}
