package leetcode.normal.j1825;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class MKAverage {

    // s1 -> 最小的 k 个元素
    // s3 -> 最大的 k 个元素
    TreeMap<Integer, Integer> s1, s2, s3;
    ArrayDeque<Integer> deque;
    int sum2, m, k, cnt;

    public MKAverage(int m, int k) {
        s1 = new TreeMap<>();
        s2 = new TreeMap<>();
        s3 = new TreeMap<>();
        deque = new ArrayDeque<>();
        sum2 = 0;
        cnt = m - (k << 1);
        this.m = m;
        this.k = k;
    }

    public void addElement(int num) {
        deque.add(num);
        if (deque.size() < m) return;
        if (deque.size() == m) {
            Integer[] arr = new Integer[m];
            deque.toArray(arr);
            Arrays.sort(arr);
            for (int i = 0; i < k; i++) addSet(s1, arr[i]);
            for (int i = k; i < m - k; i++) {
                sum2 += arr[i];
                addSet(s2, arr[i]);
            }
            for (int i = m - k; i < m; i++) addSet(s3, arr[i]);
        } else {
            // 维护 s1, s2, s3 的集合后的结果，不管什么情况最后都是 s2 会多出一个元素
            Integer s1LastKey = s1.lastKey(), s3FirstKey = s3.firstKey();
            if (num <= s1LastKey) {
                addSet(s1, num);
                removeSet(s1, s1LastKey);
                addSet(s2, s1LastKey);
                sum2 += s1LastKey;
            } else if (num >= s3FirstKey) {
                addSet(s3, num);
                removeSet(s3, s3FirstKey);
                addSet(s2, s3FirstKey);
                sum2 += s3FirstKey;
            } else {
                addSet(s2, num);
                sum2 += num;
            }
            Integer needRemove = deque.removeFirst();
            s1LastKey = s1.lastKey();
            s3FirstKey = s3.firstKey();
            if (needRemove <= s1LastKey) {
                Integer s2First = s2.firstKey();
                removeSet(s1, needRemove);
                addSet(s1, s2First);
                removeSet(s2, s2First);
                sum2 -= s2First;
            } else if (needRemove >= s3FirstKey) {
                Integer s2Last = s2.lastKey();
                removeSet(s3, needRemove);
                addSet(s3, s2Last);
                removeSet(s2, s2Last);
                sum2 -= s2Last;
            } else {
                removeSet(s2, needRemove);
                sum2 -= needRemove;
            }
        }
    }

    void addSet(TreeMap<Integer, Integer> ss, Integer num) {
        ss.put(num, ss.getOrDefault(num, 0) + 1);
    }

    void removeSet(TreeMap<Integer, Integer> ss, Integer num) {
        int left = ss.get(num) - 1;
        if (left <= 0) ss.remove(num);
        else ss.put(num, left);
    }

    public int calculateMKAverage() {
        if (deque.size() < m) return -1;
        return sum2 / cnt;
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */