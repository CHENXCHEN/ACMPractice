package leetcode.normal.j1769;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/">1769. 移动所有球到每个盒子所需的最小操作数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int[] minOperations(String boxes) {
        int n = boxes.length(), left = boxes.charAt(0) - '0', right = 0, operation = 0;
        for (int i = 1; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                ++right;
                operation += i;
            }
        }
        int[] ans = new int[n];
        ans[0] = operation;
        for (int i = 1; i < n; i++) {
            ans[i] = operation += left - right;
            if (boxes.charAt(i) == '1') {
                ++left;
                --right;
            }
        }
        return ans;
    }
}