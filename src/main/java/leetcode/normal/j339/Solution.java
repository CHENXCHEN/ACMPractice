package leetcode.normal.j339;

import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/nested-list-weight-sum/description/">339. 嵌套列表加权和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    int dfs(List<NestedInteger> nestedList, int step) {
        int ans = 0;
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                ans += nestedInteger.getInteger() * step;
            } else {
                ans += dfs(nestedInteger.getList(), step + 1);
            }
        }
        return ans;
    }
}