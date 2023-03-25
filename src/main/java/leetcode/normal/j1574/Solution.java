package leetcode.normal.j1574;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/shortest-subarray-to-be-removed-to-make-array-sorted/">1574. 删除最短的子数组使剩余数组有序</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        TreeMap<Integer, TreeSet<Integer>> tMap = new TreeMap<>();
        int n = arr.length;
        tMap.put(arr[n - 1], new TreeSet<Integer>() {{
            add(n - 1);
        }});
        int ans = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1]) {
                tMap.putIfAbsent(arr[i], new TreeSet<>());
                tMap.get(arr[i]).add(i);
            } else break;
        }
        for (int i = 0; i < n; i++) {
            Map.Entry<Integer, TreeSet<Integer>> entry = tMap.ceilingEntry(arr[i]);
            if (i == 0 || arr[i] >= arr[i - 1]) {
                if (entry != null) {
                    Integer higher = entry.getValue().higher(i);
                    if (higher != null) {
                        ans = Math.min(ans, higher - i - 1);
                    }
                }
                ans = Math.min(ans, n - i - 1);
            } else break;
        }
        if (!tMap.isEmpty()) {
            ans = Math.min(ans, tMap.firstEntry().getValue().first());
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findLengthOfShortestSubarray(new int[]{5, 4, 3, 2, 1});
    }
}