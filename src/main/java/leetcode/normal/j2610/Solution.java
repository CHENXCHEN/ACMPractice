package leetcode.normal.j2610;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/convert-an-array-into-a-2d-array-with-conditions/description/">2610. 转换二维数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] cnt = new int[nums.length + 1];
        for (int num : nums) {
            cnt[num]++;
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (!check(cnt)) {
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < cnt.length; i++) {
                if (cnt[i] > 0) {
                    --cnt[i];
                    row.add(i);
                }
            }
            ans.add(row);
        }
        return ans;
    }

    boolean check(int[] cnt) {
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] != 0) return false;
        }
        return true;
    }

}