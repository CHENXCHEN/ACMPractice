package leetcode.normal.j1769;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/">1769. 移动所有球到每个盒子所需的最小操作数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] cntSum = new int[n + 1], moveSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            cntSum[i + 1] = cntSum[i] + (boxes.charAt(i) - '0');
            moveSum[i + 1] = moveSum[i] + (boxes.charAt(i) == '0' ? 0 : i);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ans[0] = moveSum[n] - moveSum[1];
            } else {
                int leftCnt = cntSum[i];
                int rightCnt = cntSum[n] - cntSum[i + 1];
                int leftMove = leftCnt != 0 ? leftCnt * i - moveSum[i] : 0;
                int rightMove = rightCnt != 0 ? moveSum[n] - moveSum[i + 1] - i * rightCnt : 0;
                ans[i] = leftMove + rightMove;
            }
        }
        return ans;
    }
}