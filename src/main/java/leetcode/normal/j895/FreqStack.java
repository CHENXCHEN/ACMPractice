package leetcode.normal.j895;

import java.util.ArrayDeque;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-frequency-stack/">895. 最大频率栈</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class FreqStack {

    int maxLevel = 0;
    TreeMap<Integer, ArrayDeque<Integer>> tMap;
    TreeMap<Integer, Integer> record;

    public FreqStack() {
        tMap = new TreeMap<>();
        record = new TreeMap<>();
    }

    public void push(int val) {
        int level = record.getOrDefault(val, 0) + 1;
        record.put(val, level);
        if (!tMap.containsKey(level)) {
            tMap.put(level, new ArrayDeque<>());
        }
        tMap.get(level).push(val);
        maxLevel = Math.max(maxLevel, level);
    }

    public int pop() {
        ArrayDeque<Integer> deque = tMap.get(maxLevel);
        int vv = deque.pop();
        record.put(vv, record.get(vv) - 1);
        if (deque.isEmpty()) --maxLevel;
        return vv;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */