package leetcode.normal.j1237;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-positive-integer-solution-for-a-given-equation/">1237. 找出给定方程的正整数解</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    CustomFunction fuc;

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        fuc = customfunction;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= z; i++) {
            int y = binarySearch(i, z);
            if (y > 0) {
                ans.add(Arrays.asList(i, y));
            }
        }
        return ans;
    }

    int binarySearch(int x, int target) {
        int left = 1, right = target;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int tmp = fuc.f(x, mid);
            if (tmp == target) return mid;
            else if (tmp > target) right = mid - 1;
            else left = mid + 1;
        }
        return 0;
    }
}