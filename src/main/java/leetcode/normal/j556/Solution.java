package leetcode.normal.j556;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/next-greater-element-iii/">556. 下一个更大元素 III</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int nextGreaterElement(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        int tmp = n;
        while (tmp > 0) {
            arr.add(tmp % 10);
            tmp /= 10;
        }
        int leftMax = arr.get(0);
        int leftMaxPos = 0;
        int bound = 0;
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        for (int i = 0; i < arr.size(); i++) {
            Integer now = arr.get(i);
            Map.Entry<Integer, Integer> higherEntry = tMap.higherEntry(now);
            if (higherEntry != null) {
                arr.set(i, higherEntry.getKey());
                arr.set(higherEntry.getValue(), now);
                bound = i;
                break;
            }
            tMap.putIfAbsent(now, i);
        }
        if (bound > 0) {
            List<Integer> subArr = arr.subList(0, bound);
            subArr.sort(Comparator.comparingInt(x -> -x));
            for (int i = 0; i < subArr.size(); i++) arr.set(i, subArr.get(i));
        }
        int ans = 0;
        for (int i = arr.size() - 1; i >= 0; i--) {
            ans = (ans << 1) + (ans << 3) + arr.get(i);
        }
        if (ans <= n) return -1;
        return ans;
    }
}