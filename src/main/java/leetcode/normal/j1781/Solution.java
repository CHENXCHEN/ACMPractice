package leetcode.normal.j1781;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/sum-of-beauty-of-all-substrings/">1781. 所有子字符串美丽值之和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[][] preSum;

    public int beautySum(String s) {
        preSum = new int[26][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) preSum[j][i + 1] = preSum[j][i];
            preSum[s.charAt(i) - 'a'][i + 1]++;
        }
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                ans += calc(i, j);
            }
        }
        return ans;
    }

    int calc(int from, int end) {
        int max = 0, min = end - from + 1;
        for (int i = 0; i < 26; i++) {
            int cnt = preSum[i][end + 1] - preSum[i][from];
            if (cnt > 0) {
                max = Math.max(cnt, max);
                min = Math.min(cnt, min);
            }
        }
        return max - min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.beautySum("aabcb");
    }
}