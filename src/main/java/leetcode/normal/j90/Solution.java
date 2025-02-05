package leetcode.normal.j90;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/subsets-ii/description/">90. 子集 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    List<Integer> numList;
    List<List<Integer>> ans;
    HashMap<Integer, Integer> preq;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        preq = new HashMap<>();
        numList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!preq.containsKey(nums[i])) {
                numList.add(nums[i]);
            }
            preq.compute(nums[i], (key, val) -> val == null ? 1 : (val + 1));
        }
        solve(0, new ArrayList<>());
        return ans;
    }

    void solve(int curPos, List<Integer> res) {
        if (curPos == numList.size()) {
            ans.add(new ArrayList<>(res));
            return;
        }
        int curNum = numList.get(curPos);
        int maxCnt = preq.get(curNum);
        solve(curPos + 1, res);
        for (int i = 0; i < maxCnt; i++) {
            res.add(curNum);
            solve(curPos + 1, res);
        }
        for (int i = 0; i < maxCnt; i++) res.remove(res.size() - 1);
    }
}