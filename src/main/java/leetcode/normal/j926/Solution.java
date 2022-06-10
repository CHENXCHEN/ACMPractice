package leetcode.normal.j926;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/flip-string-to-monotone-increasing/
 * 926. 将字符串翻转到单调递增
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minFlipsMonoIncr(String s) {
        int[] prefixCnt = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            prefixCnt[i + 1] = prefixCnt[i] + (s.charAt(i) - '0');
        }
        int lastSum = prefixCnt[s.length()];
        int ans = lastSum;
        for (int i = 0; i < s.length(); i++) {
            // 如果从第 i 开始单调递增
            // [0, i-1] 中 1 的个数，需要设置为 0
            int leftOneCnt = prefixCnt[i];
            // [i, n] 中 1 的个数，需要找到有多少个 0
            int rightOneCnt = lastSum - prefixCnt[i];
            // [i, n] 中 0 的个数，需要设为 1
            int rightZeroCnt = s.length() - i - rightOneCnt;
            int tmp = leftOneCnt + rightZeroCnt;
            ans = Math.min(ans, tmp);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minFlipsMonoIncr("00110"));
    }
}