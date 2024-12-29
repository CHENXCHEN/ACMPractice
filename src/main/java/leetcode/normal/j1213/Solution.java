package leetcode.normal.j1213;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/intersection-of-three-sorted-arrays/description/">1213. 三个有序数组的交集</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<Integer> arraysIntersection(int[] arr0, int[] arr1, int[] arr2) {
        int[] cursor = new int[3];
        ArrayList<Integer> ans = new ArrayList<>();
        while (cursor[0] < arr0.length && cursor[1] < arr1.length && cursor[2] < arr2.length) {
            int x = arr0[cursor[0]], y = arr1[cursor[1]], z = arr2[cursor[2]];
            if (x == y && y == z) {
                ans.add(arr0[cursor[0]]);
                cursor[0]++;
                cursor[1]++;
                cursor[2]++;
            } else {
                int min = Math.min(x, Math.min(y, z));
                if (x == min) ++cursor[0];
                if (y == min) ++cursor[1];
                if (z == min) ++cursor[2];
            }
//            System.out.println("cursor: " + Arrays.toString(cursor));
        }
        return ans;
    }
}