package leetcode.normal.j1200;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-absolute-difference/">1200. 最小绝对差</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int size = 0;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff > min) continue;
            if (diff < min) {
                size = 0;
                min = diff;
            }
            ArrayList<Integer> now = new ArrayList<>();
            now.add(arr[i - 1]);
            now.add(arr[i]);
            if (size == ans.size()) ans.add(now);
            else ans.set(size, now);
            size++;
        }
        return ans.subList(0, size);
    }
}