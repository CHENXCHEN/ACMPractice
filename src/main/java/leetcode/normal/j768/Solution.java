package leetcode.normal.j768;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/max-chunks-to-make-sorted-ii/">768. 最多能完成排序的块 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int ans = 0;
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        int[] sort = new int[arr.length];
        System.arraycopy(arr, 0, sort, 0, arr.length);
        Arrays.sort(sort);
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i], y = sort[i];
            int nextX = tMap.getOrDefault(x, 0) + 1;
            if (nextX == 0) tMap.remove(x);
            else tMap.put(x, nextX);
            int nextY = tMap.getOrDefault(y, 0) - 1;
            if (nextY == 0) tMap.remove(y);
            else tMap.put(y, nextY);
            if (tMap.isEmpty()) ans++;
        }
        return ans;
    }
}