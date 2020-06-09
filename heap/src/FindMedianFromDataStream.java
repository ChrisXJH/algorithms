import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {

    private Queue<Integer> left;

    private Queue<Integer> right;

    /** initialize your data structure here. */
    public FindMedianFromDataStream() {
        left = new PriorityQueue<>(1, Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (left.isEmpty() || num <= left.peek()) left.add(num);
        else right.add(num);

        if (left.size() - 1 > right.size()) right.add(left.remove());
        else if (right.size() > left.size()) left.add(right.remove());
    }

    public double findMedian() {
        if (left.size() == right.size()) return (left.peek() + right.peek()) / 2.0;
        return left.peek();
    }

    public static void main(String[] args) {
        FindMedianFromDataStream solution = new FindMedianFromDataStream();
        solution.addNum(1);
        solution.addNum(2);
        System.out.println(solution.findMedian());
        solution.addNum(3);
        System.out.println(solution.findMedian());
    }
}
