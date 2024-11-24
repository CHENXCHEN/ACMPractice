package leetcode.normal.j632;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/smallest-range-covering-elements-from-k-lists/description/">632. 最小区间</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        // 枚举每一个左端点，二分求其右端点，求最小区间，时间复杂度会超，复杂度为 O(n * k * log(n))，n为所有数字长度
        // 将数组平铺，总共有最多 n=175000 个数字，转换为 O(n * log(n))
        int[] ans = new int[2];
        int lastLen = Integer.MAX_VALUE;
        ArrayList<int[]> arr = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (Integer num : nums.get(i)) {
                arr.add(new int[]{i, num});
            }
        }
        arr.sort((x, y) -> x[1] - y[1]);
        TreeMap<Integer, Integer> cnt = new TreeMap<>();
        int k = nums.size();
        for (int i = 0, right = 0; i < arr.size(); i++) {
            int[] item = arr.get(i);
            while (right < arr.size() && cnt.size() != k) {
                int[] sub = arr.get(right);
                cnt.compute(sub[0], (kk, vv) -> vv == null ? 1 : (vv + 1));
                right++;
            }
            if (cnt.size() == k) {
                int ll = item[1], rr = arr.get(right - 1)[1];
                int len = rr - ll + 1;
                if (len < lastLen) {
                    ans[0] = ll;
                    ans[1] = rr;
                    lastLen = len;
                }
            }
            cnt.compute(item[0], (kk, vv) -> vv == 1 ? null : (vv - 1));
        }
        return ans;
    }
}