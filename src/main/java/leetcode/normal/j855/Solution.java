package leetcode.normal.j855;

import javafx.util.Pair;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/exam-room/description/">855. 考场就座</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class ExamRoom {
    TreeSet<Integer> seats = new TreeSet<>();
    PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((x, y) -> {
        int lenX = (x.getValue() - x.getKey()) >> 1, lenY = (y.getValue() - y.getKey()) >> 1;
        return lenX != lenY ? lenY - lenX : x.getKey() - y.getKey();
    });
    int n;

    public ExamRoom(int n) {
        this.n = n;
    }

    public int seat() {
        if (seats.isEmpty()) {
            seats.add(0);
            return 0;
        }
        int left = seats.first(), right = n - 1 - seats.last();
        while (seats.size() >= 2) {
            Pair<Integer, Integer> peek = pq.peek();
            if (seats.contains(peek.getKey()) && Objects.equals(seats.higher(peek.getKey()), peek.getValue())) {
                int len = peek.getValue() - peek.getKey();
                int d = len >> 1;
                // 如果左边或者右边距离更大，就跳出
                if (right > d || left >= d) break;
                pq.poll();
                int pos = peek.getKey() + d;
                pq.add(new Pair<>(peek.getKey(), pos));
                pq.add(new Pair<>(pos, peek.getValue()));
                seats.add(pos);
                return pos;
            }
            pq.poll();
        }
        if (right > left) {
            pq.add(new Pair<>(seats.last(), n - 1));
            seats.add(n - 1);
            return n - 1;
        } else {
            pq.add(new Pair<>(0, seats.first()));
            seats.add(0);
            return 0;
        }
    }

    public void leave(int p) {
        seats.remove(p);
        Integer higher = seats.higher(p);
        Integer lower = seats.lower(p);
        if (higher != null && lower != null) {
            pq.add(new Pair<>(lower, higher));
        }
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */