package leetcode.normal.j254;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/factor-combinations/description/">254. 因子的组合</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {


    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(2, new ArrayList<>(), ans, n);
        return ans;
    }

    void solve(int start, List<Integer> cur, List<List<Integer>> ans, int target) {
        if (target == 1) {
            // 若结果已经是 1，那么说明找到答案了
            if (cur.size() > 1)
                ans.add(new ArrayList<>(cur));
        } else {
            // 否则，要么当前 target 为结果，要么 target 再继续分解
            int sqrt = (int) Math.sqrt(target);
            for (int i = start; i <= sqrt; i++) {
                if (target % i == 0) {
                    cur.add(i);
                    solve(i, cur, ans, target / i);
                    cur.remove(cur.size() - 1);
                }
            }
            cur.add(target);
            solve(target, cur, ans, 1);
            cur.remove(cur.size() - 1);
        }
    }
}