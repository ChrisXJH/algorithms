// https://leetcode.com/problems/design-hashset/

package design;

import java.util.LinkedList;
import java.util.List;

public class DesignHashSet {
    private static class Bucket {
        private final List<Integer> list;

        public Bucket() {
            list = new LinkedList<>();
        }

        public void add(int key) {
            if (contains(key)) return;
            list.add(key);
        }

        public void remove(int key) {
            int index = list.indexOf(key);
            if (index == -1) return;
            list.remove(index);
        }

        public boolean contains(int key) {
            return list.contains(key);
        }
    }

    private static final int SIZE = 769;

    private final Bucket[] buckets;

    /** Initialize your data structure here. */
    public DesignHashSet() {
        buckets = new Bucket[SIZE];

        for (int i = 0; i < SIZE; ++i)
            buckets[i] = new Bucket();
    }

    private int getHash(int key) {
        return key % SIZE;
    }

    public void add(int key) {
        buckets[getHash(key)].add(key);
    }

    public void remove(int key) {
        buckets[getHash(key)].remove(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return buckets[getHash(key)].contains(key);
    }

    public static void main(String[] args) {
        DesignHashSet hashSet = new DesignHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));    // returns true
        System.out.println(hashSet.contains(3));    // returns false (not found)
        hashSet.add(2);
        System.out.println(hashSet.contains(2));    // returns true
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));    // returns false (already removed)
    }
}
